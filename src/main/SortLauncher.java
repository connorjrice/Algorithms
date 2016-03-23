package main;

import sorting.BubbleSort;
import sorting.QuickSort;
import sorting.Sorter;
import sortingalgorithms.ExchangeSort;

/**
 *
 * @author Connor
 */
public class SortLauncher {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        eS();
        qS();
        bS();
    }
    
    public static void eS() {
        Sorter es = new ExchangeSort();
        es.sort(new Integer[]{5,4,1,3,2});

    }
    
    public static void mS() {
        
    }
    
    public static void bS() {
        Sorter bs = new BubbleSort();
        bs.sort(new Integer[]{5,4,3,2,1});
    }
    
    public static void qS() {        
        Sorter qs = new QuickSort();
        qs.sort(new Integer[]{2,1});
        qs.sort(new Integer[]{123,34,189,56,150,12,9,240});
        qs.sort(new String[]{"Hello","Googbye"});
    }
    
}
