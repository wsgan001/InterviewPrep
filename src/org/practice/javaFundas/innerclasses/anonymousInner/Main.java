package org.practice.javaFundas.innerclasses.anonymousInner;

/**
 * Created by priyasingh on 11/11/15.
 */
public class Main {
    //  An anonymous class with Outer as base class
    static Outer outer = new Outer() {
        void show() {
            super.show();
            System.out.println("I am in Main class");
        }
    };

    public static void main(String args[]) {
        outer.show();
    }
}
