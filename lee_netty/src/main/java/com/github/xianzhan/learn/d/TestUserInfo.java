package com.github.xianzhan.learn.d;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class TestUserInfo {
    public static void main(String[] args) throws IOException {
        UserInfo info = new UserInfo();
        info.buildUserid(100).buildUsername("Welcome to Netty");
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(info);
        oos.flush();
        oos.close();
        byte[] b = baos.toByteArray();
        System.out.println("The jdk serializable length is: " + b.length);
        System.out.println(new String(b));
        baos.close();
        System.out.println("-------------------------------------------");
        System.out.println("The byte array serializable length is: "
                + info.codeC().length);
        System.out.println(new String(info.codeC()));
        System.out.println("-------------------------------------------");
        System.out.println(info.toString().length());
    }
}
