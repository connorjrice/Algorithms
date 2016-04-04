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
        
        System.out.println(Arrays.deepToString(sortedEdges));
        
        // Initialize disjoint subsets
        ArrayList[] collections = new ArrayList[n];
        for (int i = 0; i < n; i++){
            collections[i] = new ArrayList();
            collections[i].add(i);
        }
        System.out.println(Arrays.deepToString(collections));        
        // While number of edges in F is less than n-1
        int considered = 0;
        while (fSize < n-1) {
            edge = sortedEdges[considered];
            if (merge(collections,(int)edge[0],(int)edge[1])) {
                F[fSize] = new int[]{(int)edge[0], (int)edge[1], (int)edge[2]};
                fSize++;
            }
            considered++;
        }
        
        System.out.println(Arrays.deepToString(collections));
        
        /*if (collections[0].size() == n) {
            return F;
        }
        else {
            return new int[][]{{collections[0].size()}};
        }*/
        return F;
            
    }
    
    // Merge collections TODO: improve
    private static boolean merge(ArrayList[] collections, int p, int q) {
        boolean disjoint = true;
        // Make sure nothing that is in q is in p
        for (int i = 0; i < collections[q].size(); i++) { 
            if (collections[p].contains(collections[q].get(i))) {
                disjoint = false;
            }
        }
        if (disjoint) {
            for (int i = 0; i < collections[q].size(); i++) {
                collections[p].add(collections[q].get(i));                
            }
            collections[q].removeAll(collections[q]);
        }

        return disjoint;
        
    }

}