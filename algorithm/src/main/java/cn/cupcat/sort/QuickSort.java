package cn.cupcat.sort;

import static cn.cupcat.sort.SortAlgorithm.swap;

public class QuickSort {

    /**
     * 快速排序
     *
     * @param arr
     * @return
     */
    public static int[] quickSort(int[] arr, int begin, int end) {
        int i = begin;
        int j = end;
        // 取数组中第一个元素作为基准值
        int pivot = arr[begin];

        while (i < j) {
            // 右边指针移动，大于基准值忽略，直到找到小于基准值结束
            while (arr[j] > pivot && i < j) {
                j--;
            }
            // 左边指针移动，小于基准值忽略，直到找到大于基准值结束
            while (arr[i] <= pivot && i < j) {
                i++;
            }
            // 相遇
            if (i == j) {
                swap(arr, i, begin);
            } else {
                swap(arr, i, j);
            }
        }

        // 左边排序
        if (i - 1 > begin) {
            quickSort(arr, begin, i - 1);
        }
        // 右边排序
        if (j + 1 < end) {
            quickSort(arr, i + 1, end);
        }
        return arr;
    }

}
