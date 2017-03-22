package com.github.xianzhan.aio;

import com.github.xianzhan.aio.handler.AsyncTimeServerHandler;

public class TimeServerAio {

    public static void main(String[] args) {
        int port = 8080;
        AsyncTimeServerHandler timeServer = new AsyncTimeServerHandler(port);
        new Thread(timeServer, "AIO-AsyncTimeServerHandler-001").start();
    }
}
