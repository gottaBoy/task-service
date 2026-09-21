/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.app.view.IPSAppDEMobWFMDView
 *  net.ibizsys.model.app.view.IPSAppDEWFActionView
 */
package net.ibizsys.model.app.view;

import net.ibizsys.model.app.view.IPSAppDEMobWFMDView;
import net.ibizsys.model.app.view.IPSAppDEWFActionView;
import net.ibizsys.model.app.view.PSAppDEMobMDViewImpl;

public class PSAppDEMobWFMDViewImpl
extends PSAppDEMobMDViewImpl
implements IPSAppDEWFActionView,
IPSAppDEMobWFMDView {
    @Override
    protected void onInit() throws Exception {
        if (!this.psViewBase.isWFVIEWPARAMNull()) {
            this.setWFIAMode(this.psViewBase.getWFVIEWPARAM());
        }
        this.setWFStepValue(this.psViewBase.getWFVIEWPARAM3());
        super.onInit();
    }

    @Override
    public boolean isEnableWF() {
        return this.getPSDEWF() != null;
    }
}

