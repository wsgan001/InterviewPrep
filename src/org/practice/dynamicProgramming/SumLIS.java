package org.practice.dynamicProgramming;

/* Amazon Interview Question
find sum of longest increasing subsequence ?
        Not the maximum sum,sum of longest subsequence.
        Eg. 1, 8,2, 3
        ans-> 6
*/
public class SumLIS {
    public static void sumLIS(int[] a) {
        int n = a.length;
        int[] t = new int[n];
        int[] sum = new int[n];

        int largest = 1, value = 1;

        for(int i = 0; i <n; i++) {
            t[i] = 1;
            sum[i] = a[i];
        }

        for(int i = 1; i < n; i++) {
            for(int j = 0; j<i; j++) {
                if(a[i] > a[j]) {
                    t[i] =  Math.max(t[i], t[j]+1);
                    sum[i] = sum[j]+a[i];

                    if(value < t[i]) {
                        value = t[i];
                        largest = i;
                    }
                }
            }
        }
        System.out.print("Sum of longest increasing subsequence: "+sum[largest]);
    }

    public static void main(String args[]) {
        int[] arr = {1, 8, 2, 3};
        sumLIS(arr);
    }
}
