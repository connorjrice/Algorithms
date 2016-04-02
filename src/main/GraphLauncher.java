/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import datastructures.Graph;
import datastructures.nodes.GraphNode;
import graph.FloydsPath;
import graph.SimpleWeightedGraph;
import java.util.Arrays;

/**
 *
 * @author Connor
 */
public class GraphLauncher {
    
    public static void main(String[] args) {
/*        Graph g = new Graph(2);
        System.out.println(g.1));*/
        floyd();
    }
    
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
        
        System.out.println(Arrays.deepToString(fp.floyd(g.getEdges())));
    }
    
}
