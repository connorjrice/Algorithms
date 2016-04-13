package main;

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
        readLists();
        color();
    }
    
    public static void makeLists() {
        DataFeed.makeAdjacencyMatrix(10);
        DataFeed.makeAdjacencyMatrix(25);
        DataFeed.makeAdjacencyMatrix(50);
        DataFeed.makeAdjacencyMatrix(75);
        DataFeed.makeAdjacencyMatrix(100);
    }
    
    public static void readLists() {
        System.out.println(Arrays.deepToString(DataFeed.readAdjacencyMatrix(25)));
    }
    
    public static void color() {
        
    }
    
}
