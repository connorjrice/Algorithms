package sorting;

/**
 * This class is an implementation of Exchange Sort.
 * @author Connor
 */
public class ExchangeSort extends Sorter {
    
    public ExchangeSort() {
        this.name = "ExchangeSort";
    }    
    
    public ExchangeSort(String[] args) {
        this.args = args;
        this.name = "ExchangeSort";
    }    
        
    /**
     * Public method called by any class.
     * @param <E>
     * @param a 
     */
    @Override
    public <E extends Comparable<? super E>> void sort(E[] a) {
        super.start();
        exchangeSort(a, 0, a.length-1);
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
        exchangeSort(a, low, high);
    }    
    
    /**
     * Method called by sort(). This is where the actual algorithm is implemented.
     * @param a = array for sorting
     * @param low = lower bound
     * @param high = upper bound
     */
    private <E extends Comparable<? super E>> void exchangeSort(E[] a, int low, int high) {                    
        if (!runHybrid(a, low, high)) {
            for (int i = low; i < high; i++) {
                for (int j = i + 1; j < high+1; j++) {
                    if (a[i].compareTo(a[j]) > 0) {
                        sendComparison();
                        swap(a,i,j);
                    } else {
                        sendComparison();
                    }
                }
            }            
        }             
    }    
    
}
