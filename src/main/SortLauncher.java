package main;

import sorting.BubbleSort;
import sorting.QuickSort;
import sorting.Sorter;
import sorting.ExchangeSort;
import sorting.InsertionSort;
import sorting.MergeSort;
import utilities.DataFeed;

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
       //eS(args);
        //mS(args);
        //quickHybrid(args);
    }
    
    public static void curSort(String[] args) {                   
        String n = "1000.csv";        
        Sorter i = new InsertionSort(args);
        i.hybrid(new ExchangeSort(args), 10);
        i.sort(getData(n));
        Sorter e = new ExchangeSort(args);
        e.hybrid(new InsertionSort(args), 10);
        e.sort(getData(n));
    }
    
    public static void quickHybrid(String[] args) {
        String n = "10000.csv";
        int t = 7;   
        Sorter q = new QuickSort(args);
        q.hybrid(new ExchangeSort(args), t);
        q.sort(getData(n));
        q.removeHybrid();
        q.sort(getData(n));
    }
    
    
    public static void mergeHybrid(String[] args) {
        String n = "10000.csv";
        int t = 9;
        MergeSort ms = new MergeSort(args);
        ms.hybrid(new ExchangeSort(args), t);        
        ms.sort(getData(n));
        /*
        ms.hybrid(new InsertionSort(args), t);
        ms.sort(getData(n));
        ms.removeHybrid();
        ms.sort(getData(n));*/
        ms = new MergeSort(args);
        ms.hybrid(new InsertionSort(args),t);
        ms.sort(getData(n));
    }
    
    public static void eS(String[] args) {
        Sorter es = new ExchangeSort(args);
        es.sort(getData("1000.csv"));
    }
    
    public static void mS(String[] args) {
        MergeSort ms = new MergeSort(args);
        ms.sort(getData("25000.csv"));
    }
    
    public static void bS(String[] args) {
        Sorter bs = new BubbleSort(args);
        bs.sort(getData("1000.csv"));
    }
    
    public static void qS(String[] args) {        
       Sorter qs = new QuickSort(args);
       qs.sort(getData("25000.csv"));
    }
    
    public static void iS(String[] args) {
        Sorter i = new InsertionSort(args);
        i.sort(getData("25000.csv"));
    }
    
    public static Integer[] getData(String n) {
        return DataFeed.readCSV(n);
    }
    
}
