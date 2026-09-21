/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Pub;

import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Core.Pub.IPSSFCodePublisher;

public abstract class PSSFCodePublisherImpl
extends PSObjectImpl
implements IPSSFCodePublisher {
    public static final String PARAMTYPE = "_PARAMTYPE_";

    @Override
    public void close() {
        this.onClose();
    }

    protected void onClose() {
    }
}

