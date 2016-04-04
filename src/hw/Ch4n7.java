package hw;

import java.util.Arrays;
import sorting.InsertionSort;

/**
 *
 * @author Connor
 */
public class Ch4n7 {
        /** Chapter 4, n.7
     * 
     * @param edges : set of edges
     * @return 
     */
    public static int[][] getMSTKruskals(int[][] edges, int n) {
        int[][] mst = new int[n-1][n-1];
        int[] edge = new int[3];
        Integer[] weights = new Integer[edges.length];
        for (int i = 0; i < edges.length; i++) {
            weights[i] = edges[i][2];
        }
        
        // Sort the edges by nondecreasing weight
        new InsertionSort().sortIndices(weights);
        System.out.println(Arrays.deepToString(weights));
        int[][] sortedEdges = edges.clone();
        
        
        return null;
    }
    
}
