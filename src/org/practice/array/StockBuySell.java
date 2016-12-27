package org.practice.array;

/**
 * Created by priyasingh on 10/28/15.
 */
public class StockBuySell {
    private static int count =0;
    public static class Interval {
        protected int buy;
        protected int sell;
    }
    public static void stockbuysell(int[] price) {
        int n = price.length;
        if(n ==1) {
            return ;
        }

        Interval[] sol = new Interval[n/2+1];
        for ( int i=0; i<sol.length; i++) {
            sol[i]=new Interval();
        }
        int i = 0;
        while(i < n-1) {
            while(i < n-1 && price[i+1] <= price [i]) {
                i++;
            }

            if(i == n-1)
                break;
           // sol[0] = 0;
            sol[count].buy = i++;

            while(i < n && price[i] >= price [i-1]) {
                i++;
            }

            sol[count].sell = i-1;
            count++;
        }

        if(count ==0) {
            System.out.println("There is no way to make profit");
        } else {
            for(int j =0; j<count; j++){
                System.out.println("Buy on day: "+sol[j].buy+ " Sell on day: "+sol[j].sell);
            }
        }
    }
    public static void main(String args[]) {
        int price[] = new int[]{100, 180, 260, 310, 40, 535, 695};
        stockbuysell(price);
    }
}
