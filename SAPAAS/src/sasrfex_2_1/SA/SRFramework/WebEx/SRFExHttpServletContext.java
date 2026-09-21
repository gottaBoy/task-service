/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.Web.WebConfig
 *  javax.servlet.ServletContext
 *  javax.servlet.http.HttpServletRequest
 *  javax.servlet.http.HttpServletResponse
 */
package SA.SRFramework.WebEx;

import SA.SRFramework.CodeList.CodeListMgr;
import SA.SRFramework.SecurityEx.Web.DefaultUserPrivilegeMgr;
import SA.SRFramework.SecurityEx.Web.IUserPrivilegeMgr;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.Web.WebConfig;
import SA.SRFramework.WebEx.ISRFExWebContext;
import SA.SRFramework.WebEx.SRFExAjaxActionResult;
import SA.SRFramework.WebEx.UI.GlobalConfigMgr;
import SA.SRFramework.WebEx.UI.WebExConfig;
import SA.SRFramework.WebEx.Utility.ContextHelper;
import SA.SRFramework.WebEx.Utility.URLHelper;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.TimeZone;
import java.util.TreeMap;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SRFExHttpServletContext
implements ISRFExWebContext {
    protected HttpServletRequest request = null;
    protected HttpServletResponse response = null;
    protected ServletContext servletContext = null;
    protected Hashtable<String, String> paramList = new Hashtable();
    private SRFExAjaxActionResult ajaxActionResult = null;
    protected Hashtable<String, String> cacheLocalizationMap = null;

    public SRFExHttpServletContext(HttpServletRequest arg0, HttpServletResponse arg1, ServletContext arg2) {
        if (arg0 instanceof HttpServletRequest) {
            this.request = arg0;
            this.ParseRequest(this.request.getQueryString());
        }
        if (arg1 instanceof HttpServletResponse) {
            this.response = arg1;
        }
        this.servletContext = arg2;
    }

    protected void ParseRequest(String strQueryString) {
        if (strQueryString == null) {
            return;
        }
        String[] strLists = strQueryString.split("&");
        int i = 0;
        while (i < strLists.length) {
            String[] set = strLists[i].split("=");
            if (set.length == 2) {
                try {
                    String strValue = URLDecoder.decode(set[1], "UTF-8");
                    if (StringHelper.Length((String)strValue) != 0) {
                        this.SetParamValue(set[0], strValue);
                    }
                }
                catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
            ++i;
        }
    }

    @Override
    public void SetParamValue(String strParamName, String strParamValue) {
        if (!StringHelper.IsNullOrEmpty((String)(strParamValue = strParamValue.trim()))) {
            this.paramList.put(strParamName.toUpperCase(), strParamValue);
        } else {
            this.RemoveParam(strParamName);
        }
    }

    @Override
    public void RemoveParam(String strParamName) {
        if (this.paramList.containsKey(strParamName.toUpperCase())) {
            this.paramList.remove(strParamName.toUpperCase());
        }
    }

    @Override
    public String GetParamValue(String strParamName) {
        if (this.paramList.containsKey(strParamName.toUpperCase())) {
            return this.paramList.get(strParamName.toUpperCase()).toString();
        }
        return "";
    }

    @Override
    public Object GetSessionValue(String strKey) {
        return this.request.getSession().getAttribute(strKey);
    }

    @Override
    public void SetSessionValue(String strKey, Object objValue) {
        if (objValue == null) {
            this.request.getSession().removeAttribute(strKey);
        } else {
            this.request.getSession().setAttribute(strKey, objValue);
        }
    }

    @Override
    public String getCurUserId() {
        Object objValue = this.GetSessionValue("PERSONID");
        if (objValue == null) {
            return "";
        }
        return objValue.toString();
    }

    @Override
    public String getCurUserName() {
        Object objValue = this.GetSessionValue("PERSONNAME");
        if (objValue == null) {
            return "";
        }
        return objValue.toString();
    }

    @Override
    public Object GetGlobalValue(String strKey) {
        return this.getServletContext().getAttribute(strKey);
    }

    @Override
    public void SetGlobalValue(String strKey, Object objValue) {
        if (objValue == null) {
            this.getServletContext().removeAttribute(strKey);
        } else {
            this.getServletContext().setAttribute(strKey, objValue);
        }
    }

    public String GetAppRootPath() {
        return (String)this.getServletContext().getAttribute("APPROOTPATH");
    }

    public String GetTempPath() {
        return this.getWebExConfig().GetValue("SRFEXWEB", "TEMPFOLDER", "");
    }

    public WebExConfig getWebExConfig() {
        return this.getGlobalConfigMgr().GetWebExConfig();
    }

    public GlobalConfigMgr getGlobalConfigMgr() {
        return (GlobalConfigMgr)((Object)this.getServletContext().getAttribute("GLOBALCONFIG"));
    }

    public ServletContext getServletContext() {
        return this.servletContext;
    }

    protected IUserPrivilegeMgr CreateUserPrivilegeMgr() {
        return new DefaultUserPrivilegeMgr();
    }

    @Override
    public IUserPrivilegeMgr GetUserPrivilegeMgr() {
        Object objUserPrivilegeMgr = this.GetSessionValue("USERPRIVILEGEMGR");
        if (objUserPrivilegeMgr != null && objUserPrivilegeMgr instanceof IUserPrivilegeMgr) {
            return (IUserPrivilegeMgr)objUserPrivilegeMgr;
        }
        IUserPrivilegeMgr iUserPrivilegeMgr = this.CreateUserPrivilegeMgr();
        if (iUserPrivilegeMgr != null) {
            this.SetSessionValue("USERPRIVILEGEMGR", iUserPrivilegeMgr);
        }
        return iUserPrivilegeMgr;
    }

    @Override
    public String getRemoteAddr() {
        return this.request.getRemoteAddr();
    }

    @Override
    public CodeListMgr getCodeListMgr() {
        if (!this.isEnableUserCodeList()) {
            return this.getGlobalHelper().getCodeListMgr();
        }
        Object obj = this.GetSessionValue("CODELIST");
        if (obj == null) {
            return null;
        }
        return (CodeListMgr)((Object)obj);
    }

    protected boolean isEnableUserCodeList() {
        return this.getWebConfig().GetExtValue("USERCODELIST", false);
    }

    public WebConfig getWebConfig() {
        return (WebConfig)this.getServletContext().getAttribute("SRFWEBCONFIG");
    }

    @Override
    public ContextHelper getGlobalHelper() {
        return (ContextHelper)this.GetGlobalValue("CONTEXTHELPER");
    }

    @Override
    public String getCurUserMode() {
        Object objValue = this.GetSessionValue("UESRMODE");
        if (objValue == null) {
            return "DEFAULT";
        }
        return objValue.toString();
    }

    @Override
    public String getCurDeptName() {
        Object objValue = this.GetSessionValue("DEPTNAME");
        if (objValue == null) {
            return "";
        }
        return objValue.toString();
    }

    @Override
    public String getCurDeptId() {
        Object objValue = this.GetSessionValue("DEPTID");
        if (objValue == null) {
            return "";
        }
        return objValue.toString();
    }

    public String GetPostValue(String strParamName, String strDefault) {
        String strValue = this.request.getParameter(strParamName.toLowerCase());
        if (strValue == null) {
            return strDefault;
        }
        return strValue;
    }

    @Override
    public String GetPostValue(String strParamName) {
        String strValue = this.request.getParameter(strParamName.toLowerCase());
        if (strValue == null) {
            strValue = "";
        }
        return strValue;
    }

    @Override
    public boolean IsBackEndMode() {
        return false;
    }

    @Override
    public String GetQueryStringWithout(String strParams) {
        if (StringHelper.Length((String)strParams) == 0) {
            return this.GetQueryString();
        }
        String strURLCall = "";
        String[] list = strParams.split("[|]");
        TreeMap<String, String> notKeys = new TreeMap<String, String>();
        int i = 0;
        while (i < list.length) {
            notKeys.put(list[i].toUpperCase(), "");
            ++i;
        }
        Enumeration<String> enumeration = this.paramList.keys();
        while (enumeration.hasMoreElements()) {
            String strValue;
            String strName = enumeration.nextElement();
            if (StringHelper.Length((String)strName) == 0 || notKeys.containsKey(strName.toUpperCase()) || StringHelper.Length((String)(strValue = this.paramList.get(strName))) == 0) continue;
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

    @Override
    public String GetQueryString() {
        return URLHelper.GetQueryString(this.paramList);
    }

    @Override
    public void Logon() {
    }

    @Override
    public void Logout() {
    }

    @Override
    public String getLocalization() {
        Object objValue = this.GetSessionValue("LOCALIZATION");
        if (objValue == null) {
            return "";
        }
        return (String)objValue;
    }

    @Override
    public TimeZone getCurTimeZone() {
        Object objTimeZone = this.GetSessionValue("SRFTIMEZONE");
        if (objTimeZone == null) {
            return TimeZone.getDefault();
        }
        return (TimeZone)objTimeZone;
    }

    @Override
    public String GetLocalization(String strResId, String strResId2, String strDefault) {
        String strText;
        String strKey = StringHelper.Format((String)"%1$s|%2$s|%3$s", (Object)this.getLocalization(), (Object)strResId, (Object)strResId2);
        if (this.cacheLocalizationMap == null) {
            this.cacheLocalizationMap = new Hashtable();
        }
        if ((strText = this.cacheLocalizationMap.get(strKey)) == null) {
            strText = this.getGlobalHelper().getLocalizationHelper().GetLocalization(this.getLocalization(), strResId, strResId2, strDefault);
            this.cacheLocalizationMap.put(strKey, strText);
        }
        return strText;
    }

    @Override
    public String getCurOrgUnitId() {
        Object objCurOrgId = this.GetSessionValue("SRFORGID");
        if (objCurOrgId == null) {
            return "";
        }
        return objCurOrgId.toString();
    }

    public void setCurOrgUnitId(String strValue) {
        this.SetSessionValue("SRFORGID", strValue);
    }

    @Override
    public String getCurOrgUnitName() {
        Object objCurOrgName = this.GetSessionValue("SRFORGNAME");
        if (objCurOrgName == null) {
            return "";
        }
        return objCurOrgName.toString();
    }

    public void setCurOrgUnitName(String strValue) {
        this.SetSessionValue("SRFORGNAME", strValue);
    }

    @Override
    public Hashtable<String, String> GetParams() {
        return this.paramList;
    }

    @Override
    public String getCurPagePath() {
        return "";
    }

    @Override
    public void ReloadUserPrivilege() {
        this.SetSessionValue("USERPRIVILEGEMGR", null);
    }

    @Override
    public SRFExAjaxActionResult getActiveAjaxActionResult() {
        return this.ajaxActionResult;
    }

    @Override
    public void setActiveAjaxActionResult(SRFExAjaxActionResult ajaxActionResult) {
        this.ajaxActionResult = ajaxActionResult;
    }
}

