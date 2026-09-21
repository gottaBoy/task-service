/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.util.ObjectHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Control.Chart;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEField;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEUILogicGroupDetail;
import SA.SRFDA.PS.Core.Control.Chart.IPSChartAxes;
import SA.SRFDA.PS.Core.Control.Chart.IPSChartCoordinateSystem;
import SA.SRFDA.PS.Core.Control.Chart.IPSChartDataGrid;
import SA.SRFDA.PS.Core.Control.Chart.IPSChartLegend;
import SA.SRFDA.PS.Core.Control.Chart.IPSChartRuntime;
import SA.SRFDA.PS.Core.Control.Chart.IPSChartSeries;
import SA.SRFDA.PS.Core.Control.Chart.IPSChartTitle;
import SA.SRFDA.PS.Core.Control.Chart.IPSDEChart;
import SA.SRFDA.PS.Core.Control.Chart.IPSDEChartAxes;
import SA.SRFDA.PS.Core.Control.Chart.IPSDEChartCoordinateSystem;
import SA.SRFDA.PS.Core.Control.Chart.IPSDEChartDataGrid;
import SA.SRFDA.PS.Core.Control.Chart.IPSDEChartLegend;
import SA.SRFDA.PS.Core.Control.Chart.IPSDEChartLogic;
import SA.SRFDA.PS.Core.Control.Chart.IPSDEChartParam;
import SA.SRFDA.PS.Core.Control.Chart.IPSDEChartSeries;
import SA.SRFDA.PS.Core.Control.Chart.IPSDEChartTitle;
import SA.SRFDA.PS.Core.Control.Chart.IPSEChartsObjectRuntime;
import SA.SRFDA.PS.Core.Control.Chart.PSChartDataItemImpl;
import SA.SRFDA.PS.Core.Control.Chart.PSChartImpl;
import SA.SRFDA.PS.Core.Control.Chart.PSDEChartAxesImpl;
import SA.SRFDA.PS.Core.Control.Chart.PSDEChartCoordinateSystemCalendarImpl;
import SA.SRFDA.PS.Core.Control.Chart.PSDEChartCoordinateSystemCartesian2DImpl;
import SA.SRFDA.PS.Core.Control.Chart.PSDEChartCoordinateSystemGeoImpl;
import SA.SRFDA.PS.Core.Control.Chart.PSDEChartCoordinateSystemNoneImpl;
import SA.SRFDA.PS.Core.Control.Chart.PSDEChartCoordinateSystemParallelImpl;
import SA.SRFDA.PS.Core.Control.Chart.PSDEChartCoordinateSystemPolarImpl;
import SA.SRFDA.PS.Core.Control.Chart.PSDEChartCoordinateSystemRadarImpl;
import SA.SRFDA.PS.Core.Control.Chart.PSDEChartCoordinateSystemSingleImpl;
import SA.SRFDA.PS.Core.Control.Chart.PSDEChartDataGridImpl;
import SA.SRFDA.PS.Core.Control.Chart.PSDEChartLegendImpl;
import SA.SRFDA.PS.Core.Control.Chart.PSDEChartLogicImpl;
import SA.SRFDA.PS.Core.Control.Chart.PSDEChartParamImpl;
import SA.SRFDA.PS.Core.Control.Chart.PSDEChartSeriesBarImpl;
import SA.SRFDA.PS.Core.Control.Chart.PSDEChartSeriesCandlestickImpl;
import SA.SRFDA.PS.Core.Control.Chart.PSDEChartSeriesCustomImpl;
import SA.SRFDA.PS.Core.Control.Chart.PSDEChartSeriesFunnelImpl;
import SA.SRFDA.PS.Core.Control.Chart.PSDEChartSeriesGaugeImpl;
import SA.SRFDA.PS.Core.Control.Chart.PSDEChartSeriesImpl;
import SA.SRFDA.PS.Core.Control.Chart.PSDEChartSeriesLineImpl;
import SA.SRFDA.PS.Core.Control.Chart.PSDEChartSeriesMapImpl;
import SA.SRFDA.PS.Core.Control.Chart.PSDEChartSeriesPieImpl;
import SA.SRFDA.PS.Core.Control.Chart.PSDEChartSeriesRadarImpl;
import SA.SRFDA.PS.Core.Control.Chart.PSDEChartSeriesScatterImpl;
import SA.SRFDA.PS.Core.Control.Chart.PSDEChartTitleImpl;
import SA.SRFDA.PS.Core.Control.IPSAjaxControlParam;
import SA.SRFDA.PS.Core.Control.IPSControlContainer;
import SA.SRFDA.PS.Core.Control.IPSControlParam;
import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSet;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSetGroupParam;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogic;
import SA.SRFDA.PS.Core.DynaModel.IPSSysDynaModel;
import SA.SRFDA.PS.Core.PSModelImplementMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import SA.SRFDA.PS.Data.PSDEChart;
import SA.SRFDA.PS.Data.PSDEChartAxes;
import SA.SRFDA.PS.Data.PSDEChartCS;
import SA.SRFDA.PS.Data.PSDEChartLogic;
import SA.SRFDA.PS.Data.PSDEChartSeries;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import net.ibizsys.paas.util.ObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelImplementMeta(implement="IPSControl", typevalues={"CHART"})
public class PSDEChartImpl
extends PSChartImpl
implements IPSDEChart,
IPSChartRuntime {
    private static final Log log = LogFactory.getLog(PSDEChartImpl.class);
    private static final Map<String, String> seriesMap = new HashMap<String, String>();
    private static final Map<String, String> coordinateSystemMap = new HashMap<String, String>();
    protected PSDEChart psDEChart;
    protected ArrayList<IPSDEChartAxes> psDEChartAxesList = new ArrayList();
    protected ArrayList<IPSDEChartSeries> psDEChartSeriesList = new ArrayList();
    protected PSDEChartParamImpl psDEChartParamImpl = null;
    protected String strCodeName = "";
    protected IPSDEDataSet iPSDEDataSet = null;
    protected String strPSDEDataSetId = null;
    private String strActiveDataPSDELogicId = null;
    private IPSDELogic activeDataPSDELogic = null;
    private IPSDEChartTitle iPSDEChartTitle = null;
    private IPSDEChartLegend iPSDEChartLegend = null;
    private IPSDEChartDataGrid iPSDEChartDataGrid = null;
    private String strChartTheme = null;
    private String strEmptyText = null;
    private IPSLanguageRes emptyTextPSLanguageRes = null;
    private String strCoordinateSystem = null;
    private List<IPSChartCoordinateSystem> psChartCoordinateSystemList = new ArrayList<IPSChartCoordinateSystem>();
    protected IPSDEField minorPSDEField = null;
    protected String strMinorSortDir = "";
    private IPSAppDEField minorPSAppDEField = null;
    private boolean bInvalidId = false;
    protected List<PSDEChartLogicImpl> psDEChartLogicList = new ArrayList<PSDEChartLogicImpl>();

    static {
        seriesMap.put("area", PSDEChartSeriesLineImpl.class.getName());
        seriesMap.put("line", PSDEChartSeriesLineImpl.class.getName());
        seriesMap.put("pie", PSDEChartSeriesPieImpl.class.getName());
        seriesMap.put("pie3d", PSDEChartSeriesPieImpl.class.getName());
        seriesMap.put("bar", PSDEChartSeriesBarImpl.class.getName());
        seriesMap.put("bar3d", PSDEChartSeriesBarImpl.class.getName());
        seriesMap.put("candlestick", PSDEChartSeriesCandlestickImpl.class.getName());
        seriesMap.put("gauge", PSDEChartSeriesGaugeImpl.class.getName());
        seriesMap.put("radar", PSDEChartSeriesRadarImpl.class.getName());
        seriesMap.put("scatter", PSDEChartSeriesScatterImpl.class.getName());
        seriesMap.put("column", PSDEChartSeriesBarImpl.class.getName());
        seriesMap.put("funnel", PSDEChartSeriesFunnelImpl.class.getName());
        seriesMap.put("map", PSDEChartSeriesMapImpl.class.getName());
        seriesMap.put("custom", PSDEChartSeriesCustomImpl.class.getName());
        coordinateSystemMap.put("XY", PSDEChartCoordinateSystemCartesian2DImpl.class.getName());
        coordinateSystemMap.put("MAP", PSDEChartCoordinateSystemGeoImpl.class.getName());
        coordinateSystemMap.put("CALENDAR", PSDEChartCoordinateSystemCalendarImpl.class.getName());
        coordinateSystemMap.put("PARALLEL", PSDEChartCoordinateSystemParallelImpl.class.getName());
        coordinateSystemMap.put("POLAR", PSDEChartCoordinateSystemPolarImpl.class.getName());
        coordinateSystemMap.put("RADAR", PSDEChartCoordinateSystemRadarImpl.class.getName());
        coordinateSystemMap.put("SINGLE", PSDEChartCoordinateSystemSingleImpl.class.getName());
        coordinateSystemMap.put("NONE", PSDEChartCoordinateSystemNoneImpl.class.getName());
    }

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSControlContainer iPSControlContainer, String strName, IPSControlParam iPSControlParam) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSControlContainer(iPSControlContainer);
            IPSDEChartParam iPSDEChartParam = (IPSDEChartParam)iPSControlParam;
            this.psDEChart = new PSDEChart();
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)iPSDEChartParam.getPSDEChartId())) {
                CallResult callResult = this.getPSModelHelper().getPSDEChart(iPSDEChartParam.getPSDEChartId(), this.psDEChart);
                if (callResult.isError()) {
                    throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u83b7\u53d6\u5b9e\u4f53\u56fe\u8868\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                this.setId(this.psDEChart.getPSDECHARTID());
            } else {
                this.setId(SA.SRFramework.Utility.StringHelper.Format((String)"%1$s_%2$s", (Object)this.getPSAppView().getId(), (Object)strName));
                this.bInvalidId = true;
            }
            this.setName(strName);
            this.setLogicName(this.psDEChart.getPSDECHARTNAME());
            this.setPSObjectData(this.psDEChart);
            if (!(this.getPSDataEntity() != null && SA.SRFramework.Utility.StringHelper.Compare((String)this.psDEChart.getPSDEID(), (String)this.getPSDataEntity().getId(), (boolean)true) == 0 || SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEChart.getPSDEID()))) {
                this.setPSDataEntity(this.getPSAppView().getPSSystem().getPSDataEntity2(this.psDEChart.getPSDEID()));
            }
            this.psDEChartParamImpl = this.createPSDEChartParam();
            this.psDEChartParamImpl.merge(iPSControlParam);
            this.strCodeName = this.psDEChart.getCODENAME();
            if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strCodeName)) {
                this.strCodeName = this.getName();
            }
            if (!(SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strCodeName) || this.getPSSystem() != null && this.getPSSystem().getPSSystemSetting().isFixCodeNameAutoCapitalize())) {
                String strHeader = this.strCodeName.substring(0, 1).toUpperCase();
                this.strCodeName = String.valueOf(strHeader) + this.strCodeName.substring(1);
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEChart.getCHARTTHEME())) {
                this.strChartTheme = this.psDEChart.getCHARTTHEME();
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEChart.getCOORDINATESYSTEM())) {
                this.strCoordinateSystem = this.psDEChart.getCOORDINATESYSTEM();
            }
            this.strEmptyText = this.psDEChart.getEMPTYTEXT();
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEChart.getEMPTYTEXTPSLANRESID())) {
                this.emptyTextPSLanguageRes = this.getPSAppView().getPSApplication().getPSLanguageRes(this.psDEChart.getEMPTYTEXTPSLANRESID());
            }
            super.init(iDAGlobalHelper, iPSControlContainer, strName, this.psDEChartParamImpl);
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
    protected void onInit() throws Exception {
        String strMinorSortPSDEFName = this.psDEChart.getMINORSORTPSDEFNAME();
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)strMinorSortPSDEFName)) {
            this.minorPSDEField = this.getPSDataEntity().getPSDEField(strMinorSortPSDEFName);
            this.strMinorSortDir = this.psDEChart.getMINORSORTDIR();
            if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strMinorSortDir)) {
                this.strMinorSortDir = "ASC";
            }
            if (this.getPSAppDataEntity() != null && this.getMinorSortPSDEF() != null) {
                this.minorPSAppDEField = this.getPSAppDataEntity().getPSAppDEField(this.getMinorSortPSDEF(), true);
            }
        }
        super.onInit();
        if (!this.bInvalidId) {
            this.onPreparePSDEChartTitle();
            this.onPreparePSDEChartLegend();
            this.onPreparePSDEChartDataGrid();
            this.onPreparePSDEDataSet();
            this.onPreparePSDEChartAxeses();
            this.onPreparePSDEChartCoordinateSystem();
            this.onPreparePSDEChartSerieses();
            this.onPreparePSDEChartDataItems();
            this.onPreparePSDEChartLogics();
        }
        this.initNavParams(this.psDEChart);
    }

    protected PSDEChartParamImpl createPSDEChartParam() {
        PSDEChartParamImpl psDEChartParamImpl = new PSDEChartParamImpl();
        psDEChartParamImpl.setPSSysPFPluginId(this.psDEChart.getPSSYSPFPLUGINID());
        psDEChartParamImpl.setPSAjaxControlHandlerId(this.psDEChart.getPSACHANDLERID());
        psDEChartParamImpl.setActiveDataPSDELogicId(this.psDEChart.getADPSDELOGICID());
        psDEChartParamImpl.setPSSysCssId(this.psDEChart.getPSSYSCSSID());
        psDEChartParamImpl.setPSDEUILogicGroupId(this.psDEChart.getPSCTRLLOGICGROUPID());
        psDEChartParamImpl.setPSDEDataSetId(this.psDEChart.getPSDEDSID());
        try {
            if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEChart.getPSDEDSID()) && this.getPSDataEntity() != null && this.getPSDataEntity().getDefaultPSDEDataSet() != null) {
                psDEChartParamImpl.setPSDEDataSetId(this.getPSDataEntity().getDefaultPSDEDataSet().getId());
            }
        }
        catch (Exception ex) {
            log.error((Object)ex);
        }
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)psDEChartParamImpl.getPSDEDataSetId())) {
            psDEChartParamImpl.setCustomCond(this.psDEChart.getCUSTOMCOND());
        }
        return psDEChartParamImpl;
    }

    protected void onPreparePSDEChartTitle() throws Exception {
        PSDEChartTitleImpl psDEChartTitleImpl = new PSDEChartTitleImpl();
        psDEChartTitleImpl.init(this.getDAGlobalHelper(), this, this.psDEChart);
        this.setPSDEChartTitle(psDEChartTitleImpl);
    }

    protected void onPreparePSDEChartLegend() throws Exception {
        PSDEChartLegendImpl psDEChartLegendImpl = new PSDEChartLegendImpl();
        psDEChartLegendImpl.init(this.getDAGlobalHelper(), this, this.psDEChart);
        this.setPSDEChartLegend(psDEChartLegendImpl);
    }

    protected void onPreparePSDEChartDataGrid() throws Exception {
        PSDEChartDataGridImpl psDEChartDataGridImpl = new PSDEChartDataGridImpl();
        psDEChartDataGridImpl.init(this.getDAGlobalHelper(), this, this.psDEChart);
        this.setPSDEChartDataGrid(psDEChartDataGridImpl);
    }

    protected void onPreparePSDEChartCoordinateSystem() throws Exception {
    }

    protected void onPreparePSDEDataSet() throws Exception {
        this.strPSDEDataSetId = this.psDEChartParamImpl.getPSDEDataSetId();
        if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strPSDEDataSetId)) {
            this.strPSDEDataSetId = this.psDEChart.getPSDEDSID();
        }
        this.iPSDEDataSet = !SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strPSDEDataSetId) ? this.getPSDataEntity().getPSDEDataSet(this.strPSDEDataSetId) : this.getPSDataEntity().getDefaultPSDEDataSet();
        this.strActiveDataPSDELogicId = this.psDEChartParamImpl.getActiveDataPSDELogicId();
        if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strActiveDataPSDELogicId)) {
            this.strActiveDataPSDELogicId = this.psDEChart.getADPSDELOGICID();
        }
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strActiveDataPSDELogicId)) {
            this.activeDataPSDELogic = this.getPSDataEntity().getPSDELogic(this.strActiveDataPSDELogicId);
        }
    }

    protected void onPreparePSDEChartAxeses() throws Exception {
        this.psDEChartAxesList.clear();
        Vector<PSDEChartAxes> psDEChartAxesList = new Vector<PSDEChartAxes>();
        CallResult callResult = this.getPSModelHelper().getPSDEChartAxeses(this.getId(), psDEChartAxesList);
        if (callResult.isError()) {
            throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u67e5\u8be2\u56fe\u8868\u5750\u6807\u8f74\u96c6\u5408\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        for (PSDEChartAxes psDEChartAxes : psDEChartAxesList) {
            PSDEChartAxesImpl iPSDEChartAxes = new PSDEChartAxesImpl();
            iPSDEChartAxes.init(this.getDAGlobalHelper(), this, psDEChartAxes);
            this.psDEChartAxesList.add(iPSDEChartAxes);
        }
    }

    protected void onPreparePSDEChartSerieses() throws Exception {
        this.psDEChartSeriesList.clear();
        Vector<PSDEChartSeries> psDEChartSeriesList = new Vector<PSDEChartSeries>();
        CallResult callResult = this.getPSModelHelper().getPSDEChartSerieses(this.getId(), psDEChartSeriesList);
        if (callResult.isError()) {
            throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u67e5\u8be2\u56fe\u8868\u6570\u636e\u5e8f\u5217\u96c6\u5408\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        for (PSDEChartSeries psDEChartSeries : psDEChartSeriesList) {
            IPSDEChartSeries iPSDEChartSeries = null;
            String strSeriesObject = null;
            if (SA.SRFramework.Utility.StringHelper.Compare((String)this.getPSSystemUtil().getTemplEngineVer(), (String)"V2", (boolean)true) == 0) {
                strSeriesObject = seriesMap.get(psDEChartSeries.getCHARTTYPE());
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty(strSeriesObject)) {
                iPSDEChartSeries = (IPSDEChartSeries)ObjectHelper.create(strSeriesObject);
                if (iPSDEChartSeries == null) {
                    throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u65e0\u6cd5\u5efa\u7acb\u56fe\u8868\u6570\u636e\u5e8f\u5217\u5bf9\u8c61\uff0c\u7c7b\u578b\u4e3a[%1$s]", (Object)psDEChartSeries.getCHARTTYPE()));
                }
            } else {
                iPSDEChartSeries = new PSDEChartSeriesImpl();
            }
            iPSDEChartSeries.init(this.getDAGlobalHelper(), this, psDEChartSeries);
            int nIndex = this.psDEChartSeriesList.size();
            ((IPSEChartsObjectRuntime)((Object)iPSDEChartSeries)).setIndex(nIndex);
            this.psDEChartSeriesList.add(iPSDEChartSeries);
        }
    }

    protected void onPreparePSDEChartDataItems() throws Exception {
        boolean bUseDTO = false;
        if (this.getPSAppView() != null && this.getPSAppView().getPSApplication() != null) {
            bUseDTO = this.getPSAppView().getPSApplication().isUseServiceApi();
        }
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
                nStdDataType = SA.SRFramework.Utility.StringHelper.Compare((String)iPSDEChartAxes.getAxesType(), (String)"numeric", (boolean)true) == 0 ? 14 : (SA.SRFramework.Utility.StringHelper.Compare((String)iPSDEChartAxes.getAxesType(), (String)"time", (boolean)true) == 0 ? 5 : this.calcFieldStdDataType(strName));
                if (!psChartDataItemMap.containsKey(strName)) {
                    nStdDataType = this.calcFieldStdDataType(strName);
                    PSChartDataItemImpl psChartDataItemImpl = new PSChartDataItemImpl();
                    psChartDataItemImpl.setName(strName);
                    psChartDataItemImpl.setDataType(nStdDataType);
                    if (!bUseDTO) {
                        if (this.getPSSystemSetting() != null) {
                            psChartDataItemImpl.setFormat(this.getPSSystemSetting().getValueFormat());
                        }
                    } else {
                        psChartDataItemImpl.setFormat("");
                    }
                    psChartDataItemMap.put(strName, psChartDataItemImpl);
                    this.addPSChartDataItem(psChartDataItemImpl);
                }
                ++n2;
            }
        }
        for (IPSDEChartSeries iPSDEChartSeries : this.psDEChartSeriesList) {
            String strName;
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)iPSDEChartSeries.getCatalogField()) && !psChartDataItemMap.containsKey(strName = iPSDEChartSeries.getCatalogField().toLowerCase())) {
                int nStdDataType = this.calcFieldStdDataType(strName);
                PSChartDataItemImpl psChartDataItemImpl = new PSChartDataItemImpl();
                psChartDataItemImpl.setName(strName);
                psChartDataItemImpl.setDataType(nStdDataType);
                if (!bUseDTO) {
                    if (this.getPSSystemSetting() != null) {
                        psChartDataItemImpl.setFormat(this.getPSSystemSetting().getValueFormat());
                    }
                } else {
                    psChartDataItemImpl.setFormat("");
                }
                psChartDataItemMap.put(strName, psChartDataItemImpl);
                this.addPSChartDataItem(psChartDataItemImpl);
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)iPSDEChartSeries.getValueField()) && !psChartDataItemMap.containsKey(strName = iPSDEChartSeries.getValueField().toLowerCase())) {
                int nStdDataType = this.calcFieldStdDataType(strName);
                PSChartDataItemImpl psChartDataItemImpl = new PSChartDataItemImpl();
                psChartDataItemImpl.setName(strName);
                psChartDataItemImpl.setDataType(nStdDataType);
                if (!bUseDTO) {
                    if (this.getPSSystemSetting() != null) {
                        psChartDataItemImpl.setFormat(this.getPSSystemSetting().getValueFormat());
                    }
                } else {
                    psChartDataItemImpl.setFormat("");
                }
                psChartDataItemMap.put(strName, psChartDataItemImpl);
                this.addPSChartDataItem(psChartDataItemImpl);
            }
            if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)iPSDEChartSeries.getValue2Field()) || psChartDataItemMap.containsKey(strName = iPSDEChartSeries.getValue2Field().toLowerCase())) continue;
            int nStdDataType = this.calcFieldStdDataType(strName);
            PSChartDataItemImpl psChartDataItemImpl = new PSChartDataItemImpl();
            psChartDataItemImpl.setName(strName);
            psChartDataItemImpl.setDataType(nStdDataType);
            if (!bUseDTO) {
                if (this.getPSSystemSetting() != null) {
                    psChartDataItemImpl.setFormat(this.getPSSystemSetting().getValueFormat());
                }
            } else {
                psChartDataItemImpl.setFormat("");
            }
            psChartDataItemMap.put(strName, psChartDataItemImpl);
            this.addPSChartDataItem(psChartDataItemImpl);
        }
    }

    protected void onPreparePSDEChartLogics() throws Exception {
        this.psDEChartLogicList.clear();
        this.onPreparePSDEChartLogics(this.getId());
    }

    protected void onPreparePSDEChartLogics(String strPSDEChartId) throws Exception {
        Vector<PSDEChartLogic> psDEChartLogicList = new Vector<PSDEChartLogic>();
        CallResult callResult = this.getPSModelHelper().getPSDEChartLogics(strPSDEChartId, psDEChartLogicList);
        if (callResult.isError()) {
            throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u67e5\u8be2\u56fe\u8868\u903b\u8f91\u96c6\u5408\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        for (PSDEChartLogic psDEChartLogic : psDEChartLogicList) {
            PSDEChartLogicImpl psDEChartLogicImpl = new PSDEChartLogicImpl();
            psDEChartLogicImpl.init(this.getDAGlobalHelper(), this, psDEChartLogic);
            this.psDEChartLogicList.add(psDEChartLogicImpl);
        }
    }

    @Override
    public Iterator<? extends IPSChartAxes> getPSChartAxeses() {
        if (this.psDEChartAxesList.size() == 0) {
            return null;
        }
        return this.psDEChartAxesList.iterator();
    }

    @Override
    public Iterator<? extends IPSChartSeries> getPSChartSerieses() {
        if (this.psDEChartSeriesList.size() == 0) {
            return null;
        }
        return this.psDEChartSeriesList.iterator();
    }

    protected int calcFieldStdDataType(String strFieldName) throws Exception {
        IPSDEDataSetGroupParam iPSDEDataSetGroupParam;
        if (this.getPSDEDataSet() != null && this.getPSDEDataSet().isEnableGroup() && (iPSDEDataSetGroupParam = this.getPSDEDataSet().getPSDEDataSetGroupParam(strFieldName, true)) != null && iPSDEDataSetGroupParam.getStdDataType() != -1) {
            return iPSDEDataSetGroupParam.getStdDataType();
        }
        IPSDEField iPSDEField = this.getPSDataEntity().getPSDEField(strFieldName, true);
        if (iPSDEField != null) {
            return iPSDEField.getStdDataType();
        }
        log.warn((Object)SA.SRFramework.Utility.StringHelper.Format((String)"\u65e0\u6cd5\u8ba1\u7b97\u5c5e\u6027[%1$s]\u6570\u636e\u7c7b\u578b", (Object)strFieldName));
        return 25;
    }

    @Override
    protected String onGetControlType() {
        return "CHART";
    }

    @Override
    public Iterator<IPSDEChartAxes> getPSDEChartAxeses() {
        return this.psDEChartAxesList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u56fe\u8868\u6570\u636e\u5e8f\u5217\u96c6\u5408", child=true)
    public Iterator<IPSDEChartSeries> getPSDEChartSerieses() {
        return this.psDEChartSeriesList.iterator();
    }

    @Override
    public IPSAjaxControlParam getPSAjaxControlParam() {
        return this.psDEChartParamImpl;
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.onGetCodeName();
    }

    @Override
    protected String onGetCodeName() {
        return this.getPSApplication().getViewCodeName(null, this.strCodeName, null);
    }

    @Override
    public String getModelScope() {
        return "DE";
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u6570\u636e\u96c6\u5bf9\u8c61", hideempty=true)
    public IPSDEDataSet getPSDEDataSet() {
        return this.iPSDEDataSet;
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u56fe\u8868\u6807\u9898\u5bf9\u8c61", child=true)
    public IPSDEChartTitle getPSDEChartTitle() {
        return this.iPSDEChartTitle;
    }

    protected void setPSDEChartTitle(IPSDEChartTitle iPSDEChartTitle) {
        this.iPSDEChartTitle = iPSDEChartTitle;
    }

    @Override
    public String getChartTheme() {
        return this.strChartTheme;
    }

    @Override
    public IPSChartTitle getPSChartTitle() {
        return this.getPSDEChartTitle();
    }

    @Override
    public ArrayList<IPSDEChartAxes> getPSDEChartAxesesByPos(String strPos) {
        ArrayList<IPSDEChartAxes> list = new ArrayList<IPSDEChartAxes>();
        boolean bX = false;
        boolean bY = false;
        if (SA.SRFramework.Utility.StringHelper.Compare((String)strPos, (String)"x", (boolean)true) == 0) {
            bX = true;
        } else if (SA.SRFramework.Utility.StringHelper.Compare((String)strPos, (String)"y", (boolean)true) == 0) {
            bY = true;
        }
        for (IPSDEChartAxes iPSDEChartAxes : this.psDEChartAxesList) {
            if (bX && (SA.SRFramework.Utility.StringHelper.Compare((String)iPSDEChartAxes.getAxesPos(), (String)"top", (boolean)true) == 0 || SA.SRFramework.Utility.StringHelper.Compare((String)iPSDEChartAxes.getAxesPos(), (String)"bottom", (boolean)true) == 0)) {
                list.add(iPSDEChartAxes);
                continue;
            }
            if (!bY || SA.SRFramework.Utility.StringHelper.Compare((String)iPSDEChartAxes.getAxesPos(), (String)"left", (boolean)true) != 0 && SA.SRFramework.Utility.StringHelper.Compare((String)iPSDEChartAxes.getAxesPos(), (String)"right", (boolean)true) != 0) continue;
            list.add(iPSDEChartAxes);
        }
        return list;
    }

    @Override
    public IPSDEChartAxes getPSDEChartAxes(String strPSDEChartAxesId) throws Exception {
        for (IPSDEChartAxes iPSDEChartAxes : this.psDEChartAxesList) {
            if (SA.SRFramework.Utility.StringHelper.Compare((String)iPSDEChartAxes.getId(), (String)strPSDEChartAxesId, (boolean)false) != 0) continue;
            return iPSDEChartAxes;
        }
        throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u5750\u6807\u8f74[%1$s]", (Object)strPSDEChartAxesId));
    }

    @Override
    @PSModelRTMeta(description="\u65e0\u503c\u5185\u5bb9\u8bed\u8a00\u8d44\u6e90")
    public IPSLanguageRes getEmptyTextPSLanguageRes() {
        if (this.emptyTextPSLanguageRes == null && this.getPSApplication() != null) {
            return this.getPSApplication().getPSApplicationUI().getMDCtrlEmptyTextPSLanguageRes();
        }
        return this.emptyTextPSLanguageRes;
    }

    @Override
    @PSModelRTMeta(description="\u65e0\u503c\u663e\u793a\u5185\u5bb9")
    public String getEmptyText() {
        if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strEmptyText) && this.getPSApplication() != null) {
            return this.getPSApplication().getPSApplicationUI().getMDCtrlEmptyText();
        }
        return this.strEmptyText;
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u56fe\u8868\u56fe\u4f8b\u5bf9\u8c61", child=true)
    public IPSDEChartLegend getPSDEChartLegend() {
        return this.iPSDEChartLegend;
    }

    @Override
    public IPSChartLegend getPSChartLegend() {
        return this.getPSDEChartLegend();
    }

    protected void setPSDEChartLegend(IPSDEChartLegend iPSDEChartLegend) {
        this.iPSDEChartLegend = iPSDEChartLegend;
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u56fe\u8868\u6570\u636e\u8868\u683c\u5bf9\u8c61", child=true)
    public IPSDEChartDataGrid getPSDEChartDataGrid() {
        return this.iPSDEChartDataGrid;
    }

    @Override
    public IPSChartDataGrid getPSChartDataGrid() {
        return this.getPSDEChartDataGrid();
    }

    protected void setPSDEChartDataGrid(IPSDEChartDataGrid iPSDEChartDataGrid) {
        this.iPSDEChartDataGrid = iPSDEChartDataGrid;
    }

    @Override
    @PSModelRTMeta(description="\u5750\u6807\u7cfb\u7edf\u7c7b\u578b", codelist="ChartCoordinateSystem")
    public String getCoordinateSystem() {
        return this.strCoordinateSystem;
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u96c6\u5408\u4e0a\u4e0b\u6587\u6570\u636e\u8f6c\u6362\u903b\u8f91", hideempty=true)
    public IPSDELogic getActiveDataPSDELogic() {
        return this.activeDataPSDELogic;
    }

    @Override
    public String getModelType() {
        return "PSDECHART";
    }

    @Override
    public boolean hasWFDataItems() {
        return false;
    }

    @Override
    public IPSChartCoordinateSystem createPSChartCoordinateSystem(PSDEChartCS csData) throws Exception {
        int nIndex = csData.GetParamIntValue("INDEX", -1);
        String strType = csData.getParamStringValue("COORDINATESYSTEM", "");
        int nAutoIndex = 0;
        if (nIndex != -1) {
            for (IPSChartCoordinateSystem iPSChartCoordinateSystem : this.psChartCoordinateSystemList) {
                if (iPSChartCoordinateSystem.getIndex() != nIndex) continue;
                throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u6307\u5b9a\u5e8f\u53f7\u5df2\u7ecf\u88ab[%1$s:%2$s]\u4f7f\u7528", (Object)iPSChartCoordinateSystem.getType(), (Object)iPSChartCoordinateSystem.getName()));
            }
            nAutoIndex = nIndex;
        } else {
            while (true) {
                boolean bExists = false;
                for (IPSChartCoordinateSystem iPSChartCoordinateSystem : this.psChartCoordinateSystemList) {
                    if (iPSChartCoordinateSystem.getIndex() != nAutoIndex) continue;
                    bExists = true;
                    break;
                }
                if (!bExists) break;
                ++nAutoIndex;
            }
        }
        String strCoordinateSystemObj = coordinateSystemMap.get(strType);
        if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)strCoordinateSystemObj)) {
            throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u65e0\u6cd5\u8bc6\u522b\u7684\u5750\u6807\u7cfb\u7edf\u7c7b\u578b[%1$s]", (Object)strType));
        }
        IPSDEChartCoordinateSystem iPSDEChartCoordinateSystem = (IPSDEChartCoordinateSystem)ObjectHelper.create((String)strCoordinateSystemObj);
        if (iPSDEChartCoordinateSystem == null) {
            throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u65e0\u6cd5\u5efa\u7acb\u56fe\u8868\u5750\u6807\u7cfb\u7edf\u5bf9\u8c61\uff0c\u7c7b\u578b\u4e3a[%1$s]", (Object)strType));
        }
        csData.set("AUTOINDEX", nAutoIndex);
        iPSDEChartCoordinateSystem.init(this.getDAGlobalHelper(), this, this.psDEChart, csData);
        this.psChartCoordinateSystemList.add(iPSDEChartCoordinateSystem);
        return iPSDEChartCoordinateSystem;
    }

    @Override
    @PSModelRTMeta(description="\u56fe\u8868\u5750\u6807\u7cfb\u96c6\u5408", child=true)
    public Iterator<? extends IPSChartCoordinateSystem> getPSChartCoordinateSystems() {
        if (this.psChartCoordinateSystemList == null || this.psChartCoordinateSystemList.size() == 0) {
            return null;
        }
        return this.psChartCoordinateSystemList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u57fa\u7840\u914d\u7f6eJson\u5185\u5bb9")
    public String getBaseOptionJOString() {
        if (this.getPSDynaModel() != null) {
            return ((IPSSysDynaModel)this.getPSDynaModel()).getJOString();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u9ed8\u8ba4\u6392\u5e8f\u5c5e\u6027")
    public IPSDEField getMinorSortPSDEF() {
        return this.minorPSDEField;
    }

    @Override
    @PSModelRTMeta(description="\u9ed8\u8ba4\u6392\u5e8f\u65b9\u5411", codelist="SortDir")
    public String getMinorSortDir() {
        return this.strMinorSortDir;
    }

    @Override
    @PSModelRTMeta(description="\u9ed8\u8ba4\u6392\u5e8f\u5e94\u7528\u5b9e\u4f53\u5c5e\u6027", hideempty=true, dumpref=true)
    public IPSAppDEField getMinorSortPSAppDEField() {
        return this.minorPSAppDEField;
    }

    @Override
    @PSModelRTMeta(description="\u56fe\u8868\u903b\u8f91\u96c6\u5408", group="\u90e8\u4ef6\u903b\u8f91", order=217)
    public Iterator<? extends IPSDEChartLogic> getPSDEChartLogics() {
        if (this.psDEChartLogicList == null || this.psDEChartLogicList.size() == 0) {
            return null;
        }
        return this.psDEChartLogicList.iterator();
    }

    @Override
    protected Iterator<? extends IPSAppDEUILogicGroupDetail> getPSAppDEUILogicGroupDetails() {
        if (this.psDEChartLogicList == null || this.psDEChartLogicList.size() == 0) {
            return null;
        }
        return this.psDEChartLogicList.iterator();
    }
}

