/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.Pub;

import SA.SRFDA.PS.Core.App.View.IPSAppViewLogic;
import SA.SRFDA.PS.Core.PF.IPSPFViewLogicTempl;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.Pub.IPSGenerateCodeResult;
import SA.SRFDA.PS.Core.Pub.IPSPFCodePublisher;
import SA.SRFDA.PS.Core.Pub.IPSPublisherContext;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

@PSModelIgnoreMeta
public interface IPSPFViewLogicCodePublisher
extends IPSPFCodePublisher {
    public void init(ISRFDAGlobalHelper var1, IPSPFViewLogicTempl var2) throws Exception;

    public IPSGenerateCodeResult generateCode(IPSPublisherContext var1, IPSAppViewLogic var2) throws Exception;
}

