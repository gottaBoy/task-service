/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.Pub;

import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.PF.IPSPFCtrlTempl;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.Pub.IPSGenerateCodeResult;
import SA.SRFDA.PS.Core.Pub.IPSPFCodePublisher;
import SA.SRFDA.PS.Core.Pub.IPSPublisherContext;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Map;

@PSModelIgnoreMeta
public interface IPSPFCtrlCodePublisher
extends IPSPFCodePublisher {
    public void init(ISRFDAGlobalHelper var1, IPSPFCtrlTempl var2) throws Exception;

    public IPSGenerateCodeResult generateCode(IPSPublisherContext var1, IPSControl var2) throws Exception;

    public IPSGenerateCodeResult generateCode(IPSPublisherContext var1, IPSControl var2, Map<String, Object> var3) throws Exception;

    public String getCodePart(String var1, Object var2) throws Exception;

    public boolean hasCodePart(String var1) throws Exception;
}

