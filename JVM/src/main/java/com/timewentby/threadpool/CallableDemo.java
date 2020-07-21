package com.timewentby.threadpool;

import java.util.concurrent.*;

public class CallableDemo {

    static class MyCallable implements Callable<Integer> {
        @Override
        public Integer call() throws Exception {
            TimeUnit.SECONDS.sleep(3);
            System.out.println(Thread.currentThread().getName() + "\t" + "callable is executing");
            return 1024;
        }
    }


    public static void main(String[] args) {

        System.out.println(Runtime.getRuntime().availableProcessors());

        ExecutorService poolExecutor = new ThreadPoolExecutor(
                2,
                5,
                10L,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());

        try {
            for (int i = 1; i <= 9; i++) {

                poolExecutor.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + "~~~~~~");
                });

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            poolExecutor.shutdown();
        }
    }

    private static void ThreadPoolDemo() {
        FutureTask<Integer> futureTask = new FutureTask<>(new MyCallable());
        FutureTask<Integer> futureTask2 = new FutureTask<>(new MyCallable());


        Thread thread1 = new Thread(futureTask);
        Thread thread2 = new Thread(futureTask2);
        thread1.start();
        thread2.start();
        try {
            // 会阻塞下面的主线程
            Integer result = futureTask.get();
            System.out.println(result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName() + "~~~~~~~~~~~");
    }
}
