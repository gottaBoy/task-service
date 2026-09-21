/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Chart;

import SA.SRFDA.PS.Core.Control.Chart.IPSChartSeriesCustom;
import SA.SRFDA.PS.Core.Control.Chart.PSDEChartSeriesImpl2;
import SA.SRFDA.PS.Core.PSModelImplementMeta;

@PSModelImplementMeta(implement="IPSDEChartSeries", typevalues={"custom"})
public class PSDEChartSeriesCustomImpl
extends PSDEChartSeriesImpl2
implements IPSChartSeriesCustom {
    @Override
    protected void onInit() throws Exception {
        super.onInit();
    }

    @Override
    protected String onGetEChartsType() {
        return "custom";
    }

    @Override
    protected boolean onGetEnableChartDataSet() {
        return true;
    }

    @Override
    protected String getDefaultCoordinateSystem() throws Exception {
        return "XY";
    }
}

