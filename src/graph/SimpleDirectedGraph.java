package graph;

/**
 *
 * @author Connor
 */
public class SimpleDirectedGraph {
    
    private double[][] edges;
    private int size;
    
    public SimpleDirectedGraph(double[][] edges) {
        this.size = edges.length;
        this.edges = edges;
    }
    
    public SimpleDirectedGraph(int _size) {
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
    }
    
    public void removeEdge(int a, int b) {
        edges[a][b] = Double.POSITIVE_INFINITY;
    }
    
    public double[][] getEdges() {
        return edges;
    }
    
    public int getSize() {
        return size;
    }    
    
}
