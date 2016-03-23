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
 * There's also static sorting allowed.
 * # I used StackOverflow for help with the generic programming.
 * TODO: CSV output of benchmark stats
 * @author Connor Rice
 */
public class Sorter {
    private static final Logger LOG = Logger.getLogger(Sorter.class.getName());
    protected long startTime;
    protected long endTime;
    protected int numComparisons;
    protected String name;
    protected String[] args;
    private Object[] array;
    private boolean bench = false;
    
    public Sorter() {
        Sorter.LOG.setLevel(Level.INFO);
        this.numComparisons = 0;
        this.args = new String[0];
    }
        
    /**
     * Sort method. Blank for now, but used by sub-classes.
     * @param <E>
     * @param a 
     */
    public <E extends Comparable<? super E>> void sort(E[] a) {
        
    }
    
    /**
     * Swaps i and j.
     * @param a array
     * @param i swap index 1
     * @param j swap index 2
     */
    protected <E extends Comparable<? super E>> boolean swap(E[] a, int i, int j) {
        if (i != j) {
            E t = a[i];
            a[i] = a[j];
            a[j] = t;
            return true;
        }
        return false;
    }    
    
    /**
     * Runs args list at start, gets start time.
     * @param <E> 
     */
    protected <E extends Comparable<? super E>> void start() {
        runArgsStart();
        getStartTime();
    }
        
    /**
     * Gets end time, runds end args, resets for next run.
     * @param <E>
     * @param a 
     */
    protected <E extends Comparable<? super E>> void end(E[] a) {
        getEndTime();
        runArgsEnd(a);
        reset();
    }
    
    /**
     * We only care about comparisons if it's a benchmark run.
     */
    protected void sendComparison() {
        if (bench) { 
            incrementComparisons();
        }
    }
    
    /**
     * Runs arguments at start of algorithm execution.
     * @param <E> 
     */
    private <E extends Comparable<? super E>> void runArgsStart() {
        for (String s : args) {
            if (s.equals("-b")) {
                getLogger().log(Level.SEVERE, "true");
                bench = true;
            }
        }
        
    }

    /**
     * Runs arguments at end of algorithm execution.
     * Has the ability to write the array.
     * @param <E>
     * @param a 
     */
    private <E extends Comparable<? super E>> void runArgsEnd(E[] a) {
        if (args != null) {
            if (args.length > 0) {
                for (String s : args) {
                    if (s.equals("-p") || s.equals("-b")) {
                        print(a);                
                    } else if (s.equals("-w")) {
                        write(a);
                    }                    
                }
            }
        } else {
            print(a);
        }
    }

    /**
     * Records System.nanoTime() as a long.
     * Called when the algorithm is started.
     */
    private void getStartTime() {
        startTime = System.nanoTime();
    }

    /**
     * Records System.nanoTime() as a long.
     * Called when the algorithm is ended.
     */
    private void getEndTime() {
        endTime = System.nanoTime();
    }
    
    /**
     * Subtracts startTime from endTime.
     * Then divides by 10^-6 to get to ms
     * @return string of time with ms added.
     */
    private String getDuration() {
       float time = endTime - startTime;
       time /= 1000000;
       return "Time: " + (time) + "ms" ;
    }
    
    /**
     * Resets the environment for the next run.
     */
    protected void reset() {
        numComparisons = 0;
        startTime = 0;
        endTime = 0;
        bench = false;
    }
    
    /**
     * Internal method for incrementing numComparisons.
     */
    private void incrementComparisons() {
        numComparisons++;
    }    
    
    /**
     * @return logger
     */
    protected Logger getLogger() {
        return LOG;
    }
    
    /**
     * Prints out the final list, with number of comparisons if benchmark was
     * run.
     * @param <E>
     * @param a 
     */
    private <E> void print(E[] a) {
        String info = getName() + "\n";             
        if (a.length > 0) {
            info += ("{");
            info += (a[0]);
            for (int i = 1; i < a.length; i++) {
                info += (", " + a[i]);
            }
            info += ("}\n");
            if (bench) {
                info += ("# Comparisons: " + numComparisons + "\n");                
            }

            info += getDuration();
            
            getLogger().log(Level.INFO, info);
        }
    }

    /**
     * Writes a. Only needed if you want to use getArray()
     * @param <E>
     * @param a 
     */
    private <E extends Comparable<? super E>> void write(E[] a) {
        this.array = a;
    }
    
    /**
     * Returns the array sorted by the algorithm.
     * Must have had write() called.
     * @param <E>
     * @return 
     */
    protected <E extends Comparable<? super E>> Object[] getArray() {
        return array;
    }
    
    public String getName() {
        return name;
    }
}
