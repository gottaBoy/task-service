/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Chart;

import SA.SRFDA.PS.Core.Control.Chart.IPSChartCoordinateSystemControl;
import SA.SRFDA.PS.Core.Control.Chart.IPSChartCoordinateSystemGeo;
import SA.SRFDA.PS.Core.Control.Chart.IPSChartGeo;
import SA.SRFDA.PS.Core.Control.Chart.IPSDEChartGeo;
import SA.SRFDA.PS.Core.Control.Chart.PSDEChartCoordinateSystemImplBase;
import SA.SRFDA.PS.Core.Control.Chart.PSDEChartGeoImpl;
import SA.SRFDA.PS.Core.PSModelImplementMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;

@PSModelImplementMeta(implement="IPSChartCoordinateSystem", typevalues={"MAP"})
public class PSDEChartCoordinateSystemGeoImpl
extends PSDEChartCoordinateSystemImplBase
implements IPSChartCoordinateSystemGeo {
    private IPSDEChartGeo iPSDEChartGeo = null;

    @Override
    protected void onInit() throws Exception {
        PSDEChartGeoImpl psDEChartGeoImpl = new PSDEChartGeoImpl();
        psDEChartGeoImpl.init(this.getDAGlobalHelper(), this, this.getPSDEChartData(), this.getPSDEChartCSData());
        this.iPSDEChartGeo = psDEChartGeoImpl;
        super.onInit();
    }

    @Override
    @PSModelRTMeta(description="\u5730\u7406\u5750\u6807\u7cfb\u7ec4\u4ef6", child=true)
    public IPSChartGeo getPSChartGeo() {
        return this.iPSDEChartGeo;
    }

    @Override
    protected IPSChartCoordinateSystemControl onGetPSChartCoordinateSystemControl() {
        return this.getPSChartGeo();
    }

    @Override
    protected String onGetType() {
        return "MAP";
    }

    @Override
    protected String onGetEChartsType() {
        return "geo";
    }
}

