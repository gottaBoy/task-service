/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.DEFHelper.IDEFHelper
 *  SA.SRFDA.Ctrl.DEFHelper.ILinkDEFHelper
 *  SA.SRFDA.Ctrl.Data.DER1N
 *  SA.SRFDA.Ctrl.Data.DERINDEX
 *  SA.SRFDA.Ctrl.Data.Form
 *  SA.SRFDA.Ctrl.IDEHelper
 *  SA.SRFDA.Web.ISRFDAWebContext
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.BaseDataEntityEx
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  SA.SRFramework.WebEx.DP.SRFExDPEx
 *  SA.SRFramework.WebEx.Form.SRFExForm
 *  SA.SRFramework.WebEx.SRFExControl
 *  SA.SRFramework.WebEx.SRFExTabView
 *  SA.SRFramework.WebEx.Script.FormJSHelper
 *  SA.SRFramework.WebEx.Script.TabViewJSHelper
 *  SA.SRFramework.WebEx.ToolBar.SRFExToolbar
 *  SA.SRFramework.WebEx.UI.TabViewPageConfig
 *  SA.SRFramework.WebEx.Utility.URLHelper
 */
package SA.SRFDA.Web.Default;

import SA.SRFDA.Ctrl.DEFHelper.IDEFHelper;
import SA.SRFDA.Ctrl.DEFHelper.ILinkDEFHelper;
import SA.SRFDA.Ctrl.Data.DER1N;
import SA.SRFDA.Ctrl.Data.DERINDEX;
import SA.SRFDA.Ctrl.Data.Form;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Web.Default.BaseMainPage;
import SA.SRFDA.Web.Default.PageRender;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFDA.Web.JSGear.DataNavBarJSGear;
import SA.SRFDA.Web.JSGear.FormModifyAlertJSGear;
import SA.SRFDA.Web.SRFDAPage;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.BaseDataEntityEx;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.WebEx.DP.SRFExDPEx;
import SA.SRFramework.WebEx.Form.SRFExForm;
import SA.SRFramework.WebEx.SRFExControl;
import SA.SRFramework.WebEx.SRFExTabView;
import SA.SRFramework.WebEx.Script.FormJSHelper;
import SA.SRFramework.WebEx.Script.TabViewJSHelper;
import SA.SRFramework.WebEx.ToolBar.SRFExToolbar;
import SA.SRFramework.WebEx.UI.TabViewPageConfig;
import SA.SRFramework.WebEx.Utility.URLHelper;
import java.util.ArrayList;
import java.util.Vector;

