/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.DEFHelper.IDEFHelper
 *  SA.SRFDA.Ctrl.DEFHelper.ILinkDEFHelper
 *  SA.SRFDA.Ctrl.Data.Form
 *  SA.SRFDA.Ctrl.Data.Message
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFDA.Web.Default.BaseMainPage
 *  SA.SRFDA.Web.Default.PageRender
 *  SA.SRFDA.Web.Default.ViewModel.EditView2Model
 *  SA.SRFDA.Web.ISRFDAWebContext
 *  SA.SRFDA.Web.JSGear.FormModifyAlertJSGear
 *  SA.SRFDA.Web.SRFDAPage
 *  SA.SRFDA.Web.ViewModel.DPExModel
 *  SA.SRFDA.Web.ViewModel.FormModel
 *  SA.SRFDA.Web.ViewModel.PageModel
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  SA.SRFramework.WebEx.DP.SRFExDPEx
 *  SA.SRFramework.WebEx.Form.SRFExForm
 *  SA.SRFramework.WebEx.SRFExControl
 *  SA.SRFramework.WebEx.Script.FormJSHelper
 *  SA.SRFramework.WebEx.ToolBar.SRFExToolbar
 *  net.sf.json.JSONObject
 */
package SA.SRFDA.MSG.Web;

import SA.SRFDA.Ctrl.DEFHelper.IDEFHelper;
import SA.SRFDA.Ctrl.DEFHelper.ILinkDEFHelper;
import SA.SRFDA.Ctrl.Data.Form;
import SA.SRFDA.Ctrl.Data.Message;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.MSG.Ctrl.Form.MsgFormActionHelper;
import SA.SRFDA.Web.Default.BaseMainPage;
import SA.SRFDA.Web.Default.PageRender;
import SA.SRFDA.Web.Default.ViewModel.EditView2Model;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFDA.Web.JSGear.FormModifyAlertJSGear;
import SA.SRFDA.Web.SRFDAPage;
import SA.SRFDA.Web.ViewModel.DPExModel;
import SA.SRFDA.Web.ViewModel.FormModel;
import SA.SRFDA.Web.ViewModel.PageModel;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.WebEx.DP.SRFExDPEx;
import SA.SRFramework.WebEx.Form.SRFExForm;
import SA.SRFramework.WebEx.SRFExControl;
import SA.SRFramework.WebEx.Script.FormJSHelper;
import SA.SRFramework.WebEx.ToolBar.SRFExToolbar;
import java.util.ArrayList;
import net.sf.json.JSONObject;

