/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.App.View;

import SA.SRFDA.PS.Core.App.View.IPSAppDEDataView;
import SA.SRFDA.PS.Core.App.View.PSAppDEMultiDataView2Impl;
import SA.SRFDA.PS.Core.PSModelImplementMeta;

@PSModelImplementMeta(implement="IPSAppDEView", typevalues={"DEDATAVIEW", "DEDATAVIEW9"})
public class PSAppDEDataViewImpl
extends PSAppDEMultiDataView2Impl
implements IPSAppDEDataView {
    @Override
    protected String onGetXDataControlName() {
        return "dataview";
    }
}

