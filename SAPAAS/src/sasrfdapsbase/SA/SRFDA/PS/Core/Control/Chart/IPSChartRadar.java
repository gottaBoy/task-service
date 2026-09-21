/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Chart;

import SA.SRFDA.PS.Core.CodeList.IPSCodeList;
import SA.SRFDA.PS.Core.Control.Chart.IPSChartCoordinateSystemControl;
import SA.SRFDA.PS.Core.PSModelExtendMeta;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;

@PSModelInterfaceMeta(title="\u56fe\u8868\u96f7\u8fbe\u56fe\u5750\u6807\u7cfb\u7ec4\u4ef6\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", implement="PSDEChartRadarImpl")
@PSModelExtendMeta(typevalue={"radar"})
public interface IPSChartRadar
extends IPSChartCoordinateSystemControl {
    public IPSCodeList getIndicatorPSCodeList();
}

