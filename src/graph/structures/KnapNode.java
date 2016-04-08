package graph.structures;

import java.util.ArrayList;

/**
 * Node for kn
 * @author Connor
 */
public class KnapNode {
    public int level, profit, weight;
    public ArrayList<KnapNode> items;
    
    public KnapNode(int _level, int _profit, int _weight) {
        this.level = _level;
        this.profit = _profit;
        this.weight = _weight;
    }
    
    public void setItems(ArrayList<KnapNode> _items) {
        this.items = _items;
    }
    
    public ArrayList<KnapNode> getItems() {
        return items;
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
