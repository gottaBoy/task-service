/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.DEFHelper.IDEFHelper
 *  SA.SRFDA.Ctrl.Data.DEWF
 *  SA.SRFDA.Ctrl.Data.Form
 *  SA.SRFDA.Ctrl.Data.PP.PPFormView
 *  SA.SRFDA.Ctrl.IDESubWFHelper
 *  SA.SRFDA.Ctrl.IDEWFHelper
 *  SA.SRFDA.Web.ISRFDAWebContext
 *  SA.SRFDA.Web.SRFDAWebCTXHelper
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.Helper
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.PropertiesHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  SA.SRFramework.Web.ListItem
 *  SA.SRFramework.WebEx.Form.SRFExForm
 *  SA.SRFramework.WebEx.SRFExControl
 *  SA.SRFramework.WebEx.SRFExDropDownList
 *  SA.SRFramework.WebEx.Script.FormJSHelper
 *  SA.SRFramework.WebEx.Script.TabViewJSHelper
 *  SRFWF.Client.WFClientAPI
 *  SRFWF.Client.WFGetIAActionsResult
 *  SRFWF.Ctrl.SRFWFStates
 *  SRFWF.Model.WFInteractiveActionConfig
 */
package SA.SRFDA.Web.Default;

import SA.SRFDA.Ctrl.DEFHelper.IDEFHelper;
import SA.SRFDA.Ctrl.Data.DEWF;
import SA.SRFDA.Ctrl.Data.Form;
import SA.SRFDA.Ctrl.Data.PP.PPFormView;
import SA.SRFDA.Ctrl.IDESubWFHelper;
import SA.SRFDA.Ctrl.IDEWFHelper;
import SA.SRFDA.Web.Default.BaseFormViewPage;
import SA.SRFDA.Web.Default.PageRender;
import SA.SRFDA.Web.Default.ViewModel.FormViewModel;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFDA.Web.JSGear.TabView2FormJSGear;
import SA.SRFDA.Web.SRFDAPage;
import SA.SRFDA.Web.SRFDAWebCTXHelper;
import SA.SRFDA.Web.ViewModel.DPExModel;
import SA.SRFDA.Web.ViewModel.FormModel;
import SA.SRFDA.Web.ViewModel.PageModel;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.Helper;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.PropertiesHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.Web.ListItem;
import SA.SRFramework.WebEx.Form.SRFExForm;
import SA.SRFramework.WebEx.SRFExControl;
import SA.SRFramework.WebEx.SRFExDropDownList;
import SA.SRFramework.WebEx.Script.FormJSHelper;
import SA.SRFramework.WebEx.Script.TabViewJSHelper;
import SRFWF.Client.WFClientAPI;
import SRFWF.Client.WFGetIAActionsResult;
import SRFWF.Ctrl.SRFWFStates;
import SRFWF.Model.WFInteractiveActionConfig;
import java.util.Properties;
import java.util.TreeMap;

