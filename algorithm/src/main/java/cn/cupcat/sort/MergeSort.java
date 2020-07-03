package cn.cupcat.sort;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int[] arr = {3, 1, -1, 9, 0, 60, 23, 100};

        System.out.println("排序前：" + Arrays.toString(arr));

        mergeSort(arr);
        System.out.println("排序后：" + Arrays.toString(arr));
    }

    public static void mergeSort(int[] arr) {
        int length = 1;
        int n = arr.length;
        int[] tmpArr = new int[n];

        while (length < n) {
            mergePass(arr, tmpArr, n, length);
            length *= 2;
            mergePass(tmpArr, arr, n, length);
            length *= 2;
        }
    }

    /**
     * 合并
     *
     * @param arr
     * @param tmpArr
     * @param n      数组长度
     * @param length 当前有序子列的长度
     */
    private static void mergePass(int[] arr, int[] tmpArr, int n, int length) {

        int i = 0;
        // 将能够合并的子列合并
        while (i <= n - 2 * length) {
            merge(arr, tmpArr, i, i + length, i + 2 * length - 1);
            i += 2 * length;
        }

        // 归并最后2个子列
        if (i + length < n) {
            merge(arr, tmpArr, i, i + length, n - 1);
        } else {
            // 最后只剩下一个子列,直接放到temp数组的末尾
            for (int j = i; j < n; j++) {
                tmpArr[j] = arr[j];
            }
        }

    }

    private static void merge(int[] arr, int[] tmpArr, int left, int right, int end) {
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
    }


}
