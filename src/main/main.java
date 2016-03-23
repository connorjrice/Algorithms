package main;

import search.BinarySearch;

/**
 *
 * @author Connor
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        binarySearch();
    }
    
    public static void binarySearch() {
        BinarySearch bs = new BinarySearch();
        System.out.println(bs.find());
    }
}
