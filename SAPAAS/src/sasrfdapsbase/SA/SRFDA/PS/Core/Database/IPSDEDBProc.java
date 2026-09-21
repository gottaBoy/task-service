/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Database;

import SA.SRFDA.PS.Core.DataEntity.IPSDataEntityObject;
import SA.SRFDA.PS.Core.Database.IPSDEDBProcCode;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;

@PSModelIgnoreMeta
public interface IPSDEDBProc
extends IPSDataEntityObject {
    public IPSDEDBProcCode getPSDEDBProcCode(String var1) throws Exception;
}

