/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Database;

import SA.SRFDA.PS.Core.Database.IPSDBCodePublisher;
import SA.SRFDA.PS.Core.Database.IPSDBType;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.PSObjectImpl;

@PSModelIgnoreMeta
public abstract class PSDBCodePublisherImpl
extends PSObjectImpl
implements IPSDBCodePublisher {
    private IPSDBType iPSDBType = null;

    protected void setPSDBType(IPSDBType iPSDBType) {
        this.iPSDBType = iPSDBType;
    }

    @Override
    public IPSDBType getPSDBType() {
        return this.iPSDBType;
    }

    @Override
    public void close() {
        this.onClose();
    }

    protected void onClose() {
    }
}

