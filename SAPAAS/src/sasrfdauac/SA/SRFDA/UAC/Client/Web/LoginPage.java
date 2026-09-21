/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.WebEx.SRFExWebContext
 */
package SA.SRFDA.UAC.Client.Web;

import SA.SRFDA.UAC.Client.Web.BaseLoginPage;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.SRFExWebContext;
import org.jasig.cas.client.validation.Assertion;

public class LoginPage
extends BaseLoginPage {
    protected String strRedirectURL = "";

    protected void OnInitComponents() {
        super.OnInitComponents();
        try {
            Assertion assertion = null;
            Object objCAS = this.getRequest().getAttribute("_const_cas_assertion_");
            if (objCAS == null) {
                objCAS = this.getWebContext().GetSessionValue("_const_cas_assertion_");
            }
            if (objCAS != null && objCAS instanceof Assertion) {
                assertion = (Assertion)objCAS;
            }
            if (assertion == null) {
                this.getResponse().sendRedirect(this.getWebContext().GetParamValue("RU"));
                return;
            }
            String strLoginName = assertion.getPrincipal().getName();
            CallResult callResult = this.OnLoginUserName(strLoginName);
            if (callResult.IsError()) {
                this.strRedirectURL = this.getWebContext().getWebExConfig().GetValue("SRFUAC", "ERRORPATH", "");
                String strErrorInfo = callResult.getErrorInfo();
                if (StringHelper.IsNullOrEmpty((String)strErrorInfo)) {
                    strErrorInfo = "\u7528\u6237\u767b\u5f55\u5e10\u6237\u4e0d\u5b58\u5728\uff0c\u65e0\u6cd5\u767b\u5165\u7cfb\u7edf";
                }
                this.strRedirectURL = String.valueOf(this.strRedirectURL) + SRFExWebContext.EncodeURLParamValue((String)strErrorInfo);
            }
            if (!StringHelper.IsNullOrEmpty((String)this.strRedirectURL)) {
                this.getResponse().sendRedirect(this.strRedirectURL);
            } else {
                this.getResponse().sendRedirect(this.getWebContext().GetParamValue("RU"));
            }
            return;
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return;
        }
    }
}

