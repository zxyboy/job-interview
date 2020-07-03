package cn.cupcat.sort;

import static cn.cupcat.sort.SortAlgorithm.print;
import static cn.cupcat.sort.SortAlgorithm.swap;

public class HeapSort {

    /**
     * 堆排序，是对选择排序的一种改进，将查找最小值/最大值使用最小堆/最大堆来实现
     * <p>
     * 思想：
     * 1、现将数组排列成最大堆（最小堆，一般使用最大堆升序）
     * 最大堆特点：
     * a、最大堆相当于一个完全二叉树
     * b、二叉树的根节点是最大
     * c、父节点比左右子节点都要大
     * d、如果按照二叉树乘次
     * <p>
     * 构建最大堆方法：
     * a、方法一：从前往后构建
     * <p>
     * b、方法二：从后往前构建
     * <p>
     * <p>
     * 2、将堆顶中元素移除和数组中最后一位元素交换，移除堆中最后一个元素（最大值），重新构建最大堆
     * 3、继续1，2直到排序完成
     *
     * @param arr
     * @return
     */
    public static int[] heapSort(int[] arr) {
        // 将数组构建成最大堆
        buildMaxHeap(arr, 0, arr.length);
        int count = 1;
        System.out.println("第" + count++ + "次buildMaxHeap后：");
        print(arr);
        // 从新构建最大堆，重复以上步骤，直到堆没有元素为止
        for (int i = arr.length - 1; i > 0; i--) {
            // 取出堆栈顶部元素与最后一个元素交换位置
            swap(arr, 0, i);
            // 在堆栈中除去数组中最后一个元素
            buildMaxHeap(arr, 0, i);
            System.out.println("第" + count++ + "次buildMaxHeap后：");
            print(arr);
        }

        return arr;
    }

    /**
     * 将数组中元素构建成最大堆
     *
     * @param arr
     * @param start  数组开始下标，从0开始
     * @param length 数组长度
     */
    private static void buildMaxHeap(int[] arr, int start, int length) {
        // 实现方式一：从前往后依次构建完全二叉树

        // 这里按照数组元素下标从1（start + 1）开始计算，因为这样符合完全二叉树的规则
        for (int i = start + 1; i <= length; i++) {
            // 当前元素实际下标为： i-1
            int currentIndex = i - 1;
            // 当前元素父节点实际下标： i / 2 - 1 , 这里都-1是因为我们开始循环的时候下标都 + 1了
            int parentIndex = i / 2 - 1;

            // 第一个元素不需要判断，以后元素都判断，直到根节点位置
            while (currentIndex > 0 && parentIndex >= 0) {
                // 如果当前元素大于父节点元素，则交换当前元素和父节点元素位置
                if (arr[currentIndex] > arr[parentIndex]) {
                    swap(arr, currentIndex, parentIndex);
                } else {
                    // 不符合，就跳出循环
                    break;
                }
                // 通过上面交换完成以后，修改当前节点下标为父节点下标。继续向上面父节点判断，直到到达根节点
                currentIndex = parentIndex;
                // 通过上面交换完成以后,修改父节点下标为父节点的父节点，。继续向上面父节点判断，直到到达根节点
                parentIndex = (parentIndex + 1) / 2 - 1;

            }
        }
    }

    private static void buildMaxHeap1(int[] arr, int start, int length) {
        // 实现方式二：从后往前依次构建完全二叉树,
        // 因为n/2是最后一个有子节点的元素，所以只需要 0到n/2 做好最大堆即可
        for (int i = length / 2; i >= start + 1; i--) {

            int leftChild = 2 * i;
            int currentIndex = i - 1;
            // 如果左子树节点大于数组长度则终止
            while (leftChild <= length) {

                int currentValue = arr[currentIndex];
                int leftValue = arr[leftChild - 1];
                int rightChild = leftChild + 1;

                // 如果右孩子节点大于长度，则不需要计算右孩子节点
                if (rightChild > length) {
                    if (leftValue > currentValue) {
                        swap(arr, leftChild - 1, currentIndex);
                        // 更新做孩子节点，跳出循环
                        leftChild = leftChild * 2;
                    } else {
                        // 注意： 这里的break不能省略，如果只有左叶子节点并且不满足leftValue > currentValue条件
                        // 就不会跳出循环，从而导致死循环
                        break;
                    }
                } else {
                    int rightValue = arr[rightChild - 1];
                    int max = Integer.max(leftValue, rightValue);
                    if (max > currentValue) {
                        if (max == leftValue) {
                            swap(arr, leftChild - 1, currentIndex);
                            currentIndex = leftChild - 1;
                            leftChild = leftChild * 2;

                        } else {
                            swap(arr, rightChild - 1, currentIndex);
                            currentIndex = rightChild - 1;
                            leftChild = rightChild * 2;
                        }
                    } else {
                        // 这里的break不能省略，这是不符合max > currentValue不成立时，立刻结束循环。
                        break;
                    }
                }
            }
        }
    }



}
