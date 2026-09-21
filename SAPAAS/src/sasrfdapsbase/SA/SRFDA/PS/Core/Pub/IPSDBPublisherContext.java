/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Pub;

import SA.SRFDA.PS.Core.Database.IPSSystemDBConfig;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.Pub.IPSPublisherContext;

@PSModelIgnoreMeta
public interface IPSDBPublisherContext
extends IPSPublisherContext {
    public IPSSystemDBConfig getPSSystemDBConfig();
}

