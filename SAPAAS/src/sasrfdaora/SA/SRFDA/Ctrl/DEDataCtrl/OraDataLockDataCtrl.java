/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.BaseDEDataCtrl
 *  SA.SRFDA.Ctrl.DEDataCtrl.DataLockDataCtrl
 *  SA.SRFDA.Ctrl.Data.DataLock
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.Ctrl.DEDataCtrl;

import SA.SRFDA.Ctrl.BaseDEDataCtrl;
import SA.SRFDA.Ctrl.DEDataCtrl.DataLockDataCtrl;
import SA.SRFDA.Ctrl.Data.DataLock;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class OraDataLockDataCtrl
extends DataLockDataCtrl {
    private static final Log log = LogFactory.getLog(DataLockDataCtrl.class);

    public CallResult AddDataLock(DataLock dataLock) {
        return this.CustomSaveCall("ADD", (BaseDataEntity)dataLock);
    }

    public CallResult GetDataLock(DataLock dataLock) {
        String strSQL = StringHelper.Format((String)"SELECT * FROM T_SRFDATALOCK WHERE OBJECTTYPE='%1$s' AND OBJECTID='%2$s' AND (EXPIRETIME IS NULL OR EXPIRETIME> FU_SRFCURTIME())", (Object)dataLock.getOBJECTTYPE(), (Object)dataLock.getOBJECTID());
        return BaseDEDataCtrl.SelectSingle((ISRFDAGlobalHelper)this.globalHelperEx, (String)strSQL, null, (BaseDataEntity)dataLock);
    }

    public CallResult RemoveDataLock(DataLock dataLock) {
        String strSQL = StringHelper.Format((String)"DELETE FROM T_SRFDATALOCK WHERE OBJECTTYPE='%1$s' AND OBJECTID='%2$s' AND KEY='%3$s'", (Object)dataLock.getOBJECTTYPE(), (Object)dataLock.getOBJECTID(), (Object)dataLock.getKEY());
        return OraDataLockDataCtrl.ExecuteWithoutResult((ISRFDAGlobalHelper)this.globalHelperEx, (String)strSQL, null);
    }

    public CallResult RemoveDataLockWithoutKey(DataLock dataLock) {
        String strSQL = StringHelper.Format((String)"DELETE FROM T_SRFDATALOCK WHERE  OBJECTTYPE='%1$s' AND OBJECTID='%2$s'", (Object)dataLock.getOBJECTTYPE(), (Object)dataLock.getOBJECTID());
        return OraDataLockDataCtrl.ExecuteWithoutResult((ISRFDAGlobalHelper)this.globalHelperEx, (String)strSQL, null);
    }
}

