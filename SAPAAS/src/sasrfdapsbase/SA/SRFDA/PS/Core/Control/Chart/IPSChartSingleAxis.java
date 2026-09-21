/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Chart;

import SA.SRFDA.PS.Core.Control.Chart.IPSChartAxis;
import SA.SRFDA.PS.Core.Control.Chart.IPSChartSingle;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;

@PSModelInterfaceMeta(title="\u56fe\u8868\u5355\u8f74\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", implement="PSDEChartSingleAxisImpl")
public interface IPSChartSingleAxis
extends IPSChartAxis {
    public IPSChartSingle getPSChartSingle();
}

