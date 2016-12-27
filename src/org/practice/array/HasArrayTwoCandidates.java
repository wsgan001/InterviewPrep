package org.practice.array;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

//Given an array a[] and a sum , check for all pairs in a[] with given sum
public class HasArrayTwoCandidates {
    public static void findPairs(int a[], int sum) {
        HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();

        for(int i=0; i<a.length; i++) {
            map.put(sum-a[i], true);
        }

        for(int i=0; i<a.length; i++) {
            if(map.containsKey(a[i]) && map.get(a[i])) {
                System.out.println("Pair with sum "+sum+" are "+a[i]+" and "+(sum-a[i]));
                map.put(a[i],false);
                map.put(sum-a[i],false);
            }
        }
    }
    public static void main(String args[]) {
        int[]a = new int[]{1,4,45,6,10,-8,15};
        findPairs(a, 16);
    }
}
