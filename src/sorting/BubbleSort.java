package sorting;

/**
 *
 * @author Connor Rice
 */
public class BubbleSort extends Sorter {
    
    
    public BubbleSort(String[] args) {
        this.args = args;
        this.name = "BubbleSort";        
    }    
    
    
    public BubbleSort() {
        this.name = "BubbleSort";
    }
    
    @Override
    public <E extends Comparable<? super E>> void sort(E[] a) {
        super.start();
        bubbleSort(a, 0, a.length-1);
        super.end(a);
    }
    
    @Override
    protected <E extends Comparable<? super E>> void sort(E[]a, int lb, int ub) {
        bubbleSort(a,lb,ub);
    }
    
    /**
     * Bubble Sort Algorithm. Not optimized, doesn't have to be.
     */
    private <E extends Comparable<? super E>> void bubbleSort(E[] a, int lb, int ub) {
        if(!runHybrid(a,lb,ub)) {
            boolean hasSwapped = false;
            for (int i = lb; i < ub; i++) {
                if (a[i].compareTo(a[i+1])> 0) {
                    sendComparison();
                    E placeholder = a[i];
                    a[i] = a[i+1];
                    a[i+1] = placeholder;
                    hasSwapped = true;
                }   
            }
            if (hasSwapped == true) {
                bubbleSort(a,lb,ub);
            }
        }
    }
    
}
