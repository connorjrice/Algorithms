package graph.whiteboard;

/**
 * Implementation of Dijkstra's pathfinding algorithm, but specifically for use
 * in a whiteboard interview situation
 * @author Connor
 */
public class DijkstraWhiteboard {
    
    public static int[][] getShortestPath(int[][] edges) {
        int n = edges.length;
        int[][] shortestPath = new int[n-1][3];
        int shortSize = 0;
        
        int[] touch = new int[n+1];
        double[] length = new double[n+1];
        
        int vnear = 0;
        double min;

        for (int i = 1; i < n; i++) {
            touch[i] = 0;
            length[i] = edges[0][i];
        }
        
        while (shortSize < n-1) { // Add all n-1 vertices to Y
            min = Double.POSITIVE_INFINITY;
            for (int i = 1; i < n; i++) { // Find smallest vertex
                if (0 <= length[i] && length[i] < min) {
                    min = length[i];
                    vnear = i;
                }
            }
            // Add edge from touch[vnear] to vnear to path
            shortestPath[shortSize] = new int[]{touch[shortSize],vnear-1,(int)edges[touch[vnear]][vnear]};
            shortSize++;
            
            for (int i = 1; i < n; i++) {
                if (length[vnear] + edges[vnear][i] < length[i]) {
                    // For each vertex not in path, update shortest path
                    length[i] = length[vnear] + edges[vnear][i];
                    touch[i] = vnear;                                    
                }
                
            }
            length[vnear] = -1;
        }
        return shortestPath;
    }
    
}
