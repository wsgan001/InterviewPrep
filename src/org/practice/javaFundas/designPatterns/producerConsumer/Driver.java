package org.practice.javaFundas.designPatterns.producerConsumer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

//BlockingQueue is a unique collection type which not only store elements but also supports flow control by
//introducing blocking if either BlockingQueue is full or empty. take() method of BlockingQueue will block if Queue is empty and
// put() method of BlockingQueue will block if Queue is full.
public class Driver {
    public static void main(String args[]) {
        //creating shared queue
        BlockingQueue sharedQueue = new LinkedBlockingQueue();

        //creating producer and consumer thread
        Thread prodThread = new Thread(new Producer(sharedQueue));
        Thread consumerThread = new Thread(new Consumer(sharedQueue));

        //start producer and consumer thread
        prodThread.start();
        consumerThread.start();
    }
}
