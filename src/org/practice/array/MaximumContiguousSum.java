package org.practice.array;

// Linkedin Telephonic
public class MaximumContiguousSum {
    public static int maxSum(int[] a) {
        int max_so_far = a[0];
        int curr_max = a[0];
        for(int i = 1; i < a.length; i++) {
            curr_max = Math.max(a[i], curr_max+a[i]);
            max_so_far = Math.max(max_so_far, curr_max);
        }
        return max_so_far;
    }
    public static void main(String args[]) {
        int a[] =  {-2, -3, 4, -1, -2, 1, 5, -3};
        System.out.print(maxSum(a));
    }
}
