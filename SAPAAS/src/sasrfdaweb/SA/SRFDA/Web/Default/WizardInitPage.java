/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.Data.DEWizard
 *  SA.SRFDA.Ctrl.Data.WizardSession
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.WebEx.Utility.URLHelper
 */
package SA.SRFDA.Web.Default;

import SA.SRFDA.Ctrl.Data.DEWizard;
import SA.SRFDA.Ctrl.Data.WizardSession;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.Web.SRFDAPageEx;
import SA.SRFDA.Web.Script.RichAppJSHelper;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.Utility.URLHelper;
import java.util.TreeMap;

public class WizardInitPage
extends SRFDAPageEx {
    @Override
    protected boolean PreparePageEnv() {
        if (!super.PreparePageEnv()) {
            return false;
        }
        String strDEWizardId = this.getWebContext().GetParamValue("SRFDEWIZARDID");
        if (StringHelper.IsNullOrEmpty((String)strDEWizardId)) {
            this.PageLog((Object)this, 1, StringHelper.Format((String)"\u6ca1\u6709\u6307\u5b9a\u5b9e\u4f53\u5411\u5bfc\u7f16\u53f7"));
            if (this.pageModel != null) {
                if (!StringHelper.IsNullOrEmpty((String)this.getPageModel())) {
                    this.pageModel.AppendPageCode(RichAppJSHelper.getAlertMessageScript(this.getPageModel(), StringHelper.Format((String)"\u6ca1\u6709\u6307\u5b9a\u5b9e\u4f53\u5411\u5bfc\u7f16\u53f7")));
                    this.pageModel.AppendPageCode(RichAppJSHelper.getCloseWindowScript(this.getPageModel()));
                }
                this.OutputDirect(this.pageModel.toString());
            }
            return false;
        }
        DEWizard deWizard = new DEWizard();
        CallResult callResult = this.getDAModelHelper().GetDEWizard(strDEWizardId, deWizard);
        if (callResult.IsError()) {
            this.PageLog((Object)this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u5b9e\u4f53\u5411\u5bfc[%1$s]", (Object)strDEWizardId));
            if (this.pageModel != null) {
                if (!StringHelper.IsNullOrEmpty((String)this.getPageModel())) {
                    this.pageModel.AppendPageCode(RichAppJSHelper.getAlertMessageScript(this.getPageModel(), StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u5b9e\u4f53\u5411\u5bfc[%1$s]", (Object)strDEWizardId)));
                    this.pageModel.AppendPageCode(RichAppJSHelper.getCloseWindowScript(this.getPageModel()));
                }
                this.OutputDirect(this.pageModel.toString());
            }
            return false;
        }
        this.strPageDataEntityId = deWizard.getWZDEID();
        if (!this.LoadPageDataEntity()) {
            return false;
        }
        if (StringHelper.IsNullOrEmpty((String)deWizard.getINITDEACTIONID())) {
            this.PageLog((Object)this, 1, StringHelper.Format((String)"\u6ca1\u6709\u6307\u5b9a\u5411\u5bfc\u6570\u636e\u521d\u59cb\u5316\u64cd\u4f5c"));
            if (this.pageModel != null) {
                if (!StringHelper.IsNullOrEmpty((String)this.getPageModel())) {
                    this.pageModel.AppendPageCode(RichAppJSHelper.getAlertMessageScript(this.getPageModel(), StringHelper.Format((String)"\u6ca1\u6709\u6307\u5b9a\u5411\u5bfc\u6570\u636e\u521d\u59cb\u5316\u64cd\u4f5c")));
                    this.pageModel.AppendPageCode(RichAppJSHelper.getCloseWindowScript(this.getPageModel()));
                }
                this.OutputDirect(this.pageModel.toString());
            }
            return false;
        }
        IDEDataCtrl wzDEDataCtrl = this.GetDEDataCtrl();
        if (wzDEDataCtrl == null) {
            this.PageLog((Object)this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61", (Object)deWizard.getWZDEID()));
            if (this.pageModel != null) {
                if (!StringHelper.IsNullOrEmpty((String)this.getPageModel())) {
                    this.pageModel.AppendPageCode(RichAppJSHelper.getAlertMessageScript(this.getPageModel(), StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61", (Object)deWizard.getWZDEID())));
                    this.pageModel.AppendPageCode(RichAppJSHelper.getCloseWindowScript(this.getPageModel()));
                }
                this.OutputDirect(this.pageModel.toString());
            }
            return false;
        }
        BaseDataEntity dataEntity = new BaseDataEntity();
        callResult = wzDEDataCtrl.Execute(deWizard.getINITDEACTIONID(), dataEntity);
        if (callResult.IsError()) {
            this.PageLog((Object)this, 1, StringHelper.Format((String)"\u6267\u884c\u5b9e\u4f53[%1$s]\u884c\u4e3a[%2$s]\u5931\u8d25\uff0c%3$s", (Object)deWizard.getWZDEID(), (Object)deWizard.getINITDEACTIONID(), (Object)callResult.getErrorInfo()));
            if (this.pageModel != null) {
                if (!StringHelper.IsNullOrEmpty((String)this.getPageModel())) {
                    this.pageModel.AppendPageCode(RichAppJSHelper.getAlertMessageScript(this.getPageModel(), StringHelper.Format((String)"\u5411\u5bfc\u521d\u59cb\u5316\u5931\u8d25\uff0c%1$s", (Object)callResult.getErrorInfo())));
                    this.pageModel.AppendPageCode(RichAppJSHelper.getCloseWindowScript(this.getPageModel()));
                }
                this.OutputDirect(this.pageModel.toString());
            }
            return false;
        }
        String strKeyName = wzDEDataCtrl.GetDEHelper().GetKeyDEFHelper().getName();
        String strWZPageId = "WZPAGEID";
        TreeMap<String, String> daParams = new TreeMap<String, String>();
        daParams.put("SRFDEID", deWizard.getWZDEID());
        daParams.put("SRFDEWIZARDID", strDEWizardId);
        daParams.put(strKeyName, dataEntity.GetParamStringValue(strKeyName, ""));
        daParams.put("SRFDEWZPAGEID", dataEntity.GetParamStringValue(strWZPageId, ""));
        if (StringHelper.Compare((String)deWizard.getWIZARDMODE(), (String)"WIZARDSESSION", (boolean)true) == 0) {
            WizardSession wizardSession = new WizardSession();
            wizardSession.setDEWIZARDID(strDEWizardId);
            IDEDataCtrl wizardSessionDataCtrl = this.GetDEDataCtrl("DE0265");
            callResult = wizardSessionDataCtrl.Save(true, (BaseDataEntity)wizardSession);
            if (callResult.IsError()) {
                this.PageLog((Object)this, 1, StringHelper.Format((String)"\u4fdd\u5b58\u5411\u5bfc\u4f1a\u8bdd\u6570\u636e\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                return false;
            }
            daParams.put("SRFWZSESSIONID", wizardSession.getWIZARDSESSIONID());
        }
        String strRedirectPage = StringHelper.Format((String)"../srfpage/wizardstepview.jsp?%1$s", (Object)URLHelper.GetQueryString(daParams));
        if (!StringHelper.IsNullOrEmpty((String)deWizard.getAPPENDURLPARAMS())) {
            strRedirectPage = URLHelper.AppendURLSeperator((String)strRedirectPage);
            strRedirectPage = String.valueOf(strRedirectPage) + this.getWebContext().GetParamsString(deWizard.getAPPENDURLPARAMS());
        }
        try {
            if (StringHelper.IsNullOrEmpty((String)this.getPageModel())) {
                this.getResponse().sendRedirect(strRedirectPage);
            } else {
                this.getResponse().getWriter().write(WizardInitPage.OutputRedirectModel(strRedirectPage));
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }
}

