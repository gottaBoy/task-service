/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.FilterConfig
 */
package SA.SRFramework.Web;

import java.util.Enumeration;
import java.util.Hashtable;
import javax.servlet.FilterConfig;

public class WebConfig {
    protected static String EXCELEXPORTER = "EXCELEXPORTER";
    protected Hashtable extAttrList = new Hashtable();

    public WebConfig(FilterConfig config) {
        Enumeration enumeration = config.getInitParameterNames();
        while (enumeration.hasMoreElements()) {
            String strName = (String)enumeration.nextElement();
            String strValue = config.getInitParameter(strName);
            if (strValue == null) continue;
            this.extAttrList.put(strName.toUpperCase(), strValue);
        }
    }

    public String GetExtValue(String strKey, String strDefault) {
        if (this.extAttrList.containsKey(strKey = strKey.toUpperCase())) {
            return (String)this.extAttrList.get(strKey);
        }
        return strDefault;
    }

    public int GetExtValue(String strKey, int nDefault) {
        try {
            return Integer.parseInt(this.GetExtValue(strKey, Integer.valueOf(nDefault).toString()));
        }
        catch (Exception ex) {
            return nDefault;
        }
    }

    public long GetExtValue(String strKey, Long nDefault) {
        try {
            return Long.parseLong(this.GetExtValue(strKey, nDefault.toString()));
        }
        catch (Exception ex) {
            return nDefault;
        }
    }

    public boolean GetExtValue(String strKey, boolean bDefault) {
        try {
            return Boolean.parseBoolean(this.GetExtValue(strKey, bDefault ? "True" : "False"));
        }
        catch (Exception ex) {
            return bDefault;
        }
    }

    public boolean GetValue(String strValue, boolean bDefault) {
        try {
            return Boolean.parseBoolean(strValue);
        }
        catch (Exception ex) {
            return bDefault;
        }
    }

    public double GetValue(String strValue, Double fDefault) {
        try {
            return Double.parseDouble(strValue);
        }
        catch (Exception ex) {
            return fDefault;
        }
    }

    public int GetValue(String strValue, int nDefault) {
        try {
            return Integer.parseInt(strValue);
        }
        catch (Exception ex) {
            return nDefault;
        }
    }

    public void SetValue(String strName, String strValue) {
        if (strValue != null) {
            this.extAttrList.put(strName.toUpperCase(), strValue);
        }
    }

    public String getExcelExporter() {
        return this.GetExtValue(EXCELEXPORTER, "");
    }
}

