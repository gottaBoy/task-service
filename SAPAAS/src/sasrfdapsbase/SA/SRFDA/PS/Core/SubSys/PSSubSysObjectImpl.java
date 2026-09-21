/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.SubSys;

import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Core.SubSys.IPSSubSys;
import SA.SRFDA.PS.Core.SubSys.IPSSubSysObject;

public abstract class PSSubSysObjectImpl
extends PSObjectImpl
implements IPSSubSysObject {
    protected IPSSubSys iPSSubSys = null;

    @Override
    public IPSSubSys getPSSubSys() {
        return this.iPSSubSys;
    }

    protected void setPSSubSys(IPSSubSys iPSSubSys) {
        this.iPSSubSys = iPSSubSys;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.getPSSubSys().getPSSysModelInstId();
    }
}

