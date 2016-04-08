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
    
    private ArrayList<KnapNode> items;
    private ArrayList<KnapNode> bestItems;

    public BFS01prune() {
        this.items = new ArrayList<>();
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
        v = new KnapNode(0,0,0);
        q.push(v);
        
        while (!q.isEmpty()) {
            KnapNode k = q.pop();
            // U is the child of k, includes next item
            u = new KnapNode(k.level+1, k.weight+w[k.level+1],
                    k.profit + p[k.level+1]);
            if (u.weight <= trunk && u.profit > maxProfit) {
                maxProfit = u.profit;
            }
            if (bound(n,p,w,trunk,u) > maxProfit) {
                q.push(u);
            }
            // Set u to the child that does not include the next item
            u.weight = k.weight;
            u.profit = k.profit;
            if (bound(n,p,w,trunk,u) > maxProfit) {
                q.push(u);
            }
        }
        
        return maxProfit;
    }
    
    
    public KnapNode[] getOptimalSet(int n, int[] p, int[] w,  int trunk) {
        int maxProfit = 0;
        KnapNode u;
        KnapNode v; // Nodes
        Queue<KnapNode> q = new Queue();
        v = new KnapNode(0,0,0);
        q.push(v);
        
        while (!q.isEmpty()) {
            KnapNode k = q.pop();
            // U is the child of k, includes next item
            u = new KnapNode(k.level+1, k.weight+w[k.level+1],
                    k.profit + p[k.level+1]);
            if (u.weight <= trunk && u.profit > maxProfit) {
                maxProfit = u.profit;
                bestItems = u.items;
            }
            if (bound(n,p,w,trunk,u) > maxProfit) {
                q.push(u);
                u.setItems(items);                
                if (!items.contains(u)) {
                    items.add(u);                    
                }
            }
            // Set u to the child that does not include the next item
            u.weight = k.weight;
            u.profit = k.profit;
            if (bound(n,p,w,trunk,u) > maxProfit) {
                q.push(u);
                u.setItems(items);                
                if (!items.contains(u)) {
                    items.add(u);                    
                }
            }
        }        
        return (KnapNode[]) bestItems.toArray();
    }
    
    
    private double bound(int n, int[] p, int[] w, int trunk, KnapNode u) {
        double result;
        int j,k;
        int totweight;
        
        if (u.weight >= trunk) {
            return 0;
        } else {
            result = u.profit;
            j = u.level + 1;
            totweight = u.weight;
            while (j <= n && totweight + w[j] <= trunk) {
                totweight = totweight + w[j]; // Smash'n'grab jewlery cases
                result += result + p[j]; 
                j++;
            }
            k = j;
            if (k <= n) {
                // The algorithm in the book says to do this even though it's 
                // supposed to be the 0-1 knapsack problem?
                result += result + (trunk - totweight) * (p[k]/w[k]);
            }
            return result;            
        }
    }
}
