/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.DEFHelper.IDEFHelper
 *  SA.SRFDA.Ctrl.Data.DERINDEX
 *  SA.SRFDA.Ctrl.Data.DESubWF
 *  SA.SRFDA.Ctrl.Data.DEWF
 *  SA.SRFDA.Ctrl.Data.Form
 *  SA.SRFDA.Ctrl.Data.Page
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFDA.Ctrl.IDEHelper
 *  SA.SRFDA.Web.IFormViewPage
 *  SA.SRFDA.Web.ISRFDAPage
 *  SA.SRFDA.Web.ISRFDAWebContext
 *  SA.SRFDA.Web.SRFDAPage
 *  SA.SRFDA.Web.SRFDAWebCTXHelper
 *  SA.SRFDA.Web.SRFDAWebContext
 *  SA.SRFDA.Web.Script.RichAppJSHelper
 *  SA.SRFramework.Base.XMLConfig
 *  SA.SRFramework.CodeList.CodeItemConfig
 *  SA.SRFramework.CodeList.CodeListConfig
 *  SA.SRFramework.Data.DBResult
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  SA.SRFramework.WebEx.DP.SRFExDPEx
 *  SA.SRFramework.WebEx.Form.SRFExForm
 *  SA.SRFramework.WebEx.Form.SRFExFormActionHelper
 *  SA.SRFramework.WebEx.Form.SRFExFormItemErrors
 *  SA.SRFramework.WebEx.Form.SRFExFormLoadResult
 *  SA.SRFramework.WebEx.Form.SRFExFormSaveResult
 *  SA.SRFramework.WebEx.SRFExControl
 *  SA.SRFramework.WebEx.SRFExFormItem
 *  SA.SRFramework.WebEx.Script.BrowserJSHelper
 *  SA.SRFramework.WebEx.Utility.URLHelper
 *  SRFWF.Client.WFCallResult
 *  SRFWF.Client.WFClientAPI
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.WF.Ctrl.Form;

