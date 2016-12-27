package org.practice.numbers;

//Convert a number to its binary representation
public class BinaryConvertor {

    //Recursive approach
    public static void convertToBinary(int num) {
        if(num <=1) {
            System.out.print(num);
            return;
        }

        int rem = num%2;
        convertToBinary(num >> 1);
        System.out.print(rem);
    }

    public static String convertToBinary1(int num) {
       StringBuffer s = new StringBuffer();
        int temp =0;
        while(num > 0) {
            temp = num % 2;
            s.append(temp);
            num = num/2;
        }
        return s.reverse().toString();
    }

    public static void main(String args[]) {
       // convertToBinary(80);
        System.out.println(convertToBinary1(4));
    }
}
