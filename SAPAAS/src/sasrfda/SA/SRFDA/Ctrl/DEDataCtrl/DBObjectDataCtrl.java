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
import SA.SRFDA.Ctrl.Data.DBObject;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;

public class DBObjectDataCtrl
extends BaseDEDataCtrl {
    public static final String CUSTOMCALL_PUBLISH = "PUBLISH";

    @Override
    protected CallResult OnCustomCall(String strCallName, BaseDataEntity dataEntity) {
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_PUBLISH, (boolean)true) == 0) {
            return this.CustomCall_Publish(dataEntity);
        }
        return super.OnCustomCall(strCallName, dataEntity);
    }

    protected CallResult CustomCall_Publish(BaseDataEntity dataEntity) {
        CallResult callResult = new CallResult();
        DBObject dbObject = new DBObject();
        dbObject.Proxy(dataEntity);
        IDEHelper dstDEHelper = this.getGlobalHelper().getDAModelStorage().FindDEHelper(dbObject.getDEID());
        if (dstDEHelper == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u8f85\u52a9\u5bf9\u8c61", (Object)dbObject.getDEID()));
            return callResult;
        }
        return dstDEHelper.PrepareDBObject(dbObject.getDBOBJECTID());
    }
}

