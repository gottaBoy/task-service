/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.DEFHelper.IDEFHelper
 *  SA.SRFDA.Ctrl.Data.DEWF
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFDA.Ctrl.IDEDataLockKeyHelper
 *  SA.SRFDA.Ctrl.IDEHelper
 *  SA.SRFDA.Web.ISRFDAWebContext
 *  SA.SRFDA.Web.SRFDAWebCTXHelper
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SRFWF.Client.WFCallResult
 *  SRFWF.Client.WFClientAPI
 *  SRFWF.Client.WFGetIAActionsResult
 *  SRFWF.Ctrl.SRFWFStates
 */
package SA.SRFDA.WF.Ctrl;

import SA.SRFDA.Ctrl.DEFHelper.IDEFHelper;
import SA.SRFDA.Ctrl.Data.DEWF;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.Ctrl.IDEDataLockKeyHelper;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFDA.Web.SRFDAWebCTXHelper;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SRFWF.Client.WFCallResult;
import SRFWF.Client.WFClientAPI;
import SRFWF.Client.WFGetIAActionsResult;
import SRFWF.Ctrl.SRFWFStates;

public class WFDataLockKeyHelper
implements IDEDataLockKeyHelper {
    public String GetDataLockKey(ISRFDAWebContext webContext, IDEHelper iDEHelper, BaseDataEntity dataEntity) throws Exception {
        if (iDEHelper.IsEnableWF()) {
            return "";
        }
        if (iDEHelper.GetMajorDEHelper() == null || !iDEHelper.GetMajorDEHelper().IsEnableWF()) {
            return "";
        }
        return this.OnGetMajorDEDataLockKey(webContext, iDEHelper, iDEHelper.GetMajorDEHelper(), dataEntity);
    }

    protected String OnGetMajorDEDataLockKey(ISRFDAWebContext webContext, IDEHelper iDEHelper, IDEHelper iMajorDEHelper, BaseDataEntity dataEntity) throws Exception {
        String strWFStepColumnName;
        BaseDataEntity majorData = this.OnGetMajorData(webContext, iDEHelper, iDEHelper.GetMajorDEHelper(), dataEntity);
        if (majorData == null) {
            return "";
        }
        DEWF dewf = iMajorDEHelper.GetDEWF();
        if (dewf == null) {
            throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u5de5\u4f5c\u6d41\u914d\u7f6e", (Object)iMajorDEHelper.getId()));
        }
        String strWFStateColumnName = dewf.getWFSTATEDEFID();
        if (!StringHelper.IsNullOrEmpty((String)strWFStateColumnName)) {
            IDEFHelper iDEFHelper = iMajorDEHelper.GetDEFHelper(strWFStateColumnName);
            strWFStateColumnName = iDEFHelper != null ? iDEFHelper.getName() : "";
        }
        if (!StringHelper.IsNullOrEmpty((String)(strWFStepColumnName = dewf.getWFSTEPDEFID()))) {
            IDEFHelper iDEFHelper = iMajorDEHelper.GetDEFHelper(strWFStepColumnName);
            strWFStepColumnName = iDEFHelper != null ? iDEFHelper.getName() : "";
        }
        if (StringHelper.IsNullOrEmpty((String)strWFStateColumnName)) {
            throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u5de5\u4f5c\u6d41\u72b6\u6001\u5c5e\u6027", (Object)iMajorDEHelper.getId()));
        }
        String strWFState = SRFWFStates.ToString((int)majorData.GetParamIntValue(strWFStateColumnName, 0));
        if (StringHelper.Compare((String)strWFState, (String)"WFNOTFINISH", (boolean)true) != 0) {
            return "";
        }
        if (StringHelper.IsNullOrEmpty((String)strWFStepColumnName)) {
            throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u5de5\u4f5c\u6d41\u6b65\u9aa4\u5c5e\u6027", (Object)iMajorDEHelper.getId()));
        }
        String strWFStep = majorData.GetParamStringValue(strWFStepColumnName, "");
        String strEditableWFStep = dewf.getEDITABLEWFSTEP();
        if (StringHelper.IsNullOrEmpty((String)strEditableWFStep)) {
            return "";
        }
        boolean bEnableUpdate = false;
        String[] editableWFStep = StringHelper.SplitEx((String)strEditableWFStep);
        int i = 0;
        while (i < editableWFStep.length) {
            if (StringHelper.Compare((String)strWFStep, (String)editableWFStep[i], (boolean)true) == 0) {
                bEnableUpdate = true;
                break;
            }
            ++i;
        }
        if (!bEnableUpdate) {
            return "";
        }
        CallResult callResult = WFDataLockKeyHelper.TestWFAction(webContext, iMajorDEHelper, majorData.GetParamStringValue(iMajorDEHelper.GetKeyDEFHelper().getName(), ""), strWFStep);
        if (callResult.getRetCode() == 0) {
            String strDataLockKey = StringHelper.Format((String)"WFINSTID:%1$s", (Object)callResult.getUserObject());
            return strDataLockKey;
        }
        return "";
    }

    protected BaseDataEntity OnGetMajorData(ISRFDAWebContext webContext, IDEHelper iDEHelper, IDEHelper iMajorDEHelper, BaseDataEntity dataEntity) throws Exception {
        BaseDataEntity majorData = new BaseDataEntity();
        Object objKey = dataEntity.GetParamValue(iDEHelper.GetMajorDEPickupField());
        if (objKey == null) {
            IDEDataCtrl dataCtrl = iDEHelper.GetDEDataCtrl("", webContext);
            if (dataCtrl == null) {
                throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61", (Object)iDEHelper.getId()));
            }
            BaseDataEntity dataEntity2 = new BaseDataEntity();
            dataEntity.CopyTo(dataEntity2, false);
            CallResult callResult = dataCtrl.Get(dataEntity2);
            if (callResult.IsError()) {
                throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e[%2$s]\u53d1\u751f\u9519\u8bef\uff0c%3$s", (Object)iDEHelper.getId(), (Object)dataEntity2.GetParamValue(iDEHelper.GetKeyDEFHelper().getName()), (Object)callResult.getErrorInfo()));
            }
            objKey = dataEntity2.GetParamValue(iDEHelper.GetMajorDEPickupField());
        }
        majorData.SetParamValue(iMajorDEHelper.GetKeyDEFHelper().getName(), objKey);
        IDEDataCtrl majorDataCtrl = iMajorDEHelper.GetDEDataCtrl("", webContext);
        if (majorDataCtrl == null) {
            throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61", (Object)iMajorDEHelper.getId()));
        }
        CallResult callResult = majorDataCtrl.Get(majorData);
        if (callResult.IsError() && callResult.getRetCode() == 3) {
            return null;
        }
        return majorData;
    }

    protected static CallResult TestWFAction(ISRFDAWebContext webContext, IDEHelper iMajorDEHelper, String strKeyValue, String strStepName) throws Exception {
        WFClientAPI wfClientAPI = new WFClientAPI();
        String strWFWSUrl = webContext.getGlobalHelper().getWebExConfig().GetValue("SRFDA", "WFWSURL", "");
        CallResult callResult = wfClientAPI.Init(strWFWSUrl, true);
        if (callResult == null || callResult.getRetCode() != 0) {
            throw new Exception(StringHelper.Format((String)"\u521d\u59cb\u5316\u5de5\u4f5c\u6d41WS\u94fe\u63a5\u5931\u8d25\uff0c%1$s", (Object)(callResult == null ? "\u672a\u77e5\u9519\u8bef" : callResult.getErrorInfo())));
        }
        String strWFMode = SRFDAWebCTXHelper.GetWFMode((ISRFDAWebContext)webContext);
        String strWFId = iMajorDEHelper.GetDEWFId(strWFMode);
        WFGetIAActionsResult wfGetIAActionsResult = wfClientAPI.GetIAActions(strWFId, webContext.getCurUserId(), "", strStepName, "", "", "", "");
        if (wfGetIAActionsResult == null || wfGetIAActionsResult.getRetCode() != 0) {
            throw new Exception(StringHelper.Format((String)StringHelper.Format((String)"\u83b7\u53d6\u5de5\u4f5c\u6d41\u4ea4\u4e92\u6b65\u9aa4\u5931\u8d25\uff0c%1$s", (Object)wfGetIAActionsResult.getErrorInfo())));
        }
        String strProcessName = wfGetIAActionsResult.getProcessName();
        WFCallResult wfCallResult = wfClientAPI.TestSubmitIAAction(strWFId, webContext.getCurUserId(), strKeyValue, "", "", iMajorDEHelper.getId(), strProcessName, "", "", "", "");
        if (wfCallResult == null || wfCallResult.getRetCode() != 0) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u6d4b\u8bd5\u5de5\u4f5c\u6d41\u4ea4\u4e92\u64cd\u4f5c\u5931\u8d25\uff0c%1$s", (Object)(wfCallResult == null ? "\u672a\u77e5\u9519\u8bef" : wfCallResult.getErrorInfo())));
            return callResult;
        }
        callResult.setUserObject((Object)wfCallResult.getRunInfo());
        return callResult;
    }
}

