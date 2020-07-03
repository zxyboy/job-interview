package cn.cupcat.sort;

import static cn.cupcat.sort.SortAlgorithm.swap;

public class BubbleSort {

    /**
     * 冒泡排序
     * 原理：
     * 1、两个相邻数据相互比较，如果前面大于后面数据，则交换位置
     * 2、外层循环控制循环次数
     * 3、内层循环负责比较数据
     *
     * @param arr
     * @return
     */
    public static int[] bubbleSort(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {

            // 标志数数组是否已经有序
            boolean flag = true;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    // 有数据交换，说明还没有有序
                    if (flag) {
                        flag = false;
                    }
                    swap(arr, j, j + 1);
                }
            }
            if (flag) {
                return arr;
            }
        }
        return arr;
    }

    public static int[] bubbleSort2(int[] arr) {

        for (int loopCount = arr.length - 1; loopCount >= 0; loopCount--) {
            // 标志数数组是否已经有序
            boolean flag = true;
            for (int j = 0; j < loopCount; j++) {
                if (arr[j] > arr[j + 1]) {
                    // 有数据交换，说明还没有有序
                    if (flag) {
                        flag = false;
                    }
                    swap(arr, j, j + 1);
                }
            }
            if (flag) {
                return arr;
            }
        }
        return arr;
    }
}
