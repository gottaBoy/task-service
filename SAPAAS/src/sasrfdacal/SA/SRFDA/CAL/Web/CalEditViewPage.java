/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.DEFHelper.IDEFHelper
 *  SA.SRFDA.Ctrl.Data.Form
 *  SA.SRFDA.Web.Default.BaseMainPage
 *  SA.SRFDA.Web.Default.PageRender
 *  SA.SRFDA.Web.Default.ViewModel.EditView2Model
 *  SA.SRFDA.Web.SRFDAPage
 *  SA.SRFDA.Web.ViewModel.DPExModel
 *  SA.SRFDA.Web.ViewModel.FormModel
 *  SA.SRFDA.Web.ViewModel.PageModel
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  SA.SRFramework.WebEx.DP.SRFExDPEx
 *  SA.SRFramework.WebEx.Form.SRFExForm
 *  SA.SRFramework.WebEx.SRFExControl
 *  SA.SRFramework.WebEx.Script.FormJSHelper
 *  SA.SRFramework.WebEx.ToolBar.SRFExToolbar
 *  net.sf.json.JSONObject
 */
package SA.SRFDA.CAL.Web;

import SA.SRFDA.CAL.Ctrl.Form.CalendarFormActionHelper;
import SA.SRFDA.Ctrl.DEFHelper.IDEFHelper;
import SA.SRFDA.Ctrl.Data.Form;
import SA.SRFDA.Web.Default.BaseMainPage;
import SA.SRFDA.Web.Default.PageRender;
import SA.SRFDA.Web.Default.ViewModel.EditView2Model;
import SA.SRFDA.Web.SRFDAPage;
import SA.SRFDA.Web.ViewModel.DPExModel;
import SA.SRFDA.Web.ViewModel.FormModel;
import SA.SRFDA.Web.ViewModel.PageModel;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.WebEx.DP.SRFExDPEx;
import SA.SRFramework.WebEx.Form.SRFExForm;
import SA.SRFramework.WebEx.SRFExControl;
import SA.SRFramework.WebEx.Script.FormJSHelper;
import SA.SRFramework.WebEx.ToolBar.SRFExToolbar;
import net.sf.json.JSONObject;

