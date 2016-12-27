package org.practice.javaFundas.multithreading.synchronizer;

import java.util.concurrent.Semaphore;

//Counting Semaphores are used to control the number of activities that can access a certain resource or perform a given action at the same time.
//It can be used to implement resource pools or to impose a bound on the collection.
public class SemaphoreDemo {
    Semaphore binary = new Semaphore(2); //here 2 is the no of virtual permit

    public static class Service implements Runnable {
        private final SemaphoreDemo ob;
        Service(SemaphoreDemo ob) {
            this.ob = ob;
        }
        @Override
        public void run() {
            ob.mutualExclusion();
        }
    }

    public void mutualExclusion() {
        try {
            binary.acquire(); //acquiring permit
            System.out.println(Thread.currentThread().getName()+" inside mutual exclusive region");
        }catch(InterruptedException e) {

        } finally {
            binary.release(); //releasing permit
            System.out.println(Thread.currentThread().getName()+" outside mutual exclusive region");
        }
    }

    public static void main(String args[]) {
        SemaphoreDemo ob = new SemaphoreDemo();

        Thread t1 = new Thread(new Service(ob));
        Thread t2 = new Thread(new Service(ob));

        t1.start();
        t2.start();
    }
}
