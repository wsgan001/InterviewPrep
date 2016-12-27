package org.practice.javaFundas.miscellaneous.expiryCacheProblemV2;

import java.util.concurrent.TimeUnit;
//Flipkart SDE2 question
//Driver Program
//Time Taken:
//Thinking: 15 mins
//Writing: 20 mins
//Testing: 10 mins
public class Driver {

   private static class Thread1 implements Runnable {
        ExpiryCache cache;

        Thread1(ExpiryCache cache) {
            this.cache = cache;
        }

        @Override
        public void run() {
            cache.put(1, 1000, 1000, TimeUnit.MILLISECONDS);
            cache.put(2, 2000, 2000, TimeUnit.MILLISECONDS);
            System.out.println("Thread1: "+cache.get(1));
            System.out.println("Thread1: "+cache.get(2));
            System.out.println("Thread1: "+cache.get(3));
            System.out.println("Thread1: "+cache.get(4));
            try {
                Thread.sleep(1000);
            }catch(InterruptedException e) {
            }
            System.out.println("Thread1: "+cache.get(1));
            System.out.println("Thread1: "+cache.get(2));
            System.out.println("Thread1: "+cache.get(3));
            System.out.println("Thread1: "+cache.get(4));

        }
    }

    private static class Thread2 implements Runnable {
        ExpiryCache cache;

        Thread2(ExpiryCache cache) {
            this.cache = cache;
        }

        @Override
        public void run() {
            cache.put(3, 3000, 3000, TimeUnit.MILLISECONDS);
            cache.put(4, 4000, 4000, TimeUnit.MILLISECONDS);
            System.out.println("Thread2: "+cache.get(1));
            System.out.println("Thread2: "+cache.get(2));
            System.out.println("Thread2: "+cache.get(3));
            System.out.println("Thread2: "+cache.get(4));
            try {
                Thread.sleep(1000);
            }catch(InterruptedException e) {
            }
            System.out.println("Thread2: "+cache.get(1));
            System.out.println("Thread2: "+cache.get(2));
            System.out.println("Thread2: "+cache.get(3));
            System.out.println("Thread2: "+cache.get(4));
        }
    }


    public static void main(String args[]) throws InterruptedException {
        ExpiryCache cache = new ExpiryCacheImpl();

        //Create 2 threads
        Thread t1 = new Thread(new Thread1(cache));
        Thread t2 = new Thread(new Thread2(cache));


        t1.start(); //start thread1
        t2.start(); //start thread2

        t1.join(); //wait for thread 1 to terminate
        t2.join(); //wait for thread 2 to terminate

    }
}
