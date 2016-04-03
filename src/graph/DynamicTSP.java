package graph;

/**
 *
 * @author Connor
 */
public class DynamicTSP {
 
    
    public DynamicTSP() {
        
    }
    
    public void travel(int n, int[][] edges, int minLength) {
        int[][] p = new int[n][n];
        int[][] d = new int[n][n-1];
        
        for (int i = 1; i<= n; i++) {
            d[i][0] = edges[i][1];
        }
        for (int k = 1; k <= n-2; k++) {//n-what?
            
            
        }
    }
}
