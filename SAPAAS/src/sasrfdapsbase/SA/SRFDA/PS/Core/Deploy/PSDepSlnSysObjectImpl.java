/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Deploy;

import SA.SRFDA.PS.Core.Deploy.IPSDepSlnSys;
import SA.SRFDA.PS.Core.Deploy.IPSDepSlnSysObject;
import SA.SRFDA.PS.Core.Deploy.PSDepSlnObjectImpl;

public abstract class PSDepSlnSysObjectImpl
extends PSDepSlnObjectImpl
implements IPSDepSlnSysObject {
    protected IPSDepSlnSys iPSDepSlnSys = null;

    @Override
    public IPSDepSlnSys getPSDepSlnSys() {
        return this.iPSDepSlnSys;
    }

    protected void setPSDepSlnSys(IPSDepSlnSys iPSDepSlnSys) {
        this.iPSDepSlnSys = iPSDepSlnSys;
    }
}

