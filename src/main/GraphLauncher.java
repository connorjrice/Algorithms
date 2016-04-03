/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import graph.FloydsPath;
import graph.Grapher;
import hw.ProblemsCGraph;
import graph.SimpleWeightedGraph;
import hw.Ch4n2;
import hw.Ch4n6;
import java.util.Arrays;

/**
 *
 * @author Connor
 */
public class GraphLauncher {
    
    public static void main(String[] args) {
/*        Graph g = new Graph(2);
        System.out.println(g.1));*/
        //floyd();
       // prims();
       connected();
    }
    
    public static void prims() {
        int[][] W = {{0,8,13,18,20},
                     {3,0,7,8,10},
                     {4,11,0,10,7},
                     {6,6,7,0,11},
                     {10,6,2,1,0}
        };
        int[][] edges = Ch4n2.getMSTPrims(W);
        //int[][] edges = ProblemsCGraph.getOptimalCircuit(W);
        System.out.println(Arrays.deepToString(edges));
        System.out.println(Grapher.getMSTWeight(edges));
    }
    
    public static void connected() {
            int[][] W = {{0,1,1},{0,0,0},{0,0,0}};
        W = Ch4n2.getMSTPrims(W);
        System.out.println(Arrays.deepToString(W));
        System.out.println(Ch4n6.isConnected(W, 3));
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
