package org.practice.string;

/**  Linkedin Interview Question
 * Find minimum distance between two words (order preserved) in a big string.
 For e.g 1. "hello how are you" - distance between "hello" and "you" is 3.
 e.g 2. "hello how are hello you" - distance is 1
 */
public class MinimumDistance {
    public static int findDistance(String str, String a, String b) {
        int aIndex = -1, bIndex = -1;
        int minDistance = Integer.MAX_VALUE;
        int i =0;
        String[] as = str.toLowerCase().split(" ");
        for(String t: as) {
            if(t.equals(a)) {
                aIndex = i;
            }
            if(t.equals(b)) {
                bIndex = i;
            }
            if(aIndex != -1 && bIndex != -1) {
                minDistance = Math.min(minDistance, Math.abs(bIndex - aIndex));
            }
            i++;
        }

        if(aIndex == -1 || bIndex == -1) {
            return -1;
        } else
            return minDistance;
    }

    public static void main(String args[]) {
        String str= "hello how are you how";
        System.out.println(findDistance(str, "how", "you"));
    }
}
