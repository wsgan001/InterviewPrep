package org.practice.string;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.*;


public class FirstNonRepeatedCharacter {

    //Find first non repeated character in a string
    public static char firstNonRepeatedCharacter(String str) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i =0; i<str.length(); i++) {
            char c = str.charAt(i);
            if(map.containsKey(c)) {
                map.put(c, map.get(c)+1);
            } else {
                map.put(c,1);
            }
        }

        for(int i =0; i<str.length(); i++) {
            char c = str.charAt(i);
            if (map.get(c) == 1) {
                return c;
            }
        }
        return 0;

    }

    //Find first non repeated character in a stream of characters
    public static void firstNonRepeating() {
        // Let us consider following stream and see the process
        String inputString = "geegeks";
        Set<Character> repeatingSet = new HashSet<Character>();
        List<Character> nonRepeatingList = new ArrayList<Character>();
        for (char c : inputString.toCharArray()) {
            System.out.println("Reading "+c+" from stream");
            if(repeatingSet.contains(c))
                continue;

            if(nonRepeatingList.contains(c)) {
                nonRepeatingList.remove((Character)c);
                repeatingSet.add(c);
            } else {
                nonRepeatingList.add(c);
            }

            if(nonRepeatingList.isEmpty() == false) {
                System.out.println("First non-repeating character so far is "+nonRepeatingList.get(0));
            }
        }
    }
    public static void main(String args[]) {
        //System.out.println(firstNonRepeatedCharacter("simplest"));
        firstNonRepeating();
    }
}
