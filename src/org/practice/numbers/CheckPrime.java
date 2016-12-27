package org.practice.numbers;

/**
 * Created by priyasingh on 6/15/15.
 */
public class CheckPrime {
    public static void main(String args[]){
        int n =131;

        if(Math.abs(n)==2){
            System.out.println("PRIME");
            return;
        }
        if(n < 2 || n%2 == 0){
            System.out.println("NOT PRIME");
            return;
        }
        for(int i=3;i*i<=n;i+=2){
            if(n%i==0){
                System.out.println("NOT     PRIME");
                return;
            }
        }
        System.out.println("PRIME");
    }

}
