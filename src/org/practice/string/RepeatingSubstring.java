package org.practice.string;

import java.util.*;
/* Linkedin Interview Question
Find all the repeating sub-string sequence of specified length in a large string sequence.
The sequences returned i.e. the output must be sorted alphabetically.

        For e.g.

        Input String: "ABCACBABC"
        repeated sub-string length: 3

        Output: ABC
*/
public class RepeatingSubstring {
    public static void repeatedSubstring(String s, int k) {
        Set<String> set = new HashSet<String>();
        for(int i = 0; i+k <= s.length(); i++) {
            if(set.contains(s.substring(i, i+k))) {
                System.out.print(s.substring(i, i+k)+" ");
            }
            set.add(s.substring(i, i+k));
        }
    }

    public static void main(String args[]) {
        String s = "ABCACBABCA";
        repeatedSubstring(s, 3);
    }
}
