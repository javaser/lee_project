package com.github.xianzhan.util;

import java.util.Iterator;

public class IteratorImpl<T> implements Iterator<T> {
    private int locate = 0;
    private NodeSingle<T> temp;
    private int size;

    public IteratorImpl(NodeSingle<T> temp, int size) {
        this.temp = temp;
        this.size = size;
    }

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
