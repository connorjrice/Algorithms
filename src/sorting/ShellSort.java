package sorting;

import sorting.Sorter;

/**
 *
 * @author Connor Rice
 */
public class ShellSort extends Sorter {

    public ShellSort() {

    }
    
    @Override
    public <E extends Comparable<? super E>> void sort(E[] a) {
        

    }
    
    private <E extends Comparable<? super E>> void shellSort(E[] a) {  
        int[] stepList = new int[2];
        stepList[0] = 10;
        stepList[1] = 4;
        stepList[2] = 1;
        for (int h = 0; h < stepList.length; h++) { 
            for (int i = 1; i < a.length; i+=stepList[h]) {
                int j = i-stepList[h];
                E comparison = a[i];
                while (j >= 0 && a[j].compareTo(comparison) > 0) {
                    a[j+stepList[h]] = a[j];
                    j-=stepList[h];
                }
                a[j+stepList[h]] = comparison;
            }
            
        }        
    }  
}
