/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.App.View;

import SA.SRFDA.PS.Core.App.View.PSAppDEPickupViewImpl;
import SA.SRFDA.PS.Core.PSModelImplementMeta;

@PSModelImplementMeta(implement="IPSAppDEView", typevalues={"DEMPICKUPVIEW", "DEMPICKUPVIEW2"})
public class PSAppDEMPickupViewImpl
extends PSAppDEPickupViewImpl {
    @Override
    public boolean isEnableMultiSelect() {
        return true;
    }
}

