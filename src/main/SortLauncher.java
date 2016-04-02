package main;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        //rTask(args);
       //ewList();
        runAlgorithms(args);
    }
    
    public static void curTask(String[] args) {

    }
    
    
    public static void newList() {
        DataFeed.makeNewList(2000);
        DataFeed.makeNewList(3000);
        DataFeed.makeNewList(4000);
        DataFeed.makeNewList(5000);
        DataFeed.makeNewList(6000);
        DataFeed.makeNewList(7000);
        DataFeed.makeNewList(8000);
        DataFeed.makeNewList(9000);
    }
    
    public static void runAlgorithms(String[] args) {

      //Sorter[] s = {new BubbleSort(args)};
       
       Sorter[] s = {new ExchangeSort(args),
            new InsertionSort(args), new MergeSort(args),new QuickSort(args), new SelectionSort(args)};
        
           
               
        int[] listSizes = new int[]{100,1000,2000,3000,4000,5000,6000,7000,8000,9000,10000,25000};
        Integer[][] lists = new Integer[listSizes.length][listSizes.length];
        for (int i = 0; i < listSizes.length; i++) {
            lists[i] = getData(listSizes[i]+".csv");
        }
        int numTests = 10;
        for (Sorter s1 : s) {
            for (int j = 0; j < lists.length; j++) { // Lists
                for (int k = 0; k < numTests; k++) { // number of interations
                    s1.sort(lists[j].clone());                        
                    write(s1.getData(),lists[j].length);                        
                }
            }
        }
    }
    
    public static void write(String line, int n) {
        Path p = Paths.get("algtimings6.csv");
        
    
        try {
            List<String> lines = Files.readAllLines(p);
            if (lines.isEmpty()) {
                lines.add("Name,Time,Comparisons,Size");
            } 
            lines.add(line + ","+n);
            Files.write(Paths.get(p.toString()), lines); 
            
        } catch (IOException e) {
            if (e.getCause() == new NoSuchFieldException().getCause()) {
                try {
                    Files.createFile(p);
                    write(line, n);
                } catch (IOException ex) {
                    Logger.getLogger(SortLauncher.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
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
    
    public static Integer[] getData(String n) {
        return DataFeed.readCSV(n);
    }
    
}
