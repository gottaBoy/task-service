/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFDA.Web.Default.BaseMainPage
 *  SA.SRFDA.Web.SRFDAPage
 *  SA.SRFDA.Web.SRFDAPageEx
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  SA.SRFramework.WebEx.Form.SRFExForm
 *  SA.SRFramework.WebEx.Form.SRFExSearchForm
 *  SA.SRFramework.WebEx.SP.SRFExSPEx
 *  SA.SRFramework.WebEx.SRFExControl
 *  SA.SRFramework.WebEx.SRFExIFrame
 *  SA.SRFramework.WebEx.Script.FormJSHelper
 *  SA.SRFramework.WebEx.ToolBar.SRFExToolbar
 *  SA.SRFramework.WebEx.ToolBar.UI.BaseToolbarItemConfig
 */
package SA.SRFDA.BI.Web;

import SA.SRFDA.BI.Ctrl.DABIConfigHelperFactory;
import SA.SRFDA.BI.Ctrl.Data.BIReport;
import SA.SRFDA.BI.Ctrl.IDABIConfigHelper;
import SA.SRFDA.BI.Ctrl.SearchForm.BIQuerySearchFormActionHelper;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.Web.Default.BaseMainPage;
import SA.SRFDA.Web.SRFDAPage;
import SA.SRFDA.Web.SRFDAPageEx;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.WebEx.Form.SRFExForm;
import SA.SRFramework.WebEx.Form.SRFExSearchForm;
import SA.SRFramework.WebEx.SP.SRFExSPEx;
import SA.SRFramework.WebEx.SRFExControl;
import SA.SRFramework.WebEx.SRFExIFrame;
import SA.SRFramework.WebEx.Script.FormJSHelper;
import SA.SRFramework.WebEx.ToolBar.SRFExToolbar;
import SA.SRFramework.WebEx.ToolBar.UI.BaseToolbarItemConfig;

public class BIReportQueryPage
extends BaseMainPage {
    protected SRFExSPEx spEx = null;
    protected BIReport biReport = null;
    protected SRFExToolbar toolbar = null;
    protected String strToolbarConfigId = "";
    protected SRFExIFrame iFrame = null;

    protected boolean PreparePageEnv() {
        if (!super.PreparePageEnv()) {
            return false;
        }
        String strBIReportId = this.getWebContext().GetParamValue("BIREPORTID");
        if (!StringHelper.IsNullOrEmpty((String)strBIReportId)) {
            IDEDataCtrl reportDEDataCtrl = this.GetDEDataCtrl("BI0020");
            if (reportDEDataCtrl == null) {
                this.PageLog((Object)this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61", (Object)"BI0020"));
                return false;
            }
            this.biReport = new BIReport();
            this.biReport.setBIREPORTID(strBIReportId);
            CallResult callResult = reportDEDataCtrl.Get((BaseDataEntity)this.biReport);
            if (callResult.IsError()) {
                this.PageLog((Object)this, 1, StringHelper.Format((String)"\u83b7\u53d6BI\u62a5\u8868[%1$s]\u5931\u8d25\uff0c%2$s", (Object)strBIReportId, (Object)callResult.getErrorInfo()));
                return false;
            }
        } else {
            this.PageLog((Object)this, 1, StringHelper.Format((String)"\u6ca1\u6709\u6307\u5b9aBI\u62a5\u8868\u5bf9\u8c61", (Object)"BI0020"));
            return false;
        }
        this.setPageParam("BIREPORT", (Object)this.biReport);
        return true;
    }

    public String OutputPageCaption() {
        if (this.biReport != null) {
            return this.biReport.getBIREPORTNAME();
        }
        return "BI\u62a5\u8868";
    }

    protected void OnInitComponents() {
        super.OnInitComponents();
        this.LoadSPEx();
        this.LoadToolbar();
        this.LoadIFrame();
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
        if (this.getDefaultForm() != null) {
            this.RegisterOnReadyScript(3, FormJSHelper.getLoadDefaultScript((SRFExForm)((SRFExSearchForm)this.getDefaultForm())));
        }
    }

    protected String GetSearchFormActionHelper() {
        return BIQuerySearchFormActionHelper.class.getName();
    }

    protected void LoadSPEx() {
        String strSPConfigId = this.OnGetSPExConfigId();
        if (StringHelper.IsNullOrEmpty((String)strSPConfigId)) {
            return;
        }
        this.spEx = BIReportQueryPage.CreateSPEx((SRFDAPage)this, (String)"spEx", (String)strSPConfigId, (boolean)false);
        if (this.spEx != null) {
            this.spEx.getSPExConfig().setWidth(1024);
            this.IsBackEndMode();
        }
    }

    protected String OnGetSPExConfigId() {
        IDABIConfigHelper iDABIConfigHelper = DABIConfigHelperFactory.GetDABIConfigHelper((SRFDAPageEx)this);
        if (iDABIConfigHelper == null) {
            this.PageLog((Object)this, 1, "\u65e0\u6cd5\u83b7\u53d6\u754c\u9762\u914d\u7f6e\u8f85\u52a9\u5bf9\u8c61");
            return "";
        }
        return iDABIConfigHelper.GetBIReportSPExConfigId(this.biReport);
    }

    protected void LoadToolbar() {
        if (!this.IsBackEndMode()) {
            this.strToolbarConfigId = this.OnGetToolbarConfigId();
            if (StringHelper.IsNullOrEmpty((String)this.strToolbarConfigId)) {
                return;
            }
        }
        this.toolbar = BIReportQueryPage.CreateToolbar((SRFDAPage)this, (String)"toolBar", (double)0.0, (double)0.0, (String)this.strToolbarConfigId);
        if (this.toolbar != null && !this.IsBackEndMode()) {
            this.toolbar.getToolbarConfig().setCssClass("sx-toolbarnobg");
        }
    }

    protected String OnGetToolbarConfigId() {
        return "SRFBI.TB_REPORTQUERY_DEFAULT";
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

    public String GetAfterOnReadyCode() {
        StringBuilderEx script = new StringBuilderEx();
        this.OnGetAfterOnReadyCode(script);
        return script.toString();
    }

    protected void OnGetAfterOnReadyCode(StringBuilderEx script) {
        BaseToolbarItemConfig filterTBBConfig = this.toolbar.getToolbarConfig().getToolbarItemsConfig().FindToolbarItemConfig("TBB_FILTER");
        if (filterTBBConfig != null) {
            script.Append(StringHelper.Format((String)"$P.toolbar['%1$s'].items.get('%2$s').toggle(showhidesp());", (Object)this.toolbar.getUniqueID(), (Object)"TBB_FILTER"));
        }
    }

    public String GetHideSPCode() {
        BaseToolbarItemConfig filterTBBConfig = this.toolbar.getToolbarConfig().getToolbarItemsConfig().FindToolbarItemConfig("TBB_FILTER");
        if (filterTBBConfig != null) {
            return StringHelper.Format((String)"$P.toolbar['%1$s'].items.get('%2$s').toggle(false);", (Object)this.toolbar.getUniqueID(), (Object)"TBB_FILTER");
        }
        return "";
    }
}

