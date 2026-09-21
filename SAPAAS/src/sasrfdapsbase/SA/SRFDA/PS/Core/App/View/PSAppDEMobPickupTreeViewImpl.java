/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.App.View;

import SA.SRFDA.PS.Core.App.View.PSAppDEMobTreeViewImpl;
import SA.SRFDA.PS.Core.PSModelImplementMeta;

@PSModelImplementMeta(implement="IPSAppDEView", typevalues={"DEMOBPICKUPTREEVIEW"})
public class PSAppDEMobPickupTreeViewImpl
extends PSAppDEMobTreeViewImpl {
    @Override
    protected void onInit() throws Exception {
        this.setEnableEditDataDefault(false);
        this.setEnableNewDataDefault(false);
        this.setEnableRemoveDataDefault(false);
        this.setExpandSearchFormDefault(true);
        super.onInit();
    }

    @Override
    public boolean isPickupMode() {
        return true;
    }
}

