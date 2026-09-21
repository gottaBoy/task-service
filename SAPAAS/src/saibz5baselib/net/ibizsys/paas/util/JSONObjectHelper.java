/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.sf.json.JSONArray
 *  net.sf.json.JSONObject
 */
package net.ibizsys.paas.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Iterator;
import net.ibizsys.paas.util.JSONStringEx;
import net.ibizsys.paas.util.StringHelper;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class JSONObjectHelper {
    public static JSONObject fromFile(File file) throws Exception {
        ByteBuffer inBuf = null;
        FileInputStream inFile = null;
        try {
            int nRet;
            inFile = new FileInputStream(file);
            inBuf = ByteBuffer.allocate((int)inFile.getChannel().size());
            ByteBuffer readBuf = ByteBuffer.allocate(8);
            FileChannel srcChannel = inFile.getChannel();
            while ((nRet = JSONObjectHelper.replenish(srcChannel, readBuf)) != -1) {
                inBuf.put(readBuf.array(), 0, nRet);
                readBuf.clear();
            }
            inFile.close();
        }
        catch (IOException ex) {
            try {
                if (inFile != null) {
                    inFile.close();
                }
            }
            catch (Exception exception) {
                // empty catch block
            }
            throw ex;
        }
        String strRet = new String(inBuf.array(), "UTF-8");
        return JSONObject.fromString((String)strRet);
    }

    private static int replenish(FileChannel channel, ByteBuffer buf) throws IOException {
        long byteLeft = channel.size() - channel.position();
        if (byteLeft == 0L) {
            return -1;
        }
        buf.position(0);
        buf.limit(buf.position() + (byteLeft < 8L ? (int)byteLeft : 8));
        return channel.read(buf);
    }

    public static void put(JSONObject jsonObject, String strPropertyName, Object objValue) throws Exception {
        JSONObjectHelper.put(jsonObject, strPropertyName, objValue, true);
    }

    public static void put(JSONObject jsonObject, String strPropertyName, Object objValue, boolean bRemoveIfExists) throws Exception {
        if (jsonObject.has(strPropertyName)) {
            if (bRemoveIfExists) {
                jsonObject.remove(strPropertyName);
            } else {
                return;
            }
        }
        if (objValue != null && objValue instanceof String) {
            objValue = JSONObjectHelper.stripQuotes((String)objValue);
        }
        jsonObject.put(strPropertyName, objValue);
    }

    public static void putRaw(JSONObject jsonObject, String strPropertyName, Object objValue) throws Exception {
        JSONObjectHelper.putRaw(jsonObject, strPropertyName, objValue, true);
    }

    public static void putRaw(JSONObject jsonObject, String strPropertyName, Object objValue, boolean bRemoveIfExists) throws Exception {
        if (jsonObject.has(strPropertyName)) {
            if (bRemoveIfExists) {
                jsonObject.remove(strPropertyName);
            } else {
                return;
            }
        }
        if (objValue != null && objValue instanceof String) {
            objValue = JSONObjectHelper.stripQuotes((String)objValue, true);
        }
        jsonObject.put(strPropertyName, objValue);
    }

    public static Object stripQuotes(Object objValue) {
        if (objValue != null && objValue instanceof String) {
            return JSONObjectHelper.stripQuotes((String)objValue);
        }
        return objValue;
    }

    public static Object stripQuotes(Object objValue, boolean bBracket) {
        if (objValue != null && objValue instanceof String) {
            return JSONObjectHelper.stripQuotes((String)objValue, bBracket);
        }
        return objValue;
    }

    public static Object stripQuotes(String strValue) {
        return JSONObjectHelper.stripQuotes(strValue, false);
    }

    public static Object stripQuotes(String strValue, boolean bBracket) {
        if (StringHelper.isNullOrEmpty(strValue)) {
            return strValue;
        }
        if (strValue.length() <= 1) {
            return strValue;
        }
        if (strValue.startsWith("'") && strValue.endsWith("'")) {
            return new JSONStringEx(strValue);
        }
        if (strValue.startsWith("\"") && strValue.endsWith("\"")) {
            return new JSONStringEx(strValue);
        }
        if (StringHelper.compare(strValue, "NULL", true) == 0) {
            return new JSONStringEx(strValue);
        }
        if (bBracket) {
            if (strValue.startsWith("{") && strValue.endsWith("}")) {
                return new JSONStringEx(strValue);
            }
            if (strValue.startsWith("[") && strValue.endsWith("]")) {
                return new JSONStringEx(strValue);
            }
        }
        return strValue;
    }

    public static void remove(JSONObject jsonObject, String strPropertyName) throws Exception {
        if (jsonObject.has(strPropertyName)) {
            jsonObject.remove(strPropertyName);
        }
    }

    public static void addToChildList(JSONObject jsonObject, String strPropertyName, Object objValue) throws Exception {
        JSONArray list = null;
        Object object = jsonObject.opt(strPropertyName);
        if (object != null) {
            if (!(object instanceof JSONArray)) {
                throw new Exception(StringHelper.format("\u5b50\u5c5e\u6027\u5df2\u7ecf\u5b58\u5728\uff0c\u4f46\u4e0d\u662f\u6570\u7ec4\u5bf9\u8c61"));
            }
            list = (JSONArray)object;
        } else {
            list = new JSONArray();
            jsonObject.put(strPropertyName, (Object)list);
        }
        int nIndex = list.length();
        list.put(nIndex, objValue);
        jsonObject.remove(strPropertyName);
        jsonObject.put(strPropertyName, (Object)list);
    }

    public static void copy(JSONObject srcJO, JSONObject dstJO) throws Exception {
        Iterator iterator = srcJO.keys();
        while (iterator.hasNext()) {
            String strKey = (String)iterator.next();
            JSONObjectHelper.put(dstJO, strKey, srcJO.get(strKey));
        }
    }

    public static void copyIf(JSONObject srcJO, JSONObject dstJO) throws Exception {
        Iterator iterator = srcJO.keys();
        while (iterator.hasNext()) {
            String strKey = (String)iterator.next();
            if (dstJO.has(strKey)) continue;
            JSONObjectHelper.put(dstJO, strKey, srcJO.get(strKey));
        }
    }

    public static JSONObject fromString(String strJSONString) {
        return JSONObject.fromString((String)strJSONString);
    }

    public static JSONObject fromString2(String strJSONString) throws Exception {
        try {
            return JSONObject.fromString((String)strJSONString);
        }
        catch (Exception ex) {
            throw new Exception(StringHelper.format("JSON\u683c\u5f0f\u4e0d\u6b63\u786e\uff1a%1$s", strJSONString));
        }
    }
}

