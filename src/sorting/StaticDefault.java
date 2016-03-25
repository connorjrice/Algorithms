package sorting;

/**
 *
 * @author Connor
 */
public class StaticDefault {

    public static <E extends Comparable<? super E>> void sort(E[] a) {
        mergeSort(a, a.clone(), 0, a.length-1);
        /*if (aS != null) { // needed for insertionSort at least
            aS.sort(a,0,a.length-1);
        }
        super.end(a);*/
    }
    

    protected static <E extends Comparable<? super E>> void sort(E[]a, int low, int high) {
        mergeSort(a, a.clone(), low, high);
    }
    
    private static <E extends Comparable<? super E>> void mergeSort(E[] s, E[] u, int low, int high) {                    
        int mid;
        if (low < high) {
            mid = (low + high)/2;
            mergeSort(s,u,low,mid);                    
            mergeSort(s,u,mid+1,high);
            merge(s,u,low,mid,high);
        }             
    }
    
    private static <E extends Comparable<? super E>> void merge(E[] s, E[] u, int low, int mid, int high) { 
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
