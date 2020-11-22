package cn.chenzw.dependence.jsoup;

import cn.chenzw.toolkit.commons.ResourceExtUtils;
import com.jayway.jsonpath.JsonPath;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.File;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
@RunWith(JUnit4.class)
public class JsoupTests {


    /**
     * 解析Html
     */
    @Test
    public void testParseHtml() {
        String html = "<html><head><title>First parse</title></head>"
                + "<body><p>Parsed HTML into a doc.</p></body></html>";
        Document doc = Jsoup.parse(html);

        log.info(doc.toString());
    }


    /**
     * 解析片段
     */
    @Test
    public void testParseBodyFragment() {
        String html = "<div><p>Lorem ipsum.</p>";
        Document doc = Jsoup.parseBodyFragment(html);
        Element body = doc.body();

        log.info(body.toString());
    }

    /**
     * Get请求中加载document
     *
     * @throws IOException
     */
    @Test
    public void testGet() throws IOException {
        Document doc = Jsoup.connect("https://www.baidu.com/").get();

        log.info(doc.toString());
    }

    /**
     * Post请求中加载document
     *
     * @throws IOException
     */
    @Test
    public void testPost() throws IOException {
        Document doc = Jsoup.connect("https://www.baidu.com")
                .data("query", "Java")
                .userAgent("Mozilla")
                .cookie("auth", "token")
                .timeout(3000)
                .post();

        log.info(doc.toString());
    }

    /**
     * 从文件中加载document
     *
     * @throws IOException
     */
    @Test
    public void testFile() throws IOException {
        File input = ResourceExtUtils.loadFromClassPath("bilibili.html");
        Document doc = Jsoup.parse(input, "UTF-8", "https://www.baidu.com/");

        log.info(doc.toString());
    }


}
