/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.Data.Chart
 *  SA.SRFDA.Ctrl.Data.SearchForm
 *  SA.SRFDA.Ctrl.SearchForm.BaseDASearchFormActionHelper
 *  SA.SRFDA.Web.Default.BaseMainPage
 *  SA.SRFDA.Web.SRFDAPage
 *  SA.SRFDA.Web.ViewModel.PageModel
 *  SA.SRFDA.Web.ViewModel.SPExModel
 *  SA.SRFramework.Base.XMLConfig
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.ReportEx.Model.ChartConfig
 *  SA.SRFramework.ReportEx.SRFExChart
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  SA.SRFramework.WebEx.Form.SRFExForm
 *  SA.SRFramework.WebEx.Form.SRFExSearchForm
 *  SA.SRFramework.WebEx.SP.SRFExSPEx
 *  SA.SRFramework.WebEx.SRFExControl
 *  SA.SRFramework.WebEx.Script.FormJSHelper
 */
package SA.SRFDA.Report.Web;

import SA.SRFDA.Ctrl.Data.Chart;
import SA.SRFDA.Ctrl.Data.SearchForm;
import SA.SRFDA.Ctrl.SearchForm.BaseDASearchFormActionHelper;
import SA.SRFDA.Report.Web.ViewModel.ReportChartViewModel;
import SA.SRFDA.Web.Default.BaseMainPage;
import SA.SRFDA.Web.SRFDAPage;
import SA.SRFDA.Web.ViewModel.PageModel;
import SA.SRFDA.Web.ViewModel.SPExModel;
import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.ReportEx.Model.ChartConfig;
import SA.SRFramework.ReportEx.SRFExChart;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.WebEx.Form.SRFExForm;
import SA.SRFramework.WebEx.Form.SRFExSearchForm;
import SA.SRFramework.WebEx.SP.SRFExSPEx;
import SA.SRFramework.WebEx.SRFExControl;
import SA.SRFramework.WebEx.Script.FormJSHelper;

