package cn.cupcat.stack;

import java.util.LinkedList;

/**
 * 实现最小栈
 * <p>
 * 最小栈
 * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
 * push(x) -- 将元素 x 推入栈中。
 * pop() -- 删除栈顶的元素。
 * top() -- 获取栈顶元素。
 * getMin() -- 检索栈中的最小元素。
 * 示例
 * MinStackmin Stack=new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin(); --> 返回 -3.
 * minStack.pop();
 * minStack.top(); --> 返回 0.
 * minStack.getMin(); --> 返回 -2.
 * <p>
 * <p>
 * 思路
 * 根据数组的性质，push、pop、top都能在常数时间内完成，而此题关键是常数时间内检索最小元 素，
 * 此解法是开辟一个数组存储，push数据同时，存储当前栈中最小元素，pop数据的同时pop最 小元素栈栈顶数据;
 */
public class MinStack {

    public static void main(String[] args) {
        MockMinStack<Integer> minStack = new MockMinStack<>();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        minStack.push(4);

        Integer min = minStack.getMin();
        System.out.println("min  = " + min);
        minStack.pop();
        minStack.top();
        min = minStack.getMin();
        System.out.println("min  = " + min);

    }


}

class MockMinStack<T extends Comparable<T>> {

    // 保存栈存储元素
    private LinkedList<T> stack = new LinkedList<>();
    // 保存stack中的最小值
    private LinkedList<T> minStack = new LinkedList<>();

    /**
     * 入栈
     */
    public void push(T t) {
        stack.push(t);
        if (minStack.isEmpty()) {
            // 最小栈中没有元素，则添加
            minStack.push(t);
        } else {
            // 最小栈有元素，判断栈顶元素和添加元素的大小，取最小值入栈
            T peek = minStack.peek();
            T min = peek.compareTo(t) >= 0 ? t : peek;
            minStack.push(min);
        }
    }

    /**
     * 出栈
     *
     * @return
     */
    public T pop() {
        minStack.pop();
        return stack.pop();
    }

    /**
     * 获取栈顶元素
     *
     * @return
     */
    public T top() {
        return stack.peek();
    }

    /**
     * 获取最小栈
     */
    public T getMin() {
        return minStack.peek();
    }

}


