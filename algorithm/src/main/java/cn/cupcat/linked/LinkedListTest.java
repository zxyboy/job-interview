package cn.cupcat.linked;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class LinkedListTest {


    LinkedList<Integer> linkedList = new LinkedList<>();





    @Before
    public void setUp() throws Exception {
        linkedList.push(1);
        linkedList.push(2);
        linkedList.push(3);
        linkedList.push(4);
        linkedList.push(5);
        linkedList.push(2);
        linkedList.push(7);
        System.out.println("---------初始化元素------");
        listTest();
        System.out.println();
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("---------最后输出元素------");
        listTest();
    }


    @Test
    public void listTest() {
        List<Integer> list = linkedList.list();
        list.stream()
                .forEach(System.out::print);
    }


    @Test
    public void remove() {
        linkedList.remove(2, false);
    }

    @Test
    public void isEmpty() {

    }

    @Test
    public void reserve() {
        linkedList.reserve();
        linkedList.push(7);
        linkedList.push(8);
        linkedList.remove(8, true);
    }




    @Test
    public void get() {
        Integer integer = linkedList.get(1);
        System.out.println(integer);

        Integer integer2 = linkedList.get(4);
        System.out.println(integer2);

        Integer integer3 = linkedList.get(9);
        System.out.println(integer3);


    }

    @Test
    public void contains() {
        boolean contains = linkedList.contains(1);
        System.out.println("2 " + contains);

        contains = linkedList.contains(2);
        System.out.println("2 " + contains);
        contains = linkedList.contains(7);
        System.out.println("7 " + contains);

    }

    @Test
    public void pop() {


    }
}