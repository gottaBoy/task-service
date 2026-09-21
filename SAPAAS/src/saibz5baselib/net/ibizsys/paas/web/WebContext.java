/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.ServletContext
 *  javax.servlet.ServletInputStream
 *  javax.servlet.ServletRequest
 *  javax.servlet.http.Cookie
 *  javax.servlet.http.HttpServletRequest
 *  javax.servlet.http.HttpServletResponse
 *  javax.servlet.http.HttpSession
 *  net.sf.json.JSONObject
 *  org.springframework.web.context.WebApplicationContext
 *  org.springframework.web.servlet.support.RequestContextUtils
 */
package net.ibizsys.paas.web;

import java.io.InputStream;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import java.util.TimeZone;
import java.util.TreeMap;
import javax.servlet.ServletContext;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletRequest;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.controller.IViewController;
import net.ibizsys.paas.controller.ViewController;
import net.ibizsys.paas.core.IApplication;
import net.ibizsys.paas.core.ISystem;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.security.IUserPrivilegeMgr;
import net.ibizsys.paas.security.IUserRoleMgr;
import net.ibizsys.paas.security.UserPrivilegeMgr;
import net.ibizsys.paas.security.UserRoleMgr;
import net.ibizsys.paas.sysmodel.UserCodeListGlobal;
import net.ibizsys.paas.util.GlobalContext;
import net.ibizsys.paas.util.IGlobalContext;
import net.ibizsys.paas.util.StringBuilderEx;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.util.WebUtility;
import net.ibizsys.paas.web.AjaxActionResult;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.paas.web.LocalSessionStorage;
import net.ibizsys.paas.web.WebContextBase;
import net.sf.json.JSONObject;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.support.RequestContextUtils;

