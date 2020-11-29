package cn.chenzw.java.dependence.lombok;

import cn.chenzw.denpendence.lombok.domain.superbuilder.Children;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@Slf4j
@RunWith(JUnit4.class)
public class LombokTests {


    @Test
    public void testBuilder() {
        Children children = Children.builder()
                .cName("儿子1")
                .cAge("12")
                .fName("父亲1")
                .fAge("20")
                .build();

        log.info("children: " + children);
    }
}
