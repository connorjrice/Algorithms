package graph;

import graph.structures.SimpleSparseGraph;
import java.util.ArrayList;
import sorting.InsertionSort;

/**
 *
 * @author Connor
 */
public class Kruskals {
    
    /** Chapter 4, n.7
     * @param g
     * @param n
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
        
        int step = 0;
        // While number of edges in F is less than n-1
        int considered = 0;
        while (fSize < n-1) {
            edge = sortedEdges[considered];
            if (merge(collections,(int)edge[0],(int)edge[1])) {
                System.out.println("Step " + (fSize+1)  + " : Add edge: node1: " + (int)edge[0] + " node2: " + (int)edge[1] + " weight: " + (int)edge[2]);                
                F[fSize] = new int[]{(int)edge[0], (int)edge[1], (int)edge[2]};
                fSize++;
            }
            considered++;
        }
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