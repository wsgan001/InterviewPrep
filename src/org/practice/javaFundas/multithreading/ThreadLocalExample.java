package org.practice.javaFundas.multithreading;

import java.util.Timer;

public class ThreadLocalExample {


    public static class MyRunnable implements Runnable {
        private int count;

        public MyRunnable() {
            count = 0;
        }

        private ThreadLocal<Integer> threadLocal =
               new ThreadLocal<Integer>();

        @Override
        public void run() {
            threadLocal.set(++count);

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
            }

            System.out.println(threadLocal.get());
        }
    }


    public static void main(String[] args)throws Exception{
        MyRunnable sharedRunnableInstance = new MyRunnable();

        Thread thread1 = new Thread(sharedRunnableInstance);
        Thread thread2 = new Thread(sharedRunnableInstance);

        thread1.start();
        thread2.start();

        thread1.join(); //wait for thread 1 to terminate
        thread2.join(); //wait for thread 2 to terminate
        Timer t = new Timer();
    }

}
