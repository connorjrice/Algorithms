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
    
    /**
     * Sorts a int[][] where int[i][0] = startNode,          
     *                       int[i][1] = endNode,
     *                       int[i][2] = weight
     * by the weight.
     */
    public void sort(double[][] edges) {
        int low = 0;
        int high = edges.length-1;
        double[] c; 
        for (int i = low; i <= high; i++) {
            int j = i-1;
            c = edges[i];
            while (j >= 0 && edges[j][2] > c[2]) {
                sendComparison();
                edges[j+1] = edges[j];
                j--;
            }
            edges[j+1] = c;
        }        
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
