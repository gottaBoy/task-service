/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.WebEx.DP.SRFExDPEx
 *  SA.SRFramework.WebEx.Form.SRFExBaseFormAction
 *  SA.SRFramework.WebEx.Form.SRFExForm
 *  SA.SRFramework.WebEx.Form.SRFExFormAjaxSuccessAction
 *  SA.SRFramework.WebEx.Form.SRFExFormCustomAjaxActionEx
 *  SA.SRFramework.WebEx.Form.SRFExFormLoadSuccessAction
 */
package SA.SRFDA.Web.Default;

import SA.SRFDA.Ctrl.Form.XMLObjectFormActionHelper;
import SA.SRFDA.Web.Default.CommonDialogEx;
import SA.SRFDA.Web.Default.PageRender;
import SA.SRFDA.Web.SRFDAPage;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.DP.SRFExDPEx;
import SA.SRFramework.WebEx.Form.SRFExBaseFormAction;
import SA.SRFramework.WebEx.Form.SRFExForm;
import SA.SRFramework.WebEx.Form.SRFExFormAjaxSuccessAction;
import SA.SRFramework.WebEx.Form.SRFExFormCustomAjaxActionEx;
import SA.SRFramework.WebEx.Form.SRFExFormLoadSuccessAction;

public class CommonXMLFormDialogEx
extends CommonDialogEx {
    protected SRFExDPEx panel = null;
    public static final String TAG_DPEXID = "PAGE.DPEXID";
    public static final String TAG_FAHELPER = "PAGE.FAHELPER";
    protected String strDPConfigId = "";

    @Override
    protected void OnInitComponents() {
        super.OnInitComponents();
        this.LoadDPEx();
    }

    @Override
    protected void LoadToolbar() {
        this.toolbar = CommonXMLFormDialogEx.CreateToolbar(this, "toolBar", 0.0, 0.0, "SRFDA.TB_DIALOG");
    }

    protected void LoadDPEx() {
        String strDPExConfigId = this.GetDPExConfigId();
        this.panel = CommonXMLFormDialogEx.CreateDPEx((SRFDAPage)this, "Panel", true, strDPExConfigId);
        if (this.panel != null && this.panel.getDPConfig().getPageGroupsConfig().size() == 1) {
            this.panel.getDPConfig().setSimpleMode(true);
        }
        SRFExForm form = (SRFExForm)this.getDefaultForm();
        if (!this.IsBackEndMode()) {
            SRFExFormCustomAjaxActionEx customAction = new SRFExFormCustomAjaxActionEx((SRFExFormAjaxSuccessAction)new SRFExFormLoadSuccessAction());
            customAction.setActionName("loadxml");
            customAction.setAppendAll(false);
            customAction.setAppendKey(false);
            form.AddFormAction((SRFExBaseFormAction)customAction);
        }
    }

    protected String GetDPExConfigId() {
        return this.getPageParam(TAG_DPEXID, this.strDPConfigId);
    }

    public void SetDPExConfigId(String strDPConfigId) {
        this.strDPConfigId = strDPConfigId;
    }

    protected void OnInitBackEnd() {
        super.OnInitBackEnd();
        String strFAHelperId = this.getPageParam(TAG_FAHELPER, XMLObjectFormActionHelper.class.getName());
        this.RegisterFormActionHelper(this.getDefaultForm().getFormId(), strFAHelperId);
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
            strOutput = String.valueOf(strOutput) + StringHelper.Format((String)"<div class=\"sx-errorpanel\" id=\"%1$s_errorindicator\" style=\"width:100%%;height:60px;display:none;overflow:auto;\"></div>", (Object)this.getDefaultFormId());
        }
        return strOutput;
    }
}

