/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Chart;

import SA.SRFDA.PS.Core.Control.Chart.IPSChartCoordinateSystem;
import SA.SRFDA.PS.Core.Control.Chart.IPSChartCoordinateSystemNone;
import SA.SRFDA.PS.Core.Control.Chart.IPSChartSeriesCSNone;
import SA.SRFDA.PS.Core.Control.Chart.PSDEChartSeriesImpl2;

public class PSDEChartSeriesCSNoneImplBase
extends PSDEChartSeriesImpl2
implements IPSChartSeriesCSNone {
    @Override
    protected boolean testPSChartCoordinateSystem(IPSChartCoordinateSystem iPSChartCoordinateSystem) throws Exception {
        return iPSChartCoordinateSystem instanceof IPSChartCoordinateSystemNone;
    }
}

