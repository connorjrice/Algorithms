package graph;

import java.util.Arrays;

/**
 *
 * @author Connor
 */
public class Prims {
    
    
    
    /** Chapter 4, n.2
     * Prim's algorithm for minimum spanning tree.
     * startEdge, endEdge, weight
     * @param g
     * @param W//
     * @return int[][] where int[i][0] = startNode // node
     *                       int[i][1] = endNode // vertex
     *                       int[i][2] = weight
     */
    public static int[][] getMST(SimpleWeightedGraph g) {
        // TODO: Check if W is a matrix
        int n = g.getSize();
        int[][] F = new int[n-1][3]; // list of edges to be returned.
        // Y is the set of nodes, which I guess is contained in F.
        int numEdges = 0;
                
        // Edge is startEdge, endEdge, weight (a[0], a[1], a[2])
        int vnear = 0; // index of nearest node
        double min; // value of smallest edge weight
        int[] nearest = new int[n]; // index
        double[] distance = new double[n]; // value
        
        // Grab the edge values for v1, our starting vertex.
        for (int i = 1; i < n; i++) {
            nearest[i] = 0; // Initialize v1 to be nearest vertex to all
            distance[i] = g.getEdges()[0][i];
        }
        for (int i = 0; i < n-1; i++) { // repeat n-1 times
            min = Double.POSITIVE_INFINITY; // value
            
            // Check each edge weight, look for minimum
            for (int j = 1; j < n; j++) {
                // If we have a nonzero distance and the distance at the current
                // index is less than our minimum, set minimum to be distance[j]
               // if (0 <= distance[j] && distance[j] < min) {
               if (0 < distance[j] && distance[j] < min) {               
                    min = distance[j];
                    vnear = j;
                }                
            }
            // Add this edge to F
            System.out.println("Add edge: node1: " + vnear + " node2: " + nearest[vnear] + " weight: " + g.getEdges()[vnear][nearest[vnear]]);
            F[numEdges] = new int[]{vnear,nearest[vnear],
                (int) g.getEdges()[vnear][nearest[vnear]]}; 
            numEdges++;
            distance[vnear] = -1;
            
            // Add vertex indexed by vnear to Y.
            // For each vertex not in Y, update it's distance from Y.
            for (int j = 1; j < n; j++) {
                if (g.getEdges()[j][vnear] < distance[j]) {
                    distance[j] = g.getEdges()[j][vnear];
                    nearest[j] = vnear;
                }
            }            
        }
        return F;
    }    
    
    /***
     * Takes in a minimum spanning tree and determines if it is connected.
     * @param edges
     * @param n number of nodes
     * @return 
     */
    public static boolean isConnected (int[][] F) {
        System.out.println("F: " + Arrays.deepToString(F));
        boolean[] seen = new boolean[F.length+1];
        for (int[] edge : F) {
            if (!seen[edge[0]] && edge[2] > 0) {
                seen[edge[0]] = true;
            }
            if (!seen[edge[1]] && edge[2] > 0) {
                seen[edge[1]] = true;
            }
        }
        System.out.println("seen: " + Arrays.toString(seen));
        boolean seenAll = true;
        for (boolean b : seen) {
            if (!b) {
                seenAll = false;
            }
        }
        return seenAll;

    }
    
}
