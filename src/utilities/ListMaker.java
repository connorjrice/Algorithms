package utilities;

import java.util.Random;

public class ListMaker {

    public ListMaker() {

    }

    public static Integer[] makeIntList(int size, int range) {
        Random randy = new Random(42);
	Integer[] intlist = new Integer[size];
	for (int i = 0; i < size; i++) {
            intlist[i] = randy.nextInt(range+1);
	}
	return intlist;
    }
    
}
