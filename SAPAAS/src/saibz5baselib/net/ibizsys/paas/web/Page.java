/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.http.HttpServletRequest
 *  javax.servlet.http.HttpServletResponse
 *  javax.servlet.jsp.PageContext
 *  org.apache.commons.lang.StringEscapeUtils
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.paas.web;

import java.io.Writer;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.PageContext;
import net.ibizsys.paas.appmodel.AppModelGlobal;
import net.ibizsys.paas.appmodel.IApplicationModel;
import net.ibizsys.paas.db.DataSetCache;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.security.AccessUserModes;
import net.ibizsys.paas.security.RemoteLoginGlobal;
import net.ibizsys.paas.service.SessionFactoryManager;
import net.ibizsys.paas.util.ObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.util.WebUtility;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.paas.web.WebConfig;
import net.ibizsys.paas.web.WebContext;
import net.ibizsys.psrt.srv.common.entity.LoginLog;
import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public class Page {
    private static final Log log = LogFactory.getLog(Page.class);
    private boolean bNoCache = true;
    private ThreadLocal<SessionFactory> sessionFactory = new ThreadLocal();
    private ThreadLocal<PageContext> pageContext = new ThreadLocal();
    private IDataEntityModel iDataEntityModel = null;
    private ThreadLocal<Boolean> bInitResult = new ThreadLocal();
    private static ThreadLocal<Page> curPage = new ThreadLocal();
    private int nAccessUserMode = AccessUserModes.ALLUSER;
    private String strAccessKey = null;

    public final boolean init(PageContext context) throws Exception {
        this.pageContext.set(context);
        this.bInitResult.set(true);
        curPage.set(this);
        SessionFactoryManager.enter();
        if (this.isNoCache()) {
            this.getResponse().addHeader("cache-control", "no-cache");
            this.getResponse().addHeader("expires", "thu, 01 jan 1970 00:00:01 gmt");
        }
        IWebContext iWebContext = this.createWebContext(this.getRequest(), this.getResponse());
        WebContext.setCurrent(iWebContext);
        if (!this.testUserAccess()) {
            this.resetCurrent();
            return false;
        }
        IApplicationModel iApplicationModel = this.getApplicationModel();
        if (iApplicationModel != null && iApplicationModel.doFilter(this, this.getRequest(), this.getResponse())) {
            this.resetCurrent();
            return this.getInitResult();
        }
        try {
            DataSetCache.enableCurrent();
            this.onInit();
        }
        catch (Exception ex) {
            this.resetCurrent();
            throw ex;
        }
        return this.getInitResult();
    }

    protected void resetCurrent() {
        this.setSessionFactory(null);
        WebContext.setCurrent(null);
        DataSetCache.resetCurrent();
        this.pageContext.set(null);
        SessionFactoryManager.leave();
    }

    protected IWebContext createWebContext(HttpServletRequest request, HttpServletResponse response) throws Exception {
        IApplicationModel iApplicationModel = this.getApplicationModel();
        if (iApplicationModel != null) {
            return iApplicationModel.createWebContext(null, request, response);
        }
        if (StringHelper.isNullOrEmpty(WebConfig.getCurrent().getWebContextObj())) {
            WebContext iWebContext = new WebContext();
            iWebContext.init(request, response, request.getSession().getServletContext());
            this.doRemoteLogin(iWebContext);
            return iWebContext;
        }
        IWebContext iWebContext = (IWebContext)ObjectHelper.create(WebConfig.getCurrent().getWebContextObj());
        iWebContext.init(request, response, request.getSession().getServletContext());
        this.doRemoteLogin(iWebContext);
        return iWebContext;
    }

    protected void doRemoteLogin(IWebContext iWebContext) throws Exception {
        if (!StringHelper.isNullOrEmpty(iWebContext.getCurUserId())) {
            return;
        }
        String strLoginKey = WebContext.getLoginKey(iWebContext);
        if (StringHelper.isNullOrEmpty(strLoginKey)) {
            return;
        }
        LoginLog loginLog = RemoteLoginGlobal.getLoginLog(strLoginKey);
        if (loginLog == null) {
            return;
        }
        iWebContext.remoteLogin(loginLog);
    }

    protected void onInit() throws Exception {
    }

    public final Writer getWriter() {
        return this.getPageContext().getOut();
    }

    public final HttpServletRequest getRequest() {
        return (HttpServletRequest)this.getPageContext().getRequest();
    }

    public final HttpServletResponse getResponse() {
        return (HttpServletResponse)this.getPageContext().getResponse();
    }

    public boolean isNoCache() {
        return this.bNoCache;
    }

    protected void setNoCache(boolean bNoCache) {
        this.bNoCache = bNoCache;
    }

    public IWebContext getWebContext() {
        return WebContext.getCurrent();
    }

    public final PageContext getPageContext() {
        return this.pageContext.get();
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory.set(sessionFactory);
    }

    public SessionFactory getSessionFactory() {
        return this.sessionFactory.get();
    }

    public boolean isEmbed() {
        return !StringHelper.isNullOrEmpty(this.getContainerId());
    }

    public boolean isIFChild() {
        return StringHelper.compare(this.getWebContext().getParamValue("SRFIFCHILD"), "TRUE", true) == 0;
    }

    public String getContainerId() {
        return WebContext.getContainerId();
    }

    public String getCId() {
        if (StringHelper.isNullOrEmpty(this.getContainerId())) {
            return "";
        }
        return StringHelper.format("%1$s_", this.getContainerId());
    }

    public String getCLevel() {
        String strContainerLevel = WebContext.getContainerLevel();
        if (StringHelper.isNullOrEmpty(strContainerLevel)) {
            return "";
        }
        return strContainerLevel;
    }

    protected boolean testUserAccess() throws Exception {
        String strPersonId = this.getWebContext().getCurUserId();
        if (StringHelper.isNullOrEmpty(strPersonId)) {
            if ((this.getAccessUserMode() & AccessUserModes.ANONYMOUS) > 0) {
                return true;
            }
            String strPath = String.valueOf(this.getRequest().getRequestURL().toString()) + "?" + this.getRequest().getQueryString();
            HashMap<String, String> urlParamMap = new HashMap<String, String>();
            urlParamMap.put("RU", strPath);
            this.sendRedirect("LOGIN", urlParamMap);
            return false;
        }
        if (this.getWebContext().isCurUserPasswordExpired()) {
            String strPath = String.valueOf(this.getRequest().getRequestURL().toString()) + "?" + this.getRequest().getQueryString();
            HashMap<String, String> urlParamMap = new HashMap<String, String>();
            urlParamMap.put("RU", strPath);
            this.sendRedirect("PASSWORDEXPIRED", urlParamMap);
            return false;
        }
        if ((this.getAccessUserMode() & AccessUserModes.LOGINUSER) > 0) {
            return true;
        }
        if ((this.getAccessUserMode() & AccessUserModes.LOGINUSERWITHKEY) > 0 && this.getWebContext().getUserPrivilegeMgr().test(this.getWebContext(), this.getAccessKey())) {
            return true;
        }
        this.sendRedirect("ACCESSDENY", null);
        return false;
    }

    protected void setDEModel(IDataEntityModel iDataEntityModel) {
        this.iDataEntityModel = iDataEntityModel;
    }

    public IDataEntityModel getDEModel() {
        return this.iDataEntityModel;
    }

    public String getLocalization() {
        return WebContext.getCurrent().getLocalization();
    }

    public int getAccessUserMode() {
        return this.nAccessUserMode;
    }

    public void setAccessUserMode(int nAccessUserMode) {
        this.nAccessUserMode = nAccessUserMode;
    }

    public String getAccessKey() {
        return this.strAccessKey;
    }

    public void setAccessKey(String strAccessKey) {
        this.strAccessKey = strAccessKey;
    }

    protected void sendRedirect(String strPageType, HashMap<String, String> urlParamMap) throws Exception {
        IApplicationModel appModel = this.getApplicationModel();
        String strPageUrl = appModel.getUtilPageUrl(strPageType);
        strPageUrl = this.mapRealPageUrl(strPageUrl);
        if (urlParamMap != null) {
            String strQueryString = WebUtility.getQueryString(urlParamMap);
            strPageUrl = WebUtility.appendURLSeperator(strPageUrl);
            strPageUrl = String.valueOf(strPageUrl) + strQueryString;
        }
        this.getResponse().sendRedirect(strPageUrl);
    }

    protected String mapRealPageUrl(String strPageUrl) throws Exception {
        return strPageUrl;
    }

    protected IApplicationModel getApplicationModel() throws Exception {
        return (IApplicationModel)AppModelGlobal.getDefaultApplication();
    }

    public void setInitResult(boolean bRet) {
        this.bInitResult.set(bRet);
    }

    public boolean getInitResult() {
        return this.bInitResult.get();
    }

    public void end() {
        this.resetCurrent();
    }

    public static Page getCurrent() {
        return curPage.get();
    }

    public boolean isShowAction(String strActionPrivTag) throws Exception {
        return true;
    }

    public static String getRequest(HttpServletRequest request, String strParamName) {
        String strValue = request.getParameter(strParamName);
        if (!StringHelper.isNullOrEmpty(strValue)) {
            strValue = StringEscapeUtils.escapeJava((String)strValue);
        }
        return strValue;
    }
}

