package org.practice.numbers;

import java.util.*;

public class
NextGreater {
    public static void findNext(char number[]) {
        int n = number.length, i, j;

        // 1) Start from the right most digit and find the first digit that is
        // smaller than the digit next to it.
        for(i = n-1; i > 0; i--) {
            if(number[i] > number[i-1])
                break;
        }

        if(i == 0) {
            System.out.println("No such number possible");
            return ;
        }

        // 2) Find the smallest digit on right side of (i-1)'th digit that is
        // greater than number[i-1]

        int x = number[i-1], smallest =i;
        for(j = i+1; j<n; j++) {
            if(number[j] > x && number[j] < number[smallest])
                smallest = j;
        }

       // 3) Swap the above found smallest digit with number[i-1]
        char temp = number[smallest];
        number[smallest] = number[i-1];
        number[i-1] = temp;

        // 4) Sort the digits after (i-1) in ascending order
        Arrays.sort(number, i, n);
        System.out.println("Next number with the same set of digits is "+ new String(number));
    }

    public static void main(String args[]) {
        findNext("1234".toCharArray());
    }
}
