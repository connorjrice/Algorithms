package graph;

/**
 *
 * @author Connor
 */
public class MatrixGraph {
    
    private int[][] edges;
    
    public MatrixGraph(int[][] edges) {
        this.edges = edges;
    }
    
    public int getEdge(int i, int j) {
        return edges[i][j];
    }
    
}
