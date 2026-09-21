/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.DEFHelper.IDEFHelper
 *  SA.SRFDA.Ctrl.DEFHelper.ILinkDEFHelper
 *  SA.SRFDA.Ctrl.Data.DER1N
 *  SA.SRFDA.Ctrl.IDAConfigPublishContext
 *  SA.SRFDA.Ctrl.IDEHelper
 *  SA.SRFDA.Web.ISRFDAWebContext
 *  SA.SRFDA.Web.SRFDAWebCTXHelper
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.Helper
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  SA.SRFramework.WebEx.Form.SRFExForm
 *  SA.SRFramework.WebEx.SRFExControl
 *  SA.SRFramework.WebEx.Script.FormJSHelper
 *  SA.SRFramework.WebEx.Script.TabViewJSHelper
 *  SA.SRFramework.WebEx.UI.TabViewPageConfig
 *  SA.SRFramework.WebEx.Utility.URLHelper
 */
package SA.SRFDA.Web.Default;

import SA.SRFDA.Ctrl.Config.EditViewToolbarConfigPublishContext;
import SA.SRFDA.Ctrl.DEFHelper.IDEFHelper;
import SA.SRFDA.Ctrl.DEFHelper.ILinkDEFHelper;
import SA.SRFDA.Ctrl.Data.DER1N;
import SA.SRFDA.Ctrl.IDAConfigPublishContext;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Web.Default.BaseEditViewPage2;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFDA.Web.JSGear.DataNavBarJSGear;
import SA.SRFDA.Web.JSGear.FormModifyAlertJSGear;
import SA.SRFDA.Web.SRFDAPage;
import SA.SRFDA.Web.SRFDAWebCTXHelper;
import SA.SRFDA.Web.ViewModel.DPExModel;
import SA.SRFDA.Web.ViewModel.FormModel;
import SA.SRFDA.Web.ViewModel.TabViewModel;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.Helper;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.WebEx.Form.SRFExForm;
import SA.SRFramework.WebEx.SRFExControl;
import SA.SRFramework.WebEx.Script.FormJSHelper;
import SA.SRFramework.WebEx.Script.TabViewJSHelper;
import SA.SRFramework.WebEx.UI.TabViewPageConfig;
import SA.SRFramework.WebEx.Utility.URLHelper;
import java.util.ArrayList;

