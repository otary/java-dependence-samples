package cn.chenzw.dependence.okhttp.samples.interceptors;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class LoggingInterceptor implements Interceptor {

    private static final Logger logger = LoggerFactory.getLogger(LoggerFactory.class);

    @Override
    public Response intercept(Chain chain) throws IOException {

        Request request = chain.request();

       // logger.info(" [request]> uri:{}, body:{}", request.url(), request.body());

        Response response = chain.proceed(request);


        // logger.info(" [response]> code:{}, message:{}, body:{}", response.code(), response.message(), response.peekBody(1024*1024).string());

       // logger.info(" [response]> code:{}, message:{}, body:{}", response.code(), response.message());


        return response;
    }
}
