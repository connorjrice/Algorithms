package sorting;

/**
 * 
 * @author Connor Rice
 */


public final class QuickSort extends Sorter {

    public int pivotpoint;
    
    public QuickSort(String[] args) {
        this.pivotpoint = 0;
        this.name = "QuickSort";
        this.args = args;
    }
    
    public QuickSort() {
        this.pivotpoint = 0;
        this.name = "QuickSort";
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

    private <E extends Comparable<? super E>> void quickSort(E[] a, int low, 
            int high) {
        if (high > low) {
            partition(a, low, high);
            quickSort(a,low,pivotpoint-1);
            quickSort(a,pivotpoint+1,high);
            
        }
    }
    
    private <E extends Comparable<? super E>> void partition(E[] a, int low, 
            int high) {
        E pivotitem = a[low];
        int j = low;
        for (int i = low+1; i <= high; i++) {
            if (a[i].compareTo(pivotitem) < 0) {
                sendComparison();
                j++;
                swap(a,j,i);
            }
        }
        this.pivotpoint = j;
        swap(a,low,pivotpoint);            
    }
 
    
    @Override
    protected void reset() {
        super.reset();
    }

}
