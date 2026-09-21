/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Chart;

import SA.SRFDA.PS.Core.Control.Chart.IPSChartCoordinateSystemControl;
import SA.SRFDA.PS.Core.Control.Chart.IPSChartGridXAxis;
import SA.SRFDA.PS.Core.Control.Chart.IPSChartGridYAxis;
import SA.SRFDA.PS.Core.Control.Chart.IPSChartPosition;
import SA.SRFDA.PS.Core.Control.Chart.IPSChartXAxis;
import SA.SRFDA.PS.Core.Control.Chart.IPSChartYAxis;
import SA.SRFDA.PS.Core.PSModelExtendMeta;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import java.util.Iterator;

@PSModelInterfaceMeta(title="\u56fe\u8868\u5750\u6807\u7cfb\u5185\u7ed8\u56fe\u7f51\u683c\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", implement="PSDEChartGridImpl", description="\u5355\u4e2a grid \u5185\u6700\u591a\u53ef\u4ee5\u653e\u7f6e\u4e0a\u4e0b\u4e24\u4e2a X \u8f74\uff0c\u5de6\u53f3\u4e24\u4e2a Y \u8f74\u3002\u53ef\u4ee5\u5728\u7f51\u683c\u4e0a\u7ed8\u5236\u6298\u7ebf\u56fe\uff0c\u67f1\u72b6\u56fe\uff0c\u6563\u70b9\u56fe\uff08\u6c14\u6ce1\u56fe\uff09\u3002")
@PSModelExtendMeta(typevalue={"grid"})
public interface IPSChartGrid
extends IPSChartCoordinateSystemControl,
IPSChartPosition {
    public IPSChartGridXAxis getPSChartGridXAxis0();

    public IPSChartGridXAxis getPSChartGridXAxis1();

    public IPSChartGridYAxis getPSChartGridYAxis0();

    public IPSChartGridYAxis getPSChartGridYAxis1();

    public Iterator<? extends IPSChartXAxis> getPSChartXAxises();

    public Iterator<? extends IPSChartYAxis> getPSChartYAxises();
}

