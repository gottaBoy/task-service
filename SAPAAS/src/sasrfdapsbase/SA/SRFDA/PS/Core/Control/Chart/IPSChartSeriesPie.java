/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Chart;

import SA.SRFDA.PS.Core.Control.Chart.IPSChartPosition;
import SA.SRFDA.PS.Core.Control.Chart.IPSChartSeriesCSNone;
import SA.SRFDA.PS.Core.PSModelExtendMeta;

@PSModelExtendMeta(title="\u56fe\u8868\u997c\u56fe\u5e8f\u5217\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", typevalue={"pie", "pie3d"}, model="PSDEChartAxes")
public interface IPSChartSeriesPie
extends IPSChartSeriesCSNone,
IPSChartPosition {
    public Object getCenter();

    public Object getRadius();

    public Integer getStartAngle();

    public Integer getMinAngle();

    public Integer getMinShowLabelAngle();

    public Object getRoseType();
}

