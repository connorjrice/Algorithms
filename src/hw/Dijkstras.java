package hw;

import graph.SimpleDirectedGraph;
import java.util.Arrays;

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
        
        // For all vertices, initialize v1 to be the last vertex on the current
        // shortest path from v1, and initialize length of that path to be the
        // weight on the edge from v1.
        for (int i = 1; i < n; i++) {
            touch[i] = 0;
            length[i] = g.getEdges()[0][i];
        }
        System.out.println(Arrays.deepToString(g.getEdges()));        

        while (shortSize < n-1) { // Add all n-1 vertices to Y
            min = Double.POSITIVE_INFINITY;
            for (int i = 1; i < n; i++) { // Find smallest vertex
                if (0 <= length[i] && length[i] < min) {
                    min = length[i];
                    vnear = i;
                }
            }
            // Add edge from touch[vnear] to vnear to path
            shortestPath[shortSize] = new int[]{touch[vnear],vnear,(int)g.getEdges()[touch[vnear]][vnear]};
            shortSize++;
            
            for (int i = 1; i < n; i++) {
                if (length[vnear] + g.getEdges()[vnear][i] < length[i]) {
                    // For each vertex not in path, update shortest path
                    length[i] = length[vnear] + g.getEdges()[vnear][i];
                    touch[i] = vnear;
                }
            }
            length[vnear] = -1;
        }
        return shortestPath;
    }
    
}
