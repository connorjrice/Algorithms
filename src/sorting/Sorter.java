package sorting;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Sorter class.
 * CP407 Block 7 2016
 * This is the parent class for all sorting algorithms.
 * It provides for number of comparisons and time benchmarking.
 * It's generic too, so anything that can be made to extend comparable is
 * valid input.
 * # I used StackOverflow for help with the generic programming.
 * @author Connor Rice
 */
public class Sorter {
    private static final Logger LOG = Logger.getLogger(Sorter.class.getName());
    protected long startTime;
    protected long endTime;
    protected int numComparisons;
    protected String name;
    
    public Sorter() {
        Sorter.LOG.setLevel(Level.FINE);
        this.numComparisons = 0;
    }
    
    public <E extends Comparable<? super E>> void sort(E[] a) {
        
    }
    
    protected <E extends Comparable<? super E>> void swap(E[] a, int i, int j) {
        if (i != j) {
            E t = a[i];
            a[i] = a[j];
            a[j] = t;
        }
    }    

    protected <E extends Comparable<? super E>> void start() {
        getStartTime();
    }
    
    protected void getStartTime() {
        startTime = System.nanoTime();
    }
    
    protected String getDuration() {
       float time = endTime - startTime;
       time /= 1000000;
       return "Time: " + (time) + "ms" ;
    }
    
    protected void getEndTime() {
        endTime = System.nanoTime();
    }
    
    protected void reset() {
        numComparisons = 0;
        startTime = 0;
        endTime = 0;
    }
    
    protected void incrementComparisons() {
        numComparisons++;
    }    
    
    protected Logger getLogger() {
        return LOG;
    }
    
    protected <E> void print(E[] a) {
        String info = getName() + "\n";             
        if (a.length > 0) {
            info += ("{");
            info += (a[0]);
            for (int i = 1; i < a.length; i++) {
                info += (", " + a[i]);
            }
            info += ("}\n");
            info += ("# Comparisons: " + numComparisons + "\n");
            info += getDuration();
            
            getLogger().log(Level.INFO, info);
        }
    }
    
    protected <E extends Comparable<? super E>> void end(E[] a) {
        getEndTime();
        print(a);
        reset();
    }
    
    private String getName() {
        return name;
    }
}
