/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

import java.util.Arrays;


/**
 *
 * @author Connor
 */
public class FloydsPath {
   
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
        
        System.out.println(Arrays.deepToString(g.getEdges()));
        
        FloydsPath fp = new FloydsPath();
        
        //System.out.println(Arrays.deepToString(fp.floyd(g.getEdges())));
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
