package org.practice.string;

/* Snapdeal Interview Question
Given a list of words. Find if two words can be joined to form a palindrome.
*/

public class PalindromePairs {
    private static boolean isPalindromePair(String a, String b) {
        String rev_a = new StringBuffer(a).reverse().toString();
        String rev_b = new StringBuffer(b).reverse().toString();

        if((a+b).equals(rev_b+rev_a) || (b+a).equals(rev_a+rev_b) )
            return true;
        return false;
    }

    public static void findPalindromePair(String[] s) {
        for(int i = 0; i < s.length-1; i++) {
            for(int j = i+1; j < s.length; j++) {
                if(isPalindromePair(s[i], s[j])) {
                    System.out.println(s[i]+","+s[j]);
                }
            }
        }
    }

    public static void main(String args[]) {
        String s[] = {"bat" , "tab", "tabaa", "aatab"};
        findPalindromePair(s);
    }
}
