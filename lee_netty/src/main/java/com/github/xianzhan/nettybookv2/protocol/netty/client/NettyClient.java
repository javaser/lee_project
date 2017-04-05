package com.github.xianzhan.nettybookv2.protocol.netty.client;

import com.github.xianzhan.nettybookv2.protocol.netty.NettyConstant;
import com.github.xianzhan.nettybookv2.protocol.netty.codec.NettyMessageDecoder;
import com.github.xianzhan.nettybookv2.protocol.netty.codec.NettyMessageEncoder;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.timeout.ReadTimeoutHandler;

import java.net.InetSocketAddress;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class NettyClient {
    private ScheduledExecutorService executor = Executors
            .newScheduledThreadPool(1);

    public void connect(int port, String host) throws Exception {
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap b = new Bootstrap();
            b.group(group).channel(NioSocketChannel.class)
                    .option(ChannelOption.TCP_NODELAY, true)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            ChannelPipeline cp = socketChannel.pipeline();
                            cp.addLast(new NettyMessageDecoder(1024 * 1024,4, 4));
                            cp.addLast("MessageEncoder", new
                                    NettyMessageEncoder());
                            cp.addLast("readTimeoutHandler", new
                                    ReadTimeoutHandler(50));
                            cp.addLast("LoginAuthHandler", new
                                    LoginAuthReqHandler());
                            cp.addLast("HeartBeatHandler", new
                                    HeartBeatReqHandler());
                        }
                    });
            // 发起异步连接操作
            ChannelFuture f = b.connect(
                    new InetSocketAddress(host, port),
                    new InetSocketAddress(NettyConstant.LOCALIP,
                            NettyConstant.LOCAL_PORT)
            ).sync();
            f.channel().closeFuture().sync();
        } finally {
            group.shutdownGracefully();
            // 所有资源释放完成之后，清空资源，再次发起重连操作
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        TimeUnit.SECONDS.sleep(1);
                        connect(NettyConstant.PORT, NettyConstant.REMOTEIP);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    public static void main(String[] args) throws Exception {
        new NettyClient().connect(NettyConstant.PORT, NettyConstant.REMOTEIP);
    }
}
