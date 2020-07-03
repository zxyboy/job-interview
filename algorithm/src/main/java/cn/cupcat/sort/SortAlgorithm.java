package cn.cupcat.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 本片介绍排序算法
 * 包括： 冒泡、插入、选择、快排等
 */
public class SortAlgorithm {


    public static void main(String[] args) {
//        int[] arr = {3, 1, 1, 9, 0, 60, 23, 100} ;

        int size = 20000000;
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = (int) (Math.random() * 100);
        }
        System.out.println("排序前：");
//        print(arr);

        long start = System.currentTimeMillis();
        BaseSort.baseSort(arr);
//        BaseSort.baseSort2(arr);
//        CounterSort.counterSort(arr, 10);
        long end = System.currentTimeMillis();


        System.out.println("排序后：用时：" + (end - start) + "毫秒");
//        print(arr);

    }


    /**
     * 交换数组arr index1和index2下标的位置
     *
     * @param arr
     * @param index1
     * @param index2
     */
    public static void swap(int[] arr, int index1, int index2) {
        int tmp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tmp;
    }

    public static void print(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }
}
