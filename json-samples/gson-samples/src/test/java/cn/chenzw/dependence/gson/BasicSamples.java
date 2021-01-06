package cn.chenzw.dependence.gson;

import cn.chenzw.dependence.gson.domain.User;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.LongSerializationPolicy;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Arrays;
import java.util.Calendar;

@Slf4j
@RunWith(JUnit4.class)
public class BasicSamples {

    private User user;

    @Before
    public void setup() {
        this.user = new User();
        this.user.setId(1L);
        this.user.setName("张三");
        this.user.setPassword("123");
        this.user.setBirthDate(Calendar.getInstance().getTime());
        this.user.setMobiles(Arrays.asList(
                new User.Mobile(1L, "12345678"),
                new User.Mobile(2L, "87654321")
        ));
    }

    @Test
    public void testToJsonDefault() {
        Gson gson = new GsonBuilder()
                .create();

        String json = gson.toJson(user);

        // Assert.assertEquals("{\"id\":1,\"userName\":\"张三\",\"mobiles\":[{\"id\":1,\"no\":\"12345678\"},{\"id\":2,\"no\":\"87654321\"}],\"birthDate\":\"Jan 6, 2021 8:42:11 PM\"}", json);

        log.info("result => {}", json);
    }

    @Test
    public void testToJsonWithExposeAnnotation() {
        Gson gson = new GsonBuilder()
                //  .excludeFieldsWithoutExposeAnnotation()  // 启用@Expose注解
                .create();

        String json = gson.toJson(user);

        log.info("result => {}", json);
    }

    /**
     * 将null值字段也输出（默认不输出）
     */
    @Test
    public void testToJsonSerializeNulls() {
        Gson gson = new GsonBuilder()
                .serializeNulls()
                .create();

        String json = gson.toJson(user);

        log.info("result => {}", json);
    }

    /**
     * Long字段转换策略（数值 或 字符串，默认是数值）
     */
    @Test
    public void toJsonLongSerializationPolicy() {
        Gson gson = new GsonBuilder()
                .setLongSerializationPolicy(LongSerializationPolicy.STRING)
                .create();

        String json = gson.toJson(user);

        // Assert.assertEquals("{\"id\":\"1\",\"name\":\"张三\",\"mobiles\":[{\"id\":\"1\",\"no\":\"12345678\"},{\"id\":\"2\",\"no\":\"87654321\"}]}", json);

        log.info("result => {}", json);
    }

    /**
     * 日期格式化
     */
    @Test
    public void testDateFormat() {
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd HH:mm:ss")
                .create();

        String json = gson.toJson(user);

        // Assert.assertEquals("{\"id\":1,\"name\":\"张三\",\"mobiles\":[{\"id\":1,\"no\":\"12345678\"},{\"id\":2,\"no\":\"87654321\"}],\"birth\":\"2021-01-06 20:06:10\"}", json);

        log.info("result => {}", json);
    }

    /**
     * 字段名转换策略
     */
    @Test
    public void testFieldNamingStrategy() {
        Gson gson = new GsonBuilder()
                // .setFieldNamingStrategy(FieldNamingPolicy.LOWER_CASE_WITH_DASHES)  // 小写 + 破折号（eg.birth-date）
                .setFieldNamingStrategy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)  // 小写 + 下划线（eg.birth_date）
                // .setFieldNamingStrategy(FieldNamingPolicy.LOWER_CASE_WITH_DOTS) // 小写 + 点（eg. birth.date）
                // .setFieldNamingStrategy(FieldNamingPolicy.UPPER_CAMEL_CASE)   // 大写驼峰（eg. BirthDate）
                // .setFieldNamingStrategy(FieldNamingPolicy.UPPER_CAMEL_CASE_WITH_SPACES)  // 大写驼峰 + 空格（eg. Birth Date）
                // .setFieldNamingStrategy(FieldNamingPolicy.IDENTITY)  // 默认，原样输出
                .create();

        String json = gson.toJson(user);

        log.info("result => {}", json);
    }

    /**
     * 美化输出
     */
    @Test
    public void testPrettyPrinting() {
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        String json = gson.toJson(user);

        log.info("result => {}", json);
    }

    /**
     * 注册类型转换器
     */
    @Test
    public void testRegisterTypeAdapter() {

    }

    /**
     *  根据修饰符过滤输出字段
     */
    @Test
    public void testExcludeFieldsWithModifiers() {

    }

}
