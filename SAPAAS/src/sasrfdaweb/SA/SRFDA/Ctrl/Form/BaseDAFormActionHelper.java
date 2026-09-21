/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.BaseDEHelper
 *  SA.SRFDA.Ctrl.DEFHelper.IDEFHelper
 *  SA.SRFDA.Ctrl.DEFHelper.IInheritDEFHelper
 *  SA.SRFDA.Ctrl.DEFHelper.ILinkDEFHelper
 *  SA.SRFDA.Ctrl.DEFHelper.IPickupDEFHelper
 *  SA.SRFDA.Ctrl.Data.DEAction
 *  SA.SRFDA.Ctrl.Data.DEBehavior
 *  SA.SRFDA.Ctrl.Data.DEDSCtrl
 *  SA.SRFDA.Ctrl.Data.DER1N
 *  SA.SRFDA.Ctrl.Data.DERINDEX
 *  SA.SRFDA.Ctrl.Data.DataEntity
 *  SA.SRFDA.Ctrl.Data.FIUpdate
 *  SA.SRFDA.Ctrl.Data.Form
 *  SA.SRFDA.Ctrl.Data.PP.PPEditForm
 *  SA.SRFDA.Ctrl.Data.TempData
 *  SA.SRFDA.Ctrl.DefaultTransactionManager
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFDA.Ctrl.IDEHelper
 *  SA.SRFDA.Ctrl.IDEMainActionHelper
 *  SA.SRFDA.Ctrl.IDEMainStateHelper
 *  SA.SRFDA.Ctrl.Utility.KeyHelper
 *  SA.SRFDA.Web.ISRFDAWebContext
 *  SA.SRFDA.Web.SRFDAWebCTXHelper
 *  SA.SRFDA.Web.SRFDAWebContext
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Data.DBResult
 *  SA.SRFramework.Data.DataTypeParse
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.DataEx.ValueError
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  SA.SRFramework.Web.WebUtility
 *  SA.SRFramework.WebEx.DP.SRFExDPEx
 *  SA.SRFramework.WebEx.DP.UI.DPDefaultItemConfig
 *  SA.SRFramework.WebEx.Form.SRFExBaseForm
 *  SA.SRFramework.WebEx.Form.SRFExForm
 *  SA.SRFramework.WebEx.Form.SRFExFormActionHelper
 *  SA.SRFramework.WebEx.Form.SRFExFormActionResult
 *  SA.SRFramework.WebEx.Form.SRFExFormCustomCallResult
 *  SA.SRFramework.WebEx.Form.SRFExFormItemErrors
 *  SA.SRFramework.WebEx.Form.SRFExFormLoadResult
 *  SA.SRFramework.WebEx.Form.SRFExFormRemoveResult
 *  SA.SRFramework.WebEx.Form.SRFExFormSaveResult
 *  SA.SRFramework.WebEx.SRFExAjaxActionResult
 *  SA.SRFramework.WebEx.SRFExControl
 *  SA.SRFramework.WebEx.SRFExWebContext
 *  SA.SRFramework.WebEx.Script.BrowserJSHelper
 *  SA.SRFramework.WebEx.Utility.DADVHelper
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.Ctrl.Form;

