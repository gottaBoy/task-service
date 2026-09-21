/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Chart;

import SA.SRFDA.PS.Core.Control.Chart.IPSEChartsRuntime;
import SA.SRFDA.PS.Core.Control.Chart.PSDEChartParallelAxisImplBase;

public class PSDEChartParallelAxisImpl
extends PSDEChartParallelAxisImplBase {
    @Override
    protected void onInit() throws Exception {
        super.onInit();
    }

    @Override
    public String getModelType() {
        return "PSDECHARTPARALLELAXIS";
    }

    @Override
    protected String onGetEChartsPos() {
        return "rarallelAxis";
    }

    @Override
    protected void onRegisterToPSECharts(IPSEChartsRuntime iPSEChartsRuntime) throws Exception {
        iPSEChartsRuntime.registerPSChartParallelAxis(this);
        super.onRegisterToPSECharts(iPSEChartsRuntime);
    }
}

