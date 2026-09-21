/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.Ctrl.DEDataCtrl;

import SA.SRFDA.Ctrl.BaseDEDataCtrl;
import SA.SRFDA.Ctrl.DBUtility;
import SA.SRFDA.Ctrl.Data.DBIndex;
import SA.SRFDA.Ctrl.IDBModelHelper;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DBIndexDataCtrl
extends BaseDEDataCtrl {
    private static final Log log = LogFactory.getLog(DBIndexDataCtrl.class);

    @Override
    protected CallResult OnAfterSaveOK(boolean bInsert, String strActionMode, BaseDataEntity dataEntity, BaseDataEntity lastDataEntity) {
        CallResult callResult = super.OnAfterSaveOK(bInsert, strActionMode, dataEntity, lastDataEntity);
        if (callResult.IsError()) {
            return callResult;
        }
        if (bInsert || lastDataEntity == null || dataEntity.GetParamIntValue("VERSION", 0) != lastDataEntity.GetParamIntValue("VERSION", 0)) {
            String strDEId = dataEntity.GetParamStringValue("DEID", "");
            IDEHelper dstDEHelper = this.getGlobalHelper().getDAModelStorage().FindDEHelper(strDEId);
            if (dstDEHelper == null) {
                callResult.setRetCode(1);
                callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u8f85\u52a9\u5bf9\u8c61", (Object)strDEId));
                log.error((Object)callResult.getErrorInfo());
                return callResult;
            }
            IDBModelHelper iDBModelHelper = DBUtility.GetDBModelHelper(dstDEHelper.getDataEntity(), this.globalHelperEx);
            if (iDBModelHelper == null) {
                callResult.setRetCode(1);
                callResult.setErrorInfo(StringHelper.Format((String)"\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u5e93\u6a21\u578b\u8f85\u52a9\u5bf9\u8c61\u5931\u8d25", (Object)strDEId));
                log.error((Object)callResult.getErrorInfo());
                return callResult;
            }
            DBIndex dbIndex = new DBIndex();
            dbIndex.Proxy(dataEntity);
            callResult = iDBModelHelper.AddIndex(dbIndex);
            if (callResult.IsError()) {
                log.error((Object)callResult.getErrorInfo());
                return callResult;
            }
        }
        return callResult;
    }

    @Override
    protected CallResult OnAfterRemoveOK(String strActionMode, BaseDataEntity dataEntity) {
        CallResult callResult = super.OnAfterRemoveOK(strActionMode, dataEntity);
        if (callResult.IsError()) {
            return callResult;
        }
        String strDEId = dataEntity.GetParamStringValue("DEID", "");
        IDEHelper dstDEHelper = this.getGlobalHelper().getDAModelStorage().FindDEHelper(strDEId);
        if (dstDEHelper == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u8f85\u52a9\u5bf9\u8c61", (Object)strDEId));
            log.error((Object)callResult.getErrorInfo());
            return callResult;
        }
        IDBModelHelper iDBModelHelper = DBUtility.GetDBModelHelper(dstDEHelper.getDataEntity(), this.globalHelperEx);
        if (iDBModelHelper == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u5e93\u6a21\u578b\u8f85\u52a9\u5bf9\u8c61\u5931\u8d25", (Object)strDEId));
            log.error((Object)callResult.getErrorInfo());
            return callResult;
        }
        DBIndex dbIndex = new DBIndex();
        dbIndex.Proxy(dataEntity);
        callResult = iDBModelHelper.DropIndex(dbIndex);
        if (callResult.IsError()) {
            log.error((Object)callResult.getErrorInfo());
            return callResult;
        }
        return callResult;
    }
}

