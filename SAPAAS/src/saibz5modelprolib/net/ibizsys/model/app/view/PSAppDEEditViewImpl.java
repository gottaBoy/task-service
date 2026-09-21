/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.app.view.IPSAppDEEditView
 */
package net.ibizsys.model.app.view;

import net.ibizsys.model.PSModelRTMeta;
import net.ibizsys.model.app.view.IPSAppDEEditView;
import net.ibizsys.model.app.view.PSAppDEXDataViewImpl;

public class PSAppDEEditViewImpl
extends PSAppDEXDataViewImpl
implements IPSAppDEEditView {
    protected boolean bShowDataInfoBar = true;
    private boolean bHideEditForm = false;

    @Override
    protected void onInit() throws Exception {
        super.onInit();
        if (!this.psViewBase.isVIEWPARAM5Null()) {
            this.bShowDataInfoBar = this.psViewBase.getVIEWPARAM5();
        }
        if (!this.psViewBase.isVIEWPARAM6Null()) {
            this.bHideEditForm = this.psViewBase.getVIEWPARAM6();
        }
    }

    @PSModelRTMeta(description="\u662f\u5426\u663e\u793a\u4fe1\u606f\u680f")
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

    @PSModelRTMeta(description="\u662f\u5426\u9690\u85cf\u7f16\u8f91\u8868\u5355")
    public boolean isHideEditForm() {
        return this.bHideEditForm;
    }
}

