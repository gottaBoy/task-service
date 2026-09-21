/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.FilterConfig
 */
package net.ibizsys.paas.web;

import java.util.Enumeration;
import java.util.HashMap;
import javax.servlet.FilterConfig;

public class WebConfig {
    private static WebConfig webConfig = null;
    protected HashMap<String, String> extAttrList = new HashMap();
    public static final String WEBCONTEXT = "WEBCONTEXT";
    public static final String TEMPPATH = "TEMPPATH";
    public static final String LOWCASESQL = "LOWCASESQL";
    public static final String FILEPATH = "FILEPATH";
    public static final String SERVICECONTAINER = "SERVICECONTAINER";
    public static final String DEFAULTOPERATOR = "DEFAULTOPERATOR";
    public static final String DEFAULTOPERATORNAME = "DEFAULTOPERATORNAME";
    public static final String DYNASYSINSTID = "DYNASYSINSTID";
    public static final String APPURL = "APPURL_";
    public static final String HTMLURL = "HTMLURL_";
    public static final String DEFAULTWEBAPPURL = "DEFAULTWEBAPPURL";
    public static final String DEFAULTMOBAPPURL = "DEFAULTMOBAPPURL";
    private String strWebContextObj = null;
    private String strFilePath = null;
    private String strTempPath = null;
    private String strServiceContainer = null;
    private String strDefaultOperator = null;
    private String strDefaultOperatorName = null;
    private String strDynaSysInstId = null;
    private String strDefaultWebAppUrl = null;
    private String strDefaultMobAppUrl = null;
    private boolean bLowCaseSql = false;

    public WebConfig(FilterConfig config) {
        if (config != null) {
            Enumeration enumeration = config.getInitParameterNames();
            while (enumeration.hasMoreElements()) {
                String strName = (String)enumeration.nextElement();
                String strValue = config.getInitParameter(strName);
                if (strValue == null) continue;
                this.extAttrList.put(strName.toUpperCase(), strValue);
            }
            this.strWebContextObj = this.extAttrList.get(WEBCONTEXT);
            this.strFilePath = this.extAttrList.get(FILEPATH);
            this.strTempPath = this.extAttrList.get(TEMPPATH);
            this.strServiceContainer = this.extAttrList.get(SERVICECONTAINER);
            this.strDefaultOperator = this.extAttrList.get(DEFAULTOPERATOR);
            this.strDefaultOperatorName = this.extAttrList.get(DEFAULTOPERATORNAME);
            this.strDynaSysInstId = this.extAttrList.get(DYNASYSINSTID);
            this.strDefaultWebAppUrl = this.extAttrList.get(DEFAULTWEBAPPURL);
            this.strDefaultMobAppUrl = this.extAttrList.get(DEFAULTMOBAPPURL);
            this.bLowCaseSql = this.getAttribute(LOWCASESQL, false);
        }
        webConfig = this;
    }

    public String getWebContextObj() {
        return this.strWebContextObj;
    }

    public String getAttribute(String strKey, String strDefault) {
        String strValue = this.extAttrList.get(strKey = strKey.toUpperCase());
        if (strValue == null) {
            return strDefault;
        }
        return strValue;
    }

    public int getAttribute(String strKey, int nDefault) {
        try {
            return Integer.parseInt(this.getAttribute(strKey, Integer.valueOf(nDefault).toString()));
        }
        catch (Exception ex) {
            return nDefault;
        }
    }

    public long getAttribute(String strKey, Long nDefault) {
        try {
            return Long.parseLong(this.getAttribute(strKey, nDefault.toString()));
        }
        catch (Exception ex) {
            return nDefault;
        }
    }

    public boolean getAttribute(String strKey, boolean bDefault) {
        try {
            return Boolean.parseBoolean(this.getAttribute(strKey, bDefault ? "True" : "False"));
        }
        catch (Exception ex) {
            return bDefault;
        }
    }

    protected static boolean getValue(String strValue, boolean bDefault) {
        try {
            return Boolean.parseBoolean(strValue);
        }
        catch (Exception ex) {
            return bDefault;
        }
    }

    protected static double getValue(String strValue, Double fDefault) {
        try {
            return Double.parseDouble(strValue);
        }
        catch (Exception ex) {
            return fDefault;
        }
    }

    protected static int getValue(String strValue, int nDefault) {
        try {
            return Integer.parseInt(strValue);
        }
        catch (Exception ex) {
            return nDefault;
        }
    }

    public void setAttribute(String strName, String strValue) {
        if (strValue != null) {
            this.extAttrList.put(strName.toUpperCase(), strValue);
        }
    }

    public static WebConfig getCurrent() {
        return webConfig;
    }

    public String getTempPath() {
        return this.strTempPath;
    }

    public String getFilePath() {
        return this.strFilePath;
    }

    public String getServiceContainer() {
        return this.strServiceContainer;
    }

    public String getDefaultOperator() {
        return this.strDefaultOperator;
    }

    public String getDefaultOperatorName() {
        return this.strDefaultOperatorName;
    }

    public String getDynaSysInstId() {
        return this.strDynaSysInstId;
    }

    public String getDefaultWebAppUrl() {
        return this.strDefaultWebAppUrl;
    }

    public String getDefaultMobAppUrl() {
        return this.strDefaultMobAppUrl;
    }

    public boolean isLowCaseSql() {
        return this.bLowCaseSql;
    }
}

