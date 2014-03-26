package sortingalgorithms;

/**
 *
 * @author Connor Rice
 */

public final class iQuickSort {

    private int[] intList; // The list to be operated upon
    private int piv;
    
    public iQuickSort(int[] _intList) {
        intList = _intList;
    }

    /**
     * Quicksort algorithm for integers
     *
     * @param beg beginning position in array
     * @param iend ending position in array
     */
    private void cs2QS(int beg, int iend) {
        if (iend - beg >= 2) {

            int p = intList[(beg + iend) / 2];
            piv = (beg + iend) / 2;
            int lpos = beg;
            int rpos = iend;

            while (lpos < rpos) {
                while (intList[lpos] < p) {
                    lpos++;
                }
                while (intList[rpos] > p) {
                    rpos--;
                }
                if (lpos == piv) {
                    int keyr = intList[piv];
                    intList[piv] = intList[rpos];
                    intList[rpos] = keyr;
                    piv = rpos;
                } else if (rpos == piv) {
                    int keyl = intList[piv];
                    intList[piv] = intList[lpos];
                    intList[lpos] = keyl;
                    piv = lpos;
                } else {
                    int key = intList[lpos];
                    intList[lpos] = intList[rpos];
                    intList[rpos] = key;
                }

            }
            cs2QS(beg, piv);
            cs2QS(piv, iend);
        }
        
    }
    
    
    private void quickSort(int beg, int end) {
        
    }
    
    public int[] getList() {
        cs2QS(0, intList.length);
        return intList;
        
    }
}
