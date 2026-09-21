/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.DEFHelper.IDEFHelper
 *  SA.SRFDA.Ctrl.DEFHelper.ILinkDEFHelper
 *  SA.SRFDA.Ctrl.Data.DEWF
 *  SA.SRFDA.Ctrl.Data.Form
 *  SA.SRFDA.Web.Default.BaseMainPage
 *  SA.SRFDA.Web.Default.PageRender
 *  SA.SRFDA.Web.JSGear.FormModifyAlertJSGear
 *  SA.SRFDA.Web.SRFDAPage
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  SA.SRFramework.WebEx.DP.SRFExDPEx
 *  SA.SRFramework.WebEx.Form.SRFExBaseForm
 *  SA.SRFramework.WebEx.Form.SRFExForm
 *  SA.SRFramework.WebEx.SRFExControl
 *  SA.SRFramework.WebEx.Script.FormJSHelper
 *  SA.SRFramework.WebEx.ToolBar.SRFExToolbar
 */
package SA.SRFDA.WF.Web;

import SA.SRFDA.Ctrl.DEFHelper.IDEFHelper;
import SA.SRFDA.Ctrl.DEFHelper.ILinkDEFHelper;
import SA.SRFDA.Ctrl.Data.DEWF;
import SA.SRFDA.Ctrl.Data.Form;
import SA.SRFDA.Web.Default.BaseMainPage;
import SA.SRFDA.Web.Default.PageRender;
import SA.SRFDA.Web.JSGear.FormModifyAlertJSGear;
import SA.SRFDA.Web.SRFDAPage;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.WebEx.DP.SRFExDPEx;
import SA.SRFramework.WebEx.Form.SRFExBaseForm;
import SA.SRFramework.WebEx.Form.SRFExForm;
import SA.SRFramework.WebEx.SRFExControl;
import SA.SRFramework.WebEx.Script.FormJSHelper;
import SA.SRFramework.WebEx.ToolBar.SRFExToolbar;
import java.util.ArrayList;

