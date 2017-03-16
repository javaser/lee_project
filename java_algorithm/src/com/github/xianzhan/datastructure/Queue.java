package com.github.xianzhan.datastructure;

import com.github.xianzhan.util.IteratorImpl;
import com.github.xianzhan.util.NodeSingle;

import java.util.Iterator;

public class Queue<T> implements Iterable<T> {
    private NodeSingle<T> node;
    private int size;

    /**
     * 创建空队列
     */
    public Queue() {
    }

    /**
     * 添加一个元素
     */
    void enqueue(T t) {
        if (node == null) {
            node = new NodeSingle<T>(t);
        } else {
            NodeSingle<T> temp = new NodeSingle<T>(t);
            temp.next = node;
            node = temp;
        }
        size++;
    }

    /**
     * 删除最后一个元素
     */
    T dequeue() {
        if (size == 0) {
            return null;
        } else if (size == 1) {
            NodeSingle<T> temp = node;
            node = null;
            size--;
            return temp.t;
        }
        NodeSingle<T> temp = node;
        for (int i = 0; i < size - 2; i++) {
            temp = temp.next;
        }
        NodeSingle<T> t = temp.next;
        temp.next = null;
        size--;
        return t.t;
    }

    /**
     * 队列是否为空
     */
    boolean isEmpty() {
        return size == 0;
    }

    /**
     * 队列中的元素数量
     */
    int size() {
        return size;
    }

    @Override
    public String toString() {
        return node + ":size = " + size;
    }

    @Override
    public Iterator<T> iterator() {
        return new IteratorImpl<T>(node, size);
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        System.out.println("size = " + queue.size());
//        System.out.println(queue.dequeue());
//        System.out.println(queue.size());
//        System.out.println(queue.dequeue());
//        System.out.println(queue.size());
//        System.out.println(queue.dequeue());
//        System.out.println(queue.size());
//        System.out.println(queue.dequeue());
        for (int i : queue) {
            System.out.println(i);
        }
    }
}
