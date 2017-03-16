package com.github.xianzhan.datastructure;

public class NodeSingle<T> {
    T t;
    NodeSingle next;

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
