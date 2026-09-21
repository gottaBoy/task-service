/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.web.AjaxActionResult
 *  net.ibizsys.paas.web.IWebContext
 *  net.ibizsys.paas.web.WebContext
 *  net.ibizsys.sswf.api.SaaSWFActionParam
 *  net.ibizsys.sswf.entity.WFProxyEntity
 */
package net.ibizsys.ssdynawf.controller;

import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.AjaxActionResult;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.paas.web.WebContext;
import net.ibizsys.ssdynawf.controller.DynaWFViewControllerInstBase;
import net.ibizsys.sswf.api.SaaSWFActionParam;
import net.ibizsys.sswf.entity.WFProxyEntity;

public abstract class DynaWFProxyDataViewControllerInstBase
extends DynaWFViewControllerInstBase {
    @Override
    protected AjaxActionResult onLoadViewModel() throws Exception {
        AjaxActionResult ajaxActionResult = super.onLoadViewModel();
        if (ajaxActionResult.isError()) {
            return ajaxActionResult;
        }
        String strKey = WebContext.getKey((IWebContext)this.getWebContext());
        if (StringHelper.isNullOrEmpty((String)strKey)) {
            strKey = WebContext.getParentKey((IWebContext)this.getWebContext());
        }
        if (StringHelper.isNullOrEmpty((String)strKey)) {
            ajaxActionResult.setRetCode(4);
            return ajaxActionResult;
        }
        SaaSWFActionParam wfActionParam = new SaaSWFActionParam();
        wfActionParam.setUserData(strKey);
        wfActionParam.setUserData4(this.getDEModel().getId());
        wfActionParam.setWorkflowId(this.getWFModel().getId());
        WFProxyEntity wfProxyEntity = this.getDynaSysModel().getSaaSWFServiceUtil().getProxyEntity(wfActionParam);
        ajaxActionResult.setExtAttr("viewurl", (Object)wfProxyEntity.getViewUrl());
        return ajaxActionResult;
    }
}

