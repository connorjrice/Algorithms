/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;


/**
 *
 * @author Connor
 */
public class FloydsPath {
    
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
