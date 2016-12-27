package org.practice.javaFundas.multithreading;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Lock;

public class JavaAtomic {
    private static class ProcessingThread implements Runnable {
        private AtomicInteger count = new AtomicInteger();


        @Override
        public void run() {
            for (int i = 1; i < 5; i++) {
                processSomething(i);
                count.incrementAndGet();
            }
        }

        public int getCount() {
            return this.count.get();
        }

        private void doSomething() {
            int a[]= new int[]{1, 2};
            System.out.println(a[3]);
        }

        private void processSomething(int i) {
            // processing some job
            try {
                Thread.sleep(i * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
    public static void main(String[] args) throws InterruptedException {
        ProcessingThread pt = new ProcessingThread();

        Thread t1 = new Thread(pt, "t1");
        t1.start();
        Thread t2 = new Thread(pt, "t2");
        t2.start();

        t1.join();
        t2.join();
        System.out.println("Processing count=" + pt.getCount());
    }
}


