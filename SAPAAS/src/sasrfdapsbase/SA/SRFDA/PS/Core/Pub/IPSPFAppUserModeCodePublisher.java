/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Pub;

import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.App.UserMode.IPSAppUserMode;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.Pub.IPSPFAppCodePublisher;
import SA.SRFDA.PS.Core.Pub.IPSPublisherContext;

@PSModelIgnoreMeta
public interface IPSPFAppUserModeCodePublisher
extends IPSPFAppCodePublisher {
    public void generateCode(IPSPublisherContext var1, IPSApplication var2, IPSAppUserMode var3) throws Exception;
}

