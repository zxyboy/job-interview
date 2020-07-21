package com.timewentby.singleton;

public final class Singleton4 {

    private static Singleton4 singleton4;

    private Singleton4() {
        // 防止反射
        if (singleton4 == null) {
            singleton4 = this;
        } else {
            throw new RuntimeException(" Singleton4 is already inited");
        }
    }

    public static synchronized Singleton4 getInstance() {
        if (singleton4 == null) {
            synchronized (Singleton4.class) {
                if (singleton4 == null) {
                    singleton4 = new Singleton4();
                }
            }
        }
        return singleton4;
    }

}
