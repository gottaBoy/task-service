/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.DEDataCtrl.IWizardSessionDataCtrl
 *  SA.SRFDA.Ctrl.Data.DEWizard
 *  SA.SRFDA.Ctrl.Data.Page
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFDA.Ctrl.IDEHelper
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.WebEx.Utility.URLHelper
 *  net.sf.json.JSONObject
 */
package SA.SRFDA.Web.Default;

import SA.SRFDA.Ctrl.DEDataCtrl.IWizardSessionDataCtrl;
import SA.SRFDA.Ctrl.Data.DEWizard;
import SA.SRFDA.Ctrl.Data.Page;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Web.Default.DefaultPageHelper;
import SA.SRFDA.Web.SRFDAPageEx;
import SA.SRFDA.Web.Script.RichAppJSHelper;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.Utility.URLHelper;
import java.util.TreeMap;
import java.util.Vector;
import net.sf.json.JSONObject;

public class WizardFinishPage
extends SRFDAPageEx {
    @Override
    protected boolean PreparePageEnv() {
        if (!super.PreparePageEnv()) {
            return false;
        }
        String strDEWizardId = this.getWebContext().GetParamValue("SRFDEWIZARDID");
        if (StringHelper.IsNullOrEmpty((String)strDEWizardId)) {
            this.OutputPreparePageEnvError("\u6ca1\u6709\u6307\u5b9a\u5b9e\u4f53\u5411\u5bfc\u7f16\u53f7");
            return false;
        }
        DEWizard deWizard = new DEWizard();
        CallResult callResult = this.getDAModelHelper().GetDEWizard(strDEWizardId, deWizard);
        if (callResult.IsError()) {
            this.OutputPreparePageEnvError(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u5b9e\u4f53\u5411\u5bfc[%1$s]", (Object)strDEWizardId));
            return false;
        }
        this.strPageDataEntityId = deWizard.getWZDEID();
        if (!this.LoadPageDataEntity()) {
            return false;
        }
        if (StringHelper.IsNullOrEmpty((String)deWizard.getFINISHDEACTIONID())) {
            this.OutputPreparePageEnvError(StringHelper.Format((String)"\u6ca1\u6709\u6307\u5b9a\u5411\u5bfc\u6570\u636e\u5b8c\u6210\u64cd\u4f5c"));
            return false;
        }
        IDEDataCtrl wzDEDataCtrl = this.GetDEDataCtrl();
        if (wzDEDataCtrl == null) {
            this.OutputPreparePageEnvError(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61", (Object)deWizard.getWZDEID()));
            return false;
        }
        String strKeyName = wzDEDataCtrl.GetDEHelper().GetKeyDEFHelper().getName();
        BaseDataEntity dataEntity = null;
        String strWizardSessionId = this.getWebContext().GetParamValue("SRFWZSESSIONID");
        if (StringHelper.IsNullOrEmpty((String)strWizardSessionId)) {
            dataEntity = new BaseDataEntity();
            dataEntity.SetParamValue(strKeyName, wzDEDataCtrl.GetDEHelper().GetKeyDEFHelper().GetDEFValue(this.getWebContext().GetParamValue(strKeyName)));
            callResult = wzDEDataCtrl.Execute(deWizard.getFINISHDEACTIONID(), dataEntity);
            if (callResult.IsError()) {
                this.OutputPreparePageEnvError(StringHelper.Format((String)"\u6267\u884c\u5b9e\u4f53[%1$s]\u884c\u4e3a[%2$s]\u5931\u8d25\uff0c%3$s", (Object)deWizard.getWZDEID(), (Object)deWizard.getFINISHDEACTIONID(), (Object)callResult.getErrorInfo()));
                return false;
            }
        } else {
            Vector list = new Vector();
            IWizardSessionDataCtrl iWizardSessionDataCtrl = (IWizardSessionDataCtrl)this.GetDEDataCtrl("DE0265");
            callResult = iWizardSessionDataCtrl.SaveWizardStepDatas(strWizardSessionId, list);
            if (callResult.IsError()) {
                this.OutputPreparePageEnvError(StringHelper.Format((String)"\u4fdd\u5b58\u5411\u5bfc\u6b65\u9aa4\u6570\u636e\u5931\u8d25\uff0c%1$s", (Object)callResult.getErrorInfo()));
                return false;
            }
            if (list.size() == 0) {
                this.OutputPreparePageEnvError(StringHelper.Format((String)"\u672a\u4fdd\u5b58\u4efb\u4f55\u5411\u5bfc\u6b65\u9aa4\u6570\u636e"));
                return false;
            }
            dataEntity = (BaseDataEntity)list.get(0);
        }
        IDEHelper majorDEHelper = this.getDAModelStorage().FindDEHelper(deWizard.getDEID());
        String strMajorKeyName = majorDEHelper.GetKeyDEFHelper().getName();
        boolean bShowModal = true;
        String strURL = "";
        int nWidth = 0;
        int nHeight = 0;
        if (deWizard.getSHOWDATAAFTERWZ()) {
            String strPopupMode;
            String strDataPageId = dataEntity.GetParamStringValue("SRFPAGEID", deWizard.getPAGEID());
            if (StringHelper.IsNullOrEmpty((String)strDataPageId)) {
                strDataPageId = majorDEHelper.GetEditPageId();
            }
            bShowModal = StringHelper.Compare((String)(strPopupMode = this.getWebContext().getWebExConfig().GetValue("SRFDA", "POPUPMODE", "WINDOW")), (String)"MODAL", (boolean)true) == 0;
            strURL = DefaultPageHelper.GetEditViewPage();
            if (!StringHelper.IsNullOrEmpty((String)strDataPageId)) {
                Page editPage = this.getDAModelStorage().FindPage(strDataPageId);
                if (editPage == null) {
                    this.OutputPreparePageEnvError(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u9875\u9762[%1$s]\u5bf9\u8c61", (Object)strDataPageId));
                    return false;
                }
                if (editPage.GetParamValue("ISMODELSTYLE") != null) {
                    bShowModal = editPage.isMODALSTYLE();
                }
                if (!StringHelper.IsNullOrEmpty((String)editPage.GetTotalPagePath())) {
                    strURL = editPage.GetTotalPagePath();
                }
                if (editPage.getWIDTH() != 0) {
                    nWidth = editPage.getWIDTH();
                }
                if (editPage.getHEIGHT() != 0) {
                    nHeight = editPage.getHEIGHT();
                }
            }
        }
        TreeMap<String, String> daParams = new TreeMap<String, String>();
        daParams.put("SRFDEID", majorDEHelper.getId());
        String strDAParams = URLHelper.GetQueryString(daParams);
        if (!StringHelper.IsNullOrEmpty((String)strDAParams)) {
            strURL = URLHelper.AppendURLSeperator((String)strURL);
            strURL = String.valueOf(strURL) + strDAParams;
            strURL = String.valueOf(strURL) + "&";
        }
        if (StringHelper.Compare((String)this.getPageModel(), (String)"SL", (boolean)true) == 0 && this.pageModel != null) {
            JSONObject keyData = new JSONObject();
            keyData.put("key", (Object)dataEntity.GetParamStringValue(strMajorKeyName, ""));
            this.pageModel.AppendPageCode(RichAppJSHelper.getSetDialogResult(this.getPageModel(), "OK"));
            this.pageModel.AppendPageCode(RichAppJSHelper.getSetReturnValue(this.getPageModel(), "KEYDATA", StringHelper.Format((String)"'%1$s'", (Object)keyData.toString())));
            this.pageModel.AppendPageCode(RichAppJSHelper.getCloseWindowScript(this.getPageModel()));
            if (deWizard.getSHOWDATAAFTERWZ()) {
                strURL = URLHelper.AppendURLSeperator((String)strURL);
                strURL = String.valueOf(strURL) + StringHelper.Format((String)"%1$s=%2$s", (Object)strMajorKeyName, (Object)dataEntity.GetParamStringValue(strMajorKeyName, ""));
                this.pageModel.AppendPageCode(RichAppJSHelper.getShowWindowScript(this.getPageModel(), strURL, bShowModal, nWidth, nHeight, ""));
            }
            this.OutputDirect(this.pageModel.toString());
        }
        return false;
    }

    protected CallResult SaveWizardSessionData(Vector<BaseDataEntity> dataEntities) {
        CallResult callResult = new CallResult();
        return callResult;
    }
}

