package com.timewentby.singleton;

public final class Singleton3 {


    private Singleton3() {

    }

    public static Singleton3 getInstance() {
        return Singleton3Help.singleton3;
    }

    /**
     * 利用类加载机制
     */
    private static class Singleton3Help {

        public static final Singleton3 singleton3 = new Singleton3();

    }

}
