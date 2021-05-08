package cn.chenzw.dependence.jackson.samples;

import cn.chenzw.dependence.jackson.samples.domain.entity.Address;
import cn.chenzw.dependence.jackson.samples.domain.entity.Employee;
import cn.chenzw.dependence.jackson.samples.domain.entity.User;
import cn.chenzw.dependence.jackson.samples.module.CustomSerializer;
import cn.chenzw.dependence.jackson.samples.module.User2JacksonModule;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Map;


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
     * 字段值排除（空、null）
     */
    @Test
    public void testWriteWithSerializationInclusion() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        objectMapper.setSerializationInclusion(
                JsonInclude.Include.NON_EMPTY  // 只输出非空的字段
                // JsonInclude.Include.NON_NULL  // 只输出非null的字段
                //  JsonInclude.Include.ALWAYS   // 全输出
                // JsonInclude.Include.NON_ABSENT
        );

        String json = objectMapper.writeValueAsString(user);

        log.info("result => {}", json);
    }


    /**
     * 默认反序列化
     *
     * @throws JsonProcessingException
     */
    @Test
    public void testReadValueDefault() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        User user = objectMapper.readValue("{\"id\":1,\"mobiles\":[{\"id\":1,\"no\":\"12345678\"},{\"id\":2,\"no\":\"87654321\"}],\"birthDate\":\"2021-01-07 06:12:25\",\"hapyyDate\":1609999945969,\"money\":100.18999999999999772626324556767940521240234375,\"height\":1.8,\"ext\":{},\"userName\":\"张三\"}", User.class);

        log.info("user => {}", user);
    }

    /**
     * 反序列化为节点（节点操作）
     *
     * @throws JsonProcessingException
     */
    @Test
    public void testReadTree() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree("{\"id\":1,\"mobiles\":[{\"id\":1,\"no\":\"12345678\"},{\"id\":2,\"no\":\"87654321\"}],\"birthDate\":\"2021-01-07 06:12:25\",\"hapyyDate\":1609999945969,\"money\":100.18999999999999772626324556767940521240234375,\"height\":1.8,\"ext\":{},\"userName\":\"张三\"}");

        log.info("user.name => {}", jsonNode.get("userName"));

        JsonNode mobiles = jsonNode.get("mobiles");
        for (JsonNode mobile : mobiles) {
            log.info("user.mobile.no => {}", mobile.get("no"));
        }

        // JsonNode => Java Bean
        User user = objectMapper.treeToValue(jsonNode, User.class);
        log.info("user => {}", user);

        // JavaBean => JsonNode
        JsonNode jsonNode2 = objectMapper.valueToTree(user);
        log.info("user jsonNode => {}", jsonNode2);

    }

    /**
     * 泛型反序列化
     */
    @Test
    public void testReadValueWithGeneric() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<User> users = objectMapper.readValue("[{\"id\":1,\"mobiles\":[{\"id\":1,\"no\":\"12345678\"},{\"id\":2,\"no\":\"87654321\"}],\"nickName\":null,\"birthDate\":\"2021-01-07 06:45:44\",\"hapyyDate\":1610001944160,\"money\":100.18999999999999772626324556767940521240234375,\"height\":1.8,\"ext\":{},\"userName\":\"张三\"},{\"id\":1,\"mobiles\":[{\"id\":1,\"no\":\"12345678\"},{\"id\":2,\"no\":\"87654321\"}],\"nickName\":null,\"birthDate\":\"2021-01-07 06:45:44\",\"hapyyDate\":1610001944160,\"money\":100.18999999999999772626324556767940521240234375,\"height\":1.8,\"ext\":{},\"userName\":\"张三\"}]",
                new TypeReference<List<User>>() {
                });
        log.info("users => {}", users);
    }

    /**
     * 反序列化Map
     */
    @Test
    public void testReadValueWithMap() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        Map<String, Object> map = objectMapper.readValue("{\"id\":1,\"mobiles\":[{\"id\":1,\"no\":\"12345678\"},{\"id\":2,\"no\":\"87654321\"}],\"birthDate\":\"2021-01-07 06:12:25\",\"hapyyDate\":1609999945969,\"money\":100.18999999999999772626324556767940521240234375,\"height\":1.8,\"ext\":{},\"userName\":\"张三\"}", new TypeReference<Map<String, Object>>() {
        });

        log.info("map => {}", map);
    }

    @Test
    public void testCustomSerializer() throws JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper();

        SimpleModule module = new SimpleModule("myModule");
        module.addSerializer(new CustomSerializer(User.class));
        objectMapper.registerModule(module);

        String json = objectMapper.writeValueAsString(user);

        log.info("result => {}", json);

    }

    @Test
    public void testUser2JacksonModule() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        User2JacksonModule user2JacksonModule = new User2JacksonModule();
        user2JacksonModule.registerModule(objectMapper);

        Employee employee = new Employee();
        employee.setName("张三");
        employee.setAge(50);
        employee.setDesignation("总裁");
        employee.setSalary(10000000000d);
        employee.setAddress(Arrays.asList(
                new Address("北京", "北京", "", "xx小区2栋2001")
        ));

        String result = objectMapper.writeValueAsString(employee);
        log.info("result => {}", result);
    }


}
