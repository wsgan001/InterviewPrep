package org.practice.numbers;

/** Bankbazaar online test
 * check if a number can be expressed as x raised to power y
 * http://www.geeksforgeeks.org/check-if-a-number-can-be-expressed-as-xy-x-raised-to-power-y/
 * @author kumari.singh
 */
public class SuperPower {
    static int superPower(int z) {
        if(z <=1 ) {
            return 1;
        }

        for(int x = 2; x <= Math.sqrt(z); x++) {
            int p = x;

            while( p <= z) {
                p = p*x;

                if(p == z) {
                    return 1;
                }
            }
        }
        return 0;
    }

    public static void main(String args[]) {
        System.out.println(superPower(26));

    }
}
