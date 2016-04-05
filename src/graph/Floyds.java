package graph;

import graph.structures.SimpleWeightedGraph;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Connor
 */
public class Floyds {
   
        public static void floyd() {
        SimpleWeightedGraph g = new SimpleWeightedGraph(7);
        // V1
        g.addEdge(0, 1, 4);
        g.addEdge(0, 5, 10);
                
        // V2
        g.addEdge(1, 0, 3);
        g.addEdge(1, 3, 18);
        
        // V3
        g.addEdge(2, 1, 6);        
        
        // V4
        g.addEdge(3, 1, 5);        
        g.addEdge(3, 2, 15);
        g.addEdge(3, 4, 2);        
        g.addEdge(3, 5, 19);                
        g.addEdge(3, 6, 5);                        
        
        // V5
        g.addEdge(4, 3, 1);        
        g.addEdge(4, 2, 12);
        
        // V6
        g.addEdge(5, 6, 10);        

        
        // V7        
        g.addEdge(6, 3, 8);        
        
        Logger.getLogger("Floyds").log(Level.INFO, Arrays.deepToString(g.getEdges()));
        
        Floyds fp = new Floyds();
        
        //Logger.getLogger("").log(Level.INFO, Arrays.deepToString(fp.floyd(g.getEdges())));
    }
    
    
    public int[][] floyd(int[][] edges) {
        int[][] d = edges;
        int i, j, k = 0;
        for (k = 0; k < edges.length; k++) {
            for (i = 0; i < edges.length; i++) {
                for (j = 0; j < edges.length; j++) {
                    d[i][j] = minimum(d[i][j], d[i][k] + d[k][j]);
                }
            }
        }
        return d;
    }
    
    public int minimum(int a, int b) {
        if (a > b) {
            return a;
        } else {
            return b;
        }
            
    }
    
}
