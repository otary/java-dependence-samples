package cn.chenzw.java.denpendence.itext7;

import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;


@RunWith(JUnit4.class)
public class Html2PdfTests {

    @Test
    public void testSimpleHtml2Pdf() throws IOException {
        String html = "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\"/>\n" +
                "    <title>标题</title>\n" +
                "</head>\n" +
                "<style>\n" +
                "    *{\n" +
                "        font-family: KaiTi_GB2312;\n" +
                "    }\n" +
                "</style>\n" +
                "<body>\n" +
                "    这是带有中文的html格式内容hello world! <font color=\"red\">XMLWorkerHelper</font> [这是带有中文的html格式内容]\n" +
                "</body>\n" +
                "</html>";

        HtmlConverter.convertToPdf(html, new FileOutputStream("result.pdf"), new ConverterProperties());
    }

    @Test
    public void testHtml2Pdf() throws IOException {
        InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("html/input.html");

        HtmlConverter.convertToPdf(is, new FileOutputStream("result.pdf"), new ConverterProperties());
    }
}
