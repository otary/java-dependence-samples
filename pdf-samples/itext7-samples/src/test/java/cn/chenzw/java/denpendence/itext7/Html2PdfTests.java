package cn.chenzw.java.denpendence.itext7;

import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.html2pdf.resolver.font.DefaultFontProvider;
import org.apache.commons.io.IOUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

@RunWith(JUnit4.class)
public class Html2PdfTests {

    @Test
    public void test() throws IOException {
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

        InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("html/input.html");

        html = IOUtils.toString(is, "UTF-8");

        ConverterProperties props = new ConverterProperties();
        /*DefaultFontProvider defaultFontProvider = new DefaultFontProvider(false, false, false);
        defaultFontProvider.addDirectory("src");
        props.setFontProvider(defaultFontProvider);*/
        HtmlConverter.convertToPdf(html, new FileOutputStream("result.pdf"), props);

    }
}
