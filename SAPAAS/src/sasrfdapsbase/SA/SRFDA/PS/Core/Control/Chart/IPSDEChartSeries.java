/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.Control.Chart;

import SA.SRFDA.PS.Core.Control.Chart.IPSChartSeries;
import SA.SRFDA.PS.Core.Control.Chart.IPSDEChart;
import SA.SRFDA.PS.Core.Control.Chart.IPSDEChartAxes;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Data.PSDEChartSeries;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

@PSModelInterfaceMeta(title="\u5b9e\u4f53\u56fe\u8868\u6570\u636e\u5e8f\u5217\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", typefield="seriesType", model="PSDEChartSeries")
public interface IPSDEChartSeries
extends IPSChartSeries {
    public void init(ISRFDAGlobalHelper var1, IPSDEChart var2, PSDEChartSeries var3) throws Exception;

    public IPSDEChart getPSDEChart();

    public IPSDEChartAxes getXPSDEChartAxes();

    public IPSDEChartAxes getYPSDEChartAxes();

    public String getSampleData();
}

