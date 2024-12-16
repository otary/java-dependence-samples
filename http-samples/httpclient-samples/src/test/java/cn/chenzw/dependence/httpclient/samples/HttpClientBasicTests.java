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
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

@Slf4j
@RunWith(JUnit4.class)
public class HttpClientBasicTests {

    @Test
    public void testGet() {
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpGet httpGet = new HttpGet("http://www.baidu.com");
            httpGet.setHeader("aaa", "111");
            try (CloseableHttpResponse response = httpClient.execute(httpGet)) {
                Assert.assertEquals(200, response.getStatusLine().getStatusCode());
                String body = EntityUtils.toString(response.getEntity());
                log.info("body => {}", body);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 需要JDK11+
     * @throws IOException
     * @throws InterruptedException
     */
    @Test
    public void testGetUseChain() throws IOException, InterruptedException {
        HttpClient httpClient = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .connectTimeout(Duration.ofSeconds(10))
                .build();
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("https://www.baidu.com"))
                .header("aaa", "111")
                .build();
        HttpResponse<String> response = httpClient.send(
                httpRequest, HttpResponse.BodyHandlers.ofString()
        );
        log.info("statusCode => {}", response.statusCode());
        log.info("body => {}", response.body());
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
