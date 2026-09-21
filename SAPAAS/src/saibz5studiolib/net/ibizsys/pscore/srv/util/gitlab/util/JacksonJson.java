/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.annotation.JsonInclude$Include
 *  com.fasterxml.jackson.core.JsonGenerationException
 *  com.fasterxml.jackson.core.JsonGenerator
 *  com.fasterxml.jackson.core.JsonParseException
 *  com.fasterxml.jackson.core.JsonParser
 *  com.fasterxml.jackson.core.JsonProcessingException
 *  com.fasterxml.jackson.core.TreeNode
 *  com.fasterxml.jackson.databind.DeserializationContext
 *  com.fasterxml.jackson.databind.DeserializationFeature
 *  com.fasterxml.jackson.databind.JsonDeserializer
 *  com.fasterxml.jackson.databind.JsonMappingException
 *  com.fasterxml.jackson.databind.JsonNode
 *  com.fasterxml.jackson.databind.JsonSerializer
 *  com.fasterxml.jackson.databind.Module
 *  com.fasterxml.jackson.databind.ObjectMapper
 *  com.fasterxml.jackson.databind.ObjectWriter
 *  com.fasterxml.jackson.databind.PropertyNamingStrategy
 *  com.fasterxml.jackson.databind.SerializationFeature
 *  com.fasterxml.jackson.databind.SerializerProvider
 *  com.fasterxml.jackson.databind.module.SimpleModule
 */
package net.ibizsys.pscore.srv.util.gitlab.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.module.SimpleModule;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import net.ibizsys.pscore.srv.util.gitlab.model.User;
import net.ibizsys.pscore.srv.util.gitlab.util.ISO8601;

public class JacksonJson {
    private final ObjectMapper objectMapper = new ObjectMapper();
    private static final SimpleDateFormat iso8601UtcFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss 'UTC'");

    public JacksonJson() {
        this.objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        this.objectMapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
        this.objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        this.objectMapper.configure(SerializationFeature.WRITE_ENUMS_USING_TO_STRING, true);
        this.objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        this.objectMapper.configure(DeserializationFeature.READ_ENUMS_USING_TO_STRING, true);
        SimpleModule simpleModule = new SimpleModule("GitLabApiJsonModule");
        simpleModule.addSerializer(Date.class, (JsonSerializer)new JsonDateSerializer());
        simpleModule.addDeserializer(Date.class, (JsonDeserializer)new JsonDateDeserializer());
        this.objectMapper.registerModule((Module)simpleModule);
    }

    public static <T> String toJsonString(T t) {
        return JacksonJsonSingletonHelper.JACKSON_JSON.marshal(t);
    }

    public <T> String marshal(T t) {
        if (t == null) {
            throw new IllegalArgumentException("object parameter is null");
        }
        ObjectWriter objectWriter = this.objectMapper.writer().withDefaultPrettyPrinter();
        String string = null;
        try {
            string = objectWriter.writeValueAsString(t);
        }
        catch (JsonGenerationException jsonGenerationException) {
            System.err.println("JsonGenerationException, message=" + jsonGenerationException.getMessage());
        }
        catch (JsonMappingException jsonMappingException) {
            jsonMappingException.printStackTrace();
            System.err.println("JsonMappingException, message=" + jsonMappingException.getMessage());
        }
        catch (IOException iOException) {
            System.err.println("IOException, message=" + iOException.getMessage());
        }
        return string;
    }

    public ObjectMapper getObjectMapper() {
        return this.objectMapper;
    }

    public ObjectMapper getContext(Class<?> clazz) {
        return this.objectMapper;
    }

    public <T> T unmarshal(Class<T> clazz, String string) throws JsonParseException, JsonMappingException, IOException {
        ObjectMapper objectMapper = this.getContext(clazz);
        return (T)objectMapper.readValue(string, clazz);
    }

    static {
        iso8601UtcFormat.setLenient(true);
        iso8601UtcFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
    }

    public static class JsonDateDeserializer
    extends JsonDeserializer<Date> {
        public Date deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            try {
                return ISO8601.toDate(jsonParser.getText());
            }
            catch (Exception exception) {
                throw new RuntimeException(exception);
            }
        }
    }

    public static class JsonDateSerializer
    extends JsonSerializer<Date> {
        public void serialize(Date date, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
            String string = ISO8601.toString(date);
            jsonGenerator.writeString(string);
        }
    }

    public static class UserListDeserializer
    extends JsonDeserializer<List<User>> {
        private static final ObjectMapper mapper = new JacksonJson().getObjectMapper();

        public List<User> deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            JsonNode jsonNode = (JsonNode)jsonParser.readValueAsTree();
            int n = jsonNode.size();
            ArrayList<User> arrayList = new ArrayList<User>(n);
            for (int i = 0; i < n; ++i) {
                JsonNode jsonNode2 = jsonNode.get(i);
                JsonNode jsonNode3 = jsonNode2.get("user");
                User user = (User)mapper.treeToValue((TreeNode)jsonNode3, User.class);
                arrayList.add(user);
            }
            return arrayList;
        }
    }

    public static class UserListSerializer
    extends JsonSerializer<List<User>> {
        public void serialize(List<User> list, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
            jsonGenerator.writeStartArray();
            for (User user : list) {
                jsonGenerator.writeStartObject();
                jsonGenerator.writeObjectField("user", (Object)user);
                jsonGenerator.writeEndObject();
            }
            jsonGenerator.writeEndArray();
        }
    }

    private static class JacksonJsonSingletonHelper {
        private static final JacksonJson JACKSON_JSON = new JacksonJson();

        private JacksonJsonSingletonHelper() {
        }

        static {
            JACKSON_JSON.objectMapper.setPropertyNamingStrategy(PropertyNamingStrategy.LOWER_CAMEL_CASE);
            JACKSON_JSON.objectMapper.setSerializationInclusion(JsonInclude.Include.ALWAYS);
        }
    }
}

