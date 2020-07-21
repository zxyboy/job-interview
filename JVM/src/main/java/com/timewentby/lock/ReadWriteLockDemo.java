package com.timewentby.lock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读写锁
 * ReentrantReadWriteLock ： 读锁和写锁都在这个类中
 * <p>
 * private final ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
 * // 读锁
 * private final Lock r = rwl.readLock();
 * // 写锁
 * private final Lock w = rwl.writeLock();
 */
public class ReadWriteLockDemo {


    static class MyCache {

        private volatile Map<String, Object> cache = new HashMap<>();
        private final ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();

        private final Lock r = rwl.readLock();
        private final Lock w = rwl.writeLock();

        public void push(String key, Object value) {

            w.lock();
            try {
                String name = Thread.currentThread().getName();
                System.out.println(name + "~~~~正在保存key ： " + key);
                cache.put(key, value);
                System.out.println(name + "~~~~保存key ： " + key + "，完成");
            } finally {
                w.unlock();
            }
        }

        public Object get(String key) {

            r.lock();
            try {
                String name = Thread.currentThread().getName();
                System.out.println(name + "~~~~正在读取key ： " + key);
                Object value = cache.get(key);
                System.out.println(name + "~~~~读取key ： " + key + "，完成， value = " + value);
                return value;
            } finally {
                r.unlock();
            }
        }

        public void clear() {
            w.lock();
            try {
                cache.clear();
            } finally {
                w.unlock();
            }
        }

    }

    public static void main(String[] args) {
        MyCache cache = new MyCache();

        for (int i = 1; i < 5; i++) {
            final int j = i;
            new Thread(() -> {
                cache.push(String.valueOf(j), String.valueOf(j));
            }, String.valueOf(i)).start();
        }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 1; i < 5; i++) {
            final int j = i;
            new Thread(() -> {
                cache.get(String.valueOf(j));
            }, String.valueOf(i)).start();
        }
    }
}
