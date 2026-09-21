/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.App.View;

import SA.SRFDA.PS.Core.App.View.IPSAppDEListView;
import SA.SRFDA.PS.Core.App.View.PSAppDEMultiDataView2Impl;
import SA.SRFDA.PS.Core.PSModelImplementMeta;

@PSModelImplementMeta(implement="IPSAppDEView", typevalues={"DELISTVIEW", "DELISTVIEW9"})
public class PSAppDEListViewImpl
extends PSAppDEMultiDataView2Impl
implements IPSAppDEListView {
    @Override
    protected void onInit() throws Exception {
        super.onInit();
    }

    @Override
    protected String onGetXDataControlName() {
        return "list";
    }
}

