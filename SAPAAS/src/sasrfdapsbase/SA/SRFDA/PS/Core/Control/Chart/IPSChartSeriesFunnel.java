/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Chart;

import SA.SRFDA.PS.Core.Control.Chart.IPSChartPosition;
import SA.SRFDA.PS.Core.Control.Chart.IPSChartSeriesCSNone;
import SA.SRFDA.PS.Core.PSModelExtendMeta;

@PSModelExtendMeta(title="\u56fe\u8868\u6f0f\u6597\u56fe\u5e8f\u5217\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", typevalue={"funnel"}, model="PSDEChartSeries")
public interface IPSChartSeriesFunnel
extends IPSChartSeriesCSNone,
IPSChartPosition {
    public String getFunnelAlign();

    public Integer getMinValue();

    public Integer getMaxValue();

    public Object getMaxSize();

    public Object getMinSize();
}

