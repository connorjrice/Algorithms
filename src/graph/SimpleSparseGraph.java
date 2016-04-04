package graph;

/**
 * Undirected sparse graph containing only edges.
 * @author Connor
 */
public class SimpleSparseGraph {
    
    
    private double[][] edges;
    private int size;
    private int curSize;
    
    public SimpleSparseGraph(int _size) {
        this.size = _size;
        this.edges = new double[size][3];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < 3; j++) {
                edges[i][j] = Double.POSITIVE_INFINITY;
            }
        }        
    }
    
    public void addEdge(int a, int b, double w) {
        edges[curSize][0] = a;
        edges[curSize][1] = b;        
        edges[curSize][2] = w;      
        curSize++;
    }
    
    public void removeEdge(int a, int b) {
        // Binary search
    }
    
    public double[][] getEdges() {
        return edges;
    }
    
    public int getSize() {
        return size;
    }
}
