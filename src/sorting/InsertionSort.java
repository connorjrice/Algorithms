package sorting;

/**
 *
 * @author Connor Rice
 */
public class InsertionSort extends Sorter {
    
    public InsertionSort() {
        this.name = "InsertionSort";
    }
    
    public InsertionSort(String[] args) {
        this.args = args;
        this.name = "Insertion Sort";
    }
    
    @Override
    public <E extends Comparable<? super E>> void sort(E[] a) {        
        super.start();
        insertionSort(a);
        super.end(a);
    }
    
    public <E extends Comparable<? super E>> E[] sort(E[] a, int lb, int ub) {
       /* E c = a[lb+1];
        insertionSort(a,c,lb,ub);*/
        return a;
    }
    
    private <E extends Comparable<? super E>> void insertionSort(E[] a) {            
        for (int i = 1; i < a.length; i++) {
            int j = i-1;
            E comparison = a[i];
            while (j >= 0 && a[j].compareTo(comparison) > 0) {
                a[j+1] = a[j];
                j--;
            }
            a[j+1] = comparison;
        }
    }
   
    private <E extends Comparable<? super E>> void insertionSort(E[] a, E c, int lb, int ub) {            
        for (int i = lb+1; i < ub; i++) {
            int j = i-1;
            while (j >= 0 && a[j].compareTo(c) > 0) {
                a[j+1] = a[j];
                j--;
            }
            a[j+1] = c;
        }
    }
       
}
