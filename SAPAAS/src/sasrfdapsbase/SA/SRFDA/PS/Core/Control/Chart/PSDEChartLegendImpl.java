/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Control.Chart;

import SA.SRFDA.PS.Core.Control.Chart.IPSDEChart;
import SA.SRFDA.PS.Core.Control.Chart.IPSDEChartLegend;
import SA.SRFDA.PS.Core.Control.Chart.PSDEChartObjectImplBase;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Data.PSDEChart;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEChartLegendImpl
extends PSDEChartObjectImplBase
implements IPSDEChartLegend {
    private static final Log log = LogFactory.getLog(PSDEChartLegendImpl.class);
    private PSDEChart psDEChart = null;
    private boolean bShowLegend = true;
    private String strLegendPos = null;

    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDEChart iPSDEChart, PSDEChart psDEChart) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSDEChart(iPSDEChart);
            this.psDEChart = psDEChart;
            if (!this.psDEChart.isSHOWLEGENDNull()) {
                this.bShowLegend = this.psDEChart.getSHOWLEGEND();
            }
            if (!StringHelper.isNullOrEmpty((String)this.psDEChart.getLEGENDPOS())) {
                this.strLegendPos = this.psDEChart.getLEGENDPOS();
            }
            this.onInit();
        }
        catch (Exception ex) {
            this.throwCriticalInitException(ex);
            String strLogName = StringHelper.format((String)"%1$s[%2$s]", (Object)PSModels.getModelName((String)this.getModelType()), (Object)this.getFullModelName());
            String strExInfo = StringHelper.format((String)"\u521d\u59cb\u5316\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage());
            log.error((Object)StringHelper.format((String)"%1$s%2$s", (Object)strLogName, (Object)strExInfo), (Throwable)ex);
            if (this.getPSSystemUtil() != null) {
                this.getPSSystemUtil().getPSSysConsole().error(strLogName, strExInfo);
            }
            this.throwInitException(ex);
        }
    }

    @Override
    @PSModelRTMeta(description="\u663e\u793a\u56fe\u4f8b", fields={"SHOWLEGEND"})
    public boolean isShowLegend() {
        return this.bShowLegend;
    }

    @Override
    @PSModelRTMeta(description="\u56fe\u4f8b\u4f4d\u7f6e", codelist="ChartTitlePos", fields={"LEGENDPOS"})
    public String getLegendPos() {
        return this.strLegendPos;
    }

    @Override
    public String getModelType() {
        return "PSDECHARTLEGEND";
    }

    @Override
    public String getModelId() {
        return this.getPSDEChart().getModelId();
    }

    @Override
    public String getFullModelName() {
        return StringHelper.format((String)"%1$s", (Object)this.getPSDEChart().getFullModelName());
    }
}

