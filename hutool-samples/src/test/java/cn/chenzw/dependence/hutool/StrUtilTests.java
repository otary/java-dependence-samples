package cn.chenzw.dependence.hutool;

import cn.hutool.core.codec.Base62;
import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.StrUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * @author chenzw
 */
@Slf4j
@RunWith(JUnit4.class)
public class StrUtilTests {

    @Test
    public void testBase62Encode() {
        String encode = Base62.encode("中国");
        Assert.assertEquals("19PTgl89d", encode);
    }
}
