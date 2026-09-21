/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.CallResult
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.web.WebContext
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.jasig.cas.client.validation.Assertion
 */
package net.ibizsys.psuac.web;

import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.WebContext;
import net.ibizsys.psuac.web.LoginPageBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jasig.cas.client.validation.Assertion;

public class LoginPage
extends LoginPageBase {
    private static final Log log = LogFactory.getLog(LoginPage.class);
    protected String strRedirectURL = "";

    protected void onInit() throws Exception {
        super.onInit();
        try {
            Assertion assertion = null;
            Object objCAS = this.getRequest().getAttribute("_const_cas_assertion_");
            if (objCAS == null) {
                objCAS = this.getWebContext().getSessionValue("_const_cas_assertion_");
            }
            if (objCAS != null && objCAS instanceof Assertion) {
                assertion = (Assertion)objCAS;
            }
            if (assertion == null) {
                this.getResponse().sendRedirect(this.getWebContext().getParamValue("RU"));
                return;
            }
            String strLoginName = assertion.getPrincipal().getName();
            CallResult callResult = this.loginUserName(strLoginName);
            if (callResult.isError()) {
                this.strRedirectURL = "#";
                String strErrorInfo = callResult.getErrorInfo();
                if (StringHelper.isNullOrEmpty((String)strErrorInfo)) {
                    strErrorInfo = "\u7528\u6237\u767b\u5f55\u5e10\u6237\u4e0d\u5b58\u5728\uff0c\u65e0\u6cd5\u767b\u5165\u7cfb\u7edf";
                }
                this.strRedirectURL = String.valueOf(this.strRedirectURL) + WebContext.encodeURLParamValue((String)strErrorInfo);
            }
            if (!StringHelper.isNullOrEmpty((String)this.strRedirectURL)) {
                this.getResponse().sendRedirect(this.strRedirectURL);
            } else {
                this.getResponse().sendRedirect(this.getWebContext().getParamValue("RU"));
            }
            return;
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return;
        }
    }
}