import SA.SRFDA.Ctrl.DEFHelper.IDEFHelper;
import SA.SRFDA.Ctrl.Data.DERINDEX;
import SA.SRFDA.Ctrl.Data.DESubWF;
import SA.SRFDA.Ctrl.Data.DEWF;
import SA.SRFDA.Ctrl.Data.Form;
import SA.SRFDA.Ctrl.Data.Page;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Web.IFormViewPage;
import SA.SRFDA.Web.ISRFDAPage;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFDA.Web.SRFDAPage;
import SA.SRFDA.Web.SRFDAWebCTXHelper;
import SA.SRFDA.Web.SRFDAWebContext;
import SA.SRFDA.Web.Script.RichAppJSHelper;
import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.CodeList.CodeItemConfig;
import SA.SRFramework.CodeList.CodeListConfig;
import SA.SRFramework.Data.DBResult;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.WebEx.DP.SRFExDPEx;
import SA.SRFramework.WebEx.Form.SRFExForm;
import SA.SRFramework.WebEx.Form.SRFExFormActionHelper;
import SA.SRFramework.WebEx.Form.SRFExFormItemErrors;
import SA.SRFramework.WebEx.Form.SRFExFormLoadResult;
import SA.SRFramework.WebEx.Form.SRFExFormSaveResult;
import SA.SRFramework.WebEx.SRFExControl;
import SA.SRFramework.WebEx.SRFExFormItem;
import SA.SRFramework.WebEx.Script.BrowserJSHelper;
import SA.SRFramework.WebEx.Utility.URLHelper;
import SRFWF.Client.WFCallResult;
import SRFWF.Client.WFClientAPI;
import java.util.TreeMap;
import java.util.Vector;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class WFIAActionFormActionHelper
extends SRFExFormActionHelper {
    protected Form formView = null;
    protected SRFExDPEx mainPanel = null;
    private static final Log log = LogFactory.getLog(WFIAActionFormActionHelper.class);
    protected Vector<String> disableItems = null;
    protected SRFExForm form1 = null;
    protected String strPageInfo = "";
    protected IFormViewPage iFormViewPage = null;
    public static final String TAG_IADESCITEM = "FORM.IADESC.ITEM";
    public static final String TAG_IADESCFORMAT = "FORM.IADESC.FORMAT";
    public static final String TAG_IADESCACTION = "FORM.IADESC.ACTION";
    public static final String TAG_IADESCACTION_UPDATE = "UPDATE";
    public static final String TAG_IADESCACTION_RESET = "RESET";
    protected String strIADesc = "";
    protected String strWFNextStepActor = "";
    protected DESubWF deSubWF = null;
    protected String strDESubWFId = "";
    protected String strSubWFStep = "";

    protected boolean OnBeforeProcess() {
        if (super.OnBeforeProcess()) {
            this.form1 = this.getForm();
            SRFExControl contorl = this.form1.getMainPanel();
            if (contorl != null && contorl instanceof SRFExDPEx) {
                this.mainPanel = (SRFExDPEx)contorl;
            }
            if (this.mainPanel == null) {
                return false;
            }
            String strKeyName = this.getPage().getDEHelper().GetKeyDEFHelper().getName();
            SRFExControl keyControl = this.form1.FindControl(strKeyName);
            if (keyControl != null && keyControl instanceof SRFExFormItem) {
                ((SRFExFormItem)keyControl).getFormItemConfig().setDataType(25);
                ((SRFExFormItem)keyControl).getFormItemConfig().setMaxLength(65536);
            }
            if (this.getPage() instanceof IFormViewPage) {
                this.iFormViewPage = (IFormViewPage)this.getPage();
            }
            this.strDESubWFId = SRFDAWebCTXHelper.GetDESubWFId((ISRFDAWebContext)this.getWebContext());
            if (!StringHelper.IsNullOrEmpty((String)this.strDESubWFId)) {
                this.deSubWF = this.getPage().getDEHelper().GetDESubWF(this.strDESubWFId);
                if (this.deSubWF == null) {
                    this.getPage().PageLog((Object)this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53\u5e76\u884c\u5b50\u6d41\u7a0b[%1$s]", (Object)this.strDESubWFId));
                    return false;
                }
                this.strSubWFStep = SRFDAWebCTXHelper.GetWFSubStep((ISRFDAWebContext)this.getWebContext());
            }
            return true;
        }
        return false;
    }

    protected boolean OnLoadAction() {
        SRFExFormLoadResult loadResult = new SRFExFormLoadResult();
        SRFExFormItemErrors formItemErrors = new SRFExFormItemErrors();
        BaseDataEntity dataEntity = this.CreateFormDataEntity();
        if (!this.form1.FillDataEntity(dataEntity, true, formItemErrors, this.getPage().isControlValueFromUniqueId())) {
            loadResult.setRetCode(4);
            loadResult.setJSCode("alert('\u6ca1\u6709\u6307\u5b9a\u6570\u636e\u952e\u503c');");
            loadResult.AppendJSCode(WFIAActionFormActionHelper.GetSetPageDataJS((ISRFDAPage)this.getPage(), ""));
            loadResult.AppendJSCode(WFIAActionFormActionHelper.GetSetPageInfoJS((ISRFDAPage)this.getPage(), "\u6ca1\u6709\u6307\u5b9a\u6570\u636e\u952e\u503c"));
            this.getPage().Output(loadResult.ToJSONString());
            return true;
        }
        String strKey = dataEntity.GetParamStringValue(this.getPage().getDEHelper().GetKeyDEFHelper().getName(), "");
        String[] keys = strKey.split("[,]");
        if (keys.length == 1) {
            CallResult callResult = null;
            callResult = this.formView == null || StringHelper.IsNullOrEmpty((String)this.formView.getGETMODE()) ? this.getDEDataCtrl().Get(dataEntity) : this.getDEDataCtrl().Get(this.formView.getGETMODE(), dataEntity);
            if (callResult.getRetCode() != 0) {
                if (callResult.getRetCode() == 3 && this.getPage().getPageParam("EMBEDEDIT", false)) {
                    return this.OnLoadDefaultAction();
                }
                if (callResult.IsUserError()) {
                    callResult.setRetCode(5);
                    formItemErrors.FillJSONs(loadResult.getItems());
                }
                loadResult.From(callResult);
                loadResult.AppendJSCode(WFIAActionFormActionHelper.GetSetPageDataJS((ISRFDAPage)this.getPage(), ""));
                loadResult.AppendJSCode(WFIAActionFormActionHelper.GetSetPageInfoJS((ISRFDAPage)this.getPage(), "\u6570\u636e\u67e5\u8be2\u5931\u8d25"));
                this.getPage().Output(loadResult.ToJSONString());
                return true;
            }
        }
        this.OnLoadActionFillForm(dataEntity);
        if (this.disableItems != null) {
            for (String strFormItemId : this.disableItems) {
                this.form1.EnableFormItem(strFormItemId, false);
            }
        }
        this.form1.FillValueJSON(loadResult.getItems(), this.getPage().isControlValueFromUniqueId());
        if (keys.length == 1) {
            loadResult.AppendJSCode(WFIAActionFormActionHelper.GetSetPageDataJS((ISRFDAPage)this.getPage(), this.getPage().getDEHelper().GetDataInfo(dataEntity)));
        } else {
            loadResult.AppendJSCode(WFIAActionFormActionHelper.GetSetPageDataJS((ISRFDAPage)this.getPage(), "\u591a\u9879\u6570\u636e\u6a21\u5f0f"));
        }
        loadResult.setFormState(this.GetFormState(true, dataEntity));
        loadResult.setUpdateFlag(true);
        this.getPage().Output(loadResult.ToJSONString());
        return true;
    }

    protected void OnLoadActionFillForm(BaseDataEntity dataEntity) {
        this.form1.FillDataEntityDV(dataEntity, true);
        if (this.getWebContext().getCopyMode()) {
            for (IDEFHelper iDEFHelper : this.getPage().getDEHelper().GetDEFHelpers()) {
                if (!iDEFHelper.IsPasteReset()) continue;
                dataEntity.RemoveParam(iDEFHelper.getName());
            }
        }
        this.form1.FillByDataEntity(dataEntity, this.getWebContext().getCopyMode());
        this.form1.EnableFormItems(this.getWebContext().getCopyMode());
    }

    protected boolean OnSaveAction() {
        String strStepActor;
        String strRunInfo = "";
        SRFExFormSaveResult saveResult = new SRFExFormSaveResult();
        CallResult callResult = null;
        SRFExFormItemErrors formItemErrors = new SRFExFormItemErrors();
        BaseDataEntity dataEntity = this.CreateFormDataEntity();
        this.OnSaveActionBeforeFillDataEntity(dataEntity);
        if (!this.OnSaveActionFillDataEntity(dataEntity, formItemErrors)) {
            saveResult.setRetCode(5);
            formItemErrors.FillJSONs(saveResult.getItems());
            saveResult.AppendJSCode(WFIAActionFormActionHelper.GetSetPageInfoJS((ISRFDAPage)this.getPage(), "\u8f93\u5165\u6709\u8bef\uff0c\u6570\u636e\u65e0\u6cd5\u66f4\u65b0!"));
            this.getPage().Output(saveResult.ToJSONString());
            return true;
        }
        TreeMap<String, String> derIndexMap = null;
        if (this.getPage().getDEHelper().IsIndexDE()) {
            derIndexMap = new TreeMap<String, String>();
            Vector<DERINDEX> list = this.getPage().getDEHelper().GetDERINDEXs(true);
            for (DERINDEX derIndex : list) {
                derIndexMap.put(derIndex.getTYPEVALUE().toUpperCase(), derIndex.getDEID());
            }
        }
        String strKey = dataEntity.GetParamStringValue(this.getPage().getDEHelper().GetKeyDEFHelper().getName(), "");
        String[] keys = strKey.split("[,]");
        BaseDataEntity backup = new BaseDataEntity();
        dataEntity.CopyTo(backup, true);
        StringBuilderEx processInfo = new StringBuilderEx();
        String strMajorDEFName = this.getPage().getDEHelper().GetMajorDEFHelper().getName();
        this.SetPageInfo("");
        boolean bHasError = false;
        Form formView = this.getFormView();
        if (formView != null) {
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
                    this.strIADesc = StringHelper.Format((String)strIADescFormat, (Object[])descs);
                }
            }
        }
        if (!StringHelper.IsNullOrEmpty((String)(strStepActor = dataEntity.GetParamStringValue("SRFFORMITEMID_WFSTEPACTOR", "")))) {
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
            block42: {
                IDEHelper iDEHelper;
                block50: {
                    IDEFHelper stateDEFHelper;
                    String[] states;
                    BaseDataEntity realDataEntity;
                    block51: {
                        IDEFHelper wfStateDEFHelper;
                        block49: {
                            block48: {
                                WFCallResult wfCallResult;
                                block47: {
                                    block46: {
                                        block45: {
                                            block44: {
                                                block43: {
                                                    block41: {
                                                        dataEntity.SetParamValue(this.getPage().getDEHelper().GetKeyDEFHelper().getName(), (Object)keys[i]);
                                                        callResult = this.getDEDataCtrl().Get(dataEntity);
                                                        if (callResult.getRetCode() == 0) break block41;
                                                        bHasError = true;
                                                        processInfo.Append("alert('\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u6570\u636e[%1$s]\uff0c%2$s');\r\n", (Object)keys[i], (Object)callResult.getErrorInfo());
                                                        break block42;
                                                    }
                                                    iDEHelper = null;
                                                    if (derIndexMap == null) break block43;
                                                    String strIndexType = dataEntity.GetParamStringValue(this.getPage().getDEHelper().GetIndexTypeDEFHelper().getName(), "");
                                                    String strDEId = (String)derIndexMap.get(strIndexType.toUpperCase());
                                                    iDEHelper = this.getPage().getDAModelStorage().FindDEHelper(strDEId);
                                                    if (iDEHelper != null) break block44;
                                                    processInfo.Append("alert('\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u8f85\u52a9\u5bf9\u8c61');\r\n", (Object)strDEId);
                                                    break block42;
                                                }
                                                iDEHelper = this.getPage().getDEHelper();
                                            }
                                            backup.CopyTo(dataEntity, true);
                                            dataEntity.SetParamValue(iDEHelper.GetKeyDEFHelper().getName(), (Object)keys[i]);
                                            callResult = this.OnSaveActionBeforeUpdate(dataEntity, iDEHelper);
                                            if (callResult.getRetCode() == 0) break block45;
                                            bHasError = true;
                                            processInfo.Append("alert('\u6570\u636e[%1$s]\u6267\u884c\u5de5\u4f5c\u6d41\u4ea4\u4e92\u64cd\u4f5c\u5931\u8d25\uff0c%2$s');\r\n", (Object)dataEntity.GetParamStringValue(strMajorDEFName, ""), (Object)callResult.getErrorInfo());
                                            break block42;
                                        }
                                        callResult = iDEHelper == this.getPage().getDEHelper() ? this.getDEDataCtrl().Save(false, dataEntity) : iDEHelper.GetDEDataCtrl(this.getWebContext().getCurUserId(), (ISRFDAWebContext)this.getWebContext()).Save(false, dataEntity);
                                        saveResult.From(callResult);
                                        if (saveResult.getRetCode() == 0) break block46;
                                        if (callResult.IsUserError()) {
                                            this.FillFormUserErrors(this.form1, formItemErrors, callResult);
                                            saveResult.setRetCode(5);
                                            formItemErrors.FillJSONs(saveResult.getItems());
                                            bHasError = true;
                                            processInfo.Append("alert('\u6570\u636e[%1$s]\u6267\u884c\u5de5\u4f5c\u6d41\u4ea4\u4e92\u64cd\u4f5c\u5931\u8d25\uff0c%2$s');\r\n", (Object)dataEntity.GetParamStringValue(strMajorDEFName, ""), (Object)callResult.getErrorInfo());
                                        } else {
                                            bHasError = true;
                                            processInfo.Append("alert('\u6570\u636e[%1$s]\u6267\u884c\u5de5\u4f5c\u6d41\u4ea4\u4e92\u64cd\u4f5c\u5931\u8d25\uff0c%2$s');\r\n", (Object)dataEntity.GetParamStringValue(strMajorDEFName, ""), (Object)callResult.getErrorInfo());
                                        }
                                        break block42;
                                    }
                                    callResult = this.OnSaveActionAfterUpdate(callResult, dataEntity, iDEHelper);
                                    saveResult.From(callResult);
                                    if (saveResult.getRetCode() == 0) break block47;
                                    bHasError = true;
                                    processInfo.Append("alert('\u6570\u636e[%1$s]\u6267\u884c\u5de5\u4f5c\u6d41\u4ea4\u4e92\u64cd\u4f5c\u5931\u8d25\uff0c%2$s');\r\n", (Object)dataEntity.GetParamStringValue(strMajorDEFName, ""), (Object)callResult.getErrorInfo());
                                    break block42;
                                }
                                if (callResult.getUserObject() != null && callResult.getUserObject() instanceof WFCallResult && !StringHelper.IsNullOrEmpty((String)(strRunInfo = (wfCallResult = (WFCallResult)callResult.getUserObject()).getRunInfo()))) {
                                    processInfo.Append("alert('\u6570\u636e[%1$s]\u6267\u884c\u5de5\u4f5c\u6d41\u4ea4\u4e92\u64cd\u4f5c\u5b8c\u6210! \u7cfb\u7edf\u8fd4\u56de\u4ee5\u4e0b\u4fe1\u606f:\\r\\n\\r\\n%2$s');\r\n", (Object)dataEntity.GetParamStringValue(strMajorDEFName, ""), (Object)strRunInfo);
                                }
                                if (iDEHelper.GetDEWF() == null || StringHelper.IsNullOrEmpty((String)iDEHelper.GetDEWF().getWFFINISHPAGEID())) break block42;
                                realDataEntity = iDEHelper.CreateDEObject();
                                realDataEntity.SetParamValue(iDEHelper.GetKeyDEFHelper().getName(), iDEHelper.GetKeyDEFHelper().GetDEFValue(keys[i]));
                                IDEDataCtrl realDataCtrl = iDEHelper.GetDEDataCtrl("", (ISRFDAWebContext)this.getWebContext());
                                callResult = realDataCtrl.Get(realDataEntity);
                                if (callResult.getRetCode() == 0) break block48;
                                processInfo.Append("alert('\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u6570\u636e[%1$s]\uff0c%2$s');\r\n", (Object)keys[i], (Object)callResult.getErrorInfo());
                                break block42;
                            }
                            String strWFStateDEFId = iDEHelper.GetDEWF().getWFSTATEDEFID();
                            if (StringHelper.IsNullOrEmpty((String)strWFStateDEFId)) break block42;
                            wfStateDEFHelper = iDEHelper.GetDEFHelper(strWFStateDEFId);
                            if (wfStateDEFHelper != null) break block49;
                            callResult.setRetCode(1);
                            callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u5c5e\u6027[%2$s]\u8f85\u52a9\u5bf9\u8c61", (Object)iDEHelper.GetFullName(), (Object)strWFStateDEFId));
                            processInfo.Append("alert('%1$s');\r\n", (Object)callResult.getErrorInfo());
                            break block42;
                        }
                        if (realDataEntity.GetParamIntValue(wfStateDEFHelper.getName(), 1) != 2) break block42;
                        String strOpenPageStates = iDEHelper.GetDEWF().getOPENPAGESTATES();
                        if (StringHelper.IsNullOrEmpty((String)strOpenPageStates)) break block50;
                        states = strOpenPageStates.split("[|]");
                        String strStateDEFId = iDEHelper.GetDEWF().getSTATEDEFID();
                        if (StringHelper.IsNullOrEmpty((String)strStateDEFId)) break block50;
                        stateDEFHelper = iDEHelper.GetDEFHelper(strStateDEFId);
                        if (stateDEFHelper != null) break block51;
                        callResult.setRetCode(1);
                        callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u5c5e\u6027[%2$s]\u8f85\u52a9\u5bf9\u8c61", (Object)iDEHelper.GetFullName(), (Object)strStateDEFId));
                        processInfo.Append("alert('%1$s');\r\n", (Object)callResult.getErrorInfo());
                        break block42;
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
                    if (!bFind) break block42;
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
                this.OnSaveActionFillForm(dataEntity);
                this.form1.FillValueJSON(saveResult.getItems(), this.getPage().isControlValueFromUniqueId());
            }
            if (keys.length == 1) {
                saveResult.AppendJSCode(WFIAActionFormActionHelper.GetSetPageDataJS((ISRFDAPage)this.getPage(), this.getPage().getDEHelper().GetDataInfo(dataEntity)));
            } else {
                saveResult.AppendJSCode(WFIAActionFormActionHelper.GetSetPageDataJS((ISRFDAPage)this.getPage(), "\u591a\u9879\u6570\u636e\u6a21\u5f0f"));
            }
            saveResult.setUpdateFlag(true);
            saveResult.setRetCode(0);
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
        this.getPage().Output(this.OnSaveActionOutputResult(saveResult));
        return true;
    }

    protected void OnSaveActionFillForm(BaseDataEntity dataEntity) {
        this.form1.FillByDataEntity(dataEntity, this.getWebContext().getCopyMode());
        this.form1.EnableFormItems(this.getWebContext().getCopyMode());
    }

    protected void OnSaveActionBeforeFillDataEntity(BaseDataEntity dataEntity) {
    }

    protected boolean IsFormContainKey(BaseDataEntity dataEntity) {
        return this.getForm().IsContainerKeyValue(dataEntity);
    }

    protected boolean OnSaveActionFillDataEntity(BaseDataEntity dataEntity, SRFExFormItemErrors formItemErrors) {
        return this.getForm().FillDataEntity(dataEntity, false, formItemErrors);
    }

    protected CallResult OnSaveActionBeforeUpdate(BaseDataEntity dataEntity, IDEHelper iDEHelper) {
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
        String strStepName = this.getWebContext().GetParamValue("SRFWFPROCESSNAME");
        String strConnection = this.getWebContext().GetParamValue("SRFWFIAACTIONNAME");
        if (this.deSubWF == null) {
            WFCallResult wfCallResult = wfClientAPI.TestSubmitIAAction(strWFId, this.getWebContext().getCurUserId(), strKeyValue, "", "", iDEHelper.getId(), strStepName, strConnection, "", this.OnGetUserTag(), this.OnGetUserTag2());
            if (wfCallResult == null || wfCallResult.getRetCode() != 0) {
                this.getPage().PageLog((Object)this, 1, StringHelper.Format((String)"\u6d4b\u8bd5\u5de5\u4f5c\u6d41\u4ea4\u4e92\u64cd\u4f5c\u5931\u8d25\uff0c%1$s", (Object)wfCallResult.getErrorInfo()));
                return wfCallResult;
            }
        } else {
            WFCallResult wfCallResult = wfClientAPI.TestSubmitIAAction(this.deSubWF.getWFID(), this.getWebContext().getCurUserId(), strKeyValue, "", "", iDEHelper.getId(), strStepName, strConnection, "", this.OnGetUserTag(), this.OnGetUserTag2());
            if (wfCallResult == null || wfCallResult.getRetCode() != 0) {
                this.getPage().PageLog((Object)this, 1, StringHelper.Format((String)"\u6d4b\u8bd5\u5de5\u4f5c\u6d41\u4ea4\u4e92\u64cd\u4f5c\u5931\u8d25\uff0c%1$s", (Object)wfCallResult.getErrorInfo()));
                callResult.setRetCode(1);
                callResult.setErrorInfo(StringHelper.Format((String)"\u6d4b\u8bd5\u5de5\u4f5c\u6d41\u4ea4\u4e92\u64cd\u4f5c\u5931\u8d25\uff0c%1$s", (Object)wfCallResult.getErrorInfo()));
                return callResult;
            }
        }
        return callResult;
    }

    protected CallResult OnSaveActionAfterUpdate(CallResult callResult, BaseDataEntity dataEntity, IDEHelper iDEHelper) {
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
        WFCallResult wfCallResult = null;
        String strKeyValue = dataEntity.GetParamStringValue(iDEHelper.GetKeyDEFHelper().getName(), "");
        String strStepName = this.getWebContext().GetParamValue("SRFWFPROCESSNAME");
        String strConnection = this.getWebContext().GetParamValue("SRFWFIAACTIONNAME");
        if (this.deSubWF == null) {
            String strWFId = iDEHelper.GetDEWFId(this.getWebContext().getSRFWFMode());
            wfCallResult = wfClientAPI.SubmitIAAction(strWFId, this.getWebContext().getCurUserId(), strKeyValue, "", "", iDEHelper.getId(), strStepName, strConnection, this.OnGetDescription(), this.OnGetUserTag(), this.OnGetUserTag2());
        } else {
            wfCallResult = wfClientAPI.SubmitIAAction(this.deSubWF.getWFID(), this.getWebContext().getCurUserId(), strKeyValue, "", "", iDEHelper.getId(), strStepName, strConnection, this.OnGetDescription(), this.OnGetUserTag(), this.OnGetUserTag2());
        }
        wfCallResult = this.OnAfterSubmitIAAction(wfCallResult, iDEHelper, dataEntity);
        if (wfCallResult == null || wfCallResult.getRetCode() != 0) {
            this.getPage().PageLog((Object)this, 1, StringHelper.Format((String)"\u5de5\u4f5c\u6d41\u4ea4\u4e92\u64cd\u4f5c\u5931\u8d25\uff0c%1$s", (Object)wfCallResult.getErrorInfo()));
            return wfCallResult;
        }
        callResult.setUserObject((Object)wfCallResult);
        return callResult;
    }

    protected String OnSaveActionOutputResult(SRFExFormSaveResult saveResult) {
        return saveResult.ToJSONString();
    }

    protected void FillFormUserErrors(SRFExForm form1, SRFExFormItemErrors formItemErrors, CallResult callResult) {
        DBResult result;
        Object objDBResult = callResult.getUserObject();
        if (objDBResult != null && objDBResult instanceof DBResult && (result = (DBResult)objDBResult).getOutValues().containsKey("SRF_TAG")) {
            String strFormItems = (String)result.getOutValues().get("SRF_TAG");
            String[] formItems = StringHelper.Split((String)strFormItems, (char)'|');
            int i = 0;
            while (i < formItems.length) {
                String strFormItemId = formItems[i];
                if (StringHelper.Length((String)strFormItemId) != 0) {
                    SRFExControl control = form1.FindControl(strFormItemId);
                    if (control != null) {
                        formItemErrors.Register(control, 3, callResult.getErrorInfo());
                    } else {
                        String strErrorInfo = "";
                        IDEFHelper iDEFHelper = this.getPage().getDEHelper().GetDEFHelper(strFormItemId);
                        if (iDEFHelper != null) {
                            strErrorInfo = StringHelper.Format((String)"\u8868\u5355\u4e2d\u4e0d\u5b58\u5728[%1$s]", (Object)iDEFHelper.getLogicName(this.getPage().getLanguage()));
                        }
                        if (!StringHelper.IsNullOrEmpty((String)strErrorInfo) && !StringHelper.IsNullOrEmpty((String)callResult.getErrorInfo())) {
                            strErrorInfo = String.valueOf(strErrorInfo) + ",";
                        }
                        strErrorInfo = String.valueOf(strErrorInfo) + callResult.getErrorInfo();
                        formItemErrors.Register("", "", 3, strErrorInfo);
                    }
                }
                ++i;
            }
        }
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

    protected SRFDAPage getPage() {
        return (SRFDAPage)this.page;
    }

    protected SRFDAWebContext getWebContext() {
        return (SRFDAWebContext)super.getWebContext();
    }

    protected Form getFormView() {
        if (this.formView != null) {
            return this.formView;
        }
        Object obj = this.getPage().getPageParam("FORMVIEW");
        if (obj == null) {
            return null;
        }
        if (obj instanceof Form) {
            this.formView = (Form)obj;
        }
        return this.formView;
    }

    protected IDEDataCtrl getDEDataCtrl() {
        return this.getPage().GetDEDataCtrl();
    }

    protected String GetSetPageInfoJSEx(String strDefaultInfo) {
        if (StringHelper.IsNullOrEmpty((String)this.strPageInfo)) {
            return WFIAActionFormActionHelper.GetSetPageInfoJS((ISRFDAPage)this.getPage(), strDefaultInfo);
        }
        return WFIAActionFormActionHelper.GetSetPageInfoJS((ISRFDAPage)this.getPage(), this.strPageInfo);
    }

    protected String GetSetPageInfoJS() {
        return WFIAActionFormActionHelper.GetSetPageInfoJS((ISRFDAPage)this.getPage(), this.strPageInfo);
    }

    protected static String GetSetPageInfoJS(String strInfo) {
        return StringHelper.Format((String)"$P.setpageinfo('%1$s');", (Object)strInfo);
    }

    protected static String GetSetPageInfoJS(ISRFDAPage daPage, String strInfo) {
        if (daPage == null || StringHelper.IsNullOrEmpty((String)daPage.getPageModel())) {
            return StringHelper.Format((String)"$P.setpageinfo('%1$s');", (Object)strInfo);
        }
        return RichAppJSHelper.getSetPageInfoScript((String)daPage.getPageModel(), (String)strInfo);
    }

    protected static String GetSetPageDataJS(String strData) {
        return StringHelper.Format((String)"$P.setpagedata('%1$s');", (Object)strData);
    }

    protected static String GetSetPageDataJS(ISRFDAPage daPage, String strData) {
        if (daPage == null || StringHelper.IsNullOrEmpty((String)daPage.getPageModel())) {
            return StringHelper.Format((String)"$P.setpagedata('%1$s');", (Object)strData);
        }
        return RichAppJSHelper.getSetPageDataScript((String)daPage.getPageModel(), (String)strData);
    }

    protected void SetPageInfo(String strPageInfo) {
        this.strPageInfo = strPageInfo;
    }

    protected String OnGetUserTag() {
        return this.strWFNextStepActor;
    }

    protected String OnGetUserTag2() {
        return this.getWebContext().GetParamValue("WFSTEPACTORID");
    }

    protected String OnGetDescription() {
        return this.strIADesc;
    }

    protected String GetFormState() {
        String strFormState = this.getPage().getPageParam("PAGE.FORMSTATE", "");
        if (StringHelper.IsNullOrEmpty((String)strFormState)) {
            return StringHelper.Format((String)"%1$s", (Object)TAG_IADESCACTION_UPDATE);
        }
        return strFormState;
    }

    protected JSONObject GetFormState(boolean bCreate, BaseDataEntity dataEntity) {
        JSONObject jsonObject = new JSONObject();
        String strFormState = this.GetFormState();
        if (StringHelper.IsNullOrEmpty((String)strFormState)) {
            return jsonObject;
        }
        String[] actions = strFormState.split("[|]");
        int i = 0;
        while (i < actions.length) {
            String strAction = actions[i];
            if (!StringHelper.IsNullOrEmpty((String)(strAction = strAction.trim()))) {
                jsonObject.put(strAction.toLowerCase(), true);
            }
            ++i;
        }
        return jsonObject;
    }

    protected BaseDataEntity CreateFormDataEntity() {
        return this.getPage().getDEHelper().CreateDEObject();
    }
}

