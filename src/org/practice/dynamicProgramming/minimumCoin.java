package org.practice.dynamicProgramming;

//Given a value V, if we want to make change for V cents, and we have infinite supply of each of C = { C1, C2, .. , Cm} valued coins,
// what is the minimum number of coins to make the change?
public class minimumCoin {
    public static int minCoins(int coins[], int sum) {
        int[] table = new int[sum+1];
        table[0]=0;

        for(int i=1;i<=sum;i++) {
            table[i]=Integer.MAX_VALUE;
        }

        for(int i=1;i<=sum;i++) {
            for(int j =0;j<coins.length;j++) {
                if(coins[j] <= i) {
                    int sub_res = table[i-coins[j]];
                    if(sub_res != Integer.MAX_VALUE && sub_res+1 < table[i]) {
                        table[i] = sub_res+1;
                    }
                }
            }
        }
        return table[sum];
    }

    public static void main(String args[]) {
        int[] coins =  new int[]{3, 5};
        System.out.println("Minimum coins required are: "+minCoins(coins, 16));
        System.out.println(Integer.MAX_VALUE);
    }
}
