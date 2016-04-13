package graph;

import graph.structures.SimpleWeightedGraph;
import java.util.ArrayList;
import java.util.Arrays;
/**
 *
 * @author Connor
 */
public class HamPath extends Util{
    
    private int[] vindex;
    private ArrayList<int[]> hamPaths = new ArrayList<>();
    private ArrayList costs = new ArrayList<>();
    private double min = Double.POSITIVE_INFINITY;
    private int imin = -1;
    
    /**
     * Input: weighted undirected graph
     * Output: stores all Hamiltonian paths in an array, saves index of minimum.
     * @param g
     * @param n 
     */
    public String hamiltonianPath(SimpleWeightedGraph g, int n) {
        reset();
        getStartTime();
        vindex = new int[n];
        vindex[0] = 1;
        hamiltonian(g,0,n);
        getEndTime();
        return hamPaths.size() + ","+numNodes + "," + numPromising + "," + numSolutions +"," + getDuration();
               
    }
    
    private void hamiltonian(SimpleWeightedGraph g, int i, int n) {
        if (promising(g,i,n)) {
            if (i == n-1){ // If we're at the end print vindex
                hamPaths.add(vindex.clone());
                costs.add(getCost(g));
                incSolutions();
               // Logger.getLogger("HamPath").log(Level.SEVERE, "getCost: " + getCost(g));
                if (getCost(g) < min) {
                    min = getCost(g);
                    imin = hamPaths.size()-1;
                    
                }
                //System.out.println(Arrays.toString(vindex));
                //System.out.println("Cost: " + getCost(g));
                // TODO: Make this more useful than print
            } else {
                for (int j = 2; j <= n; j++) {
                    vindex[i+1] = j;
                    incNodes();
                    hamiltonian(g, i+1, n);
                }
            }
        }
    }
    
    /**
     * Print out the smallest Hamiltonian path
     */
    public void printSmallest() {
        System.out.println(Arrays.toString(hamPaths.get(imin)));
        System.out.println("Cost: " + min);
        
    }
    
    private boolean promising(SimpleWeightedGraph g, int i, int n) {
        boolean promising;
        if (i == n && i != ((int) g.getEdges()[vindex[n-1]][vindex[0]])) {
            promising = false; // First vertex must be adjacent to last.
            // ith vertex adjacent to (i-1st)
        } else if (i == n && i != ((int) g.getEdges()[vindex[i-1]][vindex[i]])) {
            promising = false;
        } else {
            promising = true;
            // Check to see if vertex is already selected
            int j = 1;
            while (j < i && promising) {
                if (vindex[i] == vindex[j]) {
                    promising = false;
                }
                j++;
            }
            
        }
        if (promising) {
            incPromising();
        }
        return promising;
    }
    
    private double getCost(SimpleWeightedGraph g) {
        double cost = 0;
        for (int i = 0; i < vindex.length-2; i++) {
            cost += g.getEdges()[(vindex[i])-1][(vindex[i+1])-1];
        }
        return cost;
    }
    
}
