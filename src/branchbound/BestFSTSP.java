package branchbound;

import graph.structures.SimpleDirectedGraph;
import graph.structures.TSPNode;
import java.util.LinkedHashSet;
import java.util.PriorityQueue;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

/**
 * Best-First Search with Branch-and-bound pruning algorithm for TSP
 * @author Connor
 */
public class BestFSTSP {
    
    private boolean[] visited;
    
    public int[][] travel(SimpleDirectedGraph g, int n) {
        int[][] path = new int[g.getEdges().length][3];
        PriorityQueue<TSPNode> pq = new PriorityQueue(); // TODO: Write my own PQ ds        
        TSPNode u, v, k;
        v = new TSPNode(-1,getSet(new int[]{0}),0);
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
                         }
                     }
                 }
             }
        }
        return path;
    }
    
    private int getLast(LinkedHashSet<Integer> path, int n) {
        for (int i = 0; i < n; i++) {
            if (!path.contains(i)) {
                return i;
            }
        }
        return -1;
    }
    
    private LinkedHashSet<Integer> getSet(int[] nodes) {
        LinkedHashSet<Integer> set = new LinkedHashSet<>();
        for (int i : nodes) {
            set.add(i);
        }
        return set;
    }
    
    private boolean contains(LinkedHashSet<Integer> path, int value) {
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
        for (int i = 0; i < n; i++) {
            if (!path(v,i,n)) {
                for (int j = 0; j < n; j++) {
                    if (!path(v,j,n)) {
                        if (g.getEdges()[i][j] > minimums[i]) {
                            minimums[i] = g.getEdges()[i][j];
                        }                                    
                    }
                }
            }
        }
        visited = null;
        return minimums;
    }
    
    private boolean path(TSPNode v, int i, int n) {
        if (visited == null) {
            createVisited(v,n);
        } 
        return visited[i];
    }
    
    /*private boolean getVisited(TSPNode v, int i, int n) {
        if (visited == null) {
            createVisited(v,n);
        }
        return v.
    }*/
    
    private void createVisited(TSPNode v, int n) {
        visited = new boolean[n];
        // Assign true values to nodes on path contained in v
        v.path.stream().forEach((i) -> {
            visited[i] = true;
        });
    }

}
