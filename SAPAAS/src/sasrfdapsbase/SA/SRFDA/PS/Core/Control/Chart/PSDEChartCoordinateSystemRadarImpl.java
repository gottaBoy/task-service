/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Chart;

import SA.SRFDA.PS.Core.Control.Chart.IPSChartCoordinateSystemControl;
import SA.SRFDA.PS.Core.Control.Chart.IPSChartCoordinateSystemRadar;
import SA.SRFDA.PS.Core.Control.Chart.IPSChartRadar;
import SA.SRFDA.PS.Core.Control.Chart.IPSDEChartRadar;
import SA.SRFDA.PS.Core.Control.Chart.PSDEChartCoordinateSystemImplBase;
import SA.SRFDA.PS.Core.Control.Chart.PSDEChartRadarImpl;
import SA.SRFDA.PS.Core.PSModelImplementMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;

@PSModelImplementMeta(implement="IPSChartCoordinateSystem", typevalues={"RADAR"})
public class PSDEChartCoordinateSystemRadarImpl
extends PSDEChartCoordinateSystemImplBase
implements IPSChartCoordinateSystemRadar {
    private IPSDEChartRadar iPSDEChartRadar = null;

    @Override
    protected void onInit() throws Exception {
        PSDEChartRadarImpl psDEChartRadarImpl = new PSDEChartRadarImpl();
        psDEChartRadarImpl.init(this.getDAGlobalHelper(), this, this.getPSDEChartData(), this.getPSDEChartCSData());
        this.iPSDEChartRadar = psDEChartRadarImpl;
        super.onInit();
    }

    @Override
    @PSModelRTMeta(description="\u56fe\u8868\u96f7\u8fbe\u90e8\u4ef6", child=true)
    public IPSChartRadar getPSChartRadar() {
        return this.iPSDEChartRadar;
    }

    @Override
    protected String onGetType() {
        return "RADAR";
    }

    @Override
    protected IPSChartCoordinateSystemControl onGetPSChartCoordinateSystemControl() {
        return this.getPSChartRadar();
    }
}

