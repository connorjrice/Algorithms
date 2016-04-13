package misc;

/**
 * algorithm 8.4 pg 357-58
 * @author Connor
 */
public class MinMax {
    
    public int[] findMinMax(int[] a) {
        int[] result = new int[2];
        if (a[0] < a[1]) {
            result[0] = a[0];
            result[1] = a[1];
        } else {
            result[0] = a[1];
            result[1] = a[0];
        }
        
        for (int i = 2; i < a.length-1; i+=2){
            // 
            if (i == a.length-2) { // if a is odd and we're at the last item
                if (a[i] < result[0]) {
                    result[0] = a[i];
                } if (a[i] > result[1]) {
                    result[1] = a[i];
                }
            } else {
                 if (a[i] < a[i+1]) {
                    if (a[i] < result[0]) {
                        result[0] = a[i];
                    }
                    if (a[i+1] > result[1]) {
                    result[1] = a[i+1];
                    }
                } else {
                    if (a[i+1] < result[0]) {
                        result[0] = a[i+1];
                    }
                    if (a[i] > result[1]) {
                        result[1] = a[i];
                    }
                }
            }
        }
            
        return result;
    }
    
}
