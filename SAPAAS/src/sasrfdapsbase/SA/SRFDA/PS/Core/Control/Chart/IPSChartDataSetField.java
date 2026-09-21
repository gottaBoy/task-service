/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Chart;

import SA.SRFDA.PS.Core.CodeList.IPSCodeList;
import SA.SRFDA.PS.Core.Control.Chart.IPSChartDataSet;
import SA.SRFDA.PS.Core.Control.Chart.IPSChartObject;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;

@PSModelInterfaceMeta(title="\u56fe\u8868\u6570\u636e\u96c6\u5c5e\u6027\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", implement="PSDEChartDataSetFieldImpl")
public interface IPSChartDataSetField
extends IPSChartObject {
    public IPSCodeList getPSCodeList();

    public IPSChartDataSet getPSChartDataSet();

    public boolean isGroupField();

    public String getGroupMode();
}

