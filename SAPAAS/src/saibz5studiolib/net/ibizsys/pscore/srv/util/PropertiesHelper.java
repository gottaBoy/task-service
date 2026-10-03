/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.ObjectMapper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.yaml.snakeyaml.Yaml
 */
package net.ibizsys.pscore.srv.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.ByteArrayInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Map;
import java.util.Properties;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.util.PropertiesEx;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.yaml.snakeyaml.Yaml;

public class PropertiesHelper {
    private static final Log log = LogFactory.getLog(PropertiesHelper.class);

    public static Properties load(String string) throws Exception {
        return PropertiesHelper.load(null, string);
    }

    public static Properties loadFromFile(String string) throws Exception {
        return PropertiesHelper.loadFromFile(null, string);
    }

    public static Properties load(Properties properties, String string) throws Exception {
        if (properties == null) {
            properties = new Properties();
        }
        if (!StringHelper.isNullOrEmpty((String)string)) {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(string.getBytes("utf8"));
            properties.load(byteArrayInputStream);
        }
        return properties;
    }

    public static Properties loadEx(String string) throws Exception {
        Properties properties = new Properties();
        if (!StringHelper.isNullOrEmpty((String)string)) {
            Object object;
            Map map = null;
            if (string.indexOf("{") == 0) {
                map = (Map)new ObjectMapper().convertValue((Object)string, Map.class);
            } else if (string.indexOf(":") != -1) {
                try {
                    object = new Yaml();
                    map = (Map)((Yaml)object).loadAs(string, Map.class);
                }
                catch (Exception exception) {
                    log.error((Object)exception);
                }
            }
            if (map != null) {
                object = new PropertiesEx();
                ((PropertiesEx)object).load(map);
                return (Properties)object;
            }
            object = new ByteArrayInputStream(string.getBytes("utf8"));
            properties.load((InputStream)object);
        }
        return properties;
    }

    public static Properties loadFromFile(Properties properties, String string) throws Exception {
        if (properties == null) {
            properties = new Properties();
        }
        if (!StringHelper.isNullOrEmpty((String)string)) {
            properties.load(new FileReader(string));
        }
        return properties;
    }

    public static boolean getProperty(Properties properties, String string, boolean bl) {
        String string2 = PropertiesHelper.getProperty(properties, string, null);
        if (StringHelper.isNullOrEmpty((String)string2)) {
            return bl;
        }
        try {
            return Boolean.parseBoolean(string2);
        }
        catch (Exception exception) {
            log.error((Object)exception);
            return bl;
        }
    }

    public static int getProperty(Properties properties, String string, int n) {
        String string2 = PropertiesHelper.getProperty(properties, string, null);
        if (StringHelper.isNullOrEmpty((String)string2)) {
            return n;
        }
        try {
            return Integer.parseInt(string2);
        }
        catch (Exception exception) {
            log.error((Object)exception);
            return n;
        }
    }

    public static long getProperty(Properties properties, String string, long l) {
        String string2 = PropertiesHelper.getProperty(properties, string, null);
        if (StringHelper.isNullOrEmpty((String)string2)) {
            return l;
        }
        try {
            return Long.parseLong(string2);
        }
        catch (Exception exception) {
            log.error((Object)exception);
            return l;
        }
    }

    public static float getProperty(Properties properties, String string, float f) {
        String string2 = PropertiesHelper.getProperty(properties, string, null);
        if (StringHelper.isNullOrEmpty((String)string2)) {
            return f;
        }
        try {
            return Float.parseFloat(string2);
        }
        catch (Exception exception) {
            log.error((Object)exception);
            return f;
        }
    }

    public static double getProperty(Properties properties, String string, double d) {
        String string2 = PropertiesHelper.getProperty(properties, string, null);
        if (StringHelper.isNullOrEmpty((String)string2)) {
            return d;
        }
        try {
            return Double.parseDouble(string2);
        }
        catch (Exception exception) {
            log.error((Object)exception);
            return d;
        }
    }

    public static String getProperty(Properties properties, String string, String string2) {
        if (properties == null || string == null) {
            return string2;
        }
        String string3 = properties.getProperty(string);
        if (string3 == null) {
            for (Object object : properties.keySet()) {
                if (!(object instanceof String) || !string.equalsIgnoreCase((String)object)) continue;
                string3 = properties.getProperty((String)object);
                break;
            }
            if (string3 == null) {
                string3 = string2;
            }
        }
        if (string3 == null) {
            return string3;
        }
        if (StringHelper.compare((String)string3, (String)string2, (boolean)false) == 0) {
            return string2;
        }
        try {
            if (properties instanceof PropertiesEx) {
                return string3;
            }
            return new String(string3.getBytes("ISO-8859-1"), "utf8");
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            log.error((Object)unsupportedEncodingException);
            return string2;
        }
    }

    public static String getProperty(Properties properties, String string) {
        if (properties == null || string == null) {
            return null;
        }
        try {
            String string2 = properties.getProperty(string);
            if (string2 == null) {
                for (Object object : properties.keySet()) {
                    if (!(object instanceof String) || !string.equalsIgnoreCase((String)object)) continue;
                    string2 = properties.getProperty((String)object);
                    break;
                }
            }
            if (string2 == null) {
                if (properties instanceof PropertiesEx) {
                    string2 = properties.getProperty(string);
                } else {
                    string = new String(string.getBytes("utf8"), "ISO-8859-1");
                    string2 = properties.getProperty(string);
                }
            }
            if (string2 == null) {
                return string2;
            }
            if (properties instanceof PropertiesEx) {
                return string2;
            }
            return new String(string2.getBytes("ISO-8859-1"), "utf8");
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            log.error((Object)unsupportedEncodingException);
            return null;
        }
    }
}
