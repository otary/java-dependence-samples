package cn.chenzw.dependence.httpclient.samples;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.IOException;

@RunWith(JUnit4.class)
public class HttpClientBasicTests {

    @Test
    public void testBasic() {
        CloseableHttpClient client = HttpClients.createDefault();

        HttpGet get = new HttpGet("http://www.baidu.com");

        CloseableHttpResponse response = null;
        try {
            response = client.execute(get);

            Assert.assertEquals(200, response.getStatusLine().getStatusCode());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                response.close();
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
