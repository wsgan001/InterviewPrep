package org.practice.javaFundas.multithreading;

//WAP to create two threads, one thread print even number and another prints odd number.
public class EvenOddPrinter {
    public synchronized void printOdd() {
        for(int i =0; i<=10;i++) {
            if(i%2 != 0) {
                System.out.println("Odd number= "+ i);
            }
        }
    }

    public synchronized void printEven() {
        for(int i =0; i<=10;i++) {
            if(i%2 == 0) {
                System.out.println("Even number= "+ i);
            }
        }
    }

    private static class EvenThread implements Runnable {
        private EvenOddPrinter ob;

        EvenThread(EvenOddPrinter ob) {
            this.ob = ob;
        }

        @Override
        public void run() {
            ob.printEven();
        }
    }

    private static class OddThread implements Runnable {
        private EvenOddPrinter ob;

        OddThread(EvenOddPrinter ob) {
            this.ob = ob;
        }

        @Override
        public void run() {
            ob.printOdd();
        }
    }



    public static void main(String args[]) {
        EvenOddPrinter ob = new EvenOddPrinter();

        EvenThread r1 = new EvenThread(ob);
        Thread t1 = new Thread(r1);

        OddThread r2 = new OddThread(ob);
        Thread t2 = new Thread(r2);

        t1.start();
        t2.start();
    }
}
