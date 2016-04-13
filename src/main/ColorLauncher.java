package main;

import graph.MColoring;
import java.util.Arrays;
import utilities.DataFeed;

/**
 *
 * @author Connor
 */
public class ColorLauncher {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        makeLists();
      //  readLists();
        color();
    }
    
    public static void makeLists() {
        DataFeed.makeAdjacencyMatrixUndirected(5);
/*        DataFeed.makeAdjacencyMatrixDirected(6);
        DataFeed.makeAdjacencyMatrixDirected(7);
        DataFeed.makeAdjacencyMatrixDirected(8);
        DataFeed.makeAdjacencyMatrixDirected(9);*/
    }
    
    public static void readLists() {
        System.out.println(Arrays.deepToString(DataFeed.readAdjacencyMatrix(25)));
    }
    
    public static void color() {
        MColoring m = new MColoring();
        m.m_coloring(DataFeed.getDirectedGraph(5), 3);
        m.m_coloring(DataFeed.getDirectedGraph(5), 4);
    }
    
}