public class EditViewPage2
extends BaseEditViewPage2 {
    @Override
    protected boolean PreparePageEnv() {
        if (!super.PreparePageEnv()) {
            return false;
        }
        this.strPageDataEntityId = this.getWebContext().getSRFDEID();
        this.strFormViewId = this.getWebContext().getSRFFormView();
        if (StringHelper.IsNullOrEmpty((String)this.strFormViewId)) {
            if (this.ppEditForm != null) {
                this.strFormViewId = this.ppEditForm.getFORMID();
            }
            this.strFormViewId = this.getPageParam("PAGE.FORM", this.strFormViewId);
        }
        if (!StringHelper.IsNullOrEmpty((String)this.strFormViewId)) {
            this.formView = this.getWebContext().GetConfigCache().GetUserDEForm(this.getWebContext(), this.strFormViewId);
            if (this.formView == null) {
                return false;
            }
            this.strPageDataEntityId = this.formView.getDEID();
            if (!this.LoadPageDataEntity()) {
                return false;
            }
            if (!this.ProcessDEIndexMode()) {
                return false;
            }
            if (this.OnGetProcessDEDataWFMode() && !this.ProcessDEDataWFMode()) {
                return false;
            }
        } else {
            if (!this.LoadPageDataEntity()) {
                return false;
            }
            if (!this.ProcessDEIndexMode()) {
                return false;
            }
            if (this.OnGetProcessDEDataWFMode() && !this.ProcessDEDataWFMode()) {
                return false;
            }
            try {
                this.formView = this.CalcCurrentFormView();
                this.strFormViewId = this.formView.getFORMID();
            }
            catch (Exception ex) {
                this.PageLog(this, 1, StringHelper.Format((String)"\u83b7\u53d6\u5b9e\u4f53[%1$s]\u5f53\u524d\u8868\u5355\u89c6\u56fe\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)this.strPageDataEntityId, (Object)ex.getMessage()), ex);
                return false;
            }
            this.getWebContext().SetParamValue("SRFFORMVIEW", this.formView.getFORMID());
        }
        if (!this.ProcessFormDigestMode()) {
            this.PageLog(this, 1, StringHelper.Format((String)"\u51c6\u5907\u8868\u5355\u6570\u636e\u654f\u611f\u6a21\u5f0f\u5931\u8d25"));
            return false;
        }
        this.bInfoMode = this.OnGetEditViewInfoMode();
        this.setPageParam("FORMVIEW", this.formView);
        this.setPageParam("PANEL", this.formView);
        return true;
    }

    protected void OnInitComponents() {
        super.OnInitComponents();
        this.LoadToolbar();
        if (!this.isSimpleMode()) {
            this.LoadTabView();
        }
        this.LoadDPEx();
    }

    protected void OnInitBackEnd() {
        super.OnInitBackEnd();
        this.RegisterFormActionHelper(this.getDefaultFormId(), this.GetFormActionHelper());
    }

    protected void LoadDPEx() {
        this.strDPConfigId = this.OnGetDPConfigId();
        this.panel = EditViewPage2.CreateDPEx((SRFDAPage)this, "Panel", true, this.strDPConfigId);
        if (this.panel != null) {
            this.panel.getDPConfig().setWidth(600);
            if (this.isSimpleMode()) {
                this.panel.getDPConfig().setSimpleMode(this.isSimpleMode());
            }
        }
        SRFExForm form = (SRFExForm)this.getDefaultForm();
        form.getLoadAction().setLoadDefault(true);
        form.setEnableItemPrivilege(this.isEnableFormItemPrivilege());
        if (this.editView2Model != null) {
            DPExModel dpExModel = this.editView2Model.getDPExModel();
            dpExModel.setConfigId(this.strDPConfigId);
            dpExModel.setRemoteCtrlId(this.panel.getUniqueID());
            FormModel formModel = this.editView2Model.getFormModel();
            formModel.setRemoteCtrlId(form.getFormId());
            formModel.setItemPrivilege(this.OnGetFormItemPrivilege());
        }
        if (!this.IsBackEndMode()) {
            StringBuilderEx script = new StringBuilderEx();
            script.Reset();
            script.Append("$P.setmainform(%1$s);", (Object)form.getFormId());
            if (this.IsOutputTabView()) {
                script.Append("$P.mainform.newdata=function(){%1$s %2$s.loaddefault(); };", (Object)TabViewJSHelper.getSetDataScript((String)this.tabView.getUniqueID(), (String)"{}"), (Object)form.getFormId());
            } else {
                script.Append("$P.mainform.newdata=function(){%1$s.loaddefault(); };", (Object)form.getFormId());
            }
            this.RegisterOnReadyScript(3, script.toString());
            script.Reset();
            ArrayList keyControls = form.GetKeyFormControls();
            int nCount = keyControls.size();
            if (nCount == 0) {
                script.Append("alert('\u8868\u5355\u6ca1\u6709\u4efb\u4f55\u4e3b\u952e\uff0c\u5904\u7406\u505c\u6b62!');");
            }
            String strParamName = "";
            String strParamValue = "";
            int i = 0;
            while (i < nCount) {
                SRFExControl control = (SRFExControl)keyControls.get(i);
                IDEFHelper iDEFHelper = this.getDEHelper().GetDEFHelper(control.getID());
                if (iDEFHelper == null) {
                    script.Append("alert('\u65e0\u6cd5\u627e\u5230\u5b9e\u4f53\u4e3b\u952e\u8f85\u52a9\u5bf9\u8c61\uff0c\u5904\u7406\u505c\u6b62!');");
                    break;
                }
                if (iDEFHelper.IsLinkDEField()) {
                    ILinkDEFHelper linkDEFHelper = (ILinkDEFHelper)iDEFHelper;
                    strParamValue = this.getWebContext().GetParamValue(linkDEFHelper.GetRelatedDEFHelper().getName());
                    strParamName = linkDEFHelper.GetRelatedDEFHelper().getName();
                } else {
                    strParamValue = this.getWebContext().GetParamValue(iDEFHelper.getName());
                    strParamName = iDEFHelper.getName();
                }
                ++i;
            }
            if (SRFDAWebCTXHelper.IsTempDataMode((ISRFDAWebContext)this.getWebContext(), (boolean)false)) {
                strParamValue = this.getWebContext().GetParamValue("SRFDATEMPKEYID");
            } else if (StringHelper.IsNullOrEmpty((String)strParamValue) && !StringHelper.IsNullOrEmpty((String)(strParamValue = SRFDAWebCTXHelper.GetDAKey((ISRFDAWebContext)this.getWebContext())))) {
                this.getWebContext().SetParamValue(strParamName, strParamValue);
                this.getWebContext().SetParamValue("SRFDAKEYS", "");
            }
            if (StringHelper.IsNullOrEmpty((String)strParamValue) || SRFDAWebCTXHelper.IsNewDataMode((ISRFDAWebContext)this.getWebContext()) && !this.isCopyMode()) {
                this.bContainKey = false;
                script.Append("%1$s", (Object)FormJSHelper.getLoadDefaultScript((SRFExForm)form));
            } else {
                String strFKey = "";
                String strSRFDERId = this.getWebContext().getSRFDERID();
                if (!StringHelper.IsNullOrEmpty((String)strSRFDERId)) {
                    DER1N der1N = new DER1N();
                    CallResult callResult = this.getDAModelHelper().GetDER1N(strSRFDERId, der1N);
                    if (callResult.getRetCode() != 0) {
                        this.PageLog(null, 1, StringHelper.Format((String)"\u83b7\u53d6DER1N[%1$s]\u5931\u8d25\uff0c%2$s", (Object)strSRFDERId, (Object)callResult.getErrorInfo()));
                    } else {
                        IDEHelper iMajorDEHelper = this.getDAModelStorage().FindDEHelper(der1N.getMAJORDEID());
                        if (iMajorDEHelper == null) {
                            this.PageLog(null, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u8f85\u52a9\u5bf9\u8c61", (Object)der1N.getMAJORDEID()));
                        } else {
                            strFKey = iMajorDEHelper.GetKeyDEFHelper().getName();
                        }
                    }
                }
                if (StringHelper.Compare((String)strFKey, (String)strParamName, (boolean)true) == 0) {
                    this.bContainKey = false;
                    script.Append("%1$s", (Object)FormJSHelper.getLoadDefaultScript((SRFExForm)form));
                } else {
                    this.bContainKey = true;
                    this.keyJson.put(strParamName.toLowerCase(), (Object)strParamValue);
                    script.Append("%1$s", (Object)FormJSHelper.getLoad2Script((SRFExForm)form, (String)("'" + strParamValue + "'" + StringHelper.Format((String)",%1$s", (Object)(this.isCopyMode() ? "true" : "false")))));
                }
            }
            this.RegisterOnReadyScript(5, script.toString());
            script.Reset();
            script.Append("SRFUtility.refreshpdg();");
            script.Append("if($V(%1$s.saveandclose,false)){ window.close();return ;}", (Object)form.getFormId());
            if (this.IsOutputTabView()) {
                script.Append("if($V(%1$s.saveandnew,false)){%2$s %1$s.loaddefault(); return ;}", (Object)form.getFormId(), (Object)TabViewJSHelper.getSetDataScript((String)this.tabView.getUniqueID(), (String)"{}"));
            } else {
                script.Append("if($V(%1$s.saveandnew,false)){%1$s.loaddefault(); return ;}", (Object)form.getFormId());
            }
            form.getSaveAction().getSuccessAction().RegisterProcessCode(0, script.toString());
            if (this.IsOutputTabView()) {
                form.getSaveAction().getSuccessAction().RegisterProcessCode(0, TabViewJSHelper.getSetDataScript((String)this.tabView.getUniqueID(), (String)FormJSHelper.getFormGetKeysScript((SRFExForm)form)));
                script.Reset();
                script.Append("if($V(_JO.copymode,false)){%1$s}else{%2$s}", (Object)TabViewJSHelper.getSetDataScript((String)this.tabView.getUniqueID(), (String)"{_COPYMODE:true}"), (Object)TabViewJSHelper.getSetDataScript((String)this.tabView.getUniqueID(), (String)FormJSHelper.getFormGetKeysScript((SRFExForm)form)));
                form.getLoadAction().getSuccessAction().RegisterProcessCode(0, script.toString());
            }
        }
    }

    @Override
    protected void OnInit() {
        super.OnInit();
        SRFExForm form = (SRFExForm)this.getDefaultForm();
        FormModifyAlertJSGear.Load(this);
        IDEFHelper keyDEFHelper = this.getDEHelper().GetKeyDEFHelper();
        DataNavBarJSGear.Load(this, null, form, keyDEFHelper.getName());
        if (this.isJSCache()) {
            this.RegisterUncacheOnReadyScript(1, StringHelper.Format((String)"%1$s._URL='%2$s';\r\n", (Object)form.getFormId(), (Object)this.getDefaultBackEndUrl()));
        }
    }

    protected void LoadToolbar() {
        if (!this.IsBackEndMode()) {
            this.strToolbarConfigId = this.GetToolbarConfigId();
            if (StringHelper.IsNullOrEmpty((String)this.strToolbarConfigId)) {
                return;
            }
        }
        this.toolbar = EditViewPage2.CreateToolbar(this, "toolBar", 0.0, 0.0, this.strToolbarConfigId);
        if (this.editView2Model != null && this.editView2Model.getToolbarModel() != null) {
            this.editView2Model.getToolbarModel().setCtrlId("toolBar");
            this.editView2Model.getToolbarModel().setConfigId(this.strToolbarConfigId);
            this.editView2Model.getToolbarModel().setRemoteCtrlId(this.toolbar.getUniqueID());
        }
    }

    protected String GetToolbarConfigId() {
        try {
            if (this.IsContainPageParam("PAGE.TOOLBAR")) {
                return this.getPageParam("PAGE.TOOLBAR", "");
            }
            if (this.isEnableDAConfigV2("TOOLBAR")) {
                EditViewToolbarConfigPublishContext configPublishContext = new EditViewToolbarConfigPublishContext();
                this.FillDAConfigPublishContext(configPublishContext);
                configPublishContext.setEmbedMode(false);
                configPublishContext.setReadOnlyMode(this.bInfoMode);
                return this.getDAConfigHelper().GetConfigId("TOOLBAR", (IDAConfigPublishContext)configPublishContext);
            }
            return this.getDAConfigHelper().GetEditViewToolbarConfigId(this.getDEHelper(), this.page, null, false, this.bInfoMode);
        }
        catch (Exception ex) {
            this.PageLog(this, 1, StringHelper.Format((String)"\u83b7\u53d6\u5de5\u5177\u680f\u89c6\u56fe\u914d\u7f6e\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), ex);
            return "";
        }
    }

    protected void LoadTabView() {
        this.strTabViewConfigId = this.getDAConfigHelper().GetEditViewTabViewConfigId(this.getDEHelper(), this.page);
        if (StringHelper.IsNullOrEmpty((String)this.strTabViewConfigId)) {
            return;
        }
        this.tabView = EditViewPage2.CreateTabView((SRFDAPage)this, "TabView", 600.0, 0.0, this.strTabViewConfigId);
        if (this.tabView != null) {
            this.tabView.getTabViewConfig().RemoveTabPage("EDIT");
            this.tabView.getTabViewConfig().setResizeChild(true);
            if (!this.IsBackEndMode()) {
                int nCount = this.tabView.getTabViewConfig().getTabViewPages().size();
                int i = 0;
                while (i < nCount) {
                    TabViewPageConfig tabViewPageConfig = (TabViewPageConfig)this.tabView.getTabViewConfig().getTabViewPages().get(i);
                    String strURL = URLHelper.AppendURLSeperator((String)tabViewPageConfig.getRemoteURL());
                    strURL = String.valueOf(strURL) + "&SRFSHOWCAP=FALSE";
                    tabViewPageConfig.setRemoteURL(strURL);
                    ++i;
                }
            }
            if (this.editView2Model != null && this.editView2Model.getTabViewModel() != null) {
                TabViewModel tabViewModel = this.editView2Model.getTabViewModel();
                tabViewModel.setCtrlId("tabView");
                tabViewModel.setConfigId(this.strTabViewConfigId);
                tabViewModel.setRemoteCtrlId(this.tabView.getUniqueID());
            }
        }
    }

    public String RenderTabView() {
        if (this.IsOutputTabView()) {
            return this.Render("tabView");
        }
        return "";
    }

    public boolean IsOutputTabView() {
        return this.tabView != null && this.tabView.getTabViewConfig().getTabViewPages().size() > 0;
    }

    public String RenderPanel() {
        String strOutput = "";
        if (this.panel != null) {
            strOutput = String.valueOf(strOutput) + this.Render("panel");
        }
        return strOutput;
    }

    public String RenderErrorPanel() {
        String strOutput = "";
        if (this.panel != null) {
            strOutput = String.valueOf(strOutput) + StringHelper.Format((String)"<div class=\"sx-errorpanel\" id=\"%1$s_errorindicator\" style=\"width:100%%;height:150px;display:none;overflow:auto;\"></div>", (Object)this.getDefaultFormId());
        }
        return strOutput;
    }

    protected String getJSCahceFilePath() {
        String strPageId = "";
        strPageId = String.valueOf(strPageId) + this.getCurPagePath();
        strPageId = String.valueOf(strPageId) + StringHelper.Format((String)"_%1$s_%2$s", (Object)this.iDEHelper.getId(), (Object)this.iDEHelper.getVersion());
        strPageId = this.page != null ? String.valueOf(strPageId) + StringHelper.Format((String)"_%1$s_%2$s", (Object)this.page.getPAGEID(), (Object)this.page.getVERSION()) : String.valueOf(strPageId) + "_NOPAGE";
        strPageId = this.formView != null ? String.valueOf(strPageId) + StringHelper.Format((String)"_%1$s_%2$s", (Object)this.formView.getFORMID(), (Object)this.formView.getFMVERSION()) : String.valueOf(strPageId) + "_NOFORM";
        return String.valueOf(Helper.GenMD5((String)strPageId)) + ".js";
    }
}

