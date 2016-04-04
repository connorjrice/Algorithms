package hw;

import java.util.ArrayList;
import sorting.InsertionSort;

/**
 *
 * @author Connor
 */
public class Scheduler {
    
    public Scheduler() {
        
    }
    
    public static ArrayList schedule(Job[] D) {
        Job[] jobs = D.clone();
        ArrayList<Job> j = new ArrayList();
        ArrayList<Job> k = new ArrayList();
        j.add(D[0]); // add job 1
        sortJobs(jobs);
        for (int i = 2; i <= D.length; i++) {
            // k = j with i added according to nondecreasing values of deadline[i]
            for (Job ji : j) { // Add all of j
                k.add(ji);
            }
            k.add(jobs[i]);
//            k = j +
        }
        
               
        
        
        
        
        
        return j;
    }
    
    public static void sortJobs(Job[] jobs) {
        new InsertionSort().sort(jobs);
    }
    
    
    
}
