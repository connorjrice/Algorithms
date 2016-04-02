package graph;

/**
 *
 * @author Connor
 */
public class SimpleWeightedGraph {
    
    private int[][] edges;
    private int size;
    
    public SimpleWeightedGraph(int _size) {
        this.size = _size;
        this.edges = new int[size][size];
    }
    
    public void addEdge(int a, int b, int w) {
        edges[a][b] = w;
        System.out.println("here");
    }
    
    public int[][] getEdges() {
        return edges;
    }
}
