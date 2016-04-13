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
        //makeLists();
      //  readLists();
        color();
    }
    
    public static void makeLists() {
        DataFeed.makeAdjacencyMatrixUndirected(10);
        DataFeed.makeAdjacencyMatrixUndirected(6);
        DataFeed.makeAdjacencyMatrixUndirected(7);
        DataFeed.makeAdjacencyMatrixUndirected(8);
        DataFeed.makeAdjacencyMatrixUndirected(9);
    }
    
    public static void readLists() {
        //System.out.println(Arrays.deepToString(DataFeed.readAdjacencyMatrix(25)));
    }
    
    public static void color() {
       DataFeed.runColor();
    }
    
}
