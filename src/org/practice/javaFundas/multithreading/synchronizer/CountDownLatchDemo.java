package org.practice.javaFundas.multithreading.synchronizer;

import java.util.concurrent.CountDownLatch;

//A latch is a synchronizer that can delay the progress of threads until it reaches its terminal state
//A latch acts as a gate. Until the latch reaches its terminal state, gate remains closed and no thread can pass and in
//terminal state, gate opens allowing all threads to pass.
//CountDownLatch is a latch implementation which allows one or more threads to wait for a set of events to occur.
//Use CountDownLatch when one of Thread like main thread, require to wait for one or more thread to complete, before its start doing processing.


public class CountDownLatchDemo {
    private static class Service implements Runnable {
        private final String name;
        private final int timeToStart;
        private final CountDownLatch latch;

        public Service(String name, int timeToStart, CountDownLatch latch){
            this.name = name;
            this.timeToStart = timeToStart;
            this.latch = latch;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(timeToStart);
            } catch(InterruptedException e) {

            }
            System.out.println(name +" is up.");
            latch.countDown();
        }
    }
    public static void main(String args[]) {
        final CountDownLatch latch = new CountDownLatch(3);
        Thread t1 = new Thread(new Service("Cache Service", 1000, latch));
        Thread t2 = new Thread(new Service("Alert Service", 1000, latch));
        Thread t3 = new Thread(new Service("Validation Service", 1000, latch));

        t1.start();
        t2.start();
        t3.start();

        // application should not start processing any thread until all service is up
        // and ready to do there job.
        // Countdown latch is idle choice here, main thread will start with count 3
        // and wait until count reaches zero. each thread once up and read will do
        // a count down. this will ensure that main thread is not started processing
        // until all services is up.

        try{
            latch.await(); //main thread is waiting on CountDownLatch to finish
            System.out.println("All Services are up. Application is starting now");
        } catch(InterruptedException e) {

        }
    }
}