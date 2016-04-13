package unimplemented;

import graph.structures.SimpleDirectedGraph;
import graph.structures.TSPNode;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.stream.DoubleStream;
import java.util.Arrays;

/**
 * Best-First Search with Branch-and-bound pruning algorithm for TSP
 * @author Connor
 */
public class BestFSTSP {
    
    
   // public int[][] travel(SimpleDirectedGraph g, int n) {
    
    // Think about doing a list of edges rather than a double[][]
    public ArrayList<Integer> travel(SimpleDirectedGraph g, int n) {    
       // int[][] path = new int[g.getEdges().length][3];
       ArrayList<Integer> optimalTour = new ArrayList<>();
       PriorityQueue<TSPNode> pq = new PriorityQueue(); 
       TSPNode u, v, k;
       ArrayList<Integer> path = new ArrayList<>();
       path.add(0);
       v = new TSPNode(-1,path,0);
       v.bound = bound(v,g,n);
       double minlength = Double.POSITIVE_INFINITY;
       pq.add(v);
       while (!pq.isEmpty()) {
           k = pq.remove();
           u = new TSPNode(0,null,0);
           if (v.level < minlength) {
               u.level = v.level + 1;
               for (int i = 1; i < n; i++) { 
                   if (!contains(v.path, i)) { // i not in v.path
                       u.path = v.path;
                       u.path.add(i); // put i at end of path
                       if (u.level == n-1) { // may be n-2
                           // put index of only vertex not in v.path at end
                           u.path.add(getLast(u.path, n));
                           u.path.add(0); // 1st vertice
                           if (length(u.path, g) < minlength) {
                               minlength = length(u.path, g);
                               optimalTour = u.path;
                           }
                       } else { // we are not at the last node
                           u.bound = bound(u,g,n);
                           if (u.bound < minlength) {
                               pq.add(u);
                           }
                       }
                   }
               }
           }
       }
       // return path;
       return optimalTour;
    }
    
    
    private double length(ArrayList<Integer> path, SimpleDirectedGraph g) {
        double result = 0;
        for (int i = 0; i < path.size()-1; i++) {
            result += g.getEdges()[i][i+1];
        }
        return result;
    }
    
    /**
     * Return the last node that is not in the path.
     * @param path
     * @param n
     * @return 
     */
    private int getLast(ArrayList<Integer> path, int n) {
        for (int i = 0; i < n; i++) {
            if (!path.contains(i)) {
                return i;
            }
        }
        return -1;
    }
    
    /**
     * Get a LinkedHashSet<Integer> from int[] nodes
     * @param nodes
     * @return 
     */
    private ArrayList<Integer> getSet(int[] nodes) {
        ArrayList<Integer> set = new ArrayList<>();
        for (int i : nodes) {
            set.add(i);
        }
        return set;
    }
   
   
    private boolean contains(ArrayList<Integer> path, int value) {
        return path.contains(value);
    }

    /**
     * @param g
     * @param n
     * @param path boolean[], false = vertex not visited
     * @return 
     */
    private double bound(TSPNode v, SimpleDirectedGraph g, int n) {
        return DoubleStream.of(getMinimums(v,g,n)).sum();
    }
    
    /** try dynamic
     * @param g
     * @param n 
     */
    private double[] getMinimums(TSPNode v, SimpleDirectedGraph g, int n) {
        double[] minimums = new double[n];
        Arrays.fill(minimums, Double.POSITIVE_INFINITY);
       // createVisited(v,n); // see if we can do better
        for (int i = 0; i < n; i++) {
            if (!path(v,i)) {
                for (int j = 0; j < n; j++) {
                        if (g.getEdges()[i][j] < minimums[i] && g.getEdges()[i][j] > 0) {
                            minimums[i] = g.getEdges()[i][j];
                        }                                    
                    
                }
            } else {
                minimums[i] = getEdgeLength(g, v.path.get(i), v.path.get(i+1));
            }
        }
        return minimums;
    }
    
    
    private double getEdgeLength(SimpleDirectedGraph g, int i, int j) {
        return g.getEdges()[i][j];
    }
    
    private boolean path(TSPNode v, int i) {
        if (v.path.contains(i)) {
            if ((v.path.indexOf(i))+1 < v.path.size()) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
    
    /*private boolean getVisited(TSPNode v, int i, int n) {
        if (visited == null) {
            createVisited(v,n);
        }
        return v.
    }*/

}
