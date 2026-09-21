/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.pf;

import net.ibizsys.model.IPSModelObjectRuntime;
import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.PSGlobalModelBase;
import net.ibizsys.model.pf.IPSPF;
import net.ibizsys.model.pf.IPSPFStyle;

public abstract class PSPFStyleGlobalModelBase<KT, VT, HT>
extends PSGlobalModelBase<KT, VT, HT> {
    protected IPSPFStyle iPSPFStyle = null;

    public void init(IPSModelStorageContext iPSModelStorageContext, IPSPFStyle iPSPFStyle) throws Exception {
        this.iPSPFStyle = iPSPFStyle;
        super.init(iPSModelStorageContext);
    }

    protected IPSPFStyle getPSPFStyle() {
        return this.iPSPFStyle;
    }

    @Override
    public String getPSSysModelInstId() {
        return ((IPSModelObjectRuntime)((Object)this.getPSPFStyle())).getPSSysModelInstId();
    }

    protected IPSPF getPSPF() {
        return this.getPSPFStyle().getPSPF();
    }
}

