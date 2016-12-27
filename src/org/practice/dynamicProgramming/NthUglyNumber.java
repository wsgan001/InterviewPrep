package org.practice.dynamicProgramming;

/*Ugly numbers are numbers whose only prime factors are 2, 3 or 5. The sequence
        1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 15, …
        shows the first 11 ugly numbers. By convention, 1 is included.
        Write a program to find and print the 150’th ugly number.
        */
public class NthUglyNumber {
    private static int getMin(int a, int b , int c) {
        int d = a<b?a:b;
        return d<c?d:c;
    }
    public static int getNthUglyNo(int n) {
        int[] ugly = new int[n];
        int i2=0, i3=0, i5=0;
        int next_multiple_of_2 = 2;
        int next_multiple_of_3 = 3;
        int next_multiple_of_5 = 5;
        ugly[0] = 1;
        int next_ugly_no = 1;
        for(int i = 1; i < n; i++) {
            next_ugly_no = getMin(next_multiple_of_2, next_multiple_of_3, next_multiple_of_5);
            ugly[i] = next_ugly_no;

            if(next_ugly_no == next_multiple_of_2) {
                i2++;
                next_multiple_of_2 = ugly[i2]*2;
            }
            if(next_ugly_no == next_multiple_of_3) {
                i3++;
                next_multiple_of_3 = ugly[i3]*3;
            }
            if(next_ugly_no == next_multiple_of_5) {
                i5++;
                next_multiple_of_5 = ugly[i5]*5;
            }

        }
        return next_ugly_no;
    }

    public static void main(String args[]) {
        System.out.println("Nth ugly no is "+getNthUglyNo(150));
    }
}
