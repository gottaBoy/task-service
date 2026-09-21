/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Control.Chart;

import SA.SRFDA.PS.Core.CodeList.IPSCodeList;
import SA.SRFDA.PS.Core.Control.Chart.IPSChartSeries;
import SA.SRFDA.PS.Core.Control.Chart.IPSDEChartRadar;
import SA.SRFDA.PS.Core.Control.Chart.IPSEChartsRuntime;
import SA.SRFDA.PS.Core.Control.Chart.PSDEChartCoordinateSystemControlImplBase;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import java.util.Iterator;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEChartRadarImpl
extends PSDEChartCoordinateSystemControlImplBase
implements IPSDEChartRadar {
    private static final Log log = LogFactory.getLog(PSDEChartRadarImpl.class);
    private IPSCodeList indicatorPSCodeList = null;

    @Override
    protected void onInit() throws Exception {
        super.onInit();
    }

    @Override
    protected void onRegisterToPSECharts(IPSEChartsRuntime iPSEChartsRuntime) throws Exception {
        iPSEChartsRuntime.registerPSChartRadar(this);
        super.onRegisterToPSECharts(iPSEChartsRuntime);
    }

    @Override
    public String getModelType() {
        return "PSDECHARTRADAR";
    }

    @Override
    protected String onGetType() {
        return "radar";
    }

    @Override
    @PSModelRTMeta(description="\u6307\u793a\u5668\u4ee3\u7801\u8868")
    public IPSCodeList getIndicatorPSCodeList() {
        Iterator<IPSChartSeries> psChartSerieses;
        if (this.indicatorPSCodeList == null && (psChartSerieses = this.getPSChartCoordinateSystem().getPSChartSerieses()) != null && psChartSerieses.hasNext()) {
            IPSChartSeries iPSChartSeries = psChartSerieses.next();
            this.indicatorPSCodeList = iPSChartSeries.getCatalogPSCodeList();
        }
        return this.indicatorPSCodeList;
    }
}

