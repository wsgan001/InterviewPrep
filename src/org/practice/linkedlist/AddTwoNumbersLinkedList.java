package org.practice.linkedlist;

import java.util.*;

public class AddTwoNumbersLinkedList {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter number 1");
        String s1 = scan.next();
        System.out.println("Enter number 2");
        String s2 = scan.next();

        LinkedList<Integer> num1 = new LinkedList<Integer>();
        LinkedList<Integer> num2 = new LinkedList<Integer>();
        LinkedList<Integer> res = new LinkedList<Integer>();

        int len1=s1.length();
        int len2 = s2.length();
        for(int i=len1-1;i>=0;i--) {
            num1.add(s1.charAt(i) - '0');
        }

        for(int i=len2-1;i>=0;i--)
            num2.add(s2.charAt(i) - '0');
       // num1.add(563);
       // num2.add(842);
        int l1=num1.size(), l2 = num2.size();
        int len = l1>l2?l1:l2;
        int carry =0;
        for(int i=0;i<len;i++){
            int d1, d2;
            d1 = num1.get(i);
            try {
                d2 = num2.get(i);
            }catch(Exception e) {
                d2 =0;
            }
            int x = d1+d2+carry;
            res.add(x%10);
            carry = x/10;
        }
        while(carry != 0){
            res.add(carry%10);
            carry/=10;
        }
        System.out.print("Sum = ");
        for(int i=res.size()-1;i>=0;i--){
            System.out.print(res.get(i));
        }

    }
}
