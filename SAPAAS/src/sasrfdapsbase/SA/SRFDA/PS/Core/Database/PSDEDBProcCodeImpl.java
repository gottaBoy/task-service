/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Database;

import SA.SRFDA.PS.Core.Database.IPSDBProcParam;
import SA.SRFDA.PS.Core.Database.IPSDEDBProcCode;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.PSObjectImpl;
import java.util.ArrayList;
import java.util.Iterator;

@PSModelIgnoreMeta
public abstract class PSDEDBProcCodeImpl
extends PSObjectImpl
implements IPSDEDBProcCode {
    protected ArrayList<IPSDBProcParam> psDBProcParamList = new ArrayList();

    @Override
    public Iterator<IPSDBProcParam> getPSDBProcParams() {
        return this.psDBProcParamList.iterator();
    }
}

