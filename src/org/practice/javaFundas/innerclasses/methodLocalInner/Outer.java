package org.practice.javaFundas.innerclasses.methodLocalInner;

/**
 * Created by priyasingh on 11/11/15.
 */
public class Outer {
    void outerMethod() {
        final int x = 98;
        System.out.println("inside outerMethod");
        class Inner {
            void innerMethod() {
                System.out.println("x= "+x);
            }
        }
        Inner y = new Inner();
        y.innerMethod();
    }
}
