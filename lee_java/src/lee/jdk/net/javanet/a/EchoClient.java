package lee.jdk.net.javanet.a;

import java.io.*;
import java.net.Socket;

/**
 * @author Lee
 * @since 2017/4/26
 */
public class EchoClient {
    private String host = "127.0.0.1";
    private int port = 8000;
    private Socket socket;

    public EchoClient() throws IOException {
        this.socket = new Socket(host, port);
    }

    private PrintWriter getWriter(Socket socket) throws IOException {
        OutputStream os = socket.getOutputStream();
        return new PrintWriter(os, true);
    }

    private BufferedReader getReader(Socket socket) throws IOException {
        InputStream is = socket.getInputStream();
        return new BufferedReader(new InputStreamReader(is));
    }

    public void talk() {
        try {
            BufferedReader br = getReader(socket);
            PrintWriter pw = getWriter(socket);
            BufferedReader localReader = new BufferedReader(
                    new InputStreamReader(System.in));
            String msg = null;
            while ((msg = localReader.readLine()) != null) {
                pw.println(msg);
                System.out.println(br.readLine());
                if ("bye".equals(msg)) {
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
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

    public static void main(String[] args) throws IOException {
        new EchoClient().talk();
    }
}
