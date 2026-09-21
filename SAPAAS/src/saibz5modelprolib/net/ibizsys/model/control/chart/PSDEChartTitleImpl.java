/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.control.chart.IPSDEChart
 *  net.ibizsys.model.control.chart.IPSDEChartTitle
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.control.chart;

import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.PSModels;
import net.ibizsys.model.control.chart.IPSDEChart;
import net.ibizsys.model.control.chart.IPSDEChartTitle;
import net.ibizsys.model.control.chart.IPSDEChartTitleRuntime;
import net.ibizsys.model.control.chart.PSDEChartObjectImpl;
import net.ibizsys.model.entity.PSDEChart;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEChartTitleImpl
extends PSDEChartObjectImpl
implements IPSDEChartTitle,
IPSDEChartTitleRuntime {
    private static final Log log = LogFactory.getLog(PSDEChartTitleImpl.class);
    private PSDEChart psDEChart = null;
    private boolean bShowTitle = true;
    private String strTitle = null;
    private String strSubTitle = null;
    private String strTitlePos = null;

    public void init(IPSModelStorageContext iPSModelStorageContext, IPSDEChart iPSDEChart, PSDEChart psDEChart) throws Exception {
        try {
            this.setPSModelStorageContext(iPSModelStorageContext);
            this.setPSDEChart(iPSDEChart);
            this.psDEChart = psDEChart;
            if (!this.psDEChart.isSHOWTITLENull()) {
                this.bShowTitle = this.psDEChart.getSHOWTITLE();
            }
            if (!StringHelper.isNullOrEmpty((String)this.psDEChart.getLOGICNAME())) {
                this.strTitle = this.psDEChart.getLOGICNAME();
            }
            if (!StringHelper.isNullOrEmpty((String)this.psDEChart.getSUBTITLE())) {
                this.strSubTitle = this.psDEChart.getSUBTITLE();
            }
            if (!StringHelper.isNullOrEmpty((String)this.psDEChart.getTITLEPOS())) {
                this.strTitlePos = this.psDEChart.getTITLEPOS();
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

    public String getTitle() {
        return this.strTitle;
    }

    public String getSubTitle() {
        return this.strSubTitle;
    }

    public boolean isShowTitle() {
        return this.bShowTitle;
    }

    public String getTitlePos() {
        return this.strTitlePos;
    }

    @Override
    public String getModelType() {
        return "PSDECHARTTITLE";
    }
}