public class WFEditViewPage
extends BaseMainPage {
    protected SRFExToolbar toolbar = null;
    protected SRFExDPEx panel = null;
    protected Form formView = new Form();
    protected String strFormViewId = "";
    protected String strWFState = "";
    protected String strWFStep = "";
    protected DEWF deWF = null;
    protected boolean bEnableWFMainState = false;
    public static final String TAG_WFFORMNAME_DEFAULT = "DEFAULT";

    protected boolean PreparePageEnv() {
        if (!super.PreparePageEnv()) {
            return false;
        }
        this.strWFState = this.getWebContext().getSRFWFSTATE();
        this.strWFStep = this.getWebContext().getSRFWFSTEP();
        if (StringHelper.IsNullOrEmpty((String)this.strWFState)) {
            this.PageLog((Object)this, 1, StringHelper.Format((String)"\u6ca1\u6709\u6307\u5b9a\u5de5\u4f5c\u6d41\u72b6\u6001\u503c"));
            return false;
        }
        this.strPageDataEntityId = this.getWebContext().getSRFDEID();
        if (!this.LoadPageDataEntity()) {
            return false;
        }
        String strWFFORMNAME = "";
        if (StringHelper.Compare((String)this.strWFState, (String)"WFNOTSTART", (boolean)true) == 0) {
            strWFFORMNAME = TAG_WFFORMNAME_DEFAULT;
        }
        if (StringHelper.IsNullOrEmpty((String)strWFFORMNAME)) {
            this.PageLog((Object)this, 1, "\u6ca1\u6709\u6307\u5b9a\u5b9e\u4f53\u5de5\u4f5c\u6d41\u8868\u5355\u540d\u79f0");
            return false;
        }
        CallResult callResult = this.getDAModelHelper().GetDEWFForm(this.strPageDataEntityId, strWFFORMNAME, this.formView);
        if (callResult == null || callResult.getRetCode() != 0) {
            this.PageLog((Object)this, "\u83b7\u53d6\u5b9e\u4f53\u9ed8\u8ba4\u8868\u5355\u89c6\u56fe\u5931\u8d25", callResult);
            return false;
        }
        this.setPageParam("FORMVIEW", this.formView);
        this.deWF = this.getDEHelper().GetDEWF();
        if (this.deWF == null) {
            this.PageLog((Object)this, 1, "\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53\u5de5\u4f5c\u6d41\u914d\u7f6e\u5bf9\u8c61");
            return false;
        }
        this.bEnableWFMainState = !StringHelper.IsNullOrEmpty((String)this.deWF.getMSCLID());
        return true;
    }

    protected void OnInitBackEnd() {
        super.OnInitBackEnd();
        this.RegisterFormActionHelper(this.getDefaultFormId(), this.GetFormActionHelper());
    }

    protected String GetFormActionHelper() {
        if (!StringHelper.IsNullOrEmpty((String)this.formView.getBACKENDCTRL())) {
            return this.formView.getBACKENDCTRL();
        }
        return this.getWebContext().getWebExConfig().GetValue("SRFDA", "WFFORMACTIONHELPER", "");
    }

    protected void LoadDPEx() {
        String strDPConfigId = this.getDAConfigHelper().GetEditViewDPId(this.getDEHelper(), this.formView);
        this.panel = WFEditViewPage.CreateDPEx((SRFDAPage)this, (String)"Panel", (boolean)true, (String)strDPConfigId);
        if (this.panel != null) {
            this.panel.getDPConfig().setWidth(600);
        }
        SRFExForm form = (SRFExForm)this.getDefaultForm();
        form.getLoadAction().setLoadDefault(true);
        form.setEnableItemPrivilege(this.OnGetFormItemPrivilege());
        if (!this.IsBackEndMode()) {
            StringBuilderEx script = new StringBuilderEx();
            script.Reset();
            script.Append("$P.setmainform(%1$s);", (Object)form.getFormId());
            this.RegisterOnReadyScript(3, script.toString());
            ArrayList keyControls = form.GetKeyFormControls();
            int nCount = keyControls.size();
            if (nCount == 0) {
                script.Append("alert('\u8868\u5355\u6ca1\u6709\u4efb\u4f55\u4e3b\u952e\uff0c\u5904\u7406\u505c\u6b62!');");
            }
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
                } else {
                    strParamValue = this.getWebContext().GetParamValue(iDEFHelper.getName());
                }
                ++i;
            }
            if (StringHelper.IsNullOrEmpty((String)strParamValue)) {
                script.Append("%1$s", (Object)FormJSHelper.getResetScript((SRFExForm)form));
            } else {
                script.Append("%1$s", (Object)FormJSHelper.getLoad2Script((SRFExForm)form, (String)("'" + strParamValue + "'" + ",false")));
            }
            this.RegisterOnReadyScript(5, script.toString());
        } else {
            this.setFormParam((SRFExBaseForm)form, "WFSTATE", this.strWFState);
            this.setFormParam((SRFExBaseForm)form, "WFSTEP", this.strWFStep);
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
        String strToolbarConfigId = this.GetToolbarConfigId();
        if (StringHelper.IsNullOrEmpty((String)strToolbarConfigId)) {
            this.PageLog((Object)this, 1, "\u65e0\u6cd5\u83b7\u53d6\u5de5\u5177\u680f\u914d\u7f6e\u5bf9\u8c61");
            return;
        }
        this.toolbar = WFEditViewPage.CreateToolbar((SRFDAPage)this, (String)"toolBar", (double)0.0, (double)0.0, (String)strToolbarConfigId);
    }

    protected String GetToolbarConfigId() {
        if (StringHelper.Compare((String)this.strWFState, (String)"WFNOTSTART", (boolean)true) == 0) {
            return this.getDAConfigHelper().GetWFEditViewToolbarConfigId(this.getDEHelper(), this.page, this.formView, true, this.deWF.GetWFFIRSTACTION(this.getLanguage()));
        }
        return "";
    }

    protected boolean OnGetFormItemPrivilege() {
        return this.getPageParam("PAGE.FORM.ITEMPRIVILEGE", this.getDEHelper().IsEnableDEFieldPriv());
    }

    public boolean IsEnableWFMainState() {
        return this.bEnableWFMainState;
    }
}

