/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.app.view;

import net.ibizsys.model.app.view.PSAppDEMobMDViewImpl;

public class PSAppDEMobPickupMDViewImpl
extends PSAppDEMobMDViewImpl {
    @Override
    protected void onInit() throws Exception {
        this.setEnableEditDataDefault(false);
        this.setEnableNewDataDefault(false);
        this.setEnableRemoveDataDefault(false);
        this.setEnableQuickSearchDefault(false);
        super.onInit();
    }

    @Override
    public boolean isPickupMode() {
        return true;
    }
}

