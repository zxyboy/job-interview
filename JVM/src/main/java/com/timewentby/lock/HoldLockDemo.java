package com.timewentby.lock;

import java.util.concurrent.TimeUnit;

public class HoldLockDemo {


    static class DeadLock implements Runnable {
        private String lockA;
        private String lockB;

        public DeadLock(String lockA, String lockB) {
            this.lockA = lockA;
            this.lockB = lockB;
        }

        @Override
        public void run() {
            synchronized (lockA) {
                System.out.println(Thread.currentThread().getName() + "~~~~~持有" + lockA + ",想要获取：" + lockB);

                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lockB) {
                    System.out.println(Thread.currentThread().getName() + "~~~~~持有" + lockB + ",想要获取：" + lockA);
                }

            }
        }
    }

    /**
     * 死锁案例
     *
     * @param args
     */
    public static void main(String[] args) {

        String lockA = "lockA";
        String lockB = "lockB";
        DeadLock deadLock1 = new DeadLock(lockA, lockB);
        DeadLock deadLock2 = new DeadLock(lockB, lockA);

        new Thread(deadLock1, "thead-A").start();
        new Thread(deadLock2, "thead-B").start();


    }
}
