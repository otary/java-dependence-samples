package cn.chenzw.java.dependence.jaxb;

import cn.chenzw.java.dependence.jaxb.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@RunWith(JUnit4.class)
public class BasicSamplesTests {

    /**
     * Java Bean => XML
     * @throws JAXBException
     */
    @Test
    public void testBeanToXml() throws JAXBException {
        JAXBContext jc = JAXBContext.newInstance(User.class);
        // 创建序列化器,用于将java对象转化成XML数据
        Marshaller jaxbMarshaller = jc.createMarshaller();
        // 指定是否格式化生成的xml串,默认false
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        // 指定xsi:schemaLocation属性值
        jaxbMarshaller.setProperty(Marshaller.JAXB_SCHEMA_LOCATION, "ssss");
        // 指定xsi:noNamespaceSchemaLocation属性值
        jaxbMarshaller.setProperty(Marshaller.JAXB_NO_NAMESPACE_SCHEMA_LOCATION, "eeee");
        // 指定是否省略头部声明,默认false
        jaxbMarshaller.setProperty(Marshaller.JAXB_FRAGMENT, false);

        User user = new User();
        user.setId(1L);
        user.setName("张三");

        jaxbMarshaller.marshal(user, System.out);
    }

    /**
     * XML字符串 => Java Bean对象
     * @throws JAXBException
     */
    @Test
    public void testXmlToBean() throws JAXBException {
        JAXBContext jc = JAXBContext.newInstance(User.class);
        Unmarshaller jaxbUnmarshaller = jc.createUnmarshaller();

        User user = (User) jaxbUnmarshaller.unmarshal(new StringReader("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
                "<user xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"ssss\" xsi:noNamespaceSchemaLocation=\"eeee\">\n" +
                "    <id>1</id>\n" +
                "    <name>张三</name>\n" +
                "</user>"));

        log.info("user => {}", user);
    }

    /**
     * xml => map
     */
    @Test
    public void testXmlToMap() throws JAXBException {
        /*JAXBContext jaxbContext = JAXBContext.newInstance(HashMap.class);

        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

        Map map = (Map) unmarshaller.unmarshal(new StringReader("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
                "<user>\n" +
                "    <id>1</id>\n" +
                "    <name>张三</name>\n" +
                "</user>"));

        log.info("map => {}", map);*/
    }
}
