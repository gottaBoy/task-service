/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.app.view;

import net.ibizsys.model.app.view.PSAppDEMobListViewImpl;

public class PSAppDEMobPickupListViewImpl
extends PSAppDEMobListViewImpl {
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

