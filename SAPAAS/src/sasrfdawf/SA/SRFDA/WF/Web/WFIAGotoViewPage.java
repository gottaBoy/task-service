/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.Data.DEWF
 *  SA.SRFDA.Web.Default.BaseMainPage
 *  SA.SRFDA.Web.Default.PageRender
 *  SA.SRFDA.Web.Default.ViewModel.EditView2Model
 *  SA.SRFDA.Web.JSGear.FormModifyAlertJSGear
 *  SA.SRFDA.Web.SRFDAPage
 *  SA.SRFDA.Web.ViewModel.DPExModel
 *  SA.SRFDA.Web.ViewModel.FormModel
 *  SA.SRFDA.Web.ViewModel.PageModel
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  SA.SRFramework.WebEx.DP.SRFExDPEx
 *  SA.SRFramework.WebEx.Form.SRFExForm
 *  SA.SRFramework.WebEx.SRFExControl
 *  SA.SRFramework.WebEx.ToolBar.SRFExToolbar
 */
package SA.SRFDA.WF.Web;

import SA.SRFDA.Ctrl.Data.DEWF;
import SA.SRFDA.Web.Default.BaseMainPage;
import SA.SRFDA.Web.Default.PageRender;
import SA.SRFDA.Web.Default.ViewModel.EditView2Model;
import SA.SRFDA.Web.JSGear.FormModifyAlertJSGear;
import SA.SRFDA.Web.SRFDAPage;
import SA.SRFDA.Web.ViewModel.DPExModel;
import SA.SRFDA.Web.ViewModel.FormModel;
import SA.SRFDA.Web.ViewModel.PageModel;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.WebEx.DP.SRFExDPEx;
import SA.SRFramework.WebEx.Form.SRFExForm;
import SA.SRFramework.WebEx.SRFExControl;
import SA.SRFramework.WebEx.ToolBar.SRFExToolbar;

public class WFIAGotoViewPage
extends BaseMainPage {
    protected SRFExToolbar toolbar = null;
    protected SRFExDPEx panel = null;
    protected String strFormViewId = "";
    protected String strWFState = "";
    protected String strWFStep = "";
    protected String strWFFormName = "";
    protected DEWF deWF = null;
    public static final String TAG_WFFORMNAME_DEFAULT = "DEFAULT";
    protected EditView2Model editView2Model = null;

    protected boolean PreparePageEnv() {
        if (!super.PreparePageEnv()) {
            return false;
        }
        this.strWFStep = this.getWebContext().getSRFWFSTEP();
        this.strPageDataEntityId = this.getWebContext().getSRFDEID();
        return this.LoadPageDataEntity();
    }

    protected PageModel CreatePageModel() {
        return new EditView2Model();
    }

    protected void PreparePageModel() {
        super.PreparePageModel();
        this.editView2Model = (EditView2Model)this.pageModel;
    }

    protected void OnInitBackEnd() {
        super.OnInitBackEnd();
        this.RegisterFormActionHelper(this.getDefaultFormId(), "SA.SRFDA.WF.Ctrl.Form.WFIAGotoFormActionHelper");
    }

    protected void LoadDPEx() {
        String strDPConfigId = this.getWebContext().getWebExConfig().GetValue("SRFDA", "WFIAGOTODP", "SRFWF.DPEX_IAGOTO");
        this.panel = WFIAGotoViewPage.CreateDPEx((SRFDAPage)this, (String)"Panel", (boolean)true, (String)strDPConfigId);
        if (this.panel != null) {
            this.panel.getDPConfig().setWidth(600);
            if (this.panel.getDPConfig().getPageGroupsConfig().size() == 1) {
                this.panel.getDPConfig().setSimpleMode(true);
            }
        }
        SRFExForm form = (SRFExForm)this.getDefaultForm();
        form.getLoadAction().setLoadDefault(false);
        if (this.editView2Model != null) {
            DPExModel dpExModel = this.editView2Model.getDPExModel();
            dpExModel.setConfigId(strDPConfigId);
            dpExModel.setRemoteCtrlId(this.panel.getUniqueID());
            FormModel formModel = this.editView2Model.getFormModel();
            formModel.setRemoteCtrlId(form.getFormId());
        }
        if (!this.IsBackEndMode()) {
            StringBuilderEx script = new StringBuilderEx();
            script.Reset();
            script.Append("$P.setmainform(%1$s);", (Object)form.getFormId());
            this.RegisterOnReadyScript(3, script.toString());
            script.Reset();
            SRFExControl keyControl = form.FindControl("WFKEYS");
            if (keyControl == null) {
                script.Append("alert('\u8868\u5355\u6ca1\u6709\u4efb\u4f55\u4e3b\u952e\uff0c\u5904\u7406\u505c\u6b62!');");
            } else {
                script.Append("var keys = '';if(dialogArguments){keys = dialogArguments.toString();}", (Object)form.getFormId(), (Object)keyControl.getUniqueID());
                script.Append("if(keys == '')return;%1$s.S('%2$s',keys);%1$s.load();", (Object)form.getFormId(), (Object)keyControl.getUniqueID());
            }
            this.RegisterOnReadyScript(5, script.toString());
        }
    }

    public String RenderPanel() {
        String strOutput = "";
        if (this.panel != null) {
            strOutput = String.valueOf(strOutput) + PageRender.RenderLoadingIndicator((String)(String.valueOf(this.getDefaultFormId()) + "_indicator"));
            strOutput = String.valueOf(strOutput) + this.Render("panel");
        }
        return strOutput;
    }

    public String RenderErrorPanel() {
        String strOutput = "";
        if (this.panel != null) {
            strOutput = String.valueOf(strOutput) + StringHelper.Format((String)"<div class=\"sx-errorpanel\" id=\"%1$s_errorindicator\" style=\"width:100%%;height:150px;display:none;\"></div>", (Object)this.getDefaultFormId());
        }
        return strOutput;
    }

    protected void OnInitComponents() {
        super.OnInitComponents();
        this.LoadToolbar();
        this.LoadDPEx();
    }

    protected void OnInit() {
        super.OnInit();
        FormModifyAlertJSGear.Load((SRFDAPage)this);
    }

    protected void LoadToolbar() {
        String strToolbarConfigId = this.getPageParam("PAGE.TOOLBAR", "SRFWF.TB_WFIAACTIONDIALOG");
        this.toolbar = WFIAGotoViewPage.CreateToolbar((SRFDAPage)this, (String)"toolBar", (double)0.0, (double)0.0, (String)strToolbarConfigId);
        if (this.editView2Model != null && this.editView2Model.getToolbarModel() != null) {
            this.editView2Model.getToolbarModel().setCtrlId("toolBar");
            this.editView2Model.getToolbarModel().setConfigId(strToolbarConfigId);
            this.editView2Model.getToolbarModel().setRemoteCtrlId(this.toolbar.getUniqueID());
        }
    }

    protected boolean OnGetEnableDEMainState() {
        return false;
    }
}

