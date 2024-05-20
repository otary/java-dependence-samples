package cn.chenzw.dependence.elasticsearch;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpHost;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.IOException;

/**
 * @author chenzw
 */
@Slf4j
@RunWith(JUnit4.class)
public class ElasticSearchTests {

    private RestHighLevelClient createClient() {
        // 初始化RestClientBuilder
        RestClientBuilder builder = RestClient.builder(
                new HttpHost("localhost", 9200, "http")
        );
        return new RestHighLevelClient(builder);
    }

    @Test
    public void testCreateClient() {
        try (RestHighLevelClient client = createClient()) {
            log.info("client => {}", client);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testBasic() {
        // 构建RestHighLevelClient
        try (RestHighLevelClient client = createClient()) {
            // 创建索引请求
            IndexRequest request = new IndexRequest("my-index");
            // 设置文档的内容
            String jsonString = "{" +
                    "\"user\":\"kimchy\"," +
                    "\"postDate\":\"2023-04-07\"," +
                    "\"message\":\"trying out Elasticsearch\"" +
                    "}";
            request.source(jsonString, XContentType.JSON);

            // 执行请求，并获取响应
            IndexResponse indexResponse = client.index(request, RequestOptions.DEFAULT);

            // 打印结果
            log.info("Index Response Status => {}" + indexResponse.getResult());
            log.info("Index Response Index => {}" + indexResponse.getIndex());
            log.info("Index Response Type => {}" + indexResponse.getType());
            log.info("Index Response ID => {}" + indexResponse.getId());
            log.info("Index Response Version => {}" + indexResponse.getVersion());
            log.info("Index Response Result => {}" + indexResponse.getResult());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
