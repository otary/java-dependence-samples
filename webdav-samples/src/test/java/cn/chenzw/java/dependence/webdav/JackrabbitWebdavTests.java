package cn.chenzw.java.dependence.webdav;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.AuthCache;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.impl.auth.BasicScheme;
import org.apache.http.impl.auth.DigestScheme;
import org.apache.http.impl.client.BasicAuthCache;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.jackrabbit.webdav.DavConstants;
import org.apache.jackrabbit.webdav.DavException;
import org.apache.jackrabbit.webdav.MultiStatus;
import org.apache.jackrabbit.webdav.MultiStatusResponse;
import org.apache.jackrabbit.webdav.client.methods.HttpMkcol;
import org.apache.jackrabbit.webdav.client.methods.HttpPropfind;
import org.apache.jackrabbit.webdav.property.DavPropertyNameSet;
import org.apache.jackrabbit.webdav.version.DeltaVConstants;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URLDecoder;

/**
 * @author chenzw
 */
@Slf4j
@RunWith(JUnit4.class)
public class JackrabbitWebdavTests {

    /**
     * 未解决，建议使用webdav-spring-boot-starter试试
     * @throws IOException
     * @throws DavException
     */
    @Test
    public void test() throws IOException, DavException {
        URI serverURI = URI.create("https://dav.jianguoyun.com/dav/");
        String serverURL = serverURI.toASCIIString();
        if (!serverURL.endsWith("/")) {
            serverURL += "/";
        }

        PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();
        HttpHost targetHost = new HttpHost(serverURI.getHost(), serverURI.getPort());

        CredentialsProvider cp = new BasicCredentialsProvider();
        UsernamePasswordCredentials upc = new UsernamePasswordCredentials("656469722@qq.com", "aip69vqtzrx5r2ha");
        cp.setCredentials(new AuthScope(targetHost.getHostName(), targetHost.getPort()), upc);
        //cp.setCredentials(AuthScope.ANY, upc);

        AuthCache authCache = new BasicAuthCache();
        // Basic认证
        BasicScheme basicAuth = new BasicScheme();
        authCache.put(targetHost, basicAuth);

        // Digest认证
        // DigestScheme digestScheme = new DigestScheme();
        // authCache.put(targetHost, digestScheme);

        // Add AuthCache to the execution context
        HttpClientContext context = HttpClientContext.create();
        context.setCredentialsProvider(cp);
        context.setAuthCache(authCache);
        CloseableHttpClient client = HttpClients.custom().setConnectionManager(cm).build();

        // Propfind请求
        DavPropertyNameSet names = new DavPropertyNameSet();
        names.add(DeltaVConstants.COMMENT);
        names.add(DeltaVConstants.CREATOR_DISPLAYNAME);
        // DavConstants.DEPTH_1
        HttpPropfind propfind = new HttpPropfind(serverURL, DavConstants.PROPFIND_ALL_PROP_INCLUDE, names, DavConstants.DEPTH_1);
        HttpResponse resp = client.execute(propfind, context);
        int status = resp.getStatusLine().getStatusCode();

        log.info("List file  status is :" + status);

        // assertEquals(207, status)
        MultiStatus multistatus = propfind.getResponseBodyAsMultiStatus(resp);
        MultiStatusResponse[] responses = multistatus.getResponses();

        // 列举文件
        for (MultiStatusResponse response : responses) {
            String href = response.getHref();
            String path = URLDecoder.decode(href, "UTF-8");
            log.info("file => {}", href);
        }

        // 下载文件
        HttpGet get = new HttpGet("");
        HttpResponse execRel = client.execute(get, context);
        StatusLine statusLine = execRel.getStatusLine();
        HttpEntity httpEntity = execRel.getEntity();
        log.info("file content => {}", httpEntity.getContent());

        // 上传文件
        HttpPut put = new HttpPut("");
        FileInputStream fis = new FileInputStream("");
        InputStreamEntity requestEntity = new InputStreamEntity(fis);
        put.setEntity(requestEntity);
        int statusCode = client.execute(put, context).getStatusLine().getStatusCode();

        // 删除文件
        HttpDelete delete = new HttpDelete("");
        int statusCode2 = client.execute(delete, context).getStatusLine().getStatusCode();

        // 创建文件
        HttpMkcol mkcol = new HttpMkcol("");
        int statusCode3 = client.execute(mkcol, context).getStatusLine().getStatusCode();


    }
}
