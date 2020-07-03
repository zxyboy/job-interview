package cn.cupcat.sort;

import static cn.cupcat.sort.SortAlgorithm.swap;

public class SelectionSort {


    /**
     * 选择排序
     * 核心思想： 打擂台
     * 1、选择第一个数组元素作为最大值
     * 2、循环和最大值比较，如果比最大值大，则需要交换最大值。一轮技术将最大值归为
     * 3、一致循环，直到数组有序
     *
     * @param arr
     * @return
     */
    public static int[] chooseSort(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {
            int max = 0;
            for (int j = 1; j < arr.length - i; j++) {
                if (arr[j] > arr[max]) {
                    swap(arr, j, max);
                }
            }
            // 将最大值放到应该在的位置上
            swap(arr, max, arr.length - 1 - i);
        }
        return arr;
    }

}
