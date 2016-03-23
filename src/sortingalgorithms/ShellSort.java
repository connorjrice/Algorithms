package sortingalgorithms;

import sorting.Sorter;

/**
 *
 * @author Connor Rice
 */
public class ShellSort extends Sorter {
    
    public int[] intList;

    public ShellSort() {

    }
    
    @Override
    public <E extends Comparable<? super E>> void sort(E[] a) {
        
        int[] stepList = new int[2];
        stepList[0] = 10;
        stepList[1] = 4;
        stepList[2] = 1;
        for (int h = 0; h < stepList.length; h++) { 
            for (int i = 1; i < a.length; i+=stepList[h]) {
                int j = i-stepList[h];
                int comparison = intList[i];
                while (j >= 0 && intList[j] > comparison) {
                    intList[j+stepList[h]] = intList[j];
                    j-=stepList[h];
                }
                intList[j+stepList[h]] = comparison;
            }
            
        }
    }
    
    public void shellSort() {
    }
    
    public int[] getList() {
        shellSort();
        return intList;
    }
    
}
