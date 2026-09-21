/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.DEFHelper.IDEFHelper
 *  SA.SRFDA.Ctrl.DEFHelper.ILinkDEFHelper
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  SA.SRFramework.WebEx.Form.SRFExForm
 *  SA.SRFramework.WebEx.SRFExControl
 *  SA.SRFramework.WebEx.Script.FormJSHelper
 */
package SA.SRFDA.Web.Default;

import SA.SRFDA.Ctrl.DEFHelper.IDEFHelper;
import SA.SRFDA.Ctrl.DEFHelper.ILinkDEFHelper;
import SA.SRFDA.Web.Default.BaseEditViewPage2;
import SA.SRFDA.Web.Default.PageRender;
import SA.SRFDA.Web.SRFDAPage;
import SA.SRFDA.Web.ViewModel.DPExModel;
import SA.SRFDA.Web.ViewModel.FormModel;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.WebEx.Form.SRFExForm;
import SA.SRFramework.WebEx.SRFExControl;
import SA.SRFramework.WebEx.Script.FormJSHelper;
import java.util.ArrayList;

public class EmbedInfoViewPage
extends BaseEditViewPage2 {
    @Override
    protected boolean PreparePageEnv() {
        if (!super.PreparePageEnv()) {
            return false;
        }
        this.strPageDataEntityId = this.getWebContext().getSRFDEID();
        this.strFormViewId = this.getWebContext().getSRFFormView();
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
        this.setPageParam("EMBEDEDIT", true);
        return true;
    }

    protected void OnInitBackEnd() {
        super.OnInitBackEnd();
        this.RegisterFormActionHelper(this.getDefaultFormId(), this.GetFormActionHelper());
    }

    @Override
    protected String GetFormActionHelper() {
        if (!StringHelper.IsNullOrEmpty((String)this.formView.getBACKENDCTRL())) {
            return this.formView.getBACKENDCTRL();
        }
        return this.getWebContext().getWebExConfig().GetValue("SRFDA", "FORMACTIONHELPER", "");
    }

    protected void LoadDPEx() {
        this.strDPConfigId = this.OnGetDPConfigId();
        this.panel = EmbedInfoViewPage.CreateDPEx((SRFDAPage)this, "Panel", true, this.strDPConfigId);
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
            if (this.getPageParam("PAGE.FORM.RELOADMAINAFTERSAVE", false)) {
                form.getSaveAction().getSuccessAction().RegisterProcessCode(0, "if(parent&&parent.$P&&parent.$P.mainform){parent.$P.mainform.load();}");
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
                this.bContainKey = false;
                script.Append("%1$s", (Object)FormJSHelper.getResetScript((SRFExForm)form));
            } else {
                this.bContainKey = true;
                this.keyJson.put(strParamName.toLowerCase(), (Object)strParamValue);
                script.Append("%1$s", (Object)FormJSHelper.getLoad2Script((SRFExForm)form, (String)("'" + strParamValue + "'" + ",false")));
            }
            this.RegisterOnReadyScript(5, script.toString());
        }
    }

    public String GetLoadFormCode() {
        String strSummaryKey = this.getWebContext().GetParamValue("SRFSUMMARYKEY");
        if (StringHelper.IsNullOrEmpty((String)strSummaryKey)) {
            return "";
        }
        SRFExForm form = (SRFExForm)this.getDefaultForm();
        StringBuilderEx script = new StringBuilderEx();
        script.Append("var _V=$V(_1.%1$s,'');", (Object)this.getWebContext().GetParamValue("SRFSUMMARYKEY"));
        script.Append("if(_V==''){%1$s return;}", (Object)FormJSHelper.getResetScript((SRFExForm)form));
        script.Append(FormJSHelper.getLoad2Script((SRFExForm)form, (String)"_V"));
        return script.toString();
    }

    public String RenderPanel() {
        String strOutput = "";
        if (this.panel != null) {
            strOutput = String.valueOf(strOutput) + PageRender.RenderLoadingIndicator(String.valueOf(this.getDefaultFormId()) + "_indicator");
            strOutput = String.valueOf(strOutput) + this.Render("panel");
        }
        return strOutput;
    }

    protected void OnInitComponents() {
        super.OnInitComponents();
        this.LoadDPEx();
    }
}

