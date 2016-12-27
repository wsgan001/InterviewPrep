package org.practice.javaFundas.designPatterns.producerConsumer;

import java.util.concurrent.BlockingQueue;

/**
 * Created by priyasingh on 11/22/15.
 */
public class Producer implements Runnable {
    private final BlockingQueue queue;

    Producer(BlockingQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        for(int i =0; i <10; i++) {
            try {
                System.out.println("Produced: "+i);
                queue.put(i);

            }catch(InterruptedException e) {

            }
        }

    }
}
