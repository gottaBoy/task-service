/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.Filter
 *  javax.servlet.FilterChain
 *  javax.servlet.FilterConfig
 *  javax.servlet.ServletContext
 *  javax.servlet.ServletException
 *  javax.servlet.ServletRequest
 *  javax.servlet.ServletResponse
 *  javax.servlet.http.HttpServletRequest
 *  javax.servlet.http.HttpServletResponse
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.paas.web;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.ibizsys.paas.Version;
import net.ibizsys.paas.sysmodel.BackendServiceMgr;
import net.ibizsys.paas.util.GlobalContext;
import net.ibizsys.paas.util.IGlobalContext;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.util.SystemRTHelper;
import net.ibizsys.paas.util.WebUtility;
import net.ibizsys.paas.web.LocalSessionStorage;
import net.ibizsys.paas.web.WebConfig;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class WebFilter
implements Filter {
    public static final String ATTR_INSTALLDBMODELS = "INSTALLDBMODELS";
    protected FilterConfig filterConfig;
    protected boolean bEncrypt = true;
    protected String strRootPath = "";
    private static Log log = LogFactory.getLog(WebFilter.class);
    private WebConfig webConfig = null;
    private boolean bAuthFilter = false;
    private String strAuthPath = "";
    protected HashMap<String, Integer> unauthpathMap = new HashMap();
    public static final String RESPONSE_REDIRECT = "SRF_RESPONSE_REDIRECT";
    protected String strServerName = "";
    protected HashMap<String, String> authPathMap = new HashMap();

    public void init(FilterConfig config) {
        char ch;
        this.filterConfig = config;
        this.webConfig = this.createWebConfig();
        this.strRootPath = this.webConfig.getAttribute("APPPATH", "");
        if (StringHelper.isNullOrEmpty(this.strRootPath)) {
            this.strRootPath = this.filterConfig.getServletContext().getRealPath("/");
        }
        if (!StringHelper.isNullOrEmpty(this.strRootPath) && (ch = this.strRootPath.charAt(this.strRootPath.length() - 1)) != File.separatorChar) {
            this.strRootPath = String.valueOf(this.strRootPath) + File.separator;
        }
        try {
            LocalSessionStorage.getCurrent(this.filterConfig.getServletContext());
            GlobalContext2 globalContext2 = new GlobalContext2(this.filterConfig.getServletContext());
            globalContext2.setCurrent(globalContext2);
            globalContext2.init();
            this.prepareAuthFilter();
            String strInstallDBModels = this.filterConfig.getInitParameter(ATTR_INSTALLDBMODELS);
            if (!StringHelper.isNullOrEmpty(strInstallDBModels)) {
                SystemRTHelper.installDBModel(strInstallDBModels, false);
            }
            SystemRTHelper.installDynaSys();
        }
        catch (Exception e) {
            log.equals(e);
            e.printStackTrace();
        }
        this.outputVersionInfo();
        this.startBackendService();
        this.onInit();
    }

    protected WebConfig createWebConfig() {
        return new WebConfig(this.filterConfig);
    }

    protected void startBackendService() {
        String strServiceContainerId = this.webConfig.getServiceContainer();
        if (StringHelper.isNullOrEmpty(strServiceContainerId)) {
            return;
        }
        log.info((Object)StringHelper.format("\u521d\u59cb\u5316\u540e\u53f0\u670d\u52a1\u5bb9\u5668[%1$s]", strServiceContainerId));
        try {
            BackendServiceMgr backendServiceMgr = BackendServiceMgr.createInstance(strServiceContainerId);
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.format("\u521d\u59cb\u5316\u540e\u53f0\u670d\u52a1\u5bb9\u5668[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", strServiceContainerId, ex.getMessage()), (Throwable)ex);
        }
    }

    protected void outputVersionInfo() {
        log.info((Object)String.format("SA iBizSys Runtime [%1$s]", Version.toVersionString()));
    }

    protected void onInit() {
    }

    public void destroy() {
        this.onDestroy();
        log.info((Object)"WebFilter destroy");
        this.filterConfig = null;
    }

    protected void onDestroy() {
    }

    public final void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest curRequest = (HttpServletRequest)request;
        HttpServletResponse curResponse = (HttpServletResponse)response;
        String strRequestURL = curRequest.getRequestURL().toString();
        int nPos = strRequestURL.lastIndexOf(".jsp");
        if (nPos != -1 && nPos == strRequestURL.length() - 4 && !this.doPageFilter(curRequest, curResponse)) {
            return;
        }
        filterChain.doFilter(request, response);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    protected boolean doPageFilter(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        if (!this.bAuthFilter) return true;
        if (request.getSession().getAttribute("SRFPERSONID") != null) return true;
        String strCurPath = request.getRequestURL().toString();
        String strContextPath = request.getContextPath();
        String strServerName2 = request.getServerName();
        int nStartPos = strCurPath.indexOf(strServerName2);
        nStartPos = nStartPos != -1 ? (nStartPos += strServerName2.length()) : 0;
        int nContextPathPos = strCurPath.indexOf(strContextPath, nStartPos);
        if (nContextPathPos != -1) {
            strCurPath = strCurPath.substring(nContextPathPos + strContextPath.length());
        }
        if (this.unauthpathMap.containsKey(strCurPath)) return true;
        try {
            request.setAttribute(RESPONSE_REDIRECT, (Object)1);
            boolean bDirectLogin = false;
            int nPos = strCurPath.lastIndexOf("backend.jsp");
            if (nPos != -1) {
                String strActionType = request.getParameter("srfactiontype");
                if (StringHelper.isNullOrEmpty(strActionType)) {
                    strActionType = request.getParameter("actiontype");
                }
                if (!StringHelper.isNullOrEmpty(strActionType)) {
                    nPos = strCurPath.lastIndexOf("modelbackend.jsp");
                    if (nPos == -1) {
                        if (StringHelper.compare(strActionType, "formaction", true) == 0) {
                            response.sendRedirect("../uacclient/uaclogin_formaction.jsp");
                            return false;
                        }
                        if (StringHelper.compare(strActionType, "gridaction", true) == 0) {
                            response.sendRedirect("../uacclient/uaclogin_gridaction.jsp");
                            return false;
                        }
                        response.sendRedirect("../uacclient/uaclogin_backendaction.jsp");
                        return false;
                    }
                    if (StringHelper.compare(strActionType, "formaction", true) == 0) {
                        response.sendRedirect("../uacclient/uaclogin_formaction2.jsp");
                        return false;
                    }
                    if (StringHelper.compare(strActionType, "gridaction", true) == 0) {
                        response.sendRedirect("../uacclient/uaclogin_gridaction2.jsp");
                        return false;
                    }
                    response.sendRedirect("../uacclient/uaclogin_backendaction2.jsp");
                    return false;
                }
            } else {
                nPos = strCurPath.lastIndexOf("/uacclient/uaclogin_popup.jsp");
                if (nPos != -1) {
                    bDirectLogin = true;
                }
            }
            String strRequestUrl = "";
            strRequestUrl = StringHelper.isNullOrEmpty(this.strServerName) ? request.getRequestURL().toString() : String.valueOf(this.strServerName) + strContextPath + strCurPath;
            String strQueryString = request.getQueryString();
            String strParams = "";
            strParams = StringHelper.isNullOrEmpty(strQueryString) ? String.valueOf(WebUtility.encodeURLParamValue(strRequestUrl)) + (bDirectLogin ? "&DIRECT=TRUE" : "") : String.valueOf(WebUtility.encodeURLParamValue(String.valueOf(strRequestUrl) + "?" + request.getQueryString())) + (bDirectLogin ? "&DIRECT=TRUE" : "");
            String strAuthPath = this.authPathMap.get(request.getServerName().toUpperCase());
            if (StringHelper.isNullOrEmpty(strAuthPath)) {
                strAuthPath = this.strAuthPath;
            }
            response.sendRedirect(String.valueOf(strAuthPath) + strParams);
            return false;
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    private void prepareAuthFilter() throws Exception {
        String strAuthFilter = this.filterConfig.getInitParameter("AUTHFILTER");
        if (!StringHelper.isNullOrEmpty(strAuthFilter)) {
            this.bAuthFilter = StringHelper.compare(strAuthFilter, "TRUE", true) == 0;
            this.strAuthPath = this.filterConfig.getInitParameter("AUTHPATH");
            if (StringHelper.isNullOrEmpty(this.strAuthPath)) {
                this.bAuthFilter = false;
                log.warn((Object)"\u6ca1\u6709\u6307\u5b9a\u8ba4\u8bc1\u8def\u5f84\uff0c\u4e0d\u542f\u7528\u8ba4\u8bc1\u8fc7\u6ee4");
            }
        }
        if (this.bAuthFilter) {
            String strAuthServer;
            this.unauthpathMap.put("/srfapp/remotecall.jsp", 1);
            this.unauthpathMap.put("/commonex/accessdeny_major.jsp", 1);
            this.unauthpathMap.put("/commonex/accessdeny_minor.jsp", 1);
            this.unauthpathMap.put("/commonex/showerror.jsp", 1);
            this.unauthpathMap.put("/uacclient/uaclogin2.jsp", 1);
            this.unauthpathMap.put("/uacclient/uaclogin.jsp", 1);
            this.unauthpathMap.put("/uacclient/uaclogin3.jsp", 1);
            this.unauthpathMap.put("/uacclient/uaclogin4.jsp", 1);
            this.unauthpathMap.put("/uacclient/uacremotelogin.jsp", 1);
            this.unauthpathMap.put("/uacclient/uaclogout.jsp", 1);
            this.unauthpathMap.put("/uacclient/uaclogin_formaction.jsp", 1);
            this.unauthpathMap.put("/uacclient/uaclogin_gridaction.jsp", 1);
            this.unauthpathMap.put("/uacclient/uaclogin_pagemodel.jsp", 1);
            this.unauthpathMap.put("/uacclient/uaclogin_formaction2.jsp", 1);
            this.unauthpathMap.put("/uacclient/uaclogin_gridaction2.jsp", 1);
            this.unauthpathMap.put(this.strAuthPath, 1);
            if (this.strAuthPath.indexOf("http") != 0 && this.strAuthPath.indexOf("..") != 0) {
                this.strAuthPath = ".." + this.strAuthPath;
                this.strAuthPath = WebUtility.appendURLSeperator(this.strAuthPath);
                this.strAuthPath = String.valueOf(this.strAuthPath) + "RU=";
            }
            if (!StringHelper.isNullOrEmpty(strAuthServer = this.filterConfig.getInitParameter("AUTHSERVER"))) {
                String[] authServers;
                strAuthServer = strAuthServer.toUpperCase();
                String[] stringArray = authServers = strAuthServer.split("[|]");
                int n = authServers.length;
                int n2 = 0;
                while (n2 < n) {
                    String strAuthServerItem = stringArray[n2];
                    String strAuthPath = this.filterConfig.getInitParameter("AUTHPATH_" + strAuthServerItem.replace(".", "_"));
                    if (!StringHelper.isNullOrEmpty(strAuthPath)) {
                        if (strAuthPath.indexOf("http") != 0 && strAuthPath.indexOf("..") != 0) {
                            strAuthPath = ".." + strAuthPath;
                            strAuthPath = WebUtility.appendURLSeperator(strAuthPath);
                            strAuthPath = String.valueOf(strAuthPath) + "RU=";
                        }
                        this.authPathMap.put(strAuthServerItem, strAuthPath);
                    }
                    ++n2;
                }
            }
        }
    }

    class GlobalContext2
    extends GlobalContext {
        public GlobalContext2(ServletContext servletContext) {
            this.servletContext = servletContext;
        }

        public void setCurrent(IGlobalContext iGlobalContext) {
            GlobalContext.globalContext = iGlobalContext;
        }

        public void init() throws Exception {
            this.onInit();
        }
    }
}

