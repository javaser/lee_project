package lee.jdk.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Lee
 * @since 2017/4/26
 */
public class EchoPlayer {
    public String echo(String msg) {
        return "echo: " + msg;
    }

    public void talk() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String msg = null;
        while ((msg = br.readLine()) != null) {
            System.out.println(echo(msg));
            if (msg.equals("bye")) {
                break;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        new EchoPlayer().talk();
    }
}
