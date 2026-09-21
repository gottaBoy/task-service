/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.DEFHelper.IDEFHelper
 *  SA.SRFDA.Ctrl.Data.DERINDEX
 *  SA.SRFDA.Ctrl.Data.DESubWF
 *  SA.SRFDA.Ctrl.Data.DEWF
 *  SA.SRFDA.Ctrl.Data.Page
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFDA.Ctrl.IDEHelper
 *  SA.SRFDA.Web.ISRFDAWebContext
 *  SA.SRFDA.Web.SRFDAPageEx
 *  SA.SRFDA.Web.Script.RichAppJSHelper
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  SA.SRFramework.WebEx.SRFExAjaxActionResult
 *  SA.SRFramework.WebEx.Script.BrowserJSHelper
 *  SA.SRFramework.WebEx.Utility.URLHelper
 *  SRFWF.Client.WFCallResult
 *  SRFWF.Client.WFClientAPI
 */
package SA.SRFDA.WF.Web;

import SA.SRFDA.Ctrl.DEFHelper.IDEFHelper;
import SA.SRFDA.Ctrl.Data.DERINDEX;
import SA.SRFDA.Ctrl.Data.DESubWF;
import SA.SRFDA.Ctrl.Data.DEWF;
import SA.SRFDA.Ctrl.Data.Page;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFDA.Web.SRFDAPageEx;
import SA.SRFDA.Web.Script.RichAppJSHelper;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.WebEx.SRFExAjaxActionResult;
import SA.SRFramework.WebEx.Script.BrowserJSHelper;
import SA.SRFramework.WebEx.Utility.URLHelper;
import SRFWF.Client.WFCallResult;
import SRFWF.Client.WFClientAPI;
import java.util.TreeMap;
import java.util.Vector;

