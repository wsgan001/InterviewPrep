package org.practice.array;

//Fnd all repeating elements in O(n) and O(1)
public class RepeatingElements {
    public static void printRepeating(int[] a) {
        int i;
        System.out.println("The repeating elements are: \n");
        for (i = 0; i < a.length; i++)
        {
            if (a[Math.abs(a[i])] >= 0)
                a[Math.abs(a[i])] = -a[Math.abs(a[i])];
            else
                System.out.print(Math.abs(a[i])+" ");
        }
        System.out.println();
        for(i =0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }
    }
    public static void main(String args[]) {
        int[] a = new int[] {1, 2, 3, 1, 3, 6, 6};
        printRepeating(a);
    }
}
