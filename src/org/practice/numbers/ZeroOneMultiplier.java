package org.practice.numbers;

/*Bank bazaar online test
 * An integer whose base-ten representation consists only of zero and one is called a "zero-one" (ie binary nubmers)
 * Given an integer N, find the string S that represents the smallest positive "zero-one"
 * which is a multiple of N. (Every N has atleast one S)
 *
 * Constraint:
 * 0 < N < 100,000
 * S should be a zero-one integer and there should be no leading zeroes
 *
 * Example:
 * N = 4 => 100
 * N = 7 => 1001
 * */

public class ZeroOneMultiplier {
    static String zero_one(int num) {
        int i = 1;
        while(true) {
            // Convert to binary
            String s = Integer.toBinaryString(i);

            // Convert to int
            int divider = Integer.parseInt(s);

            // Check if number is divisible
            if(divider % num == 0) {
                return String.valueOf(divider);
            }
            i++;
        }
    }

    public static void main(String ags[]) {
        System.out.println(zero_one(7));
    }
}
