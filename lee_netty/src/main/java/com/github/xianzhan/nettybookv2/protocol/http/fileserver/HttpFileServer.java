package com.github.xianzhan.nettybookv2.protocol.http.fileserver;

import com.github.xianzhan.nettybookv2.protocol.http.fileserver.handler.HttpFileServerHandler;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpRequestDecoder;
import io.netty.handler.codec.http.HttpResponseEncoder;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.handler.stream.ChunkedWriteHandler;

public class HttpFileServer {

    /*
    这里链接的是 lee_project 项目下的 lee_netty 模块
     */
    private static final String DEFAULT_URL =
            "/lee_netty/src/main/java/com/github/xianzhan/";
    private static final String URL = "192.168.1.2";

    public void run(final int port, final String url) throws Exception {
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap b = new ServerBootstrap();
            b.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .handler(new LoggingHandler(LogLevel.INFO))
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            // HTTP 请求消息解码器
                            ch.pipeline().addLast("http-decoder", new
                                    HttpRequestDecoder());

                            /*
                            HTTP 聚合器
                            将多个消息转换为单一的 FullHttpRequest 或者 FullHttpResponse，
                            原因是 HTTP 解码器在每个 HTTP 消息中会生成多个消息对象。
                            HttpRequest / HttpResponse
                            HttpContent
                            LastHttpContent
                             */
                            ch.pipeline().addLast("http-aggregator", new
                                    HttpObjectAggregator(65536));

                            // HTTP 响应加密器
                            ch.pipeline().addLast("http-encoder", new
                                    HttpResponseEncoder());

                            /*
                            作用是支持异步发送大的码流（例如大的文件传输），但不占用过多的内存，
                            防止发生 Java 内存溢出错误
                             */
                            ch.pipeline().addLast("http-chunked", new
                                    ChunkedWriteHandler());

                            /*
                            文件服务器的业务逻辑处理，自己实现
                             */
                            ch.pipeline().addLast("fileServerHandler", new
                                    HttpFileServerHandler(url));
                        }
                    });
            ChannelFuture f = b.bind(URL, port).sync();
            System.out.println("HTTP 文件服务器启动，网址是：http://" + URL + ":" + port +
                    url);
            f.channel().closeFuture().sync();
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }

    public static void main(String[] args) throws Exception {
        int port = 8080;
        String url = DEFAULT_URL;

        new HttpFileServer().run(port, url);
    }
}
