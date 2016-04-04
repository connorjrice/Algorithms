package hw;

import graph.SimpleDirectedGraph;

/**
 *
 * @author Connor
 */
public class DynamicTSP {
 
    
    public DynamicTSP() {
        
    }
    
    public static int[][] travel(SimpleDirectedGraph g) {
        int[][] P = new int[g.getSize()][3]; // getsize for now
        double[][] D = new double[g.getSize()][g.getSize()-1];
        for (int i = 0; i < g.getSize(); i++) {
            D[i][0] = g.getEdges()[i][1];
        }
        for (int k = 0; k < g.getSize()-2; k++) {
//            for ()
        }
        return P;
    }
}