import SA.SRFDA.Ctrl.BaseDEHelper;
import SA.SRFDA.Ctrl.DEFHelper.IDEFHelper;
import SA.SRFDA.Ctrl.DEFHelper.IInheritDEFHelper;
import SA.SRFDA.Ctrl.DEFHelper.ILinkDEFHelper;
import SA.SRFDA.Ctrl.DEFHelper.IPickupDEFHelper;
import SA.SRFDA.Ctrl.Data.DEAction;
import SA.SRFDA.Ctrl.Data.DEBehavior;
import SA.SRFDA.Ctrl.Data.DEDSCtrl;
import SA.SRFDA.Ctrl.Data.DER1N;
import SA.SRFDA.Ctrl.Data.DERINDEX;
import SA.SRFDA.Ctrl.Data.DataEntity;
import SA.SRFDA.Ctrl.Data.FIUpdate;
import SA.SRFDA.Ctrl.Data.Form;
import SA.SRFDA.Ctrl.Data.PP.PPEditForm;
import SA.SRFDA.Ctrl.Data.TempData;
import SA.SRFDA.Ctrl.DefaultTransactionManager;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Ctrl.IDEMainActionHelper;
import SA.SRFDA.Ctrl.IDEMainStateHelper;
import SA.SRFDA.Ctrl.Utility.KeyHelper;
import SA.SRFDA.Web.Default.DefaultPageHelper;
import SA.SRFDA.Web.IDEMainActionPage;
import SA.SRFDA.Web.IDEMainStatePage;
import SA.SRFDA.Web.IFormViewPage;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFDA.Web.SRFDAPage;
import SA.SRFDA.Web.SRFDAWebCTXHelper;
import SA.SRFDA.Web.SRFDAWebContext;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFDA.Web.Utility.PagePathHelper;
import SA.SRFramework.Data.DBResult;
import SA.SRFramework.Data.DataTypeParse;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.DataEx.ValueError;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.Web.WebUtility;
import SA.SRFramework.WebEx.DP.SRFExDPEx;
import SA.SRFramework.WebEx.DP.UI.DPDefaultItemConfig;
import SA.SRFramework.WebEx.Form.SRFExBaseForm;
import SA.SRFramework.WebEx.Form.SRFExForm;
import SA.SRFramework.WebEx.Form.SRFExFormActionHelper;
import SA.SRFramework.WebEx.Form.SRFExFormActionResult;
import SA.SRFramework.WebEx.Form.SRFExFormCustomCallResult;
import SA.SRFramework.WebEx.Form.SRFExFormItemErrors;
import SA.SRFramework.WebEx.Form.SRFExFormLoadResult;
import SA.SRFramework.WebEx.Form.SRFExFormRemoveResult;
import SA.SRFramework.WebEx.Form.SRFExFormSaveResult;
import SA.SRFramework.WebEx.SRFExAjaxActionResult;
import SA.SRFramework.WebEx.SRFExControl;
import SA.SRFramework.WebEx.SRFExWebContext;
import SA.SRFramework.WebEx.Script.BrowserJSHelper;
import SA.SRFramework.WebEx.Utility.DADVHelper;
import java.util.Hashtable;
import java.util.Vector;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class BaseDAFormActionHelper
extends SRFExFormActionHelper {
    protected Form formView = null;
    protected SRFExDPEx mainPanel = null;
    private static final Log log = LogFactory.getLog(BaseDAFormActionHelper.class);
    protected Vector<String> disableItems = null;
    protected SRFExForm form1 = null;
    protected String strPageInfo = "";
    protected StringBuilderEx script = null;
    protected StringBuilderEx beforeScript = null;
    protected boolean bTempDataMode = false;
    protected boolean bUpdateFlag = false;
    protected boolean bTestDataReadAction = true;
    protected boolean bTestDataCreateAction = true;
    protected boolean bTestDataUpdateAction = true;
    protected boolean bTestDataDeleteAction = true;
    protected PPEditForm ppEditForm = null;
    protected IDEMainStateHelper iDEMainStateHelper = null;
    protected boolean bEnableDEMainState = false;
    protected IDEMainActionHelper iDEMainActionHelper = null;
    protected boolean bEnableDEMainAction = false;
    protected IFormViewPage iFormViewPage = null;

    protected boolean OnBeforeProcess() {
        if (super.OnBeforeProcess()) {
            IDEMainStatePage iDEMainStatePage;
            IDEMainActionPage iDEMainActionPage;
            this.form1 = this.getForm();
            SRFExControl contorl = this.form1.getMainPanel();
            if (contorl != null && contorl instanceof SRFExDPEx) {
                this.mainPanel = (SRFExDPEx)contorl;
            }
            if (this.mainPanel == null) {
                return false;
            }
            BaseDataEntity pageParam = this.getPage().getAdvPageParam(this.mainPanel.getID().toUpperCase(), "PP_FORM");
            if (pageParam != null && pageParam instanceof PPEditForm) {
                this.ppEditForm = (PPEditForm)pageParam;
            }
            this.bTempDataMode = SRFDAWebCTXHelper.IsTempDataMode((ISRFDAWebContext)this.getWebContext(), (boolean)false);
            String strUF = this.getWebContext().GetPostValue("srfuf");
            this.bUpdateFlag = !StringHelper.IsNullOrEmpty((String)strUF) && StringHelper.Compare((String)strUF, (String)"TRUE", (boolean)true) == 0;
            this.form1.setUpdateMode(this.bUpdateFlag);
            this.getFormView();
            if (this.getPage() instanceof IFormViewPage) {
                this.iFormViewPage = (IFormViewPage)((Object)this.getPage());
            }
            if (this.getPage() instanceof IDEMainActionPage && (iDEMainActionPage = (IDEMainActionPage)((Object)this.getPage())).isEnableDEMainAction()) {
                this.iDEMainActionHelper = iDEMainActionPage.getDEMainAction();
                this.bEnableDEMainAction = true;
            }
            if (!this.bEnableDEMainAction && this.getPage() instanceof IDEMainStatePage && (iDEMainStatePage = (IDEMainStatePage)((Object)this.getPage())).isEnableDEMainState()) {
                this.iDEMainStateHelper = iDEMainStatePage.getDEMainState();
                this.bEnableDEMainState = true;
            }
            return true;
        }
        return false;
    }

    protected boolean OnLoadDefaultAction() {
        String strDV;
        String strDVT;
        SRFExFormLoadResult loadResult = new SRFExFormLoadResult();
        this.getWebContext().setActiveAjaxActionResult((SRFExAjaxActionResult)loadResult);
        BaseDataEntity dataEntity = this.CreateFormDataEntity();
        this.OnLoadDefaultActionBeforeFillDataEntity(dataEntity);
        this.FillMajorDataEntity(dataEntity);
        if (this.mainPanel.getDPConfig().getDPDefaultGroupConfig() != null) {
            for (DPDefaultItemConfig defaultItem : this.mainPanel.getDPConfig().getDPDefaultGroupConfig().getDefaultConfigs()) {
                strDVT = defaultItem.getDVT();
                strDV = defaultItem.getDV();
                if (dataEntity.ContainesParam(defaultItem.getID())) continue;
                dataEntity.SetParamValue(defaultItem.getID(), (Object)DADVHelper.GetDefaultValue((SRFExWebContext)this.getWebContext(), (String)strDVT, (String)strDV));
            }
        }
        this.form1.FillDataEntityDV(dataEntity);
        for (IDEFHelper iDEFHelper : this.getPage().getDEHelper().GetDEFHelpers()) {
            if (iDEFHelper.IsKeyDEField()) continue;
            strDVT = iDEFHelper.GetFormCtrl().GetDefaultValueType();
            strDV = iDEFHelper.GetFormCtrl().GetDefaultValue();
            if (StringHelper.Length((String)strDVT) == 0 && StringHelper.Length((String)strDV) == 0 || dataEntity.ContainesParam(iDEFHelper.getName())) continue;
            dataEntity.SetParamValue(iDEFHelper.getName(), DADVHelper.GetDefaultValue((SRFExWebContext)this.getWebContext(), (String)strDVT, (String)strDV, (String)iDEFHelper.GetStdDataType()));
        }
        CallResult callResult = this.getDEDataCtrl().GetDefault((ISRFDAWebContext)this.getWebContext(), dataEntity);
        loadResult.From(callResult);
        if (loadResult.getRetCode() != 0) {
            loadResult.AppendJSCode(BaseDAFormActionHelper.GetSetPageInfoJS(""));
            loadResult.AppendJSCode(BaseDAFormActionHelper.GetSetPageDataJS(""));
            if (!StringHelper.IsNullOrEmpty((String)this.getWebContext().getSRFPageModel())) {
                loadResult.setExtInfo("pageinfo", "");
                loadResult.setExtInfo("pagedata", "");
            }
            this.getPage().Output(loadResult.ToJSONString());
            return true;
        }
        dataEntity.SetParamValue("SRFDATEMPKEYID", (Object)KeyHelper.GetTempKey((String)""));
        this.OnLoadDefaultActionAfterFillDataEntity(dataEntity);
        this.CalcDataUrl(null, (SRFExFormActionResult)loadResult, false);
        this.form1.FillByDataEntity(dataEntity, false);
        this.form1.EnableFormItems(true);
        if (this.disableItems != null) {
            for (String strFormItemId : this.disableItems) {
                this.form1.EnableFormItem(strFormItemId, false);
            }
        }
        loadResult.setUpdateFlag(false);
        this.form1.FillValueJSON(loadResult.getItems(), this.getPage().isControlValueFromUniqueId());
        loadResult.AppendJSBeforeCode(this.GetExtJSBeforeCode());
        loadResult.AppendJSCode(BaseDAFormActionHelper.GetSetPageInfoJS(""));
        loadResult.AppendJSCode(BaseDAFormActionHelper.GetSetPageDataJS(""));
        loadResult.AppendJSCode(BaseDAFormActionHelper.GetSetWFMainStateJS(this.getPage().getDEHelper(), ""));
        loadResult.AppendJSCode(this.GetExtJSCode());
        loadResult.setFormState(this.GetFormState(true, dataEntity));
        if (!StringHelper.IsNullOrEmpty((String)this.getWebContext().getSRFPageModel())) {
            loadResult.setExtInfo("pageinfo", "");
            loadResult.setExtInfo("pagedata", "");
        }
        this.getPage().Output(this.OnLoadDefaultActionOutputResult(dataEntity, loadResult));
        return true;
    }

    protected String OnLoadDefaultActionOutputResult(BaseDataEntity dataEntity, SRFExFormLoadResult loadResult) {
        return loadResult.ToJSONString();
    }

    protected void OnLoadDefaultActionBeforeFillDataEntity(BaseDataEntity dataEntity) {
    }

    protected void OnLoadDefaultActionAfterFillDataEntity(BaseDataEntity dataEntity) {
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    protected void FillMajorDataEntity(BaseDataEntity dataEntity) {
        String strDERID = this.getWebContext().getSRFDERID();
        if (StringHelper.IsNullOrEmpty((String)strDERID)) {
            return;
        }
        boolean bEnableModifyPData = this.IsEnableModifyPData();
        IPickupDEFHelper pickupDEFHelper = this.getPage().getDEHelper().FindPickupDEFHelper(strDERID);
        if (pickupDEFHelper == null) {
            DER1N der1n = new DER1N();
            CallResult callResult = this.getPage().getDAModelHelper().GetDER1N(strDERID, der1n);
            if (callResult.getRetCode() != 0) {
                log.error((Object)StringHelper.Format((String)"\u83b7\u53d6DER1N[%1$s]\u5931\u8d25\uff0c%2$s", (Object)strDERID, (Object)callResult.getErrorInfo()));
                return;
            }
            IDEFHelper iDEFHelper = this.getPage().getDEHelper().GetDEFHelper(der1n.getMAJORKEYDEFNAME());
            if (iDEFHelper == null) {
                return;
            }
            if (!(iDEFHelper instanceof IPickupDEFHelper)) {
                if (!(iDEFHelper instanceof IInheritDEFHelper)) {
                    return;
                }
                IInheritDEFHelper inheritDEFHelper = (IInheritDEFHelper)iDEFHelper;
                if (!(inheritDEFHelper.GetRelatedDEFHelper() instanceof IPickupDEFHelper)) return;
                pickupDEFHelper = (IPickupDEFHelper)inheritDEFHelper.GetRelatedDEFHelper();
            } else {
                pickupDEFHelper = (IPickupDEFHelper)iDEFHelper;
            }
            strDERID = pickupDEFHelper.GetDERId();
            this.getWebContext().SetParamValue("SRFDERID", strDERID);
        }
        if (!pickupDEFHelper.GetRealDEFHelper().GetDTColumn().IsPKey()) {
            return;
        }
        String strKeyValue = this.getWebContext().GetParamValue(pickupDEFHelper.GetRelatedDEFHelper().getName());
        if (StringHelper.IsNullOrEmpty((String)strKeyValue)) {
            strKeyValue = this.getWebContext().GetPostValue(pickupDEFHelper.GetRelatedDEFHelper().getName());
        }
        if (StringHelper.IsNullOrEmpty((String)strKeyValue)) {
            if (!pickupDEFHelper.GetRealDEFHelper().getDEHelper().IsIndexDE()) return;
            Vector list = pickupDEFHelper.GetRealDEFHelper().getDEHelper().GetDERINDEXs(true);
            boolean bFind = false;
            for (DERINDEX dERINDEX : list) {
                IDEHelper iDEHelper = this.getPage().getDAModelStorage().FindDEHelper(dERINDEX.getDEID());
                if (iDEHelper == null) {
                    log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u8f85\u52a9\u5bf9\u8c61", (Object)dERINDEX.getDEID()));
                    continue;
                }
                strKeyValue = this.getWebContext().GetParamValue(iDEHelper.GetKeyDEFHelper().getName());
                if (StringHelper.IsNullOrEmpty((String)strKeyValue)) {
                    strKeyValue = this.getWebContext().GetPostValue(iDEHelper.GetKeyDEFHelper().getName());
                }
                if (StringHelper.IsNullOrEmpty((String)strKeyValue)) continue;
                if (pickupDEFHelper.GetRealDEFHelper().getDEHelper().GetIndexMode() == 1) {
                    strKeyValue = BaseDEHelper.GetIndexDEKeyValueWithType((DERINDEX)dERINDEX, (Object)strKeyValue);
                }
                bFind = true;
                break;
            }
            if (!bFind) {
                return;
            }
        }
        if (!bEnableModifyPData) {
            if (this.disableItems == null) {
                this.disableItems = new Vector();
            }
            this.disableItems.add(pickupDEFHelper.GetFormCtrl().GetFormCtrlId());
        }
        DataEntity realDataEntity = new DataEntity();
        dataEntity.SetParamValue(pickupDEFHelper.GetFormCtrl().GetFormCtrlId(), (Object)strKeyValue);
        if (KeyHelper.IsTempKey((String)strKeyValue)) {
            realDataEntity.SetParamValue(pickupDEFHelper.GetPickupTextDEFHelper().GetRealDEFHelper().getName(), (Object)this.GetLocalization("CTRL.FORMAH.UNSAVENEWDATA", "\u65b0\u5efa\u672a\u4fdd\u5b58\u6570\u636e"));
        } else {
            Object objKeyValue = DataTypeParse.Parse((String)pickupDEFHelper.GetRealDEFHelper().GetStdDataType(), (String)strKeyValue);
            if (objKeyValue == null) {
                log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53\u5c5e\u6027[%1$s]\u5b9e\u9645\u5bf9\u8c61\u503c[%2$s]", (Object)pickupDEFHelper.GetRealDEFHelper().GetFullName(), (Object)strKeyValue));
                return;
            }
            realDataEntity.SetParamValue(pickupDEFHelper.GetRealDEFHelper().getName(), objKeyValue);
            IDEDataCtrl iRealDataCtrl = pickupDEFHelper.GetRealDEFHelper().getDEHelper().GetDEDataCtrl("", (ISRFDAWebContext)this.getWebContext());
            if (iRealDataCtrl == null) {
                log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u64cd\u4f5c\u5bf9\u8c61", (Object)pickupDEFHelper.GetRealDEFHelper().getDEHelper().GetFullName()));
                return;
            }
            CallResult callResult = iRealDataCtrl.Get((BaseDataEntity)realDataEntity);
            if (callResult.getRetCode() != 0) {
                log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u51fa\u73b0\u9519\u8bef[%2$s]", (Object)iRealDataCtrl.GetDEHelper().getId(), (Object)callResult.getErrorInfo()));
                return;
            }
        }
        dataEntity.SetParamValue(pickupDEFHelper.GetPickupTextDEFHelper().getName(), (Object)realDataEntity.GetParamStringValue(pickupDEFHelper.GetPickupTextDEFHelper().GetRealDEFHelper().getName(), ""));
        if (!bEnableModifyPData) {
            if (this.disableItems == null) {
                this.disableItems = new Vector();
            }
            this.disableItems.add(pickupDEFHelper.GetPickupTextDEFHelper().getName());
        }
        for (IDEFHelper tempDEFHelper : this.getPage().getDEHelper().GetDEFHelpers()) {
            if (!(tempDEFHelper instanceof ILinkDEFHelper) || pickupDEFHelper == tempDEFHelper || pickupDEFHelper.GetPickupTextDEFHelper() == tempDEFHelper) continue;
            ILinkDEFHelper linkDEFHelper = (ILinkDEFHelper)tempDEFHelper;
            if (StringHelper.Compare((String)pickupDEFHelper.GetDERId(), (String)linkDEFHelper.GetDERId(), (boolean)true) != 0) continue;
            dataEntity.SetParamValue(linkDEFHelper.getName(), realDataEntity.GetParamValue(linkDEFHelper.GetRelatedDEFHelper().getName()));
            if (this.disableItems == null) continue;
            this.disableItems.add(linkDEFHelper.getName());
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    protected boolean FillTempDataPDEInfo(TempData tempData) {
        String strDERID = this.getWebContext().getSRFDERID();
        if (StringHelper.IsNullOrEmpty((String)strDERID)) {
            return false;
        }
        IPickupDEFHelper pickupDEFHelper = this.getPage().getDEHelper().FindPickupDEFHelper(strDERID);
        if (pickupDEFHelper == null) {
            DER1N der1n = new DER1N();
            CallResult callResult = this.getPage().getDAModelHelper().GetDER1N(strDERID, der1n);
            if (callResult.getRetCode() != 0) {
                log.error((Object)StringHelper.Format((String)"\u83b7\u53d6DER1N[%1$s]\u5931\u8d25\uff0c%2$s", (Object)strDERID, (Object)callResult.getErrorInfo()));
                return false;
            }
            IDEFHelper iDEFHelper = this.getPage().getDEHelper().GetDEFHelper(der1n.getMAJORKEYDEFNAME());
            if (iDEFHelper == null) {
                return false;
            }
            if (!(iDEFHelper instanceof IPickupDEFHelper)) {
                if (!(iDEFHelper instanceof IInheritDEFHelper)) return false;
                IInheritDEFHelper inheritDEFHelper = (IInheritDEFHelper)iDEFHelper;
                if (!(inheritDEFHelper.GetRelatedDEFHelper() instanceof IPickupDEFHelper)) return false;
                pickupDEFHelper = (IPickupDEFHelper)inheritDEFHelper.GetRelatedDEFHelper();
            } else {
                pickupDEFHelper = (IPickupDEFHelper)iDEFHelper;
            }
        }
        if (!pickupDEFHelper.GetRealDEFHelper().GetDTColumn().IsPKey()) {
            return false;
        }
        tempData.setPDEID(pickupDEFHelper.GetRealDEFHelper().getDEHelper().getId());
        tempData.setPTEMPKEYNAME(pickupDEFHelper.getName());
        String strKeyValue = this.getWebContext().GetParamValue(pickupDEFHelper.GetRelatedDEFHelper().getName());
        if (StringHelper.IsNullOrEmpty((String)strKeyValue)) {
            if (!pickupDEFHelper.GetRealDEFHelper().getDEHelper().IsIndexDE()) return false;
            Vector list = pickupDEFHelper.GetRealDEFHelper().getDEHelper().GetDERINDEXs(true);
            boolean bFind = false;
            for (DERINDEX dERINDEX : list) {
                IDEHelper iDEHelper = this.getPage().getDAModelStorage().FindDEHelper(dERINDEX.getDEID());
                if (iDEHelper == null) {
                    log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u8f85\u52a9\u5bf9\u8c61", (Object)dERINDEX.getDEID()));
                    continue;
                }
                strKeyValue = this.getWebContext().GetParamValue(iDEHelper.GetKeyDEFHelper().getName());
                if (StringHelper.IsNullOrEmpty((String)strKeyValue)) continue;
                bFind = true;
                break;
            }
            if (!bFind) {
                return false;
            }
        }
        tempData.setPTEMPKEYVALUE(strKeyValue);
        return true;
    }

    protected boolean OnLoadAction() {
        SRFExFormLoadResult loadResult = new SRFExFormLoadResult();
        this.getWebContext().setActiveAjaxActionResult((SRFExAjaxActionResult)loadResult);
        SRFExFormItemErrors formItemErrors = new SRFExFormItemErrors();
        BaseDataEntity dataEntity = this.CreateFormDataEntity();
        if (!this.form1.FillDataEntity(dataEntity, true, formItemErrors, this.getPage().isControlValueFromUniqueId())) {
            String strNotSpecifyKey = this.GetLocalization("CTRL.FORMAH.NOTSPECIFYKEY", "\u6ca1\u6709\u6307\u5b9a\u6570\u636e\u952e\u503c");
            loadResult.setRetCode(4);
            loadResult.setJSCode(StringHelper.Format((String)"alert('%1$s');", (Object)strNotSpecifyKey));
            loadResult.AppendJSCode(BaseDAFormActionHelper.GetSetPageDataJS(""));
            loadResult.AppendJSCode(BaseDAFormActionHelper.GetSetPageInfoJS(strNotSpecifyKey));
            if (!StringHelper.IsNullOrEmpty((String)this.getWebContext().getSRFPageModel())) {
                loadResult.setExtInfo("pagemsg", strNotSpecifyKey);
                loadResult.setExtInfo("pageinfo", strNotSpecifyKey);
                loadResult.setExtInfo("pagedata", "");
            }
            this.getPage().Output(loadResult.ToJSONString());
            return true;
        }
        if (this.bTempDataMode) {
            IDEDataCtrl iTempDataCtrl = this.getWebContext().getGlobalHelper().getDAModelStorage().FindDEDataCtrl("DE0112", (ISRFDAWebContext)this.getWebContext());
            if (iTempDataCtrl == null) {
                log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61", (Object)"DE0112"));
                loadResult.setRetCode(1);
                loadResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61", (Object)"DE0112"));
                loadResult.AppendJSCode(BaseDAFormActionHelper.GetSetPageInfoJS("\u6570\u636e\u67e5\u8be2\u5931\u8d25"));
                if (!StringHelper.IsNullOrEmpty((String)this.getWebContext().getSRFPageModel())) {
                    loadResult.setExtInfo("pageinfo", "\u6570\u636e\u67e5\u8be2\u5931\u8d25");
                    loadResult.setExtInfo("pagedata", "");
                }
                this.getPage().Output(loadResult.ToJSONString());
                return true;
            }
            String strTempData = dataEntity.GetParamStringValue(this.getPage().getDEHelper().GetKeyDEFHelper().getName(), "");
            TempData tempData = new TempData();
            tempData.setTEMPDATAID(strTempData);
            CallResult callResult = iTempDataCtrl.Get((BaseDataEntity)tempData);
            if (callResult.getRetCode() != 0) {
                if (callResult.getRetCode() == 3 && this.getPage().getPageParam("EMBEDEDIT", false)) {
                    return this.OnLoadDefaultAction();
                }
                if (callResult.IsUserError()) {
                    callResult.setRetCode(5);
                    formItemErrors.FillJSONs(loadResult.getItems());
                }
                loadResult.From(callResult);
                loadResult.AppendJSCode(BaseDAFormActionHelper.GetSetPageDataJS(""));
                loadResult.AppendJSCode(BaseDAFormActionHelper.GetSetPageInfoJS("\u6570\u636e\u67e5\u8be2\u5931\u8d25"));
                if (!StringHelper.IsNullOrEmpty((String)this.getWebContext().getSRFPageModel())) {
                    loadResult.setExtInfo("pageinfo", "\u6570\u636e\u67e5\u8be2\u5931\u8d25");
                    loadResult.setExtInfo("pagedata", "");
                }
            } else {
                BaseDataEntity realDataEntity = BaseDataEntity.FromString((String)tempData.getDEDATA());
                realDataEntity.SetParamValue("SRFDATEMPKEYID", (Object)strTempData);
                this.FillMajorDataEntity(realDataEntity);
                this.OnLoadActionFillForm(realDataEntity);
                this.form1.FillValueJSON(loadResult.getItems(), this.getPage().isControlValueFromUniqueId());
                if (this.getWebContext().getCopyMode()) {
                    loadResult.AppendJSCode(BaseDAFormActionHelper.GetSetPageDataJS(""));
                    loadResult.setCopyMode(true);
                    loadResult.setUpdateFlag(false);
                } else {
                    loadResult.AppendJSCode(BaseDAFormActionHelper.GetSetPageInfoJS(""));
                    loadResult.AppendJSCode(BaseDAFormActionHelper.GetSetPageDataJS(this.getPage().getDEHelper().GetDataInfo(realDataEntity)));
                    loadResult.setFormState(this.GetFormState(false, dataEntity));
                    loadResult.setUpdateFlag(true);
                }
            }
        } else {
            CallResult callResult = this.OnTestDataAction(dataEntity, "READ");
            if (callResult.getRetCode() != 0) {
                loadResult.From(callResult);
                loadResult.AppendJSCode(BaseDAFormActionHelper.GetSetPageDataJS(""));
                loadResult.AppendJSCode(BaseDAFormActionHelper.GetSetPageInfoJS(callResult.getErrorInfo()));
                this.getPage().Output(loadResult.ToJSONString());
                return true;
            }
            String strKeyData = dataEntity.GetParamStringValue(this.getPage().getDEHelper().GetKeyDEFHelper().getName(), "");
            dataEntity.SetParamValue("SRF_CHILDDATATAG", (Object)this.formView.getCHILDDATATAG());
            callResult = this.formView == null || StringHelper.IsNullOrEmpty((String)this.formView.getGETMODE()) ? this.getDEDataCtrl().Get(dataEntity) : this.getDEDataCtrl().Get(this.formView.getGETMODE(), dataEntity);
            if (callResult.IsOk()) {
                callResult = this.OnLoadActionAfterGet(dataEntity);
            }
            if (callResult.getRetCode() != 0) {
                if (callResult.getRetCode() == 3 && this.getPage().getPageParam("EMBEDEDIT", false)) {
                    return this.OnLoadDefaultAction();
                }
                if (callResult.IsUserError()) {
                    callResult.setRetCode(5);
                    formItemErrors.FillJSONs(loadResult.getItems());
                }
                loadResult.From(callResult);
                loadResult.AppendJSBeforeCode(this.GetExtJSBeforeCode());
                loadResult.AppendJSCode(BaseDAFormActionHelper.GetSetPageDataJS(""));
                loadResult.AppendJSCode(BaseDAFormActionHelper.GetSetPageInfoJS("\u6570\u636e\u67e5\u8be2\u5931\u8d25"));
                if (!StringHelper.IsNullOrEmpty((String)this.getWebContext().getSRFPageModel())) {
                    loadResult.setExtInfo("pageinfo", "\u6570\u636e\u67e5\u8be2\u5931\u8d25");
                    loadResult.setExtInfo("pagedata", "");
                }
            } else {
                if (this.getWebContext().getCopyMode()) {
                    dataEntity.SetParamValue("SRFDATEMPKEYID", (Object)KeyHelper.GetTempKey((String)""));
                }
                this.CalcDataUrl(dataEntity, (SRFExFormActionResult)loadResult, this.getWebContext().getCopyMode());
                this.OnLoadActionFillForm(dataEntity);
                this.form1.FillValueJSON(loadResult.getItems(), this.getPage().isControlValueFromUniqueId());
                if (this.getWebContext().getCopyMode()) {
                    loadResult.setCopyId(strKeyData);
                    loadResult.AppendJSCode(BaseDAFormActionHelper.GetSetPageDataJS(""));
                    loadResult.AppendJSCode(BaseDAFormActionHelper.GetSetWFMainStateJS(this.getPage().getDEHelper(), ""));
                    loadResult.setCopyMode(true);
                    loadResult.setFormState(this.GetFormState(true, dataEntity));
                    loadResult.setUpdateFlag(false);
                } else {
                    loadResult.AppendJSBeforeCode(this.GetExtJSBeforeCode());
                    loadResult.AppendJSCode(BaseDAFormActionHelper.GetSetPageInfoJS(""));
                    loadResult.setUpdateFlag(true);
                    loadResult.AppendJSCode(BaseDAFormActionHelper.GetSetPageDataJS(this.getPage().getDEHelper().GetDataInfo(dataEntity)));
                    loadResult.AppendJSCode(BaseDAFormActionHelper.GetSetWFMainStateJS(this.getPage().getDEHelper(), dataEntity.GetParamStringValue(this.getPage().getDEHelper().GetKeyDEFHelper().getName(), "")));
                    loadResult.AppendJSCode(this.GetExtJSCode());
                    loadResult.setFormState(this.GetFormState(false, dataEntity));
                    if (!StringHelper.IsNullOrEmpty((String)this.getWebContext().getSRFPageModel())) {
                        loadResult.setExtInfo("pageinfo", "");
                        loadResult.setExtInfo("pagedata", this.getPage().getDEHelper().GetDataInfo(dataEntity));
                    }
                }
            }
        }
        this.getPage().Output(this.OnLoadActionOutputResult(dataEntity, loadResult));
        return true;
    }

    protected String OnLoadActionOutputResult(BaseDataEntity dataEntity, SRFExFormLoadResult loadResult) {
        return loadResult.ToJSONString();
    }

    protected CallResult OnLoadActionAfterGet(BaseDataEntity dataEntity) {
        return new CallResult();
    }

    protected void OnLoadActionFillForm(BaseDataEntity dataEntity) {
        block9: {
            block8: {
                if (!this.bTempDataMode) break block8;
                this.form1.FillDataEntityDV(dataEntity, false);
                this.form1.FillByDataEntity(dataEntity, false);
                this.form1.EnableFormItems(true);
                if (this.disableItems == null) break block9;
                for (String strFormItemId : this.disableItems) {
                    this.form1.EnableFormItem(strFormItemId, false);
                }
                break block9;
            }
            this.form1.FillDataEntityDV(dataEntity, true);
            if (this.getWebContext().getCopyMode()) {
                this.getDEDataCtrl().RemoveUncopyValue(dataEntity);
            }
            if (this.OnGetCheckDataUpdateDate()) {
                dataEntity.SetParamValue("SRFDAUPDATEDATE", dataEntity.GetParamValue("UPDATEDATE"));
            }
            this.form1.FillByDataEntity(dataEntity, this.getWebContext().getCopyMode());
            if (!this.getWebContext().getCopyMode() && this.IsDisableAllItems(dataEntity)) {
                this.form1.EnableAllFormItems(false);
            } else {
                this.form1.EnableFormItems(this.getWebContext().getCopyMode());
                DEDSCtrl deDSCtrl = this.getPage().getDEHelper().GetDataAccHelper().FindFieldCtrl(dataEntity);
                if (deDSCtrl != null) {
                    this.form1.DisableFormItems(deDSCtrl.getCtrlFields(), StringHelper.Compare((String)deDSCtrl.getFIELDCTRLMODE(), (String)"DENY", (boolean)true) == 0);
                }
            }
            if (this.disableItems != null) {
                for (String strFormItemId : this.disableItems) {
                    this.form1.EnableFormItem(strFormItemId, false);
                }
            }
        }
    }

    protected boolean OnRemoveAction() {
        SRFExFormRemoveResult removeResult = new SRFExFormRemoveResult();
        this.getWebContext().setActiveAjaxActionResult((SRFExAjaxActionResult)removeResult);
        SRFExFormItemErrors formItemErrors = new SRFExFormItemErrors();
        BaseDataEntity dataEntity = this.CreateFormDataEntity();
        if (!this.form1.FillDataEntity(dataEntity, true, formItemErrors, this.getPage().isControlValueFromUniqueId())) {
            String strNotSpecifyKeyInfo = this.GetLocalization("CTRL.FORMAH.NOTSPECIFYKEY", "\u6ca1\u6709\u6307\u5b9a\u6570\u636e\u952e\u503c");
            removeResult.setRetCode(4);
            removeResult.setJSCode(StringHelper.Format((String)"alert('%1$s');", (Object)strNotSpecifyKeyInfo));
            removeResult.AppendJSCode(BaseDAFormActionHelper.GetSetPageDataJS(""));
            removeResult.AppendJSCode(BaseDAFormActionHelper.GetSetPageInfoJS(strNotSpecifyKeyInfo));
            if (!StringHelper.IsNullOrEmpty((String)this.getWebContext().getSRFPageModel())) {
                removeResult.setExtInfo("pagemsg", strNotSpecifyKeyInfo);
                removeResult.setExtInfo("pageinfo", strNotSpecifyKeyInfo);
                removeResult.setExtInfo("pagedata", "");
            }
            this.getPage().Output(removeResult.ToJSONString());
            return true;
        }
        if (this.bTempDataMode) {
            String strTempData = dataEntity.GetParamStringValue(this.getPage().getDEHelper().GetKeyDEFHelper().getName(), "");
            TempData tempData = new TempData();
            tempData.setTEMPDATAID(strTempData);
            CallResult callResult = this.getDEDataCtrl().RemoveTempData(tempData);
            if (callResult.getRetCode() != 0) {
                if (callResult.IsUserError()) {
                    callResult.setRetCode(5);
                    formItemErrors.FillJSONs(removeResult.getItems());
                }
                removeResult.From(callResult);
                removeResult.AppendJSCode(BaseDAFormActionHelper.GetSetPageDataJS(""));
                removeResult.AppendJSCode(BaseDAFormActionHelper.GetSetPageInfoJS("\u6570\u636e\u5220\u9664\u5931\u8d25"));
                if (!StringHelper.IsNullOrEmpty((String)this.getWebContext().getSRFPageModel())) {
                    removeResult.setExtInfo("pageinfo", "\u6570\u636e\u5220\u9664\u5931\u8d25");
                    removeResult.setExtInfo("pagedata", "");
                }
            }
        } else {
            CallResult callResult = this.OnRemoveActionBeforeRemove(dataEntity);
            if (callResult.getRetCode() != 0) {
                removeResult.From(callResult);
                removeResult.AppendJSCode(BaseDAFormActionHelper.GetSetPageDataJS(""));
                removeResult.AppendJSCode(BaseDAFormActionHelper.GetSetPageInfoJS(callResult.getErrorInfo()));
                if (!StringHelper.IsNullOrEmpty((String)this.getWebContext().getSRFPageModel())) {
                    removeResult.setExtInfo("pageinfo", callResult.getErrorInfo());
                    removeResult.setExtInfo("pagedata", "");
                }
                this.getPage().Output(removeResult.ToJSONString());
                return true;
            }
            DefaultTransactionManager transactionManager = new DefaultTransactionManager();
            transactionManager.Init((ISRFDAGlobalHelper)this.getWebContext().getGlobalHelper());
            transactionManager.Register(this.getDEDataCtrl());
            callResult = this.getDEDataCtrl().Remove(dataEntity);
            if (callResult.IsError()) {
                transactionManager.Rollback();
            } else {
                transactionManager.Commit();
            }
            if (callResult.getRetCode() != 0) {
                if (callResult.IsUserError()) {
                    callResult.setRetCode(5);
                    formItemErrors.FillJSONs(removeResult.getItems());
                }
                removeResult.From(callResult);
                removeResult.AppendJSBeforeCode(this.GetExtJSBeforeCode());
                removeResult.AppendJSCode(BaseDAFormActionHelper.GetSetPageDataJS(""));
                removeResult.AppendJSCode(BaseDAFormActionHelper.GetSetPageInfoJS("\u6570\u636e\u5220\u9664\u5931\u8d25"));
                if (!StringHelper.IsNullOrEmpty((String)this.getWebContext().getSRFPageModel())) {
                    removeResult.setExtInfo("pageinfo", "\u6570\u636e\u5220\u9664\u5931\u8d25");
                    removeResult.setExtInfo("pagedata", "");
                }
            }
        }
        this.getPage().Output(this.OnRemoveActionOutputResult(dataEntity, removeResult));
        return true;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    protected boolean OnSaveAction() {
        String strErrorFormat;
        BaseDataEntity dataEntity;
        SRFExFormItemErrors formItemErrors;
        CallResult callResult;
        SRFExFormSaveResult saveResult;
        block47: {
            IDEDataCtrl iDEDataCtrl;
            block46: {
                boolean bInsert;
                saveResult = new SRFExFormSaveResult();
                this.getWebContext().setActiveAjaxActionResult((SRFExAjaxActionResult)saveResult);
                callResult = null;
                formItemErrors = new SRFExFormItemErrors();
                iDEDataCtrl = this.getDEDataCtrl();
                dataEntity = this.CreateFormDataEntity();
                this.OnSaveActionBeforeFillDataEntity(dataEntity);
                if (!this.OnSaveActionFillDataEntity(dataEntity, formItemErrors)) {
                    saveResult.setRetCode(5);
                    formItemErrors.FillJSONs(saveResult.getItems());
                    saveResult.AppendJSCode(BaseDAFormActionHelper.GetSetPageInfoJS(this.GetLocalization("CTRL.FORMAH.INPUTERROR", "\u8f93\u5165\u6709\u8bef\uff0c\u6570\u636e\u65e0\u6cd5\u4fdd\u5b58!")));
                    this.getPage().Output(saveResult.ToJSONString());
                    return true;
                }
                boolean bl = bInsert = !this.IsFormContainKey(dataEntity);
                if (this.isTempDataMode()) {
                    bInsert = true;
                }
                if (!bInsert) {
                    if (!StringHelper.IsNullOrEmpty((String)this.getWebContext().getSRFPageModel())) {
                        BaseDataEntity checkkeyparam = new BaseDataEntity();
                        dataEntity.CopyTo(checkkeyparam, true);
                        callResult = iDEDataCtrl.CheckKeyState(checkkeyparam);
                        if (callResult.getRetCode() != 0 || callResult.getUserObject() == null) {
                            saveResult.setRetCode(1);
                            saveResult.AppendJSCode(BaseDAFormActionHelper.GetSetPageInfoJS(this.GetLocalization("CTRL.FORMAH.DATAKEYERROR", "\u68c0\u67e5\u6570\u636e\u4e3b\u952e\u53d1\u751f\u9519\u8bef!\u6570\u636e\u65e0\u6cd5\u4fdd\u5b58!")));
                            this.getPage().Output(saveResult.ToJSONString());
                            return true;
                        }
                        int nState = (Integer)callResult.getUserObject();
                        if (nState == 0) {
                            bInsert = true;
                        } else {
                            if (nState != 1) {
                                saveResult.setRetCode(5);
                                saveResult.AppendJSCode(BaseDAFormActionHelper.GetSetPageInfoJS(this.GetLocalization("CTRL.FORMAH.DATAALREADYREMOVED", "\u8be5\u6570\u636e\u5df2\u7ecf\u88ab\u5220\u9664!\u6570\u636e\u65e0\u6cd5\u4fdd\u5b58!")));
                                this.getPage().Output(saveResult.ToJSONString());
                                return true;
                            }
                            bInsert = false;
                        }
                    } else {
                        bInsert = !this.IsUpdateMode();
                    }
                }
                this.form1.RemoveInvalidValue(dataEntity, bInsert);
                if (bInsert) {
                    for (IDEFHelper iDEFHelper : this.getPage().getDEHelper().GetDEFHelpers()) {
                        if (iDEFHelper.IsKeyDEField()) continue;
                        String strDVT = iDEFHelper.GetFormCtrl().GetDefaultValueType();
                        String strDV = iDEFHelper.GetFormCtrl().GetDefaultValue();
                        if (StringHelper.Length((String)strDVT) == 0 && StringHelper.Length((String)strDV) == 0 || dataEntity.ContainesParam(iDEFHelper.getName())) continue;
                        dataEntity.SetParamValue(iDEFHelper.getName(), DADVHelper.GetDefaultValue((SRFExWebContext)this.getWebContext(), (String)strDVT, (String)strDV, (String)iDEFHelper.GetStdDataType()));
                    }
                }
                this.SetPageInfo("");
                if (!this.OnSaveActionAfterFillDataEntity(dataEntity, bInsert, formItemErrors)) {
                    saveResult.setRetCode(5);
                    formItemErrors.FillJSONs(saveResult.getItems());
                    String strErrorInfo = formItemErrors.getErrorInfo();
                    if (StringHelper.IsNullOrEmpty((String)strErrorInfo)) {
                        saveResult.AppendJSCode(this.GetSetPageInfoJSEx(this.GetLocalization("CTRL.FORMAH.INPUTERROR", "\u8f93\u5165\u6709\u8bef\uff0c\u6570\u636e\u65e0\u6cd5\u4fdd\u5b58!")));
                    } else {
                        saveResult.AppendJSCode(this.GetSetPageInfoJSEx(StringHelper.Format((String)this.GetLocalization("CTRL.FORMAH.INPUTERROR2", "\u6570\u636e\u65e0\u6cd5\u4fdd\u5b58\uff0c%1$s"), (Object)strErrorInfo)));
                    }
                    this.getPage().Output(saveResult.ToJSONString());
                    return true;
                }
                if (!bInsert) break block46;
                this.SetPageInfo("");
                callResult = this.OnSaveActionBeforeInsert(dataEntity);
                if (callResult.getRetCode() != 0) {
                    strErrorFormat = this.GetLocalization("CTRL.FORMAH.DATASAVEFAILED", "\u6570\u636e\u65e0\u6cd5\u4fdd\u5b58\uff0c%1$s");
                    String strErrorInfo = StringHelper.Format((String)strErrorFormat, (Object)callResult.getErrorInfo());
                    saveResult.From(callResult);
                    saveResult.setErrorInfo(strErrorInfo);
                    saveResult.AppendJSCode(this.GetSetPageInfoJSEx(strErrorInfo));
                    this.getPage().Output(saveResult.ToJSONString());
                    return true;
                }
                this.SetPageInfo("");
                String strInsertMode = "DEFAULT";
                if (this.formView != null) {
                    strInsertMode = this.formView.getINSERTMODE();
                }
                DefaultTransactionManager transactionManager = new DefaultTransactionManager();
                transactionManager.Init((ISRFDAGlobalHelper)this.getWebContext().getGlobalHelper());
                if (this.bTempDataMode) {
                    TempData tempData = new TempData();
                    tempData.setTEMPDATAID(dataEntity.GetParamStringValue("SRFDATEMPKEYID", ""));
                    IDEDataCtrl iTempDataCtrl = this.getWebContext().getGlobalHelper().getDAModelStorage().FindDEDataCtrl("DE0112", (ISRFDAWebContext)this.getWebContext());
                    if (iTempDataCtrl == null) {
                        log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61", (Object)"DE0112"));
                        saveResult.setRetCode(1);
                        saveResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61", (Object)"DE0112"));
                        saveResult.AppendJSCode(BaseDAFormActionHelper.GetSetPageInfoJS("\u6570\u636e\u4fdd\u5b58\u5931\u8d25"));
                        if (!StringHelper.IsNullOrEmpty((String)this.getWebContext().getSRFPageModel())) {
                            saveResult.setExtInfo("pageinfo", "\u6570\u636e\u4fdd\u5b58\u5931\u8d25");
                            saveResult.setExtInfo("pagedata", "");
                        }
                        this.getPage().Output(saveResult.ToJSONString());
                        return true;
                    }
                    callResult = iTempDataCtrl.Get((BaseDataEntity)tempData);
                    if (callResult.getRetCode() == 3 && !this.FillTempDataPDEInfo(tempData)) {
                        saveResult.setRetCode(1);
                        saveResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u7236\u5b9e\u4f53\u6570\u636e"));
                        saveResult.AppendJSCode(this.GetSetPageInfoJSEx(StringHelper.Format((String)"\u6570\u636e\u65e0\u6cd5\u65b0\u5efa\uff0c\u65e0\u6cd5\u83b7\u53d6\u7236\u5b9e\u4f53\u6570\u636e")));
                        this.getPage().Output(saveResult.ToJSONString());
                        return true;
                    }
                    this.FillMajorDataEntity(dataEntity);
                    tempData.setDEDATA(BaseDataEntity.ToString((BaseDataEntity)dataEntity));
                    tempData.setSAVEMODE(strInsertMode);
                    transactionManager.Register(iDEDataCtrl);
                    callResult = iDEDataCtrl.SaveTempData(tempData, dataEntity);
                    if (callResult.IsError()) {
                        transactionManager.Rollback();
                    } else {
                        transactionManager.Commit();
                    }
                    if (callResult.IsError()) {
                        saveResult.From(callResult);
                        saveResult.AppendJSCode(BaseDAFormActionHelper.GetSetPageInfoJS(StringHelper.Format((String)"\u4fdd\u5b58\u4e34\u65f6\u6570\u636e\u53d1\u751f\u9519\u8bef!%1$s", (Object)callResult.getErrorInfo())));
                        this.getPage().Output(saveResult.ToJSONString());
                        return true;
                    }
                    dataEntity.SetParamValue(this.getPage().getDEHelper().GetKeyDEFHelper().getName(), (Object)tempData.getTEMPDATAID());
                    break block47;
                } else {
                    transactionManager.Register(iDEDataCtrl);
                    dataEntity.SetParamValue("SRF_CHILDDATATAG", (Object)this.formView.getCHILDDATATAG());
                    callResult = iDEDataCtrl.Save(true, strInsertMode, dataEntity);
                    if (callResult.IsOk() && this.formView != null && !StringHelper.IsNullOrEmpty((String)this.formView.getGETMODE()) && StringHelper.Compare((String)this.formView.getGETMODE(), (String)strInsertMode, (boolean)true) != 0) {
                        callResult = this.getDEDataCtrl().Get(this.formView.getGETMODE(), dataEntity);
                    }
                    if (callResult.IsError()) {
                        transactionManager.Rollback();
                    } else {
                        transactionManager.Commit();
                    }
                    if (callResult.getRetCode() == 0) {
                        callResult = this.OnSaveActionAfterInsert(callResult, dataEntity);
                    }
                }
                break block47;
            }
            this.SetPageInfo("");
            callResult = this.OnSaveActionBeforeUpdate(dataEntity);
            if (callResult.getRetCode() != 0) {
                strErrorFormat = this.GetLocalization("CTRL.FORMAH.DATASAVEFAILED", "\u6570\u636e\u65e0\u6cd5\u4fdd\u5b58\uff0c%1$s");
                String strErrorInfo = StringHelper.Format((String)strErrorFormat, (Object)callResult.getErrorInfo());
                saveResult.From(callResult);
                saveResult.setErrorInfo(strErrorInfo);
                saveResult.AppendJSCode(this.GetSetPageInfoJSEx(strErrorInfo));
                this.getPage().Output(saveResult.ToJSONString());
                return true;
            }
            this.SetPageInfo("");
            String strUpdateMode = "";
            try {
                strUpdateMode = this.GetSaveActionUpdateMode();
            }
            catch (Exception ex) {
                log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u4fdd\u5b58\u64cd\u4f5c\u66f4\u65b0\u6a21\u5f0f\u53d1\u751f\u5f02\u5e38,%1$s", (Object)ex.getMessage()), (Throwable)ex);
                strUpdateMode = "DEFAULT";
            }
            DefaultTransactionManager transactionManager = new DefaultTransactionManager();
            transactionManager.Init((ISRFDAGlobalHelper)this.getWebContext().getGlobalHelper());
            transactionManager.Register(iDEDataCtrl);
            dataEntity.SetParamValue("SRF_CHILDDATATAG", (Object)this.formView.getCHILDDATATAG());
            callResult = iDEDataCtrl.Save(false, strUpdateMode, dataEntity);
            if (callResult.IsOk() && this.formView != null && !StringHelper.IsNullOrEmpty((String)this.formView.getGETMODE()) && StringHelper.Compare((String)this.formView.getGETMODE(), (String)strUpdateMode, (boolean)true) != 0) {
                callResult = this.getDEDataCtrl().Get(this.formView.getGETMODE(), dataEntity);
            }
            if (callResult.IsError()) {
                transactionManager.Rollback();
            } else {
                transactionManager.Commit();
            }
            if (callResult.getRetCode() == 0) {
                callResult = this.OnSaveActionAfterUpdate(callResult, dataEntity);
            }
        }
        saveResult.From(callResult);
        if (saveResult.getRetCode() != 0) {
            strErrorFormat = this.GetLocalization("CTRL.FORMAH.DATASAVEFAILED", "\u6570\u636e\u65e0\u6cd5\u4fdd\u5b58\uff0c%1$s");
            saveResult.AppendJSBeforeCode(this.GetExtJSBeforeCode());
            if (callResult.IsUserError()) {
                this.SetPageInfo("");
                this.FillFormUserErrors(this.form1, formItemErrors, callResult);
                saveResult.setRetCode(5);
                formItemErrors.FillJSONs(saveResult.getItems());
                saveResult.AppendJSCode(BaseDAFormActionHelper.GetSetPageInfoJS(StringHelper.Format((String)strErrorFormat, (Object)callResult.getErrorInfo())));
            } else {
                saveResult.AppendJSCode(BaseDAFormActionHelper.GetSetPageInfoJS(StringHelper.Format((String)strErrorFormat, (Object)callResult.getErrorInfo())));
            }
        } else {
            if (this.getWebContext().getSaveAndNewMode()) {
                return this.OnLoadDefaultAction();
            }
            if (!this.bTempDataMode) {
                this.CalcDataUrl(dataEntity, (SRFExFormActionResult)saveResult, false);
            }
            this.OnSaveActionFillForm(dataEntity);
            this.form1.FillValueJSON(saveResult.getItems(), this.getPage().isControlValueFromUniqueId());
            saveResult.AppendJSBeforeCode(this.GetExtJSBeforeCode());
            if (this.bTempDataMode) {
                saveResult.AppendJSCode(BaseDAFormActionHelper.GetSetPageDataJS(this.getPage().getDEHelper().GetDataInfo(dataEntity)));
            } else {
                saveResult.AppendJSCode(BaseDAFormActionHelper.GetSetPageDataJS(this.getPage().getDEHelper().GetDataInfo(dataEntity)));
            }
            saveResult.AppendJSCode(BaseDAFormActionHelper.GetSetWFMainStateJS(this.getPage().getDEHelper(), dataEntity.GetParamStringValue(this.getPage().getDEHelper().GetKeyDEFHelper().getName(), "")));
            String strInfoFormat = this.GetLocalization("CTRL.FORMAH.DATASAVEDSUCCESSFULLY", "\u6570\u636e\u4fdd\u5b58\u6210\u529f!");
            saveResult.AppendJSCode(this.GetSetPageInfoJSEx(strInfoFormat));
            saveResult.AppendJSCode(this.GetExtJSCode());
            saveResult.setUpdateFlag(true);
            if (!StringHelper.IsNullOrEmpty((String)this.getWebContext().getSRFPageModel())) {
                saveResult.setExtInfo("pageinfo", strInfoFormat);
                saveResult.setExtInfo("pagedata", this.getPage().getDEHelper().GetDataInfo(dataEntity));
            }
            saveResult.setFormState(this.GetFormState(false, dataEntity));
            saveResult.setSaveTag(this.getWebContext().GetPostValue("SRFSAVETAG"));
        }
        this.getPage().Output(this.OnSaveActionOutputResult(dataEntity, saveResult));
        return true;
    }

    protected void OnSaveActionFillForm(BaseDataEntity dataEntity) {
        if (this.bTempDataMode) {
            this.form1.FillByDataEntity(dataEntity, this.getWebContext().getCopyMode());
            this.form1.EnableFormItems(true);
            if (this.disableItems != null) {
                for (String strFormItemId : this.disableItems) {
                    this.form1.EnableFormItem(strFormItemId, false);
                }
            }
        } else {
            if (this.OnGetCheckDataUpdateDate()) {
                dataEntity.SetParamValue("SRFDAUPDATEDATE", dataEntity.GetParamValue("UPDATEDATE"));
            }
            this.form1.FillByDataEntity(dataEntity, false);
            if (this.IsDisableAllItems(dataEntity)) {
                this.form1.EnableAllFormItems(false);
            } else {
                this.form1.EnableFormItems(false);
                DEDSCtrl deDSCtrl = this.getPage().getDEHelper().GetDataAccHelper().FindFieldCtrl(dataEntity);
                if (deDSCtrl != null) {
                    this.form1.DisableFormItems(deDSCtrl.getCtrlFields(), StringHelper.Compare((String)deDSCtrl.getFIELDCTRLMODE(), (String)"DENY", (boolean)true) == 0);
                }
            }
        }
    }

    protected void OnSaveActionBeforeFillDataEntity(BaseDataEntity dataEntity) {
    }

    protected boolean OnSaveActionAfterFillDataEntity(BaseDataEntity dataEntity, boolean bInsert, SRFExFormItemErrors formItemErrors) {
        CallResult callResult;
        Vector errors = new Vector();
        String strActionMode = "DEFAULT";
        if (this.formView != null) {
            strActionMode = bInsert ? this.formView.getINSERTMODE() : this.formView.getUPDATEMODE();
        }
        if ((callResult = this.getDEDataCtrl().TestSave(bInsert, strActionMode, dataEntity, errors)).getRetCode() != 0) {
            formItemErrors.setRetCode(callResult.getRetCode());
            formItemErrors.setErrorInfo(callResult.getErrorInfo());
            for (ValueError valueError : errors) {
                SRFExControl control = this.form1.FindControl(valueError.getValue());
                if (control != null) {
                    formItemErrors.Register(control, valueError.getErrorCode(), valueError.getErrorInfo());
                    continue;
                }
                String strErrorInfo = "";
                IDEFHelper iDEFHelper = this.getPage().getDEHelper().GetDEFHelper(valueError.getValue());
                if (iDEFHelper != null) {
                    strErrorInfo = StringHelper.Format((String)"\u8868\u5355\u4e2d\u4e0d\u5b58\u5728[%1$s]", (Object)iDEFHelper.getLogicName(this.getPage().getLanguage()));
                }
                if (!StringHelper.IsNullOrEmpty((String)strErrorInfo) && !StringHelper.IsNullOrEmpty((String)callResult.getErrorInfo())) {
                    strErrorInfo = String.valueOf(strErrorInfo) + ",";
                }
                strErrorInfo = String.valueOf(strErrorInfo) + callResult.getErrorInfo();
                formItemErrors.Register("", "", 3, strErrorInfo);
            }
            return false;
        }
        return true;
    }

    protected boolean IsFormContainKey(BaseDataEntity dataEntity) {
        return this.getForm().IsContainerKeyValue(dataEntity);
    }

    protected boolean OnSaveActionFillDataEntity(BaseDataEntity dataEntity, SRFExFormItemErrors formItemErrors) {
        return this.getForm().FillDataEntity(dataEntity, false, formItemErrors, this.getPage().isControlValueFromUniqueId());
    }

    protected CallResult OnSaveActionBeforeInsert(BaseDataEntity dataEntity) {
        CallResult callResult;
        if (!this.bTempDataMode && this.bTestDataCreateAction && (callResult = this.OnTestDataAction(dataEntity, "CREATE")).getRetCode() != 0) {
            return callResult;
        }
        return this.getDEDataCtrl().TestDataLock(dataEntity, this.GetDataLockKey(dataEntity));
    }

    protected CallResult OnSaveActionBeforeUpdate(BaseDataEntity dataEntity) {
        String strAction;
        CallResult callResult;
        if (!this.bTempDataMode && this.bTestDataUpdateAction && (callResult = this.OnTestDataAction(dataEntity, strAction = this.GetUpdateDataAction())).getRetCode() != 0) {
            return callResult;
        }
        return this.getDEDataCtrl().TestDataLock(dataEntity, this.GetDataLockKey(dataEntity));
    }

    protected String GetUpdateDataAction() {
        String strAction = "";
        try {
            if (this.getFormView() != null && !this.getFormView().isUPDATEMODENull()) {
                strAction = this.getFormView().getUPDATEMODE();
            } else {
                IDEMainActionHelper iDEMainActionHelper = null;
                if (this.bEnableDEMainAction) {
                    iDEMainActionHelper = this.iDEMainActionHelper;
                } else if (this.bEnableDEMainState && this.iDEMainStateHelper != null) {
                    iDEMainActionHelper = this.iDEMainStateHelper.getEditDEMainAction();
                }
                if (iDEMainActionHelper != null) {
                    if (StringHelper.Compare((String)iDEMainActionHelper.getActionType(), (String)"UPDATE", (boolean)true) != 0) {
                        throw new Exception("\u4e3b\u64cd\u4f5c\u64cd\u4f5c\u7c7b\u578b\u4e0d\u6b63\u786e\uff0c\u5fc5\u987b\u4e3a[\u66f4\u65b0]");
                    }
                    strAction = iDEMainActionHelper.getDataAccessAction();
                } else {
                    strAction = "DEFAULT";
                }
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u66f4\u65b0\u64cd\u4f5c\u6570\u636e\u8bbf\u95ee\u64cd\u4f5c\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)e.getMessage()), (Throwable)e);
        }
        if (StringHelper.IsNullOrEmpty((String)strAction) || StringHelper.Compare((String)strAction, (String)"DEFAULT", (boolean)true) == 0 || StringHelper.Compare((String)strAction, (String)"WFACTION", (boolean)true) == 0) {
            strAction = "UPDATE";
        }
        return strAction;
    }

    protected CallResult OnTestDataAction(BaseDataEntity dataEntity, String strAction) {
        return this.getPage().getDEHelper().GetDataAccHelper().Test((ISRFDAWebContext)this.getWebContext(), dataEntity, strAction);
    }

    protected CallResult OnSaveActionAfterInsert(CallResult callResult, BaseDataEntity dataEntity) {
        String strCopyId = this.getWebContext().GetPostValue("SRFCOPYID");
        if (!StringHelper.IsNullOrEmpty((String)strCopyId)) {
            Object objSrcKey = this.getPage().getDEHelper().GetKeyDEFHelper().GetDEFValue(strCopyId);
            callResult = this.getDEDataCtrl().CopyDetail(dataEntity, objSrcKey);
        }
        return callResult;
    }

    protected CallResult OnSaveActionAfterUpdate(CallResult callResult, BaseDataEntity dataEntity) {
        return callResult;
    }

    protected String OnSaveActionOutputResult(BaseDataEntity dataEntity, SRFExFormSaveResult saveResult) {
        return saveResult.ToJSONString();
    }

    protected String OnRemoveActionOutputResult(BaseDataEntity dataEntity, SRFExFormRemoveResult removeResult) {
        return removeResult.ToJSONString();
    }

    protected CallResult OnRemoveActionBeforeRemove(BaseDataEntity dataEntity) {
        CallResult callResult;
        if (!this.bTempDataMode && (callResult = this.OnTestDataAction(dataEntity, "DELETE")).getRetCode() != 0) {
            return callResult;
        }
        return this.getDEDataCtrl().TestDataLock(dataEntity, this.GetDataLockKey(dataEntity));
    }

    protected boolean IsDisableAllItems(BaseDataEntity dataEntity) {
        boolean bRet = false;
        String strFormDisableState = this.getPage().getPageParam("PAGE.FORM.DISABLESTATE", "");
        if (StringHelper.IsNullOrEmpty((String)strFormDisableState) && !StringHelper.IsNullOrEmpty((String)(strFormDisableState = this.getWebContext().getWebExConfig().GetValue("SRFDA", "FORMDISABLESTATE", "")))) {
            if (this.bTempDataMode) {
                return false;
            }
            String[] actions = strFormDisableState.split("[|]");
            int i = 0;
            while (i < actions.length) {
                String strAction = actions[i];
                if (!StringHelper.IsNullOrEmpty((String)(strAction = strAction.trim()))) {
                    CallResult callResult = null;
                    boolean bTestDataLock = this.TestDataLock();
                    callResult = this.OnTestDataAction(dataEntity, strAction);
                    if (callResult.getRetCode() == 0 && bTestDataLock) {
                        callResult = this.getDEDataCtrl().TestDataLock(dataEntity, this.GetDataLockKey(dataEntity));
                    }
                    return callResult == null || callResult.getRetCode() != 0;
                }
                ++i;
            }
        }
        if (this.formView != null) {
            bRet = this.formView.GetFormProperty("DISABLEITEMS", bRet);
        }
        return this.getPage().getFormParam((SRFExBaseForm)this.form1, "DISABLEITEMS", bRet);
    }

    protected void FillFormUserErrors(SRFExForm form1, SRFExFormItemErrors formItemErrors, CallResult callResult) {
        Object objDBResult = callResult.getUserObject();
        if (objDBResult != null && objDBResult instanceof DBResult) {
            DBResult result = (DBResult)objDBResult;
            if (result.getOutValues().containsKey("SRF_TAG")) {
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
            } else {
                this.SetPageInfo(StringHelper.Format((String)"\u65e0\u6cd5\u4fdd\u5b58\u6570\u636e\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
        }
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
        Object obj = this.getPage().getPageParam(this.mainPanel.getID().toUpperCase());
        if (obj != null && obj instanceof Form) {
            this.formView = (Form)obj;
            return this.formView;
        }
        obj = this.getPage().getPageParam("FORMVIEW");
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

    protected BaseDataEntity CreateFormDataEntity() {
        return this.getPage().getDEHelper().CreateDEObject();
    }

    protected String GetSetPageInfoJSEx(String strDefaultInfo) {
        if (StringHelper.IsNullOrEmpty((String)this.strPageInfo)) {
            return BaseDAFormActionHelper.GetSetPageInfoJS(strDefaultInfo);
        }
        return BaseDAFormActionHelper.GetSetPageInfoJS(this.strPageInfo);
    }

    protected String GetSetPageInfoJS() {
        return BaseDAFormActionHelper.GetSetPageInfoJS(this.strPageInfo);
    }

    protected static String GetSetPageInfoJS(String strInfo) {
        if (!StringHelper.IsNullOrEmpty((String)strInfo)) {
            strInfo = strInfo.replace("\r", "<br>");
            strInfo = strInfo.replace("\n", "<br>");
            strInfo = strInfo.replace("\\", "\\\\");
        }
        return StringHelper.Format((String)"$P.setpageinfo(\"%1$s\");", (Object)WebUtility.GetJSONText((String)strInfo, (boolean)false));
    }

    protected static String GetSetPageDataJS(String strData) {
        if (!StringHelper.IsNullOrEmpty((String)strData)) {
            strData = strData.replace("\\", "\\\\");
        }
        return StringHelper.Format((String)"$P.setpagedata(\"%1$s\");", (Object)WebUtility.GetJSONText((String)strData, (boolean)false));
    }

    protected static String GetSetWFMainStateJS(IDEHelper iDEHelper, String strKeyData) {
        if (!iDEHelper.IsEnableWF()) {
            return "";
        }
        if (iDEHelper.GetDEWF() == null || StringHelper.IsNullOrEmpty((String)iDEHelper.GetDEWF().getMSCLID())) {
            return "";
        }
        if (!StringHelper.IsNullOrEmpty((String)strKeyData)) {
            strKeyData = strKeyData.replace("\\", "\\\\");
        }
        JSONObject jo = new JSONObject();
        jo.put("srfdeid", (Object)iDEHelper.getId());
        jo.put(iDEHelper.GetKeyDEFHelper().getName().toLowerCase(), (Object)strKeyData);
        return StringHelper.Format((String)"$P.setwfmainstate(%1$s);", (Object)jo.toString());
    }

    protected void SetPageInfo(String strPageInfo) {
        this.strPageInfo = strPageInfo;
    }

    protected void AppendExtJSCode(String strCode) {
        if (this.script == null) {
            this.script = new StringBuilderEx();
        }
        this.script.Append(strCode);
    }

    protected String GetExtJSCode() {
        if (this.script == null) {
            return "";
        }
        return this.script.toString();
    }

    protected void AppendExtJSBeforeCode(String strCode) {
        if (this.beforeScript == null) {
            this.beforeScript = new StringBuilderEx();
        }
        this.beforeScript.Append(strCode);
    }

    protected String GetExtJSBeforeCode() {
        if (this.beforeScript == null) {
            return "";
        }
        return this.beforeScript.toString();
    }

    protected String GetDataLockKey(BaseDataEntity dataEntity) {
        try {
            return this.getPage().getDEHelper().GetDataLockKey((ISRFDAWebContext)this.getWebContext(), dataEntity);
        }
        catch (Exception ex) {
            this.getPage().PageLog((Object)this, 1, StringHelper.Format((String)"\u83b7\u53d6\u6570\u636e\u5bf9\u8c61\u9501\u94a5\u5319\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), ex);
            return "";
        }
    }

    protected String GetFormState() {
        String strFormState = this.getPage().getPageParam("PAGE.FORMSTATE", "");
        if (StringHelper.IsNullOrEmpty((String)strFormState)) {
            String strUpdateAction = this.GetUpdateDataAction();
            strFormState = StringHelper.Format((String)"%1$s|%2$s|%3$s", (Object)"CREATE", (Object)strUpdateAction, (Object)"DELETE");
            String strDEDataActions = this.getPage().getDEHelper().GetDataAccHelper().GetDataActions();
            if (!StringHelper.IsNullOrEmpty((String)strDEDataActions)) {
                strFormState = String.valueOf(strFormState) + "|";
                strFormState = String.valueOf(strFormState) + strDEDataActions;
            }
        }
        return strFormState;
    }

    protected boolean IsDataActionTestDataLock(String strDataAction) {
        return true;
    }

    protected JSONObject GetFormState(boolean bCreate, BaseDataEntity dataEntity) {
        JSONObject jsonObject = new JSONObject();
        String strFormState = this.GetFormState();
        if (StringHelper.IsNullOrEmpty((String)strFormState)) {
            return jsonObject;
        }
        if (this.bTempDataMode) {
            String[] actions = strFormState.split("[|]");
            int i = 0;
            while (i < actions.length) {
                String strAction = actions[i];
                if (!StringHelper.IsNullOrEmpty((String)(strAction = strAction.trim())) && !jsonObject.has(strAction.toLowerCase())) {
                    jsonObject.put(strAction.toLowerCase(), true);
                }
                ++i;
            }
        } else {
            String[] actions = strFormState.split("[|]");
            int i = 0;
            while (i < actions.length) {
                String strAction = actions[i];
                if (!StringHelper.IsNullOrEmpty((String)(strAction = strAction.trim())) && !jsonObject.has(strAction.toLowerCase())) {
                    CallResult callResult = null;
                    CallResult dataLockTestResult = null;
                    boolean bTestDataLock = this.TestDataLock();
                    if (bTestDataLock) {
                        dataLockTestResult = this.getDEDataCtrl().TestDataLock(dataEntity, this.GetDataLockKey(dataEntity));
                    }
                    if (StringHelper.Compare((String)strAction, (String)"UPDATE", (boolean)true) == 0 || StringHelper.Compare((String)strAction, (String)"WFSTART", (boolean)true) == 0) {
                        if (bCreate) {
                            callResult = this.OnTestDataAction(dataEntity, "CREATE");
                            bTestDataLock = false;
                        } else {
                            callResult = this.OnTestDataAction(dataEntity, strAction);
                        }
                    } else {
                        callResult = this.OnTestDataAction(dataEntity, strAction);
                        if (StringHelper.Compare((String)strAction, (String)"CREATE", (boolean)true) == 0) {
                            bTestDataLock = false;
                        }
                    }
                    if (callResult.getRetCode() == 0 && bTestDataLock) {
                        callResult = dataLockTestResult;
                    }
                    if (callResult == null || callResult.getRetCode() != 0) {
                        jsonObject.put(strAction.toLowerCase(), false);
                    } else {
                        jsonObject.put(strAction.toLowerCase(), true);
                    }
                }
                ++i;
            }
            if (bCreate && jsonObject.has("DELETE".toLowerCase())) {
                jsonObject.remove("DELETE".toLowerCase());
                jsonObject.put("DELETE".toLowerCase(), false);
            }
            this.OnSetMainFormState(jsonObject, bCreate, dataEntity);
        }
        return jsonObject;
    }

    protected void OnSetMainFormState(JSONObject jsonObject, boolean bCreate, BaseDataEntity dataEntity) {
    }

    protected boolean TestDataLock() {
        return true;
    }

    protected boolean IsUpdateMode() {
        return this.bUpdateFlag;
    }

    protected final String GetSaveActionUpdateMode() throws Exception {
        return this.OnGetSaveActionUpdateMode();
    }

    protected String OnGetSaveActionUpdateMode() throws Exception {
        if (this.getFormView() != null && !this.getFormView().isUPDATEMODENull()) {
            return this.getFormView().getUPDATEMODE();
        }
        IDEMainActionHelper iDEMainActionHelper = null;
        if (this.bEnableDEMainAction) {
            iDEMainActionHelper = this.iDEMainActionHelper;
        } else if (this.bEnableDEMainState && this.iDEMainStateHelper != null) {
            iDEMainActionHelper = this.iDEMainStateHelper.getEditDEMainAction();
        }
        if (iDEMainActionHelper != null) {
            if (StringHelper.Compare((String)iDEMainActionHelper.getActionType(), (String)"UPDATE", (boolean)true) != 0) {
                throw new Exception("\u4e3b\u64cd\u4f5c\u64cd\u4f5c\u7c7b\u578b\u4e0d\u6b63\u786e\uff0c\u5fc5\u987b\u4e3a[\u66f4\u65b0]");
            }
            return iDEMainActionHelper.getActionMode();
        }
        return "DEFAULT";
    }

    protected boolean IsEnableNew() {
        if (this.getFormView() != null && !this.getFormView().isENABLENEWNull()) {
            return this.getFormView().getENABLENEW();
        }
        return true;
    }

    protected boolean OnItemUpdateAction(String strAction) {
        String strMessage;
        SRFExFormLoadResult loadResult = new SRFExFormLoadResult();
        FIUpdate fiUpdate = this.getPage().getDAModelStorage().FindFIUpdate(this.getPage().getPageDataEntityId(), strAction);
        if (fiUpdate == null) {
            loadResult.setRetCode(1);
            loadResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u8868\u5355\u9879\u586b\u5145\u6a21\u5f0f[%1$s-%2$s]", (Object)this.getPage().getPageDataEntityId(), (Object)strAction));
            this.getPage().PageLog((Object)this, 1, loadResult.getErrorInfo());
            this.getPage().Output(loadResult.ToJSONString());
            return true;
        }
        String strActionMode = fiUpdate.GetParamStringValue("ACTIONMODE", "");
        SRFExFormItemErrors formItemErrors = new SRFExFormItemErrors();
        BaseDataEntity dataEntity = this.CreateFormDataEntity();
        if (!this.form1.FillDataEntity(dataEntity, true, formItemErrors, this.getPage().isControlValueFromUniqueId())) {
            loadResult.setRetCode(5);
            if (!StringHelper.IsNullOrEmpty((String)this.getWebContext().getSRFPageModel())) {
                loadResult.setExtInfo("pagedata", "");
            }
            this.getPage().Output(loadResult.ToJSONString());
            return true;
        }
        CallResult callResult = this.getDEDataCtrl().CustomCall(strActionMode, dataEntity);
        if (callResult.IsError()) {
            loadResult.From(callResult);
            loadResult.AppendJSCode(BaseDAFormActionHelper.GetSetPageDataJS(""));
            loadResult.AppendJSCode(BaseDAFormActionHelper.GetSetPageInfoJS(StringHelper.Format((String)"\u6267\u884c\u903b\u8f91\u64cd\u4f5c[%1$s]\u5931\u8d25\uff0c%2$s", (Object)strActionMode, (Object)callResult.getErrorInfo())));
            this.getPage().Output(loadResult.ToJSONString());
            return true;
        }
        String strInfoField = fiUpdate.getInfoField();
        if (!StringHelper.IsNullOrEmpty((String)strInfoField) && !StringHelper.IsNullOrEmpty((String)(strMessage = dataEntity.GetParamStringValue(strInfoField, "")))) {
            loadResult.AppendJSCode(BrowserJSHelper.getAlertMessageScript((String)strMessage));
        }
        this.getForm().FillByDataEntity(dataEntity, false);
        this.getForm().FillValueJSON(loadResult.getItems(), this.getPage().isControlValueFromUniqueId(), fiUpdate.getRelatedFields());
        this.getPage().Output(loadResult.ToJSONString());
        return true;
    }

    protected boolean IsEnableModifyPData() {
        if (this.formView != null) {
            return this.formView.GetFormProperty("MODIFYPDATA", false);
        }
        return false;
    }

    protected boolean OnCustomAction(String strAction) {
        if (StringHelper.Compare((String)strAction, (String)"srfbehavior", (boolean)true) == 0) {
            this.OnDEBehavior(this.getWebContext().GetPostValue("srfbehaviorid"));
            return true;
        }
        return super.OnCustomAction(strAction);
    }

    protected boolean OnDEBehaviorFillDataEntity(BaseDataEntity dataEntity, SRFExFormItemErrors formItemErrors) {
        return this.getForm().FillDataEntity(dataEntity, true, formItemErrors);
    }

    protected void OnDEBehavior(String strDEBehaviorId) {
        CallResult callResult;
        SRFExFormCustomCallResult loadResult = new SRFExFormCustomCallResult();
        this.getWebContext().setActiveAjaxActionResult((SRFExAjaxActionResult)loadResult);
        DEBehavior deBehavior = this.getWebContext().getGlobalHelper().getDAModelStorage().FindDEBehavior(strDEBehaviorId);
        if (deBehavior == null) {
            loadResult.setRetCode(1);
            loadResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53\u754c\u9762\u884c\u4e3a[%1$s]", (Object)strDEBehaviorId));
            this.getPage().Output(loadResult.ToJSONString());
            return;
        }
        if (!StringHelper.IsNullOrEmpty((String)deBehavior.getRESOURCEID()) && !this.getWebContext().GetUserPrivilegeMgr().Test((SRFExWebContext)this.getWebContext(), deBehavior.getRESOURCEID())) {
            loadResult.setRetCode(2);
            loadResult.setErrorInfo(StringHelper.Format((String)"\u5b9e\u4f53\u754c\u9762\u884c\u4e3a[%1$s]\u6743\u9650\u4e0d\u8db3", (Object)deBehavior.getDEACTIONNAME()));
            this.getPage().Output(loadResult.ToJSONString());
            return;
        }
        if (StringHelper.IsNullOrEmpty((String)deBehavior.getDEACTIONID())) {
            loadResult.setRetCode(1);
            loadResult.setErrorInfo(StringHelper.Format((String)"\u6ca1\u6709\u6307\u5b9a\u5b9e\u4f53\u754c\u9762\u884c\u4e3a[%1$s]\u6240\u5bf9\u5e94\u7684\u5b9e\u4f53\u64cd\u4f5c", (Object)deBehavior.getDEACTIONNAME()));
            this.getPage().Output(loadResult.ToJSONString());
            return;
        }
        DEAction deAction = this.getPage().getDEHelper().GetDEAction(deBehavior.getDEACTIONID());
        if (deAction == null) {
            loadResult.setRetCode(1);
            loadResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53\u64cd\u4f5c\u884c\u4e3a[%1$s]", (Object)deBehavior.getDEACTIONID()));
            this.getPage().Output(loadResult.ToJSONString());
            return;
        }
        SRFExFormItemErrors formItemErrors = new SRFExFormItemErrors();
        BaseDataEntity dataEntity = this.CreateFormDataEntity();
        this.OnSaveActionBeforeFillDataEntity(dataEntity);
        if (!this.OnDEBehaviorFillDataEntity(dataEntity, formItemErrors)) {
            loadResult.setRetCode(5);
            formItemErrors.FillJSONs(loadResult.getItems());
            loadResult.AppendJSCode(BaseDAFormActionHelper.GetSetPageInfoJS(this.GetLocalization("CTRL.FORMAH.INPUTERROR", "\u8f93\u5165\u6709\u8bef\uff0c\u6570\u636e\u65e0\u6cd5\u64cd\u4f5c!")));
            this.getPage().Output(loadResult.ToJSONString());
            return;
        }
        if (!StringHelper.IsNullOrEmpty((String)deAction.getDEDATAACTION()) && (callResult = this.OnTestDataAction(dataEntity, deAction.getDEDATAACTION())).getRetCode() != 0) {
            loadResult.From(callResult);
            loadResult.AppendJSCode(BaseDAFormActionHelper.GetSetPageDataJS(""));
            loadResult.AppendJSCode(BaseDAFormActionHelper.GetSetPageInfoJS(callResult.getErrorInfo()));
            this.getPage().Output(loadResult.ToJSONString());
            return;
        }
        IDEDataCtrl iDEDataCtrl = this.getDEDataCtrl();
        DefaultTransactionManager transactionManager = new DefaultTransactionManager();
        transactionManager.Init((ISRFDAGlobalHelper)this.getWebContext().getGlobalHelper());
        transactionManager.Register(iDEDataCtrl);
        CallResult callResult2 = iDEDataCtrl.Execute(deAction, dataEntity);
        if (callResult2.IsError()) {
            transactionManager.Rollback();
        } else {
            transactionManager.Commit();
        }
        if (callResult2.getRetCode() != 0) {
            if (callResult2.IsUserError()) {
                callResult2.setRetCode(5);
                formItemErrors.FillJSONs(loadResult.getItems());
            }
            loadResult.From(callResult2);
            loadResult.AppendJSCode(BaseDAFormActionHelper.GetSetPageDataJS(""));
            loadResult.AppendJSCode(BaseDAFormActionHelper.GetSetPageInfoJS(StringHelper.Format((String)"\u6267\u884c\u64cd\u4f5c\u5931\u8d25\uff0c%1$s", (Object)callResult2.getErrorInfo())));
            if (!StringHelper.IsNullOrEmpty((String)this.getWebContext().getSRFPageModel())) {
                loadResult.setExtInfo("pageinfo", StringHelper.Format((String)"\u6267\u884c\u64cd\u4f5c\u5931\u8d25\uff0c%1$s", (Object)callResult2.getErrorInfo()));
                loadResult.setExtInfo("pagedata", "");
            }
        } else {
            if (!StringHelper.IsNullOrEmpty((String)deBehavior.getSUCCESSINFO())) {
                loadResult.AppendJSCode(StringHelper.Format((String)"alert('%1$s');", (Object)deBehavior.getSUCCESSINFO()));
            }
            if (!StringHelper.IsNullOrEmpty((String)deBehavior.getSUCCESSCODE())) {
                loadResult.AppendJSCode(deBehavior.getSUCCESSCODE());
            }
            if (deBehavior.getRELOADDATA()) {
                loadResult.setFillForm(true);
                this.OnDEBehaviorFillForm(dataEntity);
                this.form1.FillValueJSON(loadResult.getItems(), this.getPage().isControlValueFromUniqueId());
                loadResult.setUpdateFlag(true);
                loadResult.setFormState(this.GetFormState(false, dataEntity));
                if (!StringHelper.IsNullOrEmpty((String)this.getWebContext().getSRFPageModel())) {
                    loadResult.setExtInfo("pageinfo", "");
                    loadResult.setExtInfo("pagedata", this.getPage().getDEHelper().GetDataInfo(dataEntity));
                }
            }
        }
        this.getPage().Output(loadResult.ToJSONString());
    }

    protected void OnDEBehaviorFillForm(BaseDataEntity dataEntity) {
        if (this.bTempDataMode) {
            this.form1.FillDataEntityDV(dataEntity, false);
            this.form1.FillByDataEntity(dataEntity, false);
            this.form1.EnableFormItems(true);
        } else {
            this.form1.FillDataEntityDV(dataEntity, true);
            if (this.getWebContext().getCopyMode()) {
                this.getDEDataCtrl().RemoveUncopyValue(dataEntity);
            }
            if (this.OnGetCheckDataUpdateDate()) {
                dataEntity.SetParamValue("SRFDAUPDATEDATE", dataEntity.GetParamValue("UPDATEDATE"));
            }
            this.form1.FillByDataEntity(dataEntity, this.getWebContext().getCopyMode());
            if (!this.getWebContext().getCopyMode() && this.IsDisableAllItems(dataEntity)) {
                this.form1.EnableAllFormItems(false);
            } else {
                this.form1.EnableFormItems(this.getWebContext().getCopyMode());
                DEDSCtrl deDSCtrl = this.getPage().getDEHelper().GetDataAccHelper().FindFieldCtrl(dataEntity);
                if (deDSCtrl != null) {
                    this.form1.DisableFormItems(deDSCtrl.getCtrlFields(), StringHelper.Compare((String)deDSCtrl.getFIELDCTRLMODE(), (String)"DENY", (boolean)true) == 0);
                }
            }
        }
    }

    public String GetLocalization(String strResId, String strDefault) {
        return this.getPage().GetLocalization(strResId, strDefault);
    }

    protected boolean CalcDataUrl(BaseDataEntity dataEntity, SRFExFormActionResult result, boolean bCopyMode) {
        block12: {
            if (!this.bEnableDEMainState) {
                return true;
            }
            try {
                IDEHelper iDEHelper = this.getPage().getDEHelper();
                boolean bFormDigestChanged = false;
                if (this.iFormViewPage != null && this.iFormViewPage.isEnableFormDigest()) {
                    String strFormDigestData = BaseDataEntity.CalcDigest((BaseDataEntity)(bCopyMode ? null : dataEntity), (String)this.iFormViewPage.getFormData().getSENSITIVEFIELDS());
                    bFormDigestChanged = StringHelper.Compare((String)strFormDigestData, (String)this.iFormViewPage.getFormDigestData(), (boolean)false) != 0;
                }
                IDEMainStateHelper curMainStateHelper = null;
                if (this.bEnableDEMainState) {
                    curMainStateHelper = dataEntity != null && !bCopyMode ? iDEHelper.CalcDEMainState(dataEntity) : iDEHelper.GetDefaultDEMainState();
                }
                if (curMainStateHelper != this.iDEMainStateHelper || bFormDigestChanged) {
                    Hashtable queryParams = SRFDAWebCTXHelper.GetQueryParamsWithoutDAParams((ISRFDAWebContext)this.getWebContext());
                    queryParams.put("SRFDEID", iDEHelper.getId());
                    if (dataEntity != null) {
                        queryParams.put(iDEHelper.GetKeyDEFHelper().getName(), dataEntity.GetParamStringValue(iDEHelper.GetKeyDEFHelper().getName(), ""));
                        if (bCopyMode) {
                            queryParams.put("SRFNEWDATA", "TRUE");
                            queryParams.put("SRFCOPYMODE", "TRUE");
                        } else {
                            queryParams.remove("SRFNEWDATA");
                        }
                    } else {
                        queryParams.put("SRFNEWDATA", "TRUE");
                    }
                    String strPageId = "";
                    if (curMainStateHelper == null) {
                        strPageId = iDEHelper.GetEditPageId();
                    } else {
                        queryParams.put("SRFDEMAINSTATE", curMainStateHelper.getName());
                        strPageId = curMainStateHelper.getSDPageId();
                    }
                    String strPagePath = PagePathHelper.CalcPath((ISRFDAGlobalHelper)this.getWebContext().getGlobalHelper(), strPageId, DefaultPageHelper.GetEditViewPage(), queryParams);
                    result.setDataUrl(strPagePath);
                    break block12;
                }
                return true;
            }
            catch (Exception ex) {
                log.error((Object)StringHelper.Format((String)"\u8ba1\u7b97\u6570\u636e\u6240\u5bf9\u5e94\u7684\u5c55\u793a\u8def\u5f84\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            }
        }
        return true;
    }

    protected boolean OnGetCheckDataUpdateDate() {
        if (this.formView.isSAVECHECKNull()) {
            return true;
        }
        return this.formView.getSAVECHECK();
    }

    protected boolean isTempDataMode() {
        return this.bTempDataMode;
    }
}

