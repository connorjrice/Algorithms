package main;

import misc.MinMaxSort;
import sorting.*;
import utilities.*;

/**
 *
 * @author Connor
 */
public class SortLauncher {
    
    
    /**
     * -p : print
     * -b : benchmark
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //DataFeed.runAlgorithms(args);
        curTask(args);
        //newList();
        
    }
    
    public static void curTask(String[] args) {
        ///DataFeed.averageResults(5, "algtimings7.csv", "average.csv");
       // mmS(args);
       //DataFeed.runSortingAlgorithms(args);
       DataFeed.averageResults(6, "algtimings11.csv", "average5.csv");
    }
    
    
    
    public static void newList() {
        DataFeed.makeNewIntCSV(50000);
        DataFeed.makeNewIntCSV(75000);
        DataFeed.makeNewIntCSV(125000);
    }
    

    
    public static void sortRunner(String[] args) {

       /* Sorter s = new MergeSort(args);
        s.sort(getData("1000.csv"));
        System.out.println(s.getTime());*/
        SortRunner sr = new SortRunner(1);
        MergeSort ms = new MergeSort(args);
        QuickSort qs = new QuickSort(args);
        //Sorter[] sorters = new Sorter[]{ms};

        sr.run(ms,getIntArray("25000.csv"), 1);
        System.out.println(sr.getAverage(0));
        System.out.println("hey");
        //double avg = sr.run(new MergeSort(), getData("10000.csv"), 1);        
    }
    
    public static void quickHybrid(String[] args) {
        String n = "10000.csv";
        int t = 7;   
        Sorter q = new QuickSort(args);
        q.hybrid(new InsertionSort(args), t);
        q.sort(getIntArray(n));
        q.removeHybrid();
        q.sort(getIntArray(n));
    }
    
    public static void mergeHybrid(String[] args) {
        String n = "1000.csv";
        int t = 10;
        MergeSort ms = new MergeSort(args);
        ms.sort(getIntArray(n));
        ms.hybrid(new ExchangeSort(args), t);        
        ms.sort(getIntArray(n));
        ms.hybrid(new InsertionSort(args), t);
        ms.sort(getIntArray(n));
        ms.removeHybrid();
        ms.sort(getIntArray(n));
    }
    
    public static void eS(String[] args) {
        Sorter es = new ExchangeSort(args);
        es.sort(getIntArray("1000.csv"));
    }
    
    public static void mS(String[] args) {
        MergeSort ms = new MergeSort(args);
        ms.sort(getIntArray("25000.csv"));
    }
    
    public static void bS(String[] args) {
        Sorter bs = new BubbleSort(args);
        bs.sort(getIntArray("1000.csv"));
    }
    
    public static void qS(String[] args) {        
       Sorter qs = new QuickSort(args);
       qs.sort(getIntArray("25000.csv"));
    }
    
    public static void iS(String[] args) {
        Sorter i = new InsertionSort(args);
        i.sort(getIntArray("1000.csv"));
        i.hybrid(new BubbleSort(args), 7);
        i.sort(getIntArray("1000.csv"));
    }
    
    public static void mmS(String[] args) {
        Sorter i = new MinMaxSort(args);
        i.sort(new Integer[]{5,4,6,8,2,30});
        i.sort(new Integer[]{5,4,8,2,30});
    }
    
    /**
     * Returns a list of Integer[] from n.
     * The list is used by a sorting algorithm.
     * @param n
     * @return 
     */
    public static Integer[] getIntArray(String n) {
        return DataFeed.readIntCSV(n);
    }
    
}
