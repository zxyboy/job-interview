package cn.cupcat.search;

/**
 * 常见的查找
 * 1、二分查找
 */
public class SearchAlgorithm {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 5, 6, 7, 8, 9, 22, 99};
        int value = 88;
        int i = binarySearch(arr, 0, arr.length - 1, value);
        System.out.println("i = " + i);
    }


    /**
     * 二分查找, 查找必须是有序数组
     *
     * @param arr
     * @param left
     * @param right
     * @param value
     * @return
     */
    public static int binarySearch(int[] arr, int left, int right, int value) {


        int mid = (left + right) / 2;

        if (left > right){
            return -1;
        }

        if (arr[mid] > value) {
            return binarySearch(arr, left, mid - 1, value);
        } else if (arr[mid] < value) {
            return binarySearch(arr, mid + 1, right, value);
        } else {
            return mid;
        }
    }
}
