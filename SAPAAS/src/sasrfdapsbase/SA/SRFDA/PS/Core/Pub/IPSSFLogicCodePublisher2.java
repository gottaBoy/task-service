/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Pub;

import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.Pub.IPSGenerateCodeResult;
import SA.SRFDA.PS.Core.Pub.IPSPublisherContext;
import SA.SRFDA.PS.Core.Pub.IPSSFLogicCodePublisher;
import java.util.Map;

@PSModelIgnoreMeta
public interface IPSSFLogicCodePublisher2
extends IPSSFLogicCodePublisher {
    public IPSGenerateCodeResult generateCode(IPSPublisherContext var1, Object var2, Map<String, Object> var3) throws Exception;
}

