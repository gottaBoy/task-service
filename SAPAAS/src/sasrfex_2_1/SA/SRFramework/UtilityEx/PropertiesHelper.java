/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.UtilityEx;

import SA.SRFramework.Utility.StringHelper;
import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

public class PropertiesHelper {
    public static Properties Load(String strProperty) throws Exception {
        return PropertiesHelper.Load(null, strProperty);
    }

    public static Properties Load(Properties properties, String strProperty) throws Exception {
        if (properties == null) {
            properties = new Properties();
        }
        ByteArrayInputStream inputStream = new ByteArrayInputStream(strProperty.getBytes("utf8"));
        properties.load(inputStream);
        return properties;
    }

    public static boolean GetProperty(Properties properties, String strName, boolean bDefault) {
        String strValue = PropertiesHelper.GetProperty(properties, strName, null);
        if (strValue == null) {
            return bDefault;
        }
        try {
            return Boolean.parseBoolean(strValue);
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return bDefault;
        }
    }

    public static int GetProperty(Properties properties, String strName, int nDefault) {
        String strValue = PropertiesHelper.GetProperty(properties, strName, null);
        if (strValue == null) {
            return nDefault;
        }
        try {
            return Integer.parseInt(strValue);
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return nDefault;
        }
    }

    public static float GetProperty(Properties properties, String strName, float fDefault) {
        String strValue = PropertiesHelper.GetProperty(properties, strName, null);
        if (strValue == null) {
            return fDefault;
        }
        try {
            return Float.parseFloat(strValue);
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return fDefault;
        }
    }

    public static double GetProperty(Properties properties, String strName, double fDefault) {
        String strValue = PropertiesHelper.GetProperty(properties, strName, null);
        if (strValue == null) {
            return fDefault;
        }
        try {
            return Double.parseDouble(strValue);
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return fDefault;
        }
    }

    public static String GetProperty(Properties properties, String strName, String strDefault) {
        if (properties == null) {
            return strDefault;
        }
        String strValue = properties.getProperty(strName, strDefault);
        if (strValue == null) {
            return strValue;
        }
        if (StringHelper.Compare((String)strValue, (String)strDefault, (boolean)true) == 0) {
            return strDefault;
        }
        try {
            return new String(strValue.getBytes("ISO-8859-1"), "utf8");
        }
        catch (UnsupportedEncodingException e) {
            return strDefault;
        }
    }

    public static String GetProperty(Properties properties, String strName) {
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
            return null;
        }
    }
}

