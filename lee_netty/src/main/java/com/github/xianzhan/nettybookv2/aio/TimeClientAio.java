package com.github.xianzhan.nettybookv2.aio;

import com.github.xianzhan.nettybookv2.aio.handler.AsyncTimeClientHandler;

public class TimeClientAio {
    public static void main(String[] args) {
        int port = 8080;
        new Thread(new AsyncTimeClientHandler("127.0.0.1", port),
                "AIO-AsyncTimeClientHandler-001").start();
    }
}
