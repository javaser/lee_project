package lee.jdk.net.javanet.a;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 只能连接一个客户端
 * @author Lee
 * @since 2017/4/26
 */
public class EchoServer {
    private int port = 8000;
    private ServerSocket serverSocket;

    public EchoServer() throws IOException {
        serverSocket = new ServerSocket(port);
        System.out.println("服务器启动");
    }

    public String echo(String msg) {
        return "echo: " + msg;
    }

    public void service() {
        while (true) {
            Socket socket = null;
            try {
                socket = serverSocket.accept();
                System.out.println("New connection accepted " +
                        socket.getInetAddress() + ": " + socket.getPort());
                BufferedReader br = getReader(socket);
                PrintWriter pw = getWriter(socket);

                String msg = null;
                while ((msg = br.readLine()) != null) {
                    System.out.println(msg);
                    pw.println(echo(msg));
                    if ("bye".equals(msg)) {
                        break;
                    }
                }
            } catch (IOException e) {
                System.err.println(e.getMessage());
                System.out.println("客户端关闭：" + socket.getInetAddress());
            } finally {
                if (socket != null) {
                    try {
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    private PrintWriter getWriter(Socket socket) throws IOException {
        OutputStream os = socket.getOutputStream();
        return new PrintWriter(os, true);
    }

    private BufferedReader getReader(Socket socket) throws IOException {
        InputStream is = socket.getInputStream();
        return new BufferedReader(new InputStreamReader(is));
    }

    public static void main(String[] args) throws IOException {
        new EchoServer().service();
    }
}
