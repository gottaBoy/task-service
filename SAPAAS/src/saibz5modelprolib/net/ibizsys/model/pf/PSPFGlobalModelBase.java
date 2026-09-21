/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.pf;

import net.ibizsys.model.IPSModelObjectRuntime;
import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.PSGlobalModelBase;
import net.ibizsys.model.pf.IPSPF;

public abstract class PSPFGlobalModelBase<KT, VT, HT>
extends PSGlobalModelBase<KT, VT, HT> {
    protected IPSPF iPSPF = null;

    public void init(IPSModelStorageContext iPSModelStorageContext, IPSPF iPSPF) throws Exception {
        this.iPSPF = iPSPF;
        super.init(iPSModelStorageContext);
    }

    protected IPSPF getPSPF() {
        return this.iPSPF;
    }

    @Override
    public String getPSSysModelInstId() {
        return ((IPSModelObjectRuntime)((Object)this.getPSPF())).getPSSysModelInstId();
    }
}

