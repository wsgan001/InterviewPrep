package org.practice.array;

/**
 * Created by priyasingh on 9/25/15.
 */
//Given a number n, print following pattern without using any loop.
//Input: n = 16
     //   Output: 16, 11, 6, 1, -4, 1, 6, 11, 16

public class PrintPattern {
    static void print(int n){

        // Base case (When n becomes 0 or negative)
        if (n ==0 || n<0)
        {
            System.out.println(n);
            return;
        }

        // First print decreasing order
        System.out.println(n);
        print(n - 5);

        // Then print increasing order
        System.out.println(n);

    }
    public static void main(String args[]) {
        print(16);
    }
}
