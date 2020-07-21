package com.timewentby.blockingQueue;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class ShardData {
    private int number = 0;

    private Lock lock = new ReentrantLock();

    private Condition condition = lock.newCondition();

    public void increment() {

        lock.lock();
        try {
            while (number != 0) {
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
            number++;
            System.out.println(Thread.currentThread().getName() + "\t" + "生产完成~~~~~~" + number);
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public void decrement() {
        lock.lock();
        try {
            while (number == 0) {
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
            number--;
            System.out.println(Thread.currentThread().getName() + "\t" + "消费完成~~~~~~" + +number);
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }
}

/**
 * 线程      操作      资源类
 * <p>
 * 1、
 */
public class ProductConsumerTraditionDemo {
    public static void main(String[] args) {
        ShardData shardData = new ShardData();

        new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                shardData.increment();
            }
        }, "AA").start();

        new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                shardData.decrement();
            }
        }, "BB").start();

    }

}
