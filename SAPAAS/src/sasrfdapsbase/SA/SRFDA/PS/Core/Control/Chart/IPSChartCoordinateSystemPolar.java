/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Chart;

import SA.SRFDA.PS.Core.Control.Chart.IPSChartCoordinateSystem;
import SA.SRFDA.PS.Core.Control.Chart.IPSChartPolar;
import SA.SRFDA.PS.Core.Control.Chart.IPSChartSeriesGraphSupportable;
import SA.SRFDA.PS.Core.Control.Chart.IPSChartSeriesLineSupportable;
import SA.SRFDA.PS.Core.Control.Chart.IPSChartSeriesScatterSupportable;
import SA.SRFDA.PS.Core.PSModelExtendMeta;

@PSModelExtendMeta(title="\u56fe\u8868\u6781\u5750\u6807\u7cfb\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", typevalue={"POLAR"}, description="\u53ef\u4ee5\u7528\u4e8e\u6563\u70b9\u56fe\u548c\u6298\u7ebf\u56fe\u3002\u6bcf\u4e2a\u6781\u5750\u6807\u7cfb\u62e5\u6709\u4e00\u4e2a\u89d2\u5ea6\u8f74\u548c\u4e00\u4e2a\u534a\u5f84\u8f74\u3002")
public interface IPSChartCoordinateSystemPolar
extends IPSChartCoordinateSystem,
IPSChartSeriesLineSupportable,
IPSChartSeriesScatterSupportable,
IPSChartSeriesGraphSupportable {
    public IPSChartPolar getPSChartPolar();
}

