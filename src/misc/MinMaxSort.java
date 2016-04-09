package misc;

import sorting.Sorter;

/**
 *
 * @author Connor
 */
public class MinMaxSort extends Sorter {
    
    
    public MinMaxSort() {
        this.name = "MinMaxSort";
    }
    
    public MinMaxSort(String[] args) {
        this.args = args;
        this.name = "MinMaxSort";
    }
    
    /**
     * Public method called by any class.
     * @param <E>
     * @param a 
     */
    @Override
    public <E extends Comparable<? super E>> void sort(E[] a) {
        super.start();
        minMaxSort(a, 0, a.length-1);
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
        minMaxSort(a,low,high);
    }    
    
    /**
     * Method called by sort(). This is where the actual algorithm is implemented.
     * @param a = array for sorting
     * @param low = lower bound
     * @param high = upper bound
     */
    private <E extends Comparable<? super E>> void minMaxSort(E[] a, int low, int high) {                    
        if (low < high) {
            
        
        E min = a[low], 
                max = a[low];
        int imin = low, imax = low;
        for (int i = low+1; i <= high; i++) {
            if (a[i].compareTo(min) < 0) {
                sendComparison();
                min = a[i];
                imin = i;
            } else if (a[i].compareTo(max) > 0) {
                sendComparison();
                max = a[i];
                imax = i;
            }
            else {
                sendComparison();
            }
        }
        E temp = a[low];
        a[low] = min;
        a[imin] = temp;
        temp = a[high];
        a[high] = max;
        a[imax] = temp;
        minMaxSort(a,low+1,high-1);
        }
    }    
    
}
