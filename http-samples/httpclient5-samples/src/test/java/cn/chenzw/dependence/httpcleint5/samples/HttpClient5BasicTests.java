package cn.chenzw.dependence.httpcleint5.samples;

import lombok.extern.slf4j.Slf4j;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.IOException;

@Slf4j
@RunWith(JUnit4.class)
public class HttpClient5BasicTests {

    @Test
    public void testGet() throws ParseException {
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpGet request = new HttpGet("https://www.baidu.com");

            try (CloseableHttpResponse response = httpClient.execute(request)) {
                int statusCode = response.getCode();
                log.info("statusCode => {}", statusCode);

                String responseBody = EntityUtils.toString(response.getEntity());
                log.info("responseBody => {}", responseBody);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
