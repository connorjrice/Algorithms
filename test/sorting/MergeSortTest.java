/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sorting;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import utilities.DataFeed;

/**
 *
 * @author Connor
 */
public class MergeSortTest {
    
    public static final String N = "10000.csv";
    
    public MergeSortTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of sort method, of class MergeSort.
     */
    @Test
    public void testSort_GenericType() {
        System.out.println("sort-parent");
        Comparable[] a = DataFeed.readCSV(N);
        MergeSort instance = new MergeSort();
        instance.sort(a);
        for (int i = 1; i < a.length; i++) {
            if (a[i].compareTo(a[i-1]) < 0) {
                fail("Array was not sorted! index= " + i +  " a[i] = " + 
                        a[i] + " a[j]= " + a[i-1]);                
            }
        }
    }

    /**
     * Test of sort method, of class MergeSort.
     */
    @Test
    public void testSort_3args() {
        System.out.println("sort-child");
        Comparable[] a = DataFeed.readCSV(N);
        MergeSort instance = new MergeSort();
        instance.sort(a, 0, a.length-1);
        for (int i = 1; i < a.length; i++) {
            if (a[i].compareTo(a[i-1]) < 0) {
                fail("Array was not sorted! index= " + i +  " a[i] = " + 
                        a[i] + " a[j]= " + a[i-1]);
            }
        }        
    }
    
    @Test
    public void testSort_hybrid_bub() {
        System.out.println("hybrid-bub");
    }
    
    @Test
    public void testSort_hybrid_ex() {
        System.out.println("hybrid-ex");        
    }
    
    @Test
    public void testSort_hybrid_ins() {
        System.out.println("hybrid-ins");        
    }
    @Test
    public void testSort_hybrid_mrg() {
        System.out.println("hybrid-mrg");        
    }
    @Test
    public void testSort_hybrid_qk() {
        System.out.println("hybrid-qk");        
    }
    
    
}
