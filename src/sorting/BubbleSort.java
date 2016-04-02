package sorting;

import sorting.*;


/**
 * This class is a template for new algorithms.
 * @author Connor
 */
public class BubbleSort extends Sorter {
    
    public BubbleSort() {
        this.name = "BubbleSort";
    }    
    
    public BubbleSort(String[] args) {
        this.args = args;
        this.name = "BubbleSort";
    }    
        
    /**
     * Public method called by any class.
     * @param <E>
     * @param a 
     */
    @Override
    public <E extends Comparable<? super E>> void sort(E[] a) {
        super.start();
        bubbleSort(a, 0, a.length-1);
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
        bubbleSort(a, low, high);
    }    
    
    /**
     * Method called by sort(). This is where the actual algorithm is implemented.
     * @param a = array for sorting
     * @param low = lower bound
     * @param high = upper bound
     */
    private <E extends Comparable<? super E>> void bubbleSort(E[] a, int low, int high) {                    
        if(!runHybrid(a, low, high)) {
            boolean hasSwapped = false;
            for (int i = low; i < high; i++) {
                if (a[i].compareTo(a[i+1])> 0) {
                    sendComparison();
                    E placeholder = a[i];
                    a[i] = a[i+1];
                    a[i+1] = placeholder;
                    hasSwapped = true;
                } else {
                    sendComparison();
                }
            }
            if (hasSwapped == true) {
                bubbleSort(a, low, high);
            }
        }
    }    
    
}
