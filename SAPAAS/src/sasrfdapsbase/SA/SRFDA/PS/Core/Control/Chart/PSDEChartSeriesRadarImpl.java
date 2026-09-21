/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Chart;

import SA.SRFDA.PS.Core.Control.Chart.IPSChartCoordinateSystem;
import SA.SRFDA.PS.Core.Control.Chart.IPSChartSeriesRadar;
import SA.SRFDA.PS.Core.Control.Chart.IPSChartSeriesRadarSupportable;
import SA.SRFDA.PS.Core.Control.Chart.PSDEChartSeriesImpl2;
import SA.SRFDA.PS.Core.PSModelImplementMeta;

@PSModelImplementMeta(implement="IPSDEChartSeries", typevalues={"radar"})
public class PSDEChartSeriesRadarImpl
extends PSDEChartSeriesImpl2
implements IPSChartSeriesRadar {
    @Override
    protected void onInit() throws Exception {
        super.onInit();
    }

    @Override
    protected String onGetEChartsType() {
        return "radar";
    }

    @Override
    protected String getDefaultCoordinateSystem() throws Exception {
        return "RADAR";
    }

    @Override
    protected boolean testPSChartCoordinateSystem(IPSChartCoordinateSystem iPSChartCoordinateSystem) throws Exception {
        return iPSChartCoordinateSystem instanceof IPSChartSeriesRadarSupportable;
    }

    @Override
    protected boolean onGetEnableChartDataSet() {
        return true;
    }
}

