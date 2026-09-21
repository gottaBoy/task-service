/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.ExpBar;

import SA.SRFDA.PS.Core.Control.Chart.IPSDEChart;
import SA.SRFDA.PS.Core.Control.ExpBar.IPSExpBar;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;

@PSModelInterfaceMeta(title="\u56fe\u8868\u5bfc\u822a\u680f\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3")
public interface IPSChartExpBar
extends IPSExpBar {
    public IPSDEChart getPSDEChart();
}

