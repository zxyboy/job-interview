package cn.cupcat.sort;

import java.util.ArrayList;
import java.util.List;

/**
 * 本片介绍排序算法
 * 包括： 冒泡、插入、选择、快排等
 */
public class MergeSortRecursive {


    public static void main(String[] args) {
        int[] arr = {3, 1, -1, 9, 0, 60, 23, 100};

        System.out.println("排序前：");
        print(arr);
        mergeSort(arr);
        print(arr);
    }

    /**
     * 归并排序
     *
     * @param arr
     * @return
     */
    public static void mergeSort(int[] arr) {
        // 创建临时数组
        int[] tmpArr = new int[arr.length];
        separate(arr, tmpArr, 0, arr.length - 1);
    }

    /**
     * 归并排序分开过程
     *
     * @param arr
     * @param tmpArr
     * @param left   数组开始位置下标
     * @param right  数组结束位置下标
     */
    public static void separate(int[] arr, int[] tmpArr, int left, int right) {
        // 数组中有元素，递归分
        if (left < right) {
            int mid = (left + right) / 2;
            // 递归分左边
            separate(arr, tmpArr, left, mid);
            // 递归分右边
            separate(arr, tmpArr, mid + 1, right);
            // 合并
            merge(arr, tmpArr, left, mid + 1, right);
        }
    }

    /**
     * 归并排序合并过程
     *
     * @param arr    原数组
     * @param tmpArr 临时数组
     * @param left   左有序数组开始下标
     * @param right  有有序数组开始下标
     * @param end    原数组末尾下标
     */
    public static void merge(int[] arr, int[] tmpArr, int left, int right, int end) {

        System.out.println("xxxxx");
        // i : 指向左边有序数组开始位置下标
        // j : 指向右边有序数组开始位置下标
        // tmpIndex : 指向临时数组开始位置下标
        // mid : 指向左边有序数组结束位置下标
        // end : 指向右边有序数组结束位置下标

        int i = left, j = right, tempIndex = left, mid = right - 1;

        // 比较两个有序数组大小，存放到临时数组中，直到一个有序数组全部存放到临时数组
        //i <= j - 1 : 是因为左边有序数组和右边有序数组是连续的，右边开始位置 -1 ，就是左边有序数组的结束下标位置
        while (i <= mid && j <= end) {
            // 左边有序数组当前元素小于等于右边有序数组当前元素,将左边有序数组元素移动到临时当前位置，
            // 同时左边有序数组下标 + 1 ， 临时数组下标 + 1
            if (arr[i] <= arr[j]) {
                tmpArr[tempIndex++] = arr[i++];
            } else {
                tmpArr[tempIndex++] = arr[j++];
            }
        }
        // 将第一个有序数组剩下的元素存放到临时数组
        while (i <= mid) {
            tmpArr[tempIndex++] = arr[i++];
        }
        // 将第二个有序数组剩下的元素存放到临时数组
        while (j <= end) {
            tmpArr[tempIndex++] = arr[j++];
        }

        System.out.println("left = " + left + ", right =" + right + ", end = " + end);
        // 将临时数组元素拷贝到原始数组内
        for (int start = left; start <= end; start++) {
            arr[start] = tmpArr[start];
        }

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
