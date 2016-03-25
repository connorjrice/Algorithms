package sortingalgorithms;

import sorting.*;


/**
 * This class is a template for new algorithms.
 * @author Connor
 */
public class HeapSort extends Sorter {
    
    public HeapSort() {
        this.name = "HeapSort";
    }    
    
    public HeapSort(String[] args) {
        this.args = args;
        this.name = "HeapSort";
    }    
        
    /**
     * Public method called by any class.
     * @param <E>
     * @param a 
     */
    @Override
    public <E extends Comparable<? super E>> void sort(E[] a) {
        super.start();
        heapSort(a, 0, a.length-1);
        super.end(a);
    }
    
    /**
     * Method to only be used by Sorting classes. Allows bounds to be set, called
     * by hybrid algorithm runs.
     * @param <E>
     * @param a = array for sorting
     * @param low = lower bound
     * @param high = upper bound
     */
    @Override
    protected <E extends Comparable<? super E>> void sort(E[]a, int low, int high) {
        heapSort(a, low, high);
    }    
    
    /**
     * Method called by sort(). This is where the actual algorithm is implemented.
     * @param a = array for sorting
     * @param low = lower bound
     * @param high = upper bound
     */
    private <E extends Comparable<? super E>> void heapSort(E[] a, int low, int high) {                    

    }    
    
}
