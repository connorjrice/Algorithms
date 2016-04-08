package branchbound;

import graph.structures.SimpleDirectedGraph;
import graph.structures.TSPNode;
import java.util.PriorityQueue;

/**
 * Best-First Search with Branch-and-bound pruning algorithm for TSP
 * @author Connor
 */
public class BestFSTSP {
    
    public int[][] travel(SimpleDirectedGraph g, int n) {
        int[][] path = new int[g.getEdges().length][3];
        PriorityQueue pq = new PriorityQueue(); // TODO: Write my own PQ ds        
        TSPNode u, v;
        
        //v = new TSPNode(0,new int[0],bound(v));
        return path;
    }
    

}
