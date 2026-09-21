/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.EAI.Ctrl;

import SA.SRFDA.EAI.Data.DBOPDTMap;
import SA.SRFDA.EAI.Data.DBOPPKGParam;
import SA.SRFDA.EAI.Data.DBOPSetting;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Vector;

public interface IDBOPSetting {
    public void Init(ISRFDAGlobalHelper var1, DBOPSetting var2) throws Exception;

    public DBOPSetting getDBOPSetting();

    public DBOPDTMap FindDBDataType(String var1) throws Exception;

    public Vector<DBOPPKGParam> getSysProcParams();

    public Vector<DBOPPKGParam> getSysDeclareParams();

    public String getLogDetailBeginCode() throws Exception;

    public String getLogDetailEndCode() throws Exception;

    public String getInitCode();

    public String FindPkgParam(String var1);

    public String getLineComment();
}

