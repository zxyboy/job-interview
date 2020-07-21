package com.timewentby.singleton;

public final class Singleton2 {

    private static volatile Singleton2 singleton2;

    private static boolean flag = true;

    private Singleton2() {
        if (flag) {
            flag = false;
        } else {
            throw new RuntimeException(" Singleton2 is already init");
        }
    }

    public static Singleton2 getInstance() {
        Singleton2 singleton = singleton2;

        if (singleton == null) {
            synchronized (Singleton2.class) {
                singleton = singleton2;
                if (singleton == null) {
                    singleton2 = singleton = new Singleton2();
                }
            }
        }
        return singleton;
    }

}
