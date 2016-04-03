package graph;

import datastructures.Queue;
import java.util.ArrayList;

/**
 *
 * @author Connor
 */
public class Grapher {
     
    /**
     * Takes in a set of edges that represents a minimum spanning tree and 
     * returns a graph.
     * @param edges
     * @return 
     */
    public static int[][] createGraphFromMST(int[][] edges) {
        // Determine number of nodes in MST
        ArrayList nodes = new ArrayList();
        for (int[] edge : edges) {
            if (!nodes.contains(edge[0])) {
                nodes.add(edge[0]);
            }
            if (!nodes.contains(edge[1])) {
                nodes.add(edge[1]);
            }
        }
        
        int[][] graph = new int[nodes.size()][nodes.size()];
        for (int[] edge : edges) {
            graph[edge[0]][edge[1]] = edge[2];
        }
        return graph;
        
    }
    
    /** For comparison
     * Return the total weight of a minimum spanning tree.
     * @param edges
     * @return 
     */    
    public static int getMSTWeight(int[][] edges) {
        int weight = 0;
        for (int[] e : edges) {
            weight += e[2];
        }
                
        return weight;
    }
    
    /** Chapter 4, n.6
     * Checks to see whether or not a graph described by edges is connected.
     * @param edges
     * @param n number of nodes
     * @return 
     */
    public static boolean isConnected(int[][] edges, int n) {
        Queue q = new Queue();
        int[] nodes = new int[n];
        ArrayList components = new ArrayList();
        for (int i = 0; i < n; i++) {
            nodes[i] = n;
        }
        boolean[] visited = new boolean[n]; 
        for (int[] edge : edges) {
            if (!visited[edge[0]]) { // If edge[0] is unvisited
                int[] curComponent = getNodeSet(n);
                //q.push();
            }
        }
        return false;
    }

    private static int[] getNodeSet(int n) {
        int[] nodeSet = new int[n];
        for (int i = 0; i < n; i++) {
            nodeSet[i] = -1;
        }
        return nodeSet;
    }         
                

}
