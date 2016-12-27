package org.practice.array;

// program to find minimum element in a sorted and rotated array. Time Complexity: O(logn)
public class MinimumInPivotedArray {
    public static int findMin(int[] a, int low, int high) {
        if(high < low) {
            return a[0];
        }

        if(high == low) {
            return a[low];
        }

        int mid = (low+high)/2;
        if(mid < high && a[mid+1] < a[mid]) {
            return a[mid+1];
        }

        if(mid > low && a[mid] < a[mid-1]) {
            return a[mid];
        }

        if(a[high] > a[mid]) {
            return findMin(a, low, mid-1);
        }

       return findMin(a, mid+1, high);
    }

    public static void main(String args[]){
        int[] a = new int[]{3,4,5,6,1,2};
       // int[] a = new int[]{3,3,1};
        System.out.println(findMin(a, 0, 5));
    }
}
