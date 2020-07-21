package com.timewentby.lock;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {
    private static Integer numThread = 3;

    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(numThread);
        for (int i = 0; i < numThread; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "执行........");
                countDownLatch.countDown();
            }, Country.getInstance(i).getName()).start();
        }
        try {
            countDownLatch.await();
            System.out.println("main thread  finished。。。。。。。。");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

enum Country {
    England(1, "英国"),
    China(2, "中国"),
    USA(0, "美国");


    private Integer code;
    private String name;

    Country(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    public Integer getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public static Country getInstance(Integer code) {
        for (Country country : Country.values()) {
            if (country.code == code) {
                return country;
            }
        }
        return null;
    }
}




