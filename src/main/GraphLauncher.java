/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import graph.Grapher;
import graph.SimpleDirectedGraph;
import graph.SimpleSparseGraph;
import hw.Prims;
import graph.SimpleWeightedGraph;
import hw.Ch4n6;
import hw.Dijkstras;
import hw.Kruskals;
import java.util.Arrays;

/**
 *
 * @author Connor
 */
public class GraphLauncher {
    
    public static void main(String[] args) {
      prims();
      kruskals();
      dijkstras();
    }
    
    public static void ch3() {
        /*int[][] W = {{0,8,13,18,20},
                     {3,0,7,8,10},
                     {4,11,0,10,7},
                     {6,6,7,0,11},
                     {10,6,2,1,0}
        };
        int[][] edges = Ch4n2.getMSTPrims(W);        


        //int[][] edges = ProblemsCGraph.getOptimalCircuit(W);
        System.out.println(Arrays.deepToString(edges));
        System.out.println(Grapher.getMSTWeight(edges));*/
    }
    
    // Chapter 4, no 2, 6
    public static void prims() {
        System.out.println("Prims:");
        SimpleWeightedGraph g = new SimpleWeightedGraph(10);
        g.addEdge(0,1,32);
        g.addEdge(0,3,17);
        g.addEdge(3,2,18);
        g.addEdge(2,6,5);
        g.addEdge(6,7,59);
        g.addEdge(7,3,3);
        g.addEdge(3,4,10);
        g.addEdge(4,1,45);
        g.addEdge(4,5,28); 
        g.addEdge(4,8,25);        
        g.addEdge(8,9,12);        
        g.addEdge(9,5,6);        
        g.addEdge(7,8,4);
        System.out.println(Arrays.deepToString(g.getEdges()));
        int[][] F = Prims.getMST(g);
        System.out.println(Arrays.deepToString(F));
        System.out.println("Is connected?: " + Prims.isConnected(F));
        System.out.println("Total cost: " + Grapher.getMSTWeight(F));
        
    }
    public static void kruskals() {
        System.out.println("Kruskals:");        
        SimpleSparseGraph g = new SimpleSparseGraph(13);
        g.addEdge(0,1,32);
        g.addEdge(0,3,17);
        g.addEdge(3,2,18);
        g.addEdge(2,6,5);
        g.addEdge(6,7,59);
        g.addEdge(7,3,3);
        g.addEdge(3,4,10);
        g.addEdge(4,1,45);
        g.addEdge(4,5,28); 
        g.addEdge(4,8,25);        
        g.addEdge(8,9,12);        
        g.addEdge(9,5,6);        
        g.addEdge(7,8,4);
        int[][] F = Kruskals.getMST(g, 10);
        System.out.println(Arrays.deepToString(F));        
        System.out.println("Total cost: " + Grapher.getMSTWeight(F));
    }
        
    public static void dijkstras() {
        System.out.println("Dijkstras:");                
        double[][] edges = new double[][]{
            {0,Double.POSITIVE_INFINITY,72,50,90,35},
            {Double.POSITIVE_INFINITY,0,71,70,73,75},
            {72,71,0,Double.POSITIVE_INFINITY,77,90},
            {50,70,Double.POSITIVE_INFINITY,0,60,40},
            {90,73,77,60,0,80}
        };
        // Start at v5
        SimpleDirectedGraph g = new SimpleDirectedGraph(edges);
        System.out.println(Arrays.deepToString(Dijkstras.getShortestPathFromEnd(g)));
        System.out.println(Arrays.deepToString(Dijkstras.getShortestPath(g,0)));
    }


}
