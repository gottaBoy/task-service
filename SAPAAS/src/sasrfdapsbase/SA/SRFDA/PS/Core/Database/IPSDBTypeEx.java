/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Database;

import SA.SRFDA.PS.Core.Database.IPSDBType;
import SA.SRFDA.PS.Core.Database.IPSDEDBConfig;
import SA.SRFDA.PS.Core.Database.IPSDEFDTColumn;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Data.PSDEFDTColumn;

@PSModelIgnoreMeta
public interface IPSDBTypeEx
extends IPSDBType {
    public IPSDEFDTColumn createPSDEFDTColumnEx(PSDEFDTColumn var1, IPSDEDBConfig var2) throws Exception;
}

