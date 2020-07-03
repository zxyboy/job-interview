package cn.cupcat.array;

import java.util.Arrays;

public class ArrayOperation {


    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        int[] ints = moveElement(arr, 5);

        Arrays.stream(ints).forEach(System.out::print);
    }

    /**
     * 求：数组向右移动step个元素以后数组中的元素情况,其中step大于0
     * <p>
     * 因为移动次数step可能大于length，也可能小于length。
     * 所以： 不管大于或者小于移动的次数都是 step %= length， 移动次数如果是length的整数倍，等于没有移动。
     * 思路：
     * 1、将数组中尾部元素取出
     * 2、数组中除尾部元素以后都向后移动一个位置， 直到数组尾部元素移动完位置
     * 3、重复1、2步骤 step次
     *
     * @param arr
     * @param step
     * @return
     */
    public static int[] moveElement(int[] arr, int step) {

        // 移动长度大于数组长度
        if (step < 0) {
            return arr;
        }

        int arrLength = arr.length;
        step %= arrLength;
        // 移动长度小于数组长度
        for (int i = 0; i < step; i++) {
            int tmp = arr[arrLength - 1];
            for (int j = arrLength - 2; j >= 0; j--) {
                arr[j + 1] = arr[j];
            }
            arr[0] = tmp;
        }
        return arr;
    }

}
