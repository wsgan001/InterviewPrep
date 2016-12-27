package org.practice.linkedlist;

import java.util.LinkedList;

//You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
//
//        Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
//        Output: 7 -> 0 -> 8

public class AddNumbersLinkedList {
    public static void main(String args[]) {
        LinkedList<Integer> res = new LinkedList<>();
        int sum = 0, carry = 0;
        LinkedList<Integer> num1 = new LinkedList<>();
        num1.add(2);
        num1.add(4);
        num1.add(3);
        num1.add(2);

        LinkedList<Integer> num2 = new LinkedList<>();
        num2.add(5);
        num2.add(6);
        num2.add(9);

        int len1 = num1.size();
        int len2 = num2.size();

        int len = len1 > len2 ? len1 : len2;
        int x, y;

        for (int i = 0; i < len; i++) {
            try {
                x = num1.get(i);
            } catch (Exception e) {
                x = 0;
            }

            try {
                y = num2.get(i);
            } catch (Exception e) {
                y = 0;
            }

            sum = carry + x + y;
            carry = sum >= 10 ? 1 : 0;
            res.add(sum % 10);

        }

        if (carry > 0) {
            res.add(carry);
        }

    }
}