public class WebContext
extends WebContextBase
implements IWebContext {
    private HttpServletRequest request = null;
    private HttpServletResponse response = null;
    private ServletContext servletContext = null;
    private HashMap<String, String> paramList = new HashMap();
    private AjaxActionResult ajaxActionResult = null;
    private ISystem curSystem = null;
    private IApplication curApplication = null;
    private HashMap<String, String> postValueMap = null;
    public static final String WEB_APPLICATION_CONTEXT_ATTRIBUTE = String.valueOf(WebContext.class.getName()) + ".CONTEXT";
    private WebApplicationContext webApplicationContext;

    @Override
    public void init(HttpServletRequest arg0, HttpServletResponse arg1, ServletContext arg2) throws Exception {
        if (arg0 instanceof HttpServletRequest) {
            this.request = arg0;
            this.parseRequest(this.request.getQueryString());
            this.parsePost();
        }
        if (arg1 instanceof HttpServletResponse) {
            this.response = arg1;
        }
        this.servletContext = arg2;
        this.prepareWebApplicationContext();
    }

    protected void prepareWebApplicationContext() throws Exception {
        this.webApplicationContext = (WebApplicationContext)this.request.getAttribute(WEB_APPLICATION_CONTEXT_ATTRIBUTE);
        if (this.webApplicationContext == null) {
            this.webApplicationContext = RequestContextUtils.getWebApplicationContext((ServletRequest)this.request, (ServletContext)this.servletContext);
        }
    }

    protected void parseRequest(String strQueryString) {
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
                    if (StringHelper.length(strValue) != 0) {
                        this.setParamValue(set[0], strValue);
                    }
                }
                catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
            ++i;
        }
    }

    protected void parsePost() throws Exception {
        block15: {
            if (StringHelper.compare(this.getRequest().getMethod(), "POST", true) != 0) {
                return;
            }
            if (this.getRequest().getContentType() == null || this.getRequest().getContentType().indexOf("application/x-www-form-urlencoded") != 0) {
                return;
            }
            Map map = this.getRequest().getParameterMap();
            if (map.size() > 0) {
                return;
            }
            ServletInputStream is = this.getRequest().getInputStream();
            if (is != null) {
                try (Scanner br = null;){
                    try {
                        br = new Scanner((InputStream)is);
                        StringBuilderEx sb = new StringBuilderEx();
                        while (br.hasNextLine()) {
                            String tempStream = br.nextLine();
                            if (tempStream.trim() == null || tempStream.trim().equals("")) continue;
                            sb.append(tempStream);
                        }
                        String strFormValues = sb.toString();
                        if (StringHelper.isNullOrEmpty(strFormValues)) break block15;
                        this.postValueMap = new HashMap();
                        String[] strLists = strFormValues.split("&");
                        int i = 0;
                        while (i < strLists.length) {
                            String[] set = strLists[i].split("=");
                            if (set.length == 2) {
                                try {
                                    String strValue = URLDecoder.decode(set[1], this.getRequest().getCharacterEncoding());
                                    if (StringHelper.length(strValue) != 0) {
                                        this.postValueMap.put(set[0], strValue);
                                    }
                                }
                                catch (Exception ex) {
                                    ex.printStackTrace();
                                }
                            }
                            ++i;
                        }
                    }
                    catch (Exception exception) {
                        br.close();
                    }
                }
            }
        }
    }

    @Override
    public void setParamValue(String strParamName, String strParamValue) {
        if (!StringHelper.isNullOrEmpty(strParamValue = strParamValue.trim())) {
            this.paramList.put(strParamName.toUpperCase(), strParamValue);
        } else {
            this.removeParam(strParamName);
        }
    }

    @Override
    public void removeParam(String strParamName) {
        if (this.paramList.containsKey(strParamName.toUpperCase())) {
            this.paramList.remove(strParamName.toUpperCase());
        }
    }

    @Override
    public String getParamValue(String strParamName) {
        if (this.paramList.containsKey(strParamName.toUpperCase())) {
            return this.paramList.get(strParamName.toUpperCase()).toString();
        }
        return null;
    }

    @Override
    public String getCookieValue(String strParamName) {
        if (this.getRequest() == null) {
            return null;
        }
        Cookie[] cookies = this.getRequest().getCookies();
        if (cookies != null) {
            int i = 0;
            while (i < cookies.length) {
                Cookie cookie = cookies[i];
                if (StringHelper.compare(strParamName, cookie.getName(), true) == 0) {
                    return cookie.getValue();
                }
                ++i;
            }
        }
        return null;
    }

    @Override
    public void setCookieValue(String name, String value, int maxAge) {
        if (this.response == null) {
            return;
        }
        Cookie cookie = new Cookie(name, value);
        cookie.setPath("/");
        cookie.setMaxAge(maxAge);
        this.response.addCookie(cookie);
    }

    @Override
    public Object getSessionValue(String strKey) {
        Object objValue = null;
        if (this.getRequest() != null && this.getRequest().getSession() != null) {
            if (this.isEnableSessionShare() && (objValue = LocalSessionStorage.getCurrent(this.getServletContext()).getSessionValue(this.getRequest().getSession(), strKey)) != null) {
                return objValue;
            }
            return this.getRequest().getSession().getAttribute(strKey);
        }
        return objValue;
    }

    @Override
    public Object getSessionValue(String strKey, boolean bSerializable) {
        Object objValue = null;
        if (this.getRequest() != null && this.getRequest().getSession() != null) {
            if (!bSerializable && this.isEnableSessionShare()) {
                return LocalSessionStorage.getCurrent(this.getServletContext()).getSessionValue(this.getRequest().getSession(), strKey);
            }
            return this.getRequest().getSession().getAttribute(strKey);
        }
        return objValue;
    }

    @Override
    public void setSessionValue(String strKey, Object objValue) {
        this.setSessionValue(strKey, objValue, true);
    }

    @Override
    public String getCurUserId() {
        Object objValue = this.getSessionValue("SRFPERSONID");
        if (objValue == null) {
            objValue = this.getSessionValue("SRFUSERID");
        }
        if (objValue == null) {
            return "";
        }
        return objValue.toString();
    }

    @Override
    public String getCurUserName() {
        Object objValue = this.getSessionValue("SRFUSERNAME");
        if (objValue == null) {
            objValue = this.getSessionValue("SRFUESRNAME");
        }
        if (objValue == null) {
            return "";
        }
        return objValue.toString();
    }

    public void setCurUserName(String strUserName) {
        this.setSessionValue("SRFUSERNAME", strUserName);
        this.setSessionValue("SRFUESRNAME", strUserName);
    }

    @Override
    public String getCurLoginName() {
        Object objValue = this.getSessionValue("SRFLOGINNAME");
        if (objValue == null) {
            return "";
        }
        return (String)objValue;
    }

    public void setCurLoginName(String strLoginName) {
        this.setSessionValue("SRFLOGINNAME", strLoginName);
    }

    @Override
    public String getCurUserIconPath() {
        Object objValue = this.getSessionValue("SRFUSERICONPATH");
        if (objValue == null) {
            objValue = this.getSessionValue("SRFUESRICONPATH");
        }
        if (objValue == null) {
            return "";
        }
        return objValue.toString();
    }

    public void setCurUserId(String strUserId) {
        this.setSessionValue("SRFPERSONID", strUserId);
        this.setSessionValue("SRFUSERID", strUserId);
    }

    public void setCurUserIconPath(String strUserIconPath) {
        this.setSessionValue("SRFUSERICONPATH", strUserIconPath);
        this.setSessionValue("SRFUESRICONPATH", strUserIconPath);
    }

    public void setCurUserPasswordExpired(boolean bExpired) {
        this.setSessionValue("SRFUSERPASSWORDEXPIRED", bExpired ? "1" : "0");
    }

    @Override
    public boolean isCurUserPasswordExpired() {
        Object objExpired = this.getSessionValue("SRFUSERPASSWORDEXPIRED");
        if (StringHelper.isNullOrEmpty(objExpired)) {
            return false;
        }
        return StringHelper.compare(objExpired.toString(), "1", false) == 0;
    }

    @Override
    public Object getGlobalValue(String strKey) {
        return this.getServletContext().getAttribute(strKey);
    }

    @Override
    public void setGlobalValue(String strKey, Object objValue) {
        if (objValue == null) {
            this.getServletContext().removeAttribute(strKey);
        } else {
            this.getServletContext().setAttribute(strKey, objValue);
        }
    }

    public ServletContext getServletContext() {
        return this.servletContext;
    }

    @Override
    public String getRemoteAddr() {
        if (this.getRequest() == null) {
            return null;
        }
        return this.getRequest().getRemoteAddr();
    }

    @Override
    public String getRealRemoteAddr() {
        if (this.getRequest() == null) {
            return null;
        }
        String strRealIp = this.getRequest().getHeader("X-Real-IP");
        return strRealIp;
    }

    @Override
    public String getUserAgent() {
        if (this.getRequest() == null) {
            return null;
        }
        return this.getRequest().getHeader("User-Agent");
    }

    @Override
    public IGlobalContext getGlobalContext() {
        return GlobalContext.getCurrent();
    }

    @Override
    public String getCurUserMode() {
        Object objValue = this.getSessionValue("SRFUSERMODE");
        if (objValue == null) {
            objValue = this.getSessionValue("SRFUESRMODE");
        }
        if (objValue == null) {
            return "DEFAULT";
        }
        return objValue.toString();
    }

    public void setCurUserMode(String strUserMode) {
        this.setSessionValue("SRFUSERMODE", strUserMode);
        this.setSessionValue("SRFUESRMODE", strUserMode);
    }

    public String getPostValue(String strParamName, String strDefault) {
        if (this.getRequest() != null) {
            strParamName = strParamName.toLowerCase();
            String strValue = this.getRequest().getParameter(strParamName);
            if (strValue == null) {
                if (this.postValueMap != null) {
                    strValue = this.postValueMap.get(strParamName);
                }
                if (strValue == null) {
                    return strDefault;
                }
            }
            return strValue;
        }
        return strDefault;
    }

    @Override
    public String getPostValue(String strParamName) {
        if (this.getRequest() != null) {
            strParamName = strParamName.toLowerCase();
            String strValue = this.getRequest().getParameter(strParamName);
            if (strValue == null && this.postValueMap != null) {
                strValue = this.postValueMap.get(strParamName);
            }
            return strValue;
        }
        return null;
    }

    @Override
    public String[] getPostValues(String strParamName) {
        if (this.getRequest() != null) {
            strParamName = strParamName.toLowerCase();
            String strValue = this.getRequest().getParameter(strParamName);
            if (strValue == null) {
                return null;
            }
            return this.getRequest().getParameterValues(strParamName);
        }
        return null;
    }

    @Override
    public String getQueryStringWithout(String strParams) {
        if (StringHelper.length(strParams) == 0) {
            return this.getQueryString();
        }
        String strURLCall = "";
        String[] list = strParams.split("[|]");
        TreeMap<String, String> notKeys = new TreeMap<String, String>();
        int i = 0;
        while (i < list.length) {
            notKeys.put(list[i].toUpperCase(), "");
            ++i;
        }
        for (String strName : this.paramList.keySet()) {
            String strValue;
            if (StringHelper.length(strName) == 0 || notKeys.containsKey(strName.toUpperCase()) || StringHelper.length(strValue = this.paramList.get(strName)) == 0) continue;
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
    public String getQueryString() {
        return WebUtility.getQueryString(this.paramList);
    }

    @Override
    public String getLocalization() {
        Object objValue = this.getSessionValue("SRFLOCALIZATION");
        if (objValue == null) {
            return "";
        }
        return (String)objValue;
    }

    @Override
    public TimeZone getCurTimeZone() {
        Object objTimeZone = this.getSessionValue("SRFTIMEZONE");
        if (objTimeZone == null) {
            return TimeZone.getDefault();
        }
        return (TimeZone)objTimeZone;
    }

    @Override
    public String getLocalization(String strResId, String strDefault) {
        String strValue = this.getWebApplicationContext().getMessage(strResId, null, strDefault, this.getLocale());
        if (StringHelper.isNullOrEmpty(strValue)) {
            return strDefault;
        }
        return strValue;
    }

    @Override
    public String getLocalization(String strResId, Object[] params, String strDefault) {
        String strValue = this.getWebApplicationContext().getMessage(strResId, params, strDefault, this.getLocale());
        if (StringHelper.isNullOrEmpty(strValue)) {
            return strDefault;
        }
        return strValue;
    }

    @Override
    public String getLocalization(String strResId, String strDefault, Locale locale) {
        String strValue = this.getWebApplicationContext().getMessage(strResId, null, strDefault, locale);
        if (StringHelper.isNullOrEmpty(strValue)) {
            return strDefault;
        }
        return strValue;
    }

    @Override
    public String getLocalization(String strResId, Object[] params, String strDefault, Locale locale) {
        String strValue = this.getWebApplicationContext().getMessage(strResId, params, strDefault, locale);
        if (StringHelper.isNullOrEmpty(strValue)) {
            return strDefault;
        }
        return strValue;
    }

    @Override
    public String getCurOrgId() {
        Object objCurOrgId = this.getSessionValue("SRFORGID");
        if (objCurOrgId == null) {
            return "";
        }
        return objCurOrgId.toString();
    }

    public void setCurOrgId(String strValue) {
        this.setSessionValue("SRFORGID", strValue);
    }

    @Override
    public String getCurOrgName() {
        Object objCurOrgName = this.getSessionValue("SRFORGNAME");
        if (objCurOrgName == null) {
            return "";
        }
        return objCurOrgName.toString();
    }

    public void setCurOrgName(String strValue) {
        this.setSessionValue("SRFORGNAME", strValue);
    }

    @Override
    public String getCurOrgSectorId() {
        Object objCurOrgUnitId = this.getSessionValue("SRFORGSECTORID");
        if (objCurOrgUnitId == null) {
            return "";
        }
        return objCurOrgUnitId.toString();
    }

    public void setCurOrgSectorId(String strValue) {
        this.setSessionValue("SRFORGSECTORID", strValue);
    }

    @Override
    public String getCurOrgSectorName() {
        Object objCurOrgUnitName = this.getSessionValue("SRFORGSECTORNAME");
        if (objCurOrgUnitName == null) {
            return "";
        }
        return objCurOrgUnitName.toString();
    }

    public void setCurOrgSectorName(String strValue) {
        this.setSessionValue("SRFORGSECTORNAME", strValue);
    }

    @Override
    public String getCurOrgSectorBC() {
        Object objCurOrgUnitBC = this.getSessionValue("SRFORGSECTORBC");
        if (objCurOrgUnitBC == null) {
            return "";
        }
        return objCurOrgUnitBC.toString();
    }

    public void setCurOrgSectorBC(String strValue) {
        this.setSessionValue("SRFORGSECTORBC", strValue);
    }

    @Override
    public Map<String, String> getParams() {
        return this.paramList;
    }

    @Override
    public String getCurPagePath() {
        return "";
    }

    @Override
    public AjaxActionResult getCurAjaxActionResult() {
        return this.ajaxActionResult;
    }

    @Override
    public void setCurAjaxActionResult(AjaxActionResult ajaxActionResult) {
        this.ajaxActionResult = ajaxActionResult;
    }

    @Override
    public IUserPrivilegeMgr getUserPrivilegeMgr() throws Exception {
        Object objUserPrivilegeMgr = this.getSessionValue("SRFUSERPRIVILEGEMGR", false);
        if (objUserPrivilegeMgr == null) {
            IUserPrivilegeMgr iUserPrivilegeMgr = this.createUserPrivilegeMgr();
            this.setSessionValue("SRFUSERPRIVILEGEMGR", iUserPrivilegeMgr, false);
            return iUserPrivilegeMgr;
        }
        return (IUserPrivilegeMgr)objUserPrivilegeMgr;
    }

    @Override
    public IUserRoleMgr getUserRoleMgr() throws Exception {
        Object objUserRoleMgr = this.getSessionValue("SRFUSERROLEMGR", false);
        if (objUserRoleMgr == null) {
            IUserRoleMgr iUserRoleMgr = this.createUserRoleMgr();
            this.setSessionValue("SRFUSERROLEMGR", iUserRoleMgr, false);
            return iUserRoleMgr;
        }
        return (IUserRoleMgr)objUserRoleMgr;
    }

    protected IUserRoleMgr createUserRoleMgr() throws Exception {
        UserRoleMgr userRoleMgr = new UserRoleMgr();
        userRoleMgr.init(this);
        return userRoleMgr;
    }

    @Override
    public ISystem getCurSystem() {
        return this.curSystem;
    }

    @Override
    public IApplication getCurApplication() {
        return this.curApplication;
    }

    public void setCurSystem(ISystem curSystem) {
        this.curSystem = curSystem;
    }

    public void setCurApplication(IApplication curApplication) {
        this.curApplication = curApplication;
    }

    protected IUserPrivilegeMgr createUserPrivilegeMgr() throws Exception {
        return new UserPrivilegeMgr();
    }

    @Override
    public HttpServletRequest getRequest() {
        return this.request;
    }

    @Override
    public HttpServletResponse getResponse() {
        return this.response;
    }

    @Override
    public void logout() {
        this.logout(false);
    }

    @Override
    public void logout(boolean bReleaseSession) {
        this.setSessionValue("SRFLOGINNAME", null);
        this.setSessionValue("SRFUSERROLEMGR", null);
        this.setSessionValue("SRFUSERPRIVILEGEMGR", null);
        this.setSessionValue("SRFUSERCODELISTMGR", null);
        if (bReleaseSession) {
            this.request.getSession().invalidate();
        }
    }

    @Override
    public void login(String strLoginName) throws Exception {
        this.setSessionValue("SRFLOGINNAME", strLoginName);
    }

    @Override
    public void remoteLogin(IEntity iEntity) throws Exception {
        String strUserId = DataObject.getStringValue(iEntity, "userid", "");
        String strUserName = DataObject.getStringValue(iEntity, "username", "");
        this.setSessionValue("SRFPERSONID", strUserId);
        this.setSessionValue("SRFUSERID", strUserId);
        this.setSessionValue("SRFUSERNAME", strUserName);
        this.setSessionValue("SRFUESRNAME", strUserName);
        String strRet = DataObject.getStringValue(iEntity, "SRFSUPERUSER", "0");
        this.setSessionValue("SRFSUPERUSER", strRet);
        strRet = DataObject.getStringValue(iEntity, "SRFORGADMIN", "0");
        this.setSessionValue("SRFORGADMIN", strRet);
    }

    @Override
    public boolean isSuperUser() {
        Object objSuperUser = this.getSessionValue("SRFSUPERUSER");
        if (objSuperUser == null) {
            return false;
        }
        return objSuperUser.toString().compareTo("1") == 0;
    }

    @Override
    public HttpSession getSession() {
        return this.request.getSession();
    }

    @Override
    public String getSessionId() {
        return this.getSession().getId();
    }

    @Override
    public String getPostOrParamValue(String strParamName) {
        String strValue = this.getPostValue(strParamName);
        if (strValue != null) {
            return strValue;
        }
        return this.getParamValue(strParamName);
    }

    @Override
    public String getAppDataValue(String strParamName) {
        JSONObject jsonObject = WebContext.getAppData(this);
        if (jsonObject == null) {
            return null;
        }
        return jsonObject.optString(strParamName, null);
    }

    @Override
    public String getViewParamValue(String strParamName) {
        JSONObject jsonObject = WebContext.getViewParam(this);
        if (jsonObject == null) {
            return null;
        }
        return jsonObject.optString(strParamName, null);
    }

    @Override
    public ICodeList getUserCodeList(ICodeList iCodeList) throws Exception {
        if (!iCodeList.isUserScope()) {
            return iCodeList;
        }
        return this.getUserCodeListGlobal().getUserCodeList(iCodeList);
    }

    public UserCodeListGlobal getUserCodeListGlobal() throws Exception {
        UserCodeListGlobal userCodeListGlobal = null;
        Object objUserCodeListGlobal = this.getSessionValue("SRFUSERCODELISTMGR", false);
        if (objUserCodeListGlobal == null) {
            userCodeListGlobal = new UserCodeListGlobal(this.getCurUserId());
            this.setSessionValue("SRFUSERCODELISTMGR", userCodeListGlobal, false);
        } else {
            userCodeListGlobal = (UserCodeListGlobal)objUserCodeListGlobal;
        }
        return userCodeListGlobal;
    }

    @Override
    public IViewController getViewController() {
        return ViewController.getCurrent();
    }

    @Override
    public boolean isOrgAdmin() {
        Object objOrgAdmin = this.getSessionValue("SRFORGADMIN");
        if (objOrgAdmin == null) {
            return false;
        }
        return objOrgAdmin.toString().compareTo("1") == 0;
    }

    @Override
    public Object getAttribute(String strName) {
        if (this.getRequest() == null) {
            return null;
        }
        return this.request.getAttribute(strName.toUpperCase());
    }

    @Override
    public void setAttribute(String strName, Object objValue) {
        if (objValue == null) {
            this.request.removeAttribute(strName.toUpperCase());
        } else {
            this.request.setAttribute(strName.toUpperCase(), objValue);
        }
    }

    @Override
    public String getWFMode() {
        Object objWFMode = this.getSessionValue("SRFWFMODE");
        if (objWFMode == null) {
            return "";
        }
        return (String)objWFMode;
    }

    @Override
    public void setSessionValue(String strKey, Object objValue, boolean bSerializable) {
        if (this.getRequest() != null && this.getRequest().getSession() != null) {
            if (objValue == null) {
                if (this.isEnableSessionShare()) {
                    LocalSessionStorage.getCurrent(this.getServletContext()).setSessionValue(this.getRequest().getSession(), strKey, objValue);
                }
                this.getRequest().getSession().removeAttribute(strKey);
            } else if (!bSerializable && this.isEnableSessionShare()) {
                LocalSessionStorage.getCurrent(this.getServletContext()).setSessionValue(this.request.getSession(), strKey, objValue);
            } else {
                this.getRequest().getSession().setAttribute(strKey, objValue);
            }
        }
    }

    public boolean isEnableSessionShare() {
        return false;
    }

    public WebApplicationContext getWebApplicationContext() {
        return this.webApplicationContext;
    }

    @Override
    public Locale getLocale() {
        Locale locale = null;
        Object objLocale = this.getSessionValue("SRFLOCALE");
        if (objLocale == null) {
            String[] parts;
            String strLocale = this.getLocalization();
            locale = StringHelper.isNullOrEmpty(strLocale) ? Locale.CHINA : ((parts = strLocale.split("[_]")).length == 1 ? new Locale(parts[0].toLowerCase()) : new Locale(parts[0].toLowerCase(), parts[1].toUpperCase()));
            this.setSessionValue("SRFLOCALE", locale, false);
        } else {
            locale = (Locale)objLocale;
        }
        return locale;
    }

    public void setPostValue(String strParamName, String strValue) {
        strParamName = strParamName.toLowerCase();
        if (this.postValueMap == null) {
            this.postValueMap = new HashMap();
        }
        this.postValueMap.put(strParamName, strValue);
    }
}

