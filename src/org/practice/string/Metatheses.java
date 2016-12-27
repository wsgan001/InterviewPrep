package org.practice.string;

//Two words are metatheses if they differ in a single swap of two different characters.
//For example, “conserve” and “converse”.
//Google Telephonic question
public class Metatheses {
    public static boolean isMetatheses(String str1, String str2) {
        if(str1.length() != str2.length())
            return false;

        int count =0;
        for(int i = 0; i<str1.length(); i++) {
            if(str1.charAt(i) != str2.charAt(i))
                count++;
        }

        if(count == 2) {
            return true;
        }
        return false;
    }
    public static void main(String args[]) {
        System.out.println(isMetatheses("converse", "conserve"));
    }
}
