package cn.chenzw.java.guava.concurrent;

import cn.chenzw.toolkit.commons.DateExtUtils;
import com.google.common.util.concurrent.RateLimiter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

@RunWith(JUnit4.class)
public class RateLimiterTests {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    private static DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


    @Test
    public void testBasic(){
        // 每秒只分发5个令牌（每200ms分发一个令牌）
        RateLimiter rateLimiter = RateLimiter.create(5);
        for (int i = 0; i < 50; i++) {
            logger.info("{} - {}", dateFormat.format(Calendar.getInstance().getTime()), rateLimiter.acquire());
        }
    }

    @Test
    public void testWarmupPeriod() {
        // 每2秒分发5个令牌
        RateLimiter rateLimiter = RateLimiter.create(5, 2, TimeUnit.SECONDS);
        for (int i = 0; i < 50; i++) {
            logger.info("{} - {}", dateFormat.format(Calendar.getInstance().getTime()), rateLimiter.acquire());
        }
    }

    @Test
    public void testTryAcquire(){
        // 每秒分发500个令牌（每2ms分发一个）
        RateLimiter rateLimiter = RateLimiter.create(500);
        for (int i = 0; i < 50; i++) {
            if(rateLimiter.tryAcquire()){
                logger.info("{} - {}", dateFormat.format(Calendar.getInstance().getTime()), rateLimiter.acquire());
            } else {
                logger.warn("{}", dateFormat.format(Calendar.getInstance().getTime()));
            }
        }
    }


}
