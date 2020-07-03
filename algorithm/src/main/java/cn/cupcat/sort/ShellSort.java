package cn.cupcat.sort;

public class ShellSort {


    /**
     * 希尔排序：对插入排序的改进
     *
     * @param arr
     * @return
     */
    public static int[] shellSort(int[] arr) {

        // 希尔增量序列
        for (int duration = arr.length / 2; duration > 0; duration /= 2) {
            // 插入排序
            for (int i = duration; i < arr.length; i++) {
                int tmp = arr[i];

                int j = i;
                while (j > 0 && arr[j - duration] > tmp) {
                    arr[j] = arr[j - duration];
                    j -= duration;
                }
                arr[j] = tmp;
            }
        }
        return arr;
    }


}
