/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Database;

import SA.SRFDA.PS.Core.Database.IPSDBProcParam;
import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import java.util.Iterator;

@PSModelIgnoreMeta
public interface IPSDEDBProcCode
extends IPSObject {
    public Iterator<IPSDBProcParam> getPSDBProcParams();
}

