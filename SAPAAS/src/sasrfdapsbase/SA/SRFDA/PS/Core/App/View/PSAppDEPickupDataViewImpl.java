/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.App.View;

import SA.SRFDA.PS.Core.App.View.PSAppDEDataViewImpl;
import SA.SRFDA.PS.Core.PSModelImplementMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;

@PSModelImplementMeta(implement="IPSAppDEView", typevalues={"DEPICKUPDATAVIEW"})
public class PSAppDEPickupDataViewImpl
extends PSAppDEDataViewImpl {
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

