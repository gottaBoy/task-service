/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.controller;

import net.ibizsys.paas.appmodel.IApplicationRuntime;
import net.ibizsys.paas.controller.ViewControllerBase;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.util.WebUtility;
import net.ibizsys.paas.web.AjaxActionResult;
import net.ibizsys.paas.web.WebContext;

public abstract class HtmlViewControllerBase
extends ViewControllerBase {
    public static final String VIEWPARAM_UI_HTMLURL = "UI.HTMLURL";
    public static final String VIEWPARAM_UI_HTMLURLKEY = "UI.HTMLURLKEY";

    @Override
    protected AjaxActionResult onLoadViewModel() throws Exception {
        String strHtmlUrl2;
        AjaxActionResult ajaxActionResult = super.onLoadViewModel();
        if (ajaxActionResult.isError()) {
            return ajaxActionResult;
        }
        String strKey = WebContext.getKey(this.getWebContext());
        if (StringHelper.isNullOrEmpty(strKey)) {
            strKey = WebContext.getKeys(this.getWebContext());
        }
        if (strKey == null) {
            strKey = "";
        }
        String strHtmlUrl = (String)this.getAttribute(VIEWPARAM_UI_HTMLURL);
        String strHtmlUrlKey = (String)this.getAttribute(VIEWPARAM_UI_HTMLURLKEY);
        if (!StringHelper.isNullOrEmpty(strHtmlUrlKey) && !StringHelper.isNullOrEmpty(strHtmlUrl2 = ((IApplicationRuntime)((Object)this.getAppModel())).getHtmlUrl(strHtmlUrlKey))) {
            strHtmlUrl = strHtmlUrl2;
        }
        if (!StringHelper.isNullOrEmpty(strHtmlUrl)) {
            strHtmlUrl = strHtmlUrl.replace("__SRFKEY__", WebUtility.encodeURLParamValue(strKey));
        }
        ajaxActionResult.setExtAttr("viewurl", strHtmlUrl);
        return ajaxActionResult;
    }
}

