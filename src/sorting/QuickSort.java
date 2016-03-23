package sorting;

/**
 * #StackOverflow helped for the generic bits.
 * @author Connor Rice
 */


public final class QuickSort extends SortingAlgorithm {

    private int piv; // Index of the pivot
    
    public QuickSort() {
        this.piv = 0;
    }
    
    @Override
    public <E extends Comparable<? super E>> void sort(E[] a) {
        super.start();
        if (a.length > 2) {
            incrementComparisons();
            quickSort(a, 0, a.length-1);
        } else if (a.length == 2) {
            if (a[0].compareTo(a[1]) > 0) {
                incrementComparisons();
                swap(a,0,1);
            }
        }
        super.end(a);
    }   

    private <E extends Comparable<? super E>> void quickSort(E[] a, int beg, 
            int end) {
        if (end - beg >= 2) {
            E p = a[(beg+end)/2];
            piv = (beg+end) / 2;
            int lpos = beg;
            int rpos = end;
            
            while (lpos < rpos) {
                while (a[lpos].compareTo(p) < 0) {
                    incrementComparisons();
                    lpos++;
                }
                while (a[rpos].compareTo(p) > 0) {
                    incrementComparisons();
                    rpos--;
                }
                if (lpos == piv) {
                    swap(a,piv,rpos);
                    piv = rpos;
                } else if (rpos == piv) {
                    swap(a,piv,lpos);
                    piv = lpos;
                } else {
                    swap(a,lpos,rpos);
                }
                
            }
            quickSort(a, beg, piv);
            quickSort(a, piv, end);
        } 
    }
    
    @Override
    protected void reset() {
        super.reset();
        piv = 0;
    }

}
