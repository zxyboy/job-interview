package cn.cupcat.sort;

import java.util.ArrayList;
import java.util.List;

/**
 * 本片介绍排序算法
 * 包括： 冒泡、插入、选择、快排等
 */
public class SortAlgorithm {


    public static void main(String[] args) {
        int[] arr = {3, 1, -1, 9, 0, 60, 23};

        System.out.println("排序前：");

        print(arr);
//         冒泡排序
//        int[] bubbleArray = bubbleSort(arr);
//        System.out.println("bubble排序后：");
//        print(bubbleArray);

//        int[] choose = chooseSort(arr);
//        int[] insertSort = insertSort(arr);
        int[] quickSort = quickSort(arr, 0, arr.length - 1);
        print(quickSort);
    }

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


    /**
     * 插入排序思想：
     * 1、将数组分为两个数组，一个为有序数据，另一位为无序数组
     * 2、将无序数组中的每一个元素比较以后插入到有序数据中
     * 3、通常将数组中的第一个元素作为有序数据
     *
     * @param arr
     * @return
     */
    public static int[] insertSort(int[] arr) {


        for (int i = 1; i < arr.length; i++) {

            if (arr[i] < arr[i - 1]) {
                int tmp = arr[i];
                for (int last = i - 1; last >= 0; last--) {
                    if (tmp < arr[last]) {
                        arr[last + 1] = arr[last];
                        if (last == 0) {
                            arr[last] = tmp;
                        }
                    } else {
                        arr[last + 1] = tmp;
                        break;
                    }
                }
            }
        }
//        int tmp;
//        for (int i = 1; i < arr.length; i++) {
//            // 当前无序数组第一个元素小于有序数组最后一个元素时，需要定位到 i在有序数据中的位置
//            if (arr[i] < arr[i - 1]) {
//                tmp = arr[i];
//
//                for (int j = i; j > 0; j--) {
//                    // 找到当前元素i应该在的位置
//                    if (tmp > arr[j - 1]) {
//                        arr[j] = tmp;
//                        break;
//                    } else {
//                        arr[j] = arr[j - 1];
//                    }
//                }
//            }
//        }
        return arr;
    }


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
        List<String> list = new ArrayList<>(arr.length);
        for (int i : arr) {
            list.add(String.valueOf(i));
        }
        String join = String.join(",", list);

        System.out.println(join);
    }
}
