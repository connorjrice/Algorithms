package graph.structures;

import java.util.LinkedHashSet;

/**
 * Node for Best First TSP Pruning
 * @author Connor
 */
public class TSPNode implements Comparable<TSPNode> {
    
    public int level;
    public LinkedHashSet<Integer> path;
    public double bound;
    
    public TSPNode(int _level, LinkedHashSet<Integer> _path, double _bound) {
        this.level = _level;
        this.path = _path;
        this.bound = _bound;
    }

    @Override
    public int compareTo(TSPNode o) {
        if (bound == o.bound) {
            return 0;
        } else if (bound > o.bound) {
            return 1;
        } else {
            return 0;
        }
    }
    

}
