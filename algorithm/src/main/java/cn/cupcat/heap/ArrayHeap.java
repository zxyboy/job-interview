package cn.cupcat.heap;

/**
 * 使用一个数组实现两个堆栈
 */
public class ArrayHeap {

    public static void main(String[] args) {
        Heap<Integer> heap = new Heap<>(5);

        boolean full = heap.isFull();
        boolean empty1 = heap.isEmpty(HeapFlag.HEAP_ONE);
        boolean empty2 = heap.isEmpty(HeapFlag.HEAP_TWO);

        System.out.println("full: " + full + ", empty1: " + empty1 + ", empty2 :" + empty2);

        heap.push(1, HeapFlag.HEAP_ONE);
        heap.push(2, HeapFlag.HEAP_ONE);
        heap.push(3, HeapFlag.HEAP_TWO);
        heap.push(4, HeapFlag.HEAP_TWO);
        heap.push(5, HeapFlag.HEAP_TWO);


        Integer pop = heap.pop(HeapFlag.HEAP_TWO);
        System.out.println(pop);


        full = heap.isFull();
        empty1 = heap.isEmpty(HeapFlag.HEAP_ONE);
        empty2 = heap.isEmpty(HeapFlag.HEAP_TWO);

        System.out.println("full: " + full + ", empty1: " + empty1 + ", empty2 :" + empty2);

    }

    /**
     * 本案例中是使用一个数组来实现两个堆栈
     * <p>
     * 思路：
     * 一、两个堆栈分别从数组开头和结尾开始
     * 1、第一个堆栈heap1从索引0开始
     * 2、第二个堆栈heap2从索引 arr.length -1 开始
     * 二、定义两个指针分别指向heap1和heap2的栈顶
     * 1、p1初始化为-1 , p2初始化为arr.length （默认不指向任何地方）
     * 2、p1 指向heap1堆顶， p2指向heap堆顶
     *
     * @param <T>
     */
    static class Heap<T> {
        /**
         * 两个堆总大小
         */
        private int size;

        private Object[] data;

        /**
         * 指向第一个堆栈栈顶位置
         */
        private int p1 = -1;
        /**
         * 指向第二堆栈栈顶位置
         */
        private int p2;

        public Heap(int size) {
            if (size <= 0) {
                throw new IllegalArgumentException("size必须大于0！");
            }
            this.size = size;
            p2 = size;
        }

        /**
         * 添加元素到堆栈中
         *
         * @param t
         * @param flag ： 表示指定那个堆栈
         */
        public void push(T t, HeapFlag flag) {
            if (isFull()) {
                throw new ArrayIndexOutOfBoundsException("堆栈已满无法添加元素！");
            }
            // 第一次添加元素初始化数组
            if (data == null) {
                data = new Object[size];
            }

            if (flag == HeapFlag.HEAP_ONE) {
                data[++p1] = t;
            } else if (flag == HeapFlag.HEAP_TWO) {
                data[--p2] = t;
            }
        }

        public T pop(HeapFlag flag) {
            if (isEmpty(flag)) {
                return null;
            }
            T result = null;
            if (flag == HeapFlag.HEAP_ONE) {
                result = (T) data[p1];
                data[p1--] = null;
            } else if (flag == HeapFlag.HEAP_TWO) {
                result = (T) data[p2];
                data[p2++] = null;
            }
            return result;
        }

        public T peek(HeapFlag flag) {
            if (isEmpty(flag)) {
                return null;
            }
            T result = null;
            if (flag == HeapFlag.HEAP_ONE) {
                result = (T) data[p1];
            } else if (flag == HeapFlag.HEAP_TWO) {
                result = (T) data[p2];
            }
            return result;
        }

        public boolean isFull() {
            return p1 == p2 - 1;
        }

        public boolean isEmpty(HeapFlag flag) {
            boolean r = false;

            if (flag == HeapFlag.HEAP_ONE) {
                r = p1 == -1;
            } else if (flag == HeapFlag.HEAP_TWO) {
                r = p2 == size;
            }

            return r;
        }

    }

    enum HeapFlag {
        HEAP_ONE,
        HEAP_TWO;
    }
}