public class ReportChartPage
extends BaseMainPage {
    protected String strSPExConfigId = "";
    protected SRFExSPEx spEx = null;
    protected Chart chart = new Chart();
    protected SRFExChart chartCtrl = null;
    protected String strFormTag = "";
    protected SearchForm searchForm = null;
    protected ReportChartViewModel reportChartViewModel = null;

    protected boolean PreparePageEnv() {
        if (!super.PreparePageEnv()) {
            return false;
        }
        String strChartId = this.getWebContext().GetParamValue("CHARTID");
        if (StringHelper.IsNullOrEmpty((String)strChartId)) {
            this.PageLog((Object)this, 1, "\u6ca1\u6709\u6307\u5b9a\u56fe\u8868\u7f16\u53f7");
            return false;
        }
        CallResult callResult = this.getDAModelHelper().GetChart(strChartId, this.chart);
        if (callResult.getRetCode() != 0) {
            this.PageLog((Object)this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u56fe\u8868[%1$s]\uff0c%2$s", (Object)strChartId, (Object)callResult.getErrorInfo()));
            return false;
        }
        this.strPageDataEntityId = this.chart.getDEID();
        this.LoadPageDataEntity();
        return true;
    }

    public String OutputPageCaption() {
        return this.chart.getCHARTNAME();
    }

    protected void OnInitComponents() {
        super.OnInitComponents();
        this.LoadSPEx();
        this.LoadChart();
    }

    protected void OnInitBackEnd() {
        super.OnInitBackEnd();
        this.RegisterFormActionHelper(this.getDefaultFormId(), this.GetSearchFormActionHelper());
    }

    protected void OnInit() {
        super.OnInit();
        StringBuilderEx script = new StringBuilderEx();
        script.Append("$P.object['%1$s']={};\r\n", (Object)this.spEx.getUniqueID());
        this.RegisterOnReadyScript(3, script.toString());
        this.spEx.getSearchForm().setUserParamsName(StringHelper.Format((String)"$P.object['%1$s']", (Object)this.spEx.getUniqueID()));
        script.Reset();
        script.Append("var A='../srfpage/chartdatabackend.jsp?SRFCHARTID=%1$s&SRFCHARTTYPE=%2$s&';", (Object)this.chart.getCHARTID(), (Object)this.chart.getCHARTTYPE());
        script.Append("var B=Ext.urlEncode($P.object['%1$s']);", (Object)this.spEx.getUniqueID());
        script.Append("try{$P.object['%1$s'].setDataURL(escape(A+B));if($P.object['g_%1$s']){$P.object['g_%1$s'].setDataURL(escape(A+B));}}catch(e){%2$s.search();return;}", (Object)this.chartCtrl.getUniqueID(), (Object)this.getDefaultForm().getFormId());
        this.spEx.getSearchForm().getSearchAction().getSuccessAction().RegisterProcessCode(0, script.toString());
        this.spEx.getSearchForm().getLoadAction().getSuccessAction().RegisterProcessCode(0, StringHelper.Format((String)"_F.search();"));
        if (this.getDefaultForm() != null) {
            this.RegisterOnReadyScript(5, FormJSHelper.getLoadDefaultScript((SRFExForm)((SRFExSearchForm)this.getDefaultForm())));
        }
    }

    protected PageModel CreatePageModel() {
        return new ReportChartViewModel();
    }

    protected void PreparePageModel() {
        super.PreparePageModel();
        this.reportChartViewModel = (ReportChartViewModel)this.pageModel;
    }

    protected String OnGetPageCaption() {
        return this.chart.getCHARTNAME();
    }

    protected String OnGetPageTitle() {
        return this.chart.getCHARTNAME();
    }

    protected String GetSearchFormActionHelper() {
        String strSearchFormActionHelper = this.getPageParam("PAGE.SPACTIONHELPER", "");
        if (StringHelper.IsNullOrEmpty((String)strSearchFormActionHelper)) {
            if (this.searchForm != null && !StringHelper.IsNullOrEmpty((String)(strSearchFormActionHelper = this.searchForm.getBACKENDCTRL()))) {
                return strSearchFormActionHelper;
            }
            strSearchFormActionHelper = BaseDASearchFormActionHelper.class.getName();
        }
        return strSearchFormActionHelper;
    }

    protected void LoadSPEx() {
        this.strSPExConfigId = this.OnGetSPExConfigId();
        if (StringHelper.IsNullOrEmpty((String)this.strSPExConfigId)) {
            return;
        }
        this.spEx = ReportChartPage.CreateSPEx((SRFDAPage)this, (String)"spEx", (String)this.strSPExConfigId);
        if (this.spEx != null) {
            this.spEx.getSearchForm().setFormTag(this.strFormTag);
            this.spEx.getSPExConfig().setSaveLoad(true);
            this.spEx.getSPExConfig().setWidth(1024);
            if (this.reportChartViewModel != null && this.reportChartViewModel.getSPExModel() != null) {
                SPExModel spExModel = this.reportChartViewModel.getSPExModel();
                spExModel.setCtrlId("spEx");
                spExModel.setConfigId(this.strSPExConfigId);
                spExModel.setRemoteCtrlId(this.spEx.getUniqueID());
                spExModel.setItemPrivilege(true);
                spExModel.setCustomSearch(false);
            }
            if (this.reportChartViewModel != null && this.reportChartViewModel.getSearchFormModel() != null) {
                this.reportChartViewModel.getSearchFormModel().setRemoteCtrlId(this.getDefaultFormId());
            }
        }
    }

    protected String OnGetSPExConfigId() {
        String strSPExConfigId = this.chart.getSPCONFIG();
        if (!StringHelper.IsNullOrEmpty((String)strSPExConfigId)) {
            this.strFormTag = strSPExConfigId;
            return strSPExConfigId;
        }
        String strSearchformId = this.chart.getSEARCHFORMID();
        if (!StringHelper.IsNullOrEmpty((String)strSearchformId)) {
            this.searchForm = this.getWebContext().GetConfigCache().GetDESearchForm(this.getWebContext(), strSearchformId, false);
            if (this.searchForm != null) {
                this.strFormTag = strSPExConfigId;
                return this.getDAConfigHelper().GetSPExId(this.getDEHelper(), this.searchForm);
            }
        }
        this.strFormTag = "DEDEFAULT";
        return "";
    }

    public int GetCaptionWidth() {
        return this.OnGetCaptionWidth();
    }

    protected int OnGetCaptionWidth() {
        return this.getPageParam("PAGE.CAPTIONWIDTH", 60);
    }

    protected void LoadChart() {
        this.chartCtrl = new SRFExChart();
        ChartConfig chartConfig = new ChartConfig();
        chartConfig.setChartStyle(this.chart.getCHARTTYPE());
        chartConfig.setWidth(this.chart.getWIDTH());
        chartConfig.setHeight(this.chart.getHEIGHT());
        chartConfig.setGridPos(this.chart.getGRIDPOS());
        chartConfig.setGridHeight(300);
        chartConfig.setGridWidth(this.chart.getGRIDWIDTH());
        chartConfig.setLoadDefault(false);
        String strDataURL = StringHelper.Format((String)"../srfpage/chartdatabackend.jsp?SRFCHARTID=%1$s&SRFCHARTTYPE=%2$s", (Object)this.chart.getCHARTID(), (Object)this.chart.getCHARTTYPE());
        chartConfig.setDataURL(strDataURL);
        this.chartCtrl.setConfig((XMLConfig)chartConfig);
        this.chartCtrl.setID("chart");
        this.AddControl((SRFExControl)this.chartCtrl);
        if (this.reportChartViewModel != null) {
            strDataURL = StringHelper.Format((String)"../srfpage/chartdatamodelbackend.jsp?SRFCHARTID=%1$s&SRFCHARTTYPE=%2$s", (Object)this.chart.getCHARTID(), (Object)this.chart.getCHARTTYPE());
            this.reportChartViewModel.setChart(this.chart);
            this.reportChartViewModel.setDataURL(strDataURL);
        }
    }
}

