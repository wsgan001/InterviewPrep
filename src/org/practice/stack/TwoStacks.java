package org.practice.stack;

//Create a data structure twoStacks that represents two stacks. Implementation of twoStacks should use only one array, i.e., both stacks should use the same array for storing elements. Following functions must be supported by twoStacks.
//push1(int x) –> pushes x to first stack
//push2(int x) –> pushes x to second stack
//pop1() –> pops an element from first stack and return the popped element
//pop2() –> pops an element from second stack and return the popped element
//Implementation of twoStack should be space efficient.
public class TwoStacks {
    private int[] arr;
    private int size;
    private int top1;
    private int top2;

    TwoStacks(int n) {
        size = n;
        arr = new int[n];
        top1 = -1;
        top2 = size;
    }

    void push1(int x) {
        if(top1 < top2 - 1){
            arr[++top1] = x;
        } else {
            System.out.println("Stack Overflow");
        }

    }

    void push2(int x) {
        if(top1 < top2 - 1){
            arr[--top2] = x;
        } else {
            System.out.println("Stack Overflow");
        }

    }

    int pop1() {
        if(top1 >= 0) {
            int x = arr[top1];
            top1--;
            return x;
        } else {
            System.out.println("Stack Underflow");
            return -1;
        }
    }

    int pop2() {
        if(top2 <= size-1) {
            int x = arr[top2];
            top2++;
            return x;
        } else {
            System.out.println("Stack Underflow");
            return -1;
        }

    }

    public static void main(String args[]) {
        TwoStacks ts = new TwoStacks(15);
        ts.push1(5);
        ts.push2(10);
        ts.push2(15);
        ts.push1(11);
        ts.push2(7);
        System.out.println("Popped element from stack 1: "+ts.pop1());
        ts.push2(40);
        System.out.println("Popped element from stack 2: "+ts.pop2());
    }
}
