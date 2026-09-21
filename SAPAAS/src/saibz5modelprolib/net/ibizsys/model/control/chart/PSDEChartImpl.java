/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.control.IPSAjaxControlParam
 *  net.ibizsys.model.control.IPSControlContainer
 *  net.ibizsys.model.control.IPSControlParam
 *  net.ibizsys.model.control.chart.IPSChartLegend
 *  net.ibizsys.model.control.chart.IPSChartTitle
 *  net.ibizsys.model.control.chart.IPSDEChart
 *  net.ibizsys.model.control.chart.IPSDEChartAxes
 *  net.ibizsys.model.control.chart.IPSDEChartLegend
 *  net.ibizsys.model.control.chart.IPSDEChartParam
 *  net.ibizsys.model.control.chart.IPSDEChartSeries
 *  net.ibizsys.model.control.chart.IPSDEChartTitle
 *  net.ibizsys.model.dataentity.IPSDataEntity
 *  net.ibizsys.model.dataentity.ds.IPSDEDataSet
 *  net.ibizsys.model.dataentity.field.IPSDEField
 *  net.ibizsys.model.dataentity.logic.IPSDELogic
 *  net.ibizsys.paas.core.CallResult
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.control.chart;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;
import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.PSModelRTMeta;
import net.ibizsys.model.PSModels;
import net.ibizsys.model.control.IPSAjaxControlParam;
import net.ibizsys.model.control.IPSControlContainer;
import net.ibizsys.model.control.IPSControlParam;
import net.ibizsys.model.control.chart.IPSChartLegend;
import net.ibizsys.model.control.chart.IPSChartTitle;
import net.ibizsys.model.control.chart.IPSDEChart;
import net.ibizsys.model.control.chart.IPSDEChartAxes;
import net.ibizsys.model.control.chart.IPSDEChartAxesRuntime;
import net.ibizsys.model.control.chart.IPSDEChartLegend;
import net.ibizsys.model.control.chart.IPSDEChartParam;
import net.ibizsys.model.control.chart.IPSDEChartSeries;
import net.ibizsys.model.control.chart.IPSDEChartSeriesRuntime;
import net.ibizsys.model.control.chart.IPSDEChartTitle;
import net.ibizsys.model.control.chart.PSChartDataItemImpl;
import net.ibizsys.model.control.chart.PSChartImpl;
import net.ibizsys.model.control.chart.PSDEChartAxesImpl;
import net.ibizsys.model.control.chart.PSDEChartLegendImpl;
import net.ibizsys.model.control.chart.PSDEChartParamImpl;
import net.ibizsys.model.control.chart.PSDEChartSeriesImpl;
import net.ibizsys.model.control.chart.PSDEChartTitleImpl;
import net.ibizsys.model.dataentity.IPSDataEntity;
import net.ibizsys.model.dataentity.ds.IPSDEDataSet;
import net.ibizsys.model.dataentity.field.IPSDEField;
import net.ibizsys.model.dataentity.logic.IPSDELogic;
import net.ibizsys.model.entity.PSDEChart;
import net.ibizsys.model.entity.PSDEChartAxes;
import net.ibizsys.model.entity.PSDEChartSeries;
import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEChartImpl
extends PSChartImpl
implements IPSDEChart {
    private static final Log log = LogFactory.getLog(PSDEChartImpl.class);
    protected PSDEChart psDEChart;
    protected ArrayList<IPSDEChartAxes> psDEChartAxesList = new ArrayList();
    protected ArrayList<IPSDEChartSeries> psDEChartSeriesList = new ArrayList();
    protected PSDEChartParamImpl psDEChartParamImpl = new PSDEChartParamImpl();
    protected String strCodeName = "";
    protected IPSDEDataSet iPSDEDataSet = null;
    protected String strPSDEDataSetId = null;
    private String strActiveDataPSDELogicId = null;
    private IPSDELogic activeDataPSDELogic = null;
    private IPSDataEntity iPSDataEntity = null;
    private IPSDEChartTitle iPSDEChartTitle = null;
    private IPSDEChartLegend iPSDEChartLegend = null;
    private String strChartTheme = null;
    private String strEmptyText = null;
    private String strCoordinateSystem = null;

    @Override
    public void init(IPSModelStorageContext iPSModelStorageContext, IPSControlContainer iPSControlContainer, String strName, IPSControlParam iPSControlParam) throws Exception {
        try {
            this.setPSModelStorageContext(iPSModelStorageContext);
            this.setPSControlContainer(iPSControlContainer);
            IPSDEChartParam iPSDEChartParam = (IPSDEChartParam)iPSControlParam;
            this.psDEChart = new PSDEChart();
            CallResult callResult = this.getPSModelQueryHelper().getPSDEChart(iPSDEChartParam.getPSDEChartId(), this.psDEChart);
            if (callResult.isError()) {
                throw new Exception(StringHelper.format((String)"\u83b7\u53d6\u5b9e\u4f53\u56fe\u8868\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            this.setId(this.psDEChart.getPSDECHARTID());
            this.setName(strName);
            this.setLogicName(this.psDEChart.getPSDECHARTNAME());
            this.setPSObjectData(this.psDEChart);
            this.psDEChartParamImpl.setPSAjaxControlHandlerId(this.psDEChart.getPSACHANDLERID());
            this.psDEChartParamImpl.merge(iPSControlParam);
            this.strCodeName = this.psDEChart.getCODENAME();
            if (StringHelper.isNullOrEmpty((String)this.strCodeName)) {
                this.strCodeName = this.getName();
            }
            if (!StringHelper.isNullOrEmpty((String)this.strCodeName)) {
                String strHeader = this.strCodeName.substring(0, 1).toUpperCase();
                this.strCodeName = String.valueOf(strHeader) + this.strCodeName.substring(1);
            }
            if (!StringHelper.isNullOrEmpty((String)this.psDEChart.getCHARTTHEME())) {
                this.strChartTheme = this.psDEChart.getCHARTTHEME();
            }
            if (!StringHelper.isNullOrEmpty((String)this.psDEChart.getCOORDINATESYSTEM())) {
                this.strCoordinateSystem = this.psDEChart.getCOORDINATESYSTEM();
            }
            this.iPSDataEntity = this.getPSAppView().getPSApplication().getPSSystem().getPSDataEntity(this.psDEChart.getPSDEID());
            super.init(iPSModelStorageContext, iPSControlContainer, strName, iPSControlParam);
        }
        catch (Exception ex) {
            String strLogName = StringHelper.format((String)"%1$s[%2$s]", (Object)PSModels.getModelName(this.getModelType()), (Object)this.getFullModelName());
            String strExInfo = StringHelper.format((String)"\u521d\u59cb\u5316\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage());
            log.error((Object)StringHelper.format((String)"%1$s%2$s", (Object)strLogName, (Object)strExInfo), (Throwable)ex);
            throw ex;
        }
    }

    @Override
    protected void onInit() throws Exception {
        super.onInit();
        this.onPreparePSDEChartTitle();
        this.onPreparePSDEChartLegend();
        this.onPreparePSDEDataSet();
        this.onPreparePSDEChartAxeses();
        this.onPreparePSDEChartSerieses();
        this.onPreparePSDEChartDataItems();
    }

    protected void onPreparePSDEChartTitle() throws Exception {
        PSDEChartTitleImpl psDEChartTitleImpl = new PSDEChartTitleImpl();
        psDEChartTitleImpl.init(this.getPSModelStorageContext(), this, this.psDEChart);
        this.setPSDEChartTitle(psDEChartTitleImpl);
    }

    protected void onPreparePSDEChartLegend() throws Exception {
        PSDEChartLegendImpl psDEChartLegendImpl = new PSDEChartLegendImpl();
        psDEChartLegendImpl.init(this.getPSModelStorageContext(), this, this.psDEChart);
        this.setPSDEChartLegend(psDEChartLegendImpl);
    }

    protected void onPreparePSDEDataSet() throws Exception {
        this.strPSDEDataSetId = this.psDEChartParamImpl.getPSDEDataSetId();
        if (StringHelper.isNullOrEmpty((String)this.strPSDEDataSetId)) {
            this.strPSDEDataSetId = this.psDEChart.getPSDEDSID();
        }
        if (!StringHelper.isNullOrEmpty((String)this.strPSDEDataSetId)) {
            this.iPSDEDataSet = this.getPSDataEntity().getPSDEDataSet(this.strPSDEDataSetId);
        }
        this.strActiveDataPSDELogicId = this.psDEChartParamImpl.getActiveDataPSDELogicId();
        if (StringHelper.isNullOrEmpty((String)this.strActiveDataPSDELogicId)) {
            this.strActiveDataPSDELogicId = this.psDEChart.getADPSDELOGICID();
        }
        if (!StringHelper.isNullOrEmpty((String)this.strActiveDataPSDELogicId)) {
            this.activeDataPSDELogic = this.getPSDataEntity().getPSDELogic(this.strActiveDataPSDELogicId);
        }
    }

    protected void onPreparePSDEChartAxeses() throws Exception {
        this.psDEChartAxesList.clear();
        Vector<PSDEChartAxes> psDEChartAxesList = new Vector<PSDEChartAxes>();
        CallResult callResult = this.getPSModelQueryHelper().getPSDEChartAxeses(this.getId(), psDEChartAxesList);
        if (callResult.isError()) {
            throw new Exception(StringHelper.format((String)"\u67e5\u8be2\u56fe\u8868\u5750\u6807\u8f74\u96c6\u5408\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        for (PSDEChartAxes psDEChartAxes : psDEChartAxesList) {
            PSDEChartAxesImpl iPSDEChartAxes = new PSDEChartAxesImpl();
            ((IPSDEChartAxesRuntime)iPSDEChartAxes).init(this.getPSModelStorageContext(), this, psDEChartAxes);
            this.psDEChartAxesList.add(iPSDEChartAxes);
            this.addPSChartAxes(iPSDEChartAxes);
        }
    }

    protected void onPreparePSDEChartSerieses() throws Exception {
        this.psDEChartSeriesList.clear();
        Vector<PSDEChartSeries> psDEChartSeriesList = new Vector<PSDEChartSeries>();
        CallResult callResult = this.getPSModelQueryHelper().getPSDEChartSerieses(this.getId(), psDEChartSeriesList);
        if (callResult.isError()) {
            throw new Exception(StringHelper.format((String)"\u67e5\u8be2\u56fe\u8868\u6570\u636e\u5e8f\u5217\u96c6\u5408\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        for (PSDEChartSeries psDEChartSeries : psDEChartSeriesList) {
            PSDEChartSeriesImpl iPSDEChartSeries = new PSDEChartSeriesImpl();
            ((IPSDEChartSeriesRuntime)iPSDEChartSeries).init(this.getPSModelStorageContext(), this, psDEChartSeries);
            this.psDEChartSeriesList.add(iPSDEChartSeries);
            this.addPSChartSeries(iPSDEChartSeries);
        }
    }

    protected void onPreparePSDEChartDataItems() throws Exception {
        HashMap<String, PSChartDataItemImpl> psChartDataItemMap = new HashMap<String, PSChartDataItemImpl>();
        for (IPSDEChartAxes iPSDEChartAxes : this.psDEChartAxesList) {
            String[] fields;
            String[] stringArray = fields = iPSDEChartAxes.getFields();
            int n = fields.length;
            int n2 = 0;
            while (n2 < n) {
                String strField = stringArray[n2];
                String strName = strField.toLowerCase();
                int nStdDataType = -1;
                nStdDataType = StringHelper.compare((String)iPSDEChartAxes.getAxesType(), (String)"numeric", (boolean)true) == 0 ? 14 : (StringHelper.compare((String)iPSDEChartAxes.getAxesType(), (String)"time", (boolean)true) == 0 ? 5 : this.calcFieldStdDataType(strName));
                if (!psChartDataItemMap.containsKey(strName)) {
                    nStdDataType = this.calcFieldStdDataType(strName);
                    PSChartDataItemImpl psChartDataItemImpl = new PSChartDataItemImpl();
                    psChartDataItemImpl.setName(strName);
                    psChartDataItemImpl.setDataType(nStdDataType);
                    if (this.getPSSystemSetting() != null) {
                        psChartDataItemImpl.setFormat(this.getPSSystemSetting().getValueFormat());
                    }
                    psChartDataItemMap.put(strName, psChartDataItemImpl);
                    this.addPSChartDataItem(psChartDataItemImpl);
                }
                ++n2;
            }
        }
        for (IPSDEChartSeries iPSDEChartSeries : this.psDEChartSeriesList) {
            String strName;
            if (!StringHelper.isNullOrEmpty((String)iPSDEChartSeries.getCatalogField()) && !psChartDataItemMap.containsKey(strName = iPSDEChartSeries.getCatalogField().toLowerCase())) {
                int nStdDataType = this.calcFieldStdDataType(strName);
                PSChartDataItemImpl psChartDataItemImpl = new PSChartDataItemImpl();
                psChartDataItemImpl.setName(strName);
                psChartDataItemImpl.setDataType(nStdDataType);
                if (this.getPSSystemSetting() != null) {
                    psChartDataItemImpl.setFormat(this.getPSSystemSetting().getValueFormat());
                }
                psChartDataItemMap.put(strName, psChartDataItemImpl);
                this.addPSChartDataItem(psChartDataItemImpl);
            }
            if (!StringHelper.isNullOrEmpty((String)iPSDEChartSeries.getValueField()) && !psChartDataItemMap.containsKey(strName = iPSDEChartSeries.getValueField().toLowerCase())) {
                int nStdDataType = this.calcFieldStdDataType(strName);
                PSChartDataItemImpl psChartDataItemImpl = new PSChartDataItemImpl();
                psChartDataItemImpl.setName(strName);
                psChartDataItemImpl.setDataType(nStdDataType);
                if (this.getPSSystemSetting() != null) {
                    psChartDataItemImpl.setFormat(this.getPSSystemSetting().getValueFormat());
                }
                psChartDataItemMap.put(strName, psChartDataItemImpl);
                this.addPSChartDataItem(psChartDataItemImpl);
            }
            if (StringHelper.isNullOrEmpty((String)iPSDEChartSeries.getValue2Field()) || psChartDataItemMap.containsKey(strName = iPSDEChartSeries.getValue2Field().toLowerCase())) continue;
            int nStdDataType = this.calcFieldStdDataType(strName);
            PSChartDataItemImpl psChartDataItemImpl = new PSChartDataItemImpl();
            psChartDataItemImpl.setName(strName);
            psChartDataItemImpl.setDataType(nStdDataType);
            if (this.getPSSystemSetting() != null) {
                psChartDataItemImpl.setFormat(this.getPSSystemSetting().getValueFormat());
            }
            psChartDataItemMap.put(strName, psChartDataItemImpl);
            this.addPSChartDataItem(psChartDataItemImpl);
        }
    }

    protected int calcFieldStdDataType(String strFieldName) throws Exception {
        this.getPSDEDataSet();
        IPSDEField iPSDEField = this.getPSDataEntity().getPSDEField(strFieldName, true);
        if (iPSDEField != null) {
            return iPSDEField.getStdDataType();
        }
        log.warn((Object)StringHelper.format((String)"\u65e0\u6cd5\u8ba1\u7b97\u5c5e\u6027[%1$s]\u6570\u636e\u7c7b\u578b", (Object)strFieldName));
        return 25;
    }

    public String getControlType() {
        return "CHART";
    }

    public Iterator<IPSDEChartAxes> getPSDEChartAxeses() {
        return this.psDEChartAxesList.iterator();
    }

    @PSModelRTMeta(description="\u56fe\u8868\u5750\u6807\u8f74\u96c6\u5408")
    public Iterator<IPSDEChartSeries> getPSDEChartSerieses() {
        return this.psDEChartSeriesList.iterator();
    }

    @Override
    public IPSAjaxControlParam getPSAjaxControlParam() {
        return this.psDEChartParamImpl;
    }

    @PSModelRTMeta(description="\u5b9e\u4f53\u6570\u636e\u96c6\u5bf9\u8c61", hideempty=true)
    public IPSDEDataSet getPSDEDataSet() {
        return this.iPSDEDataSet;
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u5bf9\u8c61", hideempty=true)
    public IPSDataEntity getPSDataEntity() {
        return this.iPSDataEntity;
    }

    @PSModelRTMeta(description="\u5b9e\u4f53\u56fe\u8868\u6807\u9898\u5bf9\u8c61")
    public IPSDEChartTitle getPSDEChartTitle() {
        return this.iPSDEChartTitle;
    }

    protected void setPSDEChartTitle(IPSDEChartTitle iPSDEChartTitle) {
        this.iPSDEChartTitle = iPSDEChartTitle;
    }

    public String getChartTheme() {
        return this.strChartTheme;
    }

    public IPSChartTitle getPSChartTitle() {
        return this.getPSDEChartTitle();
    }

    public ArrayList<IPSDEChartAxes> getPSDEChartAxesesByPos(String strPos) {
        ArrayList<IPSDEChartAxes> list = new ArrayList<IPSDEChartAxes>();
        boolean bX = false;
        boolean bY = false;
        if (StringHelper.compare((String)strPos, (String)"x", (boolean)true) == 0) {
            bX = true;
        } else if (StringHelper.compare((String)strPos, (String)"y", (boolean)true) == 0) {
            bY = true;
        }
        for (IPSDEChartAxes iPSDEChartAxes : this.psDEChartAxesList) {
            if (bX && (StringHelper.compare((String)iPSDEChartAxes.getAxesPos(), (String)"top", (boolean)true) == 0 || StringHelper.compare((String)iPSDEChartAxes.getAxesPos(), (String)"bottom", (boolean)true) == 0)) {
                list.add(iPSDEChartAxes);
                continue;
            }
            if (!bY || StringHelper.compare((String)iPSDEChartAxes.getAxesPos(), (String)"left", (boolean)true) != 0 && StringHelper.compare((String)iPSDEChartAxes.getAxesPos(), (String)"right", (boolean)true) != 0) continue;
            list.add(iPSDEChartAxes);
        }
        return list;
    }

    public IPSDEChartAxes getPSDEChartAxes(String strPSDEChartAxesId) throws Exception {
        for (IPSDEChartAxes iPSDEChartAxes : this.psDEChartAxesList) {
            if (StringHelper.compare((String)iPSDEChartAxes.getId(), (String)strPSDEChartAxesId, (boolean)false) != 0) continue;
            return iPSDEChartAxes;
        }
        throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u5750\u6807\u8f74[%1$s]", (Object)strPSDEChartAxesId));
    }

    public String getEmptyText() {
        return this.strEmptyText;
    }

    public IPSDEChartLegend getPSDEChartLegend() {
        return this.iPSDEChartLegend;
    }

    public IPSChartLegend getPSChartLegend() {
        return this.getPSDEChartLegend();
    }

    protected void setPSDEChartLegend(IPSDEChartLegend iPSDEChartLegend) {
        this.iPSDEChartLegend = iPSDEChartLegend;
    }

    public String getCoordinateSystem() {
        return this.strCoordinateSystem;
    }

    @PSModelRTMeta(description="\u6570\u636e\u96c6\u5408\u4e0a\u4e0b\u6587\u6570\u636e\u8f6c\u6362\u903b\u8f91")
    public IPSDELogic getActiveDataPSDELogic() {
        return this.activeDataPSDELogic;
    }

    @Override
    public String getModelType() {
        return "PSDECHART";
    }
}

