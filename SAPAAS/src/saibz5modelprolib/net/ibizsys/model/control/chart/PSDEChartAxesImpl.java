/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.control.chart.IPSChart
 *  net.ibizsys.model.control.chart.IPSDEChart
 *  net.ibizsys.model.control.chart.IPSDEChartAxes
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.control.chart;

import java.util.ArrayList;
import net.ibizsys.model.IPSModelObjectRuntime;
import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.PSModelRTMeta;
import net.ibizsys.model.PSModels;
import net.ibizsys.model.control.chart.IPSChart;
import net.ibizsys.model.control.chart.IPSDEChart;
import net.ibizsys.model.control.chart.IPSDEChartAxes;
import net.ibizsys.model.control.chart.IPSDEChartAxesRuntime;
import net.ibizsys.model.control.chart.PSChartAxesImpl;
import net.ibizsys.model.entity.PSDEChartAxes;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEChartAxesImpl
extends PSChartAxesImpl
implements IPSDEChartAxes,
IPSDEChartAxesRuntime {
    private static final Log log = LogFactory.getLog(PSDEChartAxesImpl.class);
    private IPSDEChart iPSDEChart;
    private PSDEChartAxes psDEChartAxes;
    private ArrayList<String> fieldList = new ArrayList();
    private String[] fields = null;
    private int nDataShowMode = 0;
    private Double fMaxValue = null;
    private Double fMinValue = null;

    @Override
    public void init(IPSModelStorageContext iPSModelStorageContext, IPSDEChart iPSDEChart, PSDEChartAxes psDEChartAxes) throws Exception {
        try {
            this.setPSModelStorageContext(iPSModelStorageContext);
            this.iPSDEChart = iPSDEChart;
            this.psDEChartAxes = psDEChartAxes;
            this.setId(this.psDEChartAxes.getPSDECHARTAXESID());
            this.setName(this.psDEChartAxes.getPSDECHARTAXESNAME());
            this.setPSObjectData(this.psDEChartAxes);
            if (!this.psDEChartAxes.isDATASHOWMODENull()) {
                this.nDataShowMode = this.psDEChartAxes.getDATASHOWMODE();
            }
            if (!StringHelper.isNullOrEmpty((String)this.psDEChartAxes.getFIELDS())) {
                String[] fields;
                String[] stringArray = fields = StringHelper.splitEx((String)this.psDEChartAxes.getFIELDS());
                int n = fields.length;
                int n2 = 0;
                while (n2 < n) {
                    String strField = stringArray[n2];
                    this.fieldList.add(strField.trim().toLowerCase());
                    ++n2;
                }
            }
            this.fields = new String[this.fieldList.size()];
            this.fields = this.fieldList.toArray(this.fields);
            if (!this.psDEChartAxes.isAXESMAXVALUENull()) {
                this.fMaxValue = this.psDEChartAxes.getParamDoubleValue("AXESMAXVALUE", 0.0);
            }
            if (!this.psDEChartAxes.isAXESMINVALUENull()) {
                this.fMinValue = this.psDEChartAxes.getParamDoubleValue("AXESMINVALUE", 0.0);
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

    @PSModelRTMeta(description="\u6807\u9898")
    public String getCaption() {
        return this.psDEChartAxes.getCAPTION();
    }

    @PSModelRTMeta(description="\u5750\u6807\u8f74\u7c7b\u578b", codelist="ChartAxesType")
    public String getAxesType() {
        return this.psDEChartAxes.getAXESTYPE();
    }

    @PSModelRTMeta(description="\u5750\u6807\u8f74\u4f4d\u7f6e", codelist="ChartAxesPos")
    public String getAxesPos() {
        return this.psDEChartAxes.getAXESPOS();
    }

    public IPSChart getPSChart() {
        return this.iPSDEChart;
    }

    @PSModelRTMeta(description="\u5b9e\u4f53\u56fe\u8868\u5bf9\u8c61")
    public IPSDEChart getPSDEChart() {
        return this.iPSDEChart;
    }

    public String[] getFields() {
        return this.fields;
    }

    @Override
    public String getPSSysModelInstId() {
        return ((IPSModelObjectRuntime)this.iPSDEChart).getPSSysModelInstId();
    }

    @PSModelRTMeta(description="\u6570\u636e\u663e\u793a\u6a21\u5f0f", codelist="ChartAxesDataShowMode")
    public int getDataShowMode() {
        return this.nDataShowMode;
    }

    @PSModelRTMeta(description="\u6700\u5927\u503c")
    public Double getMaxValue() {
        return this.fMaxValue;
    }

    @PSModelRTMeta(description="\u6700\u5c0f\u503c")
    public Double getMinValue() {
        return this.fMinValue;
    }

    @Override
    public String getModelType() {
        return "PSDECHARTAXES";
    }
}

