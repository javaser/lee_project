package lee.jdk.net.javanet.b;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author Lee
 * @since 2017/4/27
 */
public class HTTPClient {
    private String host;
    private int port;
    private Socket socket;

    public void createSocket() throws IOException {
        host = "www.javathinker.org";
        port = 80;
        socket = new Socket(host, port);
    }

    public void communicate() throws IOException {
        StringBuffer sb = new StringBuffer();
        sb.append("GET /index.jsp HTTP/1.1\r\n");
        sb.append("Host: www.javathinker.org\r\n");
        sb.append("Accept: */*\r\n");
        sb.append("Accept-Language: zh-cn\r\n");
        sb.append("Accept-Encoding: gzip, deflate\r\n");
        sb.append("User-Agent: Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.0)\r\n");
        sb.append("Connection: Keep-Alive\r\n\r\n");

        // 发出 HTTP 请求
        OutputStream os = socket.getOutputStream();
        os.write(sb.toString().getBytes());
        os.flush();
        socket.shutdownOutput();

        // 接收响应结果
        InputStream is = socket.getInputStream();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] buff = new byte[1024];
        int len = -1;
        while ((len = is.read(buff)) != -1) {
            baos.write(buff, 0, len);
        }

        System.out.println(new String(baos.toByteArray()));
        socket.close();
    }

    public static void main(String[] args) throws IOException {
        HTTPClient client = new HTTPClient();
        client.createSocket();
        client.communicate();
    }
}
