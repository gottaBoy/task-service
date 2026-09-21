/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx.Utility;

import SA.SRFramework.Utility.StringHelper;
import java.net.URLEncoder;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.TreeMap;

public class URLHelper {
    public static String AppendURLSeperator(String strURL) {
        if (!StringHelper.IsNullOrEmpty((String)strURL)) {
            int nPos = strURL.indexOf("?");
            if (nPos == -1) {
                strURL = String.valueOf(strURL) + "?";
            } else if (nPos != strURL.length() - 1 && strURL.lastIndexOf("&") != strURL.length() - 1) {
                strURL = String.valueOf(strURL) + "&";
            }
        }
        return strURL;
    }

    public static String EncodeURLParamValue(String strValue) {
        try {
            return URLEncoder.encode(strValue, "UTF-8");
        }
        catch (Exception ex) {
            return strValue;
        }
    }

    public static String GetQueryString(TreeMap<String, String> params) {
        String strURLCall = "";
        for (String strName : params.keySet()) {
            String strValue = params.get(strName);
            if (StringHelper.Length((String)strName) == 0 || StringHelper.Length((String)strValue) == 0) continue;
            if (strURLCall.length() > 0) {
                strURLCall = String.valueOf(strURLCall) + "&";
            }
            strURLCall = String.valueOf(strURLCall) + strName;
            strURLCall = String.valueOf(strURLCall) + "=";
            try {
                strURLCall = String.valueOf(strURLCall) + URLEncoder.encode(strValue, "UTF-8");
            }
            catch (Exception ex) {
                strURLCall = String.valueOf(strURLCall) + strValue;
            }
        }
        return strURLCall;
    }

    public static String GetQueryString(Hashtable<String, String> params) {
        String strURLCall = "";
        Enumeration<String> enumeration = params.keys();
        while (enumeration.hasMoreElements()) {
            String strValue;
            String strName = enumeration.nextElement();
            if (StringHelper.Length((String)strName) == 0 || StringHelper.Length((String)(strValue = params.get(strName))) == 0) continue;
            if (strURLCall.length() > 0) {
                strURLCall = String.valueOf(strURLCall) + "&";
            }
            strURLCall = String.valueOf(strURLCall) + strName;
            strURLCall = String.valueOf(strURLCall) + "=";
            try {
                strURLCall = String.valueOf(strURLCall) + URLEncoder.encode(strValue, "UTF-8");
            }
            catch (Exception ex) {
                strURLCall = String.valueOf(strURLCall) + strValue;
            }
        }
        return strURLCall;
    }
}

