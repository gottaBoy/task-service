/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.ServletException
 *  javax.servlet.http.HttpServletRequest
 *  javax.servlet.http.HttpServletResponse
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.paas.web.util;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.util.WebUtility;
import net.ibizsys.paas.web.HttpServletBase;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.paas.web.WebContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class HttpRedirectServlet
extends HttpServletBase {
    private static final long serialVersionUID = 7486761561445169301L;
    private static final Log log = LogFactory.getLog(HttpRedirectServlet.class);
    private String strErrorUrl = "/ibizutil/404.html";
    private boolean bAppendUrlParam = true;
    private String strRedirectUrl = "";

    public void init() throws ServletException {
        this.strRedirectUrl = this.getInitParameter("REDIRECTURL");
        String strAppendUrlParam = this.getInitParameter("APPENDURLPARAM");
        if (StringHelper.compare(strAppendUrlParam, "FALSE", true) == 0) {
            this.bAppendUrlParam = false;
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.addTimeOutHeaders(response);
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json;charset=UTF-8");
        try {
            IWebContext iWebContext = this.createWebContext(request, response);
            WebContext.setCurrent(iWebContext);
            String strUrl = this.mapRealUrl(this.getRedirectUrl());
            String strQueryString = this.getWebContext().getQueryString();
            if (this.bAppendUrlParam && !StringHelper.isNullOrEmpty(strQueryString)) {
                strUrl = WebUtility.appendURLSeperator(strUrl);
                strUrl = String.valueOf(strUrl) + strQueryString;
            }
            this.resetCurrent();
            response.sendRedirect(strUrl);
            return;
        }
        catch (Exception ex) {
            String strUrl = this.mapRealUrl(this.getErrorUrl());
            log.error((Object)ex.getMessage(), (Throwable)ex);
            this.resetCurrent();
            response.sendRedirect(strUrl);
            return;
        }
    }

    protected String mapRealUrl(String strPageUrl) {
        String strContextPath;
        String strUrl = strPageUrl;
        IWebContext iWebContext = WebContext.getCurrent();
        if (strUrl.indexOf("http") == 0) {
            return strUrl;
        }
        if (iWebContext != null && iWebContext.getRequest() != null && !StringHelper.isNullOrEmpty(strContextPath = iWebContext.getRequest().getContextPath()) && strUrl.indexOf(strContextPath) != 0) {
            strUrl = StringHelper.format("%1$s%2$s", strContextPath, strUrl);
        }
        return strUrl;
    }

    protected String getRedirectUrl() {
        return this.strRedirectUrl;
    }

    protected String getErrorUrl() {
        return this.strErrorUrl;
    }
}

