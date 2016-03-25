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
    protected int numComparisons; // for base class
    protected String finalComparisons; // string with base+(hybrid)
    protected String name = "";
    protected String[] args;
    private Object[] array;
    private boolean bench = true;

    protected Sorter aS;
    protected int threshold = -1;
    
    public Sorter() {
        Sorter.LOG.setLevel(Level.INFO);
        this.numComparisons = 0;
        this.args = new String[0];
    }
    
    public Sorter(String[] args) {
        Sorter.LOG.setLevel(Level.INFO);
        this.numComparisons = 0;
        this.args = args;        
        //runArgsStart();
    }
        
    /**
     * Sort method. Blank for now, but used by sub-classes.
     * @param <E>
     * @param a 
     */
    public <E extends Comparable<? super E>> void sort(E[] a) {
        
    }
    
    public void hybrid(Sorter _aS, int _threshold) {
        removeHybrid();
        aS = _aS;
        this.name += " + " + aS.getName() + "@"+_threshold;
        this.threshold = _threshold;
    }
    
    public void hybrid(Sorter _aS) {
        removeHybrid();
        aS = _aS;
        this.name += " + " + aS.getName() + "@"+ 7;
        this.threshold = 7;
    }

    
    public void removeHybrid() {
        aS = null;
        if (this.name.contains("+")) {
            this.name = name.substring(0, name.indexOf("+")-1);            
        }
        this.threshold = -1;
    }
    

    public String getName() {
        return name;
    }    
    
    public boolean getBench() {
        return bench;
    }
    
    protected <E extends Comparable<? super E>> boolean runHybrid(E[] a, int lb, int ub) {
        if (ub - lb <= threshold && threshold != -1) {
            aS.sort(a,lb,ub);
            return true;
        } else {
            return false;
        }
    }
    
    protected <E extends Comparable<? super E>> void sort(E[] a, int lb, int ub) {
      
    }
    
    /**
     * Swaps i and j.
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
        addHybridComparisons();
        runArgsEnd(a);
        reset();
    }
    
    protected int getComparisons() {
        return numComparisons;
    }
    
    protected void setBench(boolean b) {
        bench = b;
    }
    
    private void addHybridComparisons() {
        if (threshold != -1) {
            finalComparisons = numComparisons + "(" + aS.getComparisons() +
                    ") = " + (numComparisons + aS.getComparisons());
        } else {
            finalComparisons = numComparisons + "";
        }
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
     * Resets the environment for the next run.
     */
    protected void reset() {
        numComparisons = 0;
        startTime = 0;
        endTime = 0;
        
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
    
    /**
     * @return logger
     */
    protected Logger getLogger() {
        return LOG;
    }    
    
    /**
     * Runs arguments at start of algorithm execution.
     * @param <E> 
     */
    private <E extends Comparable<? super E>> void runArgsStart() {
        boolean foundB = false; // have we found -b? (benchmarking)
        for (String s : args) {
            if (s.equals("-b")) {
                foundB = true;
            }
        }
        bench = foundB;
        
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
                    } /*else if (s.equals("-w")) {
                        write(a);
                    }*/                    
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
        long time = endTime - startTime;
        double ms = time / 1000000.0;
        return "Time: " + (ms) + "ms" ;
    }
    
    /**
     * increments numComparisons.
     */
    private void incrementComparisons() {
        numComparisons++;
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
                info += ("# Comparisons: " + finalComparisons + "\n");                
            }

            info += getDuration();
            getLogger().log(Level.INFO, info);
        }
    }

}
