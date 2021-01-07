package cn.chenzw.dependence.jackson.samples;

import cn.chenzw.dependence.jackson.samples.domain.entity.User;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Calendar;


@Slf4j
@RunWith(JUnit4.class)
public class BasicTests {

    private User user;

    @Before
    public void setup() {
        this.user = new User();
        this.user.setId(1L);
        this.user.setName("张三");
        this.user.setPassword("123");
        this.user.setRemark("xxxx");
        this.user.setBirthDate(Calendar.getInstance().getTime());
        this.user.setHapyyDate(Calendar.getInstance().getTime());
        this.user.setMoney(new BigDecimal(100.19));
        this.user.setHeight(1.8);
        this.user.setMobiles(Arrays.asList(
                new User.Mobile(1L, "12345678"),
                new User.Mobile(2L, "87654321")
        ));
    }

    /**
     * 默认序列化输出
     *
     * @throws JsonProcessingException
     */
    @Test
    public void testWriteValueAsStringDefault() throws JsonProcessingException {
        // 默认输出null值字段
        ObjectMapper objectMapper = new ObjectMapper();

        String json = objectMapper.writeValueAsString(user);

        log.info("result => {}", json);
    }

    /**
     * 使用SerializationFeature特性
     *
     * @throws JsonProcessingException
     */
    @Test
    public void testWriteWithFeatures() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        String defaultJson = objectMapper.writer()
                .writeValueAsString(user);

        log.info("default result => {}", defaultJson);

       // objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);

        String json = objectMapper.writer()
                .withFeatures(
                        // SerializationFeature.WRITE_DATES_AS_TIMESTAMPS,  // 日期格式使用时间戳输出（默认）
                        // SerializationFeature.INDENT_OUTPUT,  // 缩进（美化输出）
                        // SerializationFeature.WRAP_ROOT_VALUE,  // 再包装一层类名（{"User": {}}）

                        //  SerializationFeature.WRITE_ENUM_KEYS_USING_INDEX  // 输出enum的索引
                        //  SerializationFeature.WRITE_ENUMS_USING_TO_STRING   //输出enum.toString()

                        SerializationFeature.CLOSE_CLOSEABLE
                )
                .writeValueAsString(user);

        log.info("use feature result => {}", json);
    }

    /**
     *
     */
    @Test
    public void testWriteWithSerializationInclusion() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);

        String json = objectMapper.writeValueAsString(user);

        log.info("result => {}", json);

    }


    @Test
    public void testDeserializer() throws JsonProcessingException {
      /*  String str = "{\"id\": 1, \"name\": \"张三\", \"birthDate\": \"2020-09-20 10:20:40\", \"test\": \"test1\", \"test2\":\"test21\", \"sex\": \"男\", \"password\":\"12345\"}";

        ObjectMapper objectMapper = new ObjectMapper();
        User user = objectMapper.readValue(str, User.class);

        System.out.println(user);

        assertEquals("1", user.getId().toString());
        assertEquals("张三", user.getName());
        assertEquals("Sun Sep 20 18:20:40 CST 2020", user.getBirthDate().toString());
        // 忽略字段
        assertNull(user.getSex());

        // 只写，可读
        assertEquals("12345", user.getPassword());

        assertThat(user.getExt(), Matchers.hasEntry("test", "test1"));
        assertThat(user.getExt(), Matchers.hasEntry("test2", "test21"));
        assertThat(user.getExt(), Matchers.hasEntry("sex", "男"));


        String str2 = objectMapper.writeValueAsString(user);
        // password字段不可写
        System.out.println(str2);

        log.info("");*/
    }


}
