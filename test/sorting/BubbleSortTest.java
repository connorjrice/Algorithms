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
public class BubbleSortTest {
    
    public static final String N = "100.csv";    
    
    public BubbleSortTest() {
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
     * Test of sort method, of class BubbleSort.
     */
    @Test
    public void testSort_GenericType() {
        System.out.println("sort-parent");
        Comparable[] a = DataFeed.readCSV(N);
        BubbleSort instance = new BubbleSort();
        instance.sort(a);
        for (int i = 1; i < a.length; i++) {
            if (a[i].compareTo(a[i-1]) < 0) {
                fail("Array was not sorted! index= " + i +  " a[i] = " + 
                        a[i] + " a[j]= " + a[i-1]);                
            }
        }
    }

    /**
     * Test of sort method, of class BubbleSort.
     */
    @Test
    public void testSort_3args() {
        System.out.println("sort-child");
        Comparable[] a = DataFeed.readCSV(N);
        BubbleSort instance = new BubbleSort();
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
        Comparable[] a = DataFeed.readCSV(N);
        BubbleSort instance = new BubbleSort();
        instance.hybrid(new BubbleSort());
        instance.sort(a, 0, a.length-1);
        for (int i = 1; i < a.length; i++) {
            if (a[i].compareTo(a[i-1]) < 0) {
                fail("Array was not sorted! index= " + i +  " a[i] = " + 
                        a[i] + " a[j]= " + a[i-1]);
            }
        }           
    }
    
    @Test
    public void testSort_hybrid_ex() {
        System.out.println("hybrid-ex");        
        Comparable[] a = DataFeed.readCSV(N);
        BubbleSort instance = new BubbleSort();
        instance.hybrid(new ExchangeSort());        
        instance.sort(a, 0, a.length-1);
        for (int i = 1; i < a.length; i++) {
            if (a[i].compareTo(a[i-1]) < 0) {
                fail("Array was not sorted! index= " + i +  " a[i] = " + 
                        a[i] + " a[j]= " + a[i-1]);
            }
        }           
    }
    
    @Test
    public void testSort_hybrid_ins() {
        System.out.println("hybrid-ins");        
        Comparable[] a = DataFeed.readCSV(N);
        BubbleSort instance = new BubbleSort();
        instance.hybrid(new InsertionSort());        
        instance.sort(a, 0, a.length-1);
        for (int i = 1; i < a.length; i++) {
            if (a[i].compareTo(a[i-1]) < 0) {
                fail("Array was not sorted! index= " + i +  " a[i] = " + 
                        a[i] + " a[j]= " + a[i-1]);
            }
        }           
    }
    @Test
    public void testSort_hybrid_mrg() {
        System.out.println("hybrid-mrg");        
        Comparable[] a = DataFeed.readCSV(N);
        BubbleSort instance = new BubbleSort();
        instance.sort(a, 0, a.length-1);
        instance.hybrid(new MergeSort());                
        for (int i = 1; i < a.length; i++) {
            if (a[i].compareTo(a[i-1]) < 0) {
                fail("Array was not sorted! index= " + i +  " a[i] = " + 
                        a[i] + " a[j]= " + a[i-1]);
            }
        }           
    }
    @Test
    public void testSort_hybrid_qk() {
        System.out.println("hybrid-qk");        
        Comparable[] a = DataFeed.readCSV(N);
        BubbleSort instance = new BubbleSort();
        instance.hybrid(new QuickSort());                        
        instance.sort(a, 0, a.length-1);
        for (int i = 1; i < a.length; i++) {
            if (a[i].compareTo(a[i-1]) < 0) {
                fail("Array was not sorted! index= " + i +  " a[i] = " + 
                        a[i] + " a[j]= " + a[i-1]);
            }
        }           
    }
    
    

}
