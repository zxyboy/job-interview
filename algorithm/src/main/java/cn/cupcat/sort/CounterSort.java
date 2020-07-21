package cn.cupcat.sort;

import java.util.Arrays;

/**
 * 计数排序
 */
public class CounterSort {


    /**
     * 计数排序
     * <p>
     * 参考视频：https://www.bilibili.com/video/BV1GW411H7Cs?from=search&seid=7909663925247503830
     * 参考文章：https://www.geeksforgeeks.org/counting-sort/
     * <p>
     * 使用前提：
     * 1、已知数组内元素值大小范围
     * 2、元素大小范围远远小于数组个数
     * <p>
     * 排序思想：
     * 1、构建count计数数组和保存结果的额外数组
     * 2、遍历数组，使用count数组计数
     * 3、修改计数数组 count[i] = count[i] + count[i - 1] ; i >= 1
     * 4、将数据从原数组转移到额外数组内 tmp[counter[--count]] = arr[i]，转移完成，此时，tmp就是有序的。
     * 5、将数据从tmp数组转移到原数组
     *
     * @param arr   待排序数组
     * @param count 待排序数组中值最大范围， 比如：值范围是0~9，则传入10 ;
     *              如果数据中出现非连续性数字，则另外处理
     */
    public static void counterSort(int[] arr, int count) {

        // 1、构建counter数组
        int[] counterArr = new int[count];
        // 创建临时数组
        int[] tmpArr = new int[arr.length];

        // 2、遍历数组，使用counter数据计数
        for (int i = 0; i < arr.length; i++) {
            counterArr[arr[i]]++;
        }
        // 3、修改计数数组的值：count[i] = count[i] + count[i - 1] ; i >= 1
        for (int i = 1; i < counterArr.length; i++) {
            counterArr[i] += counterArr[i - 1];
        }

        // 4、将数据从原数组转移到额外数组内 tmp[counter[--count]] = arr[i]，转移完成，此时，tmp就是有序的。
        for (int i = arr.length - 1; i >= 0; i--) {
            int value = arr[i];
            tmpArr[--counterArr[value]] = value;
        }

        // 5、将数据从tmp数组转移到原数组
        for (int i = 0; i < arr.length; i++) {
            arr[i] = tmpArr[i];
        }
    }

}
