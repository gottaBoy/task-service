/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.ServletConfig
 *  javax.servlet.ServletException
 *  javax.servlet.http.HttpServletRequest
 *  javax.servlet.http.HttpServletResponse
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.util.WebUtility
 *  net.ibizsys.paas.web.HttpServletBase
 *  net.ibizsys.paas.web.IWebContext
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.psuac.web;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.util.WebUtility;
import net.ibizsys.paas.web.HttpServletBase;
import net.ibizsys.paas.web.IWebContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class LogoutServlet
extends HttpServletBase {
    private static final long serialVersionUID = 1L;
    private static final Log log = LogFactory.getLog(LogoutServlet.class);
    public static final String PARAM_LOGOUTURL = "LOGOUTURL";
    public static final String PARAM_LOGOUTURLWITHRU = "LOGOUTURLWITHRU";
    public static final String PARAM_SERVERNAME = "SERVERNAME";
    private String strLogoutUrl = null;
    private String strLogoutUrlWithRU = null;
    private String strServerName = null;

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        this.strServerName = config.getInitParameter(PARAM_SERVERNAME);
        this.strLogoutUrl = config.getInitParameter(PARAM_LOGOUTURL);
        if (StringHelper.isNullOrEmpty((String)this.strLogoutUrl)) {
            log.warn((Object)StringHelper.format((String)"\u6ca1\u6709\u5b9a\u4e49\u7edf\u4e00\u8ba4\u8bc1\u767b\u51fa\u5730\u5740\uff0c\u53ea\u80fd\u5b8c\u6210\u672c\u5730\u6ce8\u9500"));
        }
        this.strLogoutUrlWithRU = config.getInitParameter(PARAM_LOGOUTURLWITHRU);
        if (StringHelper.isNullOrEmpty((String)this.strLogoutUrlWithRU)) {
            log.warn((Object)StringHelper.format((String)"\u6ca1\u6709\u5b9a\u4e49\u7edf\u4e00\u8ba4\u8bc1\u767b\u51fa\u5730\u5740\uff08\u652f\u6301\u8fd4\u56de\uff09"));
            this.strLogoutUrlWithRU = this.strLogoutUrl;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.addTimeOutHeaders(response);
        try {
            IWebContext iWebContext = this.createWebContext(request, response);
            String strRU = iWebContext.getParamValue("RU");
            if (!StringHelper.isNullOrEmpty((String)strRU) && strRU.toLowerCase().indexOf("http") != 0) {
                if (strRU.indexOf("/") != 0) {
                    String path = strRU;
                    String servletPath = request.getServletPath();
                    String pathInfo = request.getPathInfo();
                    String requestPath = null;
                    requestPath = pathInfo == null ? servletPath : String.valueOf(servletPath) + pathInfo;
                    int pos = requestPath.lastIndexOf(47);
                    String relative = null;
                    relative = pos >= 0 ? String.valueOf(requestPath.substring(0, pos + 1)) + path : String.valueOf(requestPath) + path;
                    strRU = relative;
                }
                String strFile1 = new File(this.getServletContext().getRealPath("/")).getCanonicalPath();
                String strFile2 = this.getServletContext().getRealPath(strRU);
                strFile2 = new File(strFile2).getCanonicalPath();
                strFile2 = strFile2.substring(strFile1.length());
                strFile2 = strFile2.replace("\\", "/");
                strRU = String.valueOf(this.strServerName) + request.getContextPath() + strFile2;
            }
            this.logoutUser(iWebContext);
            if (StringHelper.isNullOrEmpty((String)strRU)) {
                response.sendRedirect(this.strLogoutUrl);
            } else {
                response.sendRedirect(String.valueOf(this.strLogoutUrlWithRU) + WebUtility.encodeURLParamValue((String)strRU));
            }
            return;
        }
        catch (Exception ex) {
            log.error((Object)ex.getMessage(), (Throwable)ex);
            return;
        }
    }

    protected void logoutUser(IWebContext iWebContext) throws Exception {
        iWebContext.logout(true);
    }
}

