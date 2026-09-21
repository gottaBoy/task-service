/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Pub;

import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.Pub.IPSCodePublisherParam;
import java.util.Map;

@PSModelIgnoreMeta
public interface IPSCodePublisherHelper {
    public void fillPublisherParams(IPSModelObject var1, Map<String, IPSCodePublisherParam> var2);
}

