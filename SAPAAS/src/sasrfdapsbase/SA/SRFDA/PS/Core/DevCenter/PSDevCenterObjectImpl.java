/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.DevCenter;

import SA.SRFDA.PS.Core.DevCenter.IPSDevCenter;
import SA.SRFDA.PS.Core.DevCenter.IPSDevCenterObject;
import SA.SRFDA.PS.Core.PSObjectImpl;

public abstract class PSDevCenterObjectImpl
extends PSObjectImpl
implements IPSDevCenterObject {
    private IPSDevCenter iPSDevCenter = null;

    @Override
    public IPSDevCenter getPSDevCenter() {
        return this.iPSDevCenter;
    }

    protected void setPSDevCenter(IPSDevCenter iPSDevCenter) {
        this.iPSDevCenter = iPSDevCenter;
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }
}

