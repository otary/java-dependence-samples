package cn.chenzw.dependence.okhttp.samples.interceptors;

import okhttp3.*;
import okio.Buffer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class LoggingInterceptor implements Interceptor {

    private static final Logger logger = LoggerFactory.getLogger(LoggerFactory.class);

    @Override
    public Response intercept(Chain chain) throws IOException {

        Request request = chain.request();

        Buffer buffer = new Buffer();
        RequestBody requestBody = request.body();
        if (requestBody != null) {
            request.body().writeTo(buffer);
        }
        logger.info(" [request]> uri:{}, body:{}", request.url(), buffer.readUtf8());

        Response response = chain.proceed(request);

        logger.info(" [response]> code:{}, message:{}, body:{}", response.code(), response.message(), response.peekBody(1024).string());

        return response;
    }
}
