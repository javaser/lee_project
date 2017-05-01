package lee.jdk.net.javanet.b;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @author Lee
 * @since 2017/5/1
 */
public class MailSender {
    private String smtpServer = "smtp.mydomain.com";
    private int port = 25;

    public static void main(String[] args) {
        Message msg = new Message(
                "tom@abc.com",
                "linda@def.com",
                "hello",
                "hi, i miss you very much",
                ""
        );

        new MailSender().sendMail(msg);
    }

    public void sendMail(Message msg) {
        Socket socket = null;
        try {
            socket = new Socket(smtpServer, port);
            BufferedReader br = getReader(socket);
            PrintWriter pw = getWriter(socket);
            String localhost = InetAddress.getLocalHost().getHostName();
            
            sendAndReceive(null, br, pw);
            sendAndReceive("HELO " + localhost, br, pw);
            sendAndReceive("MAIL FROM: <" + msg.from + ">", br, pw);
            sendAndReceive("RCPT TO: <" + msg.to + ">", br, pw);
            sendAndReceive("DATA", br, pw);
            pw.println(msg.data);
            System.out.println("Client>" + msg.data);
            sendAndReceive(".", br, pw);
            sendAndReceive("QUIT", br, pw);
        } catch (UnknownHostException e) {
            e.printStackTrace();
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

    private void sendAndReceive(String str, BufferedReader br, PrintWriter pw)
            throws IOException {
        if (str != null) {
            System.out.println("Client> " + str);
            pw.println(str);
        }
        String response;
        if ((response = br.readLine()) != null) {
            System.out.println("Server> " + response);
        }
    }

    private BufferedReader getReader(Socket socket) throws IOException {
        InputStream is = socket.getInputStream();
        return new BufferedReader(new InputStreamReader(is));
    }

    private PrintWriter getWriter(Socket socket) throws IOException {
        OutputStream os = socket.getOutputStream();
        return new PrintWriter(os, true);
    }
}
