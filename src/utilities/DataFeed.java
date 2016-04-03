package utilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import main.SortLauncher;
import static main.SortLauncher.getData;
import sorting.ExchangeSort;
import sorting.InsertionSort;
import sorting.MergeSort;
import sorting.QuickSort;
import sorting.SelectionSort;
import sorting.Sorter;

public class DataFeed {

    public DataFeed() {

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
    
    public static void makeNewList(int size) {
        DataFeed.exportCSV(size, size, size+".csv");
    }

    public static void remakeLists() {
        DataFeed.exportCSV(10, 10, "10.csv");
        DataFeed.exportCSV(100, 100, "100.csv");
        DataFeed.exportCSV(1000, 1000, "1000.csv");
        DataFeed.exportCSV(10000, 10000, "10000.csv");
        DataFeed.exportCSV(100000, 100000, "100000.csv");           
    }   
    
    public static void averageResults(int numTrials, String inputName,
            String outputName) {
        String n = new File(inputName).getAbsolutePath();
        try {
            BufferedReader br = new BufferedReader(new FileReader(n));
            br.readLine(); // read "Name,Time,Comparison,Size"
            averageResults(br, numTrials, inputName, outputName);

        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(DataFeed.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
    }
    

    
    /**
     * Takes a given input file and averages the number of trials, then writes
     * to outputFile.
     * runAlgorithms() can run multiple times, this is to get a csv file with
     * @param br
     * @param numTrials
     * @param inputName
     * @param outputName
     * @throws IOException 
     */
    private static void averageResults(BufferedReader br, int numTrials, 
            String inputName, String outputName) throws IOException {
        String[] curLineSplit = br.readLine().split(",");
        String curName = curLineSplit[0];
        int curSize = Integer.parseInt(curLineSplit[3]);
        double avg = Double.parseDouble(curLineSplit[1]);
        String curLine = "";
        long numComparisons = Long.parseLong(curLineSplit[2]);                
        while ((curLine = br.readLine()) != null) {
            curLineSplit = curLine.split(",");
            if (avg == 0 && numComparisons == 0) {
                curSize = Integer.parseInt(curLineSplit[3]);
                curName = curLineSplit[0];   
                numComparisons = Long.parseLong(curLineSplit[2]);                                
            }
            
            if (curLineSplit[0].equals(curName) && Integer.parseInt(curLineSplit[3]) == curSize)  {
                avg += Double.parseDouble(curLineSplit[1]);
                //numComparisons += Long.parseLong(curLineSplit[2]);                
            } else {
                avg /= numTrials;
                //numComparisons /= numTrials;
                String output = curName + "," + avg + "," + numComparisons;
                write(outputName, output, curSize);  
                avg = 0;
                numComparisons = 0;
            }
        }

        String output = curName + "," + avg + "," + numComparisons;
        write(outputName, output, curSize);          
    }
    
    /**
     * Runs the algorithm on various list sizes with various algorithms.
     * TODO: Make use of input parameters.
     * @param args 
     */
    public static void runAlgorithms(String[] args) {

      //Sorter[] s = {new BubbleSort(args)};
       
       //Sorter[] s = {new ExchangeSort(args),
           // new InsertionSort(args), new MergeSort(args),new QuickSort(args), new SelectionSort(args)};
           
           Sorter[] s = {new QuickSort(args)};
        
       String outputName = "algtimings7.csv";
               
        int[] listSizes = new int[]{50000,75000,100000};
        Integer[][] lists = new Integer[listSizes.length][listSizes.length];
        for (int i = 0; i < listSizes.length; i++) {
            lists[i] = getData(listSizes[i]+".csv");
        }
        int numTests = 6;
        for (Sorter s1 : s) {
            for (int j = 0; j < lists.length; j++) { // Lists
                for (int k = 0; k < numTests; k++) { // number of interations
                    s1.sort(lists[j].clone());                        
                    DataFeed.write(outputName, s1.getData(),lists[j].length);                        
                }
            }
        }
    }
    
    /**
     * Returns a list of Integer from the path given by name.
     * @param name
     * @return 
     */
    public static Integer[] readCSV(String name) {
        Integer[] list = new Integer[0];
        String n = new File(name).getAbsolutePath();
        try {
            BufferedReader br = new BufferedReader(new FileReader(n));
            String[] values = br.readLine().split(",");
            list = new Integer[values.length];
            for (int i = 0; i < values.length; i++) {
                list[i] = Integer.parseInt(values[i].substring(1, values[i].length()-1));
            }
            
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    /**
     * Writes a line that is given by sorter.getData()
     * @param line
     * @param n 
     */
    public static void write(String path, String line, int n) {
        Path p = Paths.get(path);
        try {
            List<String> lines = Files.readAllLines(p);
            if (lines.isEmpty()) {
                lines.add("Name,Time,Comparisons,Size");
            } 
            lines.add(line + ","+n);
            Files.write(Paths.get(p.toString()), lines); 
            
        } catch (IOException e) {
            if (e.getCause() == new NoSuchFieldException().getCause()) {
                try {
                    Files.createFile(p);
                    write(path, line, n);
                } catch (IOException ex) {
                    java.util.logging.Logger.getLogger(SortLauncher.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
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
