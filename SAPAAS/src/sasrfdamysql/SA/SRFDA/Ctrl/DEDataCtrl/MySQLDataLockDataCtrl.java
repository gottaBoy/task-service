/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.BaseDEDataCtrl
 *  SA.SRFDA.Ctrl.DEDataCtrl.DataLockDataCtrl
 *  SA.SRFDA.Ctrl.Data.DataLock
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Data.CallParam
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.Ctrl.DEDataCtrl;

import SA.SRFDA.Ctrl.BaseDEDataCtrl;
import SA.SRFDA.Ctrl.DEDataCtrl.DataLockDataCtrl;
import SA.SRFDA.Ctrl.Data.DataLock;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Data.CallParam;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class MySQLDataLockDataCtrl
extends DataLockDataCtrl {
    private static final Log log = LogFactory.getLog(DataLockDataCtrl.class);

    public CallResult AddDataLock(DataLock dataLock) {
        return this.CustomSaveCall("ADD", (BaseDataEntity)dataLock);
    }

    public CallResult GetDataLock(DataLock dataLock) {
        String strSQL = "SELECT * FROM T_SRFDATALOCK WHERE UPPER(OBJECTTYPE)=? AND UPPER(OBJECTID)=? AND (EXPIRETIME IS NULL OR EXPIRETIME> FU_SRFCURTIME())";
        Vector<CallParam> callParams = new Vector<CallParam>();
        callParams.add(new CallParam((Object)dataLock.getOBJECTTYPE().toUpperCase()));
        callParams.add(new CallParam((Object)dataLock.getOBJECTID().toUpperCase()));
        return BaseDEDataCtrl.SelectSingle((ISRFDAGlobalHelper)this.globalHelperEx, (String)strSQL, callParams, (BaseDataEntity)dataLock);
    }

    public CallResult RemoveDataLock(DataLock dataLock) {
        String strSQL = "DELETE FROM T_SRFDATALOCK WHERE UPPER(OBJECTTYPE)=? AND UPPER(OBJECTID)=? AND UPPER(KEY)=?";
        Vector<CallParam> callParams = new Vector<CallParam>();
        callParams.add(new CallParam((Object)dataLock.getOBJECTTYPE().toUpperCase()));
        callParams.add(new CallParam((Object)dataLock.getOBJECTID().toUpperCase()));
        callParams.add(new CallParam((Object)dataLock.getKEY().toUpperCase()));
        return MySQLDataLockDataCtrl.ExecuteWithoutResult((ISRFDAGlobalHelper)this.globalHelperEx, (String)strSQL, callParams);
    }

    public CallResult RemoveDataLockWithoutKey(DataLock dataLock) {
        String strSQL = "DELETE FROM T_SRFDATALOCK WHERE UPPER(OBJECTTYPE)=? AND UPPER(OBJECTID)=? ";
        Vector<CallParam> callParams = new Vector<CallParam>();
        callParams.add(new CallParam((Object)dataLock.getOBJECTTYPE().toUpperCase()));
        callParams.add(new CallParam((Object)dataLock.getOBJECTID().toUpperCase()));
        return MySQLDataLockDataCtrl.ExecuteWithoutResult((ISRFDAGlobalHelper)this.globalHelperEx, (String)strSQL, callParams);
    }
}

