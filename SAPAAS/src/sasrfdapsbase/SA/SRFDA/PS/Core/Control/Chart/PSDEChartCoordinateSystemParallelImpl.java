/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Chart;

import SA.SRFDA.PS.Core.Control.Chart.IPSChartCoordinateSystemControl;
import SA.SRFDA.PS.Core.Control.Chart.IPSChartCoordinateSystemParallel;
import SA.SRFDA.PS.Core.Control.Chart.IPSChartParallel;
import SA.SRFDA.PS.Core.Control.Chart.IPSDEChartParallel;
import SA.SRFDA.PS.Core.Control.Chart.PSDEChartCoordinateSystemImplBase;
import SA.SRFDA.PS.Core.Control.Chart.PSDEChartParallelImpl;
import SA.SRFDA.PS.Core.PSModelImplementMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;

@PSModelImplementMeta(implement="IPSChartCoordinateSystem", typevalues={"PARALLEL"})
public class PSDEChartCoordinateSystemParallelImpl
extends PSDEChartCoordinateSystemImplBase
implements IPSChartCoordinateSystemParallel {
    private IPSDEChartParallel iPSDEChartParallel = null;

    @Override
    protected void onInit() throws Exception {
        PSDEChartParallelImpl psDEChartParallelImpl = new PSDEChartParallelImpl();
        psDEChartParallelImpl.init(this.getDAGlobalHelper(), this, this.getPSDEChartData(), this.getPSDEChartCSData());
        this.iPSDEChartParallel = psDEChartParallelImpl;
        super.onInit();
    }

    @Override
    @PSModelRTMeta(description="\u5e73\u884c\u5750\u6807\u7cfb\u754c\u9762\u5bf9\u8c61", child=true)
    public IPSChartParallel getPSChartParallel() {
        return this.iPSDEChartParallel;
    }

    @Override
    protected IPSChartCoordinateSystemControl onGetPSChartCoordinateSystemControl() {
        return this.getPSChartParallel();
    }

    @Override
    protected String onGetType() {
        return "PARALLEL";
    }
}

