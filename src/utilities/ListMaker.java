package utilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;
import java.util.stream.Stream;

public class ListMaker {

    public ListMaker() {

    }

    
    // save lists
    // compare generic to primitive
    public static Integer[] makeIntList(int size, int range) {
        Random randy = new Random();
	Integer[] intlist = new Integer[size];
	for (int i = 0; i < size; i++) {
            intlist[i] = randy.nextInt(range+1);
        }
	return intlist;
    }
    
    public static Integer[] readCSV(String name) {
        return null;
    }
    
    public static void exportCSV(int size, int range, String name){
        Random randy = new Random();
	Integer[] intlist = new Integer[size];
	for (int i = 0; i < size; i++) {
            intlist[i] = randy.nextInt(range+1);
        }
        try (PrintWriter print = new PrintWriter(new File(name))) {
            for (int i = 0; i < size; i++) {
                if (i == size-1) {
                    print.append("\"" + intlist[i] + "\"");                    
                } else {
                    print.append("\"" + intlist[i] + "\",");                    
                }

            }
        } catch (FileNotFoundException e) {
           
        }

    }
    
}
