/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Pub;

import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.Pub.IPSPublisherContext;

@PSModelIgnoreMeta
public interface IPSCodePublisher {
    public static final String PARAM_P = "P";

    public IPSPublisherContext getContext();

    public void close();
}

