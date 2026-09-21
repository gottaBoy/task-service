/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.db.IProcParam
 */
package SA.SRFDA.PS.Core.Database;

import SA.SRFDA.PS.Core.Database.IPSDEDBProcCode;
import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Data.PSDBProcParam;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import net.ibizsys.paas.db.IProcParam;

@PSModelIgnoreMeta
public interface IPSDBProcParam
extends IPSObject,
IProcParam {
    public void init(ISRFDAGlobalHelper var1, IPSDEDBProcCode var2, PSDBProcParam var3) throws Exception;
}

