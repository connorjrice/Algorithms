/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw;

import datastructures.Graph;
import datastructures.Queue;
import datastructures.nodes.GraphNode;
import java.util.ArrayList;

/**
 *
 * @author Connor
 */
public class Ch4n6 {
    
    
    public Ch4n6() {
        
    }
    
    /***
     * Takes in a minimum spanning tree and determines if it is connected.
     * @param edges
     * @param n number of nodes
     * @return 
     */
    public boolean isConnected(int[][] edges, int n) {
        Graph g = new Graph(n);
        g.createNodes();
        for (int[] edge : edges) {
            g.addEdge(g.getNode(edge[0]), g.getNode(edge[1]), edge[2]);
        }
        return (g.bread)
    }

    
   
}
