package org.practice.array;

public class AlternatingOrder {
    public static void arrange(int[] a) {
        for(int i =1; i<a.length; i++) {
            if(i%2 !=0 && a[i] < a[i-1]) {
                int temp = a[i];
                a[i] = a[i-1];
                a[i-1] = temp;
            } else if(i%2 ==0 && a[i] > a[i-1]) {
                int temp = a[i];
                a[i] = a[i-1];
                a[i-1] = temp;
            }
        }

        for(int i=0; i<a.length; i++) {
            System.out.print(a[i]+" ");
        }

    }
    public static void main(String args[]) {
        int[] a = new int[] {3, 5, 7, 8, 4, 9};
        //int[] a = new int[] {4,3,2,1};
        arrange(a);
    }
}
