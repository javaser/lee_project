package com.github.xianzhan.nettybookv2.aio.handler;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

public class AcceptCompletionHandler implements CompletionHandler {

    @Override
    public void completed(Object result, Object attachment) {
        ((AsyncTimeServerHandler) attachment).asynchronousServerSocketChannel
                .accept(attachment, this);

        ByteBuffer buffer = ByteBuffer.allocate(1024);
        ((AsynchronousSocketChannel) result).read(buffer, buffer,
                new ReadCompletionHandler((AsynchronousSocketChannel) result));
    }

    @Override
    public void failed(Throwable exc, Object attachment) {
        exc.printStackTrace();
        ((AsyncTimeServerHandler) attachment).latch.countDown();
    }
}
