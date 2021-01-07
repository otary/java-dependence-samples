package cn.chenzw.dependence.gson.adapter;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

/**
 * null转字符串""
 *
 * @author chenzw
 */
public class StringNullAdapter extends TypeAdapter<String> {


    @Override
    public void write(JsonWriter jsonWriter, String value) throws IOException {
        if (value == null) {
            jsonWriter.value("");
            return;
        }
        jsonWriter.value(value);
    }

    @Override
    public String read(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
        }
        return jsonReader.nextString();
    }
}
