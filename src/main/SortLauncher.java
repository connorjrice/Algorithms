package main;

import sorting.BubbleSort;
import sorting.QuickSort;
import sorting.Sorter;
import sorting.ExchangeSort;
import sorting.InsertionSort;
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
        curSort(args);
       // iS(args);
       // mS(args);
    }
    
    public static void curSort(String[] args) {
        String n = "10000.csv";
        
        MergeSort ms = new MergeSort(args);
        QuickSort qs = new QuickSort(args);
        ms.sort(ListMaker.readCSV(n));
        ms.sort(ListMaker.readCSV(n),10);
        qs.sort(ListMaker.readCSV(n));        

    }
    
    public static void eS(String[] args) {
        Sorter es = new ExchangeSort(args);
        es.sort(ListMaker.readCSV("1000.csv"));
    }
    
    public static void mS(String[] args) {
        MergeSort ms = new MergeSort(args);
        ms.sort(ListMaker.readCSV("25000.csv"));
        //ms.sort(ListMaker.readCSV("25000.csv"), 7);
    }
    
    public static void bS(String[] args) {
        Sorter bs = new BubbleSort(args);
        bs.sort(ListMaker.readCSV("1000.csv"));
    }
    
    public static void qS(String[] args) {        
       Sorter qs = new QuickSort(args);
       qs.sort(ListMaker.readCSV("25000.csv"));
    }
    
    public static void iS(String[] args) {
        Sorter i = new InsertionSort(args);
        i.sort(ListMaker.readCSV("25000.csv"));
    }
    
}
