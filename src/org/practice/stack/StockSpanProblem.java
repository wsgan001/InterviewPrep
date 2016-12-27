package org.practice.stack;

import java.util.*;

/*Given stock price of Amazon for some consecutive days. Need to find the maximum span of each day’s stock price.
Span is the amount of days before the given day where the stock price is less than that of given day

        E.g i/p = {2,4,6,9,5,1}
        o/p= { -1,1,2,3,2,-1}
        */

//Time Coplexity: O(n)
public class StockSpanProblem {
    public static void calculateSpan(int[] price) {
        int n =price.length;
        int[] S = new int[n];

        Stack<Integer> st = new Stack<Integer>();

        for(int i = 0; i < n; i++) {
            // Pop elements from stack while stack is not empty and top of
            // stack is smaller than price[i]
            while(!st.empty() && price[st.peek()] < price[i])
                st.pop();

            // If stack becomes empty, then price[i] is greater than all elements
            // on left of it, i.e., price[0], price[1],..price[i-1].  Else price[i]
            // is greater than elements after top of stack
            S[i] = (st.empty())? (i+1): (i-st.peek());

            //push this element to top
            st.push(i);
        }

        for(int x: S) {
            System.out.print(x+" ");
        }
    }

    public static void main(String args[]) {
        int[] price = {100, 80, 60, 70, 60, 75, 85};
        calculateSpan(price);
    }
}
