package graph;

import graph.structures.SimpleWeightedGraph;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * M-coloring graph problem
 * Produces all possible colorings of given graph
 * @author Connor
 */
public class MColoring {

    private int[] vcolor;
    private final ArrayList<int[]> colorings = new ArrayList<>();

    // Change this function call to reduce variables (i)
    public void m_coloring(SimpleWeightedGraph g, int m, int i) {
        vcolor = new int[g.getSize()];
        m_coloringHelper(g, m, i);
    }
    

    public void m_coloringHelper(SimpleWeightedGraph g, int m, int i) {
        int color;

        if (promising(g,i)) {
            if (i == g.getSize()-1) {
                System.out.println(Arrays.toString(vcolor));
            } else {
                for (color = 0; color < m; color++) {
                    vcolor[i+1] = color;
                    m_coloringHelper(g,m,i+1);
                }
            }
        }        
    }
    
    public ArrayList<int[]> getColorings() {
        return colorings;
    }
    
    private boolean promising(SimpleWeightedGraph g, int i) {
        boolean promising = true;
        int j = 0;
        while (j < i && promising) {
            if (g.getEdges()[i][j] > 0 && vcolor[i] == vcolor[j]) {
                promising = false;
            }
            j++;
        }
        return promising;
    }
}
