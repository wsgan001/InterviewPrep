package org.practice.javaFundas.innerclasses.nestedInner;

//Nested Inner class can access any private instance variable of outer class. Like any other instance variable, we can have access modifier private, protected, public and default modifier.
//Like class, interface can also be nested and can have access specifiers.
//we can’t have static method in a nested inner class because an inner class is implicitly associated with an object of its outer class
// so it cannot define any static method for itself
public class Main {
    public static void main(String args[]) {
        Outer.Inner in = new Outer().new Inner();
        in.show();
    }
}