public class MultiEditViewPage
extends BaseMainPage {
    protected SRFExToolbar toolbar = null;
    protected SRFExTabView tabView = null;
    protected SRFExDPEx panel = null;
    protected Form formView = null;
    protected String strFormViewId = "";
    protected boolean bSimpleMode = false;

    public void setSimpleMode(boolean bSimpleMode) {
        this.bSimpleMode = bSimpleMode;
    }

    public boolean isSimpleMode() {
        return this.bSimpleMode;
    }

    @Override
    protected boolean PreparePageEnv() {
        if (!super.PreparePageEnv()) {
            return false;
        }
        this.strPageDataEntityId = this.getWebContext().getSRFDEID();
        this.strFormViewId = this.getWebContext().getSRFFormView();
        if (StringHelper.IsNullOrEmpty((String)this.strFormViewId)) {
            this.strFormViewId = this.getPageParam("PAGE.FORM", "");
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
        } else {
            if (!this.LoadPageDataEntity()) {
                return false;
            }
            if (this.getDEHelper().IsIndexDE()) {
                String strIndexDEId = this.getWebContext().getSRFDEID();
                IDEHelper indexDEHelper = this.getDEHelper();
                String strIndexType = "";
                BaseDataEntityEx obj = new BaseDataEntityEx();
                obj.SetParamValue(indexDEHelper.GetKeyDEFHelper().getName(), (Object)this.getWebContext().GetParamValue(indexDEHelper.GetKeyDEFHelper().getName()));
                CallResult callResult = indexDEHelper.GetDEDataCtrl(this.getWebContext().getCurUserId(), (ISRFDAWebContext)this.getWebContext()).Get((BaseDataEntity)obj);
                if (callResult.getRetCode() == 0) {
                    strIndexType = obj.GetParamStringValue(indexDEHelper.GetIndexTypeDEFHelper().getName(), "");
                }
                Vector list = indexDEHelper.GetDERINDEXs(true);
                for (DERINDEX dERINDEX : list) {
                    if (StringHelper.Compare((String)dERINDEX.getTYPEVALUE(), (String)strIndexType, (boolean)true) != 0) continue;
                    this.strPageDataEntityId = dERINDEX.getDEID();
                    this.iDEHelper = null;
                    if (!this.LoadPageDataEntity()) {
                        return false;
                    }
                    this.getWebContext().SetParamValue("SRFDEID", this.strPageDataEntityId);
                    this.getWebContext().SetParamValue(this.getDEHelper().GetKeyDEFHelper().getName(), this.getWebContext().GetParamValue(indexDEHelper.GetKeyDEFHelper().getName()));
                    break;
                }
            }
            this.formView = this.getWebContext().GetConfigCache().GetDefaultDEMainForm(this.getWebContext(), this.strPageDataEntityId);
            if (this.formView == null) {
                return false;
            }
            this.getWebContext().SetParamValue("SRFFORMVIEW", this.formView.getFORMID());
        }
        this.setPageParam("FORMVIEW", this.formView);
        return true;
    }

    protected void OnInitComponents() {
        super.OnInitComponents();
        this.LoadToolbar();
        if (!this.bSimpleMode) {
            this.LoadTabView();
        }
        this.LoadDPEx();
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
        return this.GetDefaultFormActionHelper();
    }

    protected String GetDefaultFormActionHelper() {
        if (this.getDEHelper().IsEnableWF()) {
            return this.getWebContext().getWebExConfig().GetValue("SRFDA", "WFFORMACTIONHELPER", "");
        }
        return this.getWebContext().getWebExConfig().GetValue("SRFDA", "FORMACTIONHELPER", "");
    }

    protected void LoadDPEx() {
        String strDPConfigId = this.getDAConfigHelper().GetEditViewDPId(this.getDEHelper(), this.formView);
        this.panel = MultiEditViewPage.CreateDPEx((SRFDAPage)this, "Panel", true, strDPConfigId);
        if (this.panel != null) {
            this.panel.getDPConfig().setWidth(600);
            if (this.bSimpleMode) {
                this.panel.getDPConfig().setSimpleMode(this.bSimpleMode);
            }
        }
        SRFExForm form = (SRFExForm)this.getDefaultForm();
        form.getLoadAction().setLoadDefault(true);
        form.setEnableItemPrivilege(this.OnGetFormItemPrivilege());
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
            if (StringHelper.IsNullOrEmpty((String)strParamValue)) {
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
                    script.Append("%1$s", (Object)FormJSHelper.getLoadDefaultScript((SRFExForm)form));
                } else {
                    script.Append("%1$s", (Object)FormJSHelper.getLoad2Script((SRFExForm)form, (String)("'" + strParamValue + "'" + ",false")));
                }
            }
            this.RegisterOnReadyScript(5, script.toString());
            script.Reset();
            IDEFHelper keyDEFHelper = this.getDEHelper().GetKeyDEFHelper();
            SRFExControl keyControl = form.FindControl(keyDEFHelper.getName());
            if (keyControl == null) {
                script.Append("alert('\u8868\u5355\u6ca1\u6709\u4efb\u4f55\u4e3b\u952e\uff0c\u5904\u7406\u505c\u6b62!');");
            } else {
                script.Append("var keys='';if(dialogArguments){keys=dialogArguments.toString();}", (Object)form.getFormId(), (Object)keyControl.getUniqueID());
                script.Append("if(keys=='')return;%1$s.S('%2$s',keys);%1$s.load();", (Object)form.getFormId(), (Object)keyControl.getUniqueID());
            }
            this.RegisterOnReadyScript(6, script.toString());
        }
    }

    @Override
    protected void OnInit() {
        super.OnInit();
        FormModifyAlertJSGear.Load(this);
        IDEFHelper keyDEFHelper = this.getDEHelper().GetKeyDEFHelper();
        SRFExForm form = (SRFExForm)this.getDefaultForm();
        DataNavBarJSGear.Load(this, null, form, keyDEFHelper.getName());
    }

    protected void LoadToolbar() {
        String strToolbarConfigId = "SRFWF.TB_WFIAACTIONDIALOG";
        this.toolbar = MultiEditViewPage.CreateToolbar(this, "toolBar", 0.0, 0.0, strToolbarConfigId);
    }

    protected void LoadTabView() {
        String strTabViewId = this.getDAConfigHelper().GetEditViewTabViewConfigId(this.getDEHelper(), this.page);
        if (StringHelper.IsNullOrEmpty((String)strTabViewId)) {
            return;
        }
        this.tabView = MultiEditViewPage.CreateTabView((SRFDAPage)this, "TabView", 600.0, 0.0, strTabViewId);
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
            strOutput = String.valueOf(strOutput) + PageRender.RenderLoadingIndicator(String.valueOf(this.getDefaultFormId()) + "_indicator");
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

    protected boolean OnGetFormItemPrivilege() {
        return this.getPageParam("PAGE.FORM.ITEMPRIVILEGE", this.getDEHelper().IsEnableDEFieldPriv());
    }
}

