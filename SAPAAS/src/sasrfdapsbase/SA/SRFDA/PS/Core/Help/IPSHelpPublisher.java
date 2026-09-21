/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Help;

import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.Pub.IPSPublisherContext;

@PSModelIgnoreMeta
public interface IPSHelpPublisher {
    public IPSPublisherContext getContext();

    public void close();
}

