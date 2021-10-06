package cn.chenzw.dependence.faker;

import com.github.javafaker.Faker;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Locale;

@Slf4j
@RunWith(JUnit4.class)
public class FakerTests {

    @Test
    public void test() {
        Faker faker = new Faker(new Locale("zh-CN"));

        for (int i = 0; i < 5; i++) {
            log.info("fullName => {}", faker.name().fullName());
            log.info("title => {}", faker.name().title());
            log.info("username => {}", faker.name().username());
            log.info("city => {}", faker.address().city());
            log.info("fullAddress => {}", faker.address().fullAddress());
        }

    }
}
