package org.practice.javaFundas.multithreading;

//JP Morgan interview question
//You have two threads one printing even numbers in order and other odd numbers.
// Design an algorithm so that it prints numbers in natural order
public class NaturalNumberPrinter {
    private static Object lock = new Object();
    private static boolean printEven = false;

    private static class EvenPrinter implements Runnable {
        int start = 0, max;

        EvenPrinter(int max) {
            this.max = max;
        }

        @Override
        public void run() {
            while(start < max) {
                synchronized (lock) {
                    if(printEven) {
                        System.out.println(start);
                        start += 2;
                        printEven = false;
                    }
                }
            }
        }
    }

    private static class OddPrinter implements Runnable {
        int start = 1, max;

        OddPrinter(int max) {
            this.max = max;
        }

        @Override
        public void run() {
            while(start < max) {
                synchronized (lock) {
                    if(!printEven) {
                        System.out.println(start);
                        start += 2;
                        printEven = true;
                    }
                }
            }
        }
    }
    public static void main(String args[]) {
        printEven = true;
        int max = 10;
        Thread t1 = new Thread(new EvenPrinter(max));
        Thread t2 = new Thread(new OddPrinter(max));

        t1.start();
        t2.start();
    }
}
