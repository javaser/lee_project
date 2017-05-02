package lee.jdk.net.javanet.e;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Lee
 * @since 2017/5/2
 */
public class SimpleHttpServer {
    private int port = 80;
    private ServerSocketChannel serverSocketChannel = null;
    private ExecutorService executorService;

    public SimpleHttpServer() throws IOException {
        executorService = Executors.newFixedThreadPool(
                Runtime.getRuntime().availableProcessors()
        );
        serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.socket().setReuseAddress(true);
        serverSocketChannel.socket().bind(new InetSocketAddress(port));
        System.out.println("服务器启动");
    }

    public void service() {
        while (true) {
            SocketChannel socketChannel = null;
            try {
                socketChannel = serverSocketChannel.accept();
                executorService.execute(new Handler(socketChannel));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        new SimpleHttpServer().service();
    }

    class Handler implements Runnable {
        private SocketChannel socketChannel;

        public Handler(SocketChannel socketChannel) {
            this.socketChannel = socketChannel;
        }

        @Override
        public void run() {
            handle(socketChannel);
        }

        public void handle(SocketChannel socketChannel) {
            try {
                Socket socket = socketChannel.socket();
                System.out.println("接收到客户连接，来自："
                        + socket.getInetAddress() + " : " + socket.getPort()
                );

                ByteBuffer buffer = ByteBuffer.allocate(1024);
                socketChannel.read(buffer);
                buffer.flip();
                String request = decode(buffer);
                System.out.println(request);

                StringBuffer sb = new StringBuffer();
                sb.append("HTTP/1.1 200 OK\r\n");
                sb.append("Content-Type:text/html\r\n\r\n");
                socketChannel.write(encode(sb.toString()));

                FileInputStream fis;
                String firstLineOfRequest = request.substring(0, request.indexOf("\r\n"));
                if (firstLineOfRequest.indexOf("login.htm") != -1) {
                    fis = new FileInputStream("login.htm");
                } else {
                    fis = new FileInputStream("hello.htm");
                }

                FileChannel fileChannel = fis.getChannel();
                fileChannel.transferTo(0, fileChannel.size(), socketChannel);
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (socketChannel != null) {
                    try {
                        socketChannel.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    private Charset charset = Charset.forName("UTF-8");

    public String decode(ByteBuffer buffer) {
        CharBuffer charBuffer = charset.decode(buffer);
        return charBuffer.toString();
    }

    public ByteBuffer encode(String str) {
        return charset.encode(str);
    }
}
