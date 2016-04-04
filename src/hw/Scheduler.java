package hw;

import java.util.ArrayList;
import java.util.Arrays;
import sorting.InsertionSort;

/**
 *
 * @author Connor
 */
public class Scheduler {
    
    public Scheduler() {
        
    }
    
    public ArrayList schedule(Job[] D) {
        Job[] jobs = D.clone();
        ArrayList<Job> j = new ArrayList();
        ArrayList<Job> k = new ArrayList();

        //sortJobs(jobs);
        j.add(getJob(jobs,1)); // add job 1        
        System.out.println("Sorted Jobs: " + Arrays.toString(jobs));
        for (int i = 1; i < jobs.length; i++) {
            // k = j with i added according to nondecreasing values of deadline[i]
           for (Job ji : j) { // Add all of j to k
               if (!k.contains(ji)) {
                   k.add(ji);
               }
            }
           System.out.println("Before: "+j.toString());           
           addJob(jobs, k, i);
            // Check if K is feasible
            System.out.println("After: "+j.toString());
            if (isFeasible(k)) {
                j = k;
            } 

        }
        return j;
    }
    
    private void addJob(Job[] jobs, ArrayList<Job> k, int i) {
        Job newJob = jobs[i];
        boolean added = false;
        for (int it = 0; it < k.size(); it++) {
            if (k.get(it).compareTo(newJob) > 0) {
                if (!added) {
                    k.add(it, newJob);
                    added = true;                    
                }
            }
        }
        if (!added) {
            k.add(newJob);
        }
    }
    
    /**
     * Convert i to primitive array index
     * @param i
     * @return 
     */
    private Job getJob(Job[] j, int i) {
        return j[i-1];
    }
    
    /**

     * @return 
     */
    private boolean isFeasible(ArrayList<Job> k) {
        boolean feasible = true;
        for (int i = 1; i < k.size()+1; i++) {
            if (i > k.get(i-1).deadline) { // i-1 is jobs to index
                feasible = false;
                k.remove(k.get(i-1));
            }
        }
        return feasible;
        
    }
    
    private static void sortJobs(Job[] jobs) {
        new InsertionSort().sort(jobs);
    }
    
    
    
}
