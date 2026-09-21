/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.Config.DPConfigPublishContext
 *  SA.SRFDA.Ctrl.DAConfigPublishContext
 *  SA.SRFDA.Ctrl.DEFHelper.IDEFHelper
 *  SA.SRFDA.Ctrl.Data.DEWF
 *  SA.SRFDA.Ctrl.Data.Form
 *  SA.SRFDA.Ctrl.Data.Page
 *  SA.SRFDA.Ctrl.IDAConfigPublishContext
 *  SA.SRFDA.Web.Default.BaseFormViewPage
 *  SA.SRFDA.Web.Default.PageRender
 *  SA.SRFDA.Web.JSGear.FormModifyAlertJSGear
 *  SA.SRFDA.Web.SRFDAPage
 *  SA.SRFDA.Web.SRFDAWebContext
 *  SA.SRFDA.Web.ViewModel.DPExModel
 *  SA.SRFDA.Web.ViewModel.FormModel
 *  SA.SRFDA.Web.ViewModel.PageModel
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  SA.SRFramework.WebEx.DP.UI.DPConfig
 *  SA.SRFramework.WebEx.Form.SRFExForm
 *  SA.SRFramework.WebEx.SRFExControl
 *  SA.SRFramework.WebEx.SRFExListBoxPickup
 *  SA.SRFramework.WebEx.ToolBar.SRFExToolbar
 *  SA.SRFramework.WebEx.Utility.URLHelper
 *  net.sf.json.JSONObject
 */
package SA.SRFDA.WF.Web;

import SA.SRFDA.Ctrl.Config.DPConfigPublishContext;
import SA.SRFDA.Ctrl.DAConfigPublishContext;
import SA.SRFDA.Ctrl.DEFHelper.IDEFHelper;
import SA.SRFDA.Ctrl.Data.DEWF;
import SA.SRFDA.Ctrl.Data.Form;
import SA.SRFDA.Ctrl.Data.Page;
import SA.SRFDA.Ctrl.IDAConfigPublishContext;
import SA.SRFDA.WF.Ctrl.Data.PP.PPWFIAActionView;
import SA.SRFDA.WF.Web.ViewModel.WFIAActionViewModel;
import SA.SRFDA.Web.Default.BaseFormViewPage;
import SA.SRFDA.Web.Default.PageRender;
import SA.SRFDA.Web.JSGear.FormModifyAlertJSGear;
import SA.SRFDA.Web.SRFDAPage;
import SA.SRFDA.Web.SRFDAWebContext;
import SA.SRFDA.Web.ViewModel.DPExModel;
import SA.SRFDA.Web.ViewModel.FormModel;
import SA.SRFDA.Web.ViewModel.PageModel;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.WebEx.DP.UI.DPConfig;
import SA.SRFramework.WebEx.Form.SRFExForm;
import SA.SRFramework.WebEx.SRFExControl;
import SA.SRFramework.WebEx.SRFExListBoxPickup;
import SA.SRFramework.WebEx.ToolBar.SRFExToolbar;
import SA.SRFramework.WebEx.Utility.URLHelper;
import net.sf.json.JSONObject;

