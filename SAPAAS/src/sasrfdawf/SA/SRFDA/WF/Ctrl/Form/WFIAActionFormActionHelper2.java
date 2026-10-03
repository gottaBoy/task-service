/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.DEFHelper.IDEFHelper
 *  SA.SRFDA.Ctrl.Data.DERINDEX
 *  SA.SRFDA.Ctrl.Data.DEWF
 *  SA.SRFDA.Ctrl.Data.Form
 *  SA.SRFDA.Ctrl.Data.Page
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFDA.Ctrl.IDEHelper
 *  SA.SRFDA.Web.ISRFDAWebContext
 *  SA.SRFDA.Web.Script.RichAppJSHelper
 *  SA.SRFramework.Base.XMLConfig
 *  SA.SRFramework.CodeList.CodeItemConfig
 *  SA.SRFramework.CodeList.CodeListConfig
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  SA.SRFramework.WebEx.Form.SRFExFormItemErrors
 *  SA.SRFramework.WebEx.Form.SRFExFormSaveResult
 *  SA.SRFramework.WebEx.SRFExControl
 *  SA.SRFramework.WebEx.Script.BrowserJSHelper
 *  SA.SRFramework.WebEx.Utility.URLHelper
 *  SRFWF.Client.WFCallResult
 *  SRFWF.Client.WFClientAPI
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.WF.Ctrl.Form;

