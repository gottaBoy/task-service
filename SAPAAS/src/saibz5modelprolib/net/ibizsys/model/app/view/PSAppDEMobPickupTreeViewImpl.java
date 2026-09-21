/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.app.view;

import net.ibizsys.model.app.view.PSAppDEMobTreeViewImpl;

public class PSAppDEMobPickupTreeViewImpl
extends PSAppDEMobTreeViewImpl {
    @Override
    protected void onInit() throws Exception {
        this.setEnableEditDataDefault(false);
        this.setEnableNewDataDefault(false);
        this.setEnableRemoveDataDefault(false);
        super.onInit();
    }

    @Override
    public boolean isPickupMode() {
        return true;
    }
}

