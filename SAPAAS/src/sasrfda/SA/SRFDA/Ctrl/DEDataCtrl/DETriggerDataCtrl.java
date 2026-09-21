/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.Ctrl.DEDataCtrl;

import SA.SRFDA.Ctrl.BaseDEDataCtrl;
import SA.SRFDA.Ctrl.DBUtility;
import SA.SRFDA.Ctrl.Data.DETrigger;
import SA.SRFDA.Ctrl.Data.TriggerCode;
import SA.SRFDA.Ctrl.IDBModelHelper;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;

public class DETriggerDataCtrl
extends BaseDEDataCtrl {
    @Override
    protected CallResult OnAfterSaveOK(boolean bInsert, String strActionMode, BaseDataEntity dataEntity, BaseDataEntity lastDataEntity) {
        CallResult callResult = super.OnAfterSaveOK(bInsert, strActionMode, dataEntity, lastDataEntity);
        if (callResult.IsError()) {
            return callResult;
        }
        DETrigger deTrigger = new DETrigger();
        deTrigger.Proxy(dataEntity);
        IDEHelper iMajorDEHelper = this.globalHelperEx.getDAModelStorage().FindDEHelper(deTrigger.getDEID());
        if (iMajorDEHelper == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u4e3b\u5b9e\u4f53[%1$s]\u8f85\u52a9\u5bf9\u8c61", (Object)deTrigger.getDEID()));
            return callResult;
        }
        IDBModelHelper iDBModelHelper = DBUtility.GetDBModelHelper(iMajorDEHelper.getDataEntity(), this.globalHelperEx);
        IDEDataCtrl triggerCodeDataCtrl = this.globalHelperEx.getDAModelStorage().FindDEDataCtrlEx("DE0133", this);
        if (triggerCodeDataCtrl == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61", (Object)"DE0133"));
            return callResult;
        }
        TriggerCode triggerCode = new TriggerCode();
        triggerCode.setDETRIGGERID(deTrigger.getDETRIGGERID());
        triggerCode.setDBTYPE(iDBModelHelper.GetDBType());
        callResult = triggerCodeDataCtrl.Select(triggerCode);
        if (callResult.IsOk()) {
            callResult = iDBModelHelper.AddTrigger(deTrigger, triggerCode);
        } else if (callResult.getRetCode() == 3) {
            callResult.Reset();
        }
        return callResult;
    }

    @Override
    protected CallResult OnAfterRemoveOK(String strActionMode, BaseDataEntity dataEntity) {
        CallResult callResult = super.OnAfterRemoveOK(strActionMode, dataEntity);
        if (callResult.IsError()) {
            return callResult;
        }
        DETrigger deTrigger = new DETrigger();
        deTrigger.Proxy(dataEntity);
        IDEHelper iMajorDEHelper = this.globalHelperEx.getDAModelStorage().FindDEHelper(deTrigger.getDEID());
        if (iMajorDEHelper == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u4e3b\u5b9e\u4f53[%1$s]\u8f85\u52a9\u5bf9\u8c61", (Object)deTrigger.getDEID()));
            return callResult;
        }
        IDBModelHelper iDBModelHelper = DBUtility.GetDBModelHelper(iMajorDEHelper.getDataEntity(), this.globalHelperEx);
        callResult = iDBModelHelper.DropTrigger(deTrigger);
        return callResult;
    }
}

