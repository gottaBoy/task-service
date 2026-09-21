/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.web;

import net.ibizsys.paas.core.ActionContext;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.AjaxActionResult;
import net.ibizsys.paas.web.IAjaxActionContext;
import net.ibizsys.paas.web.IWebContext;

public class AjaxActionContext
extends ActionContext
implements IAjaxActionContext {
    protected AjaxActionResult ajaxActionResult = new AjaxActionResult();

    public AjaxActionContext(IWebContext iWebContext) {
        super(iWebContext);
    }

    @Override
    public String getCtrlId() {
        return this.getRequestParam("SRFCTRLID");
    }

    @Override
    public String getAction() {
        return this.getRequestParam("SRFACTION");
    }

    @Override
    public String getRequestParam(String strParam) {
        String strValue = this.getWebContext().getPostValue(strParam.toLowerCase());
        if (strValue == null) {
            strValue = this.getWebContext().getParamValue(strParam);
        }
        if (StringHelper.isNullOrEmpty(strValue)) {
            return null;
        }
        return strValue;
    }

    @Override
    public void setCurAjaxActionResult(AjaxActionResult ajaxActionResult) {
        this.ajaxActionResult = ajaxActionResult;
    }

    @Override
    public AjaxActionResult getCurAjaxActionResult() {
        return this.ajaxActionResult;
    }
}

