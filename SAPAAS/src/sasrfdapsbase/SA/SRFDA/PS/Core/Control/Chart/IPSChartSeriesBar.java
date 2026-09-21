/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Chart;

import SA.SRFDA.PS.Core.Control.Chart.IPSChartSeries;
import SA.SRFDA.PS.Core.PSModelExtendMeta;

@PSModelExtendMeta(title="\u56fe\u8868\u67f1\u72b6/\u6761\u5f62\u56fe\u6570\u636e\u5e8f\u5217\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", typevalue={"bar", "bar3d", "column"}, model="PSDEChartSeries")
public interface IPSChartSeriesBar
extends IPSChartSeries {
    public Object getBarWidth();

    public Object getBarMaxWidth();

    public Object getBarMinWidth();

    public Integer getBarMinHeight();

    public Object getBarGap();

    public Object getBarCategoryGap();

    public boolean isStack();
}

