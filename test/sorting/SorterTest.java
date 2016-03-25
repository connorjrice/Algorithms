/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sorting;

import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Connor
 */
public class SorterTest {
    
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
        System.out.println("sort");
        Comparable[] a = null;
        Sorter instance = new Sorter();
        instance.sort(a);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hybrid method, of class Sorter.
     */
    @Test
    public void testHybrid_Sorter_int() {
        System.out.println("hybrid");
        Sorter _aS = null;
        int _threshold = 0;
        Sorter instance = new Sorter();
        instance.hybrid(_aS, _threshold);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hybrid method, of class Sorter.
     */
    @Test
    public void testHybrid_Sorter() {
        System.out.println("hybrid");
        Sorter _aS = null;
        Sorter instance = new Sorter();
        instance.hybrid(_aS);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeHybrid method, of class Sorter.
     */
    @Test
    public void testRemoveHybrid() {
        System.out.println("removeHybrid");
        Sorter instance = new Sorter();
        instance.removeHybrid();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getName method, of class Sorter.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Sorter instance = new Sorter();
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBench method, of class Sorter.
     */
    @Test
    public void testGetBench() {
        System.out.println("getBench");
        Sorter instance = new Sorter();
        boolean expResult = false;
        boolean result = instance.getBench();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of runHybrid method, of class Sorter.
     */
    @Test
    public void testRunHybrid() {
        System.out.println("runHybrid");
        Comparable[] a = null;
        int lb = 0;
        int ub = 0;
        Sorter instance = new Sorter();
        boolean expResult = false;
        boolean result = instance.runHybrid(a, lb, ub);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of sort method, of class Sorter.
     */
    @Test
    public void testSort_3args() {
        System.out.println("sort");
        Comparable[] a = null;
        int lb = 0;
        int ub = 0;
        Sorter instance = new Sorter();
        instance.sort(a, lb, ub);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of swap method, of class Sorter.
     */
    @Test
    public void testSwap() {
        System.out.println("swap");
        Comparable[] a = null;
        int i = 0;
        int j = 0;
        Sorter instance = new Sorter();
        boolean expResult = false;
        boolean result = instance.swap(a, i, j);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of start method, of class Sorter.
     */
    @Test
    public void testStart() {
        System.out.println("start");
        Sorter instance = new Sorter();
        instance.start();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of end method, of class Sorter.
     */
    @Test
    public void testEnd() {
        System.out.println("end");
        Comparable[] a = null;
        Sorter instance = new Sorter();
        instance.end(a);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setBench method, of class Sorter.
     */
    @Test
    public void testSetBench() {
        System.out.println("setBench");
        boolean b = false;
        Sorter instance = new Sorter();
        instance.setBench(b);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of sendComparison method, of class Sorter.
     */
    @Test
    public void testSendComparison() {
        System.out.println("sendComparison");
        Sorter instance = new Sorter();
        instance.sendComparison();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of reset method, of class Sorter.
     */
    @Test
    public void testReset() {
        System.out.println("reset");
        Sorter instance = new Sorter();
        instance.reset();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getArray method, of class Sorter.
     */
    @Test
    public void testGetArray() {
        System.out.println("getArray");
        Sorter instance = new Sorter();
        Object[] expResult = null;
        Object[] result = instance.getArray();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
