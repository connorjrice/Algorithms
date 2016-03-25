package utilities;

import java.util.HashMap;
import java.util.Map;
import sorting.*;

/**
 * Runs a given sorting algorithm a number or times and collects time information.
 * @author Connor
 */
public class SortRunner {
    
    
    private int counter = 0;
    public double[] averages;
    public String[] names;
    public Map<String, Double> m;
    
    public SortRunner(int numTests) {
        averages = new double[numTests];
        m = new HashMap<>();
    }
    
    public void run(Sorter s, Comparable[] a, int n) {
        double[] times = new double[n];
        for (int i = 0; i < n; i++) {
            s.sort(a);
            times[i] = s.getTime();
        }
        
    }
        
    
    /**
     * Run a benchmark n numbers of time using s on a
     * @param s Sorting algorithm
     * @param a Comparable array
     * @param n Number of times test is to be run
     * @return 
     *//*
    public void run(Sorter s, Comparable[] a, int n) {
        double[] times = new double[n];
        times[0] = s.getTime();
        for (int i = 0; i < n; i++) {
            s.sort(a);
            averages[i] = s.getTime();
            
        }
        double average = 0;        
        for (double d : times) {
            average += d;
        }
        average /= n;

        averages[counter] = average;
        counter++;
                
    }*/
    
    public Map<String,Double> getMap() {
        return m;
    }
    
    /*private Sorter getSorter(String name) {
        String[] arg = new String[]{"-b"};
        switch (name) {
            case "BubbleSort": return new BubbleSort(arg);
            case "CountingSort": return new CountingSort(arg);
            case "DefaultSort": return new DefaultSort(arg);
            case "ExchangeSort": return new ExchangeSort(arg);
            case "InsertionSort": return new InsertionSort(arg);
            case "MergeSort": return new MergeSort(arg);
            case "QuickSort": return new QuickSort(arg);
            case "SelectionSort": return new SelectionSort(arg);
        }
        return null;
    }*/

    public double getAverage(int i) {
        return averages[i];
    }

}