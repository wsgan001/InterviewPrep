package org.practice.array;

//Print k largest element from n sorted array
//Time complexity: O((n-k)*k)
public class KLargestElements {
    public static void kLargest(int[] a, int k) {
        // Using a temporary array - similar to Min heap method for kth largest
        int[] temp = new int[k];
        for(int i = 0; i < k;i++) {
            temp[i] = a[i];
        }

        for(int i = k ; i<a.length;i++) {
            int min = Integer.MAX_VALUE;
            int minIndex = 0;
            for(int j = 0; j<temp.length;j++) {
                if(min > temp[j]) {
                    min = temp[j];
                    minIndex = j;
                }
            }
            if(a[i] > min) {
                temp[minIndex] = a[i];
            }
        }

        System.out.println(k+" largest numbers are: ");
        for(int x : temp){
            System.out.print(x + " ");
        }
    }
    public static void main(String args[]) {
        int[] array1 = {12, 3, 5, 7, 19};
        kLargest(array1, 3);
    }
}
