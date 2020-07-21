package com.timewentby.lock;

import java.util.concurrent.atomic.AtomicReference;

public class SpinLockDemo {

    AtomicReference<Thread> atomicReference = new AtomicReference<>();

    public void mylock() {

        Thread thread = Thread.currentThread();
        System.out.println( thread.getName() + "加锁 ------" );
        while (!atomicReference.compareAndSet(null, thread)) {
            System.out.println("~~~~~~~~~~~~~");
            try {
                Thread.sleep(500L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void myunlock() {
        Thread thread = Thread.currentThread();

        System.out.println( thread.getName() + "解锁 ------" );
        atomicReference.compareAndSet(thread, null);

    }

    public static void main(String[] args) {
        SpinLockDemo spinLockDemo = new SpinLockDemo();

        new Thread(() -> {
            spinLockDemo.mylock();
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            spinLockDemo.myunlock();
        }, "t1").start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        new Thread(() -> {
            spinLockDemo.mylock();
            spinLockDemo.myunlock();
        }, "t2").start();
    }

}
