/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Chart;

import SA.SRFDA.PS.Core.Control.Chart.IPSChartObject;
import SA.SRFDA.PS.Core.Control.Chart.IPSDEChart;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;

@PSModelInterfaceMeta(title="\u5b9e\u4f53\u56fe\u8868\u90e8\u4ef6\u76f8\u5173\u5bf9\u8c61\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3")
public interface IPSDEChartObject
extends IPSChartObject {
    public IPSDEChart getPSDEChart();
}