public class WFIAActionPage
extends SRFDAPageEx {
    protected String strWFState = "";
    protected String strWFStep = "";
    protected String strWFFormName = "";

    public WFIAActionPage() {
        this.setMainPage(true);
        this.setOutputDebug(false);
    }

    protected boolean PreparePageEnv() {
        if (!super.PreparePageEnv()) {
            return false;
        }
        this.strPageDataEntityId = this.getWebContext().getSRFDEID();
        if (StringHelper.IsNullOrEmpty((String)this.strPageDataEntityId)) {
            this.PageLog((Object)this, 1, "\u6ca1\u6709\u6307\u5b9a\u6709\u6548\u7684\u5b9e\u4f53\u7f16\u53f7");
            return false;
        }
        if (!this.LoadPageDataEntity()) {
            this.PageLog((Object)this, 1, "\u52a0\u8f7d\u6570\u636e\u5b9e\u4f53\u5bf9\u8c61\u5931\u8d25");
            return false;
        }
        return true;
    }

    protected void OnLoadBackEnd() {
        SRFExAjaxActionResult actionResult = new SRFExAjaxActionResult();
        String strKey = this.getWebContext().GetPostValue("keys");
        if (StringHelper.IsNullOrEmpty((String)strKey)) {
            actionResult.setRetCode(5);
            actionResult.setErrorInfo("\u6ca1\u6709\u63d0\u4ea4\u6267\u884c\u5de5\u4f5c\u6d41\u64cd\u4f5c\u7684\u7528\u6237\u6570\u636e");
            this.Output(actionResult.ToJSONString());
            return;
        }
        WFClientAPI wfClientAPI = new WFClientAPI();
        String strWFWSUrl = this.getWebContext().getWebExConfig().GetValue("SRFDA", "WFWSURL", "");
        CallResult callResult = wfClientAPI.Init(strWFWSUrl, true);
        if (callResult == null || callResult.getRetCode() != 0) {
            this.getPage().PageLog((Object)this, 1, StringHelper.Format((String)"\u521d\u59cb\u5316\u5de5\u4f5c\u6d41WS\u94fe\u63a5\u5931\u8d25\uff0c%1$s", (Object)callResult.getErrorInfo()));
            actionResult.setRetCode(1);
            actionResult.setErrorInfo(StringHelper.Format((String)"\u521d\u59cb\u5316\u5de5\u4f5c\u6d41WS\u94fe\u63a5\u5931\u8d25\uff0c%1$s", (Object)callResult.getErrorInfo()));
            this.Output(actionResult.ToJSONString());
            return;
        }
        TreeMap<String, String> derIndexMap = null;
        if (this.getDEHelper().IsIndexDE()) {
            derIndexMap = new TreeMap<String, String>();
            Vector list = this.getDEHelper().GetDERINDEXs(true);
            for (DERINDEX derIndex : list) {
                derIndexMap.put(derIndex.getTYPEVALUE().toUpperCase(), derIndex.getDEID());
            }
        }
        String[] keys = strKey.split("[,]");
        StringBuilderEx processInfo = new StringBuilderEx();
        IDEDataCtrl deDataCtrl = null;
        DEWF lastDEWF = null;
        String strLastDataKey = "";
        this.OnBeforeIAAction();
        int i = 0;
        while (i < keys.length) {
            block26: {
                IDEHelper iDEHelper;
                String strKeyValue;
                block36: {
                    IDEFHelper stateDEFHelper;
                    String[] states;
                    BaseDataEntity realDataEntity;
                    block37: {
                        IDEFHelper wfStateDEFHelper;
                        block35: {
                            block34: {
                                WFCallResult wfCallResult;
                                BaseDataEntity dataEntity;
                                block33: {
                                    String strConnection;
                                    String strStepName;
                                    String strWFId;
                                    block32: {
                                        block31: {
                                            block30: {
                                                block29: {
                                                    block28: {
                                                        block27: {
                                                            block25: {
                                                                strKeyValue = keys[i];
                                                                dataEntity = null;
                                                                if (deDataCtrl == null) {
                                                                    deDataCtrl = this.getDEHelper().GetDEDataCtrl("", (ISRFDAWebContext)this.getWebContext());
                                                                }
                                                                if (deDataCtrl != null) break block25;
                                                                processInfo.Append("alert('\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61');\r\n", (Object)this.getDEHelper().getId());
                                                                break block26;
                                                            }
                                                            dataEntity = new BaseDataEntity();
                                                            dataEntity.SetParamValue(this.getDEHelper().GetKeyDEFHelper().getName(), this.getDEHelper().GetKeyDEFHelper().GetDEFValue(strKeyValue));
                                                            callResult = deDataCtrl.Get(dataEntity);
                                                            if (callResult.getRetCode() == 0) break block27;
                                                            processInfo.Append("alert('\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u6570\u636e[%1$s]\uff0c%2$s');\r\n", (Object)strKeyValue, (Object)callResult.getErrorInfo());
                                                            break block26;
                                                        }
                                                        iDEHelper = null;
                                                        if (derIndexMap == null) break block28;
                                                        String strIndexType = dataEntity.GetParamStringValue(this.getDEHelper().GetIndexTypeDEFHelper().getName(), "");
                                                        String strDEId = (String)derIndexMap.get(strIndexType.toUpperCase());
                                                        iDEHelper = this.getDAModelStorage().FindDEHelper(strDEId);
                                                        if (iDEHelper != null) break block29;
                                                        processInfo.Append("alert('\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u8f85\u52a9\u5bf9\u8c61');\r\n", (Object)strDEId);
                                                        break block26;
                                                    }
                                                    iDEHelper = this.getDEHelper();
                                                }
                                                strWFId = "";
                                                strStepName = this.getWebContext().GetParamValue("SRFWFPROCESSNAME");
                                                strConnection = this.getWebContext().GetParamValue("SRFWFIAACTIONNAME");
                                                this.strWFStep = this.getWebContext().getSRFWFSTEP();
                                                String[] stepParts = this.strWFStep.split("[:]");
                                                if (stepParts.length == 4 && StringHelper.Compare((String)stepParts[0], (String)"SRFWFSUBSTEP", (boolean)true) == 0) {
                                                    DESubWF deSubWF = this.getDEHelper().GetDESubWF(stepParts[2]);
                                                    if (deSubWF == null) {
                                                        processInfo.Append("alert('\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53\u5b50\u6d41\u7a0b[%1$s]');\r\n", (Object)stepParts[2]);
                                                        this.PageLog((Object)this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53\u5b50\u6d41\u7a0b[%1$s]", (Object)stepParts[2]));
                                                        return;
                                                    }
                                                    strWFId = deSubWF.getWFID();
                                                } else {
                                                    strWFId = iDEHelper.GetDEWFId(this.getWebContext().getSRFWFMode());
                                                }
                                                callResult = this.OnBeforeTestSubmitIAAction(iDEHelper, dataEntity);
                                                if (callResult.getRetCode() == 0) break block30;
                                                processInfo.Append("alert('\u65e0\u6cd5\u6267\u884c\u6d4b\u8bd5\u6267\u884c\u5de5\u4f5c\u6d41\u4ea4\u4e92\u64cd\u4f5c\uff0c%1$s');\r\n", (Object)strKeyValue, (Object)callResult.getErrorInfo());
                                                break block26;
                                            }
                                            wfCallResult = wfClientAPI.TestSubmitIAAction(strWFId, this.getWebContext().getCurUserId(), strKeyValue, "", "", iDEHelper.getId(), strStepName, strConnection, "", this.OnGetUserTag(), this.OnGetUserTag2());
                                            if (wfCallResult != null && wfCallResult.getRetCode() == 0) break block31;
                                            this.getPage().PageLog((Object)this, 1, StringHelper.Format((String)"\u6d4b\u8bd5\u5de5\u4f5c\u6d41\u4ea4\u4e92\u64cd\u4f5c\u5931\u8d25\uff0c%1$s", (Object)wfCallResult.getErrorInfo()));
                                            processInfo.Append("alert('\u6570\u636e[%1$s]\u6267\u884c\u5de5\u4f5c\u6d41\u4ea4\u4e92\u64cd\u4f5c\u5931\u8d25\uff0c%2$s');\r\n", (Object)dataEntity.GetParamStringValue(this.getDEHelper().GetMajorDEFHelper().getName(), ""), (Object)wfCallResult.getErrorInfo());
                                            break block26;
                                        }
                                        callResult = this.OnBeforeSubmitIAAction(iDEHelper, dataEntity);
                                        if (callResult.getRetCode() == 0) break block32;
                                        processInfo.Append("alert('\u65e0\u6cd5\u6267\u884c\u5de5\u4f5c\u6d41\u4ea4\u4e92\u64cd\u4f5c\uff0c%1$s');\r\n", (Object)strKeyValue, (Object)callResult.getErrorInfo());
                                        break block26;
                                    }
                                    wfCallResult = wfClientAPI.SubmitIAAction(strWFId, this.getWebContext().getCurUserId(), strKeyValue, "", "", iDEHelper.getId(), strStepName, strConnection, this.OnGetDescription(), this.OnGetUserTag(), this.OnGetUserTag2());
                                    if ((wfCallResult = this.OnAfterSubmitIAAction(wfCallResult, iDEHelper, dataEntity)) != null && wfCallResult.getRetCode() == 0) break block33;
                                    this.getPage().PageLog((Object)this, 1, StringHelper.Format((String)"\u5de5\u4f5c\u6d41\u4ea4\u4e92\u64cd\u4f5c\u5931\u8d25\uff0c%1$s", (Object)wfCallResult.getErrorInfo()));
                                    processInfo.Append("alert('\u6570\u636e[%1$s]\u6267\u884c\u5de5\u4f5c\u6d41\u4ea4\u4e92\u64cd\u4f5c\u5931\u8d25\uff0c%2$s');\r\n", (Object)dataEntity.GetParamStringValue(this.getDEHelper().GetMajorDEFHelper().getName(), ""), (Object)wfCallResult.getErrorInfo());
                                    break block26;
                                }
                                if (!StringHelper.IsNullOrEmpty((String)wfCallResult.getRunInfo())) {
                                    processInfo.Append("alert('\u6570\u636e[%1$s]\u6267\u884c\u5de5\u4f5c\u6d41\u4ea4\u4e92\u64cd\u4f5c\u5b8c\u6210! \u7cfb\u7edf\u8fd4\u56de\u4ee5\u4e0b\u4fe1\u606f:\\r\\n\\r\\n%2$s');\r\n", (Object)dataEntity.GetParamStringValue(this.getDEHelper().GetMajorDEFHelper().getName(), ""), (Object)wfCallResult.getRunInfo());
                                }
                                if (iDEHelper.GetDEWF() == null || StringHelper.IsNullOrEmpty((String)iDEHelper.GetDEWF().getWFFINISHPAGEID())) break block26;
                                realDataEntity = new BaseDataEntity();
                                realDataEntity.SetParamValue(iDEHelper.GetKeyDEFHelper().getName(), iDEHelper.GetKeyDEFHelper().GetDEFValue(strKeyValue));
                                IDEDataCtrl realDataCtrl = iDEHelper.GetDEDataCtrl("", (ISRFDAWebContext)this.getWebContext());
                                callResult = realDataCtrl.Get(realDataEntity);
                                if (callResult.getRetCode() == 0) break block34;
                                processInfo.Append("alert('\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u6570\u636e[%1$s]\uff0c%2$s');\r\n", (Object)strKeyValue, (Object)callResult.getErrorInfo());
                                break block26;
                            }
                            String strWFStateDEFId = iDEHelper.GetDEWF().getWFSTATEDEFID();
                            if (StringHelper.IsNullOrEmpty((String)strWFStateDEFId)) break block26;
                            wfStateDEFHelper = iDEHelper.GetDEFHelper(strWFStateDEFId);
                            if (wfStateDEFHelper != null) break block35;
                            callResult.setRetCode(1);
                            callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u5c5e\u6027[%2$s]\u8f85\u52a9\u5bf9\u8c61", (Object)iDEHelper.GetFullName(), (Object)strWFStateDEFId));
                            processInfo.Append("alert('%1$s');\r\n", (Object)callResult.getErrorInfo());
                            break block26;
                        }
                        if (realDataEntity.GetParamIntValue(wfStateDEFHelper.getName(), 1) != 2) break block26;
                        String strOpenPageStates = iDEHelper.GetDEWF().getOPENPAGESTATES();
                        if (StringHelper.IsNullOrEmpty((String)strOpenPageStates)) break block36;
                        states = strOpenPageStates.split("[|]");
                        String strStateDEFId = iDEHelper.GetDEWF().getSTATEDEFID();
                        if (StringHelper.IsNullOrEmpty((String)strStateDEFId)) break block36;
                        stateDEFHelper = iDEHelper.GetDEFHelper(strStateDEFId);
                        if (stateDEFHelper != null) break block37;
                        callResult.setRetCode(1);
                        callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u5c5e\u6027[%2$s]\u8f85\u52a9\u5bf9\u8c61", (Object)iDEHelper.GetFullName(), (Object)strStateDEFId));
                        processInfo.Append("alert('%1$s');\r\n", (Object)callResult.getErrorInfo());
                        break block26;
                    }
                    String strState = realDataEntity.GetParamStringValue(stateDEFHelper.getName(), "");
                    boolean bFind = false;
                    int k = 0;
                    while (k < states.length) {
                        if (StringHelper.Compare((String)strState, (String)states[k], (boolean)true) == 0) {
                            bFind = true;
                            break;
                        }
                        ++k;
                    }
                    if (!bFind) break block26;
                }
                lastDEWF = iDEHelper.GetDEWF();
                strLastDataKey = strKeyValue;
            }
            ++i;
        }
        this.OnAfterIAAction();
        if (StringHelper.IsNullOrEmpty((String)this.getPageModel())) {
            actionResult.AppendJSCode("SRFUtility.refreshpdg();");
        }
        if (lastDEWF != null && !StringHelper.IsNullOrEmpty((String)strLastDataKey)) {
            boolean bShowModal = true;
            String strURL = "";
            int nWidth = 0;
            int nHeight = 0;
            Page finishPage = this.getDAModelStorage().FindPage(lastDEWF.getWFFINISHPAGEID());
            if (finishPage == null) {
                this.PageLog((Object)this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u9875\u9762[%1$s]\u5bf9\u8c61", (Object)lastDEWF.getWFFINISHPAGEID()));
            } else {
                if (finishPage.GetParamValue("ISMODELSTYLE") != null) {
                    bShowModal = finishPage.isMODALSTYLE();
                }
                if (!StringHelper.IsNullOrEmpty((String)finishPage.GetTotalPagePath())) {
                    strURL = finishPage.GetTotalPagePath();
                }
                if (finishPage.getWIDTH() != 0) {
                    nWidth = finishPage.getWIDTH();
                }
                if (finishPage.getHEIGHT() != 0) {
                    nHeight = finishPage.getHEIGHT();
                }
                strURL = URLHelper.AppendURLSeperator((String)strURL);
                strURL = String.valueOf(strURL) + lastDEWF.getFINISHPAGEPARAM();
                strURL = String.valueOf(strURL) + URLHelper.EncodeURLParamValue((String)strLastDataKey);
                if (StringHelper.IsNullOrEmpty((String)this.getPageModel())) {
                    actionResult.AppendJSCode(BrowserJSHelper.getShowWindowScriptEx((String)("'" + strURL + "'"), null, null, (boolean)true, (int)nWidth, (int)nHeight));
                } else {
                    actionResult.AppendJSCode(RichAppJSHelper.getShowWindowScript((String)this.getPageModel(), (String)strURL, (boolean)bShowModal, (int)nWidth, (int)nHeight, (String)""));
                }
            }
        }
        actionResult.setRetCode(0);
        actionResult.AppendJSCode(processInfo.toString());
        this.Output(actionResult.ToJSONString());
    }

    protected void OnBeforeIAAction() {
    }

    protected void OnAfterIAAction() {
    }

    protected CallResult OnBeforeTestSubmitIAAction(IDEHelper iDEHelper, BaseDataEntity dataEntity) {
        return new CallResult();
    }

    protected CallResult OnBeforeSubmitIAAction(IDEHelper iDEHelper, BaseDataEntity dataEntity) {
        return new CallResult();
    }

    protected WFCallResult OnAfterSubmitIAAction(WFCallResult callResult, IDEHelper iDEHelper, BaseDataEntity dataEntity) {
        return callResult;
    }

    protected String OnGetUserTag() {
        return "";
    }

    protected String OnGetUserTag2() {
        return this.getWebContext().GetParamValue("WFSTEPACTORID");
    }

    protected String OnGetDescription() {
        return this.getWebContext().GetParamValue("WFDESC");
    }
}

