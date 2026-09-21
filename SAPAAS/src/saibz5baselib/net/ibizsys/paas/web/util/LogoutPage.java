/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.web.util;

import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.Page;

public class LogoutPage
extends Page {
    @Override
    protected void onInit() throws Exception {
        super.onInit();
        String strRetUrl = this.getWebContext().getParamValue("RU");
        this.getWebContext().logout(true);
        if (StringHelper.isNullOrEmpty(strRetUrl)) {
            strRetUrl = this.getApplicationModel().getUtilPageUrl("LOGIN");
            strRetUrl = this.mapRealPageUrl(strRetUrl);
        }
        this.getResponse().sendRedirect(strRetUrl);
    }

    @Override
    protected String mapRealPageUrl(String strPageUrl) throws Exception {
        if (strPageUrl.charAt(0) == '/') {
            return ".." + strPageUrl;
        }
        return strPageUrl;
    }
}

