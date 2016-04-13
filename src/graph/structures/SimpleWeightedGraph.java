package graph.structures;

/**
 * Undirected, weighted graph
 * @author Connor
 */
public class SimpleWeightedGraph {
    
    private final double[][] edges;
    private final int size;
    
    public SimpleWeightedGraph(double[][] edges) {
        this.size = edges.length;
        this.edges = edges;
    }
    
    public SimpleWeightedGraph(int _size) {
        this.size = _size;
        this.edges = new double[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                edges[i][j] = Double.POSITIVE_INFINITY;
            }
        }
    }
    
    public void addEdge(int a, int b, double w) {
        edges[a][b] = w;
        edges[b][a] = w;
    }
    
    public void removeEdge(int a, int b) {
        edges[a][b] = Double.POSITIVE_INFINITY;
        edges[b][a] = Double.POSITIVE_INFINITY;
    }
    
    public double[][] getEdges() {
        return edges;
    }
    
    public int getSize() {
        return size;
    }
}
