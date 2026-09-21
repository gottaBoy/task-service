/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.Pub;

import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.Pub.IPSGenerateCodeResult;
import SA.SRFDA.PS.Core.Pub.IPSPublisherContext;
import SA.SRFDA.PS.Core.Pub.IPSSFCodePublisher;
import SA.SRFDA.PS.Core.Pub.IPSSFLogicCodePublisher;
import SA.SRFDA.PS.Core.SF.IPSSFLogicTemplDetail;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Map;

@PSModelIgnoreMeta
public interface IPSSFLogicPartCodePublisher
extends IPSSFCodePublisher {
    public void init(ISRFDAGlobalHelper var1, IPSSFLogicTemplDetail var2) throws Exception;

    public IPSGenerateCodeResult generateCode(IPSPublisherContext var1, Object var2, Object var3) throws Exception;

    public IPSGenerateCodeResult generateCode(IPSPublisherContext var1, Object var2, Object var3, Map<String, Object> var4) throws Exception;

    public IPSGenerateCodeResult generateCode(IPSPublisherContext var1, IPSSFLogicCodePublisher var2, Object var3, Object var4, Map<String, Object> var5) throws Exception;
}

