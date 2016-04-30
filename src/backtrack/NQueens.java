package backtrack;

import graph.Util;
import java.util.Arrays;
import static java.lang.Math.abs;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author clarence
 */
public class NQueens extends Util {
   
    public int[] col;
    private Random randy = new Random();
    
    public void queens(int n) {
        getStartTime();
        col = new int[n];
        queensHelper(-1,n);
        //estimateQueens(n);
        getEndTime();
        System.out.println(getDuration());
        /*System.out.println("n= " + n + " nodes: " + numNodes);
        System.out.println("n= " + n + " promising: " + numPromising);
        System.out.println("n= " + n + " " + getDuration() + " numSolutions: " + (int) numSolutions);*/
        reset();
    }
    
    public void estimate (int n) {
        col = new int[n];        
        estimateQueens(n);        
    }
    
    private void estimateQueens(int n) {
        int i, j;
        
        int m, mprod, numnodes;
        ArrayList<Integer> promChildren = new ArrayList<>();
        
        i = 0;
        numnodes = 1;
        m = 1; 
        mprod = 1;
        while (m != 0 && i != n-1) {
            mprod *= m;
            numnodes += mprod * n ; 
            i++;
            m = 0;
            promChildren.clear(); 
            for (j = 1; j <= n; j++) {
                col[i] = j;
                if(promising(i)) {
                    m++;
                    promChildren.add(j);
                }
            }
            if (m != 0) {
                col[i] = randy.nextInt(promChildren.size());
            }
            
        }
        System.out.println("n= " + n + " nodes: " + numnodes);
    }
    
    private void queensHelper(int i, int n) {
        if (promising(i)) {
            if (i == n-1){
                incSolutions();
                //System.out.println(Arrays.toString(col));                
            } else {
                //incNodes();
                for (int j = 0; j < n; j++) {
                    col[i+1] = j;
                    incNodes();
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
        if (promising) {
            incPromising();
        }
        return promising;
    }
    
}
