package cn.chenzw.java.guava.cache;

import com.google.common.base.Charsets;
import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

/**
 * 布隆过滤器
 */
@Slf4j
@RunWith(JUnit4.class)
public class BloomFilterTests {

    @Test
    public void test() {
        // expectedInsertions: 预期插入的数据量（本例中插入1000w）
        // fpp: 误差率（误差率越小，占用空间越大，速率越慢）
        int expectedInsertions = 10000000;
        BloomFilter<CharSequence> bloomFilter = BloomFilter.create(Funnels.stringFunnel(Charsets.UTF_8), expectedInsertions, 0.01);

        for (int i = 0; i < 10000000; i++) {
            bloomFilter.put("张三_" + i);
        }

        List<String> mismatchs = new ArrayList<>();
        for (int i = 10000000; i < 20000000; i++) {
            boolean matched = bloomFilter.mightContain("张三_" + i);
            if (matched) {
                mismatchs.add("[张三_" + i + "]误匹配!");
            }
        }

        log.info("误匹配列表：{}", mismatchs);
        log.info("误匹配统计: [误匹配条数: {}, 误匹配率: {}]", mismatchs.size(), BigDecimal.valueOf((float) mismatchs.size() / expectedInsertions).setScale(2, RoundingMode.HALF_DOWN));


        // 可以尝试修改误差率，查看结果

    }
}
