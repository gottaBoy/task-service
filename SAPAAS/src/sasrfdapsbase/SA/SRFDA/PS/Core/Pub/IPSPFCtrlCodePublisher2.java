/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Pub;

import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.Pub.IPSPublisherContext;
import java.util.Map;

@PSModelIgnoreMeta
public interface IPSPFCtrlCodePublisher2 {
    public void generateCode2(IPSPublisherContext var1, IPSControl var2) throws Exception;

    public String generateCode2(IPSPublisherContext var1, IPSControl var2, Map<String, Object> var3) throws Exception;
}