import SA.SRFDA.Ctrl.DEFHelper.IDEFHelper;
import SA.SRFDA.Ctrl.Data.DERINDEX;
import SA.SRFDA.Ctrl.Data.DEWF;
import SA.SRFDA.Ctrl.Data.Form;
import SA.SRFDA.Ctrl.Data.Page;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.WF.Ctrl.Form.WFInfoFormActionHelper;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFDA.Web.Script.RichAppJSHelper;
import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.CodeList.CodeItemConfig;
import SA.SRFramework.CodeList.CodeListConfig;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.WebEx.Form.SRFExFormItemErrors;
import SA.SRFramework.WebEx.Form.SRFExFormSaveResult;
import SA.SRFramework.WebEx.SRFExControl;
import SA.SRFramework.WebEx.Script.BrowserJSHelper;
import SA.SRFramework.WebEx.Utility.URLHelper;
import SRFWF.Client.WFCallResult;
import SRFWF.Client.WFClientAPI;
import java.util.TreeMap;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class WFIAActionFormActionHelper2
extends WFInfoFormActionHelper {
    private static final Log log = LogFactory.getLog(WFIAActionFormActionHelper2.class);
    protected String strWFProcessName = "";
    protected String strWFIAActionName = "";
    String strWFStepFieldName = "";
    public static final String TAG_IADESCITEM = "FORM.IADESC.ITEM";
    public static final String TAG_IADESCFORMAT = "FORM.IADESC.FORMAT";
    public static final String TAG_IADESCACTION = "FORM.IADESC.ACTION";
    public static final String TAG_IADESCACTION_UPDATE = "UPDATE";
    public static final String TAG_IADESCACTION_RESET = "RESET";
    protected String strIADesc = "";
    protected String strWFNextStepActor = "";
    protected BaseDataEntity dataEntity = new BaseDataEntity();

    @Override
    protected boolean OnBeforeProcess() {
        boolean bProcessOK = super.OnBeforeProcess();
        if (bProcessOK) {
            this.InitDEWFKeyFields();
        }
        return bProcessOK;
    }

    protected void OnSaveActionFillForm(BaseDataEntity dataEntity) {
        this.OnReomveFormParams(this.getFormView(), dataEntity);
        super.OnSaveActionFillForm(dataEntity);
    }

    protected boolean OnSaveActionAfterFillDataEntity(BaseDataEntity dataEntity, boolean bInsert, SRFExFormItemErrors formItemErrors) {
        this.OnReomveFormParams(this.getFormView(), dataEntity);
        return super.OnSaveActionAfterFillDataEntity(dataEntity, bInsert, formItemErrors);
    }

    protected boolean OnRemoveFormParams(Form formView, BaseDataEntity backup) {
        if (formView == null || backup == null) {
            return true;
        }
        if (!StringHelper.IsNullOrEmpty((String)this.strWFStepFieldName)) {
            backup.RemoveParam(this.strWFStepFieldName);
        }
        String strIADescItem = formView.GetFormProperty(TAG_IADESCITEM, "");
        String strIADescAction = formView.GetFormProperty(TAG_IADESCACTION, "");
        if (!StringHelper.IsNullOrEmpty((String)strIADescItem)) {
            String[] items = strIADescItem.split("[|]");
            if (items.length == 1) {
                this.strIADesc = backup.GetParamStringValue(strIADescItem, "");
                if (StringHelper.Compare((String)strIADescAction, (String)TAG_IADESCACTION_RESET, (boolean)true) == 0) {
                    backup.RemoveParam(strIADescItem);
                }
            } else {
                String strIADescFormat = formView.GetFormProperty(TAG_IADESCFORMAT, "");
                if (StringHelper.IsNullOrEmpty((String)strIADescFormat)) {
                    strIADescFormat = "%1$s";
                }
                Object[] descs = new Object[items.length];
                int j = 0;
                while (j < items.length) {
                    descs[j] = backup.GetParamStringValue(items[j], "");
                    if (StringHelper.Compare((String)strIADescAction, (String)TAG_IADESCACTION_RESET, (boolean)true) == 0) {
                        backup.RemoveParam(items[j]);
                    }
                    ++j;
                }
                if (StringHelper.IsNullOrEmpty((String)this.strIADesc)) {
                    this.strIADesc = StringHelper.Format((String)strIADescFormat, (Object[])descs);
                }
            }
        }
        return true;
    }

    @Deprecated
    protected boolean OnReomveFormParams(Form formView, BaseDataEntity backup) {
        return this.OnRemoveFormParams(formView, backup);
    }

    protected CallResult OnSaveActionAfterUpdate(CallResult callResult, BaseDataEntity dataEntity) {
        callResult = super.OnSaveActionAfterUpdate(callResult, dataEntity);
        if (!StringHelper.IsNullOrEmpty((String)this.OnGetWFStepValue()) && callResult.getRetCode() == 0) {
            callResult = this.OnWFIAAction(callResult, dataEntity);
        }
        return callResult;
    }

    protected CallResult OnWFIAAction(CallResult callResult, BaseDataEntity dataEntity) {
        String strRunInfo = "";
        SRFExFormSaveResult saveResult = new SRFExFormSaveResult();
        SRFExFormItemErrors formItemErrors = new SRFExFormItemErrors();
        this.InitWFClientParams(dataEntity);
        if (StringHelper.IsNullOrEmpty((String)this.strWFProcessName) || StringHelper.IsNullOrEmpty((String)this.strWFIAActionName)) {
            return callResult;
        }
        TreeMap<String, String> derIndexMap = null;
        if (this.getPage().getDEHelper().IsIndexDE()) {
            derIndexMap = new TreeMap<String, String>();
            Vector<DERINDEX> list = this.getDEHelper().GetDERINDEXs(true);
            for (DERINDEX derIndex : list) {
                derIndexMap.put(derIndex.getTYPEVALUE().toUpperCase(), derIndex.getDEID());
            }
        }
        String strKey = dataEntity.GetParamStringValue(this.getDEHelper().GetKeyDEFHelper().getName(), "");
        String[] keys = strKey.split("[,]");
        BaseDataEntity backup = new BaseDataEntity();
        dataEntity.CopyTo(backup, true);
        StringBuilderEx processInfo = new StringBuilderEx();
        String strMajorDEFName = this.getPage().getDEHelper().GetMajorDEFHelper().getName();
        this.SetPageInfo("");
        boolean bHasError = false;
        this.OnReomveFormParams(this.getFormView(), backup);
        String strStepActor = dataEntity.GetParamStringValue("SRFFORMITEMID_WFSTEPACTOR", "");
        if (!StringHelper.IsNullOrEmpty((String)strStepActor)) {
            CodeListConfig codeListConfig = new CodeListConfig();
            XMLConfig.LoadFromXML((String)strStepActor, (XMLConfig)codeListConfig);
            if (codeListConfig.getCodeItems() != null) {
                int i = 0;
                while (i < codeListConfig.getCodeItems().size()) {
                    CodeItemConfig codeItemConfig = (CodeItemConfig)codeListConfig.getCodeItems().get(i);
                    if (!StringHelper.IsNullOrEmpty((String)this.strWFNextStepActor)) {
                        this.strWFNextStepActor = String.valueOf(this.strWFNextStepActor) + ";";
                    }
                    this.strWFNextStepActor = String.valueOf(this.strWFNextStepActor) + codeItemConfig.getValue();
                    ++i;
                }
            }
        }
        DEWF lastDEWF = null;
        String strLastDataKey = "";
        this.OnBeforeIAAction();
        int i = 0;
        while (i < keys.length) {
            block30: {
                IDEHelper iDEHelper;
                block37: {
                    IDEFHelper stateDEFHelper;
                    String[] states;
                    BaseDataEntity realDataEntity;
                    block38: {
                        IDEFHelper wfStateDEFHelper;
                        block36: {
                            block35: {
                                WFCallResult wfCallResult;
                                block34: {
                                    block33: {
                                        block32: {
                                            block31: {
                                                block29: {
                                                    dataEntity.SetParamValue(this.getPage().getDEHelper().GetKeyDEFHelper().getName(), (Object)keys[i]);
                                                    callResult = this.getDEDataCtrl().Get(dataEntity);
                                                    if (callResult.getRetCode() == 0) break block29;
                                                    bHasError = true;
                                                    processInfo.Append("alert('\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u6570\u636e[%1$s]\uff0c%2$s');\r\n", (Object)keys[i], (Object)callResult.getErrorInfo());
                                                    break block30;
                                                }
                                                iDEHelper = null;
                                                if (derIndexMap == null) break block31;
                                                String strIndexType = dataEntity.GetParamStringValue(this.getPage().getDEHelper().GetIndexTypeDEFHelper().getName(), "");
                                                String strDEId = (String)derIndexMap.get(strIndexType.toUpperCase());
                                                iDEHelper = this.getPage().getDAModelStorage().FindDEHelper(strDEId);
                                                if (iDEHelper != null) break block32;
                                                processInfo.Append("alert('\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u8f85\u52a9\u5bf9\u8c61');\r\n", (Object)strDEId);
                                                break block30;
                                            }
                                            iDEHelper = this.getDEHelper();
                                        }
                                        backup.CopyTo(dataEntity, true);
                                        dataEntity.SetParamValue(iDEHelper.GetKeyDEFHelper().getName(), (Object)keys[i]);
                                        callResult = this.OnWFIAActionBeforeUpdate(dataEntity, iDEHelper);
                                        if (callResult.getRetCode() == 0) break block33;
                                        bHasError = true;
                                        processInfo.Append("alert('\u6570\u636e[%1$s]\u6267\u884c\u5de5\u4f5c\u6d41\u4ea4\u4e92\u64cd\u4f5c\u5931\u8d25\uff0c%2$s');\r\n", (Object)dataEntity.GetParamStringValue(strMajorDEFName, ""), (Object)callResult.getErrorInfo());
                                        break block30;
                                    }
                                    callResult = this.OnWFIASaveAfterUpdate(callResult, dataEntity, iDEHelper);
                                    saveResult.From(callResult);
                                    if (saveResult.getRetCode() == 0) break block34;
                                    bHasError = true;
                                    processInfo.Append("alert('\u6570\u636e[%1$s]\u6267\u884c\u5de5\u4f5c\u6d41\u4ea4\u4e92\u64cd\u4f5c\u5931\u8d25\uff0c%2$s');\r\n", (Object)dataEntity.GetParamStringValue(strMajorDEFName, ""), (Object)callResult.getErrorInfo());
                                    break block30;
                                }
                                if (callResult.getUserObject() != null && callResult.getUserObject() instanceof WFCallResult && !StringHelper.IsNullOrEmpty((String)(strRunInfo = (wfCallResult = (WFCallResult)callResult.getUserObject()).getRunInfo()))) {
                                    processInfo.Append("alert('\u6570\u636e[%1$s]\u6267\u884c\u5de5\u4f5c\u6d41\u4ea4\u4e92\u64cd\u4f5c\u5b8c\u6210! \u7cfb\u7edf\u8fd4\u56de\u4ee5\u4e0b\u4fe1\u606f:\\r\\n\\r\\n%2$s');\r\n", (Object)dataEntity.GetParamStringValue(strMajorDEFName, ""), (Object)strRunInfo);
                                }
                                if (iDEHelper.GetDEWF() == null || StringHelper.IsNullOrEmpty((String)iDEHelper.GetDEWF().getWFFINISHPAGEID())) break block30;
                                realDataEntity = iDEHelper.CreateDEObject();
                                realDataEntity.SetParamValue(iDEHelper.GetKeyDEFHelper().getName(), iDEHelper.GetKeyDEFHelper().GetDEFValue(keys[i]));
                                IDEDataCtrl realDataCtrl = iDEHelper.GetDEDataCtrl("", (ISRFDAWebContext)this.getWebContext());
                                callResult = realDataCtrl.Get(realDataEntity);
                                if (callResult.getRetCode() == 0) break block35;
                                processInfo.Append("alert('\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u6570\u636e[%1$s]\uff0c%2$s');\r\n", (Object)keys[i], (Object)callResult.getErrorInfo());
                                break block30;
                            }
                            String strWFStateDEFId = iDEHelper.GetDEWF().getWFSTATEDEFID();
                            if (StringHelper.IsNullOrEmpty((String)strWFStateDEFId)) break block30;
                            wfStateDEFHelper = iDEHelper.GetDEFHelper(strWFStateDEFId);
                            if (wfStateDEFHelper != null) break block36;
                            callResult.setRetCode(1);
                            callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u5c5e\u6027[%2$s]\u8f85\u52a9\u5bf9\u8c61", (Object)iDEHelper.GetFullName(), (Object)strWFStateDEFId));
                            processInfo.Append("alert('%1$s');\r\n", (Object)callResult.getErrorInfo());
                            break block30;
                        }
                        if (realDataEntity.GetParamIntValue(wfStateDEFHelper.getName(), 1) != 2) break block30;
                        String strOpenPageStates = iDEHelper.GetDEWF().getOPENPAGESTATES();
                        if (StringHelper.IsNullOrEmpty((String)strOpenPageStates)) break block37;
                        states = strOpenPageStates.split("[|]");
                        String strStateDEFId = iDEHelper.GetDEWF().getSTATEDEFID();
                        if (StringHelper.IsNullOrEmpty((String)strStateDEFId)) break block37;
                        stateDEFHelper = iDEHelper.GetDEFHelper(strStateDEFId);
                        if (stateDEFHelper != null) break block38;
                        callResult.setRetCode(1);
                        callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u5c5e\u6027[%2$s]\u8f85\u52a9\u5bf9\u8c61", (Object)iDEHelper.GetFullName(), (Object)strStateDEFId));
                        processInfo.Append("alert('%1$s');\r\n", (Object)callResult.getErrorInfo());
                        break block30;
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
                    if (!bFind) break block30;
                }
                lastDEWF = iDEHelper.GetDEWF();
                strLastDataKey = keys[i];
            }
            ++i;
        }
        this.OnAfterIAAction();
        if (bHasError) {
            saveResult.setRetCode(5);
            saveResult.setErrorInfo("\u6267\u884c\u5de5\u4f5c\u6d41\u4ea4\u4e92\u64cd\u4f5c\u51fa\u73b0\u9519\u8bef");
            saveResult.AppendJSCode(processInfo.toString());
        } else {
            saveResult.AppendJSCode(processInfo.toString());
            if (keys.length == 1) {
                this.form1.FillValueJSON(saveResult.getItems(), this.getPage().isControlValueFromUniqueId());
            }
            if (keys.length == 1) {
                saveResult.AppendJSCode(WFIAActionFormActionHelper2.GetSetPageDataJS((String)this.getPage().getDEHelper().GetDataInfo(dataEntity)));
            }
            saveResult.setRetCode(0);
            saveResult.setSaveTag(this.getWebContext().GetPostValue("SRFSAVETAG"));
            if (StringHelper.IsNullOrEmpty((String)this.getPage().getPageModel())) {
                saveResult.AppendJSCode("SRFUtility.refreshpdg();");
                saveResult.AppendJSCode(BrowserJSHelper.getResetDialogReturnValue());
                saveResult.AppendJSCode(BrowserJSHelper.getSetDialogReturnValue((String)"ret", (String)"'ok'"));
                saveResult.AppendJSCode(BrowserJSHelper.getCloseWindowScript());
            } else {
                saveResult.AppendJSCode(RichAppJSHelper.getSetDialogResult((String)this.getPage().getPageModel(), (String)"OK"));
                saveResult.AppendJSCode(RichAppJSHelper.getCloseWindowScript((String)this.getPage().getPageModel()));
            }
            if (lastDEWF != null && !StringHelper.IsNullOrEmpty((String)strLastDataKey)) {
                boolean bShowModal = true;
                String strURL = "";
                int nWidth = 0;
                int nHeight = 0;
                Page finishPage = this.getPage().getDAModelStorage().FindPage(lastDEWF.getWFFINISHPAGEID());
                if (finishPage == null) {
                    this.getPage().PageLog((Object)this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u9875\u9762[%1$s]\u5bf9\u8c61", (Object)lastDEWF.getWFFINISHPAGEID()));
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
                    if (StringHelper.IsNullOrEmpty((String)this.getPage().getPageModel())) {
                        saveResult.AppendJSCode(BrowserJSHelper.getShowWindowScriptEx((String)("'" + strURL + "'"), null, null, (boolean)true, (int)nWidth, (int)nHeight));
                    } else {
                        saveResult.AppendJSCode(RichAppJSHelper.getShowWindowScript((String)this.getPage().getPageModel(), (String)strURL, (boolean)bShowModal, (int)nWidth, (int)nHeight, (String)""));
                    }
                }
            }
        }
        return callResult;
    }

    protected CallResult OnWFIAActionBeforeUpdate(BaseDataEntity dataEntity, IDEHelper iDEHelper) {
        WFClientAPI wfClientAPI = new WFClientAPI();
        CallResult callResult = this.OnBeforeTestSubmitIAAction(iDEHelper, dataEntity);
        if (callResult == null || callResult.getRetCode() != 0) {
            this.getPage().PageLog((Object)this, 1, StringHelper.Format((String)"\u68c0\u67e5\u662f\u5426\u8fdb\u884c\u5de5\u4f5c\u6d41\u4ea4\u4e92\u6d4b\u8bd5\u5931\u8d25\uff0c%1$s", (Object)callResult.getErrorInfo()));
            return callResult;
        }
        String strWFWSUrl = this.getWebContext().getWebExConfig().GetValue("SRFDA", "WFWSURL", "");
        callResult = wfClientAPI.Init(strWFWSUrl, true);
        if (callResult == null || callResult.getRetCode() != 0) {
            this.getPage().PageLog((Object)this, 1, StringHelper.Format((String)"\u521d\u59cb\u5316\u5de5\u4f5c\u6d41WS\u94fe\u63a5\u5931\u8d25\uff0c%1$s", (Object)callResult.getErrorInfo()));
            return callResult;
        }
        String strWFId = iDEHelper.GetDEWFId(this.getWebContext().getSRFWFMode());
        String strKeyValue = dataEntity.GetParamStringValue(iDEHelper.GetKeyDEFHelper().getName(), "");
        WFCallResult wfCallResult = wfClientAPI.TestSubmitIAAction(strWFId, this.getWebContext().getCurUserId(), strKeyValue, "", "", iDEHelper.getId(), this.strWFProcessName, this.strWFIAActionName, "", this.OnGetUserTag(), this.OnGetUserTag2());
        if (wfCallResult == null || wfCallResult.getRetCode() != 0) {
            this.getPage().PageLog((Object)this, 1, StringHelper.Format((String)"\u6d4b\u8bd5\u5de5\u4f5c\u6d41\u4ea4\u4e92\u64cd\u4f5c\u5931\u8d25\uff0c%1$s", (Object)wfCallResult.getErrorInfo()));
            return wfCallResult;
        }
        return callResult;
    }

    protected CallResult OnWFIASaveAfterUpdate(CallResult callResult, BaseDataEntity dataEntity, IDEHelper iDEHelper) {
        WFClientAPI wfClientAPI = new WFClientAPI();
        callResult = this.OnBeforeSubmitIAAction(iDEHelper, dataEntity);
        if (callResult == null || callResult.getRetCode() != 0) {
            this.getPage().PageLog((Object)this, 1, StringHelper.Format((String)"\u68c0\u67e5\u662f\u5426\u8fdb\u884c\u5de5\u4f5c\u6d41\u4ea4\u4e92\u5931\u8d25\uff0c%1$s", (Object)callResult.getErrorInfo()));
            return callResult;
        }
        String strWFWSUrl = this.getWebContext().getWebExConfig().GetValue("SRFDA", "WFWSURL", "");
        callResult = wfClientAPI.Init(strWFWSUrl, true);
        if (callResult == null || callResult.getRetCode() != 0) {
            this.getPage().PageLog((Object)this, 1, StringHelper.Format((String)"\u521d\u59cb\u5316\u5de5\u4f5c\u6d41WS\u94fe\u63a5\u5931\u8d25\uff0c%1$s", (Object)callResult.getErrorInfo()));
            return callResult;
        }
        String strWFId = iDEHelper.GetDEWFId(this.getWebContext().getSRFWFMode());
        String strKeyValue = dataEntity.GetParamStringValue(iDEHelper.GetKeyDEFHelper().getName(), "");
        WFCallResult wfCallResult = wfClientAPI.SubmitIAAction(strWFId, this.getWebContext().getCurUserId(), strKeyValue, "", "", iDEHelper.getId(), this.strWFProcessName, this.strWFIAActionName, this.OnGetDescription(), this.OnGetUserTag(), this.OnGetUserTag2());
        if ((wfCallResult = this.OnAfterSubmitIAAction(wfCallResult, iDEHelper, dataEntity)) == null || wfCallResult.getRetCode() != 0) {
            this.getPage().PageLog((Object)this, 1, StringHelper.Format((String)"\u5de5\u4f5c\u6d41\u4ea4\u4e92\u64cd\u4f5c\u5931\u8d25\uff0c%1$s", (Object)wfCallResult.getErrorInfo()));
            return wfCallResult;
        }
        callResult.setUserObject((Object)wfCallResult);
        return callResult;
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

    protected void OnBeforeIAAction() {
    }

    protected void OnAfterIAAction() {
    }

    @Override
    protected String OnGetUserTag2() {
        return this.getPage().getRequest().getParameter("WFSTEPACTORID".toLowerCase());
    }

    protected String OnGetDescription() {
        return this.strIADesc;
    }

    protected String OnGetWFStepValue() {
        return this.getWebContext().GetParamValue("SRFWFSTEP");
    }

    protected IDEHelper getDEHelper() {
        IDEHelper iDEHelper = this.getPage().getDEHelper();
        return iDEHelper;
    }

    protected void InitDEWFKeyFields() {
        IDEHelper iDEHelper = this.getDEHelper();
        if (iDEHelper == null || !iDEHelper.IsEnableWF()) {
            this.getPage().PageLog((Object)this, 1, "\u5b9e\u4f53\u672a\u542f\u7528\u5de5\u4f5c\u6d41\uff01");
            return;
        }
        String strWFStepFieldId = iDEHelper.GetDEWF().getWFSTEPDEFID();
        if (StringHelper.IsNullOrEmpty((String)strWFStepFieldId)) {
            this.getPage().PageLog((Object)this, 1, "\u83b7\u53d6\u5de5\u4f5c\u6d41\u6b65\u9aa4\u5c5e\u6027\u6807\u8bc6\u5931\u8d25\uff01");
            return;
        }
        IDEFHelper iDEFHelper = iDEHelper.GetDEFHelper(strWFStepFieldId);
        if (iDEFHelper != null) {
            this.strWFStepFieldName = iDEFHelper.getDEField().getDEFNAME();
        }
        if (StringHelper.IsNullOrEmpty((String)this.strWFStepFieldName)) {
            this.getPage().PageLog((Object)this, 1, "\u83b7\u53d6\u5de5\u4f5c\u6d41\u6b65\u9aa4\u5c5e\u6027\u6807\u8bc6\u540d\u79f0\u5931\u8d25\uff01");
            return;
        }
    }

    protected void InitWFClientParams(BaseDataEntity baseDataEntity) {
        SRFExControl wfstepControl = this.form1.FindControl(this.strWFStepFieldName);
        if (wfstepControl == null) {
            this.getPage().PageLog((Object)this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5de5\u4f5c\u6d41\u6b65\u9aa4\u8868\u5355\u9879[%1$s]\uff01", (Object)this.strWFStepFieldName));
            return;
        }
        String strNextStepValue = this.getPage().getRequest().getParameter(wfstepControl.getUniqueID());
        String strCurStepValue = this.getWebContext().GetParamValue("SRFWFSTEP");
        if (StringHelper.IsNullOrEmpty((String)strNextStepValue) || StringHelper.IsNullOrEmpty((String)strCurStepValue) || StringHelper.Compare((String)strNextStepValue, (String)strCurStepValue, (boolean)true) == 0) {
            return;
        }
        this.strWFProcessName = this.getWebContext().GetParamValue("WFPROCESSNAME");
        this.strWFIAActionName = strNextStepValue;
    }
}

