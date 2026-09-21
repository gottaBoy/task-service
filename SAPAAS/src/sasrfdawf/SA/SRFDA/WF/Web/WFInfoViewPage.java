/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.DEFHelper.IDEFHelper
 *  SA.SRFDA.Ctrl.DEFHelper.ILinkDEFHelper
 *  SA.SRFDA.Ctrl.Data.DERINDEX
 *  SA.SRFDA.Ctrl.Data.DataGrid
 *  SA.SRFDA.Ctrl.Data.Form
 *  SA.SRFDA.Ctrl.IDEHelper
 *  SA.SRFDA.Ctrl.IDESubWFHelper
 *  SA.SRFDA.Ctrl.IDEWFHelper
 *  SA.SRFDA.Web.Default.BaseEditViewPage2
 *  SA.SRFDA.Web.Default.PageRender
 *  SA.SRFDA.Web.ISRFDAWebContext
 *  SA.SRFDA.Web.JSGear.FormModifyAlertJSGear
 *  SA.SRFDA.Web.SRFDAPage
 *  SA.SRFDA.Web.SRFDAWebCTXHelper
 *  SA.SRFDA.Web.ViewModel.DPExModel
 *  SA.SRFDA.Web.ViewModel.FormModel
 *  SA.SRFDA.Web.ViewModel.TabViewModel
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.BaseDataEntityEx
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.PropertiesHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  SA.SRFramework.Web.ListItem
 *  SA.SRFramework.WebEx.Form.SRFExForm
 *  SA.SRFramework.WebEx.SRFExControl
 *  SA.SRFramework.WebEx.SRFExDataGrid
 *  SA.SRFramework.WebEx.SRFExDropDownList
 *  SA.SRFramework.WebEx.Script.FormJSHelper
 *  SA.SRFramework.WebEx.Script.TabViewJSHelper
 *  SRFWF.Client.WFClientAPI
 *  SRFWF.Client.WFGetIAActionsResult
 *  SRFWF.Ctrl.SRFWFStates
 *  SRFWF.Model.WFInteractiveActionConfig
 */
package SA.SRFDA.WF.Web;

import SA.SRFDA.Ctrl.DEFHelper.IDEFHelper;
import SA.SRFDA.Ctrl.DEFHelper.ILinkDEFHelper;
import SA.SRFDA.Ctrl.Data.DERINDEX;
import SA.SRFDA.Ctrl.Data.DataGrid;
import SA.SRFDA.Ctrl.Data.Form;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Ctrl.IDESubWFHelper;
import SA.SRFDA.Ctrl.IDEWFHelper;
import SA.SRFDA.WF.Ctrl.DataGrid.WFStepDataDGActionHelper;
import SA.SRFDA.Web.Default.BaseEditViewPage2;
import SA.SRFDA.Web.Default.PageRender;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFDA.Web.JSGear.FormModifyAlertJSGear;
import SA.SRFDA.Web.SRFDAPage;
import SA.SRFDA.Web.SRFDAWebCTXHelper;
import SA.SRFDA.Web.ViewModel.DPExModel;
import SA.SRFDA.Web.ViewModel.FormModel;
import SA.SRFDA.Web.ViewModel.TabViewModel;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.BaseDataEntityEx;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.PropertiesHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.Web.ListItem;
import SA.SRFramework.WebEx.Form.SRFExForm;
import SA.SRFramework.WebEx.SRFExControl;
import SA.SRFramework.WebEx.SRFExDataGrid;
import SA.SRFramework.WebEx.SRFExDropDownList;
import SA.SRFramework.WebEx.Script.FormJSHelper;
import SA.SRFramework.WebEx.Script.TabViewJSHelper;
import SRFWF.Client.WFClientAPI;
import SRFWF.Client.WFGetIAActionsResult;
import SRFWF.Ctrl.SRFWFStates;
import SRFWF.Model.WFInteractiveActionConfig;
import java.util.ArrayList;
import java.util.Properties;
import java.util.TreeMap;

