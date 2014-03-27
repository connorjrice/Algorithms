package sortingalgorithms;

/**
 *
 * @author Connor Rice
 */
public class InsertionSort {
    private int[] intList;
    private int numSwaps;
    
    public InsertionSort(int[] _intList) {
        intList = _intList;
    }
    
    public void insertionSort() {
        for (int i = 1; i < intList.length; i++) {
            int j = i-1;
            int comparison = intList[i];
            while (j >= 0 && intList[j] > comparison) {
                intList[j+1] = intList[j];
                numSwaps++;
                j--;
            }
            numSwaps++; // Compensate for when it leaves the loop
            intList[j+1] = comparison;
        }
           
    }
    
    public int[] getList() {
        insertionSort();
        return intList;
    }
    
    public int getNumSwaps() {
        return numSwaps;
    }
    
}
