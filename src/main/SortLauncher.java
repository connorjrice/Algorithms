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
       DataFeed.runAlgorithms(args);
    }
    
    
    
    public static void newList() {
        DataFeed.makeNewList(50000);
        DataFeed.makeNewList(75000);
        DataFeed.makeNewList(125000);
    }
    

    
    public static void sortRunner(String[] args) {

       /* Sorter s = new MergeSort(args);
        s.sort(getData("1000.csv"));
        System.out.println(s.getTime());*/
        SortRunner sr = new SortRunner(1);
        MergeSort ms = new MergeSort(args);
        QuickSort qs = new QuickSort(args);
        //Sorter[] sorters = new Sorter[]{ms};

        sr.run(ms,getData("25000.csv"), 1);
        System.out.println(sr.getAverage(0));
        System.out.println("hey");
        //double avg = sr.run(new MergeSort(), getData("10000.csv"), 1);        
    }
    
    public static void quickHybrid(String[] args) {
        String n = "10000.csv";
        int t = 7;   
        Sorter q = new QuickSort(args);
        q.hybrid(new InsertionSort(args), t);
        q.sort(getData(n));
        q.removeHybrid();
        q.sort(getData(n));
    }
    
    public static void mergeHybrid(String[] args) {
        String n = "1000.csv";
        int t = 10;
        MergeSort ms = new MergeSort(args);
        ms.sort(getData(n));
        ms.hybrid(new ExchangeSort(args), t);        
        ms.sort(getData(n));
        ms.hybrid(new InsertionSort(args), t);
        ms.sort(getData(n));
        ms.removeHybrid();
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
        i.sort(getData("1000.csv"));
        i.hybrid(new BubbleSort(args), 7);
        i.sort(getData("1000.csv"));
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
    public static Integer[] getData(String n) {
        return DataFeed.readIntCSV(n);
    }
    
}
