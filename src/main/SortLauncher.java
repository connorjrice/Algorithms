package main;

import sorting.BubbleSort;
import sorting.QuickSort;
import sorting.Sorter;
import sorting.ExchangeSort;
import sorting.MergeSort;
import utilities.ListMaker;

/**
 *
 * @author Connor
 */
public class SortLauncher {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //eS(args);
        qS(args);
        mS(args);
        //bS(args);
    }
    
    public static void eS(String[] args) {
        Sorter es = new ExchangeSort(args);
        es.sort(new Integer[]{5,4,1,3,2});

    }
    
    public static void mS(String[] args) {
        MergeSort ms = new MergeSort(args);
        //ms.sort(new Integer[]{3,2,1});
        //ms.sort(new Integer[]{4,2,78,23,41});
        ms.sort(new Integer[]{27,10,12,20,25,13,15,22});
        ms.sort(ListMaker.makeIntList(30000, 30000));
    }
    
    public static void bS(String[] args) {
        Sorter bs = new BubbleSort(args);
        bs.sort(new Integer[]{5,4,3,2,1});
    }
    
    public static void qS(String[] args) {        


       Sorter qs = new QuickSort(args);
       //qs.sort(new Integer[]{123,34,189,56,150,12,9,240});
       Integer[] list = ListMaker.makeIntList(30000, 30000);
       qs.sort(list);
       qs.sort(new Integer[]{4,7,3,7,10});
       qs.sort(new Integer[]{15,22,13,27,12,10,20,25});

    }
    
}
