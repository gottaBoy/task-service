/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.App.View;

import SA.SRFDA.PS.Core.App.View.IPSAppDEMultiDataView;
import SA.SRFDA.PS.Core.App.View.IPSAppDEWFView;
import SA.SRFDA.PS.Core.PSModelExtendMeta;

@PSModelExtendMeta(title="\u5e94\u7528\u5b9e\u4f53\u8868\u683c\u89c6\u56fe\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", typevalue={"DEGRIDVIEW", "DEGRIDVIEW2", "DEGRIDVIEW4"})
public interface IPSAppDEGridView
extends IPSAppDEMultiDataView,
IPSAppDEWFView {
    public static final String CONTROL_GRID = "grid";

    public boolean isEnableRowEdit();

    public boolean isDbClickEditData();

    public int getGridRowActiveMode();

    public boolean isRowEditDefault();
}

