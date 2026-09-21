/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.appmodel.IAppViewModel
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.util.WebUtility
 *  net.ibizsys.paas.web.AjaxActionResult
 *  net.ibizsys.pswf.web.util.WFRedirectPage
 *  net.sf.json.JSONObject
 */
package net.ibizsys.paas.web.jquery;

import net.ibizsys.paas.appmodel.IAppViewModel;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.util.WebUtility;
import net.ibizsys.paas.web.AjaxActionResult;
import net.sf.json.JSONObject;

public class WFRedirectPage
extends net.ibizsys.pswf.web.util.WFRedirectPage {
    protected void sendBackAppViewModel(IAppViewModel iAppViewModel) throws Exception {
        JSONObject rdview = this.getApplicationModel().getAppPFHelper().getAppViewJSONObject(iAppViewModel);
        if (StringHelper.compare((String)this.getRequest().getMethod(), (String)"POST", (boolean)true) == 0) {
            AjaxActionResult ajaxActionResult = new AjaxActionResult();
            ajaxActionResult.setExtAttr("rdview", (Object)rdview);
            this.getWriter().write(ajaxActionResult.toJSONString());
            return;
        }
        String strViewUrl = rdview.optString("viewurl");
        if (strViewUrl.charAt(0) == '/') {
            strViewUrl = "../jsp" + strViewUrl;
        }
        strViewUrl = WebUtility.appendURLSeperator((String)strViewUrl);
        strViewUrl = String.valueOf(strViewUrl) + this.getWebContext().getQueryString();
        this.getResponse().sendRedirect(strViewUrl);
    }
}

