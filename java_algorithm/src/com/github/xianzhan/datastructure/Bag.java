package com.github.xianzhan.datastructure;

import java.util.Iterator;

public class Bag<T> implements Iterable<T> {
    private NodeSingle<T> node;
    private int size;

    /**
     * 创建一个空背包
     */
    public Bag() {
        this.size = 0;
    }

    /**
     * 添加一个元素
     */
    void add(T t) {
        if (node == null) {
            node = new NodeSingle<T>(t);
        } else {
            NodeSingle<T> temp = node;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = new NodeSingle(t);
        }
        size++;
    }

    /**
     * 背包是否为空
     */
    boolean isEmpty() {
        return size == 0;
    }

    /**
     * 背包中的元素个数
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
        return this.new BagIterator<T>();
    }

    private class BagIterator<T> implements Iterator<T> {
        private int locate = 0;
        private NodeSingle<T> temp = (NodeSingle<T>) node;

        @Override
        public boolean hasNext() {
            return locate < size;
        }

        @Override
        public T next() {
            if (temp != null && locate++ != 0) {
                temp = temp.next;
            } else if (temp == null) {
                temp = new NodeSingle<T>();
            }
            return temp.t;
        }
    }

    public static void main(String[] args) {
        Bag<Integer> bag = new Bag<>();
        bag.add(1);
        bag.add(2);
        bag.add(3);
        System.out.println(bag.isEmpty());
        System.out.println(bag.size());

        for (int i : bag) {
            System.out.println(i);
        }
    }
}
