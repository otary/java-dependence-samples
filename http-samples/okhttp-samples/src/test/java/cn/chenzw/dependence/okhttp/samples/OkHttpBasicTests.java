package cn.chenzw.dependence.okhttp.samples;

import cn.chenzw.dependence.okhttp.samples.domain.User;
import cn.chenzw.dependence.okhttp.samples.interceptors.LoggingInterceptor;
import okhttp3.*;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.IOException;
import java.util.concurrent.ConcurrentLinkedQueue;

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
    public void testBasicAsync() throws IOException {
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder().url("http://www.baidu.com").build();

        // 异步请求
        okHttpClient.newCall(request).enqueue(new Callback() {

            @Override
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

}