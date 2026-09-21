/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Chart;

import SA.SRFDA.PS.Core.Control.Chart.IPSChartCoordinateSystemControl;
import SA.SRFDA.PS.Core.Control.Chart.IPSChartCoordinateSystemSingle;
import SA.SRFDA.PS.Core.Control.Chart.IPSChartSingle;
import SA.SRFDA.PS.Core.Control.Chart.IPSDEChartSingle;
import SA.SRFDA.PS.Core.Control.Chart.PSDEChartCoordinateSystemImplBase;
import SA.SRFDA.PS.Core.Control.Chart.PSDEChartSingleImpl;
import SA.SRFDA.PS.Core.PSModelImplementMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;

@PSModelImplementMeta(implement="IPSChartCoordinateSystem", typevalues={"SINGLE"})
public class PSDEChartCoordinateSystemSingleImpl
extends PSDEChartCoordinateSystemImplBase
implements IPSChartCoordinateSystemSingle {
    private IPSDEChartSingle iPSDEChartSingle = null;

    @Override
    protected void onInit() throws Exception {
        PSDEChartSingleImpl psDEChartSingleImpl = new PSDEChartSingleImpl();
        psDEChartSingleImpl.init(this.getDAGlobalHelper(), this, this.getPSDEChartData(), this.getPSDEChartCSData());
        this.iPSDEChartSingle = psDEChartSingleImpl;
        super.onInit();
    }

    @Override
    @PSModelRTMeta(description="\u5355\u5750\u6807\u7cfb\u754c\u9762\u5bf9\u8c61", child=true)
    public IPSChartSingle getPSChartSingle() {
        return this.iPSDEChartSingle;
    }

    @Override
    protected IPSChartCoordinateSystemControl onGetPSChartCoordinateSystemControl() {
        return this.getPSChartSingle();
    }

    @Override
    protected String onGetType() {
        return "SINGLE";
    }
}

