package com.timewentby.blockingQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ArrayBlockingQueueDemo {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(2);

        blockingQueue.offer("a");
        blockingQueue.put("b");
        blockingQueue.put("a");


        System.out.println("-==============");

        System.out.println("-==============");


    }
}
