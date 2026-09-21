/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Chart;

import SA.SRFDA.PS.Core.Control.Chart.IPSChartCoordinateSystem;
import SA.SRFDA.PS.Core.Control.Chart.IPSChartParallel;
import SA.SRFDA.PS.Core.Control.Chart.IPSChartSeriesParallelSupportable;
import SA.SRFDA.PS.Core.PSModelExtendMeta;

@PSModelExtendMeta(title="\u56fe\u8868\u5e73\u884c\u5750\u6807\u7cfb\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", typevalue={"PARALLEL"}, description="\u5e73\u884c\u5750\u6807\u7cfb\uff08Parallel Coordinates\uff09 \u662f\u4e00\u79cd\u5e38\u7528\u7684\u53ef\u89c6\u5316\u9ad8\u7ef4\u6570\u636e\u7684\u56fe\u8868\u3002")
public interface IPSChartCoordinateSystemParallel
extends IPSChartCoordinateSystem,
IPSChartSeriesParallelSupportable {
    public IPSChartParallel getPSChartParallel();
}

