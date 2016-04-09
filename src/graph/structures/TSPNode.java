package graph.structures;

import java.util.LinkedHashSet;

/**
 * Node for Best First TSP Pruning
 * @author Connor
 */
public class TSPNode {
    
    public int level;
    public LinkedHashSet<Integer> path;
    public double bound;
    
    public TSPNode(int _level, LinkedHashSet<Integer> _path, double _bound) {
        this.level = _level;
        this.path = _path;
        this.bound = _bound;
    }
    

}
