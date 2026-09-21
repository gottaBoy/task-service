/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.JsonNode
 *  com.fasterxml.jackson.databind.ObjectMapper
 *  com.fasterxml.jackson.databind.node.ArrayNode
 *  com.fasterxml.jackson.databind.node.ObjectNode
 */
package net.ibizsys.pscore.srv.util;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.List;
import java.util.Map;

public class JsonUtils {
    public static ObjectMapper MAPPER = new ObjectMapper();

    public static ObjectMapper getMapper() {
        return MAPPER;
    }

    public static void setMapper(ObjectMapper objectMapper) {
        MAPPER = objectMapper != null ? objectMapper : new ObjectMapper();
    }

    public static ObjectNode createObjectNode() {
        return JsonUtils.getMapper().createObjectNode();
    }

    public static ArrayNode createArrayNode() {
        return JsonUtils.getMapper().createArrayNode();
    }

    public static String toString(Object object) {
        try {
            return JsonUtils.getMapper().writeValueAsString(object);
        }
        catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

    public static JsonNode toJsonNode(Object object) {
        try {
            if (object instanceof String) {
                return JsonUtils.getMapper().readTree((String)object);
            }
            return (JsonNode)JsonUtils.getMapper().convertValue(object, JsonNode.class);
        }
        catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

    public static ArrayNode toArrayNode(Object object) {
        try {
            if (object instanceof String) {
                return (ArrayNode)JsonUtils.getMapper().readTree((String)object);
            }
            return (ArrayNode)JsonUtils.getMapper().convertValue(object, ArrayNode.class);
        }
        catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

    public static ObjectNode toObjectNode(Object object) {
        try {
            if (object instanceof String) {
                return (ObjectNode)JsonUtils.getMapper().readTree((String)object);
            }
            return (ObjectNode)JsonUtils.getMapper().convertValue(object, ObjectNode.class);
        }
        catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

    public static Map asMap(Object object) {
        return JsonUtils.as(object, Map.class);
    }

    public static List asList(Object object) {
        return JsonUtils.as(object, List.class);
    }

    public static <T> T as(Object object, Class<T> clazz) {
        try {
            if (object instanceof String) {
                return (T)JsonUtils.getMapper().readValue((String)object, clazz);
            }
            return (T)JsonUtils.getMapper().convertValue(object, clazz);
        }
        catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

    public static String getField(ObjectNode objectNode, String string, String string2) {
        if (objectNode == null) {
            return string2;
        }
        JsonNode jsonNode = objectNode.get(string);
        if (jsonNode == null) {
            return string2;
        }
        return jsonNode.asText(string2);
    }

    public static long getField(ObjectNode objectNode, String string, long l) {
        if (objectNode == null) {
            return l;
        }
        JsonNode jsonNode = objectNode.get(string);
        if (jsonNode == null) {
            return l;
        }
        return jsonNode.asLong(l);
    }

    public static double getField(ObjectNode objectNode, String string, double d) {
        if (objectNode == null) {
            return d;
        }
        JsonNode jsonNode = objectNode.get(string);
        if (jsonNode == null) {
            return d;
        }
        return jsonNode.asDouble(d);
    }

    public static int getField(ObjectNode objectNode, String string, int n) {
        if (objectNode == null) {
            return n;
        }
        JsonNode jsonNode = objectNode.get(string);
        if (jsonNode == null) {
            return n;
        }
        return jsonNode.asInt(n);
    }
}

