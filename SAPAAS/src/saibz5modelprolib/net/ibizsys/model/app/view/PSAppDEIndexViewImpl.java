/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.app.view.IPSAppDEIndexView
 */
package net.ibizsys.model.app.view;

import net.ibizsys.model.app.view.IPSAppDEIndexView;
import net.ibizsys.model.app.view.PSAppDEXDataViewImpl;

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

    public boolean isShowDataInfoBar() {
        return this.bShowDataInfoBar;
    }

    @Override
    public boolean isEnableWF() {
        return this.getPSDEWF() != null;
    }

    @Override
    protected void onPreparePSAppViewParams() throws Exception {
        if (this.isShowDataInfoBar()) {
            this.registerPSAppViewParam("UI.SHOWDATAINFOBAR", "TRUE", "\u663e\u793a\u6570\u636e\u4fe1\u606f\u680f");
        }
        super.onPreparePSAppViewParams();
    }

    @Override
    public boolean isShowCaptionBar() {
        return this.isShowDataInfoBar() && super.isShowCaptionBar();
    }
}

