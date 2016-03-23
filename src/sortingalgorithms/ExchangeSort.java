package sortingalgorithms;

import sorting.Sorter;

/**
 * ExchangeSort
 * @author Connor Rice
 */
public class ExchangeSort extends Sorter {
    
    
    public ExchangeSort(String[] args) {
        
    }
    
    public ExchangeSort() {
        this.name = "ExchangeSort";
        this.args = new String[]{"-p"};
    }
    
    /**
     * sort() is the command called from outside of the program.
     * It's responsible for setting up and tearing down the run.
     * @param <E>
     * @param a 
     */
    @Override
    public <E extends Comparable<? super E>> void sort(E[] a) {
        super.start();
        exchangeSort(a);
        super.end(a);
    }

    
    private <E extends Comparable<? super E>> void exchangeSort(E[] a) {        
        for (int i = 0; i < a.length-1; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i].compareTo(a[j]) > 0) {
                    sendComparison();
                    E placeholder = a[i];
                    a[i] = a[j];
                    a[j] = placeholder;
                } else {
                    sendComparison();
                }
            }
        }
    }
    
}
