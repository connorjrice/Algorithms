package hw;

import graph.SimpleSparseGraph;
import java.util.ArrayList;
import java.util.Arrays;
import sorting.InsertionSort;

/**
 *
 * @author Connor
 */
public class Kruskals {
    
    /** Chapter 4, n.7
     * 
     * @return 
     */
    public static int[][] getMST(SimpleSparseGraph g, int n) {
        int[][] F = new int[n-1][3];
        int fSize = 0;
        double[] edge;
        // Sort the edges by nondecreasing weight
        double[][] sortedEdges = g.getEdges().clone();
        new InsertionSort().sort(sortedEdges);
        
        // Initialize disjoint subsets
        ArrayList[] collections = new ArrayList[n];
        for (int i = 0; i < n; i++){
            collections[i] = new ArrayList();
            collections[i].add(i);
        }
        // While number of edges in F is less than n-1
        int considered = 0;
        while (fSize < n-1) {
            edge = sortedEdges[considered];
            // If the start and end nodes are nonzero
            if (edge[0] > 0 && edge[1] > 0) {
                // If the start and end nodes are different add to F
                if (edge[0] > edge[1] || edge[1] > edge[0]) {
                    merge(collections,(int)edge[0],(int)edge[1]);
                    F[fSize] = new int[]{(int)edge[0], (int)edge[1], (int)edge[2]};
                    System.out.println(fSize);
                    fSize++;
                }
            }
            considered++;
        }
        
        /*if (collections[0].size() == n) {
            return F;
        }
        else {
            return new int[][]{{collections[0].size()}};
        }*/
        return F;
            
    }
    
    // Merge collections
    private static void merge(ArrayList[] collections, int p, int q) {
        for (int i = 0; i < collections[q].size(); i++) {
            collections[p].add(collections[q].get(i));
        }
        collections[q].removeAll(collections[q]);

    }
}
