package sorting;

/**
 *
 * @author Connor Rice
 */
public class MergeSort extends Sorter {
    
    private int threshold = 0;
    private  final InsertionSort IS = new InsertionSort();
    
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
    
    public <E extends Comparable<? super E>> void sort(E[] a, int _threshold) {
        this.threshold = _threshold;
        this.name = "MergeSort with InsertionSort: T=" + _threshold;        
        super.start();

        mergeSortThreshold(a, a.clone(), 0, a.length-1);  
        super.end(a);
    }   
    
    private <E extends Comparable<? super E>> void mergeSort(E[] s, E[] u, int low, int high) {                    
        int mid;
            if (low < high) {
                mid = (int) Math.floor((double)(low + high)/2);
                mergeSort(s,u,low,mid);
                mergeSort(s,u,mid+1,high);
                merge(s,u,low,mid,high);
            }            
    }
    
    private <E extends Comparable<? super E>> void mergeSortThreshold(E[] s, E[] u, int low, int high) {                    
        int mid;
       if (high - low <= threshold) {
            IS.sort(s,low,high);
        } else {
            if (low < high) {
                mid = (int) Math.floor((double)(low + high)/2);
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
