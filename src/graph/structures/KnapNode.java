package graph.structures;

import java.util.ArrayList;

/**
 * Node for kn
 * @author Connor
 */
public class KnapNode {
    public int level, profit, weight;
    public ArrayList<Integer> items;
    
    public KnapNode(int _level, int _weight, int _profit) {
        this.level = _level;
        this.weight = _weight;
        this.profit = _profit;        
    }
    
    public KnapNode(int _level, int _weight, int _profit, ArrayList<Integer> _items) {
        this.level = _level;
        this.weight = _weight;
        this.profit = _profit;
        this.items = _items;
    }    
    
    @Override
    public KnapNode clone() {
        return new KnapNode(this.level, this.weight, this.profit);
    }
    
    @Override
    public String toString() {
        return "Level: " + level + " Profit: " + profit + " Weight: " + weight;
    }
    
    public void setItems(ArrayList<Integer> _items) {
        this.items = _items;
    }
    
    public ArrayList<Integer> getItems() {
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
