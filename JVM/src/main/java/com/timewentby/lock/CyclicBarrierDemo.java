package com.timewentby.lock;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {

    public static void main(String[] args) {

        CyclicBarrier cyclicBarrier = new CyclicBarrier(4, () -> {
            System.out.println(Thread.currentThread().getName() + "四剑合璧，天下无敌！");
        });
        for (int i = 1; i <= 4; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "剑，重出江湖~~~~~");
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }, String.valueOf(i)).start();
        }
    }
}
