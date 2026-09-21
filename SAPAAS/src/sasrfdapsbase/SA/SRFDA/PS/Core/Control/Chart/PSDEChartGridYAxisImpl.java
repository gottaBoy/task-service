/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Chart;

import SA.SRFDA.PS.Core.Control.Chart.IPSChartGridYAxis;
import SA.SRFDA.PS.Core.Control.Chart.IPSEChartsRuntime;
import SA.SRFDA.PS.Core.Control.Chart.PSDEChartGridAxisImplBase;

public class PSDEChartGridYAxisImpl
extends PSDEChartGridAxisImplBase
implements IPSChartGridYAxis {
    @Override
    protected void onInit() throws Exception {
        super.onInit();
    }

    @Override
    protected void onRegisterToPSECharts(IPSEChartsRuntime iPSEChartsRuntime) throws Exception {
        iPSEChartsRuntime.registerPSChartYAxis(this);
        super.onRegisterToPSECharts(iPSEChartsRuntime);
    }

    @Override
    public String getModelType() {
        return "PSDECHARTGRIDYAXIS";
    }

    @Override
    protected String onGetEChartsPos() {
        return "yAxis";
    }
}

