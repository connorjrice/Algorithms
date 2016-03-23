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
        mergeSort(a, a.clone(), 0, a.length-1);
        super.end(a);
    }   
    
    private <E extends Comparable<? super E>> void mergeSort(E[] a, E[] u, int low, int high) {                    
        int mid;
        if (low < high) {
            mid = (int) Math.floor((double)(low + high)/2);
            mergeSort(a,u,low,mid);
            mergeSort(a,u,mid+1,high);
            merge(a,u,low,mid,high);
        }
    }
    
    
    private <E extends Comparable<? super E>> void merge(E[] a, E[] u, int low, int mid, int high) { 
        int i, j , k;
        i = low;
        j = mid+1;
        k = low;
        while (i <= mid && j <= high) {
            if (a[i].compareTo(a[j]) < 0) {
                u[k] = a[i];
                i++;
            } else {
                u[k] = a[j];
                j++;
            }
            sendComparison();
            k++;
        }
        if (i > mid) {
            while (j <= high) {
                u[k] = a[j];
                k++;
                j++;
            }
        } else {
            int m = i;
            while (m <= mid) {
                u[k] = a[m];
                k++;
                m++;
            }
        }
        int i2 = low;
        while (i2 <= high){
            a[i2] = u[i2];
            k++;
            i2++;
        }        
    }
        
        
        
}           
