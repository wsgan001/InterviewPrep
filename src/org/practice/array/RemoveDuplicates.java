package org.practice.array;

import java.util.Arrays;

//Amazon interview Question
//Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
public class RemoveDuplicates {
    public static int[] removeDup(int[] A) {
        if(A.length < 2) {
            return A;
        }
        int j =0, i = 1;
        while(i < A.length) {
            if(A[i] == A[j]) {
                i++;
            } else {
                j++;
                A[j] = A[i];
                i++;
            }
        }
        int[] B = Arrays.copyOf(A, j+1);
        return B;
    }
    public static void main(String args[]) {
        int[] arr = { 1, 2, 2, 3, 3 };
        arr = removeDup(arr);
        System.out.print(arr.length);
    }
}
