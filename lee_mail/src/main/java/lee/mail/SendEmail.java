package lee.mail;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class SendEmail {
    public static void main(String[] args) {
        // 收件人邮箱
        String to = "接收方邮箱";
        // 发件人邮箱
        String from = "发送方邮箱";

        // 指定发送邮件主机
        String host = "发送方邮箱主机";

        // 获取系统属性
        Properties properties = System.getProperties();
        properties.setProperty("mail.smtp.host", host);
        properties.setProperty("mail.smtp.auth", "true"); // 重要

        Session session = Session.getDefaultInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from,
                        "发送方邮箱密码");
            }
        });


        try {
            // 创建默认的 MineMessage 对象
            MimeMessage message = new MimeMessage(session);
            // Set From: 头部头字段
            message.setFrom(new InternetAddress(from));
            // Set To: 头部头字段
            message.addRecipient(Message.RecipientType.TO, new
                    InternetAddress(to));
            // Set Subject: 头部头字段
            message.setSubject("这是 Subject");
            // Set Text
            message.setText("这是 Text");

            // 发送
            Transport.send(message);
            System.out.println("已发送！");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
