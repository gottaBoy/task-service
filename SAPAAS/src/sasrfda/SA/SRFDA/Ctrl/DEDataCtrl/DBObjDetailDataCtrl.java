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
import SA.SRFDA.Ctrl.Data.DBObject;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DBObjDetailDataCtrl
extends BaseDEDataCtrl {
    private static final Log log = LogFactory.getLog(DBObjDetailDataCtrl.class);

    @Override
    protected CallResult OnAfterSaveOK(boolean bInsert, String strActionMode, BaseDataEntity dataEntity, BaseDataEntity lastDataEntity) {
        CallResult callResult = super.OnAfterSaveOK(bInsert, strActionMode, dataEntity, lastDataEntity);
        if (callResult.IsError()) {
            return callResult;
        }
        IDEDataCtrl dbObjectDataCtrl = this.getGlobalHelper().getDAModelStorage().FindDEDataCtrlEx("DE0169", this);
        if (dbObjectDataCtrl == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u65e0\u6cd5\u5b9e\u4f53[%1$s]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61", (Object)"DE0169"));
            return callResult;
        }
        DBObject dbObject = new DBObject();
        dbObject.setDBOBJECTID(dataEntity.GetParamStringValue("DBOBJECTID", ""));
        callResult = dbObjectDataCtrl.Get(dbObject);
        if (callResult.IsError()) {
            return callResult;
        }
        IDEHelper dstDEHelper = this.getGlobalHelper().getDAModelStorage().FindDEHelper(dbObject.getDEID());
        if (dstDEHelper == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u8f85\u52a9\u5bf9\u8c61", (Object)dbObject.getDEID()));
            log.error((Object)callResult.getErrorInfo());
            return callResult;
        }
        if (StringHelper.Compare((String)dstDEHelper.GetDBType(), (String)dataEntity.GetParamStringValue("DBTYPE", ""), (boolean)true) == 0) {
            if (this.getTransactionManager() != null) {
                this.getTransactionManager().CommitAndBegin();
            }
            callResult = dstDEHelper.PrepareDBObject(dbObject.getDBOBJECTID());
        }
        return callResult;
    }
}

