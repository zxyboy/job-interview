package cn.cupcat.search;

import java.util.Arrays;

/**
 * 斐波那契查找
 * 一般用作有序查找
 */
public class FibnaccSearch {
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 5, 6, 7, 8, 9};
        int i = fibSearch(arr, 2);
        System.out.println("index = " + i);

//        System.out.println(Arrays.toString(fib(20)));

    }


    /**
     * 生成斐波那契数列
     *
     * @param n 斐波那契数列的数量
     * @return
     */
    public static int[] fib(int n) {
        if (n <= 2) {
            throw new IllegalArgumentException("n不能小于3");
        }
        int[] arr = new int[n];
        arr[0] = 1;
        arr[1] = 1;
        for (int i = 2; i < n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr;
    }

    /**
     * 斐波那契查到：
     * mid = low + fib(k -1 ) - 1
     *
     * @param arr
     * @param key
     * @return
     */
    public static int fibSearch(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;
        int[] fibArr = fib(20);
        // k表时黄金分割点下标
        int k = 0;
        int mid = 0;

        // 找到比数据长度最接近斐波那契数据数组（fibArr）中的下标k，注意：此时k对应的斐波那契数列数组中的值可能大于arr.length
        while (high > fibArr[k] - 1) {
            k++;
        }
        // 因为 fibArr[k]的值可能大于数组arr的长度，因此我们需要将arr数据元素拷贝到tmpArr中
        int[] tmpArr = arr;
        if (arr.length < fibArr[k]) {
            tmpArr = Arrays.copyOf(arr, fibArr[k]);
            // 将扩容以后的值，填充成arr最后一个元素的值
            for (int i = high + 1; i < fibArr[k]; i++) {
                tmpArr[i] = arr[high];
            }
        }

        while (low <= high) {
            mid = low + fibArr[k - 1] - 1;
            if (key < tmpArr[mid]) {
                high = mid - 1;
                k--;
            } else if (key > tmpArr[mid]) {
                low = mid + 1;
                k -= 2;
            } else {
                return Integer.min(mid, high);
            }
        }
        return -1;
    }

}
