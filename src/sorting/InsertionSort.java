package sorting;

import sorting.*;


/**
 * This class is an implementation of Insertion Sort.
 * @author Connor
 */
public class InsertionSort extends Sorter {
    
    public InsertionSort() {
        this.name = "InsertionSort";
    }    
    
    public InsertionSort(String[] args) {
        this.args = args;
        this.name = "InsertionSort";
    }    
        
    /**
     * Public method called by any class.
     * @param <E>
     * @param a 
     */
    @Override
    public <E extends Comparable<? super E>> void sort(E[] a) {
        super.start();
        insertionSort(a, 0, a.length-1);
        super.end(a);
    }
    
    public <E extends Comparable<? super E>> int[] sortIndices(E[] a) {
        int low = 0;
        int high = a.length-1;
        int[] indices = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            indices[i] = i;
        }
        E c; 
        for (int i = low; i <= high; i++) {
            int j = i-1;
            c = a[i];
            while (j >= 0 && a[j].compareTo(c) > 0) {
                sendComparison();
                a[j+1] = a[j];
                indices[j+1] = indices[j];
                j--;
            }
            indices[j+1] = indices[i];
        }        
        return indices;
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
        insertionSort(a, low, high);
    }    
    
    /**
     * Method called by sort(). This is where the actual algorithm is implemented.
     * @param a = array for sorting
     * @param low = lower bound
     * @param high = upper bound
     */
    private <E extends Comparable<? super E>> void insertionSort(E[] a, int low, int high) {                    
        E c; 
        for (int i = low; i <= high; i++) {
            int j = i-1;
            c = a[i];
            while (j >= 0 && a[j].compareTo(c) > 0) {
                sendComparison();
                a[j+1] = a[j];
                j--;
            }
            a[j+1] = c;
        }
    }    
    
}
