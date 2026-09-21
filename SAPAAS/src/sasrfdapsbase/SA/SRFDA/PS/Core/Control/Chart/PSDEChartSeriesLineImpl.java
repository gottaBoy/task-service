/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.Control.Chart;

import SA.SRFDA.PS.Core.Control.Chart.IPSChartCoordinateSystem;
import SA.SRFDA.PS.Core.Control.Chart.IPSChartSeriesLine;
import SA.SRFDA.PS.Core.Control.Chart.IPSChartSeriesLineSupportable;
import SA.SRFDA.PS.Core.Control.Chart.PSDEChartSeriesImpl2;
import SA.SRFDA.PS.Core.PSModelImplementMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import net.ibizsys.paas.util.StringHelper;

@PSModelImplementMeta(implement="IPSDEChartSeries", typevalues={"area", "line"})
public class PSDEChartSeriesLineImpl
extends PSDEChartSeriesImpl2
implements IPSChartSeriesLine {
    private boolean bStack = false;
    private Object objStep = null;

    @Override
    protected void onInit() throws Exception {
        super.onInit();
        if (!this.getPSDEChartSeriesData().isSTACKNull()) {
            this.bStack = this.getPSDEChartSeriesData().getSTACK();
        }
        if (!StringHelper.isNullOrEmpty((String)this.getPSDEChartSeriesData().getSTEP())) {
            this.objStep = PSDEChartSeriesLineImpl.getBooleanOrString(this.getPSDEChartSeriesData().getSTEP());
        }
    }

    @Override
    protected String onGetEChartsType() {
        return "line";
    }

    @Override
    protected String getDefaultCoordinateSystem() throws Exception {
        return "XY";
    }

    @Override
    protected boolean testPSChartCoordinateSystem(IPSChartCoordinateSystem iPSChartCoordinateSystem) throws Exception {
        return iPSChartCoordinateSystem instanceof IPSChartSeriesLineSupportable;
    }

    @Override
    protected boolean onGetEnableChartDataSet() {
        return true;
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u5806\u53e0")
    public boolean isStack() {
        return this.bStack;
    }

    @Override
    @PSModelRTMeta(description="\u9636\u68af\u7ebf\u56fe")
    public Object getStep() {
        return this.objStep;
    }
}

