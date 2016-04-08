package main;

import branchbound.BFS01prune;
import java.util.Arrays;

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
    }
    
    public static void knapsack() {
        System.out.println("Chapter 6, no. 1");
        BFS01prune k = new BFS01prune();
        int[] p = {40,30,50,10};
        int[] w = {2,5,10,5};
        System.out.println("Maximum Profit: " + k.getMaxProfit(4, p, w, 16));
        System.out.println("Optimal set: " + k.getOptimalSet(4, p, w, 16));        

        /*int[] p = {20,30,35,12,3};
        int[] w = {2,5,7,3,1}; problem*/
        //System.out.println("Maximum Profit: " + k.getMaxProfit(5, p, w, 13));
//        System.out.println("Chapter 6, no. 3");
//        System.out.println("Optimal set: " + k.getOptimalSet(5, p, w, 13).toString());
    }
    
}
