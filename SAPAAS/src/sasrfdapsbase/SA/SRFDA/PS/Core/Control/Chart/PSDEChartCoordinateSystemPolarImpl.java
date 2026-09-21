/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Chart;

import SA.SRFDA.PS.Core.Control.Chart.IPSChartCoordinateSystemControl;
import SA.SRFDA.PS.Core.Control.Chart.IPSChartCoordinateSystemPolar;
import SA.SRFDA.PS.Core.Control.Chart.IPSChartPolar;
import SA.SRFDA.PS.Core.Control.Chart.IPSDEChartPolar;
import SA.SRFDA.PS.Core.Control.Chart.PSDEChartCoordinateSystemImplBase;
import SA.SRFDA.PS.Core.Control.Chart.PSDEChartPolarImpl;
import SA.SRFDA.PS.Core.PSModelImplementMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;

@PSModelImplementMeta(implement="IPSChartCoordinateSystem", typevalues={"POLAR"})
public class PSDEChartCoordinateSystemPolarImpl
extends PSDEChartCoordinateSystemImplBase
implements IPSChartCoordinateSystemPolar {
    private IPSDEChartPolar iPSDEChartPolar = null;

    @Override
    protected void onInit() throws Exception {
        PSDEChartPolarImpl psDEChartPolarImpl = new PSDEChartPolarImpl();
        psDEChartPolarImpl.init(this.getDAGlobalHelper(), this, this.getPSDEChartData(), this.getPSDEChartCSData());
        this.iPSDEChartPolar = psDEChartPolarImpl;
        super.onInit();
    }

    @Override
    @PSModelRTMeta(description="\u56fe\u8868\u6781\u5750\u6807\u754c\u9762\u5bf9\u8c61")
    public IPSChartPolar getPSChartPolar() {
        return this.iPSDEChartPolar;
    }

    @Override
    protected IPSChartCoordinateSystemControl onGetPSChartCoordinateSystemControl() {
        return this.getPSChartPolar();
    }

    @Override
    protected String onGetType() {
        return "POLAR";
    }
}

