/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Chart;

import SA.SRFDA.PS.Core.Control.Chart.IPSChartSeries;
import SA.SRFDA.PS.Core.Control.Chart.IPSChartSeriesEncode;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;

@PSModelIgnoreMeta
public interface IPSChartCoordinateSystemRuntime {
    public void registerPSChartSeries(IPSChartSeries var1);

    public boolean testPSChartSeries(IPSChartSeries var1);

    public int getMaxPSChartSeriesCount();

    public IPSChartSeriesEncode createPSChartSeriesEncode();
}

