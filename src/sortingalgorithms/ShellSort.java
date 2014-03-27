package sortingalgorithms;

/**
 *
 * @author Connor Rice
 */
public class ShellSort {
    
    private int[] intList;
    private int numSwaps;
    
    public ShellSort(int[] _intList) {
        intList = _intList;
    }
    
    public void shellSort() {
        int[] stepList = new int[2];
        stepList[0] = 10;
        stepList[1] = 4;
        stepList[2] = 1;
        for (int h = 0; h < stepList.length; h++) { 
            for (int i = 1; i < intList.length; i+=stepList[h]) {
                int j = i-stepList[h];
                int comparison = intList[i];
                while (j >= 0 && intList[j] > comparison) {
                    intList[j+stepList[h]] = intList[j];
                    numSwaps++;
                    j-=stepList[h];
                }
                intList[j+stepList[h]] = comparison;
            }
            
        }
    }
    
    public int[] getList() {
        shellSort();
        return intList;
    }
    
    public int getNumSwaps() {
        return numSwaps;
    }
    
}
