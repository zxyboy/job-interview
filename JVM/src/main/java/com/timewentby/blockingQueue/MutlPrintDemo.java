package com.timewentby.blockingQueue;

import java.util.HashMap;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MutlPrintDemo {
    /**
     * 三个线程
     * <p>
     * 按照线程顺序：
     * 线程A打印1次,线程B打印2次,线程C打印3次
     * 线程A打印1次,线程B打印2次,线程C打印3次
     * .....
     * 打印5轮
     *
     * <p>
     *
     * @param args
     */
    public static void main(String[] args) {
        ShareData shareData = new ShareData();
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                shareData.print(1,1,2);
            }
        }, "A").start();
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                shareData.print(2,2,3);
            }
        }, "B").start();

        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                shareData.print(3,3,1);
            }
        }, "C").start();
    }


}

class ShareData {
    private Integer num = 1;

    private Lock lock = new ReentrantLock();

    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private Condition condition3 = lock.newCondition();

    private HashMap<Integer, Condition> map = new HashMap<>();

    public ShareData() {
        map.put(1, condition1);
        map.put(2, condition2);
        map.put(3, condition3);
    }

    public void print(Integer size, Integer current, Integer await) {

        lock.lock();
        try {
            // 1、判断
            while (num != current) {
                try {
                    map.get(current).await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            // 2、干活
            for (int i = 0; i < size; i++) {
                System.out.println(Thread.currentThread().getName() + "\t " + i);
            }
            // 3、唤醒
            num = await;
            map.get(await).signal();
        } finally {
            lock.unlock();
        }
    }

    public void print1() {
        lock.lock();
        try {
            // 1、判断
            while (num != 1) {
                try {
                    condition1.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            // 2、干活
            for (int i = 0; i < 1; i++) {
                System.out.println(Thread.currentThread().getName() + "\t " + i);
            }
            // 3、通知
            // 修改标志位
            num = 2;
            // 精确通知condition2
            condition2.signal();

        } finally {
            lock.unlock();
        }

    }

    public void print2() {
        lock.lock();
        try {
            // 1、判断
            while (num != 2) {
                try {
                    condition2.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            // 2、干活
            for (int i = 0; i < 2; i++) {
                System.out.println(Thread.currentThread().getName() + "\t " + i);
            }
            // 3、通知
            // 修改标志位
            num = 3;
            // 精确通知condition3
            condition3.signal();

        } finally {
            lock.unlock();
        }

    }

    public void print3() {
        lock.lock();
        try {
            // 1、判断
            while (num != 3) {
                try {
                    condition3.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            // 2、干活
            for (int i = 0; i < 3; i++) {
                System.out.println(Thread.currentThread().getName() + "\t " + i);
            }
            // 3、通知
            // 修改标志位
            num = 1;
            // 精确通知condition1
            condition1.signal();

        } finally {
            lock.unlock();
        }

    }


}
