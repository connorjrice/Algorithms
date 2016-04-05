package graph;

import graph.structures.SimpleWeightedGraph;
import java.util.Arrays;

/**
 *
 * @author Connor
 */
public class HamPath {
    
    private int[] vindex;
    
    /**
     * Input: weighted undirected graph
     * Output: Hamiltonian path
     * @param g
     * @param n 
     */
    public void hamiltonianPath(SimpleWeightedGraph g, int n) {
        vindex = new int[n];
        vindex[0] = 1;
        hamiltonian(g,0,n);
    }
    
    private void hamiltonian(SimpleWeightedGraph g, int i, int n) {
        if (promising(g,i,n)) {
            if (i == n-1){ // If we're at the end print vindex
                System.out.println(Arrays.toString(vindex));
                // TODO: Make this more useful than print
            } else {
                for (int j = 2; j <= n; j++) {
                    vindex[i+1] = j;
                    hamiltonian(g, i+1, n);
                }
            }
        }
    }
    
    private boolean promising(SimpleWeightedGraph g, int i, int n) {
        boolean promising;
        if (i == n && i != ((int) g.getEdges()[vindex[n-1]][vindex[0]])) {
            promising = false; // First vertex must be adjacent to last.
            // ith vertex adjacent to (i-1st)
        } else if (i == n && i != ((int) g.getEdges()[vindex[i-1]][vindex[i]])) {
            promising = false;
        } else {
            promising = true;
            // Check to see if vertex is already selected
            int j = 1;
            while (j < i && promising) {
                if (vindex[i] == vindex[j]) {
                    promising = false;
                }
                j++;
            }
            
        }
        return promising;
    }
    
}
