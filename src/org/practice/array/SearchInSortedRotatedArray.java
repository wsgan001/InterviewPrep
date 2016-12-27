package org.practice.array;

// Amazon Interview Question
//An element in a sorted array can be found in O(log n) time via binary search.
//But suppose we rotate an ascending order sorted array at some pivot unknown to you beforehand.
// So for instance, 1 2 3 4 5 might become 3 4 5 1 2. Devise a way to find an element in the rotated array in O(log n) time.
public class SearchInSortedRotatedArray {
    public static int pivotedBinarySearch(int a[], int key) {
        int pivot = findPivot(a, 0, a.length-1);
        if(pivot == -1) {
            return binarySearch(a, 0, a.length-1, key);
        }

        if(a[pivot] == key) {
            return pivot;
        }

        if(a[0] <= key) {
            return binarySearch(a, 0, pivot-1, key);
        }
        return binarySearch(a, pivot+1, a.length-1, key);
    }

    public static int findPivot(int a[], int low, int high) {
        if(high < low) {
            return -1;
        }

        if(high == low) {
            return low;
        }

        int mid = (low+high)/2;

        if(mid < high && a[mid+1] < a[mid]) {
            return mid;
        }

        if(mid > low && a[mid] < a[mid-1]) {
            return mid-1;
        }

        if(a[low]>=a[mid]) {
            return findPivot(a, low, mid-1);
        }
        return findPivot(a, mid+1, high);
    }

    public static int binarySearch(int a[], int low, int high, int key) {
        if(high < low) {
            return -1;
        }
        int mid = (low+high)/2;

        if(key  == a[mid]) {
            return mid;
        }

        if(key > a[mid]) {
            return binarySearch(a, mid+1, high, key);
        }
        return binarySearch(a, low, mid-1, key);
    }

    public static void main(String args[]) {
        int[] arr = new int[]{5, 6, 7, 8, 9, 10, 1, 2, 3};
        System.out.println(pivotedBinarySearch(arr, 8));

    }
}
