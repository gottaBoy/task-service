/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.paas.util;

import java.io.ByteArrayInputStream;
import java.io.FileReader;
import java.io.UnsupportedEncodingException;
import java.util.Properties;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PropertiesHelper {
    private static final Log log = LogFactory.getLog(PropertiesHelper.class);

    public static Properties load(String strProperty) throws Exception {
        return PropertiesHelper.load(null, strProperty);
    }

    public static Properties loadFromFile(String strFile) throws Exception {
        return PropertiesHelper.loadFromFile(null, strFile);
    }

    public static Properties load(Properties properties, String strProperty) throws Exception {
        if (properties == null) {
            properties = new Properties();
        }
        if (!StringHelper.isNullOrEmpty(strProperty)) {
            ByteArrayInputStream inputStream = new ByteArrayInputStream(strProperty.getBytes("utf8"));
            properties.load(inputStream);
        }
        return properties;
    }

    public static Properties loadFromFile(Properties properties, String strFilePath) throws Exception {
        if (properties == null) {
            properties = new Properties();
        }
        if (!StringHelper.isNullOrEmpty(strFilePath)) {
            properties.load(new FileReader(strFilePath));
        }
        return properties;
    }

    public static boolean getProperty(Properties properties, String strName, boolean bDefault) {
        String strValue = PropertiesHelper.getProperty(properties, strName, null);
        if (StringHelper.isNullOrEmpty(strValue)) {
            return bDefault;
        }
        try {
            return Boolean.parseBoolean(strValue);
        }
        catch (Exception ex) {
            log.error((Object)ex);
            return bDefault;
        }
    }

    public static int getProperty(Properties properties, String strName, int nDefault) {
        String strValue = PropertiesHelper.getProperty(properties, strName, null);
        if (StringHelper.isNullOrEmpty(strValue)) {
            return nDefault;
        }
        try {
            return Integer.parseInt(strValue);
        }
        catch (Exception ex) {
            log.error((Object)ex);
            return nDefault;
        }
    }

    public static long getProperty(Properties properties, String strName, long nDefault) {
        String strValue = PropertiesHelper.getProperty(properties, strName, null);
        if (StringHelper.isNullOrEmpty(strValue)) {
            return nDefault;
        }
        try {
            return Long.parseLong(strValue);
        }
        catch (Exception ex) {
            log.error((Object)ex);
            return nDefault;
        }
    }

    public static float getProperty(Properties properties, String strName, float fDefault) {
        String strValue = PropertiesHelper.getProperty(properties, strName, null);
        if (StringHelper.isNullOrEmpty(strValue)) {
            return fDefault;
        }
        try {
            return Float.parseFloat(strValue);
        }
        catch (Exception ex) {
            log.error((Object)ex);
            return fDefault;
        }
    }

    public static double getProperty(Properties properties, String strName, double fDefault) {
        String strValue = PropertiesHelper.getProperty(properties, strName, null);
        if (StringHelper.isNullOrEmpty(strValue)) {
            return fDefault;
        }
        try {
            return Double.parseDouble(strValue);
        }
        catch (Exception ex) {
            log.error((Object)ex);
            return fDefault;
        }
    }

    public static String getProperty(Properties properties, String strName, String strDefault) {
        if (properties == null) {
            return strDefault;
        }
        String strValue = properties.getProperty(strName, strDefault);
        if (strValue == null) {
            return strValue;
        }
        if (StringHelper.compare(strValue, strDefault, false) == 0) {
            return strDefault;
        }
        try {
            return new String(strValue.getBytes("ISO-8859-1"), "utf8");
        }
        catch (UnsupportedEncodingException e) {
            log.error((Object)e);
            return strDefault;
        }
    }

    public static String getProperty(Properties properties, String strName) {
        if (properties == null) {
            return null;
        }
        try {
            String strValue = properties.getProperty(strName);
            if (strValue == null) {
                strName = new String(strName.getBytes("utf8"), "ISO-8859-1");
                strValue = properties.getProperty(strName);
            }
            if (strValue == null) {
                return strValue;
            }
            return new String(strValue.getBytes("ISO-8859-1"), "utf8");
        }
        catch (UnsupportedEncodingException e) {
            log.error((Object)e);
            return null;
        }
    }
}

