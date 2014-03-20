package sortingalgorithms;

/**
 *
 * @author Connor Rice
 */
public class BubbleSort {
    
    private int[] sortingArray;
    
    public BubbleSort(int[] inputarray) {
        sortingArray = inputarray;
    }
    
    /**
     * Bubble Sort Algorithm. Not optimized
     */
    private void bubbleSort() {
        boolean hasSwapped = false;
        for (int i = 0; i < sortingArray.length; i++) {
            if (sortingArray[i] > sortingArray[i+1]) {
                int placeholder = sortingArray[i];
                sortingArray[i] = sortingArray[i+1];
                sortingArray[i+1] = placeholder;
                hasSwapped = true;
            }   
        }
        if (hasSwapped = true) {
            bubbleSort();
        }
    }
    
    /**
     * Sort and return the sorted list.
     * @return sortingArray (sorted)
     */
    public int[] doTheBubble() {
        bubbleSort();
        return sortingArray;
    }
    
}
