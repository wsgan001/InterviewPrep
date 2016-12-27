package org.practice.linkedlist;

import java.util.*;

//Time Complexity: O(n)
//Space Complexity: O(1)
public class MergeTwoSortedLinkedList {
    public static LinkedList<Integer> merge(LinkedList<Integer> list1, LinkedList<Integer>list2) {
        LinkedList<Integer> res = new LinkedList<Integer>();
        int i = 0, j =0;
        while(i < list1.size() && j < list2.size()) {
            if(list1.get(i) < list2.get(j)) {
                res.add(list1.get(i));
                i++;
            } else if(list2.get(j) < list1.get(i)) {
                res.add(list2.get(j));
                j++;
            }
        }
        while(i < list1.size()) {
            res.add(list1.get(i));
            i++;
        }

        while(j < list2.size()) {
            res.add(list2.get(j));
            j++;
        }

        return res;
    }

    public static void main(String args[]) {
        LinkedList<Integer> list1 = new LinkedList<Integer>();
        list1.add(2);
        list1.add(3);
        list1.add(5);

        LinkedList<Integer> list2 = new LinkedList<Integer>();
        list2.add(1);
        list2.add(4);
        list2.add(6);
        LinkedList<Integer> result = merge(list1, list2);

        for(Integer x: result) {
            System.out.println(x+" ");
        }
    }
}
