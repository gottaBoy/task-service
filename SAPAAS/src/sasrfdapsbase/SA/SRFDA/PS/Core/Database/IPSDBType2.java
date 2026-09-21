/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 */
package SA.SRFDA.PS.Core.Database;

import SA.SRFDA.PS.Core.Database.IPSDBType;
import SA.SRFDA.PS.Core.Database.IPSDatabase;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import java.util.Vector;

@PSModelIgnoreMeta
public interface IPSDBType2
extends IPSDBType {
    public CallResult clearLocks(IPSDatabase var1, int var2) throws Exception;

    public CallResult getDBUsedSize(IPSDatabase var1, BaseDataEntity var2) throws Exception;

    public CallResult getTableSummaries(IPSDatabase var1, Vector<BaseDataEntity> var2) throws Exception;
}

