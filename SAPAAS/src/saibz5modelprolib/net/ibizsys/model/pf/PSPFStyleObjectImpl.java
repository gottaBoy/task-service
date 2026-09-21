/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.model.pf;

import net.ibizsys.model.pf.IPSPFStyle;
import net.ibizsys.model.pf.PSPFObjectImpl;

public abstract class PSPFStyleObjectImpl
extends PSPFObjectImpl {
    protected IPSPFStyle iPSPFStyle = null;

    public IPSPFStyle getPSPFStyle() {
        return this.iPSPFStyle;
    }

    protected void setPSPFStyle(IPSPFStyle iPSPFStyle) {
        this.iPSPFStyle = iPSPFStyle;
        if (this.iPSPFStyle != null) {
            this.setPSPF(this.iPSPFStyle.getPSPF());
        }
    }
}

