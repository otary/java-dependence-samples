package cn.chenzw.dependence.snowflake;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.UUID;

@Slf4j
@RunWith(JUnit4.class)
public class SnowflakeIdGeneratorTests {


    /**
     * snowflake算法
     */
    @Test
    public void testSnowflake() {
        Snowflake snowflake = new Snowflake(1L, 1L);

        for (int i = 0; i < 10; i++) {
            log.info("生成ID => {}", snowflake.nextIdStr());
        }
    }

    /**
     * UUID Version4版本（基于随机数）
     */
    @Test
    public void testUUIDV4() {
        for (int i = 0; i < 10; i++) {
            log.info("生成UUIDv4 => {}", UUID.randomUUID());
        }
    }

    /**
     * UUID Version3版本（基于名称（MD5））
     */
    @Test
    public void testUUIDV3() {
        for (int i = 0; i < 10; i++) {
            log.info("生成UUIDv3 => {}",  UUID.nameUUIDFromBytes(("test_" + i).getBytes()));
        }

    }

}
