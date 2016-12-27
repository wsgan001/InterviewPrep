package org.practice.string;

/**
 ** Java Program to implement Longest Common Substring Algorithm
 * Program Paradigm: Dynamic Programming
 * Time Complexity: O(m*n)
 **/
public class LongestCommonSubstring {
    public static String findLCS(String str1, String str2) {
        int m =str1.length();
        int n = str2.length();

        int LCSuff[][] = new int[m+1][n+1];
        int len = 0, pos = -1;

        for(int i = 0; i <= m; i++) {
            for(int j = 0; j <= n ; j++) {
                if(i==0 || j ==0) {
                    LCSuff[i][j] = 0;
                }
                else if(str1.charAt(i-1) == str2.charAt(j-1)) {
                    LCSuff[i][j] = LCSuff[i-1][j-1] +1;
                    if(LCSuff[i][j] > len) {
                        len = LCSuff[i][j];
                        pos = i;
                    }
                } else {
                    LCSuff[i][j] = 0;
                }

            }
        }
        return str1.substring(pos-len, pos);

    }
    public static void main(String args[]) {
        System.out.println("Longest Common Substring is: "+findLCS("OldSite:GeeksforGeeks.org", "NewSite:GeeksQuiz.com"));
        System.out.println("Longest Common Substring is: "+findLCS("AGGTAB", "GXTXAYB"));
    }
}
