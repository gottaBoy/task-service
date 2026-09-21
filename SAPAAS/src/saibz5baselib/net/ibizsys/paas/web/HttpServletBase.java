/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.ServletException
 *  javax.servlet.http.HttpServlet
 *  javax.servlet.http.HttpServletRequest
 *  javax.servlet.http.HttpServletResponse
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.paas.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.ibizsys.paas.controller.ViewController;
import net.ibizsys.paas.ctrlhandler.CtrlHandler;
import net.ibizsys.paas.exception.ErrorException;
import net.ibizsys.paas.security.RemoteLoginGlobal;
import net.ibizsys.paas.service.SessionFactoryManager;
import net.ibizsys.paas.util.ObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.AjaxActionResult;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.paas.web.WebConfig;
import net.ibizsys.paas.web.WebContext;
import net.ibizsys.psrt.srv.common.entity.LoginLog;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class HttpServletBase
extends HttpServlet {
    private static final Log log = LogFactory.getLog(HttpServletBase.class);
    private ThreadLocal<SessionFactory> sessionFactory = new ThreadLocal();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.addTimeOutHeaders(response);
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json;charset=UTF-8");
        try {
            SessionFactoryManager.enter();
            IWebContext iWebContext = this.createWebContext(request, response);
            WebContext.setCurrent(iWebContext);
            AjaxActionResult ajaxActionResult = this.processAction();
            response.getWriter().print(ajaxActionResult.toJSONString());
            response.getWriter().flush();
            response.getWriter().close();
            this.resetCurrent();
            return;
        }
        catch (Exception ex) {
            log.error((Object)ex.getMessage(), (Throwable)ex);
            this.resetCurrent();
            AjaxActionResult ajaxActionResult = new AjaxActionResult();
            ajaxActionResult.setRetCode(1);
            ajaxActionResult.setErrorInfo(ex.getMessage());
            if (ex instanceof ErrorException) {
                ErrorException errorException = (ErrorException)ex;
                ajaxActionResult.setRetCode(errorException.getErrorCode());
            }
            response.getWriter().print(ajaxActionResult.toJSONString());
            response.getWriter().flush();
            response.getWriter().close();
            return;
        }
    }

    protected void resetCurrent() {
        this.setSessionFactory(null);
        WebContext.setCurrent(null);
        ViewController.setCurrent(null);
        CtrlHandler.setCurrent(null);
        SessionFactoryManager.leave();
    }

    public AjaxActionResult processAction() throws Exception {
        AjaxActionResult ajaxActionResult = this.onProcessAction();
        return ajaxActionResult;
    }

    protected AjaxActionResult onProcessAction() throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0");
    }

    protected void addTimeOutHeaders(HttpServletResponse response) {
        response.setDateHeader("Expires", System.currentTimeMillis());
    }

    public IWebContext getWebContext() {
        return WebContext.getCurrent();
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory.set(sessionFactory);
    }

    public SessionFactory getSessionFactory() {
        return this.sessionFactory.get();
    }

    protected IWebContext createWebContext(HttpServletRequest request, HttpServletResponse response) throws Exception {
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
}

