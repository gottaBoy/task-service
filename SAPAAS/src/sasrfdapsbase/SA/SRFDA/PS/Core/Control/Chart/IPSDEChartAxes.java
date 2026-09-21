/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.Control.Chart;

import SA.SRFDA.PS.Core.Control.Chart.IPSChartAxes;
import SA.SRFDA.PS.Core.Control.Chart.IPSDEChart;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Data.PSDEChartAxes;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

@PSModelInterfaceMeta(title="\u5b9e\u4f53\u56fe\u8868\u8f74\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSDEChartAxes")
public interface IPSDEChartAxes
extends IPSChartAxes {
    public void init(ISRFDAGlobalHelper var1, IPSDEChart var2, PSDEChartAxes var3) throws Exception;

    public IPSDEChart getPSDEChart();
}

