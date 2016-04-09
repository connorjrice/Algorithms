package branchbound;

import datastructures.Queue;
import graph.structures.KnapNode;
import java.util.ArrayList;

/**
 * Breadth-First Search with Branch-and-bound pruning algorithm.
 * For 0-1 knapsack problem.
 * @author Connor
 * 248
 */
public class BFS01prune {
    
    private ArrayList<Integer> bestItems;

    public BFS01prune() {
        this.bestItems = new ArrayList<>();
    }
    
    /**
     * Knapsack 0-1
     * @param n number of items
     * @param p profit
     * @param w weight
     * @param trunk how much trunk space is available in the getaway
     * @return sum of profits in optimal set
     */
    public int getMaxProfit(int n, int[] p, int[] w,  int trunk) {
        int maxProfit = 0;
        KnapNode u;
        KnapNode v; // Nodes
        Queue<KnapNode> q = new Queue();
        v = new KnapNode(-1,0,0);
        q.push(v);
        
        while (!q.isEmpty()) {
            KnapNode k = q.pop();
            // U is the child of k, includes next item
            u = new KnapNode(k.level+1, k.weight+w[k.level+1],
                    k.profit + p[k.level+1]);
            if (u.weight <= trunk && u.profit > maxProfit) {
                maxProfit = u.profit;
            }
            if (bound(n,p,w,trunk,u,false) > maxProfit) {
                q.push(u.clone());
            }
            // Set u to the child that does not include the next item
            
            u.weight = k.weight;
            u.profit = k.profit;
            if (bound(n,p,w,trunk,u,false) > maxProfit) {
                q.push(u.clone());
            }
        }
        
        return maxProfit;
    }
    
    
    /**
     *  I hate that I have to use ArrayLists.
     *  I wish I were in python land.
     * @param n
     * @param p
     * @param w
     * @param trunk
     * @return 
     */
    public ArrayList<Integer> getOptimalSet(int n, int[] p, int[] w,  int trunk) {
        bestItems = new ArrayList();
        
        int maxProfit = 0;
        KnapNode u;
        KnapNode v, k; // Nodes
        Queue<KnapNode> q = new Queue();
        ArrayList<Integer> items = new ArrayList();
        v = new KnapNode(-1,0,0, items);
        q.push(v);
        
        while (!q.isEmpty()) {
            k = q.pop();
            // U is the child of k, includes next item
            ArrayList<Integer> newList = (ArrayList<Integer>) k.items.clone();
            newList.add(k.level+1);
            u = new KnapNode(k.level+1, k.weight+w[k.level+1],
                    k.profit + p[k.level+1], newList);
            if (u.weight <= trunk && u.profit > maxProfit) {
                maxProfit = u.profit;
                bestItems = (ArrayList<Integer>) u.items.clone();
            }
            if (bound(n,p,w,trunk,u,true) > maxProfit) {
                q.push(u.clone());               
            }
            // Set u to the child that does not include the next item
            KnapNode x = new KnapNode(k.level+1, k.weight, k.profit, (ArrayList<Integer>) k.items.clone());
            if (bound(n,p,w,trunk,u,true) > maxProfit) {
                q.push(x);          
            }
        }
        return bestItems;
    }
    
    /**
     * @return profit + sum(j=i+1->k-1, pj) (trunk - totweight) * p[j]/w[j]
     */
    private double bound(int n, int[] p, int[] w, int trunk, KnapNode u, boolean items) {
        double result;
        int j;
        int totweight;
        
        if (u.weight >= trunk) {
            return 0;
        } else {
            result = u.profit;
            j = u.level + 1;
            totweight = u.weight;
            while (j < n && totweight + w[j] <= trunk) {
                totweight += w[j]; // Smash'n'grab jewlery cases
                result += p[j]; 
                j++;
            }
            if (j < n) {
                // Grab a fraction for the bound
                result += result + (trunk - totweight) * (p[j]/w[j]);
            }
            return result;            
        }
    }
}
