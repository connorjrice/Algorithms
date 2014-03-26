package sortingalgorithms;

/**
 *
 * @author Connor Rice
 */
public class ExchangeSort {
    private int[] intList;
    
    public ExchangeSort(int[] _intList) {
        intList = _intList;
    }
    
    private void exchangeSort() {
        for (int i = 0; i < intList.length-1; i++) {
            for (int j = i + 1; j < intList.length; j++) {
                if (intList[i] > intList[j]) {
                    int placeholder = intList[i];
                    intList[i] = intList[j];
                    intList[j] = placeholder;
                }
            }
        }
    }
    /**
     * Sorts and returns the list given in the constructor
     * @return intList (after being sorted)
     */
    public int[] getList() {
        exchangeSort();
        return intList;
    } 
    
}
