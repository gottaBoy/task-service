/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.appmodel.IAppViewModel
 *  net.ibizsys.paas.controller.IRedirectViewController
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.util.WebUtility
 *  net.ibizsys.paas.web.VCPage
 *  net.sf.json.JSONObject
 */
package net.ibizsys.paas.web.jquery;

import net.ibizsys.paas.appmodel.IAppViewModel;
import net.ibizsys.paas.controller.IRedirectViewController;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.util.WebUtility;
import net.ibizsys.paas.web.VCPage;
import net.sf.json.JSONObject;

public class RedirectVCPage
extends VCPage {
    protected void onInit() throws Exception {
        super.onInit();
        String strKeyValue = this.getWebContext().getParamValue("srfkey");
        if (StringHelper.isNullOrEmpty((String)strKeyValue)) {
            strKeyValue = this.getWebContext().getParamValue("srfkeys");
        }
        if (StringHelper.isNullOrEmpty((String)strKeyValue)) {
            throw new Exception(StringHelper.format((String)"\u6ca1\u6709\u6307\u5b9a\u89c6\u56fe\u6570\u636e\u4e3b\u952e"));
        }
        IRedirectViewController iRedirectViewController = (IRedirectViewController)this.getViewController();
        IAppViewModel iAppViewModel = iRedirectViewController.getRDAppViewModel(strKeyValue);
        JSONObject rdview = this.getApplicationModel().getAppPFHelper().getAppViewJSONObject(iAppViewModel);
        String strViewUrl = rdview.optString("viewurl");
        if (strViewUrl.charAt(0) == '/') {
            strViewUrl = ".." + strViewUrl;
        }
        strViewUrl = WebUtility.appendURLSeperator((String)strViewUrl);
        strViewUrl = String.valueOf(strViewUrl) + this.getWebContext().getQueryString();
        this.getResponse().sendRedirect(strViewUrl);
    }
}

