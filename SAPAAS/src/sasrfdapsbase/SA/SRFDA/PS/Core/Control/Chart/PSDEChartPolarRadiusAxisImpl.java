/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Chart;

import SA.SRFDA.PS.Core.Control.Chart.IPSChartPolarRadiusAxis;
import SA.SRFDA.PS.Core.Control.Chart.IPSEChartsRuntime;
import SA.SRFDA.PS.Core.Control.Chart.PSDEChartPolarAxisImplBase;

public class PSDEChartPolarRadiusAxisImpl
extends PSDEChartPolarAxisImplBase
implements IPSChartPolarRadiusAxis {
    @Override
    protected void onInit() throws Exception {
        super.onInit();
    }

    @Override
    public String getModelType() {
        return "PSDECHARTPOLARRADIUSAXIS";
    }

    @Override
    protected String onGetEChartsPos() {
        return "radiusAxis";
    }

    @Override
    protected void onRegisterToPSECharts(IPSEChartsRuntime iPSEChartsRuntime) throws Exception {
        iPSEChartsRuntime.registerPSChartRadiusAxis(this);
        super.onRegisterToPSECharts(iPSEChartsRuntime);
    }
}

