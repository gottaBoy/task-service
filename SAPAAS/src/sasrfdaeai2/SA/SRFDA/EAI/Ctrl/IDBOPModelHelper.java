/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 */
package SA.SRFDA.EAI.Ctrl;

import SA.SRFDA.EAI.Data.DBOPDTMap;
import SA.SRFDA.EAI.Data.DBOPPKGParam;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import java.util.Vector;

public interface IDBOPModelHelper {
    public void Init(ISRFDAGlobalHelper var1) throws Exception;

    public CallResult GetDBOPDTMaps(String var1, Vector<DBOPDTMap> var2);

    public CallResult GetDBOPSysParams(String var1, Vector<DBOPPKGParam> var2);

    public CallResult GetDBOPPkgParams(String var1, Vector<DBOPPKGParam> var2);
}

