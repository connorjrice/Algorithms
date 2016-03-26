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
        curTask(args);
    }
    
    public static void curTask(String[] args) {
        Sorter b = new BubbleSort(args);
        Sorter e = new ExchangeSort(args);
        Sorter i = new InsertionSort(args);
        Sorter m = new MergeSort(args);
        Sorter q = new QuickSort(args);
        Sorter s = new SelectionSort(args);
        int n = 10000;        
        Integer[] list = getData(n+".csv");


        b.sort(list.clone());
        write(b.getData(), n);
        e.sort(list.clone());
        write(e.getData(), n);        
        i.sort(list.clone());
        write(i.getData(), n);        
        m.sort(list.clone());
        write(m.getData(), n);        
        q.sort(list.clone());
        write(q.getData(), n);        
        s.sort(list.clone());        
        write(s.getData(), n);        
    }
    
    public static void write(String line, int n) {
        Path p = Paths.get("algtimings.csv");
        
    
        try {
            List<String> lines = Files.readAllLines(p);
            if (lines.isEmpty()) {
                lines.add("Name,Time(ms),Size");
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
