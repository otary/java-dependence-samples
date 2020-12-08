package cn.chenzw.java.dependence.lombok;

import cn.chenzw.denpendence.lombok.domain.genericbuilder.Result;
import cn.chenzw.denpendence.lombok.domain.superbuilder.Children;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@Slf4j
@RunWith(JUnit4.class)
public class LombokTests {


    @Test
    public void testSuperBuilder() {
        Children children = Children.builder()
                .cName("儿子1")
                .cAge("12")
                .fName("父亲1")
                .fAge("20")
                .build();

        log.info("children: " + children);
    }

    /**
     * 泛型构建器
     */
    @Test
    public void testGenericBuilder() {
        Result<String> result = Result.<String>builder()
                .code("200")
                .data("成功")
                .success(true)
                .build();

        log.info("result: => " + result);
    }

    /**
     * 字段值从另一个方法中取
     */
    @Test
    public void testObtainVia() {
        Result<String> result = Result.<String>builder().build().toBuilder()
                .success(false)
                .data("失败")
                .build();

        log.info("result: => " + result);
    }
}
