package sortingunimplemented;

import sorting.*;


/**
 * This class is a template for new algorithms.
 * @author Connor
 */
public class RadixSort extends Sorter {
    
    public RadixSort() {
        this.name = "RadixSort";
    }    
    
    public RadixSort(String[] args) {
        this.args = args;
        this.name = "RadixSort";
    }    
        
    /**
     * Public method called by any class.
     * @param <E>
     * @param a 
     */
    @Override
    public <E extends Comparable<? super E>> void sort(E[] a) {
        super.start();
        radixSort(a, 0, a.length-1);
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
        radixSort(a, low, high);
    }    
    
    /**
     * Method called by sort(). This is where the actual algorithm is implemented.
     * @param a = array for sorting
     * @param low = lower bound
     * @param high = upper bound
     */
    private <E extends Comparable<? super E>> void radixSort(E[] a, int low, int high) {                    

    }    
    
}
