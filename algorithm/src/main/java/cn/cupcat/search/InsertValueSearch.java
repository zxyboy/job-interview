package cn.cupcat.search;

/**
 * 插值查找算法
 */
public class InsertValueSearch {

    public static void main(String[] args) {
//        int[] arr = {1, 2, 3, 4, 5, 6, 7, 7};
        int[] arr = {7, 7, 7, 7, 7, 7, 7, 7};
        int key = 7;
        int index = insertValueSearch(arr, 0, arr.length - 1, key);
        System.out.println("index = " + index);
    }


    /**
     * 插值查找算法
     * 前提： 数组是有序的
     *
     *  计算mid：
     *  mid = left + (right - left) * (key - arr[left]) / (arr[right] - arr[left]);
     * @param arr   数组
     * @param left  数组开始下标
     * @param right 数组结束下标
     * @param key   关键字
     * @return
     */
    public static int insertValueSearch(int[] arr, int left, int right, int key) {
        // 注意：不加 key > arr[arr.length - 1] || key < arr[0] 下标可能会越界
        if (left > right || key > arr[arr.length - 1] || key < arr[0]) {
            return -1;
        }

        int mid = left + (right - left) * (key - arr[left]) / (arr[right] - arr[left]);

        if (key > arr[mid]) {
            return insertValueSearch(arr, mid + 1, right, key);
        } else if (key < arr[mid]) {
            return insertValueSearch(arr, left, mid - 1, key);
        } else {
            return mid;
        }

    }

}