public class MsgEditViewPage
extends BaseMainPage {
    protected SRFExToolbar toolbar = null;
    protected SRFExDPEx panel = null;
    protected Form formView = null;
    protected String strFormViewId = "";
    protected String strToolbarConfigId = "";
    protected String strDPConfigId = "";
    private boolean bContainKey = false;
    private JSONObject keyJson = new JSONObject();
    protected EditView2Model editView2Model = null;

    protected boolean PreparePageEnv() {
        if (!super.PreparePageEnv()) {
            return false;
        }
        this.strPageDataEntityId = "DE0071";
        if (!this.LoadPageDataEntity()) {
            return false;
        }
        this.formView = this.getWebContext().GetConfigCache().GetDefaultDEMainForm(this.getWebContext(), this.strPageDataEntityId);
        if (this.formView == null) {
            return false;
        }
        this.setPageParam("FORMVIEW", this.formView);
        return true;
    }

    protected PageModel CreatePageModel() {
        return new EditView2Model();
    }

    protected void PreparePageModel() {
        super.PreparePageModel();
        this.editView2Model = (EditView2Model)this.pageModel;
    }

    protected void OnInitBackEnd() {
        super.OnInitBackEnd();
        this.RegisterFormActionHelper(this.getDefaultFormId(), this.GetFormActionHelper());
    }

    protected String GetFormActionHelper() {
        if (!StringHelper.IsNullOrEmpty((String)this.formView.getBACKENDCTRL())) {
            return this.formView.getBACKENDCTRL();
        }
        return MsgFormActionHelper.class.getName();
    }

    protected void LoadDPEx() {
        this.strDPConfigId = this.getDAConfigHelper().GetEditViewDPId(this.getDEHelper(), this.formView);
        this.panel = MsgEditViewPage.CreateDPEx((SRFDAPage)this, (String)"Panel", (boolean)true, (String)this.strDPConfigId);
        if (this.panel != null) {
            this.panel.getDPConfig().setWidth(600);
            if (this.panel.getDPConfig().getPageGroupsConfig().size() == 1) {
                this.panel.getDPConfig().setSimpleMode(true);
            }
        }
        SRFExForm form = (SRFExForm)this.getDefaultForm();
        form.getLoadAction().setLoadDefault(true);
        if (this.editView2Model != null) {
            DPExModel dpExModel = this.editView2Model.getDPExModel();
            dpExModel.setConfigId(this.strDPConfigId);
            dpExModel.setRemoteCtrlId(this.panel.getUniqueID());
            FormModel formModel = this.editView2Model.getFormModel();
            formModel.setRemoteCtrlId(form.getFormId());
        }
        if (!this.IsBackEndMode()) {
            StringBuilderEx script = new StringBuilderEx();
            script.Reset();
            script.Append("$P.setmainform(%1$s);", (Object)form.getFormId());
            this.RegisterOnReadyScript(3, script.toString());
            script.Reset();
            ArrayList keyControls = form.GetKeyFormControls();
            int nCount = keyControls.size();
            if (nCount == 0) {
                script.Append("alert('\u8868\u5355\u6ca1\u6709\u4efb\u4f55\u4e3b\u952e\uff0c\u5904\u7406\u505c\u6b62!');");
            }
            String strParamValue = "";
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
                script.Append("%1$s", (Object)FormJSHelper.getLoadDefaultScript((SRFExForm)form));
            } else {
                this.bContainKey = true;
                this.keyJson.put(strParamName.toLowerCase(), (Object)strParamValue);
                script.Append("%1$s", (Object)FormJSHelper.getLoad2Script((SRFExForm)form, (String)("'" + strParamValue + "'" + ",false")));
            }
            this.RegisterOnReadyScript(5, script.toString());
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
        this.strToolbarConfigId = this.GetToolbarConfigId();
        if (StringHelper.IsNullOrEmpty((String)this.strToolbarConfigId)) {
            this.PageLog((Object)this, 1, "\u65e0\u6cd5\u83b7\u53d6\u5de5\u5177\u680f\u914d\u7f6e\u5bf9\u8c61");
            return;
        }
        this.toolbar = MsgEditViewPage.CreateToolbar((SRFDAPage)this, (String)"toolBar", (double)0.0, (double)0.0, (String)this.strToolbarConfigId);
        if (this.editView2Model != null && this.editView2Model.getToolbarModel() != null) {
            this.editView2Model.getToolbarModel().setCtrlId("toolBar");
            this.editView2Model.getToolbarModel().setConfigId(this.strToolbarConfigId);
            this.editView2Model.getToolbarModel().setRemoteCtrlId(this.toolbar.getUniqueID());
        }
    }

    protected String GetToolbarConfigId() {
        IDEDataCtrl iDataCtrl;
        String strMessageId = this.getWebContext().GetParamValue("MESSAGEID");
        String strMsgMode = this.getWebContext().GetParamValue("MSGMODE");
        if (!StringHelper.IsNullOrEmpty((String)strMsgMode)) {
            return "SRFMSG.TB_SENDMSG";
        }
        if (!StringHelper.IsNullOrEmpty((String)strMessageId) && (iDataCtrl = this.getDEHelper().GetDEDataCtrl("", (ISRFDAWebContext)this.getWebContext())) != null) {
            Message message = new Message();
            message.setMESSAGEID(strMessageId);
            iDataCtrl.Get((BaseDataEntity)message);
            if (StringHelper.Compare((String)message.getMSGFOLDER(), (String)"DRAFT", (boolean)true) == 0) {
                return "SRFMSG.TB_NEWMSG";
            }
            return "SRFMSG.TB_CANCELMSG";
        }
        return "SRFMSG.TB_NEWMSG";
    }

    protected boolean OnFillPageModel(JSONObject jsonObject) {
        if (!super.OnFillPageModel(jsonObject)) {
            return false;
        }
        this.editView2Model.setContainKey(this.bContainKey);
        if (this.bContainKey) {
            this.editView2Model.setKeyData(this.keyJson);
        }
        if (this.strToolbarConfigId.indexOf("SRFMSG.TB_CANCELMSG") != -1) {
            this.editView2Model.setPreviewFormDirty(Boolean.valueOf(false));
        }
        return true;
    }

    protected String OnGetPageTitle() {
        return this.GetLocalization("PAGE.HEADER.MSGEDITVIEW", "\u6d88\u606f\u89c6\u56fe");
    }
}

