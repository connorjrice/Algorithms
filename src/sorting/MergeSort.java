package sorting;

/**
 *
 * @author Connor Rice
 */
public class MergeSort extends Sorter {
    
   // private Sorter aS;//= new InsertionSort();
    
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
        mergeSort(a, a.clone(), 0, a.length-1);
        if (aS != null) { // needed for insertionSort at least
            aS.sort(a,0,a.length-1);
        }
        super.end(a);
    }
    
    /**
     * Sort using a different version of mergeSort
     * 0 = default, 1 = dynamic, 2 = linked
     * @param <E>
     * @param a
     * @param p 
     */
    public <E extends Comparable<? super E>> void sort(E[] a, int p) {
        super.start();        
        if (p == 0) {
            mergeSort(a, a.clone(), 0, a.length-1);
        } else if (p == 1) {
            //mergeSortDynamic(a, a.clone(), 0, ((a.length-1)/2) a.length-1);`
        }
        super.end(a);
    }
    
    @Override
    protected <E extends Comparable<? super E>> void sort(E[]a, int low, int high) {
        mergeSort(a, a.clone(), low, high);
    }
    
    private <E extends Comparable<? super E>> void mergeSortDynamic(E[] a, int low, int high) {
        
    }
    
    private <E extends Comparable<? super E>> void mergeSortLinked(E[] a, int low, int high) {
        
        
    }
    
    private <E extends Comparable<? super E>> void mergeSort(E[] s, E[] u, int low, int high) {                    
        int mid;
        if (!runHybrid(s,low,high)) {
            if (low < high) {
                mid = (low + high)/2;
                mergeSort(s,u,low,mid);                    
                mergeSort(s,u,mid+1,high);
                merge(s,u,low,mid,high);
            }             
        }
    }
    
    private <E extends Comparable<? super E>> void merge(E[] s, E[] u, int low, int mid, int high) { 
        int i, j , k;
        i = low;
        j = mid+1;
        k = low;
        while (i <= mid && j <= high) {
            if (s[i].compareTo(s[j]) < 0) {
                u[k] = s[i];
                i++;
            } else {
                u[k] = s[j];
                j++;
            }
            sendComparison();
            k++;
        }
        if (i > mid) {
            while (j <= high) {
                u[k] = s[j];
                k++;
                j++;
            }
        } else {
            while (i <= mid) {
                u[k] = s[i];
                k++;
                i++;
            }
        }
        while (low <= high){
            s[low] = u[low];
            k++;
            low++;
        }        
    }


}           
