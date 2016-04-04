package hw;

import graph.SimpleDirectedGraph;

/**
 *
 * @author Connor
 */
public class Dijkstras {
    
    /**
     * Standard implementation
     * @param g
     * @return 
     */
    public static int[][] getShortestPath(SimpleDirectedGraph g) {
        int n = g.getSize();
        int[][] shortestPath = new int[n-1][3];
        int shortSize = 0;
        
        int[] touch = new int[n];
        double[] length = new double[n];
        
        int vnear = 0;
        double min;
        
        for (int i = 1; i < n; i++) {
            touch[i] = 0;
            length[i] = g.getEdges()[0][i];
        }
        
        while (shortSize < n-1) {
            min = Double.POSITIVE_INFINITY;
            for (int i = 1; i < n; i++) {
                if (0 < length[i] && length[i] < min) {
                    min = length[i];
                    vnear = i;
                }
            }
            // Add edge from touch[vnear] to vnear to path
            shortestPath[shortSize] = new int[]{touch[vnear],vnear,(int)g.getEdges()[touch[vnear]][vnear]};
            shortSize++;
            
            for (int i = 1; i < n; i++) {
                if (length[vnear] + g.getEdges()[vnear][i] < length[i]) {
                    length[i] = length[vnear] + g.getEdges()[vnear][i];
                    touch[i] = vnear;
                }
            }
            length[vnear] = -1;
        }
        return shortestPath;
    }
    
}
