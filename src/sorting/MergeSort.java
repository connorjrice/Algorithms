package sorting;

/**
 *
 * @author Connor Rice
 */
public class MergeSort extends Sorter {
    
    
    public MergeSort(String[] args) {
        this.args = args;
        this.name = "MergeSort";
    }    
    
    public MergeSort() {
        this.name = "MergeSort";
    }

    @Override
    public <E extends Comparable<? super E>> void sort(E[] a) {
        super.start();
        super.end(a);
    }   

    
}
