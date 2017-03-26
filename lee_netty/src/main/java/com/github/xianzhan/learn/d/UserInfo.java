package com.github.xianzhan.learn.d;


import java.io.Serializable;
import java.nio.ByteBuffer;

public class UserInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    private String username;
    private int userid;

    public UserInfo buildUsername(String username) {
        this.username = username;
        return this;
    }

    public UserInfo buildUserid(int userid) {
        this.userid = userid;
        return this;
    }

    public final String getUsername() {
        return username;
    }

    public final void setUsername(String username) {
        this.username = username;
    }

    public final int getUserid() {
        return userid;
    }

    public final void setUserid(int userid) {
        this.userid = userid;
    }

    public byte[] codeC() {
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        byte[] value = this.username.getBytes();
        buffer.putInt(value.length);
        buffer.put(value);
        buffer.putInt(this.userid);
        buffer.flip();
        byte[] result = new byte[buffer.remaining()];
        buffer.get(result);
        return result;
    }

    public byte[] codeC(ByteBuffer buffer) {
        buffer.clear();
        byte[] value = this.username.getBytes();
        buffer.putInt(value.length);
        buffer.put(value);
        buffer.putInt(this.userid);
        buffer.flip();
        byte[] result = new byte[buffer.remaining()];
        buffer.get(result);
        return result;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "username='" + username + '\'' +
                ", userid=" + userid +
                '}';
    }
}
