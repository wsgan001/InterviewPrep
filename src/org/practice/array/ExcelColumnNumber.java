package org.practice.array;

import java.util.*;

/* Snapdeal Interview Question
Given a column title as appear in an Excel sheet, return its corresponding column number. For example:
A --> 1
B -->2
...
AA -> 27
AAA --> 703
*/

import com.sun.javaws.exceptions.InvalidArgumentException;

public class ExcelColumnNumber {
    public static int titleToNumber(String s) {
        if(s == null || s.length() == 0) {
            throw new IllegalArgumentException("Invalid Input");
        }
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        char c = 'A';
        for(int i = 1; i<=26; i++) {
            map.put(c, i);
            c += 1 ;
        }

        int result = 0;
        int i = s.length()-1;
        int t = 0;
        while(i >= 0) {
            char curr = s.charAt(i);
            result = result + (int)Math.pow(26,t) * map.get(curr);
            t++;
            i--;
        }
        return result;
    }

    public static void main(String args[]) {
        System.out.println("Column number is: "+titleToNumber("AAA"));
    }
}
