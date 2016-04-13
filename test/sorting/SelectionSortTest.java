package sorting;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import utilities.DataFeed;

/**
 * This test class should be used as a template!
 * @author Connor
 */
public class SelectionSortTest {
    
    public static final String N = "100.csv";    
    
    public SelectionSortTest() {
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
     * Test of sort method, of class SelectionSort.
     */
    @Test
    public void testSort_GenericType() {
        System.out.println("sort-parent");
        Comparable[] a = DataFeed.readIntCSV(N);
        SelectionSort instance = new SelectionSort();
        instance.sort(a);
        for (int i = 1; i < a.length; i++) {
            if (a[i].compareTo(a[i-1]) < 0) {
                fail(getResponse(a, i));
            }
        }
    }

    /**
     * Test of sort method, of class SelectionSort.
     */
    @Test
    public void testSort_3args() {
        System.out.println("sort-child");
        Comparable[] a = DataFeed.readIntCSV(N);
        SelectionSort instance = new SelectionSort();
        instance.sort(a, 0, a.length-1);
        for (int i = 1; i < a.length; i++) {
            if (a[i].compareTo(a[i-1]) < 0) {
                fail(getResponse(a, i));
            }
        }        
    }
    
    @Test
    public void testSort_hybrid_bub() {
        System.out.println("hybrid-bub");
        Comparable[] a = DataFeed.readIntCSV(N);
        SelectionSort instance = new SelectionSort();
        instance.hybrid(new BubbleSort());
        instance.sort(a, 0, a.length-1);
        for (int i = 1; i < a.length; i++) {
            if (a[i].compareTo(a[i-1]) < 0) {
                fail(getResponse(a, i));
            }
        }           
    }
    
    @Test
    public void testSort_hybrid_ex() {
        System.out.println("hybrid-ex");        
        Comparable[] a = DataFeed.readIntCSV(N);
        SelectionSort instance = new SelectionSort();
        instance.hybrid(new ExchangeSort());        
        instance.sort(a, 0, a.length-1);
        for (int i = 1; i < a.length; i++) {
            if (a[i].compareTo(a[i-1]) < 0) {
                fail(getResponse(a, i));
            }
        }           
    }
    
    @Test
    public void testSort_hybrid_ins() {
        System.out.println("hybrid-ins");        
        Comparable[] a = DataFeed.readIntCSV(N);
        SelectionSort instance = new SelectionSort();
        instance.hybrid(new InsertionSort());        
        instance.sort(a, 0, a.length-1);
        for (int i = 1; i < a.length; i++) {
            if (a[i].compareTo(a[i-1]) < 0) {
                fail(getResponse(a, i));
            }
        }           
    }
    @Test
    public void testSort_hybrid_mrg() {
        System.out.println("hybrid-mrg");        
        Comparable[] a = DataFeed.readIntCSV(N);
        SelectionSort instance = new SelectionSort();
        instance.sort(a, 0, a.length-1);
        instance.hybrid(new MergeSort());                
        for (int i = 1; i < a.length; i++) {
            if (a[i].compareTo(a[i-1]) < 0) {
                fail(getResponse(a, i));
            }
        }           
    }
    @Test
    public void testSort_hybrid_qk() {
        System.out.println("hybrid-qk");        
        Comparable[] a = DataFeed.readIntCSV(N);
        SelectionSort instance = new SelectionSort();
        instance.hybrid(new QuickSort());                        
        instance.sort(a, 0, a.length-1);
        for (int i = 1; i < a.length; i++) {
            if (a[i].compareTo(a[i-1]) < 0) {
                fail("Failure!" + getResponse(a, i));
            }
        }           
    }
    
    private String getResponse(Comparable[] a, int i) {
        String response = "Index: " + i + " a[i-1]= " + a[i-1] + " a[i] = " + a[i];
        for (Comparable a1 : a) {
            response += Integer.toString((Integer) a1) + ",";
            
        }        
        return response;
    }
    

}
