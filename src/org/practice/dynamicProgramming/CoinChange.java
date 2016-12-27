package org.practice.dynamicProgramming;

/*Given a value N, if we want to make change for N cents, and we have infinite supply of each of S = { S1, S2, .. , Sm} valued coins,
how many ways can we make the change? The order of coins doesn’t matter.
 */
public class CoinChange {
    public static int count(int[] S, int n) {
        // table[i] will be storing the number of solutions for
        // value i. We need n+1 rows as the table is consturcted
        // in bottom up manner using the base case (n = 0)
        int[] table = new int[n+1];

        for(int i =0; i<=n; i++) {
            table[i] = 0;
        }

        //Base Case
        table[0] = 1;

        //Pick all the coins one by one and update the table[] values
        //after the index greater than or equal to value of picked coin
        for(int i = 0; i<S.length; i++) {
            for(int j = S[i]; j<=n; j++) {
                table[j] += table[j-S[i]];
            }
        }
        return table[n];
    }

    public static void main(String[] args) {
        int a[] = {1,2,3};
        System.out.println("Total ways to form the sum are: "+count(a, 4));
    }
}
