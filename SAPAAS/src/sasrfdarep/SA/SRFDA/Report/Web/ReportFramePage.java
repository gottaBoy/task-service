/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.Data.Report
 *  SA.SRFDA.Ctrl.SearchForm.BaseDASearchFormActionHelper
 *  SA.SRFDA.Web.Default.BaseMainPage
 *  SA.SRFDA.Web.SRFDAPage
 *  SA.SRFDA.Web.ViewModel.PageModel
 *  SA.SRFDA.Web.ViewModel.SPExModel
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  SA.SRFramework.WebEx.Form.SRFExForm
 *  SA.SRFramework.WebEx.Form.SRFExSearchForm
 *  SA.SRFramework.WebEx.SP.SRFExSPEx
 *  SA.SRFramework.WebEx.SRFExControl
 *  SA.SRFramework.WebEx.SRFExDropDownList
 *  SA.SRFramework.WebEx.SRFExIFrame
 *  SA.SRFramework.WebEx.Script.FormJSHelper
 *  net.sf.json.JSONObject
 */
package SA.SRFDA.Report.Web;

import SA.SRFDA.Ctrl.Data.Report;
import SA.SRFDA.Ctrl.SearchForm.BaseDASearchFormActionHelper;
import SA.SRFDA.Report.Web.ViewModel.ReportFrameViewModel;
import SA.SRFDA.Web.Default.BaseMainPage;
import SA.SRFDA.Web.SRFDAPage;
import SA.SRFDA.Web.ViewModel.PageModel;
import SA.SRFDA.Web.ViewModel.SPExModel;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.WebEx.Form.SRFExForm;
import SA.SRFramework.WebEx.Form.SRFExSearchForm;
import SA.SRFramework.WebEx.SP.SRFExSPEx;
import SA.SRFramework.WebEx.SRFExControl;
import SA.SRFramework.WebEx.SRFExDropDownList;
import SA.SRFramework.WebEx.SRFExIFrame;
import SA.SRFramework.WebEx.Script.FormJSHelper;
import net.sf.json.JSONObject;

public class ReportFramePage
extends BaseMainPage {
    protected SRFExSPEx spEx = null;
    protected Report report = new Report();
    protected SRFExIFrame iFrame = null;
    protected ReportFrameViewModel reportFrameViewModel = null;
    protected SRFExDropDownList ddlReportType = null;

    protected boolean PreparePageEnv() {
        if (!super.PreparePageEnv()) {
            return false;
        }
        String strReportId = this.getWebContext().GetParamValue("REPORTID");
        if (StringHelper.IsNullOrEmpty((String)strReportId)) {
            this.PageLog((Object)this, 1, "\u6ca1\u6709\u6307\u5b9a\u62a5\u8868\u7f16\u53f7");
            return false;
        }
        CallResult callResult = this.getDAModelHelper().GetReport(strReportId, this.report);
        if (callResult.getRetCode() != 0) {
            this.PageLog((Object)this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u62a5\u8868[%1$s]\uff0c%2$s", (Object)strReportId, (Object)callResult.getErrorInfo()));
            return false;
        }
        return true;
    }

    protected PageModel CreatePageModel() {
        return new ReportFrameViewModel();
    }

    protected void PreparePageModel() {
        super.PreparePageModel();
        this.reportFrameViewModel = (ReportFrameViewModel)this.pageModel;
    }

    protected boolean OnFillPageModel(JSONObject jsonObject) {
        if (!super.OnFillPageModel(jsonObject)) {
            return false;
        }
        this.reportFrameViewModel.setReportDesc(this.report.getDESCRIPTION());
        return true;
    }

    protected String OnGetPageCaption() {
        return this.report.getREPORTNAME();
    }

    protected String OnGetPageTitle() {
        return this.report.getREPORTNAME();
    }

    protected void OnInitComponents() {
        super.OnInitComponents();
        this.LoadReportTypeList();
        this.LoadSPEx();
        this.LoadIFrame();
    }

    protected void LoadReportTypeList() {
        this.ddlReportType = new SRFExDropDownList();
        this.ddlReportType.InitConfig();
        this.ddlReportType.setID("ddlReportType");
        this.ddlReportType.getDropDownListConfig().setWidth(120);
        this.ddlReportType.getDropDownListConfig().getListFillerConfig().setCodeList("SRFREPORT.CODELIST_REPORTTYPE");
        String strDefaultType = this.getWebContext().getWebExConfig().GetValue("SRFREPORT", "DEFAULTREPORTTYPE", "pdfreport.pdf");
        this.ddlReportType.getDropDownListConfig().setSelectedValue(strDefaultType);
        this.AddControl((SRFExControl)this.ddlReportType);
        if (this.reportFrameViewModel != null) {
            this.reportFrameViewModel.setReportTypeCodeList("SRFREPORT.CODELIST_REPORTTYPE");
            this.reportFrameViewModel.setDefaultReportType(strDefaultType);
        }
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
        this.spEx.getSearchForm().getSearchAction().getSuccessAction().RegisterProcessCode(0, StringHelper.Format((String)"Ext.getDom('%1$s').contentWindow.location.href='../srfreport/'+Ext.getDom('%4$s').value+'?REPORTID=%2$s&'+ Ext.urlEncode($P.object['%3$s']);", (Object)this.iFrame.getUniqueID(), (Object)this.report.getREPORTID(), (Object)this.spEx.getUniqueID(), (Object)this.ddlReportType.getUniqueID()));
        if (this.getDefaultForm() != null) {
            this.RegisterOnReadyScript(3, FormJSHelper.getLoadDefaultScript((SRFExForm)((SRFExSearchForm)this.getDefaultForm())));
        }
    }

    protected String GetSearchFormActionHelper() {
        return BaseDASearchFormActionHelper.class.getName();
    }

    protected void LoadSPEx() {
        if (this.spEx == null) {
            this.spEx = ReportFramePage.CreateSPEx((SRFDAPage)this, (String)"spEx", (String)this.report.getSEARCHPANEL());
        }
        if (this.spEx != null) {
            this.spEx.getSPExConfig().setWidth(1024);
            this.IsBackEndMode();
            if (this.reportFrameViewModel != null && this.reportFrameViewModel.getSPExModel() != null) {
                SPExModel spExModel = this.reportFrameViewModel.getSPExModel();
                spExModel.setCtrlId("spEx");
                spExModel.setConfigId(this.report.getSEARCHPANEL());
                spExModel.setRemoteCtrlId(this.spEx.getUniqueID());
                spExModel.setItemPrivilege(false);
                spExModel.setCustomSearch(false);
            }
            if (this.reportFrameViewModel != null && this.reportFrameViewModel.getSearchFormModel() != null) {
                this.reportFrameViewModel.getSearchFormModel().setRemoteCtrlId(this.getDefaultFormId());
            }
        }
    }

    public int GetCaptionWidth() {
        return this.OnGetCaptionWidth();
    }

    protected int OnGetCaptionWidth() {
        return this.getPageParam("PAGE.CAPTIONWIDTH", 60);
    }

    protected void LoadIFrame() {
        if (this.iFrame != null) {
            return;
        }
        this.iFrame = new SRFExIFrame();
        this.iFrame.InitConfig();
        this.iFrame.setID("iframe");
        this.iFrame.getIFrameConfig().setWidth(0);
        this.iFrame.getIFrameConfig().setHeight(0);
        this.iFrame.getIFrameConfig().setScroll("auto");
        this.AddControl((SRFExControl)this.iFrame);
    }
}

