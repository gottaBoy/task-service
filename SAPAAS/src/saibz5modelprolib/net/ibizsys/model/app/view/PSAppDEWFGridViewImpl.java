/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.app.view.IPSAppDEWFActionView
 */
package net.ibizsys.model.app.view;

import net.ibizsys.model.PSModelRTMeta;
import net.ibizsys.model.app.view.IPSAppDEWFActionView;
import net.ibizsys.model.app.view.PSAppDEGridViewImpl;

public class PSAppDEWFGridViewImpl
extends PSAppDEGridViewImpl
implements IPSAppDEWFActionView {
    @Override
    protected void onInit() throws Exception {
        if (!this.psViewBase.isWFVIEWPARAMNull()) {
            this.setWFIAMode(this.psViewBase.getWFVIEWPARAM());
        }
        this.setWFStepValue(this.psViewBase.getWFVIEWPARAM3());
        super.onInit();
    }

    @Override
    @PSModelRTMeta(description="\u542f\u7528\u6d41\u7a0b")
    public boolean isEnableWF() {
        return this.getPSDEWF() != null;
    }

    @Override
    @PSModelRTMeta(description="\u6d41\u7a0b\u4ea4\u4e92\u6a21\u5f0f")
    public boolean isWFIAMode() {
        return super.isWFIAMode();
    }

    @Override
    @PSModelRTMeta(description="\u7ed1\u5b9a\u6d41\u7a0b\u6b65\u9aa4\u503c", hideempty2=true)
    public String getWFStepValue() {
        return super.getWFStepValue();
    }
}

