package cn.chenzw.dependence.junit.samples;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(JUnit4.class)
public class HamcrestTests {

    /**
     * 数组
     */
    @Test
    public void testArray() {
        String[] sArray = new String[]{"aaaa", "bbbb", "cccc", "dddd", "eeee", "ffff", "gggg"};

        Assert.assertThat(sArray, Matchers.hasItemInArray("bbbb"));
        Assert.assertThat(sArray, Matchers.arrayContainingInAnyOrder("bbbb", "aaaa", "cccc", "dddd", "ffff", "gggg", "eeee"));
    }

    /**
     * Map
     */
    @Test
    public void testMap() {
        Map<Integer, String> sMap = new HashMap<>();
        sMap.put(1, "zhangsan");
        sMap.put(2, "lisi");
        sMap.put(3, "wangwu");
        sMap.put(4, "zhaoliu");

        // 是否存在entry
        Assert.assertThat(sMap, Matchers.hasEntry(3, "wangwu"));
        // 是否存在key
        Assert.assertThat(sMap, Matchers.hasKey(2));
        // 是否存在value
        Assert.assertThat(sMap, Matchers.hasValue("zhaoliu"));
    }

    @Test
    public void testList() {
        List<String> sList = new ArrayList<>();
        sList.add("aaaa");
        sList.add("bbbb");
        sList.add("cccc");
        sList.add("dddd");

        Assert.assertThat(sList, Matchers.hasItem("bbbb"));
        Assert.assertThat(sList, Matchers.hasItems("bbbb", "cccc"));

    }
}
