/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.ISRFDAWebContext
 *  javax.servlet.ServletContext
 *  javax.servlet.http.HttpServletRequest
 *  javax.servlet.http.HttpServletResponse
 *  net.ibizsys.paas.web.IWebContext
 *  net.ibizsys.paas.web.util.SimpleWebContext
 */
package SA.SRFDA.PS.Web;

import SA.SRFDA.Web.ISRFDAWebContext;
import java.util.TimeZone;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.paas.web.util.SimpleWebContext;

public class WebContextProxy
extends SimpleWebContext
implements IWebContext {
    private ISRFDAWebContext iWebContext = null;

    public WebContextProxy(ISRFDAWebContext iWebContext) {
        this.iWebContext = iWebContext;
    }

    public void init(HttpServletRequest arg0, HttpServletResponse arg1, ServletContext arg2) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0");
    }

    public String getCurUserName() {
        return this.iWebContext.getCurUserName();
    }

    public String getCurUserId() {
        return this.iWebContext.getCurUserId();
    }

    public String getCurOrgSectorId() {
        return this.iWebContext.getCurDeptId();
    }

    public String getCurOrgSectorName() {
        return this.iWebContext.getCurDeptName();
    }

    public String getCurOrgId() {
        return this.iWebContext.getCurOrgUnitId();
    }

    public String getCurOrgName() {
        return this.iWebContext.getCurOrgUnitName();
    }

    public TimeZone getCurTimeZone() {
        return this.iWebContext.getCurTimeZone();
    }

    public String getRemoteAddr() {
        return this.iWebContext.getRemoteAddr();
    }

    public String getRealRemoteAddr() {
        return this.iWebContext.getRemoteAddr();
    }

    public String getUserAgent() {
        return null;
    }

    public String getSessionId() {
        return null;
    }

    public Object getSessionValue(String strKey, boolean bSerializable) {
        return this.iWebContext.GetSessionValue(strKey);
    }

    public Object getSessionValue(String strKey) {
        return this.iWebContext.GetSessionValue(strKey);
    }

    public void setSessionValue(String strKey, Object objValue) {
        this.iWebContext.SetSessionValue(strKey, objValue);
    }

    public void setSessionValue(String strKey, Object objValue, boolean bSerializable) {
        this.iWebContext.SetSessionValue(strKey, objValue);
    }

    public Object getGlobalValue(String strKey) {
        return this.iWebContext.GetGlobalValue(strKey);
    }

    public void setGlobalValue(String strKey, Object objValue) {
        this.iWebContext.SetGlobalValue(strKey, objValue);
    }

    public String getParamValue(String strParamName) {
        return this.iWebContext.GetParamValue(strParamName);
    }

    public void setParamValue(String strParamName, String strParamValue) {
        this.iWebContext.SetParamValue(strParamName, strParamValue);
    }

    public void removeParam(String strParamName) {
        this.iWebContext.RemoveParam(strParamName);
    }

    public String getCurUserMode() {
        return this.iWebContext.getCurUserMode();
    }

    public String getPostValue(String strParamName) {
        return this.iWebContext.GetPostValue(strParamName);
    }

    public String getLocalization() {
        return this.iWebContext.getLocalization();
    }

    public String getQueryString() {
        return this.iWebContext.GetQueryString();
    }

    public String getCurPagePath() {
        return this.iWebContext.getCurPagePath();
    }

    public String getQueryStringWithout(String strParams) {
        return this.iWebContext.GetQueryStringWithout(strParams);
    }

    public String getWFMode() {
        return this.iWebContext.getSRFWFMode();
    }
}

