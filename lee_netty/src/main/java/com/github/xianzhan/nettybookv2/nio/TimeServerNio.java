package com.github.xianzhan.nettybookv2.nio;

public class TimeServerNio {
    public static void main(String[] args) throws Exception {
        int port = 8080;
        MultiplexerTimeServer timeServer = new MultiplexerTimeServer(port);
        new Thread(timeServer, "NIO-MultiplexerTimeServer-001").start();
    }
}
