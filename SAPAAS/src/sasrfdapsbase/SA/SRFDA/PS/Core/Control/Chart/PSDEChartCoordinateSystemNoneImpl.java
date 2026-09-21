/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Chart;

import SA.SRFDA.PS.Core.Control.Chart.IPSChartCoordinateSystemControl;
import SA.SRFDA.PS.Core.Control.Chart.IPSChartCoordinateSystemNone;
import SA.SRFDA.PS.Core.Control.Chart.IPSChartSeriesEncode;
import SA.SRFDA.PS.Core.Control.Chart.PSDEChartCoordinateSystemImplBase;
import SA.SRFDA.PS.Core.Control.Chart.PSDEChartSeriesCSNoneEncodeImpl;
import SA.SRFDA.PS.Core.PSModelImplementMeta;

@PSModelImplementMeta(implement="IPSChartCoordinateSystem", typevalues={"NONE"})
public class PSDEChartCoordinateSystemNoneImpl
extends PSDEChartCoordinateSystemImplBase
implements IPSChartCoordinateSystemNone {
    @Override
    protected String onGetType() {
        return "NONE";
    }

    @Override
    public int getMaxPSChartSeriesCount() {
        return 1;
    }

    @Override
    protected IPSChartCoordinateSystemControl onGetPSChartCoordinateSystemControl() {
        return null;
    }

    @Override
    public IPSChartSeriesEncode createPSChartSeriesEncode() {
        return new PSDEChartSeriesCSNoneEncodeImpl();
    }
}

