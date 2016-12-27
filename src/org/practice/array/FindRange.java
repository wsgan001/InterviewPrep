package org.practice.array;

/* Linkedin Interview Question
Given a sorted array with duplicates and a number, find the range in the
        form of (startIndex, endIndex) of that number. For example,
        find_range({0 2 3 3 3 10 10}, 3) should return (2,4).
        */
public class FindRange {
    public static void findRange(int[] a, int k) {
        int low = 0, high = a.length-1, mid = 0;
        while(high >= low) {
            mid = (low+high)/2;
            if(a[mid] == k) {
                break;
            } else if(a[mid] < k) {
                low = mid+1;
            } else
                high = mid-1;
        }

        int left = mid, right = mid;
        while(right < a.length-1 && a[right+1] == k) {
            right++;
        }

        while(left > 1 && a[left-1] == k) {
            left--;
        }

        System.out.println(left+", "+right);
    }
    public static void main(String args[]) {
        int a[] = {0,2,3, 3, 3, 10, 10};
        findRange(a, 3);
    }
}
