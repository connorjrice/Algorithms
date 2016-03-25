package sorting;

import java.util.logging.Logger;
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
public class SorterTest {
    
    public static final String N = "100.csv";    
    public static final Comparable[] A = DataFeed.readCSV(N);            
    
    public SorterTest() {
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
     * Test of sort method, of class Sorter.
     */
    @Test
    public void testSort_GenericType() {
        System.out.println("sort-parent");
        Comparable[] a = A.clone();
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
     * Test of hybrid method, of class Sorter.
     */
    @Test
    public void testHybrid_Sorter_int() {
        System.out.println("hybrid-threshold");
        Comparable[] a = A.clone();
        MergeSort instance = new MergeSort();
        instance.hybrid(new ExchangeSort(), 10);
        instance.sort(a);
        for (int i = 1; i < a.length; i++) {
            if (a[i].compareTo(a[i-1]) < 0) {
                fail("Array was not sorted! index= " + i +  " a[i] = " + 
                        a[i] + " a[j]= " + a[i-1]);                
            }
        }         
        assertTrue(instance.threshold == 10);
    }

    /**
     * Test of hybrid method, of class Sorter.
     */
    @Test
    public void testHybrid_Sorter() {
        System.out.println("hybrid-default");

        Comparable[] a = A.clone();
        MergeSort instance = new MergeSort();
        instance.hybrid(new ExchangeSort());
        instance.sort(a);
        for (int i = 1; i < a.length; i++) {
            if (a[i].compareTo(a[i-1]) < 0) {
                fail("Array was not sorted! index= " + i +  " a[i] = " + 
                        a[i] + " a[j]= " + a[i-1]);                
            }
        }         
        assertTrue(instance.threshold == 7);
    }

    /**
     * Test of removeHybrid method, of class Sorter, when there is NO hybrid
     * attached.
     */
    @Test
    public void testRemoveHybridNoHybrid() {
        System.out.println("removeHybrid-noHybrid");
        Comparable[] a = A.clone();
        MergeSort instance = new MergeSort();
        instance.removeHybrid();
        instance.sort(a);
        for (int i = 1; i < a.length; i++) {
            if (a[i].compareTo(a[i-1]) < 0) {
                fail("Array was not sorted! index= " + i +  " a[i] = " + 
                        a[i] + " a[j]= " + a[i-1]);                
            }
        }         
        assertTrue(instance.threshold == -1);             
    }
    
    /**
     * Test of removeHybrid method, of class Sorter, when there is a hybrid
     * attached.
     */
    @Test
    public void testRemoveHybridWithHybrid() {

        System.out.println("removeHybrid-noHybrid");
        Comparable[] a = A.clone();
        MergeSort instance = new MergeSort();
        instance.hybrid(new BubbleSort());
        instance.removeHybrid();
        instance.sort(a);
        for (int i = 1; i < a.length; i++) {
            if (a[i].compareTo(a[i-1]) < 0) {
                fail("Array was not sorted! index= " + i +  " a[i] = " + 
                        a[i] + " a[j]= " + a[i-1]);                
            }
        }         
    }    

    /**
     * Test of getName method, of class Sorter.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Sorter instance = new Sorter();
        String expResult = "DefaultSorter";
        String result = instance.getName();
        assertEquals(expResult, result);

    }

    /**
     * Test of getBench method, of class Sorter.
     */
    @Test
    public void testGetBench() {
        System.out.println("getBench");
        Sorter instance = new Sorter();
        boolean expResult = true;
        boolean result = instance.getBench();
        assertEquals(expResult, result);
    }

    /**
     * Test of runHybrid method, of class Sorter.
     */
    @Test
    public void testRunHybrid() {
        System.out.println("runHybrid");
        Comparable[] a = DataFeed.readCSV("10000.csv");
        Sorter instance = new Sorter();
        instance.hybrid(new Sorter());
        boolean expResult = false;
        boolean result = instance.runHybrid(a, 0, a.length-1);
        assertEquals(expResult, result);
    }

    /**
     * Test of sort method, of class Sorter.
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

    /**
     * Test of swap method, of class Sorter.
     */
    @Test
    public void testSwap() {
        System.out.println("swap");
        Comparable[] a = new Integer[]{1,0};
        Sorter instance = new Sorter();
        boolean expResult = true;
        boolean result = instance.swap(a, 0, 1);
        assertEquals(expResult, result);
    }

    /**
     * Test of start method, of class Sorter.
     */
    @Test
    public void testStart() {
        System.out.println("start");
        Sorter instance = new Sorter(new String[]{"-b"});
        instance.start();
        assertTrue(instance.getBench());
    }

    /**
     * Test of end method, of class Sorter.
     */
    @Test
    public void testEnd() {
        System.out.println("end");
        Comparable[] a = DataFeed.readCSV("10000.csv");
        Sorter instance = new Sorter();
        instance.sort(a, 0, a.length-1);
        for (int i = 1; i < a.length; i++) {
            if (a[i].compareTo(a[i-1]) < 0) {
                fail("Array was not sorted! index= " + i +  " a[i] = " + 
                        a[i] + " a[j]= " + a[i-1]);
            }
        }               
        instance.end(a);
        assertTrue(instance.numComparisons == 0);
        assertTrue(instance.finalComparisons.equals(""));
        assertTrue(instance.startTime == 0);
        assertTrue(instance.endTime == 0);        
        
 
    }

    /**
     * Test of getComparisons method, of class Sorter.
     */
    @Test
    public void testGetComparisons() {
        System.out.println("getComparisons");
        Sorter instance = new Sorter();
        int expResult = 0;
        int result = instance.getComparisons();
        assertEquals(expResult, result);
    }

    /**
     * Test of setBench method, of class Sorter.
     */
    @Test
    public void testSetBench() {
        System.out.println("setBench");
        boolean b = false;
        Sorter instance = new Sorter();
        assertTrue(instance.getBench());
        instance.setBench(b);
        assertTrue(!instance.getBench());        
    }

    /**
     * Test of sendComparison method, of class Sorter.
     */
    @Test
    public void testSendComparison() {
        System.out.println("sendComparison");
        Sorter instance = new Sorter();
        assertTrue(instance.numComparisons == 0);
        instance.sendComparison();
        assertTrue(instance.numComparisons == 1);        
    }

    /**
     * Test of reset method, of class Sorter.
     */
    @Test
    public void testReset() {
        System.out.println("reset");
        Sorter instance = new Sorter();
        instance.sort(DataFeed.readCSV(N));
        instance.reset();
        assertTrue(instance.numComparisons == 0);
        assertTrue(instance.startTime == 0);
        assertTrue(instance.endTime == 0);        
    }


    /**
     * Test of getLogger method, of class Sorter.
     */
    @Test
    public void testGetLogger() {
        System.out.println("getLogger");
        Sorter instance = new Sorter();
        Logger expResult = null;
        Logger result = instance.getLogger();
        assertNotEquals(expResult, result);
    }
    
}
