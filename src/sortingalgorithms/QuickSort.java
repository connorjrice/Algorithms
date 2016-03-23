package sortingalgorithms;

/**
 * #StackOverflow helped for the generic bits.
 * @author Connor Rice
 */

public final class QuickSort {

    private int numComparisons;
    private int piv; // Index of the pivot
    
    public QuickSort() {
        this.numComparisons = 0;
        this.piv = 0;
    }
    
    public <E extends Comparable<? super E>> void quickSort(E[] a) {
        if (a.length > 2) {
            quickSort(a, 0, a.length-1);            
        } else if (a.length == 2) {
            if (a[0].compareTo(a[1]) > 0) {
                incComp();
                swap(a,0,1);
            }
        }
        print(a);
        reset();
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
                    incComp();
                    lpos++;
                }
                while (a[rpos].compareTo(p) > 0) {
                    incComp();
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
    
    private <E extends Comparable<? super E>> void swap(E[] a, int i, int j) {
        if (i != j) {
            E t = a[i];
            a[i] = a[j];
            a[j] = t;
        }
    }
    
    private <E> void print(E[] a) {
        if (a.length > 0) {
            System.out.print("{");
            System.out.print(a[0]);
        for (int i = 1; i < a.length; i++) {
            System.out.print(", " + a[i]);
        }
        System.out.println("}");
        System.out.println("#Comp: " + numComparisons);
        }
    }
    
    private void reset() {
        numComparisons = 0;
        piv = 0;
    }
    
    private void incComp() {
        numComparisons++;
    }
}
