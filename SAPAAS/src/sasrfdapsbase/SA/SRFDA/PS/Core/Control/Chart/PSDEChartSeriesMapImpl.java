/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.Control.Chart;

import SA.SRFDA.PS.Core.Control.Chart.IPSChartCoordinateSystem;
import SA.SRFDA.PS.Core.Control.Chart.IPSChartSeriesMap;
import SA.SRFDA.PS.Core.Control.Chart.IPSChartSeriesMapSupportable;
import SA.SRFDA.PS.Core.Control.Chart.PSDEChartSeriesImpl;
import SA.SRFDA.PS.Core.PSModelImplementMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import net.ibizsys.paas.util.StringHelper;

@PSModelImplementMeta(implement="IPSDEChartSeries", typevalues={"map"})
public class PSDEChartSeriesMapImpl
extends PSDEChartSeriesImpl
implements IPSChartSeriesMap {
    @Override
    protected void onInit() throws Exception {
        super.onInit();
    }

    @Override
    protected String onGetEChartsType() {
        return "map";
    }

    @Override
    protected boolean onGetEnableChartDataSet() {
        return true;
    }

    @Override
    protected String getDefaultCoordinateSystem() throws Exception {
        return "MAP";
    }

    @Override
    protected boolean testPSChartCoordinateSystem(IPSChartCoordinateSystem iPSChartCoordinateSystem) throws Exception {
        return iPSChartCoordinateSystem instanceof IPSChartSeriesMapSupportable;
    }

    @Override
    @PSModelRTMeta(description="\u5730\u56fe\u7c7b\u578b")
    public String getMapType() {
        String strMapType = this.getPSDEChartSeriesData().getMAPTYPE();
        if (StringHelper.isNullOrEmpty((String)strMapType)) {
            return this.getUserParam("EC.mapType", null);
        }
        return strMapType;
    }
}

