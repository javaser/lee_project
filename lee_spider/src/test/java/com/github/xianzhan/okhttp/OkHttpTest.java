package com.github.xianzhan.okhttp;

import okhttp3.*;
import org.junit.Test;

import java.io.IOException;

/**
 * @author Lee
 * @since 2017/5/6
 */
public class OkHttpTest {
    private OkHttpClient client = new OkHttpClient();

    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");


    @Test
    public void testHttpGet() throws IOException {
        String url = "http://www.baidu.com";

        Request request = new Request.Builder()
                .url(url).build();
        Response response = client.newCall(request).execute();
        if (response.isSuccessful()) {
            System.out.println(response.toString());
            ResponseBody responseBody = response.body();
            System.out.println(responseBody.string());
        } else {
            throw new IOException("Unexpected code " + response);
        }
    }

    @Test
    public void testPostJson() throws IOException {
        String url = "http://";
        String jsonStr = "{}";

        RequestBody body = RequestBody.create(JSON, jsonStr);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        Response response = client.newCall(request).execute();
        if (response.isSuccessful()) {
            System.out.println(response.body().string());
        } else {
            throw new IOException("Unexpected code " + response);
        }
    }
}
