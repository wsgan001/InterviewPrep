package org.practice.array;

import java.util.*;

/* Amazon Interview
Given an array of numbers, arrange them in a way that yields the largest value.
For example, if the given numbers are {54, 546, 548, 60}, the arrangement 6054854654 gives the largest value
*/
public class ArrangeNumbers {
    private static class StringComparator implements Comparator<String> {
        @Override
        public int compare(String X, String Y) {
            // first append Y at the end of X
            String XY = X+Y;

            // then append X at the end of Y
            String YX = Y+X;

            // Now see which of the two formed numbers is greater
            return -XY.compareTo(YX);
        }
    }
    public static String formLargestNumber(int[] a) {
        String[] strs = new String[a.length];
        for(int i =0; i <a.length; i++) {
            strs[i] = String.valueOf(a[i]);
        }
        Arrays.sort(strs, new StringComparator());

        StringBuilder sb = new StringBuilder();
        for(String s: strs) {
            sb.append(s);
        }

        while(sb.charAt(0)=='0' && sb.length()>1){
            sb.deleteCharAt(0);
        }

        return sb.toString();
    }
    public static void main(String args[]) {
        int[] a = {54, 546, 548, 60};
        System.out.println("Largest number formed is: "+formLargestNumber(a));
    }
}
