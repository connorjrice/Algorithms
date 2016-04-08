package graph.structures;

/**
 * Node for kn
 * @author Connor
 */
public class KnapNode {
    private final int level, profit, weight;
    
    public KnapNode(int _level, int _profit, int _weight) {
        this.level = _level;
        this.profit = _profit;
        this.weight = _weight;
    }
    
    public int getLevel() {
        return level;
    }
    
    public int getProfit() {
        return profit;
    }
    
    public int getWeight() {
        return weight;
    }    
        
    
}
