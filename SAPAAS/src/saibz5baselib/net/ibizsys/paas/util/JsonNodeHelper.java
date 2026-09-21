/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.JsonNode
 *  com.fasterxml.jackson.databind.ObjectMapper
 *  com.fasterxml.jackson.databind.node.ArrayNode
 *  com.fasterxml.jackson.databind.node.ObjectNode
 */
package net.ibizsys.paas.util;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import net.ibizsys.paas.util.StringHelper;

public class JsonNodeHelper {
    public static void put(ObjectNode jsonObject, String strPropertyName, Object objValue) throws Exception {
        JsonNodeHelper.put(jsonObject, strPropertyName, objValue, true);
    }

    public static void put(ObjectNode jsonObject, String strPropertyName, Object objValue, boolean bRemoveIfExists) throws Exception {
        if (jsonObject.has(strPropertyName)) {
            if (bRemoveIfExists) {
                jsonObject.remove(strPropertyName);
            } else {
                return;
            }
        }
        if (objValue == null) {
            jsonObject.putNull(strPropertyName);
            return;
        }
        if (objValue instanceof JsonNode) {
            jsonObject.put(strPropertyName, (JsonNode)objValue);
            return;
        }
        if (objValue instanceof String) {
            jsonObject.put(strPropertyName, (String)objValue);
            return;
        }
        if (objValue instanceof Character) {
            jsonObject.put(strPropertyName, (int)((Character)objValue).charValue());
            return;
        }
        if (objValue instanceof BigInteger) {
            jsonObject.put(strPropertyName, ((BigInteger)objValue).longValue());
            return;
        }
        if (objValue instanceof Long) {
            jsonObject.put(strPropertyName, (Long)objValue);
            return;
        }
        if (objValue instanceof Integer) {
            jsonObject.put(strPropertyName, (Integer)objValue);
            return;
        }
        if (objValue instanceof Float) {
            jsonObject.put(strPropertyName, (Float)objValue);
            return;
        }
        if (objValue instanceof Double) {
            jsonObject.put(strPropertyName, (Double)objValue);
            return;
        }
        if (objValue instanceof Boolean) {
            jsonObject.put(strPropertyName, (Boolean)objValue);
            return;
        }
        if (objValue instanceof BigDecimal) {
            jsonObject.put(strPropertyName, ((BigDecimal)objValue).doubleValue());
            return;
        }
        if (objValue instanceof List) {
            ArrayNode arrayNode = jsonObject.putArray(strPropertyName);
            for (Object obj : (List)objValue) {
                JsonNodeHelper.add(arrayNode, obj);
            }
            return;
        }
        throw new Exception(StringHelper.format("\u4e0d\u652f\u6301\u7684\u5bf9\u8c61\u7c7b\u578b[%1$s]", objValue.getClass().getCanonicalName()));
    }

    public static void add(ArrayNode arrayNode, Object objValue) throws Exception {
        if (objValue == null) {
            arrayNode.addNull();
            return;
        }
        if (objValue instanceof JsonNode) {
            arrayNode.add((JsonNode)objValue);
            return;
        }
        if (objValue instanceof String) {
            arrayNode.add((String)objValue);
            return;
        }
        if (objValue instanceof Character) {
            arrayNode.add((int)((Character)objValue).charValue());
            return;
        }
        if (objValue instanceof BigInteger) {
            arrayNode.add((Long)objValue);
            return;
        }
        if (objValue instanceof BigInteger) {
            arrayNode.add(((BigInteger)objValue).longValue());
            return;
        }
        if (objValue instanceof Long) {
            arrayNode.add((Long)objValue);
            return;
        }
        if (objValue instanceof Integer) {
            arrayNode.add((Integer)objValue);
            return;
        }
        if (objValue instanceof Float) {
            arrayNode.add((Float)objValue);
            return;
        }
        if (objValue instanceof Double) {
            arrayNode.add((Double)objValue);
            return;
        }
        if (objValue instanceof BigDecimal) {
            arrayNode.add(((BigDecimal)objValue).doubleValue());
            return;
        }
        throw new Exception(StringHelper.format("\u4e0d\u652f\u6301\u7684\u5bf9\u8c61\u7c7b\u578b[%1$s]", objValue.getClass().getCanonicalName()));
    }

    public static void remove(ObjectNode jsonObject, String strPropertyName) throws Exception {
        if (jsonObject.has(strPropertyName)) {
            jsonObject.remove(strPropertyName);
        }
    }

