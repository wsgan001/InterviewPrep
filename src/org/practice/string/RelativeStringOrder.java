package org.practice.string;

import java.util.HashMap;
import java.util.Map;

//Uber Interview question
//Given an input string and ordering string, need to return true if the ordering string is present in Input string.
public class RelativeStringOrder {

    public static void main(String args[]) {
        String input ="aaaabbbcccc";
        String order ="ca";
        boolean ordered = isStringOrdered(input,order);
        System.out.println("The given String is ordered: "+ordered);
    }

    private static boolean isStringOrdered(String input, String order) {
        Map<Character, Integer> orderMap = new HashMap<>();
        for(int i =0; i < input.length(); i++) {
            orderMap.put(input.charAt(i), i);
        }

        for(int i =0; i <order.length()-1; i++) {
            if(orderMap.get(order.charAt(i)) > orderMap.get(order.charAt(i+1))) {
                return false;
            }
        }
        return true;
    }
}
