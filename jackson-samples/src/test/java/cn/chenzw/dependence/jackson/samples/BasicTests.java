package cn.chenzw.dependence.jackson.samples;

import cn.chenzw.dependence.jackson.samples.domain.entity.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class BasicTests {


    @Test
    public void testDeserializer() throws JsonProcessingException {
        String str = "{\"id\": 1, \"name\": \"张三\", \"birth\": \"2020-09-20 10:20:40\", \"test\": \"test1\", \"test2\":\"test21\", \"sex\": \"男\", \"password\":\"12345\"}";

        ObjectMapper objectMapper = new ObjectMapper();
        User user = objectMapper.readValue(str, User.class);

        System.out.println(user);

        assertEquals("1", user.getId().toString());
        assertEquals("张三", user.getName());
        assertEquals("Sun Sep 20 18:20:40 CST 2020", user.getBirth().toString());
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
    }

}
