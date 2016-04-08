package misc;

/**
 * @author Connor
 */
public class TryptychSearch {
    
    public TryptychSearch() {
        
    }
    
    public int tryptychSearch(int[] n, int q) {
        return tryptychSearch(n,q,0,n.length-1);        
    }
    
    private int tryptychSearch(int[] n, int q, int low, int high) {  
        int mid1 = high/3;
        int mid2 = 2 * high/3;
        if (mid1 < mid2-2) {
            if (n[mid1] > q) {
                return tryptychSearch(n,q,low,mid1);
            }
            else if (n[mid2] > q) {
                return tryptychSearch(n,q,mid1,mid2);
            }
            else {
                return tryptychSearch(n,q,mid2,high);
            }
        } else {
            return check(n,q,mid1,mid2);
        }
        
    }
    
    private int check(int[] n, int q, int mid1, int mid2) {
        if (n[mid1] == q) {
            return mid1;
        } else if (n[mid2] == q) {
            return mid2;
        } else if (n[mid1+1] == q) {
            return mid1+1;
        } else {
            return -1;
        }
    }
    
}
