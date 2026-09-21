/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Chart;

import SA.SRFDA.PS.Core.Control.Chart.IPSEChartsRuntime;
import SA.SRFDA.PS.Core.Control.Chart.PSDEChartSingleAxisImplBase;

public class PSDEChartSingleAxisImpl
extends PSDEChartSingleAxisImplBase {
    @Override
    protected void onInit() throws Exception {
        super.onInit();
    }

    @Override
    public String getModelType() {
        return "PSDECHARTSINGLEAXIS";
    }

    @Override
    protected String onGetEChartsPos() {
        return "rarallelAxis";
    }

    @Override
    protected void onRegisterToPSECharts(IPSEChartsRuntime iPSEChartsRuntime) throws Exception {
        iPSEChartsRuntime.registerPSChartSingleAxis(this);
        super.onRegisterToPSECharts(iPSEChartsRuntime);
    }
}

