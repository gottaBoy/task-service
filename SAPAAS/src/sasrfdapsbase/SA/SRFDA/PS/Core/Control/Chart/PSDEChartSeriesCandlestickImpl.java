/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Chart;

import SA.SRFDA.PS.Core.Control.Chart.IPSChartCoordinateSystem;
import SA.SRFDA.PS.Core.Control.Chart.IPSChartSeriesCandlestick;
import SA.SRFDA.PS.Core.Control.Chart.IPSChartSeriesCandlestickSupportable;
import SA.SRFDA.PS.Core.Control.Chart.PSDEChartSeriesImpl2;
import SA.SRFDA.PS.Core.PSModelImplementMeta;

@PSModelImplementMeta(implement="IPSDEChartSeries", typevalues={"candlestick"})
public class PSDEChartSeriesCandlestickImpl
extends PSDEChartSeriesImpl2
implements IPSChartSeriesCandlestick {
    @Override
    protected void onInit() throws Exception {
        super.onInit();
    }

    @Override
    protected String onGetEChartsType() {
        return "candlestick";
    }

    @Override
    protected String getDefaultCoordinateSystem() throws Exception {
        return "XY";
    }

    @Override
    protected boolean testPSChartCoordinateSystem(IPSChartCoordinateSystem iPSChartCoordinateSystem) throws Exception {
        return iPSChartCoordinateSystem instanceof IPSChartSeriesCandlestickSupportable;
    }

    @Override
    protected boolean onGetEnableChartDataSet() {
        return true;
    }
}

