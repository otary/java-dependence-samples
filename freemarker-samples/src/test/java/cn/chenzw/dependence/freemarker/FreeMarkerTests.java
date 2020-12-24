package cn.chenzw.dependence.freemarker;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapperBuilder;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.*;

@RunWith(JUnit4.class)
public class FreeMarkerTests {


    @Test
    public void process() throws IOException {
       /* Configuration configuration = new Configuration(Configuration.VERSION_2_3_30);

        configuration.setDirectoryForTemplateLoading(new File(""));
        // 设置异常处理策略
        configuration.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        configuration.setLogTemplateExceptions(false);
        // 获取模板,并设置编码方式，这个编码必须要与页面中的编码格式一致，否则会出现乱码
        Template template = configuration.getTemplate(TEMPLATE_NAME, "UTF-8");
        // 合并数据模型与模板
        FileOutputStream fos = new FileOutputStream(OUTPUT_FILE_NAME);
        Writer out = new OutputStreamWriter(fos, "UTF-8");
        template.process(root, out);
        out.flush();
        out.close();*/
    }
}
