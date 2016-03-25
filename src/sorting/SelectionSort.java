package sorting;

/**
 * This class is a template for new algorithms.
 * @author Connor
 */
public class SelectionSort extends Sorter {
    
    public SelectionSort() {
        this.name = "SelectionSort";
    }    
    
    public SelectionSort(String[] args) {
        this.args = args;
        this.name = "SelectionSort";
    }    
        
    /**
     * Public method called by any class.
     * @param <E>
     * @param a 
     */
    @Override
    public <E extends Comparable<? super E>> void sort(E[] a) {
        super.start();
        selectionSort(a, 0, a.length-1);
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
        selectionSort(a, low, high);
    }    
    
    /**
     * Method called by sort(). This is where the actual algorithm is implemented.
     * @param a = array for sorting
     * @param low = lower bound
     * @param high = upper bound
     */
    private <E extends Comparable<? super E>> void selectionSort(E[] a, int low, int high) {                    
        int smallest;
        for (int i = 0; i < a.length-1; i++) {
            smallest = i;
            for (int j = i + 1; j < a.length; j++) {
                sendComparison();
                if (a[j].compareTo(a[smallest]) < 0) {
                    smallest = j;
                }
            }
            swap(a,i,smallest);
        }
    }    
    
}
