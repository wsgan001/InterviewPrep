package org.practice.javaFundas.innerclasses.staticNested;

//Static nested classes are not technically an inner class. They are like a static member of outer class.
public class Outer {
    private static void outerMethod() {
        System.out.println("inside outerMethod");
    }

    // A static inner class
    static class Inner {
        public static void main(String[] args) {
            System.out.println("inside inner class Method");
            outerMethod();
        }
    }
}
