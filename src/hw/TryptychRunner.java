/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw;

/**
 *
 * @author Connor
 */
public class TryptychRunner {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ch2n6 ex = new ch2n6();
        int[] n = new int[]{1,4,6,23,45,100};
        int q = 23;
        System.out.println(ex.tryptychSearch(n, q));
        int[] n2 = new int[]{1,4,5};
        int q1 = 23;
        System.out.println(ex.tryptychSearch(n2, q1));
        int[] n3 = new int[]{1,4,6,23,45,100,101};
        int q2 = 23;
        System.out.println(ex.tryptychSearch(n3, q2));
        int[] n4 = new int[]{3,4,5,6,7,8};
        int q3 = 42;
        System.out.println(ex.tryptychSearch(n4, q3));        
    }
    
}
