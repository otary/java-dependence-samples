package cn.chenzw.dependence.jackson.samples.module;

import cn.chenzw.dependence.jackson.samples.domain.entity.User;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;

public class CustomSerializer extends StdSerializer<User> {

    public CustomSerializer(Class<User> clazz) {
        super(clazz);
    }

    @Override
    public void serialize(User user, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {

    }
}
