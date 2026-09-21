/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.ServletContext
 *  javax.servlet.ServletInputStream
 *  javax.servlet.http.HttpServletRequest
 *  javax.servlet.http.HttpServletResponse
 *  javax.servlet.http.HttpSession
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.paas.web.util;

import java.io.InputStream;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import java.util.TimeZone;
import java.util.TreeMap;
import javax.servlet.ServletContext;
import javax.servlet.ServletInputStream;
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
import net.ibizsys.paas.web.WebContextBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SimpleWebContext
implements IWebContext {
    private static final Log log = LogFactory.getLog(SimpleWebContext.class);
    private ServletContext servletContext = null;
    private HashMap<String, String> paramList = new HashMap();
    private HashMap<String, Object> sessionValueMap = new HashMap();
    private AjaxActionResult ajaxActionResult = null;
    private ISystem curSystem = null;
    private IApplication curApplication = null;
    private HashMap<String, String> postValueMap = new HashMap();
    private HashMap<String, Object> attributeMap = new HashMap();
    private HttpServletRequest request = null;
    private HttpServletResponse response = null;

    public void init(ServletContext servletContext) throws Exception {
        this.servletContext = servletContext;
    }

    @Override
    public void init(HttpServletRequest arg0, HttpServletResponse arg1, ServletContext arg2) throws Exception {
        this.servletContext = arg2;
        if (arg0 instanceof HttpServletRequest) {
            this.request = arg0;
        }
        if (arg1 instanceof HttpServletResponse) {
            this.response = arg1;
        }
    }

    public void parseRequest() throws Exception {
        if (this.request == null) {
            return;
        }
        this.parseRequest(this.request.getQueryString());
        this.parsePost();
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
    public Object getSessionValue(String strKey) {
        return this.getSessionValue(strKey, true);
    }

    @Override
    public void setSessionValue(String strKey, Object objValue) {
        this.setSessionValue(strKey, objValue, true);
    }

    @Override
    public String getCurUserId() {
        Object objValue = this.getSessionValue("SRFPERSONID");
        if (objValue == null) {
            return "";
        }
        return objValue.toString();
    }

    @Override
    public String getCurUserName() {
        Object objValue = this.getSessionValue("SRFUSERNAME");
        if (objValue == null) {
            return "";
        }
        return objValue.toString();
    }

    @Override
    public String getCurLoginName() {
        Object objValue = this.getSessionValue("SRFLOGINNAME");
        if (objValue == null) {
            return "";
        }
        return (String)objValue;
    }

    @Override
    public String getCurUserIconPath() {
        Object objValue = this.getSessionValue("SRFUSERICONPATH");
        if (objValue == null) {
            return "";
        }
        return objValue.toString();
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
        Object objValue = this.getSessionValue("SRFREMOTEADDR");
        if (objValue instanceof String) {
            return (String)objValue;
        }
        return null;
    }

    @Override
    public String getRealRemoteAddr() {
        Object objValue = this.getSessionValue("SRFREALREMOTEADDR");
        if (objValue instanceof String) {
            return (String)objValue;
        }
        return null;
    }

    @Override
    public String getUserAgent() {
        Object objValue = this.getSessionValue("SRFUSERAGENT");
        if (objValue instanceof String) {
            return (String)objValue;
        }
        return null;
    }

    @Override
    public IGlobalContext getGlobalContext() {
        return GlobalContext.getCurrent();
    }

    @Override
    public String getCurUserMode() {
        Object objValue = this.getSessionValue("SRFUSERMODE");
        if (objValue == null) {
            return "DEFAULT";
        }
        return objValue.toString();
    }

    public String getPostValue(String strParamName, String strDefault) {
        strParamName = strParamName.toLowerCase();
        String strValue = null;
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

    public void setPostValue(String strParamName, String strValue) {
        this.postValueMap.put(strParamName.toLowerCase(), strValue);
    }

    @Override
    public String getPostValue(String strParamName) {
        strParamName = strParamName.toLowerCase();
        String strValue = null;
        if (strValue == null && this.postValueMap != null) {
            strValue = this.postValueMap.get(strParamName);
        }
        return strValue;
    }

    @Override
    public String[] getPostValues(String strParamName) {
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
        return strDefault;
    }

    @Override
    public String getLocalization(String strResId, Object[] params, String strDefault) {
        return strDefault;
    }

    @Override
    public String getLocalization(String strResId, String strDefault, Locale locale) {
        return strDefault;
    }

    @Override
    public String getLocalization(String strResId, Object[] params, String strDefault, Locale locale) {
        return strDefault;
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
        Object objCurOrgSectorBC = this.getSessionValue("SRFORGSECTORBC");
        if (objCurOrgSectorBC == null) {
            return "";
        }
        return objCurOrgSectorBC.toString();
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
        Object objUserPrivilegeMgr = this.getSessionValue("SRFUSERPRIVILEGEMGR");
        if (objUserPrivilegeMgr == null) {
            IUserPrivilegeMgr iUserPrivilegeMgr = this.createUserPrivilegeMgr();
            this.setSessionValue("SRFUSERPRIVILEGEMGR", iUserPrivilegeMgr);
            return iUserPrivilegeMgr;
        }
        return (IUserPrivilegeMgr)objUserPrivilegeMgr;
    }

    @Override
    public IUserRoleMgr getUserRoleMgr() throws Exception {
        Object objUserRoleMgr = this.getSessionValue("SRFUSERROLEMGR");
        if (objUserRoleMgr == null) {
            IUserRoleMgr iUserRoleMgr = this.createUserRoleMgr();
            this.setSessionValue("SRFUSERROLEMGR", iUserRoleMgr);
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
            this.sessionValueMap.clear();
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
        this.setSessionValue("SRFUSERNAME", strUserName);
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
        return null;
    }

    @Override
    public String getSessionId() {
        if (this.getSession() != null) {
            return this.getSession().getId();
        }
        return this.getCurUserId();
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
        JSONObject jsonObject = WebContextBase.getAppData(this);
        if (jsonObject == null) {
            return null;
        }
        return jsonObject.optString(strParamName, null);
    }

    @Override
    public String getViewParamValue(String strParamName) {
        JSONObject jsonObject = WebContextBase.getViewParam(this);
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
        Object objUserCodeListGlobal = this.getSessionValue("SRFUSERCODELISTMGR");
        if (objUserCodeListGlobal == null) {
            userCodeListGlobal = new UserCodeListGlobal(this.getCurUserId());
            this.setSessionValue("SRFUSERCODELISTMGR", userCodeListGlobal);
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
        return this.attributeMap.get(strName.toUpperCase());
    }

    @Override
    public void setAttribute(String strName, Object objValue) {
        if (objValue == null) {
            this.attributeMap.remove(strName.toUpperCase());
        } else {
            this.attributeMap.put(strName.toUpperCase(), objValue);
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
    public Object getSessionValue(String strKey, boolean bSerializable) {
        return this.sessionValueMap.get(strKey);
    }

    @Override
    public void setSessionValue(String strKey, Object objValue, boolean bSerializable) {
        if (objValue == null) {
            this.sessionValueMap.remove(strKey);
        } else {
            this.sessionValueMap.put(strKey, objValue);
        }
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

    @Override
    public String getCookieValue(String strParamName) {
        return null;
    }

    @Override
    public void setCookieValue(String name, String value, int maxAge) {
    }

    public void cloneSession(IWebContext iWebContext) {
        if (iWebContext.getRequest() == null || iWebContext.getRequest().getSession() == null) {
            return;
        }
        Enumeration names = iWebContext.getRequest().getSession().getAttributeNames();
        while (names.hasMoreElements()) {
            String strName = (String)names.nextElement();
            Object objValue = iWebContext.getRequest().getSession().getAttribute(strName);
            this.setSessionValue(strName, objValue);
        }
    }

    @Override
    public boolean isCurUserPasswordExpired() {
        Object objExpired = this.getSessionValue("SRFUSERPASSWORDEXPIRED");
        if (StringHelper.isNullOrEmpty(objExpired)) {
            return false;
        }
        return StringHelper.compare(objExpired.toString(), "1", false) == 0;
    }
}

