package org.practice.array;

//Given an array that contains both positive and negative integers, find the product of the maximum product subarray.
// Expected Time complexity is O(n) and only O(1) extra space can be used.

public class MaximumContiguousProduct {
    public static int findMaxProduct(int[] a) {
        int n = a.length;
        int min_ending_here = 1, max_ending_here = 1;
        int max_so_far = 1;
        for(int i = 0; i < n ; i++) {
            if(a[i] > 0) {
                max_ending_here = max_ending_here * a[i];
                min_ending_here = Math.min(min_ending_here * a[i], 1);
            } else if(a[i] == 0) {
                max_ending_here = 1;
                min_ending_here = 1;
            } else {
                int temp = max_ending_here;
                max_ending_here = Math.max(min_ending_here * a[i], 1);
                min_ending_here = temp * a[i];
            }
            max_so_far = Math.max(max_so_far, max_ending_here);
        }
        return max_so_far;
    }

    public static void main(String args[]) {
        int arr[] = {1, -2, -3, 0, 7, -8, -2};
        System.out.println(findMaxProduct(arr));
    }
}
