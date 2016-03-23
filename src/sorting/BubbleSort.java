package sorting;

/**
 *
 * @author Connor Rice
 */
public class BubbleSort extends Sorter {
    
    
    public BubbleSort() {
        this.name = "BubbleSort";
    }
    
    @Override
    public <E extends Comparable<? super E>> void sort(E[] a) {
        super.start();
        bubbleSort(a);
        super.end(a);
    }
    
    /**
     * Bubble Sort Algorithm. Not optimized, doesn't have to be.
     */
    private <E extends Comparable<? super E>> void bubbleSort(E[] a) {
        boolean hasSwapped = false;
        for (int i = 0; i < a.length-1; i++) {
            if (a[i].compareTo(a[i+1])> 0) {
                incrementComparisons();
                E placeholder = a[i];
                a[i] = a[i+1];
                a[i+1] = placeholder;
                hasSwapped = true;
            }   
        }
        if (hasSwapped == true) {
            bubbleSort(a);
        }
    }

}
