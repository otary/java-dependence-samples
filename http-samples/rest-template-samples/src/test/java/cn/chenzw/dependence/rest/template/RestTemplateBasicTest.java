package cn.chenzw.dependence.rest.template;

import cn.chenzw.dependence.rest.template.interceptors.LoggingClientHttpRequestInterceptor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = RestTemplateApp.class)
@WebAppConfiguration
public class RestTemplateBasicTest {

    @Autowired
    RestTemplate restTemplate;

    ObjectMapper mapper = new ObjectMapper();

    @Test
    public void testGet() {
        // 添加拦截器
        restTemplate.setInterceptors(Collections.singletonList(new LoggingClientHttpRequestInterceptor()));

        String result = restTemplate.getForObject("https://api.github.com/repositories", String.class);

        Assert.assertNotNull(result);
    }


    @Test
    public void testGetWithHeader() throws JsonProcessingException {
        // 头部
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.COOKIE, "a=1;b=2;");
        headers.setContentType(MediaType.TEXT_HTML);

        // 消息体
        String body = mapper.writeValueAsString(new HashMap<String, Object>() {
            {
                put("a", "1");
                put("b", "2");
            }
        });

        // 参数
        Map<String, Object> params = new HashMap<String, Object>() {
            {
                put("m", "1");
                put("n", "2");
            }
        };

        // 拦截器
        restTemplate.setInterceptors(Collections.singletonList(new LoggingClientHttpRequestInterceptor()));

        ResponseEntity<String> responseEntity = restTemplate.exchange("https://www.baidu.com?id={m}&id2={n}",
                HttpMethod.GET,
                new HttpEntity<>(body, headers), String.class,
                params
        );


    }
}
