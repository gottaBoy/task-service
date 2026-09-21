/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Pub;

import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Core.Pub.IPSDBCodePublisher;

@PSModelIgnoreMeta
public abstract class PSDBCodePublisherImpl
extends PSObjectImpl
implements IPSDBCodePublisher {
    @Override
    public void close() {
        this.onClose();
    }

    protected void onClose() {
    }
}

