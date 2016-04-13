package main;

import graph.MColoring;
import backtrack.NQueens;
import graph.Grapher;
import graph.structures.SimpleDirectedGraph;
import graph.structures.SimpleSparseGraph;
import graph.Prims;
import graph.structures.SimpleWeightedGraph;
import graph.Dijkstras;
import graph.HamPath;
import misc.Job;
import graph.Kruskals;
import misc.Scheduler;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * 
 * @author Connor
 */
public class ProblemsCLauncher {
    
    public static void main(String[] args) {
        hamPath();
        prims();
        kruskals();
        dijkstras();
        schedule();
        coloring();
       // queen();
    }
    
    public static void hamPath() {
        System.out.println("Hamiltonian Path: Chapter 3 n.28");
        double[][] W = {
            {0,8,13,18,20},
            {3,0,7,8,10},
            {4,11,0,10,7},
            {6,6,7,0,11},
            {10,6,2,1,0}
        };
        
        SimpleWeightedGraph g = new SimpleWeightedGraph(W);
        HamPath hp = new HamPath();
        hp.hamiltonianPath(g, g.getSize());
        hp.printSmallest();
        System.out.println();

    }
    
    // Chapter 4, no 2, 6
    public static void prims() {
        System.out.println("Prims: Chapter 4 n. 2, 6");
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
        int[][] F = Prims.getMST(g);
        System.out.println(Arrays.deepToString(F));
        System.out.println("Is connected?: " + Prims.isConnected(F));
        System.out.println("Total cost: " + Grapher.getMSTWeight(F));
        System.out.println();        
        
    }
    public static void kruskals() {
        System.out.println("Kruskals: Chapter 4 n. 7");        
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
        System.out.println();        
        
    }
        
    public static void dijkstras() {
        System.out.println("Dijkstras: Chapter 4 n.12, 15");            
        double[][] edges = new double[][]{
            {0,Double.POSITIVE_INFINITY,72,50,90,35},
            {Double.POSITIVE_INFINITY,0,71,70,73,75},
            {72,71,0,Double.POSITIVE_INFINITY,77,90},
            {50,70,Double.POSITIVE_INFINITY,0,60,40},
            {90,73,77,60,0,80},
            {35,75,90,40,80,0}
        };
        // Start at v5
        SimpleDirectedGraph g = new SimpleDirectedGraph(edges);
        int[][] vertex4 = Dijkstras.getShortestPathFromEnd(g);
        int[][] vertex0 = Dijkstras.getShortestPath(g);
        System.out.println("from vertex 4(indexed at 0): " + Arrays.deepToString(vertex4));
        System.out.println("Total cost: " + Grapher.getMSTWeight(vertex4));                
        System.out.println("from vertex 0: " + Arrays.deepToString(vertex0));
        System.out.println("Total cost: " + Grapher.getMSTWeight(vertex0));
        System.out.println();                
                 
    }

    private static void schedule() {
        Scheduler s = new Scheduler();
        System.out.println("Schedule problem: Chapter 4 n. 22");
        // This is the homework one from 5th edition        
        Job[] D = new Job[]{new Job(1,2,40), new Job(2,4,15), new Job(3,3,60),
            new Job(4,2,20),new Job(5,3,10),new Job(6,1,45),new Job(7,1,55)};

        
        // Fourth edition
        /*Job[] D = new Job[]{new Job(1,3,40), new Job(2,1,35), new Job(3,1,30),
            new Job(4,3,25),new Job(5,1,20),new Job(6,3,15),new Job(7,2,10)};*/
        ArrayList schedule = s.schedule(D);
        System.out.println("Schedule: " + schedule.toString());        
        System.out.println();                
    }
    
    public static void coloring() {
        System.out.println("M-Coloring problem: Chapter 5 n. 18 ");
        MColoring m = new MColoring();
        double[][] edges = new double[][] {
            {0,1,0,1,0,0},
            {1,0,1,0,1,0},
            {0,1,0,0,0,1},
            {1,0,0,0,1,0},
            {0,1,0,1,0,1},
            {0,0,1,0,1,0}
        };
        
        SimpleWeightedGraph g = new SimpleWeightedGraph(edges);
        m.m_coloring(g, 3, -1);
        System.out.println(Arrays.deepToString(m.getColorings().toArray()));
        
        System.out.println();                
    }
    
    public static void queen() {
        NQueens q = new NQueens();
        q.queens(4);
    }


}
