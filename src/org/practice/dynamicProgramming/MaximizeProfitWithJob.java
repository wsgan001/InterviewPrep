package org.practice.dynamicProgramming;

import java.util.Comparator;
import java.util.*;

class Job {
    int start;
    int end;
    int profit;

    Job(int start,int end,int profit){
        this.start= start;
        this.end = end;
        this.profit= profit;
    }
}

class FinishTimeComparator implements Comparator<Job> {
    @Override
    public int compare(Job ob1, Job ob2) {
        return ob1.end - ob2.end;
    }
}

/**
 * http://www.cs.princeton.edu/courses/archive/spr05/cos423/lectures/06dynamic-programming.pdf
 * Given set of jobs with start and end interval and profit, how to maximize profit such that
 * jobs in subset do not overlap.
 */
public class MaximizeProfitWithJob {
    /**
     * Sort the jobs by finish time.
     * For every job find the first job which does not overlap with this job
     * and see if this job profit plus profit till last non overlapping job is greater
     * than profit till last job.
     * @param jobs
     * @return
     */
    public int maximizeDynamic(Job[] jobs){
        int T[] = new int[jobs.length];
        FinishTimeComparator comparator = new FinishTimeComparator();
        Arrays.sort(jobs, comparator);

        T[0] = jobs[0].profit;
        for(int i=1; i < jobs.length; i++){
            T[i] = Math.max(jobs[i].profit, T[i-1]);
            for(int j=i-1; j >=0; j--){
                if(jobs[j].end < jobs[i].start){
                    T[i] = Math.max(T[i], jobs[i].profit + T[j]);
                    break;
                }
            }
        }
        return T[jobs.length-1];
    }
    public static void main(String args[]){
        Job jobs[] = new Job[6];
        jobs[0] = new Job(1,3,5);
        jobs[1] = new Job(2,5,6);
        jobs[2] = new Job(4,6,5);
        jobs[3] = new Job(6,7,6);
        jobs[4] = new Job(11,15,3);
        jobs[5] = new Job(7,9,4);
        MaximizeProfitWithJob mp = new MaximizeProfitWithJob();
        System.out.println(mp.maximizeDynamic(jobs));
    }

}