    public static ObjectNode createObjectNode() {
        ObjectMapper objMapper = new ObjectMapper();
        return objMapper.createObjectNode();
    }

    public static JsonNode fromString(String strJsonString) throws Exception {
        JsonNode editorNode = new ObjectMapper().readTree(strJsonString);
        return editorNode;
    }

    public static String getString(ObjectNode jsonObject, String strPropertyName, String strDefault) throws Exception {
        JsonNode valueNode = jsonObject.get(strPropertyName);
        if (valueNode == null) {
            return strDefault;
        }
        return valueNode.asText();
    }

    public static boolean getBoolean(ObjectNode jsonObject, String strPropertyName, boolean bDefault) throws Exception {
        JsonNode valueNode = jsonObject.get(strPropertyName);
        if (valueNode == null) {
            return bDefault;
        }
        return valueNode.asBoolean();
    }

    public static int getInt(ObjectNode jsonObject, String strPropertyName, int nDefault) throws Exception {
        JsonNode valueNode = jsonObject.get(strPropertyName);
        if (valueNode == null) {
            return nDefault;
        }
        return valueNode.asInt();
    }

    public static long getLong(ObjectNode jsonObject, String strPropertyName, long nDefault) throws Exception {
        JsonNode valueNode = jsonObject.get(strPropertyName);
        if (valueNode == null) {
            return nDefault;
        }
        return valueNode.asLong();
    }

    public static double getDouble(ObjectNode jsonObject, String strPropertyName, double fDefault) throws Exception {
        JsonNode valueNode = jsonObject.get(strPropertyName);
        if (valueNode == null) {
            return fDefault;
        }
        return valueNode.asDouble();
    }

    public static ArrayNode getArray(ObjectNode jsonObject, String strPropertyName) throws Exception {
        JsonNode valueNode = jsonObject.get(strPropertyName);
        if (valueNode == null) {
            return null;
        }
        if (!(valueNode instanceof ArrayNode)) {
            throw new Exception(StringHelper.format("\u65e0\u6cd5\u8bb2\u503c[%1$s]\u8f6c\u6362\u4e3a\u8282Json\u6570\u7ec4", valueNode.getClass().getCanonicalName()));
        }
        return (ArrayNode)valueNode;
    }

    public static ObjectNode getObject(ObjectNode jsonObject, String strPropertyName) throws Exception {
        JsonNode valueNode = jsonObject.get(strPropertyName);
        if (valueNode == null) {
            return null;
        }
        if (!(valueNode instanceof ObjectNode)) {
            throw new Exception(StringHelper.format("\u65e0\u6cd5\u8bb2\u503c[%1$s]\u8f6c\u6362\u4e3a\u8282Json\u5bf9\u8c61", valueNode.getClass().getCanonicalName()));
        }
        return (ObjectNode)valueNode;
    }

    public static ObjectNode copy(ObjectNode dstObjectNode, ObjectNode srcObjectNode, boolean bIgnoreExits) throws Exception {
        return JsonNodeHelper.copy(dstObjectNode, srcObjectNode, bIgnoreExits, null);
    }

    public static ObjectNode copy(ObjectNode dstObjectNode, ObjectNode srcObjectNode, boolean bIgnoreExits, String[] ignoreFields) throws Exception {
        if (dstObjectNode == null) {
            dstObjectNode = JsonNodeHelper.createObjectNode();
        }
        HashMap<String, String> ignoreFieldMap = null;
        if (ignoreFields != null && ignoreFields.length > 0) {
            ignoreFieldMap = new HashMap<String, String>();
            String[] stringArray = ignoreFields;
            int n = ignoreFields.length;
            int n2 = 0;
            while (n2 < n) {
                String strField = stringArray[n2];
                ignoreFieldMap.put(strField, "");
                ++n2;
            }
        }
        ObjectNode cloneObjectNode = srcObjectNode.deepCopy();
        Iterator fieldNames = srcObjectNode.fieldNames();
        if (fieldNames != null) {
            while (fieldNames.hasNext()) {
                String strFieldName = (String)fieldNames.next();
                if (ignoreFieldMap != null && ignoreFieldMap.containsKey(strFieldName) || bIgnoreExits && dstObjectNode.has(strFieldName)) continue;
                dstObjectNode.put(strFieldName, cloneObjectNode.get(strFieldName));
            }
        }
        return srcObjectNode;
    }
}

