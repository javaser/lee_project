package lee.jdk.net.javanet.b;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @author Lee
 * @since 2017/4/26
 */
public class PortScanner {
    public void scan(String host) {
        Socket socket = null;
        for (int port = 1; port < 1024; port++) {
            try {
                socket = new Socket(host, port);
                System.out.println("There is a server on port " + port);
            } catch (UnknownHostException e) {
                System.err.println("未知地址");
            } catch (IOException e) {
                System.err.println("Can't connect to port " + port);
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

    public static void main(String[] args) {
        String host = "127.0.0.1";
        if (args.length > 0) host = args[0];
        new PortScanner().scan(host);
    }
}
