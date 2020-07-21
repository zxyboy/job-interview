package com.timewentby.reference;


import java.lang.ref.*;

public class ReferenceDemo {
    public static void main(String[] args) {
        phantomReferenceDemo();
//        weakPerenceDemo();
//        softReferenceDemo();
    }

    private static void softReferenceDemo() {
        // JVM参数：-Xms10m -Xmx10m
        Object object = new Object();
        Reference<Object> reference = new SoftReference<>(object);

        System.out.println(object);
        System.out.println(reference);

        try {
            // 将Object赋值为null
            object = null;
            // 申请操作堆内存操作
            byte[] bytes = new byte[1024 * 1024 * 20];
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println(object); // null
            System.out.println(reference.get()); // null
        }
    }

    private static void weakPerenceDemo() {
        // JVM参数：-Xms10m -Xmx10m
        Object object = new Object();
        Reference<Object> reference = new WeakReference<>(object);

        System.out.println(object);
        System.out.println(reference);
        // 注意： 这里一定要赋值成null，才会被清除
        object = null;
        System.gc();
        System.out.println(object); // null
        System.out.println(reference.get()); // null
    }

    private static void phantomReferenceDemo() {
        // JVM参数：-Xms10m -Xmx10m
        Object object = new Object();
        ReferenceQueue<Object> referenceQueue = new ReferenceQueue<>();
        Reference<Object> reference = new PhantomReference<>(object, referenceQueue);

        System.out.println(object);// java.lang.Object@511d50c0
        System.out.println(reference);// java.lang.ref.PhantomReference@60e53b93
        System.out.println(reference.get()); // null
        System.out.println(referenceQueue.poll()); // null

        System.out.println("~~~~~~~~~~~~~~");
        // 将object赋值为null
        object = null;
        System.gc();
        System.out.println(object); // java.lang.Object@511d50c0
        System.out.println(reference);// java.lang.ref.PhantomReference@60e53b93
        System.out.println(reference.get()); // null
        // 只有object=null时，才会打印PhantomReference，否则打印null
        // 换句话说：只要object被垃圾回收,才会被添加到引用队列中
        System.out.println(referenceQueue.poll()); // java.lang.ref.PhantomReference@60e53b93
    }
}
