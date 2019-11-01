package cn.chenzw.java.guava.cache;

import com.google.common.cache.*;
import com.google.common.collect.Lists;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

@RunWith(JUnit4.class)
public class GuavaCacheTests {


    @Test
    public void testBasic() {
        Cache<Integer, String> cache = CacheBuilder.newBuilder().build();
        cache.put(1, "a");
        cache.put(2, "b");

        Assert.assertEquals("a", cache.getIfPresent(1));
        Assert.assertEquals("b", cache.getIfPresent(2));
        Assert.assertNull(cache.getIfPresent(3));
    }


    @Test
    public void testLoadingCache() throws ExecutionException {

        LoadingCache<Integer, String> cache = CacheBuilder.newBuilder().build(

                // 不存在缓存值时，自定义返回值
                new CacheLoader<Integer, String>() {
                    @Override
                    public String load(Integer key) throws Exception {
                        return "key-" + key;
                    }
                }
        );
        cache.put(1, "a");

        Assert.assertEquals("a", cache.getIfPresent(1));
        Assert.assertEquals("key-2", cache.get(2));
    }


    /**
     * 基于容量回收
     */
    @Test
    public void testMaximumSize() {
        // 指定最大容量
        Cache<Integer, String> cache = CacheBuilder.newBuilder().maximumSize(2).build();
        cache.put(1, "a");
        cache.put(2, "b");
        cache.put(3, "c");

        // 超过缓存数量则回收
        Assert.assertEquals("{3=c, 2=b}", cache.asMap().toString());

        cache.getIfPresent(2);
        cache.put(4, "d");

        // 2的缓存项被读取,所以未被回收
        Assert.assertEquals("{2=b, 4=d}", cache.asMap().toString());
    }


    /**
     * 基于时间的回收
     */
    @Test
    public void testExpireAfterAccess() {
        Cache<Integer, String> cache = CacheBuilder.newBuilder().expireAfterWrite(3, TimeUnit.SECONDS).build();
        cache.put(1, "a");

        Assert.assertEquals("a", cache.getIfPresent(1));

        // 3秒未读写，则缓存项被回收
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Assert.assertNull(cache.getIfPresent(1));
    }

    @Test
    public void testInvalidate() {
        Cache<Integer, String> cache = CacheBuilder.newBuilder().build();
        cache.put(1, "a");
        cache.put(2, "b");
        cache.put(3, "c");
        cache.put(4, "d");
        cache.put(5, "e");

        Assert.assertEquals("{5=e, 2=b, 1=a, 3=c, 4=d}", cache.asMap().toString());

        // 清除1个元素
        cache.invalidate(1);

        Assert.assertEquals("{5=e, 2=b, 3=c, 4=d}", cache.asMap().toString());

        // 清除多个元素
        cache.invalidateAll(Lists.newArrayList(4, 5));

        Assert.assertEquals("{2=b, 3=c}", cache.asMap().toString());

        // 清除所有元素
        cache.invalidateAll();

        Assert.assertEquals("{}", cache.asMap().toString());

    }

    @Test
    public void testRecordStats(){
        // 开启统计
        Cache<Integer, String> cache = CacheBuilder.newBuilder().recordStats().build();
        cache.put(1, "a");
        cache.put(2, "b");
        cache.put(3, "c");
        cache.put(4, "d");
        cache.put(5, "e");

        cache.getIfPresent(1);
        cache.getIfPresent(1);
        cache.getIfPresent(9);

        CacheStats stats = cache.stats();

        // 命中2次
        Assert.assertEquals(2, stats.hitCount());

        // 未命中1次
        Assert.assertEquals(1, stats.missCount());

        // 缓存项回收数量
        Assert.assertEquals(0, stats.evictionCount());

        Assert.assertEquals(0, stats.loadCount());

        Assert.assertEquals(0, stats.loadSuccessCount());

        Assert.assertEquals(0, stats.loadExceptionCount());

        Assert.assertEquals(0, stats.totalLoadTime());
    }

}
