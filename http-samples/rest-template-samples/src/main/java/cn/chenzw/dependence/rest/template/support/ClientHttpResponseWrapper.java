package cn.chenzw.dependence.rest.template.support;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author chenzw
 */
public class ClientHttpResponseWrapper implements ClientHttpResponse {

    private final ClientHttpResponse delegate;

    private final byte[] responseBody;

    public ClientHttpResponseWrapper(ClientHttpResponse response, byte[] body) {
        this.delegate = response;
        this.responseBody = body;
    }


    @Override
    public HttpStatus getStatusCode() throws IOException {
        return delegate.getStatusCode();
    }

    @Override
    public int getRawStatusCode() throws IOException {
        return delegate.getRawStatusCode();
    }

    @Override
    public String getStatusText() throws IOException {
        return delegate.getStatusText();
    }

    @Override
    public void close() {
        delegate.close();
    }

    @Override
    public InputStream getBody() throws IOException {
        return new ByteArrayInputStream(responseBody);
    }

    @Override
    public HttpHeaders getHeaders() {
        return delegate.getHeaders();
    }
}
