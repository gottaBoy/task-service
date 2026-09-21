/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.pf;

import net.ibizsys.model.PSObjectImpl;
import net.ibizsys.model.pf.IPSPF;
import net.ibizsys.model.pf.IPSPFObject;
import net.ibizsys.model.pf.IPSPFRuntime;

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
        return ((IPSPFRuntime)this.getPSPF()).getPSSysModelInstId();
    }

    protected IPSPFRuntime getPSPFRuntime() {
        return (IPSPFRuntime)this.getPSPF();
    }
}

