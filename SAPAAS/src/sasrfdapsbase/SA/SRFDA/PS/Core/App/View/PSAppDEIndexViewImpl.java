/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.App.View;

import SA.SRFDA.PS.Core.App.View.IPSAppDEIndexView;
import SA.SRFDA.PS.Core.App.View.PSAppDEXDataViewImpl;
import SA.SRFDA.PS.Core.PSModelImplementMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;

@PSModelImplementMeta(implement="IPSAppDEView", typevalues={"DEINDEXVIEW"})
public class PSAppDEIndexViewImpl
extends PSAppDEXDataViewImpl
implements IPSAppDEIndexView {
    protected boolean bShowDataInfoBar = true;

    @Override
    protected void onInit() throws Exception {
        super.onInit();
        if (!this.psViewBase.isVIEWPARAM5Null()) {
            this.bShowDataInfoBar = this.psViewBase.getVIEWPARAM5();
        }
    }

    @Override
    public boolean isShowDataInfoBar() {
        return this.bShowDataInfoBar;
    }

    @Override
    public boolean isEnableWF() {
        return this.getPSDEWF() != null;
    }

    @Override
    protected void onPreparePSAppViewParams() throws Exception {
        if (!this.isPrepareTemplV2logic() && this.isShowDataInfoBar()) {
            this.registerPSAppViewParam("UI.SHOWDATAINFOBAR", "TRUE", "\u663e\u793a\u6570\u636e\u4fe1\u606f\u680f");
        }
        super.onPreparePSAppViewParams();
    }

    @Override
    @PSModelRTMeta(description="\u663e\u793a\u6807\u9898\u680f", ignoredumpvalues="true")
    public boolean isShowCaptionBar() {
        return this.isShowDataInfoBar() && super.isShowCaptionBar();
    }

    @Override
    @PSModelRTMeta(description="\u6253\u5f00\u6570\u636e\u6a21\u5f0f", codelist="EditViewMarkOpenDataMode", fields={"VIEWPARAM13"})
    public String getMarkOpenDataMode() {
        return this.psViewBase.getVIEWPARAM13();
    }
}