public class CalEditViewPage
extends BaseMainPage {
    protected SRFExToolbar toolbar = null;
    protected SRFExDPEx panel = null;
    protected Form formView = new Form();
    protected String strFormViewId = "";
    protected String strCalendarId = "";
    protected SRFExForm form = null;
    private boolean bContainKey = false;
    private JSONObject keyJson = new JSONObject();
    protected EditView2Model editView2Model = null;

    protected boolean PreparePageEnv() {
        if (!super.PreparePageEnv()) {
            return false;
        }
        this.strCalendarId = this.getWebContext().GetParamValue("CALENDARID");
        this.strPageDataEntityId = this.getWebContext().getSRFDEID();
        if (StringHelper.IsNullOrEmpty((String)this.strPageDataEntityId)) {
            this.strPageDataEntityId = "DE0050";
        }
        this.strFormViewId = this.OnGetFormViewId();
        if (!this.LoadPageDataEntity()) {
            return false;
        }
        this.formView = this.getWebContext().GetConfigCache().GetUserDEForm(this.getWebContext(), this.strFormViewId);
        if (this.formView == null) {
            return false;
        }
        this.setPageParam("FORMVIEW", this.formView);
        return true;
    }

    protected PageModel CreatePageModel() {
        return new EditView2Model();
    }

    protected void PreparePageModel() {
        super.PreparePageModel();
        this.editView2Model = (EditView2Model)this.pageModel;
    }

    protected String OnGetFormViewId() {
        String strFormViewId = this.getPageParam("PAGE.FORM", "");
        if (!StringHelper.IsNullOrEmpty((String)strFormViewId)) {
            return strFormViewId;
        }
        return "DE0050_MAINFORM";
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
        if (!StringHelper.IsNullOrEmpty((String)this.formView.getBACKENDCTRL())) {
            return this.formView.getBACKENDCTRL();
        }
        return CalendarFormActionHelper.class.getName();
    }

    protected void LoadDPEx() {
        String strDPConfigId = this.getDAConfigHelper().GetEditViewDPId(this.getDEHelper(), this.formView);
        this.panel = CalEditViewPage.CreateDPEx((SRFDAPage)this, (String)"Panel", (boolean)true, (String)strDPConfigId);
        if (this.panel != null) {
            this.panel.getDPConfig().setWidth(600);
            if (this.panel.getDPConfig().getPageGroupsConfig().size() == 1) {
                this.panel.getDPConfig().setSimpleMode(true);
            }
        }
        this.form = (SRFExForm)this.getDefaultForm();
        this.form.getLoadAction().setLoadDefault(true);
        if (this.editView2Model != null) {
            DPExModel dpExModel = this.editView2Model.getDPExModel();
            dpExModel.setConfigId(strDPConfigId);
            dpExModel.setRemoteCtrlId(this.panel.getUniqueID());
            FormModel formModel = this.editView2Model.getFormModel();
            formModel.setRemoteCtrlId(this.form.getFormId());
        }
        if (!this.IsBackEndMode()) {
            StringBuilderEx script = new StringBuilderEx();
            script.Reset();
            script.Append("$P.setmainform(%1$s);", (Object)this.form.getFormId());
            this.RegisterOnReadyScript(3, script.toString());
            script.Reset();
            IDEFHelper keyDEFHelper = this.getDEHelper().GetKeyDEFHelper();
            SRFExControl keyControl = this.form.FindControl(keyDEFHelper.getName());
            if (keyControl == null) {
                script.Append("alert('\u8868\u5355\u6ca1\u6709\u4efb\u4f55\u4e3b\u952e\uff0c\u5904\u7406\u505c\u6b62!');");
            } else if (StringHelper.IsNullOrEmpty((String)this.strCalendarId)) {
                script.Append(FormJSHelper.getLoadDefaultScript((SRFExForm)this.form));
            } else {
                this.bContainKey = true;
                this.keyJson.put("calendarid", (Object)this.strCalendarId);
                script.Append("%1$s.S('%2$s','%3$s');%1$s.load();", (Object)this.form.getFormId(), (Object)keyControl.getUniqueID(), (Object)this.strCalendarId);
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
        StringBuilderEx script = new StringBuilderEx();
        script.Append("window.onbeforeunload=function(e){if($P.mainform==null)return;var _1=$P.mainform.isdirty();if(_1){if(e){e.returnValue='\u8868\u5355\u5185\u5bb9\u5df2\u7ecf\u66f4\u6539\uff0c\u786e\u5b9e\u8981\u79bb\u5f00\u5f53\u524d\u754c\u9762\u4e48\uff1f';}if(window.event){window.event.returnValue='\u8868\u5355\u5185\u5bb9\u5df2\u7ecf\u66f4\u6539\uff0c\u786e\u5b9e\u8981\u79bb\u5f00\u5f53\u524d\u754c\u9762\u4e48\uff1f';}}};");
        this.RegisterOnReadyScript(3, script.toString());
    }

    protected void LoadToolbar() {
        String strSeqMode;
        String strToolbarConfigId = "";
        strToolbarConfigId = this.getWebContext().getWebExConfig().GetValue("SRFCAL", "CALSEQ", false) ? (StringHelper.Compare((String)(strSeqMode = this.getWebContext().GetParamValue("SEQMODE")), (String)"TRUE", (boolean)true) == 0 ? "SRFCAL.TB_EDITSEQ" : "SRFCAL.TB_EDIT") : "SRFCAL.TB_EDIT_NOSEQ";
        this.toolbar = CalEditViewPage.CreateToolbar((SRFDAPage)this, (String)"toolBar", (double)0.0, (double)0.0, (String)strToolbarConfigId);
        if (this.editView2Model != null && this.editView2Model.getToolbarModel() != null) {
            this.editView2Model.getToolbarModel().setCtrlId("toolBar");
            this.editView2Model.getToolbarModel().setConfigId(strToolbarConfigId);
            this.editView2Model.getToolbarModel().setRemoteCtrlId(this.toolbar.getUniqueID());
        }
    }

    public String GetOkCode() {
        StringBuilderEx script = new StringBuilderEx();
        script.Append(FormJSHelper.getSaveScript((SRFExForm)this.form));
        return script.toString();
    }

    protected boolean OnFillPageModel(JSONObject jsonObject) {
        if (!super.OnFillPageModel(jsonObject)) {
            return false;
        }
        this.editView2Model.setContainKey(this.bContainKey);
        if (this.bContainKey) {
            this.editView2Model.setKeyData(this.keyJson);
        }
        return true;
    }
}

