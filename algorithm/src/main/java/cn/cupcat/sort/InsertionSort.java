package cn.cupcat.sort;

public class InsertionSort {

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

    public static int[] insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            // 摸下一张牌
            int tmp = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1] > tmp) {
                // 移动出空位置
                arr[j] = arr[j - 1];
                j--;
            }
            // 将牌放到对应的位置上
            arr[j] = tmp;
        }
        return arr;
    }

}
