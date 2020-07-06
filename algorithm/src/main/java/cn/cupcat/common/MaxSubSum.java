package cn.cupcat.common;

public class MaxSubSum {
    public static void main(String[] args) {
        int[] arr = {0, 1, 2, -4, 2, 7, -9, 2, 12, -6};

        int maxSubSum = maxSubSum(arr);
        System.out.println("maxSubSum = " + maxSubSum);
    }

    /**
     * 求最大子列和问题
     *
     * @param arr
     * @return
     */
    public static int maxSubSum(int[] arr) {
        if (arr == null) {
            throw new IllegalArgumentException("arr不能为空！");
        }

        int maxSubSum = 0, thisSum = 0;
        for (int i = 0; i < arr.length; i++) {
            thisSum += arr[i];
            if (thisSum > maxSubSum) {
                maxSubSum = thisSum;
            } else if (thisSum < 0) {
                thisSum = 0;
            }
        }
        return maxSubSum;

    }
}
