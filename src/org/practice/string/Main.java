package org.practice.string;

/**
 * Created by kumari.singh on 26/12/16.
 */
public class Main {
    static class Base {
        public void show() throws IllegalArgumentException {
            System.out.println("Base::show() called");
        }
    }

    static class Derived extends Base {
        @Override
        public void show()  {
            System.out.println("Derived::show() called");
        }
    }

    public static void main(String[] args) {
        Base b = new Derived();
        b.show();
    }
   }


