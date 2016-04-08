package graph.structures;

/**
 * Node for Best First TSP Pruning
 * @author Connor
 */
public class TSPNode {
    
    public int level;
    public int[] path;
    public double bound;
    
    public TSPNode(int _level, int[] _path, double _bound) {
        this.level = _level;
        this.path = _path;
        this.bound = _bound;
    }
    
}
