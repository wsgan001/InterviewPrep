package org.practice.javaFundas.miscellaneous.expiryCacheProblemV2;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// 1. Implements put and get method for Expiry cache
// 2. Scans the cache and remove expired keys from cache
public class ExpiryCacheImpl implements ExpiryCache {
   private static ConcurrentHashMap<Object, Entry> cache = new ConcurrentHashMap<Object, Entry>();
   private static Lock lock = new ReentrantLock();

    static class Entry {
        private final Object value;
        private final long expiration; //time after which a particular key will expire
        private long lastUseTime;   // time when get() method was last called for a key

        public Entry(Object value, Long expiration) {
            this.value = value;
            this.expiration = expiration;
            this.lastUseTime = System.currentTimeMillis();
        }

        public boolean isExpired() {
            return (lastUseTime + expiration) < System.currentTimeMillis();
        }

        public Object getValue() {
            return this.value;
        }

        public void updateUseTime() {
            this.lastUseTime = System.currentTimeMillis();
        }
    }

    static {
        /**
         * Scan the cache every 5 minutes, remove expired keys.
         */
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        for (Object key : cache.keySet()) {
                            if (cache.get(key).isExpired())
                                cache.remove(key);
                        }
                        Thread.sleep(TimeUnit.MINUTES.toMillis(5));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    /**
     * Creates an Entry object with key as passed value and expiration time in millisecond
     * Put key and Entry object into cache
     * Time Complexity: O(1)
     * @param key
     * @param value
     * @param ttl how
    long this entry should remain in Cache, in units of timUnit
     * @param timeUnit a
    TimeUnit (ref: java.util.concurrent.TimeUint) determining how to interpret the timeout
       @returns void
     */
    @Override
    public void put(Object key, Object value, int ttl, TimeUnit timeUnit) {
        lock.lock();
        try {
            long expiration = timeUnit.toMillis(new Long(ttl));
            cache.put(key, new Entry(value, expiration));
        } finally {
            lock.unlock();
        }
    }

    /**
     * Check if entry object is present for a key or not. If not, return null.
     * Otherwise check whether entry is expired or not. If not expired, update its use time and return value
     * Else remove it from the cache and return null.
     * Time Complexity: O(1)
     * @param key
     * @return Object
     */

    @Override
    public Object get(Object key) {
        lock.lock();
        try {
            Entry entry = cache.get(key);
            if(entry == null) {
                return null; // if key is not found in the cache, return null
            } else if(!entry.isExpired()) { // if key is not expired then update it's use time and return the value
                entry.updateUseTime();
                return entry.getValue();
            } else {
                cache.remove(key); // if a key is expired, remove it from the cache and return null
                return null;
            }

        } finally {
            lock.unlock();
        }

    }
}
