package utilities;

import java.util.Random;

public class ListMaker {
    private Random randy;

    public ListMaker() {
	randy = new Random();	
    }

    public int[] makeIntList(int size, int range) {
	int[] intlist = new int[size];
	for (int i = 0; i < size; i++) {
	    intlist[i] = randy.nextInt(range+1);
	}
	return intlist;
    }
    
}