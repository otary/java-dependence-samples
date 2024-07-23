package cn.chenzw.dependence.esapi;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.owasp.esapi.ESAPI;
import org.owasp.esapi.errors.EncodingException;

/**
 * @author chenzw
 */
@Slf4j
@RunWith(JUnit4.class)
public class BasicTests {

    @Test
    public void testEncode() throws EncodingException {
        String url = ESAPI.encoder().encodeForURL("https://www.baidu.com");
        log.info("URL => {}", url);

        String base64 = ESAPI.encoder().encodeForBase64("hello".getBytes(), true);
        log.info("base64 => {}", base64);
    }

}
