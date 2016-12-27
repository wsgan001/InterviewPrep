package org.practice.array;

//count total no of 1s in a sorted binary array
public class CountOnes {
    public static int countOnes(int a[]) {
        int x = firstOccurence(a, 0, a.length-1);
        if(x > 0) {
            return a.length - x;
        }
        return 0;
    }

    //find first occurence of 1
    public static int firstOccurence(int a[], int low, int high) {
        if(low <=high) {
            int mid = low+(high-low)/2;
            if(a[mid] == 1 && a[mid-1] == 0) {
                return mid;
            }

            if(a[mid]== 1) {
                return firstOccurence(a, low, mid - 1);
            }
            return firstOccurence(a, mid+1, high);
        }
        return 0;
    }
    public static void main(String args[]) {
        int[] arr = new int[]{0,0,0,0, 0, 1, 1};
        System.out.println(countOnes(arr));
    }
}
