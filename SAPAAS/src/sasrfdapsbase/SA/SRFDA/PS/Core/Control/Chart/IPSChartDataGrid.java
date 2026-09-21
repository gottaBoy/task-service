/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Chart;

import SA.SRFDA.PS.Core.Control.Chart.IPSChartObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;

@PSModelInterfaceMeta(title="\u56fe\u8868\u90e8\u4ef6\u6570\u636e\u8868\u683c\u5bf9\u8c61\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSDEChart")
public interface IPSChartDataGrid
extends IPSChartObject {
    public static final String LDATAGRIDPOS_TOP = "TOP";
    public static final String LDATAGRIDPOS_BOTTOM = "BOTTOM";
    public static final String LDATAGRIDPOS_LEFT = "LEFT";
    public static final String LDATAGRIDPOS_RIGHT = "RIGHT";

    public boolean isShowDataGrid();

    public String getDataGridPos();
}

