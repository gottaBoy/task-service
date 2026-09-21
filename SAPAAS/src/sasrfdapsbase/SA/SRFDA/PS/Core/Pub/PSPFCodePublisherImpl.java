/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Pub;

import SA.SRFDA.PS.Core.PF.IPSPFPubCode;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Core.Pub.IPSPFCodePublisher;

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
    public void close() {
        this.onClose();
    }

    protected void onClose() {
    }

    @Override
    public String getPSSysModelInstId() {
        return this.getPSPFPubCode().getPSSysModelInstId();
    }
}

