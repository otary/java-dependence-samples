package cn.chenzw.dependence.jackson.samples;

import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@Slf4j
@RunWith(JUnit4.class)
public class JsonSerializerTests {

    private JsonSerializer jsonSerializer;

    @Test
    public void testJsonSerializer() {
       // jsonSerializer = new JsonSerializer(Arrays.asList(new Swagger2JacksonModule()));

    }


}
