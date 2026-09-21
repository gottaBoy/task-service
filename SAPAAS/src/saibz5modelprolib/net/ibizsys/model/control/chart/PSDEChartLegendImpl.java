/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.control.chart.IPSDEChart
 *  net.ibizsys.model.control.chart.IPSDEChartLegend
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.control.chart;

import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.PSModelRTMeta;
import net.ibizsys.model.PSModels;
import net.ibizsys.model.control.chart.IPSDEChart;
import net.ibizsys.model.control.chart.IPSDEChartLegend;
import net.ibizsys.model.control.chart.PSDEChartObjectImpl;
import net.ibizsys.model.entity.PSDEChart;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEChartLegendImpl
extends PSDEChartObjectImpl
implements IPSDEChartLegend {
    private static final Log log = LogFactory.getLog(PSDEChartLegendImpl.class);
    private PSDEChart psDEChart = null;
    private boolean bShowLegend = true;
    private String strLegendPos = null;

    public void init(IPSModelStorageContext iPSModelStorageContext, IPSDEChart iPSDEChart, PSDEChart psDEChart) throws Exception {
        try {
            this.setPSModelStorageContext(iPSModelStorageContext);
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
            String strLogName = StringHelper.format((String)"%1$s[%2$s]", (Object)PSModels.getModelName(this.getModelType()), (Object)this.getFullModelName());
            String strExInfo = StringHelper.format((String)"\u521d\u59cb\u5316\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage());
            log.error((Object)StringHelper.format((String)"%1$s%2$s", (Object)strLogName, (Object)strExInfo), (Throwable)ex);
            throw ex;
        }
    }

    @PSModelRTMeta(description="\u663e\u793a\u56fe\u4f8b")
    public boolean isShowLegend() {
        return this.bShowLegend;
    }

    @PSModelRTMeta(description="\u56fe\u4f8b\u4f4d\u7f6e")
    public String getLegendPos() {
        return this.strLegendPos;
    }

    @Override
    public String getModelType() {
        return "PSDECHARTLEGEND";
    }
}