public class WFInfoViewPage
extends BaseEditViewPage2 {
    protected String strWFState = "";
    protected String strWFStep = "";
    protected IDEWFHelper iDEWFHelper = null;
    protected IDESubWFHelper iDESubWFHelper = null;
    protected String strPrintFormContent = "";
    protected SRFExDataGrid dataGrid = null;
    protected String strKeyParamValue = "";
    protected boolean bEnableUpdate = false;
    private String strWFStepColumnName = "";
    private String strSubWFStepColumnName = "";
    protected String strDESubWFId = "";
    protected String strSubWFStep = "";

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    protected boolean PreparePageEnv() {
        if (!super.PreparePageEnv()) {
            return false;
        }
        this.strPageDataEntityId = this.getWebContext().getSRFDEID();
        if (!this.LoadPageDataEntity()) {
            return false;
        }
        if (!this.ProcessDEIndexMode()) {
            return false;
        }
        try {
            String strFormView;
            this.iDEWFHelper = this.getDEHelper().GetDEWFHelper();
            this.strDESubWFId = SRFDAWebCTXHelper.GetDESubWFId((ISRFDAWebContext)this.getWebContext());
            if (!StringHelper.IsNullOrEmpty((String)this.strDESubWFId)) {
                this.iDESubWFHelper = this.getDEHelper().GetDESubWFHelper(this.strDESubWFId);
                this.strSubWFStep = SRFDAWebCTXHelper.GetWFSubStep((ISRFDAWebContext)this.getWebContext());
            }
            this.bEnableWFMainState = this.OnGetEnableWFMainState();
            BaseDataEntity activeDataEntity = this.getActiveData();
            String strKeyData = activeDataEntity.GetParamStringValue(this.getDEHelper().GetKeyDEFHelper().getName(), "");
            String strWFStateColumnName = "";
            IDEFHelper iDEFHelper = this.iDEWFHelper.getWFStateField();
            if (iDEFHelper != null) {
                strWFStateColumnName = iDEFHelper.getName();
            }
            this.strWFStepColumnName = "";
            iDEFHelper = this.iDEWFHelper.getWFStepField();
            if (iDEFHelper != null) {
                this.strWFStepColumnName = iDEFHelper.getName();
            }
            this.strWFState = SRFWFStates.ToString((int)activeDataEntity.GetParamIntValue(strWFStateColumnName, 0));
            this.strWFStep = activeDataEntity.GetParamStringValue(this.strWFStepColumnName, "");
            if (StringHelper.IsNullOrEmpty((String)this.strWFState)) {
                this.PageLog((Object)this, 1, StringHelper.Format((String)"\u4f20\u5165\u6570\u636e\u5de5\u4f5c\u6d41\u72b6\u6001\u503c\u65e0\u6548"));
                this.OutputScript("alert('\u4f20\u5165\u6570\u636e\u5de5\u4f5c\u6d41\u72b6\u6001\u503c\u65e0\u6548');");
                return false;
            }
            if (StringHelper.IsNullOrEmpty((String)this.strWFStep)) {
                this.PageLog((Object)this, 1, StringHelper.Format((String)"\u4f20\u5165\u6570\u636e\u5de5\u4f5c\u6d41\u72b6\u6001\u503c\u65e0\u6548"));
                this.OutputScript("alert('\u4f20\u5165\u6570\u636e\u5de5\u4f5c\u6d41\u72b6\u6001\u503c\u65e0\u6548');");
                return false;
            }
            this.getWebContext().SetParamValue("SRFWFSTEP", this.strWFStep);
            if (this.iDESubWFHelper != null) {
                this.strSubWFStepColumnName = "";
                iDEFHelper = this.iDESubWFHelper.getWFStepField();
                if (iDEFHelper != null) {
                    this.strSubWFStepColumnName = iDEFHelper.getName();
                }
                this.strSubWFStep = activeDataEntity.GetParamStringValue(this.strSubWFStepColumnName, "");
                if (StringHelper.IsNullOrEmpty((String)this.strSubWFStep)) {
                    this.PageLog((Object)this, 1, StringHelper.Format((String)"\u4f20\u5165\u6570\u636e\u5b50\u6d41\u7a0b\u72b6\u6001\u503c\u65e0\u6548"));
                    this.OutputScript("alert('\u4f20\u5165\u6570\u636e\u5b50\u6d41\u7a0b\u72b6\u6001\u503c\u65e0\u6548');");
                    return false;
                }
                this.getWebContext().SetParamValue("SRFWFSUBSTEP", this.strSubWFStep);
            }
            if (this.iDESubWFHelper == null) {
                if (this.iDEWFHelper.isWFStepEditable(this.strWFStep)) {
                    this.bEnableUpdate = true;
                }
            } else if (this.iDESubWFHelper.isWFStepEditable(this.strSubWFStep)) {
                this.bEnableUpdate = true;
            }
            if (StringHelper.IsNullOrEmpty((String)(strFormView = this.getWebContext().getSRFFormView())) && this.ppEditForm != null) {
                strFormView = this.ppEditForm.getFORMID();
            }
            if (StringHelper.IsNullOrEmpty((String)strFormView)) {
                String strWFFormName = this.getDEHelper().GetDEWFFormName(this.getWebContext().getSRFWFMode(), this.strWFStep, this.iDESubWFHelper, this.strSubWFStep);
                this.formView = new Form();
                CallResult callResult = this.getDAModelHelper().GetDEWFForm(this.strPageDataEntityId, strWFFormName, this.formView);
                if (callResult.getRetCode() != 0) {
                    if (callResult.getRetCode() != 3) {
                        this.PageLog((Object)this, "\u83b7\u53d6\u5b9e\u4f53\u5de5\u4f5c\u6d41\u89c6\u56fe\u5931\u8d25", callResult);
                        return false;
                    }
                    strFormView = this.ProcessMultiFormMode();
                    this.formView = !StringHelper.IsNullOrEmpty((String)strFormView) ? this.getWebContext().GetConfigCache().GetUserDEForm(this.getWebContext(), strFormView) : null;
                    if (this.formView == null) {
                        strWFFormName = "DEFAULT";
                        this.formView = new Form();
                        callResult = this.getDAModelHelper().GetDEWFForm(this.strPageDataEntityId, strWFFormName, this.formView);
                        if (callResult.getRetCode() != 0) {
                            if (callResult.getRetCode() != 3) {
                                this.PageLog((Object)this, "\u83b7\u53d6\u5b9e\u4f53\u5de5\u4f5c\u6d41\u89c6\u56fe\u5931\u8d25", callResult);
                                return false;
                            }
                            this.formView = this.getWebContext().GetConfigCache().GetDefaultDEMainForm(this.getWebContext(), this.strPageDataEntityId);
                        }
                    }
                }
                this.getWebContext().SetParamValue("SRFFORMVIEW", this.formView.getFORMID());
            } else {
                this.formView = this.getWebContext().GetConfigCache().GetUserDEForm(this.getWebContext(), strFormView);
                if (this.formView == null) {
                    return false;
                }
            }
            this.setPageParam("FORMVIEW", this.formView);
            this.setPageParam("ENABLEUPDATE", this.bEnableUpdate);
            this.RegisterOnReadyScript(3, StringHelper.Format((String)"$P.keys='%1$s';", (Object)strKeyData));
            return true;
        }
        catch (Exception ex) {
            this.PageLog((Object)this, 1, StringHelper.Format((String)"\u521d\u59cb\u5316\u9875\u9762\u73af\u5883\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), ex);
            return false;
        }
    }

    protected boolean ProcessDEIndexMode() {
        if (this.getDEHelper().IsIndexDE()) {
            IDEHelper indexDEHelper = this.getDEHelper();
            String strIndexType = "";
            BaseDataEntityEx obj = new BaseDataEntityEx();
            String strParamName = indexDEHelper.GetKeyDEFHelper().getName();
            String strParamValue = this.getWebContext().GetParamValue(strParamName);
            if (StringHelper.IsNullOrEmpty((String)strParamValue)) {
                this.PageLog((Object)this, 1, StringHelper.Format((String)"\u6ca1\u6709\u6307\u5b9a\u7d22\u5f15\u5b9e\u4f53[%1$s]\u6570\u636e\u952e\u503c", (Object)this.getDEHelper().getId()));
                return false;
            }
            obj.SetParamValue(strParamName, (Object)strParamValue);
            CallResult callResult = this.GetDEDataCtrl().Get((BaseDataEntity)obj);
            if (callResult.getRetCode() != 0) {
                this.PageLog((Object)this, 1, StringHelper.Format((String)"\u67e5\u8be2\u5b9e\u4f53[%1$s]\u6570\u636e[%2$s]\u53d1\u751f\u9519\u8bef\uff0c%3$s", (Object)this.getDEHelper().getId(), (Object)strParamValue, (Object)callResult.getErrorInfo()));
                return false;
            }
            strIndexType = obj.GetParamStringValue(indexDEHelper.GetIndexTypeDEFHelper().getName(), "");
            DERINDEX derIndex = indexDEHelper.FindDERINDEX(strIndexType);
            if (derIndex != null) {
                this.strPageDataEntityId = derIndex.getDEID();
                if (!this.LoadPageDataEntity()) {
                    return false;
                }
                this.getWebContext().SetParamValue("SRFDEID", this.strPageDataEntityId);
                this.getWebContext().SetParamValue(this.getDEHelper().GetKeyDEFHelper().getName(), this.getWebContext().GetParamValue(indexDEHelper.GetKeyDEFHelper().getName()));
            } else {
                this.PageLog((Object)this, 1, StringHelper.Format((String)"\u6ca1\u6709\u627e\u5230\u7d22\u5f15\u5b9e\u4f53[%1$s]\u5173\u7cfb\u7c7b\u578b[%2$s]\u5bf9\u5e94\u5b9e\u4f53", (Object)this.getDEHelper().getId(), (Object)strIndexType));
                return false;
            }
        }
        return true;
    }

    protected void OnInitBackEnd() {
        super.OnInitBackEnd();
        if (!this.isUsePrintForm()) {
            this.RegisterFormActionHelper(this.getDefaultFormId(), this.GetFormActionHelper());
        }
        if (this.dataGrid != null) {
            this.RegisterDataGridActionHelper(this.dataGrid.getUniqueID(), WFStepDataDGActionHelper.class.getName());
        }
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
        String strWFStep = this.getWebContext().GetParamValue("SRFWFSTEP");
        if (!StringHelper.IsNullOrEmpty((String)strWFStep) && this.getDEHelper().GetDEWF() != null) {
            boolean bSaveAsIAAction = false;
            bSaveAsIAAction = this.iDESubWFHelper != null ? PropertiesHelper.GetProperty((Properties)this.iDESubWFHelper.getParams(), (String)"WFINFOPAGE.SAVEASIAACTION", (boolean)bSaveAsIAAction) : PropertiesHelper.GetProperty((Properties)this.iDEWFHelper.getParams(), (String)"WFINFOPAGE.SAVEASIAACTION", (boolean)bSaveAsIAAction);
            if (bSaveAsIAAction) {
                return this.getWebContext().getWebExConfig().GetValue("SRFDA", "WFIAFORMACTIONHELPEREX", "SA.SRFDA.WF.Ctrl.Form.WFIAActionFormActionHelper2");
            }
        }
        return this.getWebContext().getWebExConfig().GetValue("SRFDA", "WFINFOFORMACTIONHELPER", "");
    }

    protected void OnInitComponents() {
        super.OnInitComponents();
        this.LoadToolbar();
        if (!this.isSimpleMode()) {
            this.LoadTabView();
        }
        this.LoadDPEx();
    }

    protected void LoadDPEx() {
        this.strDPConfigId = this.getDAConfigHelper().GetEditViewDPId(this.getDEHelper(), this.formView);
        this.panel = WFInfoViewPage.CreateDPEx((SRFDAPage)this, (String)"Panel", (boolean)true, (String)this.strDPConfigId);
        if (this.panel != null) {
            this.panel.getDPConfig().setWidth(600);
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
            String strWFStep = this.getWebContext().GetParamValue("SRFWFSTEP");
            if (!StringHelper.IsNullOrEmpty((String)strWFStep) && this.getDEHelper().GetDEWF() != null) {
                boolean bSaveAsIAAction = false;
                bSaveAsIAAction = this.iDESubWFHelper != null ? PropertiesHelper.GetProperty((Properties)this.iDESubWFHelper.getParams(), (String)"WFINFOPAGE.SAVEASIAACTION", (boolean)bSaveAsIAAction) : PropertiesHelper.GetProperty((Properties)this.iDEWFHelper.getParams(), (String)"WFINFOPAGE.SAVEASIAACTION", (boolean)bSaveAsIAAction);
                if (bSaveAsIAAction) {
                    this.ReConfigWFStepItem();
                }
            }
            StringBuilderEx script = new StringBuilderEx();
            script.Reset();
            script.Append("$P.setmainform(%1$s);", (Object)form.getFormId());
            this.RegisterOnReadyScript(3, script.toString());
            ArrayList keyControls = form.GetKeyFormControls();
            int nCount = keyControls.size();
            if (nCount == 0) {
                script.Append("alert('\u8868\u5355\u6ca1\u6709\u4efb\u4f55\u4e3b\u952e\uff0c\u5904\u7406\u505c\u6b62!');");
            }
            String strParamName = "";
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
                    strParamName = linkDEFHelper.GetRelatedDEFHelper().getName();
                    this.strKeyParamValue = this.getWebContext().GetParamValue(strParamName);
                } else {
                    strParamName = iDEFHelper.getName();
                    this.strKeyParamValue = this.getWebContext().GetParamValue(strParamName);
                }
                ++i;
            }
            if (StringHelper.IsNullOrEmpty((String)this.strKeyParamValue)) {
                script.Append("%1$s", (Object)FormJSHelper.getResetScript((SRFExForm)form));
            } else {
                this.bContainKey = true;
                this.keyJson.put(strParamName.toLowerCase(), (Object)this.strKeyParamValue);
                script.Append("%1$s", (Object)FormJSHelper.getLoad2Script((SRFExForm)form, (String)("'" + this.strKeyParamValue + "'" + ",false")));
            }
            this.RegisterOnReadyScript(5, script.toString());
            form.getSaveAction().getSuccessAction().RegisterProcessCode(0, script.toString());
            if (this.IsOutputTabView()) {
                form.getSaveAction().getSuccessAction().RegisterProcessCode(0, TabViewJSHelper.getSetDataScript((String)this.tabView.getUniqueID(), (String)FormJSHelper.getFormGetKeysScript((SRFExForm)form)));
                script.Reset();
                script.Append("if($V(_JO.copymode,false)){%1$s}else{%2$s}", (Object)TabViewJSHelper.getSetDataScript((String)this.tabView.getUniqueID(), (String)"{_COPYMODE:true}"), (Object)TabViewJSHelper.getSetDataScript((String)this.tabView.getUniqueID(), (String)FormJSHelper.getFormGetKeysScript((SRFExForm)form)));
                form.getLoadAction().getSuccessAction().RegisterProcessCode(0, script.toString());
            }
        }
    }

    protected void OnInit() {
        super.OnInit();
        FormModifyAlertJSGear.Load((SRFDAPage)this);
    }

    public String GetPrintFormContent() {
        return this.strPrintFormContent;
    }

    protected void LoadToolbar() {
        if (!this.IsBackEndMode()) {
            this.strToolbarConfigId = this.OnGetWFInfoViewToolbarConfigId();
            if (StringHelper.IsNullOrEmpty((String)this.strToolbarConfigId)) {
                return;
            }
        }
        this.toolbar = WFInfoViewPage.CreateToolbar((SRFDAPage)this, (String)"toolBar", (double)0.0, (double)0.0, (String)this.strToolbarConfigId);
        if (this.editView2Model != null && this.editView2Model.getToolbarModel() != null) {
            this.editView2Model.getToolbarModel().setCtrlId("toolBar");
            this.editView2Model.getToolbarModel().setConfigId(this.strToolbarConfigId);
            this.editView2Model.getToolbarModel().setRemoteCtrlId(this.toolbar.getUniqueID());
        }
    }

    protected void LoadDataGrid() {
        String strStepDataGVID = "WF0005_DATAGRID_001";
        DataGrid gridView = this.getWebContext().GetConfigCache().GetUserDEDataGrid(this.getWebContext(), strStepDataGVID);
        if (gridView == null) {
            this.PageLog((Object)this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53\u89c6\u56fe[%1$s]", (Object)strStepDataGVID));
            return;
        }
        this.setPageParam("GRIDVIEW", gridView);
        IDEHelper iWFStepDataDEHelper = this.getDAModelStorage().FindDEHelper("WF0005");
        String strDataGridConfigId = this.getDAConfigHelper().GetGridViewDGConfigId(iWFStepDataDEHelper, null, gridView, this.getWebContext().getSRFDERID());
        if (StringHelper.IsNullOrEmpty((String)strDataGridConfigId)) {
            return;
        }
        this.dataGrid = WFInfoViewPage.CreateDataGrid((SRFDAPage)this, (String)"dataGrid", (double)600.0, (double)200.0, (String)strDataGridConfigId);
        if (this.dataGrid != null && !this.IsBackEndMode()) {
            this.getWebContext().SetParamValue("SRFPDEID", this.strPageDataEntityId);
            this.RegisterOnReadyScript(3, StringHelper.Format((String)"$P.maingrid=$P.grid['%1$s'];$P.store['%1$s'].loaddefault();", (Object)this.dataGrid.getUniqueID()));
        }
    }

    protected String OnGetWFInfoViewToolbarConfigId() {
        String strRealWFStep = this.strWFStep;
        WFGetIAActionsResult wfGetIAActionsResult = null;
        if (StringHelper.Compare((String)this.strWFState, (String)"WFNOTFINISH", (boolean)true) == 0 && !StringHelper.IsNullOrEmpty((String)this.strWFStep)) {
            String strUserData = "";
            String strUserData4 = "";
            try {
                BaseDataEntity dataEntity = this.getActiveData();
                if (dataEntity != null) {
                    strUserData = dataEntity.GetParamStringValue(this.getDEHelper().GetKeyDEFHelper().getName(), "");
                    strUserData4 = this.getDEHelper().getId();
                }
            }
            catch (Exception e) {
                this.PageLog((Object)this, 1, StringHelper.Format((String)"\u83b7\u53d6\u5f53\u524d\u6570\u636e\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)e.getMessage()));
            }
            WFClientAPI wfClientAPI = new WFClientAPI();
            String strWFWSUrl = this.getWebContext().getWebExConfig().GetValue("SRFDA", "WFWSURL", "");
            if (this.iDESubWFHelper == null) {
                CallResult callResult = wfClientAPI.Init(strWFWSUrl, true);
                if (callResult == null || callResult.getRetCode() != 0) {
                    this.getPage().PageLog((Object)this, 1, StringHelper.Format((String)"\u521d\u59cb\u5316\u5de5\u4f5c\u6d41WS\u94fe\u63a5\u5931\u8d25\uff0c%1$s", (Object)callResult.getErrorInfo()));
                    return "";
                }
                String strWFId = this.getDEHelper().GetDEWFId(this.getWebContext().getSRFWFMode());
                wfGetIAActionsResult = wfClientAPI.GetIAActions(strWFId, this.getWebContext().getCurUserId(), "", this.strWFStep, strUserData, "", "", strUserData4);
                if (wfGetIAActionsResult == null || wfGetIAActionsResult.getRetCode() != 0) {
                    this.getPage().PageLog((Object)this, 1, StringHelper.Format((String)"\u83b7\u53d6\u5de5\u4f5c\u6d41\u4ea4\u4e92\u6b65\u9aa4\u5931\u8d25\uff0c%1$s", (Object)wfGetIAActionsResult.getErrorInfo()));
                    return "";
                }
            } else {
                CallResult callResult = wfClientAPI.Init(strWFWSUrl, true);
                if (callResult == null || callResult.getRetCode() != 0) {
                    this.getPage().PageLog((Object)this, 1, StringHelper.Format((String)"\u521d\u59cb\u5316\u5de5\u4f5c\u6d41WS\u94fe\u63a5\u5931\u8d25\uff0c%1$s", (Object)callResult.getErrorInfo()));
                    return "";
                }
                wfGetIAActionsResult = wfClientAPI.GetIAActions(this.iDESubWFHelper.getWFId(), this.getWebContext().getCurUserId(), "", this.strSubWFStep, strUserData, "", "", strUserData4);
                if (wfGetIAActionsResult == null || wfGetIAActionsResult.getRetCode() != 0) {
                    this.getPage().PageLog((Object)this, 1, StringHelper.Format((String)"\u83b7\u53d6\u5de5\u4f5c\u6d41\u4ea4\u4e92\u6b65\u9aa4\u5931\u8d25\uff0c%1$s", (Object)wfGetIAActionsResult.getErrorInfo()));
                    return "";
                }
                strRealWFStep = "SRFWFSUBSTEP:" + this.strWFStep + ":" + this.strDESubWFId + ":" + this.strSubWFStep;
            }
        }
        return this.getDAConfigHelper().GetWFInfoViewToolbarConfigId(this.getDEHelper(), this.page, this.strWFState, strRealWFStep, this.bEnableUpdate, wfGetIAActionsResult);
    }

    public String RenderPanel() {
        String strOutput = "";
        if (this.panel != null) {
            strOutput = String.valueOf(strOutput) + PageRender.RenderLoadingIndicator((String)(String.valueOf(this.getDefaultFormId()) + "_indicator"));
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
            strOutput = String.valueOf(strOutput) + StringHelper.Format((String)"<div class=\"sx-errorpanel\" id=\"%1$s_errorindicator\" style=\"width:100%%;height:150px;display:none;\"></div>", (Object)this.getDefaultFormId());
        }
        return strOutput;
    }

    public boolean isUsePrintForm() {
        return false;
    }

    protected boolean OnGetSimpleMode() {
        String strSimpleMode = this.getPageParam("WFINFOPAGE.SIMPLEMODE", "");
        if (!StringHelper.IsNullOrEmpty((String)strSimpleMode)) {
            return StringHelper.Compare((String)strSimpleMode, (String)"TRUE", (boolean)true) == 0;
        }
        return StringHelper.Compare((String)this.getDEHelper().GetDEWF().GetWFParam("WFINFOPAGE.SIMPLEMODE", "FALSE"), (String)"TRUE", (boolean)true) == 0;
    }

    protected void LoadTabView() {
        this.strTabViewConfigId = this.getDAConfigHelper().GetWFInfoViewTabViewConfigId(this.getDEHelper(), this.page, this.bEnableUpdate);
        if (StringHelper.IsNullOrEmpty((String)this.strTabViewConfigId)) {
            return;
        }
        this.tabView = WFInfoViewPage.CreateTabView((SRFDAPage)this, (String)"TabView", (double)600.0, (double)0.0, (String)this.strTabViewConfigId);
        if (this.tabView != null) {
            this.tabView.getTabViewConfig().RemoveTabPage("EDIT");
            this.tabView.getTabViewConfig().setResizeChild(true);
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

    protected boolean OnGetEnableWFMainState() {
        boolean bEnableWFMainState;
        boolean bl = bEnableWFMainState = !StringHelper.IsNullOrEmpty((String)this.iDEWFHelper.getWFMSCodeListId());
        if (this.ppEditView != null && !this.ppEditView.isWFMAINSTATENull()) {
            bEnableWFMainState = this.ppEditView.getWFMAINSTATE();
        }
        return this.getPageParam("PAGE.WFMAINSTATE", bEnableWFMainState);
    }

    protected String OnGetPageTitle() {
        return this.GetLocalization("PAGE.HEADER.WFINFOVIEW", "\u6d41\u7a0b\u6570\u636e\u4fe1\u606f\u89c6\u56fe");
    }

    protected boolean OnGetEnableDEMainState() {
        return false;
    }
}

