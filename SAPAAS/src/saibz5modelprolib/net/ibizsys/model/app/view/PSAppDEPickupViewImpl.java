/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.app.view.IPSAppDEPickupView
 */
package net.ibizsys.model.app.view;

import net.ibizsys.model.app.view.IPSAppDEPickupView;
import net.ibizsys.model.app.view.PSAppDEViewImpl;

public class PSAppDEPickupViewImpl
extends PSAppDEViewImpl
implements IPSAppDEPickupView {
    public static final String CTRL_PICKUPVIEWPANEL = "PICKUPVIEWPANEL";
    private boolean bConvertPickupData = false;

    @Override
    protected void onInit() throws Exception {
        if (!this.psViewBase.isVIEWPARAM5Null()) {
            this.bConvertPickupData = this.psViewBase.getVIEWPARAM5();
        }
        super.onInit();
    }

    public boolean isEnableMultiSelect() {
        return false;
    }

    @Override
    public boolean isPickupView() {
        return true;
    }

    public boolean isConvertPickupData() {
        return this.bConvertPickupData;
    }
}

