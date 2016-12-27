package org.practice.dynamicProgramming;

/** Amazon Interview
 * There are n workers and their wages are given for each day in an array.
 * If a worker work on day 1, he can only work after k day i.e 1+kth day.
 * Choose the day in such a way that he can maximize profit.
 * Dynamic Programming Approach : O(n) solution
 */
public class MaximizeWage {
    public static int findMaximumProfit(int[] a, int k) {
        int[] sum = new int[a.length];

        //sum[i] will represent maximum profit that we can make till ith day
        sum[0] = a[0];
        int i;
        for(i =1; i<=k;i++) {
            sum[i] = sum[i-1];
        }

        for(;i<a.length;i++) {
            sum[i] = Math.max(sum[i-1], a[i]+sum[i-k-1]);
        }
        return sum[a.length-1];
    }
    public static void main(String args[]) {
        int[] wages = {5,1,1,10,20,2,3,6};
        System.out.println("Maximum profit which can be made is Rs"+findMaximumProfit(wages, 2));
    }
}
