/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Chart;

import SA.SRFDA.PS.Core.Control.Chart.IPSChartCoordinateSystem;
import SA.SRFDA.PS.Core.Control.Chart.IPSChartGeo;
import SA.SRFDA.PS.Core.Control.Chart.IPSChartSeriesGraphSupportable;
import SA.SRFDA.PS.Core.Control.Chart.IPSChartSeriesHeatmapSupportable;
import SA.SRFDA.PS.Core.Control.Chart.IPSChartSeriesLinesSupportable;
import SA.SRFDA.PS.Core.Control.Chart.IPSChartSeriesMapSupportable;
import SA.SRFDA.PS.Core.Control.Chart.IPSChartSeriesScatterSupportable;
import SA.SRFDA.PS.Core.PSModelExtendMeta;

@PSModelExtendMeta(title="\u56fe\u8868\u5730\u7406\u5750\u6807\u7cfb\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", typevalue={"MAP"}, description="\u5730\u7406\u5750\u6807\u7cfb\u7ec4\u4ef6\u7528\u4e8e\u5730\u56fe\u7684\u7ed8\u5236\uff0c\u652f\u6301\u5728\u5730\u7406\u5750\u6807\u7cfb\u4e0a\u7ed8\u5236\u6563\u70b9\u56fe\uff0c\u7ebf\u96c6\u3002")
public interface IPSChartCoordinateSystemGeo
extends IPSChartCoordinateSystem,
IPSChartSeriesScatterSupportable,
IPSChartSeriesHeatmapSupportable,
IPSChartSeriesLinesSupportable,
IPSChartSeriesGraphSupportable,
IPSChartSeriesMapSupportable {
    public IPSChartGeo getPSChartGeo();
}

