package graph;

import graph.structures.SimpleDirectedGraph;
import graph.structures.SimpleWeightedGraph;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * M-coloring graph problem
 * Produces all possible colorings of given graph
 * @author Connor
 */
public class MColoring extends Util {

    private int[] vcolor;
    private final ArrayList<int[]> colorings = new ArrayList<>();
    

    /**
     * This should technically be working with a SimpleWeightedGraph, but since
     * it really only matters if there is an edge or not I'm not too concerned.
     * (Difference being weighted is a non-directed graph
     * @param g
     * @param m 
     */
    public void m_coloring(SimpleDirectedGraph g, int m) {
        vcolor = new int[g.getSize()];
        getStartTime();
        m_coloringHelper(g, m, -1);
        getEndTime();

        System.out.println("m= " + m + " nodes: " + numNodes);
        System.out.println("m= " + m + " promising: " + numPromising);
        System.out.println("m= " + m + " " + getDuration() + " numSolutions: " + (int) numSolutions);
    }
    

    private void m_coloringHelper(SimpleDirectedGraph g, int m, int i) {
        int color;

        if (promising(g,i)) {
            if (i == g.getSize()-1) {
                //System.out.println(Arrays.toString(vcolor));
                incSolutions();
            } else {
                for (color = 0; color < m; color++) {
                    vcolor[i+1] = color;
                    incNodes();
                    m_coloringHelper(g,m,i+1);
                }
            }
        }        
    }
    
    public ArrayList<int[]> getColorings() {
        return colorings;
    }
    
    private boolean promising(SimpleDirectedGraph g, int i) {
        boolean promising = true;
        int j = 0;
        while (j < i && promising) {
            if (g.getEdges()[i][j] > 0 && vcolor[i] == vcolor[j]) {
                promising = false;
            }
            j++;
        }
        if (promising) {
            incPromising();
        }
        return promising;
    }
}
