package graph;

import graph.Job;
import java.util.ArrayList;
import java.util.Arrays;
import sorting.InsertionSort;

/**
 * Chapter 4, number 22
 * @author Connor
 */
public class Scheduler {
    
    public ArrayList<Job> j = new ArrayList();
    public ArrayList<Job> k = new ArrayList();    
    
    public Scheduler() {
        
    }
    
    public ArrayList schedule(Job[] D) {
        Job[] jobs = D.clone();

        //sortJobs(jobs);
        j.add(getJob(jobs,1)); // add job 1       
        k.add(getJob(jobs,1)); // k = j;      
        
        System.out.println("Sorted Jobs: " + Arrays.toString(jobs));
        for (int i = 1; i < jobs.length; i++) {
            // k = j with i added according to nondecreasing values of deadline[i]
           addJob(jobs, k, i);
            // Check if K is feasible
            if (isFeasible(k)) {
                j = (ArrayList<Job>) k.clone();
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
