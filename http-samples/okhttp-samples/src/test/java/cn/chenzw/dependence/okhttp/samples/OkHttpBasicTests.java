package cn.chenzw.dependence.okhttp.samples;

import cn.chenzw.dependence.okhttp.samples.interceptors.LoggingInterceptor;
import lombok.extern.slf4j.Slf4j;
import okhttp3.*;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RunWith(JUnit4.class)
public class OkHttpBasicTests {

    /**
     * 最简化 - 同步请求
     *
     * @throws IOException
     */
    @Test
    public void testBasicSync() throws IOException {
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder().url("http://www.baidu.com").build();
        Response response = okHttpClient.newCall(request).execute();  // 同步请求
        if (response.isSuccessful()) {
            String result = response.body().string();

            Assert.assertThat(result, Matchers.containsString("<!DOCTYPE html>"));
        }

        // 最后response必须关闭，否则会导致溢出
        response.close();
    }

    /**
     * 最简化 - 异步请求
     *
     * @throws IOException
     */
    @Test
    public void testBasicAsync() {
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder().url("http://www.baidu.com").build();

        // 异步请求
        okHttpClient.newCall(request).enqueue(new Callback() {

            @Overrid
            public void onFailure(Call call, IOException e) {
                System.out.println("异常: " + e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    String result = response.body().string();

                    Assert.assertThat(result, Matchers.containsString("<!DOCTYPE html>"));
                }
                // 最后response必须关闭，否则会导致溢出
                response.close();

            }
        });

    }

    /**
     * Post请求示例（FormBody）
     *
     * @throws IOException
     */
    @Test
    public void testPost() throws IOException {
        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(new LoggingInterceptor()).build();

        RequestBody body = new FormBody.Builder()
                .add("bookid", "xx")
                .add("bookName", "yyy").build();

        Request request = new Request.Builder()
                .url("http://139.199.89.89/api/v1/books")
                .post(body).build();

        try (Response response = okHttpClient.newCall(request).execute()) {
            log.info("response => " + response.body().string());
        }

    }

    /**
     * Post示例（JsonBody）
     */
    @Test
    public void testPostJson() throws IOException {
        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(new LoggingInterceptor()).build();

        RequestBody body = RequestBody.create(
                MediaType.parse("application/json;charset=utf-8"),
                "{\"bookid\": \"xxx\", \"bookName\": \"yyy\"}"
        );

        Request request = new Request.Builder()
                .url("http://139.199.89.89/api/v1/books")
                .post(body).build();

        try (Response response = okHttpClient.newCall(request).execute()) {
            log.info("response => " + response.body().string());
        }
    }

    /**
     * Get请求带参数 + 日志拦截器
     *
     * @throws IOException
     */
    @Test
    public void testWithLogging() throws IOException {
        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(new LoggingInterceptor()).build();

        Request.Builder reqBuilder = new Request.Builder();

        // Get请求带参数
        HttpUrl.Builder urlBuilder = HttpUrl.parse("http://www.baidu.com/s").newBuilder();
        urlBuilder.addQueryParameter("wd", "测试");
        urlBuilder.addQueryParameter("ie", "UTF-8");
        Request request = reqBuilder.url(urlBuilder.build()).build();

        Response response = okHttpClient.newCall(request).execute();  // 同步请求
        if (response.isSuccessful()) {
            String result = response.body().string();

            Assert.assertThat(result, Matchers.containsString("<!DOCTYPE html>"));
        }

        // 最后response必须关闭，否则会导致溢出
        response.close();

    }

    /**
     * 使用代理请求
     */
    @Test
    public void testWithProxy() throws IOException {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new LoggingInterceptor())
                .cookieJar(new CookieJar() {

                    private final Map<String, List<Cookie>> cookieStore = new HashMap<>();

                    @Override
                    public void saveFromResponse(HttpUrl url, List<Cookie> cookies) {
                        log.info("[url={}]保存cookie[{}]", url, cookies);

                        cookieStore.put(url.host(), cookies);
                    }

                    @Override
                    public List<Cookie> loadForRequest(HttpUrl url) {
                        List<Cookie> cookies = cookieStore.get(url.host());

                        if (cookies == null) {
                            return Collections.EMPTY_LIST;
                        }

                        log.info("[url={}]取出cookie[{}]", url, cookies);
                        return cookies;
                    }
                })
                // 设置代理地址
                .proxy(new Proxy(Proxy.Type.HTTP, new InetSocketAddress("192.168.13.19", 7777)))
                .proxyAuthenticator(new Authenticator() {

                    @Override
                    public Request authenticate(Route route, Response response) throws IOException {
                        //设置代理服务器账号密码
                        String credential = Credentials.basic("xxx", "xxxx");
                        return response.request().newBuilder()
                                .header("Proxy-Authorization", credential)
                                .build();
                    }
                })
                .build();

        Request request = new Request.Builder().url("https://www.baidu.com").build();
        Response response = okHttpClient.newCall(request).execute();
        if (response.isSuccessful()) {
            log.info("response => " + response.body().string());
        }

        // 多次请求会有cookie
        Request request2 = new Request.Builder().url("https://blog.csdn.net/qq_36982160/article/details/82351373").build();
        Response response2 = okHttpClient.newCall(request2).execute();
        if (response2.isSuccessful()) {
            log.info("response => " + response2.body().string());
        }
    }


}
