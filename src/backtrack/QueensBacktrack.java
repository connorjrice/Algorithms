package backtrack;

import static java.lang.Math.abs;
import java.util.Arrays;

/**
 *
 * @author clarence
 */
public class QueensBacktrack {
   
    public int[] col;
    
    public void queens(int n) {
        col = new int[n];
        queensHelper(-1,n);
    }
    
    private void queensHelper(int i, int n) {
        if (promising(i)) {
            if (i == n-1){
                System.out.println(Arrays.toString(col));                
            } else {
                for (int j = 0; j < n; j++) {
                    col[i+1] = j;
                    queensHelper(i+1,n);
                }
            }
        }
    }
    
    private boolean promising(int i) {
        boolean promising = true;
        int k = 0;
        while (k < i && promising) {
            if (col[i] == col[k] || abs(col[i] - col[k]) == i-k) {
                promising = false;
            }
            k++;
        }
        return promising;
    }
    
}
