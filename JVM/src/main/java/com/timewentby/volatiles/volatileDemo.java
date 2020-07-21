package com.timewentby.volatiles;

public class volatileDemo {
    public static void main(String[] args) {

        Data date = new Data();

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "~~~~");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            date.setA();
        }).start();

        while (true) {
//            synchronized (date){
            if (date.a == 60) {
                System.out.println("__________");
                break;
            }
//            }
        }
    }

    static class Data {
        volatile int a = 0;

        public void setA() {
            a = 60;
        }
    }
}
