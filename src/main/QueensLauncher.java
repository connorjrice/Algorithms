/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import backtrack.NQueens;

/**
 *
 * @author Connor
 */
public class QueensLauncher {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        queens();
    }
    
    public static void queens() {
        NQueens nq = new NQueens();
        
        /*nq.queens(4);
        nq.queens(5);
        nq.queens(6);
        nq.queens(7);
        nq.queens(8);
        nq.queens(9);
        nq.queens(10);
        nq.queens(11);
        nq.queens(12);
        nq.queens(13);
        nq.queens(14);
        nq.queens(15);*/
        nq.queens(29);
        
        
    }
    
    

    
}
