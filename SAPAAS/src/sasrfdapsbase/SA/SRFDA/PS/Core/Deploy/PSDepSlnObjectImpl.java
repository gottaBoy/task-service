/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Deploy;

import SA.SRFDA.PS.Core.Deploy.IPSDepSln;
import SA.SRFDA.PS.Core.Deploy.IPSDepSlnObject;
import SA.SRFDA.PS.Core.PSObjectImpl;

public abstract class PSDepSlnObjectImpl
extends PSObjectImpl
implements IPSDepSlnObject {
    protected IPSDepSln iPSDepSln = null;

    @Override
    public IPSDepSln getPSDepSln() {
        return this.iPSDepSln;
    }

    protected void setPSDepSln(IPSDepSln iPSDepSln) {
        this.iPSDepSln = iPSDepSln;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.getPSDepSln().getPSSysModelInstId();
    }
}

