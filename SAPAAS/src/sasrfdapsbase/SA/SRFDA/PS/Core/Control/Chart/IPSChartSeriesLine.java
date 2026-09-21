/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Chart;

import SA.SRFDA.PS.Core.Control.Chart.IPSChartSeries;
import SA.SRFDA.PS.Core.PSModelExtendMeta;

@PSModelExtendMeta(title="\u56fe\u8868\u6298\u7ebf/\u9762\u79ef\u56fe\u5e8f\u5217\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", typevalue={"area", "line"}, model="PSDEChartSeries")
public interface IPSChartSeriesLine
extends IPSChartSeries {
    public boolean isStack();

    public Object getStep();
}

