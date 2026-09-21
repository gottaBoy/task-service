/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Chart;

import SA.SRFDA.PS.Core.Control.Chart.IPSChartSeries;
import SA.SRFDA.PS.Core.PSModelExtendMeta;

@PSModelExtendMeta(title="\u56fe\u8868\u4eea\u8868\u76d8\u5e8f\u5217\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", typevalue={"gauge"}, model="PSDEChartSeries")
public interface IPSChartSeriesGauge
extends IPSChartSeries {
    public Object getRadius();

    public Integer getStartAngle();

    public Integer getEndAngle();

    public boolean isClockwise();

    public Integer getMinValue();

    public Integer getMaxValue();

    public Integer getSplitNumber();
}

