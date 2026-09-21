/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.app.view;

import net.ibizsys.model.PSModelRTMeta;
import net.ibizsys.model.app.view.PSAppDETreeViewImpl;

public class PSAppDEPickupTreeViewImpl
extends PSAppDETreeViewImpl {
    @Override
    protected void onInit() throws Exception {
        this.setEnableEditDataDefault(false);
        this.setEnableNewDataDefault(false);
        this.setEnableRemoveDataDefault(false);
        super.onInit();
    }

    @Override
    public boolean isEnableQuickSearch() {
        return false;
    }

    @Override
    @PSModelRTMeta(description="\u9009\u62e9\u89c6\u56fe")
    public boolean isPickupMode() {
        return true;
    }

    @Override
    public String getNewDataMode() {
        return super.getNewDataMode();
    }

    @Override
    public String getEditDataMode() {
        return super.getEditDataMode();
    }
}

