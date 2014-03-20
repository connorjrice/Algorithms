package sortingalgorithms;

/**
 *
 * @author Connor Rice
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public final class QuickSort {

    private String readfile;   // The name of the file that will be read
    private String outputfile; // The name of the file that will be created
    private String[] sortingList; // The list to be operated upon
    private int piv;           // Index of the pivot

    /**
     * Make the input parameters accesible
     * @param infile
     * @param outfile 
     */
    public QuickSort() {

    }

    /**
     * Quicksort algorithm for sorting text files of words by comparing
     * lexicographical order.
     *
     * @param beg beginning position in array
     * @param iend ending position in array
     */
    private void lexicoQuickSort(int beg, int iend) {
        if (iend - beg >= 2) {

            String p = sortingList[(beg + iend) / 2];
            piv = (beg + iend) / 2;
            int lpos = beg;
            int rpos = iend;

            while (lpos < rpos) {
                while (sortingList[lpos].compareTo(p) < 0) {
                    lpos++;
                }
                while (sortingList[rpos].compareTo(p) > 0) {
                    rpos--;
                }
                if (lpos == piv) {
                    String keyr = sortingList[piv];
                    sortingList[piv] = sortingList[rpos];
                    sortingList[rpos] = keyr;
                    piv = rpos;
                } else if (rpos == piv) {
                    String keyl = sortingList[piv];
                    sortingList[piv] = sortingList[lpos];
                    sortingList[lpos] = keyl;
                    piv = lpos;
                } else {
                    String key = sortingList[lpos];
                    sortingList[lpos] = sortingList[rpos];
                    sortingList[rpos] = key;
                }

            }
            lexicoQuickSort(beg, piv);
            lexicoQuickSort(piv, iend);
        }
        /**
         * TODO: Implement MergeSort for arrays of size less than 7
         */
    }

    /**
     * Writes the list to a given filename
     *
     * @param outputfilename the name of the file to be written to
     */
    private void printer() {
        try {
            BufferedWriter print = new BufferedWriter(new FileWriter(outputfile));
            for (int i = 0; i < 63788; i++) {
                print.write(sortingList[i]);
                print.newLine();
            }
            print.flush();
            print.close();
        } catch (IOException e) {
            System.out.println("Error in printing");
        }
    }

    /**
     * Finds the number of lines in the input file
     *
     * @param filename the file to be read from
     * @return the number of lines in the file
     */
    private int getNumLines() {
        try {
            BufferedReader scan = new BufferedReader(new FileReader(readfile));
            String s = scan.readLine();
            int numlines = 0;
            while (s != null) {
                s = scan.readLine();
                numlines++;
            }
            return numlines;
        } catch (IOException e) {
            /**
             * TODO: Better exception handling
             */
            System.out.println("Error in reading");
            return -1;
        }
    }

    /**
     * Build an (unsorted) list of lines from the file.
     *
     * @param filename the filename that will be read from.
     */
    protected void reader() {
        try {
            sortingList = new String[getNumLines()];
            BufferedReader scan = new BufferedReader(new FileReader(readfile));
            String s = scan.readLine();
            int i = 0;
            while (s != null) {
                sortingList[i] = s;
                s = scan.readLine();
                i++;
            }
        } catch (IOException e) {
            /**
             * TODO: Better exception handling
             */
            System.out.println("Error in reading");
        }
    }
    
    /**
     * Determine what type of list will be built and sorted.
     * Possible types:
     * Lexicographical text file
     * Integer array
     * @param type the type of sorting that will be done
     */
    public void listType(String type) {
        if (type.equals("lTextFile")) {
            
        }
        else if (type.equals("iArray")) {
            
        }
    }
}
