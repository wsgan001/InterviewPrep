package org.practice.array;//Given n sets each containing m integers. You need to create MinDiff set by picking exactly 1 element from each set.
// The difference between the maximum and minimum elements in the MinDiff set should be minimum.
// eg: for the sets {30, 20, 10, 40},{ 22, 33, 44, 99},{ 16, 17, 18, 19} min diff set is {19, 20, 22}.
// Max and min elements in MinDiff set are 22 and 19 and their difference is 3.

import java.util.Arrays;

public class MaxMinDifference {
    public static int min(int a, int b, int c) {
        int d = a<b?a:b;
        return d<c?d:c;
    }

    public static int max(int a, int b, int c) {
        int d = a>b?a:b;
        return d>c?d:c;
    }
    public static void main(String args[]) {
        int arr1[] = {4, 10, 15};
        int arr2[] = {1, 13, 29};
        int arr3[] = {5, 14, 28};
        int size1 = arr1.length;
        int size2 = arr2.length;
        int size3 = arr3.length;

        int i=0,j=0,k=0; int[] out = new int[size1];
        int min_diff = Integer.MAX_VALUE;
        while(i<size1 && j<size2 && k<size3){
            int l = arr1[i];
            int m = arr2[j];
            int n = arr3[k];
            if(max(l,m,n) - min(l,m,n) < min_diff) {
                min_diff = max(l,m,n) - min(l,m,n);
                out[0]=l;
                out[1]=m;
                out[2]=n;
            }
            if(min(l,m,n) == l)
                i++;
            else if(min(l,m,n) == m)
                j++;
            else
                k++;
        }
        System.out.println("Min difference is "+min_diff);
        for(int x: out) {
            System.out.print(x+ ", ");
        }
    }
}
