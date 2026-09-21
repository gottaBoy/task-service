/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFramework.Utility;

import SA.SRFramework.Utility.StringHelper;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.TreeMap;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ReflectHelper {
    private static Log log = LogFactory.getLog(ReflectHelper.class);

    public static void FillSetPropertyMethod(TreeMap<String, Method> propertySetMethodMap, Class cls) {
        int nCount = cls.getMethods().length;
        int i = 0;
        while (i < nCount) {
            Method method = cls.getMethods()[i];
            if (propertySetMethodMap.containsKey(method.getName().toUpperCase())) {
                propertySetMethodMap.put(method.getName().toUpperCase(), method);
            }
            ++i;
        }
        for (String strKey : propertySetMethodMap.keySet()) {
            if (propertySetMethodMap.get(strKey) != null) continue;
            log.warn((Object)StringHelper.Format("\u5bf9\u8c61[%1$s]\u6ca1\u6709\u5c5e\u6027[%2$s]\u503c\u8bbe\u7f6e\u65b9\u6cd5", cls.getName(), strKey.substring(3)));
        }
    }

    public static void SetProperty(Object obj, Method method, String strValue) {
        if (method.getParameterTypes().length == 0) {
            return;
        }
        Object objValue = null;
        if (method.getParameterTypes()[0] == String.class) {
            objValue = strValue;
        } else if (method.getParameterTypes()[0] == Boolean.TYPE || method.getParameterTypes()[0] == Boolean.class) {
            if (StringHelper.IsNullOrEmpty(strValue)) {
                return;
            }
            objValue = Boolean.parseBoolean(strValue);
        } else {
            if (method.getParameterTypes()[0] == Integer.TYPE || method.getParameterTypes()[0] == Integer.class) {
                if (StringHelper.IsNullOrEmpty(strValue)) {
                    return;
                }
                try {
                    objValue = Integer.parseInt(strValue);
                }
                catch (Exception ex) {
                    ex.printStackTrace();
                    return;
                }
            }
            if (method.getParameterTypes()[0] == Double.TYPE || method.getParameterTypes()[0] == Double.class) {
                if (StringHelper.IsNullOrEmpty(strValue)) {
                    return;
                }
                try {
                    objValue = Double.parseDouble(strValue);
                }
                catch (Exception ex) {
                    ex.printStackTrace();
                    return;
                }
            }
            if (method.getParameterTypes()[0] == Float.TYPE || method.getParameterTypes()[0] == Float.class) {
                if (StringHelper.IsNullOrEmpty(strValue)) {
                    return;
                }
                try {
                    objValue = Float.valueOf(Float.parseFloat(strValue));
                }
                catch (Exception ex) {
                    ex.printStackTrace();
                    return;
                }
            }
        }
        try {
            method.invoke(obj, objValue);
            return;
        }
        catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}

