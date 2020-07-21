package com.timewentby.oom;

import javassist.CannotCompileException;
import javassist.ClassPool;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import sun.misc.VM;

import javax.sound.midi.SoundbankResource;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class OOMDemo {

    static final class T{}
    public static void main(String[] args) {
//        stackOverFlowError();
//        javaHeapOutOfMemoryError();
//        overheadOutOfMemoryError();
//        NIOOutOfMemoryError();
//        threadOutOfMemoryError();
        int i = 1;
        try {
            while (true) {
                i++;
                Enhancer enhancer = new Enhancer();
                enhancer.setSuperclass(T.class);
                enhancer.setUseCache(false);
                enhancer.setCallback((MethodInterceptor) (o, method, objects, methodProxy) -> methodProxy.invokeSuper(o, args));

            }
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            System.out.println("i" + i);
        }


    }

    private static void threadOutOfMemoryError() {
        int i = 1;
        while (true) {
            i++;
            try {
                new Thread(() -> {
                    try {
                        TimeUnit.HOURS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }).start();
            } catch (Exception exception) {
                exception.printStackTrace();
            } finally {
                System.out.println("i = " + i);
            }
        }
    }

    private static void NIOOutOfMemoryError() {
        long maxDirectMemory = VM.maxDirectMemory();
        // 打印5，堆外值分配5M内存
        System.out.println(maxDirectMemory / 1024 / 1024);
        // 在堆外分配6M内存，显然内存不够，因此抛出异常
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(6 * 1024 * 1024);
    }

    private static void overheadOutOfMemoryError() {
        int i = 0;
        ArrayList<String> list = new ArrayList<>();
        while (true) {
            list.add(String.valueOf(i++).intern());
        }
    }

    private static void javaHeapOutOfMemoryError() {
        String str = "";

        while (true) {
            str += str + "abc" + new Random().toString() + "";
            str.intern();
        }
    }


    private static void stackOverFlowError() {
        // 栈溢出
//        main(args);
    }
}
