/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.App.View;

import SA.SRFDA.PS.Core.App.View.IPSAppDEKanbanView;
import SA.SRFDA.PS.Core.App.View.PSAppDEMultiDataView2Impl;
import SA.SRFDA.PS.Core.PSModelImplementMeta;

@PSModelImplementMeta(implement="IPSAppDEView", typevalues={"DEKANBANVIEW", "DEKANBANVIEW9"})
public class PSAppDEKanbanViewImpl
extends PSAppDEMultiDataView2Impl
implements IPSAppDEKanbanView {
    @Override
    protected String onGetXDataControlName() {
        return "kanban";
    }
}

