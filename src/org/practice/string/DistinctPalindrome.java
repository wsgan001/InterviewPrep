package org.practice.string;
import java.util.*;

//Find total no of distict plaindromes
public class DistinctPalindrome {
    public static void findPalindromeSubStrs(String str) {
        int low, high;
        HashMap<String, Integer>map = new HashMap<String, Integer>();

        //Put all single characters in map
        for(int i=0; i<str.length();i++) {
            map.put(String.valueOf(str.charAt(i)), 1);
        }

        for(int i=1; i <str.length();i++) {
            //generate all even length palindromes and put them in map
            low = i-1;
            high = i;
            while(low >=0 && high < str.length() && str.charAt(low) == str.charAt(high)) {
                String even = str.substring(low, high+1);
                if(map.get(even) == null)
                    map.put(even, 1);

                --low;
                ++high;
            }

            //generate all odd length palindromes and put them in map
            low = i-1;
            high = i+1;
            while(low >=0 && high < str.length() && str.charAt(low) == str.charAt(high)) {
                String odd = str.substring(low, high+1);
                if(map.get(odd) == null)
                    map.put(odd, 1);

                --low;
                ++high;
            }
        }
        System.out.println("the number of distinct palindromes is: " + map.size());
        for(Map.Entry<String, Integer> entry: map.entrySet()) {
            System.out.println(entry.getKey());
        }
    }

    public static void main(String args[])throws Exception{
        findPalindromeSubStrs("abaaa");
    }
}
