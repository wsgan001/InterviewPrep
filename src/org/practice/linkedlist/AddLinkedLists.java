package org.practice.linkedlist;

import java.util.LinkedList;

public class AddLinkedLists {
    public static void addTwoLists(LinkedList<Integer> l1, LinkedList<Integer>l2) {
        LinkedList<Integer> resList = new LinkedList<Integer>();
        int number1 =0, number2 = 0, res;
        for(int i=0;i<l1.size();i++) {
            number1 = number1*10+l1.get(i);
        }
        for(int i=0;i<l2.size();i++) {
            number2 = number2*10+l2.get(i);
        }
        res = number1+number2;
        resList.add(res);
        System.out.println(resList);

    }
    public static void main(String args[]) {
        LinkedList<Integer> list1 = new LinkedList<Integer>();
        LinkedList<Integer> list2 = new LinkedList<Integer>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list2.add(1);
        list2.add(2);
        list2.add(9);
        list2.add(9);
        addTwoLists(list1, list2);
    }
}

