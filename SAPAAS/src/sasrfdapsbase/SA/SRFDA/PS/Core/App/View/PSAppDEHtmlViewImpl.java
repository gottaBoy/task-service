/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.App.View;

import SA.SRFDA.PS.Core.App.View.IPSAppDEHtmlView;
import SA.SRFDA.PS.Core.App.View.PSAppDEViewImpl;
import SA.SRFDA.PS.Core.PSModelImplementMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import net.ibizsys.paas.util.StringHelper;

@PSModelImplementMeta(implement="IPSAppDEView", typevalues={"DEHTMLVIEW"})
public class PSAppDEHtmlViewImpl
extends PSAppDEViewImpl
implements IPSAppDEHtmlView {
    private String strHtmlUrl = null;
    private boolean bLoadDefault = true;

    @Override
    protected void onInit() throws Exception {
        this.strHtmlUrl = this.psViewBase.getBOTTOMINFO();
        this.bLoadDefault = !this.psViewBase.isLOADDEFAULTNull() ? this.psViewBase.getLOADDEFAULT() : this.isLoadDefaultDefault();
        super.onInit();
    }

    @Override
    @PSModelRTMeta(description="Html\u8def\u5f84")
    public String getHtmlUrl() {
        return this.strHtmlUrl;
    }

    @Override
    protected void onPreparePSAppViewParams() throws Exception {
        if (!this.isPrepareTemplV2logic()) {
            if (!StringHelper.isNullOrEmpty((String)this.getHtmlUrl())) {
                this.registerPSAppViewParam("UI.HTMLURL", this.getHtmlUrl(), "Html\u9ed8\u8ba4\u8def\u5f84");
            }
            this.registerPSAppViewParam("UI.HTMLURLKEY", this.getFullCodeName().replace(".", "_").toUpperCase(), "Html\u8def\u5f84\u914d\u7f6e\u952e\u503c");
        }
        super.onPreparePSAppViewParams();
    }

    @Override
    @PSModelRTMeta(description="\u9ed8\u8ba4\u52a0\u8f7d\u6570\u636e")
    public boolean isLoadDefault() {
        return this.bLoadDefault;
    }

    protected boolean isLoadDefaultDefault() {
        return true;
    }
}

