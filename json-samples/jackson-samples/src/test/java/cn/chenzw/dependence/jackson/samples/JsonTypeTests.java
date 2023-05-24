package cn.chenzw.dependence.jackson.samples;

import cn.chenzw.dependence.jackson.samples.domain.entity.modules.Animal;
import cn.chenzw.dependence.jackson.samples.domain.entity.modules.Cat;
import cn.chenzw.dependence.jackson.samples.domain.entity.modules.Dog;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * @author chenzw
 */
@Slf4j
@RunWith(JUnit4.class)
public class JsonTypeTests {


    /**
     * @JsonTypeInfo 和 @JsonSubTypes 使用示例
     */
    @Test
    public void test() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        // 根据type字段映射不同的类型
        Animal animal = objectMapper.readValue("{\"type\":\"cat\",\"name\":\"猫\",\"weight\":\"10.2\"}", Animal.class);
        log.info("animal => {}", animal);
        log.info("animal instanceof Cat => {}", animal instanceof Cat);

        Animal animal2 = objectMapper.readValue("{\"type\":\"dog\",\"name\":\"狗\",\"breed\":\"哈士奇\"}", Animal.class);
        log.info("animal => {}", animal2);
        log.info("animal instanceof Dog => {}", animal instanceof Dog);
    }
}
