package org.practice.array;

/* Linkedin Interview question
Given a list of tuples representing intervals, return the range these intervals
covered.
e.g:
[(1,3), (2,5),(8,9)] should return 5
 */

import java.util.*;

class Interval {
    int start;
    int end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

class IntervalComparator implements Comparator<Interval> {
    @Override
    public int compare(Interval ob1, Interval ob2){
        return ob1.start - ob2.start;
    }
}
public class FindRangeCovered {
    public static int findRangeCovered(ArrayList<Interval> intervals) {
        if(intervals == null) {
            throw new NullPointerException();
        }

        if(intervals.size() == 0) {
            return 0;
        }
        Collections.sort(intervals, new IntervalComparator());
        int min_start = intervals.get(0).start;
        int max_end = intervals.get(0).end;
        int range =0, index = 1;
        while(index <= intervals.size()) {
            if(index == intervals.size()) {
                range += max_end - min_start;
                break;
            }
            if(max_end >= intervals.get(index).start) {
                max_end = Math.max(max_end, intervals.get(index).end);
                index++;
                continue;
            }
            range += max_end - min_start;
            max_end = intervals.get(index).end;
            min_start = intervals.get(index).start;
        }
        return range;
    }

    public static void main(String args[]) {
        Interval ob1 = new Interval(1,3);
        Interval ob2 = new Interval(2,5);
        Interval ob3 = new Interval(8,9);
        ArrayList<Interval> intervals = new ArrayList<Interval>();
        intervals.add(ob1);
        intervals.add(ob2);
        intervals.add(ob3);
        System.out.println("Range covered is: "+findRangeCovered(intervals));
    }
}
