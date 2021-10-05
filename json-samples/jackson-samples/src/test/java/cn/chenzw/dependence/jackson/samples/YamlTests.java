package cn.chenzw.dependence.jackson.samples;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.javaprop.JavaPropsMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import org.apache.commons.io.IOUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Properties;

@RunWith(JUnit4.class)
public class YamlTests {

    @Test
    public void testProperties2Yaml() throws IOException {
        String propertiesStr = "dubbo.registry.address=zookeeper://10.0.65.3:2181\n" +
                "dubbo.admin.root.password=root\n" +
                "dubbo.admin.guest.password=guest";
        /*Properties properties = new Properties();
        properties.load(new StringReader(propertiesStr));
        System.out.println(properties);*/

        JavaPropsMapper javaPropsMapper = JavaPropsMapper.builder().build();
        JsonNode jsonNode = javaPropsMapper.readTree(propertiesStr);

        YAMLMapper yamlMapper = new YAMLMapper();
        String result = yamlMapper.writeValueAsString(jsonNode);
        System.out.println(result);
    }

    @Test
    public void testYaml2Properties() throws IOException {
        String yamlStr = "---\n" +
                "dubbo:\n" +
                "  admin:\n" +
                "    guest:\n" +
                "      password: \"guest\"\n" +
                "    root:\n" +
                "      password: \"root\"\n" +
                "  registry:\n" +
                "    address: \"zookeeper://10.0.65.3:2181\"";

        YAMLMapper yamlMapper = new YAMLMapper();
        JsonNode jsonNode = yamlMapper.readTree(yamlStr);

        JavaPropsMapper javaPropsMapper = JavaPropsMapper.builder().build();
        Properties properties = javaPropsMapper.writeValueAsProperties(jsonNode);

        StringWriter sw = new StringWriter();
        properties.store(sw, "生成");
        System.out.println(sw.toString());

        System.out.println(properties);
    }
}
