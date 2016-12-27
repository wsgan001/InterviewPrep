package org.practice.array;

import java.util.Collections;
import java.util.PriorityQueue;

public class KthSmallest {
    public static int kthLargest(int[] a, int k) {
        //Use priority queue to implement max heap
        PriorityQueue<Integer> q = new PriorityQueue<Integer>(k, Collections.reverseOrder());
        int i =0;
        while(i < k) {
            q.add(a[i]);
            i++;
        }

        for(;i<a.length;i++) {
            int value = q.peek();
            if(a[i] < value) {
                q.poll();
                q.add(a[i]);
            }
        }
        return q.peek();
    }

    public static void main(String args[]) {
        int a[] = {3,6,2,8,9,4,5};
        System.out.println(kthLargest(a, 3));
    }
}
