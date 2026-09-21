/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Chart;

import SA.SRFDA.PS.Core.Control.Chart.IPSChartSeriesEncode;
import SA.SRFDA.PS.Core.Control.Chart.IPSDEChartObject;
import SA.SRFDA.PS.Core.Control.Chart.IPSDEChartSeries;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;

@PSModelInterfaceMeta(title="\u5b9e\u4f53\u56fe\u8868\u5e8f\u5217\u7f16\u7801\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3")
public interface IPSDEChartSeriesEncode
extends IPSChartSeriesEncode,
IPSDEChartObject {
    public IPSDEChartSeries getPSDEChartSeries();
}

