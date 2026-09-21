/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.DEFHelper.IDEFHelper
 *  SA.SRFDA.Ctrl.Data.Form
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  SA.SRFramework.WebEx.DP.SRFExDPEx
 *  SA.SRFramework.WebEx.Form.SRFExBaseForm
 *  SA.SRFramework.WebEx.Form.SRFExForm
 *  SA.SRFramework.WebEx.SRFExControl
 *  SA.SRFramework.WebEx.ToolBar.SRFExToolbar
 */
package SA.SRFDA.Web.Default;

import SA.SRFDA.Ctrl.DEFHelper.IDEFHelper;
import SA.SRFDA.Ctrl.Data.Form;
import SA.SRFDA.Web.Default.BaseMainPage;
import SA.SRFDA.Web.Default.PageRender;
import SA.SRFDA.Web.SRFDAPage;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.WebEx.DP.SRFExDPEx;
import SA.SRFramework.WebEx.Form.SRFExBaseForm;
import SA.SRFramework.WebEx.Form.SRFExForm;
import SA.SRFramework.WebEx.SRFExControl;
import SA.SRFramework.WebEx.ToolBar.SRFExToolbar;

public class SummaryFormViewPage
extends BaseMainPage {
    protected SRFExToolbar toolbar = null;
    protected SRFExDPEx panel = null;
    protected Form formView = new Form();
    protected String strFormViewId = "";

    @Override
    protected boolean PreparePageEnv() {
        if (!super.PreparePageEnv()) {
            return false;
        }
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
            return false;
        }
        this.setPageParam("FORMVIEW", this.formView);
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
        return this.getWebContext().getWebExConfig().GetValue("SRFDA", "FORMACTIONHELPER", "");
    }

    protected void LoadDPEx() {
        String strDPConfigId = this.getDAConfigHelper().GetEditViewDPId(this.getDEHelper(), this.formView);
        this.panel = SummaryFormViewPage.CreateDPEx((SRFDAPage)this, "Panel", true, strDPConfigId);
        if (this.panel != null) {
            this.panel.getDPConfig().setWidth(600);
            if (this.panel.getDPConfig().getPageGroupsConfig().size() == 1) {
                this.panel.getDPConfig().setSimpleMode(true);
            }
        }
        SRFExForm form = (SRFExForm)this.getDefaultForm();
        form.getLoadAction().setLoadDefault(false);
        this.setFormParam((SRFExBaseForm)form, "DISABLEITEMS", true);
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
                String strValue = this.getWebContext().GetParamValue(keyDEFHelper.getName());
                script.Append("if('%3$s'=='')return;%1$s.S('%2$s','%3$s');%1$s.load();", (Object)form.getFormId(), (Object)keyControl.getUniqueID(), (Object)strValue);
            }
            this.RegisterOnReadyScript(5, script.toString());
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

    protected void OnInitComponents() {
        super.OnInitComponents();
        this.LoadDPEx();
    }

    @Override
    protected void OnInit() {
        super.OnInit();
    }
}

