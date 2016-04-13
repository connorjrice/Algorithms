package main;

import graph.MColoring;
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
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import utilities.DataFeed;

/**
 *
 * @author Connor
 */
public class ColorLauncher {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //makeLists();
      //  readLists();
        color();
    }
    
    public static void makeLists() {
        makeAdjacencyMatrixUndirected(10);
        makeAdjacencyMatrixUndirected(6);
        makeAdjacencyMatrixUndirected(7);
        makeAdjacencyMatrixUndirected(8);
        makeAdjacencyMatrixUndirected(9);
    }
    
    public static void readLists() {
        //System.out.println(Arrays.deepToString(DataFeed.readAdjacencyMatrix(25)));
    }
    
    public static void color() {
       runColor();
    }
    
    public static SimpleWeightedGraph getWeightedGraph(int n) {
        return new SimpleWeightedGraph(readUndirectedAdjacencyMatrix(n));
    }
    
    public static void runColor() {
        //int[] listSizes = new int[]{5,6,7,8,9,10};
        int[] listSizes = new int[]{10};

        // We've gone 3D, there is no going back now
        double[][][] lists = new double[listSizes.length][listSizes.length][listSizes.length];
        for (int i = 0; i < listSizes.length; i++) {
            lists[i] = readUndirectedAdjacencyMatrix(listSizes[i]);
        }
        int numTests = 7;
        MColoring m = new MColoring();
        for (int j = 0; j < lists.length; j++) { // Lists
            for (int k = 0; k < numTests; k++) { // number of colors
               //colorWrite("color.csv", m.m_coloring(new SimpleWeightedGraph(lists[j]), k));
               m.m_coloring(new SimpleWeightedGraph(lists[j]), k);
            }
        }
    }
    
    public static double[][] readUndirectedAdjacencyMatrix(int n) {    
        double[][] edges = new double[n][n];
        String f = new File(n+"uadj.csv").getAbsolutePath();
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

    public static void colorWrite(String path, String line) {
        Path p = Paths.get(path);
        try {
            List<String> lines = Files.readAllLines(p);
            if (lines.isEmpty()) {
                lines.add("n,m,solutions,nodes,promising,time");
            }
            
            lines.add(line);
            Files.write(Paths.get(p.toString()), lines); 
            
        } catch (IOException e) {
            if (e.getCause() == new NoSuchFieldException().getCause()) {
                try {
                    Files.createFile(p);
                    colorWrite(path, line);
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
                    edges[i][j] = val;
                    edges[j][i] = val;   
                }
            }
        }
        try (PrintWriter print = new PrintWriter(new File(n+"uadj.csv"))) {
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
