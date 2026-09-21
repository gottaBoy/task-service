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

public class TriggerCodeDataCtrl
extends BaseDEDataCtrl {
    @Override
    protected CallResult OnAfterSaveOK(boolean bInsert, String strActionMode, BaseDataEntity dataEntity, BaseDataEntity lastDataEntity) {
        CallResult callResult = super.OnAfterSaveOK(bInsert, strActionMode, dataEntity, lastDataEntity);
        if (callResult.IsError()) {
            return callResult;
        }
        TriggerCode triggerCode = new TriggerCode();
        triggerCode.Proxy(dataEntity);
        IDEDataCtrl deTriggerDataCtrl = this.globalHelperEx.getDAModelStorage().FindDEDataCtrlEx("DE0131", this);
        if (deTriggerDataCtrl == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61", (Object)"DE0131"));
            return callResult;
        }
        DETrigger deTrigger = new DETrigger();
        deTrigger.setDETRIGGERID(triggerCode.getDETRIGGERID());
        callResult = deTriggerDataCtrl.Get(deTrigger);
        if (callResult.IsError()) {
            return callResult;
        }
        IDEHelper iMajorDEHelper = this.globalHelperEx.getDAModelStorage().FindDEHelper(deTrigger.getDEID());
        if (iMajorDEHelper == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u4e3b\u5b9e\u4f53[%1$s]\u8f85\u52a9\u5bf9\u8c61", (Object)deTrigger.getDEID()));
            return callResult;
        }
        IDBModelHelper iDBModelHelper = DBUtility.GetDBModelHelper(iMajorDEHelper.getDataEntity(), this.globalHelperEx);
        if (StringHelper.Compare((String)iDBModelHelper.GetDBType(), (String)triggerCode.getDBTYPE(), (boolean)true) == 0) {
            callResult = iDBModelHelper.AddTrigger(deTrigger, triggerCode);
        }
        return callResult;
    }

    @Override
    protected CallResult OnAfterRemoveOK(String strActionMode, BaseDataEntity dataEntity) {
        CallResult callResult = super.OnAfterRemoveOK(strActionMode, dataEntity);
        if (callResult.IsError()) {
            return callResult;
        }
        TriggerCode triggerCode = new TriggerCode();
        triggerCode.Proxy(dataEntity);
        IDEDataCtrl deTriggerDataCtrl = this.globalHelperEx.getDAModelStorage().FindDEDataCtrlEx("DE0131", this);
        if (deTriggerDataCtrl == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61", (Object)"DE0131"));
            return callResult;
        }
        DETrigger deTrigger = new DETrigger();
        deTrigger.setDETRIGGERID(triggerCode.getDETRIGGERID());
        callResult = deTriggerDataCtrl.Get(deTrigger);
        if (callResult.IsError()) {
            return callResult;
        }
        IDEHelper iMajorDEHelper = this.globalHelperEx.getDAModelStorage().FindDEHelper(deTrigger.getDEID());
        if (iMajorDEHelper == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u4e3b\u5b9e\u4f53[%1$s]\u8f85\u52a9\u5bf9\u8c61", (Object)deTrigger.getDEID()));
            return callResult;
        }
        IDBModelHelper iDBModelHelper = DBUtility.GetDBModelHelper(iMajorDEHelper.getDataEntity(), this.globalHelperEx);
        if (StringHelper.Compare((String)iDBModelHelper.GetDBType(), (String)triggerCode.getDBTYPE(), (boolean)true) == 0) {
            callResult = iDBModelHelper.DropTrigger(deTrigger);
        }
        return callResult;
    }
}

