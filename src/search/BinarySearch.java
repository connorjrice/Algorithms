package search;

/**
 *
 * @author Connor Rice
 */

public class BinarySearch {

    protected int low, mid, high;
    protected int location;
    protected int[] s;
    protected int x;

    
    public BinarySearch() {
        this.high = 5;
        this.s = new int[]{0,1,2,3,4,5}; // I'm using 0 as a empty character
        this.x = 3;                      // and it troubles me.
        this.low = 1;
        this.location = 0;
    }
    
    
    /**
     * n = index, 1 to n represents the list
     * s = primitive integer array
     * x = query
     * l = location
     * I think this location thing could be implemented better
     **/
    public BinarySearch(int n, int[] s, int x, int l) {
	this.high = n;
	this.s = s;
	this.x = x;
	this.low = 1;
	this.location = 0;
    }

    public int find() {
	while (low <= high && location == 0) {
	    mid = low + high/2;
	    if (x == s[mid]) {
		location = mid;
	    } else if (x < s[mid]) {
		high = mid - 1;
	    } else {
		low = mid + 1;
	    }

        }
        return location;
    }
    
    

}
