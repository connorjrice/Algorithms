package main;

import branchbound.BFS01prune;
import branchbound.BestFSTSP;
import graph.structures.SimpleDirectedGraph;

/**
 *
 * @author Connor
 */
public class ProblemsDLauncher {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        knapsack();
        tsp();
    }
    
    public static void knapsack() {
        System.out.println("Chapter 6, no. 1");
        BFS01prune k = new BFS01prune();
       /* int[] p = {40,30,50,10};
        int[] w = {2,5,10,5};
        System.out.println("Maximum Profit: " + k.getMaxProfit(4, p, w, 16));
        System.out.println("Optimal set: " + k.getOptimalSet(4, p, w, 16)); */       

        int[] p = {20,30,35,12,3};
        int[] w = {2,5,7,3,1};
        System.out.println("Maximum Profit: " + k.getMaxProfit(5, p, w, 13));
        System.out.println("Chapter 6, no. 3");
        System.out.println("Optimal set: " + k.getOptimalSet(5, p, w, 13));
    }
    
    public static void tsp() {
        double[][] edges = {
            {0,14,4,10,20},
            {14,0,7,8,7},
            {4,5,0,7,16},
            {11,7,9,0,2},
            {18,7,17,4,0},
        };
        SimpleDirectedGraph g = new SimpleDirectedGraph(edges);
        BestFSTSP tsp = new BestFSTSP();
        System.out.println(tsp.travel(g, 5).toString());
    }
    
}
