package org.practice.string;

import java.util.*;

/* Linkedin Interview question
Write a program that gives count of common characters presented in an array of strings..(or array of character arrays)

        For eg.. for the following input strings..

        aghkafgklt
        dfghako
        qwemnaarkf

        The output should be 3. because the characters a, f and k are present in all 3 strings.

        Note: The input strings contains only lower case alphabets
*/
public class CommonCharacter {
    public static int getNoOfCommonChars(String[] inputs) {
        if(inputs == null || inputs.length < 2) {
            return 0;
        } else {
            //create an int array to hold # times character appears
            int[] charCounts = new int[256];
            for(String input: inputs) {
                Set<Character> uniqueCharSets = new HashSet<Character>();
                for(int i =0; i <input.length(); i++) {
                    char ch = input.charAt(i);
                    if(!uniqueCharSets.contains(ch)) {
                        uniqueCharSets.add(ch);
                        charCounts[(int)ch]++;
                    }
                }
            }
            int commonCharCount = 0;
            for(int i =0; i <256;i++) {
                if(charCounts[i] == inputs.length) {
                    commonCharCount++;
                }
            }
            return commonCharCount;
        }
    }
    public static void main(String args[]) {
        String[] inputs = {"aghkafgklt", "dfghako", "qwemnaarkf" };
        System.out.print("No of common characters is: "+getNoOfCommonChars(inputs));
    }
}
