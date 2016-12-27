package org.practice.array;

//Maximum difference between two elements such that larger element appears after the smaller number
public class MaximumPositiveDifference {
    public static int maxDiff(int[] a) {
        int max_diff = a[1] - a[0];
        int min_element = a[0];
        int i;
        for(i =1; i <a.length; i++) {
            if(a[i]-min_element > max_diff) {
                max_diff = a[i]-min_element;
            }
            if(a[i] < min_element) {
                min_element = a[i];
            }
        }
        return max_diff;
    }
    public static void main(String args[]) {
        int arr[] = {1, 2, 6, 80, 100};
        System.out.println("Maximum positive difference is: "+maxDiff(arr));
    }
}
