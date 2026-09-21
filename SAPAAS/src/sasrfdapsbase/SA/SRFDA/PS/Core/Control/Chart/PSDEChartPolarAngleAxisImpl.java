/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Chart;

import SA.SRFDA.PS.Core.Control.Chart.IPSChartPolarAngleAxis;
import SA.SRFDA.PS.Core.Control.Chart.IPSEChartsRuntime;
import SA.SRFDA.PS.Core.Control.Chart.PSDEChartPolarAxisImplBase;

public class PSDEChartPolarAngleAxisImpl
extends PSDEChartPolarAxisImplBase
implements IPSChartPolarAngleAxis {
    @Override
    protected void onInit() throws Exception {
        super.onInit();
    }

    @Override
    public String getModelType() {
        return "PSDECHARTPOLARANGLEAXIS";
    }

    @Override
    protected String onGetEChartsPos() {
        return "angleAxis";
    }

    @Override
    protected void onRegisterToPSECharts(IPSEChartsRuntime iPSEChartsRuntime) throws Exception {
        iPSEChartsRuntime.registerPSChartAngleAxis(this);
        super.onRegisterToPSECharts(iPSEChartsRuntime);
    }
}

