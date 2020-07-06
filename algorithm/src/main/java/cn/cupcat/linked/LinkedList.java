package cn.cupcat.linked;

import java.util.ArrayList;
import java.util.List;

/**
 * 链表
 * <p>
 * 单向链表实现堆栈-添加元素需要添加到链表的表头位置
 * 单向链表实现队列-添加元素直接添加到链表尾部
 * <p>
 * 注意：
 * 本例中是添加到链表尾部，实现的是队列的功能。
 * <p>
 * 但是：
 * 使用双向链表可以同时实现队列和堆栈的功能
 */
public class LinkedList<T> {

    private Linked head = new Linked(null);

    private Linked tail;

    private int size;


    /**
     * 添加元素
     * <p>
     * 入栈操作
     *
     * @param e
     * @return
     */
    public T push(T e) {
        Linked linked = new Linked(e);
        if (tail == null) {
            head.next = linked;
        } else {
            tail.next = linked;
        }
        tail = linked;
        ++size;
        return e;
    }


    /**
     * 出队列操作
     *
     * @return
     */
    public T shift() {
        if (isEmpty()) {
            return null;
        }
        Linked<T> p = head;

        Linked<T> top = p.next;
        // 将链表头节点（头结点为空）指向第二个数据节点

        p.next = top.next;
        // 将原先第一个数据节点（栈顶元素）后项节点置空
        top.next = null;
        --size;

        return top.data;
    }


    /**
     * 获取栈队列头部元素，不做删除操作
     *
     * @return
     */
    public T unshift() {
        if (isEmpty()) {
            return null;
        }
        Linked<T> p = head;

        return p.next.data;
    }


    /**
     * 删除元素
     *
     * @param e
     * @param deleteAll true：删除符合条件的所有值， false ： 只删除最近符合条件的值
     * @return
     */
    public boolean remove(T e, boolean deleteAll) {
        boolean result = false;
        if (isEmpty()) {
            return false;
        }
        Linked<T> h = head;
        Linked<T> tmp;

        while (h != null && h.next != null) {
            if (h.next.data.equals(e)) {
                tmp = h.next;
                h.next = h.next.next;
                tmp.next = null;
                --size;
                result = true;
                if (!deleteAll) {
                    return true;
                }
            }
            h = h.next;
        }
        return result;
    }

    /**
     * 判断链表是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 翻转链表
     */
    public void reserve() {
        reserve(this.size);
    }

    /**
     * 翻转链表
     */
    public void reserve(int size) {
        if (isEmpty()) {
            return;
        }

        Linked<T> h = head;

        // 临时
        Linked<T> tmp;
        // newPoint：指向翻转链表的第一个节点
        Linked<T> newPoint = h.next;
        // oldPoint : 指向原链表正在翻转的位置
        Linked<T> oldPoint = h.next.next;
        int count = 1;
        while (oldPoint != null && count < size) {

            tmp = oldPoint.next;
            oldPoint.next = newPoint;

            count++;
            newPoint = oldPoint;
            oldPoint = tmp;
        }

        if (size >= this.size) {
            // 将原链表的未指针指向翻转以后的尾结点
            tail = h.next;
            tail.next = null;
        } else {
            h.next.next = oldPoint;
        }
        h.next = newPoint;

    }

    /**
     * 遍历链表
     *
     * @return
     */
    public List<T> list() {
        List<T> list = new ArrayList<>(size);
        Linked<T> h = head;
        while (h.next != null) {
            list.add(h.next.data);
            h = h.next;
        }
        return list;
    }

    public T get(int index) {
        if (index >= this.size || index < 0) {
            throw new ArrayIndexOutOfBoundsException("index下标越界");
        }
        int count = 0;
        Linked<T> p = head;
        while (count <= index && p != null) {
            p = p.next;
            count++;
        }
        return p.data;
    }

    public boolean contains(T e) {
        Linked<T> p = head;
        while (p != null && p.next != null) {
            if (p.next.data.equals(e)) {
                return true;
            }
            p = p.next;
        }
        return false;
    }


    private class Linked<T> {
        /**
         * 数据域
         */
        T data;
        /**
         * 指向下一个元素指针
         */
        Linked<T> next;

        public Linked(T data) {
            this.data = data;
        }

    }

}
