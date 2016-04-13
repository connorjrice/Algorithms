package main;

import graph.HamPath;
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
public class HAMLAUNCH {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //makeLists();
        runHam();
    }
    
    public static void makeLists() {
        for (int i = 5; i < 15; i++) {
            makeAdjacencyMatrixUndirected(i);            
        }

    }
    

    public static void runHam() {
        int[] listSizes = new int[]{5,6,7,8,9,10};

        // We've gone 3D, there is no going back now
        double[][][] lists = new double[listSizes.length][listSizes.length][listSizes.length];
        for (int i = 0; i < listSizes.length; i++) {
            lists[i] = readUndirectedAdjacencyMatrix(listSizes[i]);
        }
        int numTests = 7;
        HamPath h = new HamPath();
        for (int i = 0; i < listSizes.length; i++) {
            hamWrite("ham.csv",h.hamiltonianPath(new SimpleWeightedGraph(lists[i]), lists[i].length));
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

    public static void hamWrite(String path, String line) {
        Path p = Paths.get(path);
        try {
            List<String> lines = Files.readAllLines(p);
            if (lines.isEmpty()) {
                lines.add("n,nodes,promising,solutions,time");
            }
            
            lines.add(line);
            Files.write(Paths.get(p.toString()), lines); 
            
        } catch (IOException e) {
            if (e.getCause() == new NoSuchFieldException().getCause()) {
                try {
                    Files.createFile(p);
                    hamWrite(path, line);
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
