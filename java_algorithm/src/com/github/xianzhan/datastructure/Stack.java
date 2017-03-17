package com.github.xianzhan.datastructure;

import com.github.xianzhan.util.IteratorImpl;
import com.github.xianzhan.util.NodeSingle;

import java.util.Iterator;

public class Stack<T> implements Iterable<T> {
    private NodeSingle<T> node;
    private int size;

    public Stack() {
    }

    /**
     * 添加一个元素
     */
    void push(T t) {
        NodeSingle<T> temp = new NodeSingle<T>(t);
        if (node == null) {
            node = temp;
        } else {
            temp.next = node;
            node = temp;
        }
        size++;
    }

    /**
     * 删除最近添加的元素
     */
    T pop() {
        if (node == null) {
            return null;
        } else {
            NodeSingle<T> temp = node;
            node = node.next;
            size--;
            return temp.t;
        }
    }

    /**
     * 栈是否为空
     */
    boolean isEmpty() {
        return size == 0;
    }

    /**
     * 栈大小
     */
    int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new IteratorImpl<T>(node, size);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
//        System.out.println(stack.size());
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());
//        System.out.println(stack.size());
        for (int i : stack) {
            System.out.println(i);
        }
    }
}
