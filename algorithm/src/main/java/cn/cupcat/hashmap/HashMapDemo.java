package cn.cupcat.hashmap;

import java.util.HashMap;
import java.util.Map;

public class HashMapDemo {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        int key = 1;
        for (int i = 0; i < 10; i++) {
            String kv = String.valueOf(key);
            String v = String.valueOf(i);
            map.put(kv, v);
        }
        map.forEach((k, v) -> System.out.println(k + "->" + v));
//        int cap = 5;
//        int sizeFor = tableSizeFor(cap);
//        System.out.println(sizeFor);
    }

    static final int MAXIMUM_CAPACITY = 1 << 30;
    static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }

}
