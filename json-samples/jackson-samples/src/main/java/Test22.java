import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.JsonNodeType;

import java.util.Iterator;
import java.util.Map;

public class Test22 {

    public static void main(String[] args) throws JsonProcessingException {
        String json = "{\n" +
                "  \"aaa\": \"ttt\",\n" +
                "  \"bbb\": \"xx\", \n" +
                "  \"ccc\": {\n" +
                "      \"c1\": \"ttt\"\n" +
                "  },\n" +
                "  \"ddd\": [\"xxx\"],\n" +
                "  \"eee\": [{\n" +
                "        \"e1\": \"eeee\"\n" +
                "  }]\n" +
                "}";


        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(json);

        Iterator<String> keys = jsonNode.fieldNames();
        while (keys.hasNext()) {
            String key = keys.next();
            JsonNode valueNode = jsonNode.findValue(key);

            if (valueNode.getNodeType() == JsonNodeType.ARRAY) {

            }

        }


    }
}
