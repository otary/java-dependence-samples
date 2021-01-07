package cn.chenzw.java.dependence.jaxb;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.util.Map;

@RunWith(JUnit4.class)
public class BasicSamplesTests {

    /**
     * xml => map
     */
    @Test
    public void testXmlToMap() throws JAXBException {
        String xml = "<note>\n" +
                "<to>George</to>\n" +
                "<from>John</from>\n" +
                "<heading>Reminder</heading>\n" +
                "<body>Don't forget the meeting!</body>\n" +
                "</note>";

        JAXBContext jaxbContext = JAXBContext.newInstance(Map.class);

        Unmarshaller unmarshaller =
                jaxbContext.createUnmarshaller();

      //  unmarshaller.unmarshal(xml.getBytes());
    }
}
