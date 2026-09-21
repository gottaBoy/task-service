/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.PF;

import SA.SRFDA.PS.Core.PF.IPSPF;
import SA.SRFDA.PS.Core.PF.IPSPF2;
import SA.SRFDA.PS.Core.PF.IPSPFObject;
import SA.SRFDA.PS.Core.PSObjectImpl;

public abstract class PSPFObjectImpl
extends PSObjectImpl
implements IPSPFObject {
    protected IPSPF iPSPF = null;

    @Override
    public IPSPF getPSPF() {
        return this.iPSPF;
    }

    protected void setPSPF(IPSPF iPSPF) {
        this.iPSPF = iPSPF;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.getPSPF().getPSSysModelInstId();
    }

    public IPSPF2 getPSPF2() {
        if (this.getPSPF() instanceof IPSPF2) {
            return (IPSPF2)this.getPSPF();
        }
        return null;
    }
}

