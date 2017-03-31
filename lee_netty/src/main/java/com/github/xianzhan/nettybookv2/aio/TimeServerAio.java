package com.github.xianzhan.nettybookv2.aio;

import com.github.xianzhan.nettybookv2.aio.handler.AsyncTimeServerHandler;

public class TimeServerAio {

    public static void main(String[] args) {
        int port = 8080;
        AsyncTimeServerHandler timeServer = new AsyncTimeServerHandler(port);
        new Thread(timeServer, "AIO-AsyncTimeServerHandler-001").start();
    }
}
