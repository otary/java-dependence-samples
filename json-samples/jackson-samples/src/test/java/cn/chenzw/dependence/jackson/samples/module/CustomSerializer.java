package cn.chenzw.dependence.jackson.samples.module;

import cn.chenzw.dependence.jackson.samples.domain.entity.User;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;

/**
 * 通常用于某种字段类型的序列化
 */
public class CustomSerializer extends StdSerializer<User> {

    public CustomSerializer(Class<User> clazz) {
        super(clazz);
    }

    @Override
    public void serialize(User user, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();

        jsonGenerator.writeNumberField("id", user.getId());
        jsonGenerator.writeStringField("name", user.getName());
        jsonGenerator.writeStringField("nickName", user.getNickName());

        jsonGenerator.writeEndObject();
    }
}
