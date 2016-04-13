package main;

import graph.HamPath;
import graph.Prims;
import graph.structures.SimpleWeightedGraph;
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

/**
 *
 * @author Connor
 */
public class PrimsLauncher {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       // makeLists();
        runPrims();
    }
    
    public static void makeLists() {
        for (int i = 21; i < 50; i++) {
            makeAdjacencyMatrixUndirected(i);            
        }

    }
    

    public static void runPrims() {
        int[] listSizes = new int[]{5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40};
        
        // We've gone 3D, there is no going back now
        double[][][] lists = new double[listSizes.length][listSizes.length][listSizes.length];
        for (int i = 0; i < listSizes.length; i++) {
            lists[i] = readUndirectedAdjacencyMatrix(listSizes[i]);
        }

        Prims p = new Prims();
        int numTrials = 6;
        for (int i = 0; i < listSizes.length; i++) {
            for (int t = 0; t < numTrials; t++) {
                primsWrite("prims.csv",p.getMSTInstrumented(new SimpleWeightedGraph(lists[i])));                
            }

            
        }
    }
    
    public static double[][] readUndirectedAdjacencyMatrix(int n) {    
        double[][] edges = new double[n][n];
        String f = new File(n+"hamadj.csv").getAbsolutePath();
        try {
            BufferedReader br = new BufferedReader(new FileReader(f));
            for (int i = 0; i < n; i++) {
                String[] values = br.readLine().split(",");                
                for (int j = 0; j < n; j++) {
                    edges[i][j] = Double.parseDouble(values[j]);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return edges;
    }    

    public static void primsWrite(String path, String line) {
        Path p = Paths.get(path);
        try {
            List<String> lines = Files.readAllLines(p);
            if (lines.isEmpty()) {
                lines.add("n,comparisons,duration");
            }
            
            lines.add(line);
            Files.write(Paths.get(p.toString()), lines); 
            
        } catch (IOException e) {
            if (e.getCause() == new NoSuchFieldException().getCause()) {
                try {
                    Files.createFile(p);
                    primsWrite(path, line);
                } catch (IOException ex) {
                    java.util.logging.Logger.getLogger(SortLauncher.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }        
 
    public static void makeAdjacencyMatrixUndirected(int n) {
        Random randy = new Random();
        int[][] edges = new int[n][n];
        int val;
	for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    val = randy.nextInt(2);
                    if (val == 1) {
                        val = randy.nextInt(n);
                        edges[i][j] = val;
                        edges[j][i] = val;
                    }
 
                }
            }
        }
        try (PrintWriter print = new PrintWriter(new File(n+"hamadj.csv"))) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    print.append(edges[i][j] + ",");                        
                }
                print.append("\n");
            }
            print.close();
        } catch (FileNotFoundException e) {
           
        }        
    }    
    
    
    
}
