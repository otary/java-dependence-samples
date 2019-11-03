package cn.chenzw.dependence.rest.template.interceptors;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;

/**
 * 日志拦截器
 *
 * @author chenzw
 */
public class LoggingClientHttpRequestInterceptor implements ClientHttpRequestInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(LoggingClientHttpRequestInterceptor.class);

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        logger.info("- uri:[{}]", request.getURI());
        logger.info("- method:[{}]", request.getMethod());
        logger.info("- headers: [{}]", request.getHeaders());
        logger.info("- boyd:[{}]", new String(body));

        ClientHttpResponse response = execution.execute(request, body);

        logger.info("- response code:[{}]", response.getStatusCode());
        logger.info("- response text:[{}]", response.getStatusText());
        logger.info("- response headers:[{}]", response.getHeaders());
        logger.info("- response body:[{}]", IOUtils.toString(response.getBody(), "UTF-8"));

        return response;
    }
}
