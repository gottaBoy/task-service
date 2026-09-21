/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.pub;

import net.ibizsys.model.IPSModelObjectRuntime;
import net.ibizsys.model.PSObjectImpl;
import net.ibizsys.model.pf.IPSPFPubCode;
import net.ibizsys.model.pub.IPSPFCodePublisher;

public abstract class PSPFCodePublisherImpl
extends PSObjectImpl
implements IPSPFCodePublisher {
    private IPSPFPubCode iPSPFPubCode = null;

    protected void setPSPFPubCode(IPSPFPubCode iPSPFPubCode) {
        this.iPSPFPubCode = iPSPFPubCode;
    }

    @Override
    public IPSPFPubCode getPSPFPubCode() {
        return this.iPSPFPubCode;
    }

    @Override
    public String getPSSysModelInstId() {
        return ((IPSModelObjectRuntime)((Object)this.getPSPFPubCode())).getPSSysModelInstId();
    }
}

