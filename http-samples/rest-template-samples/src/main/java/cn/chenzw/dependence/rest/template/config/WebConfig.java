package cn.chenzw.dependence.rest.template.config;

import cn.chenzw.dependence.rest.template.interceptors.LoggingClientHttpRequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.Collections;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"cn.chenzw.dependence.rest.template"})
public class WebConfig {

    /**
     * 使用BufferingClientHttpRequestFactory才能重复打印response数据
     *
     * @return
     */
    @Bean
    public RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate(
                new BufferingClientHttpRequestFactory(new SimpleClientHttpRequestFactory())
        );
        restTemplate.setInterceptors(
                Collections.singletonList(
                        new LoggingClientHttpRequestInterceptor()
                )
        );
        return restTemplate;
    }
}
