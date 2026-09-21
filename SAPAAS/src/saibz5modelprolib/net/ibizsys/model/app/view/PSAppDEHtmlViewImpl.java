/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.app.view.IPSAppDEHtmlView
 *  net.ibizsys.paas.util.StringHelper
 */
package net.ibizsys.model.app.view;

import net.ibizsys.model.PSModelRTMeta;
import net.ibizsys.model.app.view.IPSAppDEHtmlView;
import net.ibizsys.model.app.view.PSAppDEViewImpl;
import net.ibizsys.paas.util.StringHelper;

public class PSAppDEHtmlViewImpl
extends PSAppDEViewImpl
implements IPSAppDEHtmlView {
    private String strHtmlUrl = null;

    @Override
    protected void onInit() throws Exception {
        this.strHtmlUrl = this.psViewBase.getBOTTOMINFO();
        super.onInit();
    }

    @PSModelRTMeta(description="Html\u8def\u5f84")
    public String getHtmlUrl() {
        return this.strHtmlUrl;
    }

    @Override
    protected void onPreparePSAppViewParams() throws Exception {
        if (!StringHelper.isNullOrEmpty((String)this.getHtmlUrl())) {
            this.registerPSAppViewParam("UI.HTMLURL", this.getHtmlUrl(), "Html\u9ed8\u8ba4\u8def\u5f84");
        }
        this.registerPSAppViewParam("UI.HTMLURLKEY", this.getFullCodeName().replace(".", "_").toUpperCase(), "Html\u8def\u5f84\u914d\u7f6e\u952e\u503c");
        super.onPreparePSAppViewParams();
    }
}

