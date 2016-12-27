package org.practice.javaFundas.designPatterns.producerConsumer;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {
    private final BlockingQueue queue;

    Consumer(BlockingQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while(true) {
            try {
                System.out.println("Consumed: "+queue.take());

            }catch(InterruptedException e) {

            }
        }

    }
}
