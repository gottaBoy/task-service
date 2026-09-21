/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Chart;

import SA.SRFDA.PS.Core.Control.Chart.IPSChartCoordinateSystemControl;
import SA.SRFDA.PS.Core.Control.Chart.IPSChartParallelAxis;
import SA.SRFDA.PS.Core.Control.Chart.IPSChartPosition;
import SA.SRFDA.PS.Core.PSModelExtendMeta;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import java.util.Iterator;

@PSModelInterfaceMeta(title="\u56fe\u8868\u5e73\u884c\u5750\u6807\u7cfb\u7ec4\u4ef6\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", implement="PSDEChartParallelImpl")
@PSModelExtendMeta(typevalue={"parallel"})
public interface IPSChartParallel
extends IPSChartCoordinateSystemControl,
IPSChartPosition {
    public Iterator<IPSChartParallelAxis> getPSChartParallelAxises();
}

