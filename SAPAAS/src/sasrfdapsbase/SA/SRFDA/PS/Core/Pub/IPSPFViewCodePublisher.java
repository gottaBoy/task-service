/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.Pub;

import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.PF.IPSPFViewTempl;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.Pub.IPSPFCodePublisher;
import SA.SRFDA.PS.Core.Pub.IPSPublisherContext;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Map;

@PSModelIgnoreMeta
public interface IPSPFViewCodePublisher
extends IPSPFCodePublisher {
    public void init(ISRFDAGlobalHelper var1, IPSPFViewTempl var2) throws Exception;

    public void generateCode(IPSPublisherContext var1, IPSAppView var2) throws Exception;

    public String generateCode2(IPSPublisherContext var1, IPSAppView var2, Map<String, Object> var3) throws Exception;
}

