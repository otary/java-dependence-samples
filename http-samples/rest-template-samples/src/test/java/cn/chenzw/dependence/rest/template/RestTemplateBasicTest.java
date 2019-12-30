package cn.chenzw.dependence.rest.template;

import cn.chenzw.dependence.rest.template.interceptors.LoggingClientHttpRequestInterceptor;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;



@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = RestTemplateApp.class)
@WebAppConfiguration
public class RestTemplateBasicTest {

    @Autowired
    RestTemplate restTemplate;

    @Test
    public void testGet() {
        // 添加拦截器
        restTemplate.setInterceptors(Collections.singletonList(new LoggingClientHttpRequestInterceptor()));

        String result = restTemplate.getForObject("https://api.github.com/repositories", String.class);

        Assert.assertNotNull(result);
    }


}
