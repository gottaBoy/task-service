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
import SA.SRFDA.PS.Core.SF.IPSSFLogicTempl;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

@PSModelIgnoreMeta
public interface IPSSFLogicCodePublisher
extends IPSSFCodePublisher {
    public void init(ISRFDAGlobalHelper var1, IPSSFLogicTempl var2) throws Exception;

    public IPSGenerateCodeResult generateCode(IPSPublisherContext var1, Object var2) throws Exception;
}

