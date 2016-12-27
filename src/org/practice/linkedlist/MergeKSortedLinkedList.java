package org.practice.linkedlist;

import java.util.LinkedList;

/**
 * Created by kumari.singh on 30/09/16.
 */
//Time Complexity: O(nklogk)
//Space Complexity: O(1)
//Approach: Divide and conquer
public class MergeKSortedLinkedList {

    public static LinkedList<Integer> merge( LinkedList<Integer>[] arr, int last) {
        // repeat until only one list is left
        while(last != 0) {
            int i = 0, j = last;

            //i, j forms a pair
            while(i < j) {
                // merge List i with List j and store
                // merged list in List i
                arr[i] = MergeTwoSortedLinkedList.merge(arr[i], arr[j]);

                // consider next pair
                i++;
                j--;

                // If all pairs are merged, update last
                if(i >= j) {
                    last = j;
                }
            }
        }
        return arr[0];
    }

    public static void main(String args[]) {
        LinkedList<Integer>[] linkedLists = new LinkedList[3];
        linkedLists[0] = new LinkedList<>();
        linkedLists[0].add(2);
        linkedLists[0].add(3);
        linkedLists[0].add(5);

        linkedLists[1] = new LinkedList<>();
        linkedLists[1].add(1);
        linkedLists[1].add(4);
        linkedLists[1].add(6);

        linkedLists[2] = new LinkedList<>();
        linkedLists[2].add(0);
        linkedLists[2].add(8);
        linkedLists[2].add(9);

        LinkedList<Integer> result = merge(linkedLists, 2);

        for(Integer x: result) {
            System.out.println(x+" ");
        }
    }
}
