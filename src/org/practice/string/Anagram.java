package org.practice.string;

//Check if two strings are anagram of each other or not
public class Anagram {
    public static boolean isDigit(char c)
    {
        if(c >=48 && c <=57)
            return true;
        return false;
    }
    public static boolean isAnagram(String str1, String str2){
        char[] chArray1 = str1.toLowerCase().toCharArray();
        char[] chArray2 = str2.toLowerCase().toCharArray();

        if(chArray1.length != chArray2.length)
            return false;

        int[] counts = new int[26]; // An array to hold the number of occurrences of each character
        for(int i=0;i<chArray1.length;i++) {
            if(!isDigit(chArray1[i]))
                counts[chArray1[i] - 97]++;  //Increment the count of the character at i
            else
                counts[chArray1[i] - 48]++;
            if(!isDigit(chArray2[i]))
                counts[chArray2[i] - 97]--; // Decrement the count of the character at i
            else
                counts[chArray2[i] -48]--;
        }

        // If the strings are anagrams, the counts array will be full of zeros
        for(int i=0;i<26;i++){
            if(counts[i] != 0)
                return false;
        }
        return true;
    }
    public static void main(String args[]){
        System.out.println(isAnagram("geeksforgeeks", "forgeeksgeeks"));
    }

}
