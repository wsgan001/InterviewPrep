package org.practice.string;

//Given a string, find the minimum number of characters to be inserted to convert it to palindrome.
public class MinInsertionForPalindrome {

    //To find longest common subsequence of two strings
    public static int lcs(String str1, String str2, int m , int n) {
        int L[][] = new int [m+1][n+1];

        for(int i=0;i<=m;i++) {
            for(int j=0;j<=n;j++) {
                if(i == 0 || j ==0)
                    L[i][j]= 0;
                else if(str1.charAt(i-1) == str2.charAt(j-1))
                    L[i][j] = L[i-1][j-1]+1 ;
                else
                    L[i][j] = Math.max(L[i-1][j], L[i][j-1]);
            }
        }
        return L[m][n];
    }

    public static int findMinInsertionsLCS(String str) {
        String rev = new StringBuilder(str).reverse().toString();
        return (str.length() - lcs(str, rev, str.length(), rev.length()));
    }

    public static void main(String args[]) {
        System.out.println("Min insertion required to form the palindrome is: "+findMinInsertionsLCS("geeks"));
    }
}
