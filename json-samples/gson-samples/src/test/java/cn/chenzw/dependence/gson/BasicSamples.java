package cn.chenzw.dependence.gson;

import cn.chenzw.dependence.gson.adapter.StringNullAdapter;
import cn.chenzw.dependence.gson.domain.User;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.lang.reflect.Modifier;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

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
        this.user.setMoney(new BigDecimal(100.19));
        this.user.setHeight(1.8);
        this.user.setMobiles(Arrays.asList(
                new User.Mobile(1L, "12345678"),
                new User.Mobile(2L, "87654321")
        ));
    }

    /**
     * 默认
     */
    @Test
    public void testToJsonDefault() {
        // 默认不输出null值字段
        Gson gson = new GsonBuilder()
                .create();

        String json = gson.toJson(user);

        // Assert.assertEquals("{\"id\":1,\"userName\":\"张三\",\"mobiles\":[{\"id\":1,\"no\":\"12345678\"},{\"id\":2,\"no\":\"87654321\"}],\"birthDate\":\"Jan 6, 2021 8:42:11 PM\"}", json);

        log.info("result => {}", json);
    }

    /**
     * @Expoose注解
     */
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

        // Assert.assertEquals("{\"id\":1,\"name\":\"张三\",\"mobiles\":[{\"id\":1,\"no\":\"12345678\"},{\"id\":2,\"no\":\"87654321\"}],\"birthDate\":\"2021-01-06 20:06:10\"}", json);

        log.info("result => {}", json);
    }

    /**
     * 字段名转换策略
     */
    @Test
    public void testFieldNamingStrategy() {
        Gson gson = new GsonBuilder()
                // .setFieldNamingStrategy(FieldNamingPolicy.LOWER_CASE_WITH_DASHES)  // 小写 + 破折号（eg.birthDate-date）
                .setFieldNamingStrategy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)  // 小写 + 下划线（eg.birth_date）
                // .setFieldNamingStrategy(FieldNamingPolicy.LOWER_CASE_WITH_DOTS) // 小写 + 点（eg. birthDate.date）
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
     * 注册类型转换器（版本<=2.2.1不支持自定义注册adapter）
     * <p>
     * 父类：JsonSerializer、JsonDeserializer、InstanceCreator、TypeAdapter
     * <p>
     * eg. 将null值转换成字符串""
     */
    @Test
    public void testRegisterTypeAdapter() {
        Gson gson = new GsonBuilder()
                .serializeNulls()
                .registerTypeAdapter(String.class, new StringNullAdapter())
                .create();

        String json = gson.toJson(user);

        log.info("result => {}", json);
    }

    /**
     * 根据修饰符过滤输出字段
     */
    @Test
    public void testExcludeFieldsWithModifiers() {
        Gson gson = new GsonBuilder()
                .excludeFieldsWithModifiers(Modifier.STATIC, Modifier.TRANSIENT, Modifier.VOLATILE)  // 忽略某些修饰符字段
                .create();

        String json = gson.toJson(user);

        log.info("result => {}", json);
    }

    /**
     * 版本号（各版本显示不同字段 @Since、@Unit）
     */
    @Test
    public void testVersion() {
        Gson gson = new GsonBuilder()
                .setVersion(1.2)  // 当前版本号
                //.setVersion(2.7)
                .create();

        String json = gson.toJson(user);

        log.info("result => {}", json);
    }

    /**
     * 转JsonElement操作
     */
    @Test
    public void testToJsonTree() {
        Gson gson = new GsonBuilder().create();

        JsonElement jsonElement = gson.toJsonTree(user);

        JsonObject jo = jsonElement.getAsJsonObject();  // Object对象

        log.info("user.id => {}", jo.get("id"));

        JsonArray ja = jo.getAsJsonArray("mobiles");   // Array数组

        for (JsonElement element : ja) {
            JsonObject mobile = element.getAsJsonObject();

            log.info("user.mobile.no => {}", mobile.get("no"));
        }


        // JsonPrimitive jp = jsonElement.getAsJsonPrimitive();
        // JsonNull jn = jsonElement.getAsJsonNull();

    }


    @Test
    public void testFromJsonDefault() {
        Gson gson = new GsonBuilder().create();

        User user = gson.fromJson("{\"id\":1,\"userName\":\"张三\",\"password\": \"12345\", \"mobiles\":[{\"id\":1,\"no\":\"12345678\"},{\"id\":2,\"no\":\"87654321\"}],\"birthDate\":\"Jan 7, 2021 8:51:08 AM\"}", User.class);

        log.info("user => {}", user);
    }

    /**
     * 泛型反序列化
     */
    @Test
    public void testFromJsonWithGeneric() {
        Gson gson = new GsonBuilder().create();

        List<User> users = gson.fromJson("[{\"id\":1,\"userName\":\"张三\",\"mobiles\":[{\"id\":1,\"no\":\"12345678\"},{\"id\":2,\"no\":\"87654321\"}],\"birthDate\":\"Jan 7, 2021 9:54:00 AM\",\"money\":100.18999999999999772626324556767940521240234375,\"height\":1.8},{\"id\":1,\"userName\":\"张三\",\"mobiles\":[{\"id\":1,\"no\":\"12345678\"},{\"id\":2,\"no\":\"87654321\"}],\"birthDate\":\"Jan 7, 2021 9:54:00 AM\",\"money\":100.18999999999999772626324556767940521240234375,\"height\":1.8}]", new TypeToken<List<User>>() {
        }.getType());

        log.info("users => {}", users);
    }

    /**
     * 数组反序列化
     */
    @Test
    public void testFromJsonWithArray() {
        Gson gson = new GsonBuilder()
                .create();

        User[] users = gson.fromJson("[{\"id\":1,\"userName\":\"张三\",\"mobiles\":[{\"id\":1,\"no\":\"12345678\"},{\"id\":2,\"no\":\"87654321\"}],\"birthDate\":\"Jan 7, 2021 9:54:00 AM\",\"money\":100.18999999999999772626324556767940521240234375,\"height\":1.8},{\"id\":1,\"userName\":\"张三\",\"mobiles\":[{\"id\":1,\"no\":\"12345678\"},{\"id\":2,\"no\":\"87654321\"}],\"birthDate\":\"Jan 7, 2021 9:54:00 AM\",\"money\":100.18999999999999772626324556767940521240234375,\"height\":1.8}]", User[].class);

        log.info("users => {}", Arrays.toString(users));
    }

    /**
     * 反序列化为Map
     */
    @Test
    public void testFromJsonWithMap() {
        Gson gson = new GsonBuilder()
                .create();

        Map userMap = gson.fromJson("{\"id\":1,\"userName\":\"张三\",\"password\": \"12345\", \"mobiles\":[{\"id\":1,\"no\":\"12345678\"},{\"id\":2,\"no\":\"87654321\"}],\"birthDate\":\"Jan 7, 2021 8:51:08 AM\"}", Map.class);

        log.info("userMap => {}", userMap);

        Map<String, Object> userGenericMap = gson.fromJson("{\"id\":1,\"userName\":\"张三\",\"password\": \"12345\", \"mobiles\":[{\"id\":1,\"no\":\"12345678\"},{\"id\":2,\"no\":\"87654321\"}],\"birthDate\":\"Jan 7, 2021 8:51:08 AM\"}", new TypeToken<Map<String, Object>>() {
        }.getType());

        log.info("userGenericMap => {}", userGenericMap);
    }

    /**
     * 反序列化Map字段
     */
    @Test
    public void testFromJsonWithMapField() {
        Gson gson = new GsonBuilder()
                .create();

        User user = gson.fromJson("{\"id\":1,\"userName\":\"张三\",\"mobiles\":[{\"id\":1,\"no\":\"12345678\"},{\"id\":2,\"no\":\"87654321\"}],\"birthDate\":\"Jan 7, 2021 10:47:41 AM\",\"money\":100.18999999999999772626324556767940521240234375,\"height\":1.8,\"ext\":{\"a\":\"1\",\"b\":\"2\"}}", User.class);

        log.info("user => {}", user);
    }

    /**
     * 大数据处理
     */
    @Test
    public void testJsonReader() {

    }

    @Test
    public void testJsonWriter() {

    }
}
