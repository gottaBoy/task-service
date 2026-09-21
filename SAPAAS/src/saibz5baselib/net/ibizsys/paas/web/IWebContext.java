/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.ServletContext
 *  javax.servlet.http.HttpServletRequest
 *  javax.servlet.http.HttpServletResponse
 *  javax.servlet.http.HttpSession
 */
package net.ibizsys.paas.web;

import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.controller.IViewController;
import net.ibizsys.paas.core.IApplication;
import net.ibizsys.paas.core.ISystem;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.security.IUserPrivilegeMgr;
import net.ibizsys.paas.security.IUserRoleMgr;
import net.ibizsys.paas.util.IGlobalContext;
import net.ibizsys.paas.web.AjaxActionResult;

public interface IWebContext {
    public static final String PERSONID = "SRFPERSONID";
    public static final String USERID = "SRFUSERID";
    public static final String USERNAME = "SRFUSERNAME";
    public static final String USERICONPATH = "SRFUSERICONPATH";
    public static final String USERPASSWORDEXPIRED = "SRFUSERPASSWORDEXPIRED";
    public static final String USERMODE = "SRFUSERMODE";
    @Deprecated
    public static final String UESRNAME = "SRFUESRNAME";
    @Deprecated
    public static final String UESRICONPATH = "SRFUESRICONPATH";
    @Deprecated
    public static final String UESRMODE = "SRFUESRMODE";
    public static final String LOGINNAME = "SRFLOGINNAME";
    public static final String SUPERUSER = "SRFSUPERUSER";
    public static final String ORGADMIN = "SRFORGADMIN";
    public static final String LOCALIZATION = "SRFLOCALIZATION";
    public static final String LOCALE = "SRFLOCALE";
    public static final String TIMEZONE = "SRFTIMEZONE";
    public static final String ORGID = "SRFORGID";
    public static final String ORGNAME = "SRFORGNAME";
    public static final String ORGSECTORID = "SRFORGSECTORID";
    public static final String ORGSECTORNAME = "SRFORGSECTORNAME";
    public static final String ORGSECTORBC = "SRFORGSECTORBC";
    public static final String USERPRIVILEGEMGR = "SRFUSERPRIVILEGEMGR";
    public static final String USERCODELISTMGR = "SRFUSERCODELISTMGR";
    public static final String USERROLEMGR = "SRFUSERROLEMGR";
    public static final String WFMODE = "SRFWFMODE";
    public static final String DYNASYSINSTID = "SRFDYNASYSINSTID";

    public void init(HttpServletRequest var1, HttpServletResponse var2, ServletContext var3) throws Exception;

    public String getCurUserName();

    public String getCurUserId();

    public String getCurOrgSectorId();

    public String getCurOrgSectorName();

    public String getCurOrgSectorBC();

    public String getCurOrgId();

    public String getCurOrgName();

    public TimeZone getCurTimeZone();

    public String getRemoteAddr();

    public String getRealRemoteAddr();

    public String getUserAgent();

    public String getSessionId();

    public Object getSessionValue(String var1, boolean var2);

    public Object getSessionValue(String var1);

    public void setSessionValue(String var1, Object var2);

    public void setSessionValue(String var1, Object var2, boolean var3);

    public Object getGlobalValue(String var1);

    public void setGlobalValue(String var1, Object var2);

    public IGlobalContext getGlobalContext();

    public String getParamValue(String var1);

    public String getCookieValue(String var1);

    public void setCookieValue(String var1, String var2, int var3);

    public void setParamValue(String var1, String var2);

    public void removeParam(String var1);

    public String getCurUserMode();

    public String getPostValue(String var1);

    public String[] getPostValues(String var1);

    public String getLocalization();

    public String getQueryString();

    public String getLocalization(String var1, String var2);

    public String getLocalization(String var1, Object[] var2, String var3);

    public String getLocalization(String var1, String var2, Locale var3);

    public String getLocalization(String var1, Object[] var2, String var3, Locale var4);

    public Map<String, String> getParams();

    public String getCurPagePath();

    public String getQueryStringWithout(String var1);

    public AjaxActionResult getCurAjaxActionResult();

    public void setCurAjaxActionResult(AjaxActionResult var1);

    public IUserPrivilegeMgr getUserPrivilegeMgr() throws Exception;

    public IUserRoleMgr getUserRoleMgr() throws Exception;

    public ISystem getCurSystem();

    public IApplication getCurApplication();

    public HttpServletRequest getRequest();

    public HttpServletResponse getResponse();

    public void login(String var1) throws Exception;

    public void remoteLogin(IEntity var1) throws Exception;

    public void logout();

    public void logout(boolean var1);

    public boolean isSuperUser();

    public HttpSession getSession();

    public String getPostOrParamValue(String var1);

    public String getAppDataValue(String var1);

    public String getViewParamValue(String var1);

    public String getCurLoginName();

    public ICodeList getUserCodeList(ICodeList var1) throws Exception;

    public IViewController getViewController();

    public boolean isOrgAdmin();

    public Object getAttribute(String var1);

    public void setAttribute(String var1, Object var2);

    public String getCurUserIconPath();

    public String getWFMode();

    public Locale getLocale();

    public boolean isCurUserPasswordExpired();
}

