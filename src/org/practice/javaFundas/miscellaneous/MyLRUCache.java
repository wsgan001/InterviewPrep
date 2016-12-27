package org.practice.javaFundas.miscellaneous;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Lock;

//Use two data structures to implement it
//1.  A queue which is implemented using doubly linked list
//2. A hashmap which contains key as page number and value as address of corresponding queue node
public class MyLRUCache {
    private ConcurrentLinkedQueue<Integer> concurrentLinkedQueue;
    private ConcurrentHashMap<Integer, Integer> concurrentHashMap;
    private Lock lock;
    private int MAX_SIZE;

    public MyLRUCache(int size) {
        concurrentLinkedQueue = new ConcurrentLinkedQueue<Integer>();
        concurrentHashMap = new ConcurrentHashMap<Integer, Integer>();
        lock = new ReentrantLock();
        MAX_SIZE = size;
    }

    public int get(int key) {
        lock.lock();
        try {
            //if a page is referenced using get(), then remove it from the queue and add it to the queue again. In this way recently used page
            //will always be at tail and least recently page will be at head.
            if(concurrentHashMap.containsKey(key)) {
                concurrentLinkedQueue.remove(key);
                int value = concurrentHashMap.get(key);
                concurrentLinkedQueue.add(key);
                return value;
            }

        } finally {
            lock.unlock();
        }
        return -1;
    }
    public void put(int key, int value) {
        lock.lock();
        try {
            if(concurrentHashMap.containsKey(key)) {
                concurrentHashMap.remove(key);
            }

            // when size of queue exceeds its capacity, then remove the page from the head of the queue as head contains least
            // recently used page
            while(concurrentLinkedQueue.size() >= MAX_SIZE) {
                Integer queuekey = concurrentLinkedQueue.poll();
                if(queuekey != null) {
                    concurrentLinkedQueue.remove(queuekey);
                }
            }
            concurrentLinkedQueue.add(key);
            concurrentHashMap.put(key, value);
        } finally {
            lock.unlock();
        }
    }

    public void printQueue() {
        Iterator<Integer> itr = concurrentLinkedQueue.iterator();
        while(itr.hasNext()) {
            System.out.println(itr.next());
        }
    }

    public static void main(String args[]) {
        MyLRUCache lruCache = new MyLRUCache(3);
        lruCache.put( 1, 1000);
        lruCache.put( 2, 2000);
        lruCache.put( 3, 3000);
        lruCache.put( 4, 4000);
        //System.out.println(lruCache.get(3));
        //System.out.println(lruCache.get(4));
        //System.out.println(lruCache.get(1));
        lruCache.printQueue();

    }
}
