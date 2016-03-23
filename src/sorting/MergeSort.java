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
        mergeSort(a, 0, a.length-1);
        super.end(a);
    }   
    
    private <E extends Comparable<? super E>> void mergeSort(E[] a, int low, int high) {        
        int mid;
        if (low < high) {
            mid = (int) Math.floor((double)(low + high)/2);
            mergeSort(a,low,mid);
            mergeSort(a, mid+1,high);
            merge(a,low,mid,high);
        }
        
    }
    
    private <E extends Comparable<? super E>> void merge(E[] a, int low, int mid, int high) { 
        int i, j , k;
        E[] u = a.clone(); // will it blend?
        i = low;
        j = mid+1;
        k = low;
        while (i <= mid && j <= high) {
            if (a[i].compareTo(a[j]) > 0) {
                u[k] = a[i];
                i++;
            } else {
                u[k] = a[j];
                j++;
            }
            k++;
        }
        if (i > mid) {
            while (j < high) {
                u[k] = a[j];
                k++;
                j++;
            }
        } else {
            while (i < mid) {
                u[k] = a[i];
                k++;
                i++;
                // move U[low] through U[high] to S[low] through S[high]
            }
                
        }
    }
        
        
        
}           
