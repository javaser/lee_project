package com.github.xianzhan.netty.demo.handler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;

public class DiscardServerHandler extends ChannelInboundHandlerAdapter {

    /**
     * 接收数据
     * @param ctx 返回给客户端的数据操作
     * @param msg 客户端传过来的数据
     * @throws Exception
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        // Discard the received data silently.
//        ((ByteBuf) msg).release();
        ByteBuf in = (ByteBuf) msg;
        try {
            // Do something with msg
            while (in.isReadable()) {
                System.out.print((char)in.readByte());
                System.out.flush();
            }
            // or System.out.println(in.toString(io.netty.util.CharsetUtil.US_ASCII))
        } finally {
            ReferenceCountUtil.release(in);
        }
    }

    /**
     * 捕获到异常后的操作
     * @param ctx
     * @param cause
     * @throws Exception
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        // Close the connection when an exception is raised.
        cause.printStackTrace();
        ctx.close();
    }
}
