/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.DEFHelper.IDEFHelper
 *  SA.SRFDA.Ctrl.DEFHelper.ILinkDEFHelper
 *  SA.SRFDA.Ctrl.Data.DER1N
 *  SA.SRFDA.Ctrl.Data.Form
 *  SA.SRFDA.Ctrl.IDEHelper
 *  SA.SRFDA.Web.Default.PageRender
 *  SA.SRFDA.Web.SRFDAPage
 *  SA.SRFDA.Web.SRFDAPageEx
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  SA.SRFramework.WebEx.DP.SRFExDPEx
 *  SA.SRFramework.WebEx.Form.SRFExForm
 *  SA.SRFramework.WebEx.SRFExControl
 *  SA.SRFramework.WebEx.Script.BrowserJSHelper
 *  SA.SRFramework.WebEx.Script.FormJSHelper
 *  SA.SRFramework.WebEx.ToolBar.SRFExToolbar
 */
package SA.SRFDA.EAI.Web;

import SA.SRFDA.Ctrl.DEFHelper.IDEFHelper;
import SA.SRFDA.Ctrl.DEFHelper.ILinkDEFHelper;
import SA.SRFDA.Ctrl.Data.DER1N;
import SA.SRFDA.Ctrl.Data.Form;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.EAI.Ctrl.Form.ProcessConfigFormActionHelper;
import SA.SRFDA.Web.Default.PageRender;
import SA.SRFDA.Web.SRFDAPage;
import SA.SRFDA.Web.SRFDAPageEx;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.WebEx.DP.SRFExDPEx;
import SA.SRFramework.WebEx.Form.SRFExForm;
import SA.SRFramework.WebEx.SRFExControl;
import SA.SRFramework.WebEx.Script.BrowserJSHelper;
import SA.SRFramework.WebEx.Script.FormJSHelper;
import SA.SRFramework.WebEx.ToolBar.SRFExToolbar;
import java.util.ArrayList;

public class ProcessEditDialog
extends SRFDAPageEx {
    public static final String TAG_TOOLBARID = "SRFDA.TB_DIALOG2";
    protected SRFExDPEx panel = null;
    protected SRFExToolbar toolbar = null;
    protected String strFormViewId = "";
    protected Form formView = new Form();

    protected boolean PreparePageEnv() {
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

    protected void OnInitComponents() {
        super.OnInitComponents();
        this.LoadToolbar();
        this.LoadDPEx();
    }

    protected void LoadToolbar() {
        this.toolbar = ProcessEditDialog.CreateToolbar((SRFDAPage)this, (String)"toolBar", (double)0.0, (double)0.0, (String)TAG_TOOLBARID);
    }

    protected void LoadDPEx() {
        String strDPConfigId = this.getDAConfigHelper().GetEditViewDPId(this.getDEHelper(), this.formView);
        this.panel = ProcessEditDialog.CreateDPEx((SRFDAPage)this, (String)"Panel", (boolean)true, (String)strDPConfigId);
        if (this.panel != null) {
            this.panel.getDPConfig().setWidth(600);
        }
        SRFExForm form = (SRFExForm)this.getDefaultForm();
        form.getLoadAction().setLoadDefault(true);
        if (!this.IsBackEndMode()) {
            StringBuilderEx script = new StringBuilderEx();
            script.Reset();
            script.Append("$P.setmainform(%1$s);", (Object)form.getFormId());
            script.Append("$P.mainform.newdata=function(){%1$s.loaddefault(); };", (Object)form.getFormId());
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
            SRFExControl nameControl = form.FindControl(this.getDEHelper().GetMajorDEFHelper().getName());
            script.Reset();
            script.Append(BrowserJSHelper.getResetDialogReturnValue());
            script.Append(BrowserJSHelper.getSetDialogReturnValue((String)"ret", (String)"'ok'"));
            script.Append(BrowserJSHelper.getSetDialogReturnValue((String)"processconfigid", (String)StringHelper.Format((String)"$P.mainform.getvalue('%1$s')", (Object)((SRFExControl)keyControls.get(0)).getUniqueID())));
            if (nameControl != null) {
                script.Append(BrowserJSHelper.getSetDialogReturnValue((String)"logicname", (String)StringHelper.Format((String)"$P.mainform.getvalue('%1$s')", (Object)nameControl.getUniqueID())));
            } else {
                script.Append(BrowserJSHelper.getSetDialogReturnValue((String)"logicname", (String)"''"));
            }
            script.Append(BrowserJSHelper.getCloseWindowScript());
            form.getSaveAction().getSuccessAction().RegisterProcessCode(0, script.toString());
        }
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
        return ProcessConfigFormActionHelper.class.getName();
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
            strOutput = String.valueOf(strOutput) + StringHelper.Format((String)"<div class=\"sx-errorpanel\" id=\"%1$s_errorindicator\" style=\"width:100%%;height:50px;display:none;\"></div>", (Object)this.getDefaultFormId());
        }
        return strOutput;
    }
}

