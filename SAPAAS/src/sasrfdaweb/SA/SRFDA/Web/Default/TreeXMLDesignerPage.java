/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.Data.Form
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.WebEx.DP.SRFExDPEx
 *  SA.SRFramework.WebEx.Form.SRFExBaseFormAction
 *  SA.SRFramework.WebEx.Form.SRFExForm
 *  SA.SRFramework.WebEx.Form.SRFExFormAjaxSuccessAction
 *  SA.SRFramework.WebEx.Form.SRFExFormCustomAjaxActionEx
 *  SA.SRFramework.WebEx.Form.SRFExFormLoadSuccessAction
 *  SA.SRFramework.WebEx.SRFExButton
 *  SA.SRFramework.WebEx.SRFExControl
 *  SA.SRFramework.WebEx.Script.FormJSHelper
 */
package SA.SRFDA.Web.Default;

import SA.SRFDA.Ctrl.Data.Form;
import SA.SRFDA.Ctrl.Form.TreeXMLObjectFormActionHelper;
import SA.SRFDA.Web.Default.PageRender;
import SA.SRFDA.Web.SRFDAPage;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.DP.SRFExDPEx;
import SA.SRFramework.WebEx.Form.SRFExBaseFormAction;
import SA.SRFramework.WebEx.Form.SRFExForm;
import SA.SRFramework.WebEx.Form.SRFExFormAjaxSuccessAction;
import SA.SRFramework.WebEx.Form.SRFExFormCustomAjaxActionEx;
import SA.SRFramework.WebEx.Form.SRFExFormLoadSuccessAction;
import SA.SRFramework.WebEx.SRFExButton;
import SA.SRFramework.WebEx.SRFExControl;
import SA.SRFramework.WebEx.Script.FormJSHelper;

public class TreeXMLDesignerPage
extends SRFDAPage {
    protected SRFExDPEx panel = null;
    protected Form formView = new Form();
    protected String strFormViewId = "";
    protected SRFExButton btnOK = null;
    protected String strBtnOKText = "\u786e\u5b9a";
    protected String strBtnOKTip = "";
    protected String strDPExConfigId = "";
    protected String strDPExFormActionHelper = TreeXMLObjectFormActionHelper.class.getName();

    public TreeXMLDesignerPage() {
        this.setJSCache(false);
        this.setMainPage(true);
        this.setOutputDebug(false);
    }

    public String GetCtrlID() {
        return this.getWebContext().GetParamValue("SRFCTRLID");
    }

    protected void OnInitComponents() {
        super.OnInitComponents();
        this.LoadDPEx();
        this.btnOK = new SRFExButton();
        this.btnOK.InitConfig();
        this.btnOK.setID("btnOK");
        this.btnOK.getButtonConfig().setText(this.strBtnOKText);
        this.btnOK.getButtonConfig().setTips(this.strBtnOKTip);
        this.btnOK.setResourceId("");
        this.AddControl((SRFExControl)this.btnOK);
        if (!this.IsBackEndMode()) {
            this.btnOK.getButtonConfig().setJSCode(FormJSHelper.getSaveScript((SRFExForm)((SRFExForm)this.getDefaultForm())));
        }
    }

    protected void OnInitBackEnd() {
        super.OnInitBackEnd();
        this.RegisterFormActionHelper(this.getDefaultFormId(), this.strDPExFormActionHelper);
    }

    protected void LoadDPEx() {
        this.panel = TreeXMLDesignerPage.CreateDPEx((SRFDAPage)this, "Panel", true, this.strDPExConfigId);
        if (this.panel != null) {
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
            strOutput = String.valueOf(strOutput) + StringHelper.Format((String)"<div class=\"sx-errorpanel\" id=\"%1$s_errorindicator\" style=\"width:100%%;height:50px;display:none;\"></div>", (Object)this.getDefaultFormId());
        }
        return strOutput;
    }
}

