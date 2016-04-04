package hw;

import graph.SimpleDirectedGraph;

/**
 *
 * @author Connor
 */
public class Dijkstras {
    
    /**
     * Standard implementation
     * @param g
     * @return 
     */
    public static int[][] getShortestPath(SimpleDirectedGraph g) {
        // if g is a matrix! {
        int n = g.getSize();
        int[][] shortestPath = new int[n-1][3];
        int shortSize = 0;
        
        int[] touch = new int[n+1];
        double[] length = new double[n+1];
        
        int vnear = 0;
        double min;
        
        // For all vertices, initialize v1 to be the last vertex on the current
        // shortest path from v1, and initialize length of that path to be the
        // weight on the edge from v1.
        for (int i = 1; i < n; i++) {
            touch[i] = 0;
            length[i] = g.getEdges()[0][i];
        }
        //System.out.println(Arrays.deepToString(g.getEdges()));        

        while (shortSize < n-1) { // Add all n-1 vertices to Y
            min = Double.POSITIVE_INFINITY;
            for (int i = 1; i < n; i++) { // Find smallest vertex
                if (0 <= length[i] && length[i] < min) {
                    min = length[i];
                    vnear = i;
                }
            }
            // Add edge from touch[vnear] to vnear to path
            shortestPath[shortSize] = new int[]{touch[shortSize],vnear-1,(int)g.getEdges()[touch[vnear]][vnear]};
            shortSize++;
            
            for (int i = 1; i < n; i++) {
                //System.out.println(i);
                if (length[vnear] + g.getEdges()[vnear][i] < length[i]) {
                    // For each vertex not in path, update shortest path
                    length[i] = length[vnear] + g.getEdges()[vnear][i];
                    touch[i] = vnear;                                    
                }
                
            }
            length[vnear] = -1;
        }
        return shortestPath;
    }
    
    
 
    /**
     * Arbitrary starting node
     * @param g
     * @return 
     */
    public static int[][] getShortestPathFromEnd(SimpleDirectedGraph g) {
        int n = g.getSize();
        int[][] shortestPath = new int[n-1][3];
        int shortSize = 0;
        
        int[] touch = new int[n];
        double[] length = new double[n];
        
        int vnear = -1;
        double min;
        
        int[] range = new int[]{4,3,2,1,0};
        
        
        // For all vertices, initialize v1 to be the last vertex on the current
        // shortest path from v1, and initialize length of that path to be the
        // weight on the edge from v1.
        for (int i : range) {
            touch[i] = 4;
            length[i] = g.getEdges()[4][i];
        }
//        System.out.println(Arrays.deepToString(g.getEdges()));   
        
        while (shortSize < n-1) { // Add all n-1 vertices to Y
            min = Double.POSITIVE_INFINITY;
            for (int i : range) {
                if (0 <= length[i] && length[i] < min) {
                    min = length[i];
                    vnear = i;
                }
            }
            System.out.println("Step " + (shortSize+1) + " Add edge: node1: " + vnear + " node2: " + touch[vnear] + " weight: " + g.getEdges()[vnear][touch[vnear]]);            
            // Add edge from touch[vnear] to vnear to path
            shortestPath[shortSize] = new int[]{touch[vnear],vnear,(int)g.getEdges()[touch[vnear]][vnear]};
            shortSize++;

            for (int i : range) {
                if (length[vnear] + g.getEdges()[vnear][i] < length[i]) {
                    // For each vertex not in path, update shortest path
                    length[i] = length[vnear] + g.getEdges()[vnear][i];
                    touch[i] = vnear;
                }
            }
            length[vnear] = -1;
        }
        return shortestPath;
    }
        
    
  
    
    
    /**
     * Arbitrary starting node
     * @param g
     * @return 
     */
    public static int[][] getShortestPath(SimpleDirectedGraph g, int start) {
        int n = g.getSize();
        int[][] shortestPath = new int[n-1][3];
        int shortSize = 0;
        
        int[] touch = new int[n];
        double[] length = new double[n];
        
        int vnear = 0;
        double min;
        
        int[] range = new int[n];
        if (start == 0) {
            for (int i = 0; i < n; i++) {
                range[i] = i+1;
            }
        }
        if (start == n-1) {
            System.out.println("here");
            for (int i = n-2; i >= 0; i--) {
                System.out.println(i);
                range[n-1-i] = i;
            }
        }
        
        for (int i = 0; i < n; i++) {
            // if i is not equal to start
            if (i != start) {
                range[i] = i;
            }
        }
        
        
        
        // For all vertices, initialize v1 to be the last vertex on the current
        // shortest path from v1, and initialize length of that path to be the
        // weight on the edge from v1.
        for (int i = 1; i < n; i++) {
            touch[i] = start;
            length[i] = g.getEdges()[start][i];
        }
        //System.out.println(Arrays.deepToString(g.getEdges()));   
        
        while (shortSize < n-1) { // Add all n-1 vertices to Y
            min = Double.POSITIVE_INFINITY;
            for (int i : range) {
                if (0 <= length[i] && length[i] < min) {
                    min = length[i];
                    vnear = i;
                }
            }
            // Add edge from touch[vnear] to vnear to path
            shortestPath[shortSize] = new int[]{touch[vnear],vnear,(int)g.getEdges()[touch[vnear]][vnear]};
            shortSize++;
            
            for (int i : range) {
                if (length[vnear] + g.getEdges()[vnear][i] < length[i]) {
                    // For each vertex not in path, update shortest path
                    length[i] = length[vnear] + g.getEdges()[vnear][i];
                    touch[i] = vnear;
                }
            }
            length[vnear] = -1;
        }
        return shortestPath;
    }
        
    
    
}
