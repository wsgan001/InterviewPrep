package org.practice.string;

import java.util.*;

public class DistinctSubstring {
    public static void distinctSubstrs(String str) {
        List<String> list = new ArrayList<String>();
        for(int i=0; i<str.length();i++) {
            for(int j=1; j<=str.length()-i;j++) {
                String substr = str.substring(i, i+j);
                list.add(substr);
            }
        }

        Set<String> set = new HashSet<String>();
        set.addAll(list); //Adding to set to remove duplicates
        list.clear();
        list.addAll(set);

        System.out.println("Total no of substrings are: "+list.size());
        System.out.println("Substrings are: ");
        for(String s: list) {
            System.out.print(s + " ");
        }
    }
    public static void main(String args[]) {
        distinctSubstrs("aaaa");
    }
}
