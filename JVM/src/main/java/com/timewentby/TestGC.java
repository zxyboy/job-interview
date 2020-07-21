package com.timewentby;

import java.util.Map;
import java.util.WeakHashMap;

public class TestGC {

    public static void main(String[] args) {
        Map<Integer, String> map = new WeakHashMap<>();
        String v = "va";
        Integer key = new Integer(1);
        map.put(key, v);
        System.out.println(map);
        key = null;
        System.gc();
        System.out.println(map);


    }
}
