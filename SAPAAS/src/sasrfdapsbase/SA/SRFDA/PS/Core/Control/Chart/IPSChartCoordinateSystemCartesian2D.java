/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Chart;

import SA.SRFDA.PS.Core.Control.Chart.IPSChartCoordinateSystem;
import SA.SRFDA.PS.Core.Control.Chart.IPSChartGrid;
import SA.SRFDA.PS.Core.Control.Chart.IPSChartSeriesBarSupportable;
import SA.SRFDA.PS.Core.Control.Chart.IPSChartSeriesBoxplotSupportable;
import SA.SRFDA.PS.Core.Control.Chart.IPSChartSeriesCandlestickSupportable;
import SA.SRFDA.PS.Core.Control.Chart.IPSChartSeriesGraphSupportable;
import SA.SRFDA.PS.Core.Control.Chart.IPSChartSeriesHeatmapSupportable;
import SA.SRFDA.PS.Core.Control.Chart.IPSChartSeriesLineSupportable;
import SA.SRFDA.PS.Core.Control.Chart.IPSChartSeriesLinesSupportable;
import SA.SRFDA.PS.Core.Control.Chart.IPSChartSeriesPictorialBarSupportable;
import SA.SRFDA.PS.Core.Control.Chart.IPSChartSeriesScatterSupportable;
import SA.SRFDA.PS.Core.PSModelExtendMeta;

@PSModelExtendMeta(title="\u56fe\u8868\u4e8c\u7ef4\u7684\u76f4\u89d2\u5750\u6807\u7cfb\uff08\u4e5f\u79f0\u7b1b\u5361\u5c14\u5750\u6807\u7cfb\uff09\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", typevalue={"XY"})
public interface IPSChartCoordinateSystemCartesian2D
extends IPSChartCoordinateSystem,
IPSChartSeriesBoxplotSupportable,
IPSChartSeriesCandlestickSupportable,
IPSChartSeriesHeatmapSupportable,
IPSChartSeriesLinesSupportable,
IPSChartSeriesGraphSupportable,
IPSChartSeriesLineSupportable,
IPSChartSeriesScatterSupportable,
IPSChartSeriesPictorialBarSupportable,
IPSChartSeriesBarSupportable {
    public IPSChartGrid getPSChartGrid();
}

