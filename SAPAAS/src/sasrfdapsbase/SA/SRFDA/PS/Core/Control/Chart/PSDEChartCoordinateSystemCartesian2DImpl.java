/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Chart;

import SA.SRFDA.PS.Core.Control.Chart.IPSChartCoordinateSystemCartesian2D;
import SA.SRFDA.PS.Core.Control.Chart.IPSChartCoordinateSystemControl;
import SA.SRFDA.PS.Core.Control.Chart.IPSChartGrid;
import SA.SRFDA.PS.Core.Control.Chart.IPSChartSeriesEncode;
import SA.SRFDA.PS.Core.Control.Chart.IPSDEChartGrid;
import SA.SRFDA.PS.Core.Control.Chart.PSDEChartCoordinateSystemImplBase;
import SA.SRFDA.PS.Core.Control.Chart.PSDEChartGridImpl;
import SA.SRFDA.PS.Core.Control.Chart.PSDEChartSeriesCSCartesian2DEncodeImpl;
import SA.SRFDA.PS.Core.PSModelImplementMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;

@PSModelImplementMeta(implement="IPSChartCoordinateSystem", typevalues={"XY"})
public class PSDEChartCoordinateSystemCartesian2DImpl
extends PSDEChartCoordinateSystemImplBase
implements IPSChartCoordinateSystemCartesian2D {
    private IPSDEChartGrid iPSDEChartGrid = null;

    @Override
    protected void onInit() throws Exception {
        PSDEChartGridImpl psDEChartGridImpl = new PSDEChartGridImpl();
        psDEChartGridImpl.init(this.getDAGlobalHelper(), this, this.getPSDEChartData(), this.getPSDEChartCSData());
        this.iPSDEChartGrid = psDEChartGridImpl;
        super.onInit();
    }

    @Override
    @PSModelRTMeta(description="\u76f4\u89d2\u5750\u6807\u7ed8\u56fe\u7f51\u683c\u5bf9\u8c61", child=true)
    public IPSChartGrid getPSChartGrid() {
        return this.iPSDEChartGrid;
    }

    @Override
    protected IPSChartCoordinateSystemControl onGetPSChartCoordinateSystemControl() {
        return this.getPSChartGrid();
    }

    @Override
    protected String onGetType() {
        return "XY";
    }

    @Override
    protected String onGetEChartsType() {
        return "cartesian2d";
    }

    @Override
    public IPSChartSeriesEncode createPSChartSeriesEncode() {
        return new PSDEChartSeriesCSCartesian2DEncodeImpl();
    }
}

