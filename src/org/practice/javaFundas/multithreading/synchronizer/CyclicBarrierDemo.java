package org.practice.javaFundas.multithreading.synchronizer;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

//Barriers are similar to latches in that they block a group of threads until some event occured.
//Difference is you cannot reuse CountDownLatch once count reaches 0 while you can can reuse CyclicBarrier by calling reset() method which
//resets barrier to its initial state

public class CyclicBarrierDemo {
    private static class Service implements Runnable {
        private CyclicBarrier barrier;

        public Service(CyclicBarrier barrier) {
            this.barrier = barrier;
        }

        @Override
        public void run() {
            try{
                System.out.println(Thread.currentThread().getName()+" is waiting on the barrier");
                barrier.await();
                System.out.println(Thread.currentThread().getName()+" has crossed the barrier");
            } catch(BrokenBarrierException e) {

            } catch(InterruptedException e) {

            }
        }
    }

    public static void main(String args[]) {
        //creating CyclicBarrier with 3 parties i.e. 3 Threads needs to call await()
        final CyclicBarrier ob = new CyclicBarrier(3, new Runnable() {
            @Override
            public void run() {
                //This task will be executed once all thread reaches barrier
                System.out.println("All parties have arrived the barrier. Let's play");
            }
        });

        Thread t1 = new Thread(new Service(ob), "Thread1");
        Thread t2 = new Thread(new Service(ob), "Thread2");
        Thread t3 = new Thread(new Service(ob), "Thread3");

        t1.start();
        t2.start();
        t3.start();
    }
}
