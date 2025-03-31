package cn.chenzw.java.dependence.nginx.parser;

import com.github.odiszapc.nginxparser.NgxConfig;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.IOException;
import java.io.InputStream;

@Slf4j
@RunWith(JUnit4.class)
public class NginxParserTests {

    @Test
    public void test() throws IOException {
        InputStream is = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("nginx.conf");
        NgxConfig conf = NgxConfig.read(is);
        // conf.queryNgxBlock()

        log.info("nginx config => {}", conf);
    }
}
