package org.practice.array;

//Ola Interview: Rotate an array k times. Time Complexity: O(n), Space Complexity: O(1)
//logic:
// 1. Divide an array into 2 parts based on k
//2. Reverse first part
//3. Reverse second part
//4. Reverse whole array
public class RotateArray {
    public static void rotate(int[] a, int k) {
        if(a == null || k == 0) {
            throw new IllegalArgumentException("Wrong Argument");
        }

        int firstPartLen = a.length - k;
        reverse(a, 0, firstPartLen-1);
        reverse(a, firstPartLen, a.length-1);
        reverse(a, 0, a.length-1);
    }

    public static void reverse (int[]a, int left, int right) {
        if(a == null || a.length ==1) {
            return;
        }

        while(left<right) {
            int temp = a[left];
            a[left] = a[right];
            a[right] = temp;
            left++;
            right--;
        }
    }
    public static void main(String args[]) {
        int[] a = new int[] {1,2,3,4,5,6};
        rotate(a, 4);
        for(int x: a) {
            System.out.print(x+" ");
        }

    }

}
