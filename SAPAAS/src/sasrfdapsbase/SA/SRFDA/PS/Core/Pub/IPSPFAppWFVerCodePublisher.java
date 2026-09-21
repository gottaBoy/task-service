/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.Pub;

import SA.SRFDA.PS.Core.App.WF.IPSAppWFVer;
import SA.SRFDA.PS.Core.PF.IPSPFAppWFVerTempl;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.Pub.IPSPFCodePublisher;
import SA.SRFDA.PS.Core.Pub.IPSPublisherContext;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

@PSModelIgnoreMeta
public interface IPSPFAppWFVerCodePublisher
extends IPSPFCodePublisher {
    public void init(ISRFDAGlobalHelper var1, IPSPFAppWFVerTempl var2) throws Exception;

    public void generateCode(IPSPublisherContext var1, IPSAppWFVer var2) throws Exception;
}

