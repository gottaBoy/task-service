/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Chart;

import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.Control.Chart.IPSChart;
import SA.SRFDA.PS.Core.Control.Chart.IPSChartSeries;
import SA.SRFDA.PS.Core.Control.Chart.IPSDEChart;
import SA.SRFDA.PS.Core.Control.Chart.IPSDEChartObject;
import SA.SRFDA.PS.Core.Control.Chart.IPSEChartsObjectRuntime;
import SA.SRFDA.PS.Core.Control.Chart.IPSEChartsRuntime;
import SA.SRFDA.PS.Core.Control.PSControlItemImpl2;
import SA.SRFDA.PS.Core.DynaModel.IPSSysDynaModel;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PSModelRTMeta;

public abstract class PSChartSeriesImpl
extends PSControlItemImpl2
implements IPSChartSeries,
IPSDEChartObject,
IPSEChartsObjectRuntime {
    private int nIndex = 0;
    private IPSDEChart iPSDEChart = null;

    @Override
    protected void onInit() throws Exception {
        this.onRegisterToPSECharts(this.getPSEChartsRuntime());
        super.onInit();
    }

    protected void onRegisterToPSECharts(IPSEChartsRuntime iPSEChartsRuntime) throws Exception {
    }

    @Override
    public IPSChart getPSChart() {
        return this.getPSDEChart();
    }

    @Override
    public IPSDEChart getPSDEChart() {
        return this.iPSDEChart;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.getPSDEChart().getPSDataEntity().getPSSysModelInstId();
    }

    protected void setPSDEChart(IPSDEChart iPSDEChart) {
        this.iPSDEChart = iPSDEChart;
    }

    @Override
    @PSModelRTMeta(description="\u5bf9\u8c61\u7d22\u5f15")
    public int getIndex() {
        return this.nIndex;
    }

    @Override
    public void setIndex(int nIndex) {
        this.nIndex = nIndex;
    }

    protected IPSSystemUtil getPSSystemUtil() {
        return (IPSSystemUtil)((Object)this.getPSDEChart().getPSAppView().getPSSystem());
    }

    protected IPSEChartsRuntime getPSEChartsRuntime() {
        return (IPSEChartsRuntime)((Object)this.getPSDEChart());
    }

    public IPSApplication getPSApplication() {
        return this.getPSDEChart().getPSAppView().getPSApplication();
    }

    @Override
    protected IPSSysDynaModel internalGetPSSysDynaModel(String strPSSysDynaModelId) throws Exception {
        return this.getPSDEChart().getPSAppView().getPSSystem().getPSSysDynaModel(strPSSysDynaModelId);
    }
}

