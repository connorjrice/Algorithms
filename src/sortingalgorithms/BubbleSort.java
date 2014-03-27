package sortingalgorithms;

/**
 *
 * @author Connor Rice
 */
public class BubbleSort {
    
    private int[] intList;
    private int numSwaps;
    
    public BubbleSort(int[] _intList) {
        intList = _intList;
    }
    
    /**
     * Bubble Sort Algorithm. Not optimized
     */
    private void bubbleSort() {
        boolean hasSwapped = false;
        for (int i = 0; i < intList.length-1; i++) {
            if (intList[i] > intList[i+1]) {
                numSwaps++;
                int placeholder = intList[i];
                intList[i] = intList[i+1];
                intList[i+1] = placeholder;
                hasSwapped = true;
            }   
        }
        if (hasSwapped == true) {
            bubbleSort();
        }
    }
    
    /**
     * Sort and return the sorted list.
     * @return sortingArray (sorted)
     */
    public int[] getList() {
        bubbleSort();
        return intList;
    }
    
    public int getNumSwaps() {
        return numSwaps;
    }
    

}
