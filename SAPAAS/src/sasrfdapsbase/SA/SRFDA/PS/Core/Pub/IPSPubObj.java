/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Pub;

import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.Pub.IPSCodePublisherParam;
import java.util.Map;

public interface IPSPubObj
extends IPSModelObject {
    public String getTarget();

    public void fillPublisherMacros(Map<String, String> var1);

    public void fillPublisherParams(IPSModelObject var1, Map<String, IPSCodePublisherParam> var2);
}

