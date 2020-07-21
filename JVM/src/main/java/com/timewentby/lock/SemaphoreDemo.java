package com.timewentby.lock;

import java.util.concurrent.Semaphore;

public class SemaphoreDemo {

    /**
     * 抢车位
     * 6部车，抢三个车位
     *
     * @param args
     */
    public static void main(String[] args) {
        // 三个车位
        Semaphore semaphore = new Semaphore(3);
        for (int i = 1; i <= 6; i++) {
            new Thread(() -> {
                try {
                    // 抢到车位
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + "抢到车位~~~~~");
                    // 模拟使用3秒钟
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    // 车被开走，其他车可以再次使用释放的车位
                    semaphore.release();
                    System.out.println(Thread.currentThread().getName() + "释放车位~~~~~");
                }
            }, String.valueOf(i)).start();
        }

    }
}
