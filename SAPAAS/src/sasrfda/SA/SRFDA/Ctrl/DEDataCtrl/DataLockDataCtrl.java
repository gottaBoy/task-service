/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Data.CallParam
 *  SA.SRFramework.DataEx.CallResult
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.Ctrl.DEDataCtrl;

import SA.SRFDA.Ctrl.BaseDEDataCtrl;
import SA.SRFDA.Ctrl.Data.DataLock;
import SA.SRFramework.Data.CallParam;
import SA.SRFramework.DataEx.CallResult;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DataLockDataCtrl
extends BaseDEDataCtrl {
    private static final Log log = LogFactory.getLog(DataLockDataCtrl.class);

    public CallResult AddDataLock(DataLock dataLock) {
        return this.CustomSaveCall("ADD", dataLock);
    }

    public CallResult GetDataLock(DataLock dataLock) {
        String strSQL = "SELECT * FROM T_SRFDATALOCK WHERE UPPER(OBJECTTYPE)=? AND UPPER(OBJECTID)=? AND (EXPIRETIME IS NULL OR EXPIRETIME> FU_SRFCURTIME())";
        Vector<CallParam> callParams = new Vector<CallParam>();
        callParams.add(new CallParam((Object)dataLock.getOBJECTTYPE().toUpperCase()));
        callParams.add(new CallParam((Object)dataLock.getOBJECTID().toUpperCase()));
        return BaseDEDataCtrl.SelectSingle(this.globalHelperEx, strSQL, callParams, dataLock);
    }

    public CallResult RemoveDataLock(DataLock dataLock) {
        String strSQL = "DELETE FROM T_SRFDATALOCK WHERE UPPER(OBJECTTYPE)=? AND UPPER(OBJECTID)=? AND UPPER(KEY)=?";
        Vector<CallParam> callParams = new Vector<CallParam>();
        callParams.add(new CallParam((Object)dataLock.getOBJECTTYPE().toUpperCase()));
        callParams.add(new CallParam((Object)dataLock.getOBJECTID().toUpperCase()));
        callParams.add(new CallParam((Object)dataLock.getKEY().toUpperCase()));
        return DataLockDataCtrl.ExecuteWithoutResult(this.globalHelperEx, strSQL, callParams);
    }

    public CallResult RemoveDataLockWithoutKey(DataLock dataLock) {
        String strSQL = "DELETE FROM T_SRFDATALOCK WHERE UPPER(OBJECTTYPE)=? AND UPPER(OBJECTID)=? ";
        Vector<CallParam> callParams = new Vector<CallParam>();
        callParams.add(new CallParam((Object)dataLock.getOBJECTTYPE().toUpperCase()));
        callParams.add(new CallParam((Object)dataLock.getOBJECTID().toUpperCase()));
        return DataLockDataCtrl.ExecuteWithoutResult(this.globalHelperEx, strSQL, callParams);
    }
}