public class WFIAActionViewPage
extends BaseFormViewPage {
    protected SRFExToolbar toolbar = null;
    protected String strWFState = "";
    protected String strWFStep = "";
    protected String strWFFormName = "";
    protected DEWF deWF = null;
    protected boolean bNoPanelMode = false;
    protected String strToolbarConfigId = "";
    protected WFIAActionViewModel wfIAActionViewModel = null;
    protected PPWFIAActionView ppWFIAActionView = null;

    protected boolean PreparePageEnv() {
        if (!super.PreparePageEnv()) {
            return false;
        }
        this.strWFStep = this.getWebContext().getSRFWFSTEP();
        this.strWFFormName = this.GetWFFormName();
        this.strPageDataEntityId = this.getWebContext().getSRFDEID();
        if (!this.LoadPageDataEntity()) {
            return false;
        }
        if (StringHelper.IsNullOrEmpty((String)this.strWFFormName)) {
            this.PageLog((Object)this, 0, "\u6ca1\u6709\u6307\u5b9a\u5b9e\u4f53\u5de5\u4f5c\u6d41\u8868\u5355\u540d\u79f0");
            this.bNoPanelMode = true;
            return true;
        }
        this.formView = new Form();
        CallResult callResult = this.getDAModelHelper().GetDEWFForm(this.strPageDataEntityId, this.strWFFormName, this.formView);
        if (callResult == null || callResult.getRetCode() != 0) {
            this.PageLog((Object)this, "\u83b7\u53d6\u5b9e\u4f53\u5de5\u4f5c\u6d41\u89c6\u56fe\u5931\u8d25", callResult);
            return false;
        }
        this.ProcessFormDigestMode();
        this.setPageParam("FORMVIEW", this.formView);
        return true;
    }

    protected void PreparePageParam() {
        BaseDataEntity pageParam;
        super.PreparePageParam();
        if (this.page != null && (pageParam = this.page.getAdvPageParam("PAGE", "PPWFIAACTIONVIEW")) != null && pageParam instanceof PPWFIAActionView) {
            this.ppWFIAActionView = (PPWFIAActionView)pageParam;
        }
    }

    protected PageModel CreatePageModel() {
        return new WFIAActionViewModel();
    }

    protected void PreparePageModel() {
        super.PreparePageModel();
        this.wfIAActionViewModel = (WFIAActionViewModel)this.pageModel;
    }

    protected String GetWFFormName() {
        return this.getWebContext().GetParamValue("SRFWFFORMNAME");
    }

    protected void OnInitBackEnd() {
        super.OnInitBackEnd();
        this.RegisterFormActionHelper(this.getDefaultFormId(), this.GetFormActionHelper());
    }

    protected String GetFormActionHelper() {
        String strFormActionHelper = this.getPageParam("PAGE.FORMACTIONHELPER", "");
        if (!StringHelper.IsNullOrEmpty((String)strFormActionHelper)) {
            return strFormActionHelper;
        }
        if (!StringHelper.IsNullOrEmpty((String)this.formView.getWFBACKENDCTRL())) {
            return this.formView.getWFBACKENDCTRL();
        }
        if (!StringHelper.IsNullOrEmpty((String)this.formView.getBACKENDCTRL())) {
            return this.formView.getBACKENDCTRL();
        }
        return this.getWebContext().getWebExConfig().GetValue("SRFDA", "WFIAACTIONFORMACTIONHELPER", "");
    }

    protected void LoadDPEx() {
        this.strDPConfigId = this.OnGetDPConfigId();
        DPConfig panelConfig = this.getWebContext().GetConfigCache().GetDPConfig(this.getWebContext(), "Panel", this.strDPConfigId);
        if (panelConfig == null) {
            this.PageLog(this.page, 1, StringHelper.Format((String)"\u52a8\u6001\u9762\u677f[%1$s]\u65e0\u6548", (Object)this.strDPConfigId));
            return;
        }
        this.panel = WFIAActionViewPage.CreateDPEx((SRFDAPage)this, (String)"Panel", (boolean)true, (String)this.strDPConfigId);
        if (this.panel != null) {
            this.panel.getDPConfig().setWidth(600);
            if (this.panel.getDPConfig().getPageGroupsConfig().size() == 1) {
                this.panel.getDPConfig().setSimpleMode(true);
            }
        }
        SRFExForm form = (SRFExForm)this.getDefaultForm();
        form.getLoadAction().setLoadDefault(false);
        if (this.wfIAActionViewModel != null) {
            DPExModel dpExModel = this.wfIAActionViewModel.getDPExModel();
            dpExModel.setConfigId(this.strDPConfigId);
            dpExModel.setRemoteCtrlId(this.panel.getUniqueID());
            FormModel formModel = this.wfIAActionViewModel.getFormModel();
            formModel.setRemoteCtrlId(form.getFormId());
            formModel.setItemPrivilege(this.isEnableFormItemPrivilege());
        }
        if (!this.IsBackEndMode()) {
            StringBuilderEx script = new StringBuilderEx();
            script.Reset();
            script.Append("$P.setmainform(%1$s);", (Object)form.getFormId());
            this.RegisterOnReadyScript(3, script.toString());
            script.Reset();
            IDEFHelper keyDEFHelper = this.getDEHelper().GetKeyDEFHelper();
            SRFExControl keyControl = form.FindControl(keyDEFHelper.getName());
            if (keyControl == null) {
                script.Append("alert('\u8868\u5355\u6ca1\u6709\u4efb\u4f55\u4e3b\u952e\uff0c\u5904\u7406\u505c\u6b62!');");
            } else {
                script.Append("var keys = '';if(dialogArguments){keys = dialogArguments.toString();}", (Object)form.getFormId(), (Object)keyControl.getUniqueID());
                script.Append("if(keys == ''){alert('\u6ca1\u6709\u4f20\u5165\u6570\u636e');return;}");
                if (this.isEnableFormDigest() && StringHelper.IsNullOrEmpty((String)this.getFormDigestData())) {
                    script.Append("var redirecturl=window.location.href+'&SRFDAKEYS='+keys;");
                    script.Append("redirectpage(redirecturl);");
                } else {
                    script.Append("%1$s.S('%2$s',keys);%1$s.load();", (Object)form.getFormId(), (Object)keyControl.getUniqueID());
                }
            }
            this.RegisterOnReadyScript(5, script.toString());
            SRFExControl wfStepActorControl = form.FindControl("SRFFORMITEMID_WFSTEPACTOR");
            if (wfStepActorControl != null) {
                String strWFId = this.iDEHelper.GetDEWFId(this.getWebContext().getSRFWFMode());
                this.getWebContext().SetParamValue("SRFWFID", strWFId);
                this.getWebContext().SetParamValue("SRFUSERDEID", this.getDEHelper().getId());
                if (wfStepActorControl instanceof SRFExListBoxPickup) {
                    SRFExListBoxPickup listBoxPickup = (SRFExListBoxPickup)wfStepActorControl;
                    String strLastAppendParams = listBoxPickup.getListBoxPickupConfig().getAppendParams();
                    if (!StringHelper.IsNullOrEmpty((String)strLastAppendParams)) {
                        strLastAppendParams = String.valueOf(strLastAppendParams) + "|";
                    }
                    strLastAppendParams = String.valueOf(strLastAppendParams) + "SRFWFID|SRFUSERDEID|SRFWFIAACTIONNAME|SRFWFPROCESSNAME|SRFWFSTEP";
                    listBoxPickup.getListBoxPickupConfig().setAppendParams(strLastAppendParams);
                    String strLastAppendFormParams = listBoxPickup.getListBoxPickupConfig().getAppendFormParams();
                    if (!StringHelper.IsNullOrEmpty((String)strLastAppendFormParams)) {
                        strLastAppendFormParams = String.valueOf(strLastAppendFormParams) + ",";
                    }
                    strLastAppendFormParams = String.valueOf(strLastAppendFormParams) + "SRFUSERDATA|" + keyDEFHelper.getName();
                    listBoxPickup.getListBoxPickupConfig().setAppendFormParams(strLastAppendFormParams);
                }
            }
        }
    }

    protected String OnGetDPConfigId() {
        try {
            if (this.isEnableDAConfigV2("DP")) {
                DPConfigPublishContext configPublishContext = new DPConfigPublishContext();
                this.FillDAConfigPublishContext((DAConfigPublishContext)configPublishContext);
                configPublishContext.setForm(this.getFormData());
                if (this.isEnableFormDigest()) {
                    configPublishContext.setAppendConfigId(this.getFormDigestData());
                    if (!this.IsBackEndMode()) {
                        configPublishContext.setActiveData(this.getActiveData());
                    }
                }
                return this.getDAConfigHelper().GetConfigId("DP", (IDAConfigPublishContext)configPublishContext);
            }
            return this.getPageParam("PAGE.FORM.DPCONFIGID", this.getDAConfigHelper().GetEditViewDPId(this.getDEHelper(), this.formView));
        }
        catch (Exception ex) {
            this.PageLog((Object)this, 1, StringHelper.Format((String)"\u83b7\u53d6\u52a8\u6001\u9762\u677f\u914d\u7f6e\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), ex);
            return "";
        }
    }

    public String RenderPanel() {
        if (this.bNoPanelMode) {
            return "";
        }
        String strOutput = "";
        if (this.panel != null) {
            strOutput = String.valueOf(strOutput) + PageRender.RenderLoadingIndicator((String)(String.valueOf(this.getDefaultFormId()) + "_indicator"));
            strOutput = String.valueOf(strOutput) + this.Render("panel");
        }
        return strOutput;
    }

    public String RenderErrorPanel() {
        if (this.bNoPanelMode) {
            return "";
        }
        String strOutput = "";
        if (this.panel != null) {
            strOutput = String.valueOf(strOutput) + StringHelper.Format((String)"<div class=\"sx-errorpanel\" id=\"%1$s_errorindicator\" style=\"width:100%%;height:150px;display:none;\"></div>", (Object)this.getDefaultFormId());
        }
        return strOutput;
    }

    protected void OnInitComponents() {
        super.OnInitComponents();
        if (!this.bNoPanelMode) {
            this.LoadToolbar();
            this.LoadDPEx();
        }
    }

    protected void OnInit() {
        super.OnInit();
        if (this.IsNoPanelMode()) {
            StringBuilderEx script = new StringBuilderEx();
            script.Append("var keys = '';if(dialogArguments){keys = dialogArguments.toString();}");
            script.Append("if(keys==''){alert('\u6ca1\u6709\u6307\u5b9a\u6709\u6548\u6570\u636e\uff0c\u65e0\u6cd5\u8fdb\u884c\u4ea4\u4e92\u64cd\u4f5c!');window.close();return;}");
            script.Append("submitiaaction(keys);");
            this.RegisterOnReadyScript(3, script.toString());
        } else {
            FormModifyAlertJSGear.Load((SRFDAPage)this);
        }
    }

    protected void LoadToolbar() {
        this.strToolbarConfigId = this.getPageParam("PAGE.TOOLBAR", "SRFWF.TB_WFIAACTIONDIALOG");
        this.toolbar = WFIAActionViewPage.CreateToolbar((SRFDAPage)this, (String)"toolBar", (double)0.0, (double)0.0, (String)this.strToolbarConfigId);
        if (this.wfIAActionViewModel != null && this.wfIAActionViewModel.getToolbarModel() != null) {
            this.wfIAActionViewModel.getToolbarModel().setCtrlId("toolBar");
            this.wfIAActionViewModel.getToolbarModel().setConfigId(this.strToolbarConfigId);
            this.wfIAActionViewModel.getToolbarModel().setRemoteCtrlId(this.toolbar.getUniqueID());
        }
    }

    public boolean IsNoPanelMode() {
        return this.bNoPanelMode;
    }

    public String GetSubmitIAActionURL() {
        String strURLParams = this.getWebContext().GetParamsString("SRFWFSTATE|SRFWFSTEP|SRFDEID|SRFWFIAACTIONNAME|SRFWFPROCESSNAME|WFSTEPACTORID");
        String strURL = this.OnGetSubmitIAActionURL();
        if (StringHelper.IsNullOrEmpty((String)strURL)) {
            strURL = "../srfwf/wfiaactionbackend.jsp";
        }
        strURL = URLHelper.AppendURLSeperator((String)strURL);
        return StringHelper.Format((String)"%1$s%2$s", (Object)strURL, (Object)strURLParams);
    }

    protected String OnGetSubmitIAActionURL() {
        Page page;
        String strURL = "";
        if (this.ppWFIAActionView != null) {
            strURL = this.ppWFIAActionView.getIAACTIONURL();
        }
        if (StringHelper.IsNullOrEmpty((String)(strURL = this.getPageParam("PAGE.WFIAACTIONURL", strURL)))) {
            return strURL;
        }
        if (strURL.indexOf(".jsp") == -1 && (page = ((SRFDAWebContext)this.webContext).getGlobalHelper().getDAModelStorage().FindPage(strURL)) != null) {
            return page.GetTotalPagePath();
        }
        return strURL;
    }

    protected boolean OnFillPageModel(JSONObject jsonObject) {
        if (!super.OnFillPageModel(jsonObject)) {
            return false;
        }
        this.wfIAActionViewModel.setNoPanelMode(this.IsNoPanelMode());
        this.wfIAActionViewModel.setSubmitIAActionUrl(this.GetSubmitIAActionURL());
        return true;
    }

    protected String OnGetPageTitle() {
        return this.GetLocalization("PAGE.HEADER.WFIAACTIOVIEW", "\u6d41\u7a0b\u4ea4\u4e92\u5904\u7406\u7a97\u53e3");
    }

    protected boolean OnGetEnableDEMainState() {
        return false;
    }
}

