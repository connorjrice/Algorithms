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
        //curSort(args);
        mergeHybrid(args);
       //iS(args);
        //mS(args);
    }
    
    public static void curSort(String[] args) {                   
        String n = "1000.csv";        
        Sorter i = new QuickSort(args);
        i.hybrid(new ExchangeSort(args), 100);
        i.sort(ListMaker.readCSV(n));
        i.hybrid(new InsertionSort(args), 0);
    }
    
    public static void mergeHybrid(String[] args) {
        String n = "10000.csv";
        int t = 7;
        MergeSort ms = new MergeSort(args);
        ms.hybrid(new ExchangeSort(args), t);        
        ms.sort(ListMaker.readCSV(n));
        ms.hybrid(new InsertionSort(args), t);
        ms.sort(ListMaker.readCSV(n));
        ms.removeHybrid();
        ms.sort(ListMaker.readCSV(n));              
    }
    
    public static void eS(String[] args) {
        Sorter es = new ExchangeSort(args);
        es.sort(ListMaker.readCSV("1000.csv"));
    }
    
    public static void mS(String[] args) {
        MergeSort ms = new MergeSort(args);
        ms.sort(ListMaker.readCSV("25000.csv"));
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
