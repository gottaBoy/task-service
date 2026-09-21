/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Chart;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEField;
import SA.SRFDA.PS.Core.Control.Chart.IPSChart;
import SA.SRFDA.PS.Core.Control.Chart.IPSDEChartAxes;
import SA.SRFDA.PS.Core.Control.Chart.IPSDEChartDataGrid;
import SA.SRFDA.PS.Core.Control.Chart.IPSDEChartLegend;
import SA.SRFDA.PS.Core.Control.Chart.IPSDEChartLogic;
import SA.SRFDA.PS.Core.Control.Chart.IPSDEChartSeries;
import SA.SRFDA.PS.Core.Control.Chart.IPSDEChartTitle;
import SA.SRFDA.PS.Core.Control.Chart.IPSECharts;
import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSet;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogic;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import SA.SRFDA.PS.Core.Res.IPSSysPFPlugin;
import java.util.ArrayList;
import java.util.Iterator;

@PSModelInterfaceMeta(title="\u5b9e\u4f53\u56fe\u8868\u90e8\u4ef6\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", model="PSDEChart")
public interface IPSDEChart
extends IPSChart,
IPSECharts {
    public IPSDEChartTitle getPSDEChartTitle();

    public IPSDEChartLegend getPSDEChartLegend();

    public IPSDEChartDataGrid getPSDEChartDataGrid();

    public IPSDEDataSet getPSDEDataSet();

    public IPSDELogic getActiveDataPSDELogic();

    public Iterator<IPSDEChartAxes> getPSDEChartAxeses();

    public Iterator<IPSDEChartSeries> getPSDEChartSerieses();

    public ArrayList<IPSDEChartAxes> getPSDEChartAxesesByPos(String var1);

    public IPSDEChartAxes getPSDEChartAxes(String var1) throws Exception;

    @Override
    public IPSSysPFPlugin getPSSysPFPlugin();

    public IPSAppDEField getMinorSortPSAppDEField();

    public IPSDEField getMinorSortPSDEF();

    public String getMinorSortDir();

    public Iterator<? extends IPSDEChartLogic> getPSDEChartLogics();
}

