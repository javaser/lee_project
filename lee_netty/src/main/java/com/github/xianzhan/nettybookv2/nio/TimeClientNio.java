package com.github.xianzhan.nettybookv2.nio;

public class TimeClientNio {
    public static void main(String[] args) {
        int port = 8080;
        new Thread(new TimeClientHandler("127.0.0.1", port),
                "TimeClient-001").start();
    }
}
