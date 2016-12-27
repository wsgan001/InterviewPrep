package org.practice.array;

import java.util.PriorityQueue;

public class KthLargest {
    public static int kthLargest(int[] a, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<Integer>();
        int i =0;
        while(i < k) {
            q.add(a[i]);
            i++;
        }

        for(;i<a.length;i++) {
            int value = q.peek();
            if(a[i] > value) {
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
