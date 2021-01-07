package cn.chenzw.java.dependence.dom4j;

import cn.chenzw.java.dependence.dom4j.domain.Book;
import lombok.extern.slf4j.Slf4j;
import org.dom4j.*;
import org.dom4j.io.SAXReader;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.File;
import java.util.Iterator;
import java.util.List;

@Slf4j
@RunWith(JUnit4.class)
public class BasicSamplesTests {


    /**
     * 解析xml文件
     */
    @Test
    public void testReadXmlFile() {
        // 创建一个SAXReader对象
        SAXReader saxReader = new SAXReader();

        try {
            // 创建一个Document对象
            Document document = saxReader.read(new File("books.xml"));

            // 获得根节点
            Element rootNode = document.getRootElement();

            // 获得book元素的集合
            List<Element> books = rootNode.elements("book");

            // 遍历每一个book元素
            for (Element book : books) {
                // 创建一本书
                Book oneBook = new Book();

                // 获得每一个book元素的属性集合
                List<Attribute> attrs = book.attributes();

                // 遍历每一个book元素的属性
                for (Attribute attr : attrs) {

                    // 设置oneBook的id属性
                    if (attr.getName().equals("id"))
                        oneBook.setId(Integer.parseInt(attr.getValue()));
                }

                // 获得每一个book元素的子元素的迭代器
                Iterator<Element> elements = book.elementIterator();

                // 遍历迭代器
                while (elements.hasNext()) {
                    // 获得每一个book元素下的某个子元素
                    Element element = elements.next();

                    switch (element.getName()) {

                        case "name":
                            oneBook.setName(element.getText());
                            break;

                        case "author":
                            oneBook.setAuthor(element.getText());
                            break;

                        case "year":
                            oneBook.setYear(Integer.parseInt(element.getText()));
                            break;

                        case "price":
                            oneBook.setPrice(Double.parseDouble(element.getText()));
                            break;

                        case "language":
                            oneBook.setLanguage(element.getText());
                            break;

                        default:
                            break;
                    }
                }

                log.info("book => {}", book);
            }

        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }


    /**
     * 解析Xml文本
     */
    @Test
    public void testParseText() throws DocumentException {
        Document document = DocumentHelper.parseText("");
    }
}
