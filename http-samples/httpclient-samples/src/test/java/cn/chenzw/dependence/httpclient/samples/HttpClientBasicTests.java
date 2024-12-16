package cn.chenzw.dependence.httpclient.samples;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.IOException;

@Slf4j
@RunWith(JUnit4.class)
public class HttpClientBasicTests {

    @Test
    public void testGet() {
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpGet httpGet = new HttpGet("http://www.baidu.com");
            try (CloseableHttpResponse response = httpClient.execute(httpGet)) {
                Assert.assertEquals(200, response.getStatusLine().getStatusCode());
                String body = EntityUtils.toString(response.getEntity());
                log.info("body => {}", body);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testPost() {
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpPost httpPost = new HttpPost("https://www.baidu.com");
            httpPost.setEntity(new StringEntity("{}", ContentType.create("application/json", "utf-8")));
            try (CloseableHttpResponse response = httpClient.execute(httpPost)) {
                String body = EntityUtils.toString(response.getEntity());
                log.info("body => {}", body);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
