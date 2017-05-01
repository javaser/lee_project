package lee.jdk.net.javanet.b;

/**
 * @author Lee
 * @since 2017/5/1
 */
public class Message {
    public String from;
    public String to;
    public String subject;
    public String content;
    public String data;

    public Message(String from, String to, String subject, String content, String data) {
        this.from = from;
        this.to = to;
        this.subject = subject;
        this.content = content;
        this.data = data;
    }
}
