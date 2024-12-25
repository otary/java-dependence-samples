package cn.chenzw.dependence.rest.template.interceptors;

import cn.chenzw.dependence.rest.template.support.ClientHttpResponseWrapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;
import java.nio.charset.Charset;

/**
 * 日志拦截器
 *
 * @author chenzw
 */
@Slf4j
public class LoggingClientHttpRequestInterceptor implements ClientHttpRequestInterceptor {

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        log.debug("- request => {} {}", request.getMethod(), request.getURI());
        log.debug("- request headers: {}", request.getHeaders());
        log.debug("- request body: {}", new String(body));

        long t1 = System.currentTimeMillis();
        ClientHttpResponse response = execution.execute(request, body);
        long t2 = System.currentTimeMillis();

        log.debug("- response => {} - {}", response.getStatusCode(), response.getStatusText());
        log.debug("- response headers:{}", response.getHeaders());
        byte[] responseBodyBytes = response.getBody().readAllBytes();
        log.debug("- response body:{}", new String(responseBodyBytes, Charset.defaultCharset()));
        log.debug("- request cost {}ms", t2 - t1);
        return new ClientHttpResponseWrapper(response, responseBodyBytes);
    }
}
