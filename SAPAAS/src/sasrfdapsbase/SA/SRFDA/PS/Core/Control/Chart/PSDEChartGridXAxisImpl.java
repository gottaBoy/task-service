/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Chart;

import SA.SRFDA.PS.Core.Control.Chart.IPSChartGridXAxis;
import SA.SRFDA.PS.Core.Control.Chart.IPSEChartsRuntime;
import SA.SRFDA.PS.Core.Control.Chart.PSDEChartGridAxisImplBase;

public class PSDEChartGridXAxisImpl
extends PSDEChartGridAxisImplBase
implements IPSChartGridXAxis {
    @Override
    protected void onInit() throws Exception {
        super.onInit();
    }

    @Override
    public String getModelType() {
        return "PSDECHARTGRIDXAXIS";
    }

    @Override
    protected String onGetEChartsPos() {
        return "xAxis";
    }

    @Override
    protected void onRegisterToPSECharts(IPSEChartsRuntime iPSEChartsRuntime) throws Exception {
        iPSEChartsRuntime.registerPSChartXAxis(this);
        super.onRegisterToPSECharts(iPSEChartsRuntime);
    }
}

