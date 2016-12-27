package org.practice.dynamicProgramming;

//Given a set of non-negative integers, and a value sum, determine if there is a subset of the given set with sum equal to given sum.
//Time complexity: O(sum*n)
//Approach: dynamic programming
public class SubsetSum {
    // Returns true if there is a subset of set[] with sun equal to given sum
    public static int isSubsetSum(int set[], int n, int sum)
    {
        // The value of subset[i][j] will be true if there is a subset of set[0..j-1]
        //  with sum equal to i
        int[][] subset= new int[sum+1][n+1];

        // If sum is 0, then answer is true
        for (int i = 0; i <= n; i++)
            subset[0][i] = 1;

        // If sum is not 0 and set is empty, then answer is false
        for (int i = 1; i <= sum; i++)
            subset[i][0] = 0;

        // Fill the subset table in botton up manner
        for (int i = 1; i <= sum; i++)
        {
            for (int j = 1; j <= n; j++)
            {
                subset[i][j] = subset[i][j-1];
                if (i >= set[j-1]) {
                    if(subset[i][j] == 0)
                        subset[i][j] = subset[i - set[j - 1]][j - 1];
                }
            }
        }

     // uncomment this code to print table
     for (int i = 0; i <= sum; i++)
     {
       for (int j = 0; j <= n; j++)
          System.out.print(subset[i][j] + " ");
         System.out.println();
     }

        return subset[sum][n];
    }
    public static void main(String args[]) {
        int[] set = new int[]{3, 34, 4, 12, 5, 2};
        if(isSubsetSum(set, 6, 6) == 1)
            System.out.println("Found a subset with given sum");
    }
}
