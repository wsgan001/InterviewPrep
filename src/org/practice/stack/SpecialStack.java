package org.practice.stack;

//Design a Data Structure SpecialStack that supports all the stack operations like push(), pop(), isEmpty(), isFull() and an additional operation getMin()
//which should return minimum element from the SpecialStack. All these operations of SpecialStack must be O(1).
import java.util.Stack;

public class SpecialStack {
    Stack st = new Stack();
    Stack aux = new Stack();

    public void push (int x){
        if(aux.empty() || x < (Integer)aux.peek()) aux.push(x);
        st.push(x);
    }

    public void pop(){
        int x = (Integer)st.pop();
        int y = (Integer)aux.pop();
        if(x != y){
            aux.push(y);
        }
    }

    public int getMin() {
        return (Integer)aux.peek();
    }

    public static void main (String args[]){
        SpecialStack s = new SpecialStack();
        s.push(18);
        System.out.println(s.getMin());
        s.push(19);
        System.out.println(s.getMin());
        s.pop();
        s.push(29);
        System.out.println(s.getMin());
        s.push(15);
        System.out.println(s.getMin());
        s.push(16);
        System.out.println(s.getMin());
    }
}


