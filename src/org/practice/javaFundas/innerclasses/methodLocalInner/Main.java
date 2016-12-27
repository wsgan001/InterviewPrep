package org.practice.javaFundas.innerclasses.methodLocalInner;

//Method Local inner classes can’t use local variable of outer method until that local variable is not declared as final.
//The main reason we need to declare a local variable as a final is that local variable lives on stack till method is on the stack but there might be a case the object of inner class still lives on the heap.
//Method local inner class can’t be marked as private, protected, static and transient but can be marked as abstract and final,
// but not both at the same time.
public class Main {
    public static void main(String args[]) {
        Outer x = new Outer();
        x.outerMethod();
    }
}
