/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.codelist.IPSCodeList
 *  net.ibizsys.model.control.chart.IPSChart
 *  net.ibizsys.model.control.chart.IPSChartAxes
 *  net.ibizsys.model.control.chart.IPSDEChart
 *  net.ibizsys.model.control.chart.IPSDEChartAxes
 *  net.ibizsys.model.control.chart.IPSDEChartSeries
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.control.chart;

import net.ibizsys.model.IPSModelObjectRuntime;
import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.PSModelRTMeta;
import net.ibizsys.model.PSModels;
import net.ibizsys.model.codelist.IPSCodeList;
import net.ibizsys.model.control.chart.IPSChart;
import net.ibizsys.model.control.chart.IPSChartAxes;
import net.ibizsys.model.control.chart.IPSDEChart;
import net.ibizsys.model.control.chart.IPSDEChartAxes;
import net.ibizsys.model.control.chart.IPSDEChartSeries;
import net.ibizsys.model.control.chart.IPSDEChartSeriesRuntime;
import net.ibizsys.model.control.chart.PSChartSeriesImpl;
import net.ibizsys.model.entity.PSDEChartSeries;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEChartSeriesImpl
extends PSChartSeriesImpl
implements IPSDEChartSeries,
IPSDEChartSeriesRuntime {
    private static final Log log = LogFactory.getLog(PSDEChartSeriesImpl.class);
    private IPSDEChart iPSDEChart;
    private PSDEChartSeries psDEChartSeries;
    private String strCatalogField = null;
    private String strValueField = null;
    private String strValue2Field = null;
    private String strValue3Field = null;
    private String strValue4Field = null;
    private String strValue5Field = null;
    private String strValue6Field = null;
    private String strSeriesField = null;
    private String strTimeGroupMode = null;
    private IPSDEChartAxes xPSDEChartAxes = null;
    private IPSDEChartAxes yPSDEChartAxes = null;
    private IPSCodeList seriesPSCodeList = null;
    private IPSCodeList catalogPSCodeList = null;
    private String strCaption = null;

    @Override
    public void init(IPSModelStorageContext iPSModelStorageContext, IPSDEChart iPSDEChart, PSDEChartSeries psDEChartSeries) throws Exception {
        try {
            this.setPSModelStorageContext(iPSModelStorageContext);
            this.iPSDEChart = iPSDEChart;
            this.psDEChartSeries = psDEChartSeries;
            this.setId(this.psDEChartSeries.getPSDECHARTPARAMID());
            this.setName(this.psDEChartSeries.getPSDECHARTPARAMNAME());
            this.setPSObjectData(this.psDEChartSeries);
            if (!StringHelper.isNullOrEmpty((String)this.psDEChartSeries.getXFIELD())) {
                this.strCatalogField = this.psDEChartSeries.getXFIELD();
            }
            if (!StringHelper.isNullOrEmpty((String)this.psDEChartSeries.getYFIELD())) {
                this.strValueField = this.psDEChartSeries.getYFIELD();
            }
            if (!StringHelper.isNullOrEmpty((String)this.psDEChartSeries.getZFIELD())) {
                this.strValue2Field = this.psDEChartSeries.getZFIELD();
            }
            if (!StringHelper.isNullOrEmpty((String)this.psDEChartSeries.getEXTFIELD())) {
                this.strValue3Field = this.psDEChartSeries.getEXTFIELD();
            }
            if (!StringHelper.isNullOrEmpty((String)this.psDEChartSeries.getEXTFIELD2())) {
                this.strValue4Field = this.psDEChartSeries.getEXTFIELD2();
            }
            if (!StringHelper.isNullOrEmpty((String)this.psDEChartSeries.getEXTFIELD3())) {
                this.strValue5Field = this.psDEChartSeries.getEXTFIELD3();
            }
            if (!StringHelper.isNullOrEmpty((String)this.psDEChartSeries.getEXTFIELD4())) {
                this.strValue6Field = this.psDEChartSeries.getEXTFIELD4();
            }
            if (!StringHelper.isNullOrEmpty((String)this.psDEChartSeries.getSERIESFIELD())) {
                this.strSeriesField = this.psDEChartSeries.getSERIESFIELD();
            }
            if (!StringHelper.isNullOrEmpty((String)this.psDEChartSeries.getXPSDECHARTAXESID())) {
                this.xPSDEChartAxes = this.iPSDEChart.getPSDEChartAxes(this.psDEChartSeries.getXPSDECHARTAXESID());
            }
            if (!StringHelper.isNullOrEmpty((String)this.psDEChartSeries.getYPSDECHARTAXESID())) {
                this.yPSDEChartAxes = this.iPSDEChart.getPSDEChartAxes(this.psDEChartSeries.getYPSDECHARTAXESID());
            }
            if (!StringHelper.isNullOrEmpty((String)this.psDEChartSeries.getTIMEGROUP())) {
                this.strTimeGroupMode = this.psDEChartSeries.getTIMEGROUP();
            }
            if (!StringHelper.isNullOrEmpty((String)this.psDEChartSeries.getSFPSCODELISTID())) {
                this.seriesPSCodeList = this.iPSDEChart.getPSDataEntity().getPSSystem().getPSCodeList(this.psDEChartSeries.getSFPSCODELISTID());
            }
            if (!StringHelper.isNullOrEmpty((String)this.psDEChartSeries.getXFPSCODELISTID())) {
                this.catalogPSCodeList = this.iPSDEChart.getPSDataEntity().getPSSystem().getPSCodeList(this.psDEChartSeries.getXFPSCODELISTID());
            }
            this.strCaption = this.psDEChartSeries.getCAPTION();
            this.onInit();
        }
        catch (Exception ex) {
            String strLogName = StringHelper.format((String)"%1$s[%2$s]", (Object)PSModels.getModelName(this.getModelType()), (Object)this.getFullModelName());
            String strExInfo = StringHelper.format((String)"\u521d\u59cb\u5316\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage());
            log.error((Object)StringHelper.format((String)"%1$s%2$s", (Object)strLogName, (Object)strExInfo), (Throwable)ex);
            throw ex;
        }
    }

    @PSModelRTMeta(description="\u6807\u9898")
    public String getCaption() {
        return this.strCaption;
    }

    @PSModelRTMeta(description="\u56fe\u5f62\u7c7b\u578b", codelist="ChartType")
    public String getSeriesType() {
        return this.psDEChartSeries.getCHARTTYPE();
    }

    public IPSChart getPSChart() {
        return this.iPSDEChart;
    }

    @PSModelRTMeta(description="\u5b9e\u4f53\u56fe\u8868\u5bf9\u8c61")
    public IPSDEChart getPSDEChart() {
        return this.iPSDEChart;
    }

    @PSModelRTMeta(description="\u5206\u7c7b\u5c5e\u6027")
    public String getCatalogField() {
        return this.strCatalogField;
    }

    @PSModelRTMeta(description="\u503c\u5c5e\u6027")
    public String getValueField() {
        return this.strValueField;
    }

    @PSModelRTMeta(description="\u503c2\u5c5e\u6027")
    public String getValue2Field() {
        return this.strValue2Field;
    }

    @Override
    public String getPSSysModelInstId() {
        return ((IPSModelObjectRuntime)this.iPSDEChart).getPSSysModelInstId();
    }

    public IPSChartAxes getXPSChartAxes() {
        return this.getXPSDEChartAxes();
    }

    public IPSChartAxes getYPSChartAxes() {
        return this.getYPSDEChartAxes();
    }

    @PSModelRTMeta(description="X\u5750\u6807\u8f74")
    public IPSDEChartAxes getXPSDEChartAxes() {
        return this.xPSDEChartAxes;
    }

    @PSModelRTMeta(description="Y\u5750\u6807\u8f74")
    public IPSDEChartAxes getYPSDEChartAxes() {
        return this.yPSDEChartAxes;
    }

    @PSModelRTMeta(description="\u6570\u636e\u5e8f\u5217\u8bc6\u522b\u5c5e\u6027")
    public String getSeriesField() {
        return this.strSeriesField;
    }

    @PSModelRTMeta(description="\u81ea\u52a8\u65f6\u95f4\u5206\u7ec4", codelist="ChartTimeGroupMode")
    public String getTimeGroupMode() {
        return this.strTimeGroupMode;
    }

    public String getValue3Field() {
        return this.strValue3Field;
    }

    public String getValue4Field() {
        return this.strValue4Field;
    }

    public String getValue5Field() {
        return this.strValue5Field;
    }

    public String getValue6Field() {
        return this.strValue6Field;
    }

    @PSModelRTMeta(description="\u5e8f\u5217\u4ee3\u7801\u8868\u5bf9\u8c61", hideempty2=true)
    public IPSCodeList getSeriesPSCodeList() {
        return this.seriesPSCodeList;
    }

    @PSModelRTMeta(description="\u5206\u7c7b\u4ee3\u7801\u8868\u5bf9\u8c61", hideempty2=true)
    public IPSCodeList getCatalogPSCodeList() {
        return this.catalogPSCodeList;
    }

    public String getCapLanResTag() {
        return null;
    }

    @Override
    public String getModelType() {
        return "PSDECHARTPARAM";
    }
}

