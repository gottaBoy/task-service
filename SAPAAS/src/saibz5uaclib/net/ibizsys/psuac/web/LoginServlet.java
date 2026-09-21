/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.ServletException
 *  javax.servlet.http.HttpServletRequest
 *  javax.servlet.http.HttpServletResponse
 *  net.ibizsys.paas.core.CallResult
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.web.IWebContext
 *  net.ibizsys.paas.web.WebContext
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.jasig.cas.client.validation.Assertion
 */
package net.ibizsys.psuac.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.paas.web.WebContext;
import net.ibizsys.psuac.web.LoginPage;
import net.ibizsys.psuac.web.LoginServletBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jasig.cas.client.validation.Assertion;

public class LoginServlet
extends LoginServletBase {
    private static final Log log = LogFactory.getLog(LoginPage.class);

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String strRedirectURL = "";
        try {
            IWebContext iWebContext = this.createWebContext(request, response);
            WebContext.setCurrent((IWebContext)iWebContext);
            Assertion assertion = null;
            Object objCAS = request.getAttribute("_const_cas_assertion_");
            if (objCAS == null) {
                objCAS = this.getWebContext().getSessionValue("_const_cas_assertion_");
            }
            if (objCAS != null && objCAS instanceof Assertion) {
                assertion = (Assertion)objCAS;
            }
            if (assertion == null) {
                response.sendRedirect(this.getWebContext().getParamValue("RU"));
                return;
            }
            String strLoginName = assertion.getPrincipal().getName();
            CallResult callResult = this.loginUserName(strLoginName);
            if (callResult.isError()) {
                strRedirectURL = "#";
                String strErrorInfo = callResult.getErrorInfo();
                if (StringHelper.isNullOrEmpty((String)strErrorInfo)) {
                    strErrorInfo = "\u7528\u6237\u767b\u5f55\u5e10\u6237\u4e0d\u5b58\u5728\uff0c\u65e0\u6cd5\u767b\u5165\u7cfb\u7edf";
                }
                strRedirectURL = String.valueOf(strRedirectURL) + WebContext.encodeURLParamValue((String)strErrorInfo);
            }
            if (!StringHelper.isNullOrEmpty((String)strRedirectURL)) {
                response.sendRedirect(strRedirectURL);
            } else {
                response.sendRedirect(this.getWebContext().getParamValue("RU"));
            }
            return;
        }
        catch (Exception ex) {
            log.error((Object)ex);
            return;
        }
    }
}

