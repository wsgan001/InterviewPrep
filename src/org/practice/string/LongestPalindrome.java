package org.practice.string;

//prints the longest palindrome substring (LPS)
//Also returns length of LPS
public class LongestPalindrome {
    public static int findLPS(String str){
       int maxLength = 1;
       int start =0;
       int len = str.length();
       int low, high;

        // One by one consider every character as center point of
        // even and length palindromes
        for(int i=1; i<len;i++) {
            // Find the longest even length palindrome with center points
            // as i-1 and i.
            low = i-1;
            high =i;
            while(low >= 0 && high < len && str.charAt(low) == str.charAt(high)) {
                if(high-low+1 > maxLength) {
                    start = low;
                    maxLength = high-low+1;
                }
                --low;
                ++high;
            }

            // Find the longest odd length palindrome with center points
            // as i-1 and i+1.
            low = i-1;
            high =i+1;
            while(low >= 0 && high < len && str.charAt(low) == str.charAt(high)) {
                if(high-low+1 > maxLength) {
                    start = low;
                    maxLength = high-low+1;
                }
                --low;
                ++high;
            }
        }
        System.out.println("Longest Palindromic Subsequence: "+str.substring(start, start+maxLength));
        return maxLength;
    }

    public static void main(String args[]){
        System.out.println(findLPS("abaaa"));
    }
}
