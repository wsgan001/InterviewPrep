package org.practice.numbers;

//1 chocolate cost is Rs.1 & if we return 3 wrapers(covers) of
//chocolate we get 1 more chocolate. If u have Rs.15 how many
//chocolates do u get...?

public class ChocoWrapperPuzzle {
    public static int calc(int amount) {
        int chocolates = amount;
        int wrapper = chocolates;
        int rem =0, temp =0;

        while(wrapper >=3) {
            temp = wrapper/3;
            chocolates+=temp;
            rem = wrapper%3;
            wrapper = temp+rem;
        }
        return chocolates;
    }
    public static void main(String args[]) {
        System.out.println("Total no of chocos bought are: "+calc(15));

    }
}
