/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.App.View;

import SA.SRFDA.PS.Core.App.View.PSAppDEMobListViewImpl;
import SA.SRFDA.PS.Core.PSModelImplementMeta;

@PSModelImplementMeta(implement="IPSAppDEView", typevalues={"DEMOBPICKUPLISTVIEW"})
public class PSAppDEMobPickupListViewImpl
extends PSAppDEMobListViewImpl {
    @Override
    protected void onInit() throws Exception {
        this.setEnableEditDataDefault(false);
        this.setEnableNewDataDefault(false);
        this.setEnableRemoveDataDefault(false);
        this.setEnableQuickSearchDefault(false);
        this.setExpandSearchFormDefault(true);
        super.onInit();
    }

    @Override
    public boolean isPickupMode() {
        return true;
    }
}

