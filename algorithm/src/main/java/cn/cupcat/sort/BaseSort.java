package cn.cupcat.sort;

import java.util.Arrays;

public class BaseSort {


    /**
     * 基数排序 ： 通过创建二维数组创建桶
     * 缺点：占用空间太大
     *
     * @param arr
     */
    public static void baseSort(int[] arr) {
        // 1、找出基数中最大值
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        // 创建桶
        int[][] bucket = new int[10][arr.length];
        // 每一个桶内指针，表示每个桶内元素个数
        int[] bucketManager = new int[10];

        int maxLength = (max + "").length();
        // 2、循环最大值的长度
        for (int i = 0, n = 1; i < maxLength; i++, n *= 10) {
            for (int j = 0; j < arr.length; j++) {
                // digit表示当前数字，存放桶的位置
                int digit = arr[j] / n % 10;
                // 3、每次遍历按照个、十、百、千位...等将对应位置放进对应的桶内
                bucket[digit][bucketManager[digit]] = arr[j];
                bucketManager[digit] += 1;
            }

            int index = 0;
            // 4、遍历桶内元素填充到原数组并将所有桶内标志元素置空
            for (int x = 0; x < bucket.length; x++) {
                // 桶内有值
                if (bucketManager[x] > 0) {
                    for (int k = 0; k < bucketManager[x]; k++) {
                        arr[index++] = bucket[x][k];
                    }
                    bucketManager[x] = 0;
                }
            }
        }
    }

    /**
     * 计数排序： 基于次要优先算法
     * 使用计算排序
     *
     * @param arr
     */
    public static void baseSort2(int[] arr) {

        // 1、求出最大值的长度
        int max = findMaxValue(arr);
        int maxLength = (max + "").length();

        // 2、创建桶（这里桶使用计数数组表示）
        int[] countArr = new int[10];

        int[] tmpArr = new int[arr.length];

        // 3、循环最大值长度，分别将各位、十位、百位、...等放入到指定的桶中
        for (int i = 0, division = 1; i < maxLength; i++, division *= 10) {

            for (int j = 0; j < arr.length; j++) {
                int element = arr[j];
                int bucket = element / division % 10;
                countArr[bucket]++;
            }

            // 4、下面是使用计算排序
            // 修改计数数组的值
            for (int k = 1; k < countArr.length; k++) {
                countArr[k] += countArr[k - 1];
            }
            // 将原数组中值移动到临时数组中，移动完成以后。那么临时数据将会是有序的。
            for (int x = arr.length - 1; x >= 0; x--) {
                int element = arr[x];
                int bucket = element / division % 10;
                tmpArr[--countArr[bucket]] = element;
            }

            // 将临时数据中元素移动到原数组中
            for (int j = 0; j < arr.length; j++) {
                arr[j] = tmpArr[j];
            }

            // 5、清空计数数组
            Arrays.fill(countArr, 0);

        }


    }

    /**
     * 查找数组中最大值
     *
     * @param arr
     * @return
     */
    public static int findMaxValue(int[] arr) {
        int max = arr[0];

        for (int i = 1; i < arr.length; i++) {
            int element = arr[i];
            if (element > max) {
                max = element;
            }
        }
        return max;
    }
}
