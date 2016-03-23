package sorting;

/**
 * 
 * @author Connor Rice
 */


public final class QuickSort extends Sorter {

    private int piv; // Index of the pivot
    
    public QuickSort(String[] args) {
        this.piv = 0;
        this.name = "QuickSort";
        this.args = new String[]{"-p"};
    }
    
    @Override
    public <E extends Comparable<? super E>> void sort(E[] a) {
        super.start();
        if (a.length > 2) {
            sendComparison();
            quickSort(a, 0, a.length-1);
        } else if (a.length == 2) {
            if (a[0].compareTo(a[1]) > 0) {
                sendComparison();
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
                    sendComparison();
                    lpos++;
                }
                while (a[rpos].compareTo(p) > 0) {
                    sendComparison();
                    rpos--;
                }
                if (lpos == piv) {
                    swap(a,piv,rpos);
                    setPiv(rpos);
                } else if (rpos == piv) {
                    sendComparison();
                    swap(a,piv,lpos);
                    setPiv(lpos);
                } else {
                    sendComparison();
                    swap(a,lpos,rpos);
                }
                
            }
            
            quickSort(a, beg, piv);
            quickSort(a, piv, end);
        } 
    }

    private void setPiv(int n) {
        piv = n;
    }
    
    @Override
    protected void reset() {
        super.reset();
        piv = 0;
    }

}
