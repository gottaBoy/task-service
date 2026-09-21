/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Chart;

import SA.SRFDA.PS.Core.Control.Chart.IPSChartCoordinateSystem;
import SA.SRFDA.PS.Core.Control.Chart.IPSChartRadar;
import SA.SRFDA.PS.Core.Control.Chart.IPSChartSeriesRadarSupportable;
import SA.SRFDA.PS.Core.PSModelExtendMeta;

@PSModelExtendMeta(title="\u56fe\u8868\u96f7\u8fbe\u56fe\u5750\u6807\u7cfb\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", typevalue={"RADAR"}, description="\u96f7\u8fbe\u56fe\u5750\u6807\u7cfb\u7ec4\u4ef6\uff0c\u53ea\u9002\u7528\u4e8e\u96f7\u8fbe\u56fe\u3002")
public interface IPSChartCoordinateSystemRadar
extends IPSChartCoordinateSystem,
IPSChartSeriesRadarSupportable {
    public IPSChartRadar getPSChartRadar();
}