public class FormViewPage
extends BaseFormViewPage {
    protected String strWFStepColumnName = "";
    protected PPFormView ppFormView = null;
    protected IDESubWFHelper iDESubWFHelper = null;
    protected IDEWFHelper iDEWFHelper = null;
    protected String strDESubWFId = "";
    protected String strSubWFStep = "";
    protected String strSubWFStepColumnName;
    protected FormViewModel formViewModel = null;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    protected boolean PreparePageEnv() {
        block22: {
            if (StringHelper.IsNullOrEmpty((String)this.getWebContext().getTabViewPageId())) {
                this.PageLog(this, 1, "\u6ca1\u6709\u6307\u5b9a\u5206\u9875\u7f16\u53f7");
                return false;
            }
            this.setID(this.getWebContext().getTabViewPageId());
            if (!super.PreparePageEnv()) {
                return false;
            }
            String strFormState = this.getWebContext().GetSRFFormState();
            if (!StringHelper.IsNullOrEmpty((String)strFormState)) {
                this.setPageParam("PAGE.FORMSTATE", strFormState);
            }
            this.strPageDataEntityId = this.getWebContext().getSRFDEID();
            this.strFormViewId = this.getWebContext().getSRFFormView();
            if (StringHelper.IsNullOrEmpty((String)this.strFormViewId)) {
                if (this.ppEditForm != null) {
                    this.strFormViewId = this.ppEditForm.getFORMID();
                }
                this.strFormViewId = this.getPageParam("PAGE.FORM", this.strFormViewId);
            }
            try {
                if (!StringHelper.IsNullOrEmpty((String)this.strFormViewId)) {
                    this.formView = this.getWebContext().GetConfigCache().GetUserDEForm(this.getWebContext(), this.strFormViewId);
                    if (this.formView == null) {
                        this.PageLog(this, 1, StringHelper.Format((String)"\u83b7\u53d6\u5b9e\u4f53[%1$s]\u8868\u5355[%2$s]\u5931\u8d25", (Object)this.strPageDataEntityId, (Object)this.strFormViewId));
                        return false;
                    }
                    this.strPageDataEntityId = this.formView.getDEID();
                    if (!this.LoadPageDataEntity()) {
                        return false;
                    }
                    if (!this.getDEHelper().IsEnableWF()) break block22;
                    this.iDEWFHelper = this.getDEHelper().GetDEWFHelper();
                    this.strDESubWFId = SRFDAWebCTXHelper.GetDESubWFId((ISRFDAWebContext)this.getWebContext());
                    if (!StringHelper.IsNullOrEmpty((String)this.strDESubWFId)) {
                        this.iDESubWFHelper = this.getDEHelper().GetDESubWFHelper(this.strDESubWFId);
                        this.strSubWFStep = SRFDAWebCTXHelper.GetWFSubStep((ISRFDAWebContext)this.getWebContext());
                    }
                    break block22;
                }
                if (!this.LoadPageDataEntity()) {
                    return false;
                }
                if (this.getDEHelper().IsEnableWF()) {
                    this.iDEWFHelper = this.getDEHelper().GetDEWFHelper();
                    this.strDESubWFId = SRFDAWebCTXHelper.GetDESubWFId((ISRFDAWebContext)this.getWebContext());
                    if (!StringHelper.IsNullOrEmpty((String)this.strDESubWFId)) {
                        this.iDESubWFHelper = this.getDEHelper().GetDESubWFHelper(this.strDESubWFId);
                        this.strSubWFStep = SRFDAWebCTXHelper.GetWFSubStep((ISRFDAWebContext)this.getWebContext());
                    }
                }
                if (!this.OnGetDefaultWFFormView()) {
                    try {
                        this.strFormViewId = this.getCurrentDEMainActionForm();
                        if (!StringHelper.IsNullOrEmpty((String)this.strFormViewId)) {
                            this.formView = this.getWebContext().GetConfigCache().GetUserDEForm(this.getWebContext(), this.strFormViewId);
                            if (this.formView == null) {
                                this.PageLog(this, 1, StringHelper.Format((String)"\u83b7\u53d6\u5b9e\u4f53[%1$s]\u8868\u5355[%2$s]\u5931\u8d25", (Object)this.strPageDataEntityId, (Object)this.strFormViewId));
                                return false;
                            }
                        }
                    }
                    catch (Exception ex) {
                        this.PageLog(this, 1, StringHelper.Format((String)"\u83b7\u53d6\u5b9e\u4f53[%1$s]\u5f53\u524d\u4e3b\u64cd\u4f5c\u8868\u5355\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)this.strPageDataEntityId, (Object)ex.getMessage()), ex);
                        return false;
                    }
                    if (this.formView == null) {
                        this.formView = this.getWebContext().GetConfigCache().GetDefaultDEMainForm(this.getWebContext(), this.strPageDataEntityId);
                    }
                }
                if (this.formView == null) {
                    this.PageLog(this, 1, StringHelper.Format((String)"\u83b7\u53d6\u5b9e\u4f53[%1$s]\u9ed8\u8ba4\u8868\u5355\u5931\u8d25", (Object)this.strPageDataEntityId));
                    return false;
                }
                this.getWebContext().SetParamValue("SRFFORMVIEW", this.formView.getFORMID());
            }
            catch (Exception ex) {
                this.PageLog(this, 1, StringHelper.Format((String)"\u51c6\u5907\u8868\u5355\u6570\u636e\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), ex);
                return false;
            }
        }
        if (!this.ProcessFormDigestMode()) {
            this.PageLog(this, 1, StringHelper.Format((String)"\u51c6\u5907\u8868\u5355\u6570\u636e\u654f\u611f\u6a21\u5f0f\u5931\u8d25"));
            return false;
        }
        this.setPageParam("FORMVIEW", this.formView);
        this.setPageParam("PANEL", this.formView);
        return true;
    }

    @Override
    protected void PreparePageModel() {
        super.PreparePageModel();
        this.formViewModel = (FormViewModel)this.pageModel;
    }

    @Override
    protected void PreparePageParam() {
        BaseDataEntity pageParam;
        super.PreparePageParam();
        if (this.page != null && (pageParam = this.page.getAdvPageParam("PAGE", "PPFORMVIEW")) != null && pageParam instanceof PPFormView) {
            this.ppFormView = (PPFormView)pageParam;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    protected boolean OnGetDefaultWFFormView() {
        try {
            IDEFHelper iDEFHelper;
            if (this.IsBackEndMode()) {
                return false;
            }
            if (StringHelper.Compare((String)this.getWebContext().GetParamValue("SRFWFMODE"), (String)"TRUE", (boolean)true) != 0) {
                return false;
            }
            DEWF dewf = this.getDEHelper().GetDEWF();
            if (dewf == null) {
                this.PageLog(this, 1, StringHelper.Format((String)"\u4f20\u5165\u5b9e\u4f53\u5bf9\u8c61\u4e0d\u652f\u6301\u5de5\u4f5c\u6d41"));
                return false;
            }
            BaseDataEntity activeDataEntity = null;
            try {
                activeDataEntity = this.getActiveData();
                if (activeDataEntity == null) {
                    this.PageLog(this, 1, StringHelper.Format((String)"\u5f53\u524d\u6ca1\u6709\u4f20\u5165\u6570\u636e"));
                    return false;
                }
            }
            catch (Exception ex) {
                this.PageLog(this, 1, StringHelper.Format((String)"\u83b7\u53d6\u5f53\u524d\u4f20\u5165\u6570\u636e\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()));
                return false;
            }
            String strWFStateColumnName = dewf.getWFSTATEDEFID();
            if (!StringHelper.IsNullOrEmpty((String)strWFStateColumnName)) {
                iDEFHelper = this.getDEHelper().GetDEFHelper(strWFStateColumnName);
                strWFStateColumnName = iDEFHelper != null ? iDEFHelper.getName() : "";
            }
            this.strWFStepColumnName = dewf.getWFSTEPDEFID();
            if (!StringHelper.IsNullOrEmpty((String)this.strWFStepColumnName)) {
                iDEFHelper = this.getDEHelper().GetDEFHelper(this.strWFStepColumnName);
                this.strWFStepColumnName = iDEFHelper != null ? iDEFHelper.getName() : "";
            }
            String strWFState = SRFWFStates.ToString((int)activeDataEntity.GetParamIntValue(strWFStateColumnName, 0));
            String strWFStep = activeDataEntity.GetParamStringValue(this.strWFStepColumnName, "");
            if (StringHelper.IsNullOrEmpty((String)strWFState)) {
                this.PageLog(this, 1, StringHelper.Format((String)"\u4f20\u5165\u6570\u636e\u5de5\u4f5c\u6d41\u72b6\u6001\u503c\u65e0\u6548"));
                this.OutputScript("alert('\u4f20\u5165\u6570\u636e\u5de5\u4f5c\u6d41\u72b6\u6001\u503c\u65e0\u6548');");
                return false;
            }
            if (StringHelper.IsNullOrEmpty((String)strWFStep)) {
                this.PageLog(this, 1, StringHelper.Format((String)"\u4f20\u5165\u6570\u636e\u5de5\u4f5c\u6d41\u72b6\u6001\u503c\u65e0\u6548"));
                this.OutputScript("alert('\u4f20\u5165\u6570\u636e\u5de5\u4f5c\u6d41\u72b6\u6001\u503c\u65e0\u6548');");
                return false;
            }
            if (this.iDESubWFHelper != null) {
                this.strSubWFStepColumnName = "";
                IDEFHelper iDEFHelper2 = this.iDESubWFHelper.getWFStepField();
                if (iDEFHelper2 != null) {
                    this.strSubWFStepColumnName = iDEFHelper2.getName();
                }
                this.strSubWFStep = activeDataEntity.GetParamStringValue(this.strSubWFStepColumnName, "");
                if (StringHelper.IsNullOrEmpty((String)this.strSubWFStep)) {
                    this.PageLog(this, 1, StringHelper.Format((String)"\u4f20\u5165\u6570\u636e\u5b50\u6d41\u7a0b\u72b6\u6001\u503c\u65e0\u6548"));
                    this.OutputScript("alert('\u4f20\u5165\u6570\u636e\u5b50\u6d41\u7a0b\u72b6\u6001\u503c\u65e0\u6548');");
                    return false;
                }
                this.getWebContext().SetParamValue("SRFWFSUBSTEP", this.strSubWFStep);
            }
            this.formView = new Form();
            String strWFFormName = this.getDEHelper().GetDEWFFormName(this.getWebContext().getSRFWFMode(), strWFStep, this.iDESubWFHelper, this.strSubWFStep);
            CallResult callResult = this.getDAModelHelper().GetDEWFForm(this.strPageDataEntityId, strWFFormName, this.formView);
            if (callResult.getRetCode() == 0) {
                return true;
            }
            if (callResult.getRetCode() != 3) {
                this.PageLog(this, "\u83b7\u53d6\u5b9e\u4f53\u5de5\u4f5c\u6d41\u89c6\u56fe\u5931\u8d25", callResult);
                return false;
            }
            strWFFormName = "DEFAULT";
            callResult = this.getDAModelHelper().GetDEWFForm(this.strPageDataEntityId, strWFFormName, this.formView);
            if (callResult.getRetCode() == 0) return true;
            this.formView = null;
            if (callResult.getRetCode() != 3) {
                this.PageLog(this, "\u83b7\u53d6\u5b9e\u4f53\u5de5\u4f5c\u6d41\u89c6\u56fe\u5931\u8d25", callResult);
                return false;
            }
            return false;
        }
        catch (Exception ex) {
            this.PageLog(this, 1, StringHelper.Format((String)"\u83b7\u53d6\u5b9e\u4f53\u6d41\u7a0b\u8868\u5355\u540d\u79f0\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), ex);
            return false;
        }
    }

    protected void OnInitComponents() {
        super.OnInitComponents();
        this.LoadDPEx();
    }

    protected void OnInitBackEnd() {
        super.OnInitBackEnd();
        this.RegisterFormActionHelper(this.getDefaultFormId(), this.GetFormActionHelper());
    }

    @Override
    protected String GetFormActionHelper() {
        String strFormActionHelper = this.getPageParam("PAGE.FORMACTIONHELPER", "");
        if (!StringHelper.IsNullOrEmpty((String)strFormActionHelper)) {
            return strFormActionHelper;
        }
        strFormActionHelper = this.formView.getBACKENDCTRL();
        if (this.getDEHelper().IsEnableWF()) {
            if (StringHelper.Compare((String)this.getWebContext().GetParamValue("SRFWFMODE"), (String)"TRUE", (boolean)true) == 0) {
                String strWFStep;
                if (!StringHelper.IsNullOrEmpty((String)this.formView.getWFBACKENDCTRL())) {
                    strFormActionHelper = this.formView.getWFBACKENDCTRL();
                }
                if (!StringHelper.IsNullOrEmpty((String)strFormActionHelper)) {
                    return strFormActionHelper;
                }
                if (StringHelper.Compare((String)this.getWebContext().GetParamValue("SRFWFUPDATE"), (String)"TRUE", (boolean)true) == 0) {
                    this.setPageParam("ENABLEUPDATE", true);
                }
                if (!StringHelper.IsNullOrEmpty((String)(strWFStep = this.getWebContext().GetParamValue("SRFWFSTEP"))) && this.getDEHelper().GetDEWF() != null) {
                    boolean bSaveAsIAAction = false;
                    bSaveAsIAAction = this.iDESubWFHelper != null ? PropertiesHelper.GetProperty((Properties)this.iDESubWFHelper.getParams(), (String)"WFINFOPAGE.SAVEASIAACTION", (boolean)bSaveAsIAAction) : PropertiesHelper.GetProperty((Properties)this.iDEWFHelper.getParams(), (String)"WFINFOPAGE.SAVEASIAACTION", (boolean)bSaveAsIAAction);
                    if (bSaveAsIAAction) {
                        return this.getWebContext().getWebExConfig().GetValue("SRFDA", "WFIAFORMACTIONHELPEREX", "SA.SRFDA.WF.Ctrl.Form.WFIAActionFormActionHelper2");
                    }
                }
                return this.getWebContext().getWebExConfig().GetValue("SRFDA", "WFINFOFORMACTIONHELPER", "");
            }
            if (!StringHelper.IsNullOrEmpty((String)strFormActionHelper)) {
                return strFormActionHelper;
            }
            return this.getWebContext().getWebExConfig().GetValue("SRFDA", "WFFORMACTIONHELPER", "");
        }
        if (!StringHelper.IsNullOrEmpty((String)strFormActionHelper)) {
            return strFormActionHelper;
        }
        return this.getWebContext().getWebExConfig().GetValue("SRFDA", "FORMACTIONHELPER", "");
    }

    @Override
    protected void OnInit() {
        super.OnInit();
        SRFExForm form = (SRFExForm)this.getDefaultForm();
        if (this.isJSCache()) {
            this.RegisterUncacheOnReadyScript(1, StringHelper.Format((String)"%1$s._URL='%2$s';\r\n", (Object)form.getFormId(), (Object)this.getDefaultBackEndUrl()));
        }
    }

    protected void LoadDPEx() {
        this.strDPConfigId = this.OnGetDPConfigId();
        this.panel = FormViewPage.CreateDPEx((SRFDAPage)this, "Panel", true, this.strDPConfigId);
        if (this.panel != null) {
            this.panel.getDPConfig().setWidth(600);
        }
        SRFExForm form = (SRFExForm)this.getDefaultForm();
        form.getLoadAction().setLoadDefault(true);
        form.setEnableItemPrivilege(this.OnGetFormItemPrivilege());
        if (this.formViewModel != null) {
            DPExModel dpExModel = this.formViewModel.getDPExModel();
            dpExModel.setConfigId(this.strDPConfigId);
            dpExModel.setRemoteCtrlId(this.panel.getUniqueID());
            FormModel formModel = this.formViewModel.getFormModel();
            formModel.setRemoteCtrlId(form.getFormId());
            formModel.setItemPrivilege(this.OnGetFormItemPrivilege());
        }
        if (!this.IsBackEndMode()) {
            boolean bSaveAsIAAction;
            String strWFStep = this.getWebContext().GetParamValue("SRFWFSTEP");
            if (!StringHelper.IsNullOrEmpty((String)strWFStep) && this.getDEHelper().GetDEWF() != null && (bSaveAsIAAction = this.iDEHelper.GetDEWF().GetWFParam("WFINFOPAGE.SAVEASIAACTION", false))) {
                this.ReConfigWFStepItem();
            }
            StringBuilderEx script = new StringBuilderEx();
            script.Reset();
            script.Append("var tb=$P.tabview['%3$s']._TAB;var A=tb.getInnerWidth();$P.tabpanel['%2$s'].setWidth(A-20);var B=tb.getInnerHeight();var C=Ext.getDom('DIV_%4$s');C.style.width=A;C.style.height=B;tb.on('resize',function(_1,adjWidth,adjHeight,_4,_5){if(_4==undefined){_4=_1.getWidth();}if(_4==undefined)return;$P.tabpanel['%2$s'].setWidth(_4-20);if(_5==undefined){_5=_1.getHeight();}if(_5==undefined)return;var A=Ext.getDom('DIV_%4$s');A.style.width=_4;A.style.height=_5;}); ", (Object)this.getWebContext().getTabViewPageId(), (Object)this.panel.getUniqueID(), (Object)this.getWebContext().getTabViewId(), (Object)this.getID());
            this.RegisterOnReadyScript(3, script.toString());
            script.Reset();
            script.Append("$P.setmainform(%1$s);", (Object)form.getFormId());
            script.Append("if($P.object['TABVIEWBAR']){$P.object['TABVIEWBAR'].setform('%1$s');}", (Object)form.getFormId());
            if (!StringHelper.IsNullOrEmpty((String)this.getWebContext().getTabViewId())) {
                script.Append("$P.mainform.newdata=function(){%1$s};", (Object)TabViewJSHelper.getSetDataExScript((String)this.getWebContext().getTabViewId(), (String)"{}"));
            } else {
                script.Append("$P.mainform.newdata=function(){%1$s.loaddefault();};", (Object)form.getFormId());
            }
            this.RegisterOnReadyScript(3, script.toString());
            script.Reset();
            script.Append("SRFUtility.refreshpdg();");
            String strCloseScript = "window.close();";
            if (StringHelper.Compare((String)this.getWebContext().getWebExConfig().GetValue("SRFDA", "POPUPMODE", "WINDOW"), (String)"INLINE", (boolean)true) == 0) {
                strCloseScript = "SRFUtility.closeTab();";
            }
            script.Append("if($V(%1$s.saveandclose,false)){%2$s return;}", (Object)form.getFormId(), (Object)strCloseScript);
            script.Append("if($V(%1$s.saveandnew,false)){%2$s return;}", (Object)form.getFormId(), (Object)TabViewJSHelper.getSetDataExScript((String)this.getWebContext().getTabViewId(), (String)"{}"));
            form.getSaveAction().getSuccessAction().RegisterProcessCode(0, script.toString());
            TabView2FormJSGear.Load(this, form, this.getWebContext().getTabViewId(), this.getWebContext().getTabViewPageId());
            if (!StringHelper.IsNullOrEmpty((String)this.getWebContext().getTabViewId())) {
                form.getSaveAction().getSuccessAction().RegisterProcessCode(0, TabViewJSHelper.getSetDataScript((String)this.getWebContext().getTabViewId(), (String)FormJSHelper.getFormGetKeysScript((SRFExForm)form)));
                script.Reset();
                script.Append("if($V(_JO.copymode,false)){%1$s}", (Object)TabViewJSHelper.getSetDataScript((String)this.getWebContext().getTabViewId(), (String)"{_COPYMODE:true}"));
                form.getLoadAction().getSuccessAction().RegisterProcessCode(0, script.toString());
            }
        }
    }

    public String RenderPanel() {
        String strOutput = "";
        if (this.panel != null) {
            strOutput = String.valueOf(strOutput) + PageRender.RenderLoadingIndicator(String.valueOf(this.getDefaultFormId()) + "_indicator");
            strOutput = String.valueOf(strOutput) + this.Render("panel");
        }
        return strOutput;
    }

    protected void ReConfigWFStepItem() {
        if (StringHelper.IsNullOrEmpty((String)this.strWFStepColumnName)) {
            return;
        }
        SRFExControl wfstepControl = this.panel.FindControl(this.strWFStepColumnName);
        if (wfstepControl == null || !(wfstepControl instanceof SRFExDropDownList)) {
            this.getPage().PageLog((Object)this, 4, StringHelper.Format((String)"\u83b7\u53d6\u5de5\u4f5c\u6d41\u6b65\u9aa4\u8868\u5355\u9879\u5931\u8d25\uff0c\u8868\u5355\u9879[%1$s]\u4e3a\u7a7a\u6216\u8005\u7c7b\u578b\u9519\u8bef\uff01", (Object)this.strWFStepColumnName));
            return;
        }
        String strWFStep = this.getWebContext().GetParamValue("SRFWFSTEP");
        WFGetIAActionsResult wfGetIAActionsResult = null;
        if (StringHelper.IsNullOrEmpty((String)strWFStep)) {
            this.panel.RemoveControl(wfstepControl);
            return;
        }
        WFClientAPI wfClientAPI = new WFClientAPI();
        String strWFWSUrl = this.getWebContext().getWebExConfig().GetValue("SRFDA", "WFWSURL", "");
        CallResult callResult = wfClientAPI.Init(strWFWSUrl, true);
        if (callResult == null || callResult.getRetCode() != 0) {
            this.getPage().PageLog((Object)this, 1, StringHelper.Format((String)"\u521d\u59cb\u5316\u5de5\u4f5c\u6d41WS\u94fe\u63a5\u5931\u8d25\uff0c%1$s", (Object)callResult.getErrorInfo()));
            return;
        }
        String strWFId = this.getDEHelper().GetDEWFId(this.getWebContext().getSRFWFMode());
        wfGetIAActionsResult = wfClientAPI.GetIAActions(strWFId, this.getWebContext().getCurUserId(), "", strWFStep, "", "", "", "");
        if (wfGetIAActionsResult == null || wfGetIAActionsResult.getRetCode() != 0) {
            this.getPage().PageLog((Object)this, 1, StringHelper.Format((String)"\u83b7\u53d6\u5de5\u4f5c\u6d41\u4ea4\u4e92\u6b65\u9aa4\u5931\u8d25\uff0c%1$s", (Object)wfGetIAActionsResult.getErrorInfo()));
            return;
        }
        TreeMap<String, ListItem> codeListMap = new TreeMap<String, ListItem>();
        SRFExDropDownList wfstepDropDownList = (SRFExDropDownList)wfstepControl;
        int i = 0;
        while (i < wfstepDropDownList.getDropDownListConfig().getListItems().size()) {
            ListItem tempItem = wfstepDropDownList.getDropDownListConfig().getListItems().Get(i);
            codeListMap.put(tempItem.getValue(), tempItem);
            ++i;
        }
        wfstepDropDownList.getDropDownListConfig().getListItems().Clear();
        if (codeListMap.containsKey(strWFStep)) {
            wfstepDropDownList.getDropDownListConfig().getListItems().Add((ListItem)codeListMap.get(strWFStep));
        }
        this.getWebContext().SetParamValue("WFPROCESSNAME", wfGetIAActionsResult.getProcessName());
        for (WFInteractiveActionConfig iaActionConfig : wfGetIAActionsResult.getIAActionList()) {
            if (!codeListMap.containsKey(iaActionConfig.getName())) continue;
            ListItem listItem = (ListItem)codeListMap.get(iaActionConfig.getName());
            listItem.setValue(StringHelper.Format((String)"%1$s", (Object)iaActionConfig.getName()));
            wfstepDropDownList.getDropDownListConfig().getListItems().Add(listItem);
        }
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

    @Override
    protected PageModel CreatePageModel() {
        return new FormViewModel();
    }
}

