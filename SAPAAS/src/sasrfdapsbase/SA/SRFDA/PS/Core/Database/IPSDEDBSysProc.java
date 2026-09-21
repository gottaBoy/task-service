/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.Database;

import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.Database.IPSDBSysProcType;
import SA.SRFDA.PS.Core.Database.IPSDEDBProc;
import SA.SRFDA.PS.Core.Database.IPSDEDBSysProcCode;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Data.PSDEDBSysProc;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

@PSModelIgnoreMeta
public interface IPSDEDBSysProc
extends IPSDEDBProc {
    public void init(ISRFDAGlobalHelper var1, IPSDataEntity var2, PSDEDBSysProc var3) throws Exception;

    public IPSDEDBSysProcCode getPSDEDBSysProcCode(String var1) throws Exception;

    public String getProcType();

    public IPSDBSysProcType getPSDBSysProcType();
}

