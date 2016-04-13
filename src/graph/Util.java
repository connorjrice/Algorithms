package graph;

/**
 *
 * @author Connor
 */
public class Util {

    protected long startTime;
    protected long endTime;
    protected double finalTime; // in ms   
    
    protected double numSolutions;
    protected int numNodes;
    protected int numPromising;
    protected int numComparisons;
    
    public void reset() {
        numSolutions = 0;
        numNodes = 0;
        numPromising = 0;
        finalTime = 0;
        numComparisons = 0;
    }
    
    public void incComparisons() {
        numComparisons++;
    }
    
    public void incPromising() {
        numPromising++;
    }
    
    public void incNodes() {
        numNodes++;
    }

    public void incSolutions() {
        numSolutions++;
    }
    
    /**
     * Records System.nanoTime() as a long.
     * Called when the algorithm is started.
     */
    public void getStartTime() {
        startTime = System.nanoTime();
    }

    /**
     * Records System.nanoTime() as a long.
     * Called when the algorithm is ended.
     */
    public void getEndTime() {
        endTime = System.nanoTime();
    }
    
    /**
     * Subtracts startTime from endTime.
     * Then divides by 10^-6 to get to ms
     * @return string of time with ms added.
     */
    public String getDuration() {
        long time = endTime - startTime;
        return "" + time / 1000000.0;
    }
    
}
