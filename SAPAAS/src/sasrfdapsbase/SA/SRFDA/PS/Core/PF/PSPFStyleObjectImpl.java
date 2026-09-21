/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.PF;

import SA.SRFDA.PS.Core.PF.IPSPFStyle;
import SA.SRFDA.PS.Core.PF.PSPFObjectImpl;

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

