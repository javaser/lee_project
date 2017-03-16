package com.github.xianzhan.util;

public class NodeSingle<T> {
    public T t;
    public NodeSingle next;

    public NodeSingle(T t) {
        this.t = t;
    }

    public NodeSingle() {
    }

    @Override
    public String toString() {
        return t + ":next --> " + next;
    }
}
