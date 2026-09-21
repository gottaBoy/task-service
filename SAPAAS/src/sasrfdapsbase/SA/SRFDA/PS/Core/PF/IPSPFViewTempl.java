/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.PF;

import SA.SRFDA.PS.Core.PF.IPSPF;
import SA.SRFDA.PS.Core.PF.IPSPFObject;
import SA.SRFDA.PS.Core.PF.IPSPFPubCode;
import SA.SRFDA.PS.Core.PF.IPSPFStyle;
import SA.SRFDA.PS.Core.Pub.IPSPFViewCodePublisher;
import SA.SRFDA.PS.Data.PSPFViewTempl;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

public interface IPSPFViewTempl
extends IPSPFObject {
    public void init(ISRFDAGlobalHelper var1, IPSPF var2, IPSPFStyle var3, PSPFViewTempl var4) throws Exception;

    public PSPFViewTempl getPSPFViewTemplData();

    public IPSPFPubCode getPSPFPubCode() throws Exception;

    public IPSPFViewCodePublisher getPSPFViewCodePublisher() throws Exception;

    public void releasePSPFViewCodePublisher(IPSPFViewCodePublisher var1);

    public void resetPSPFViewCodePublishers();

    public IPSPFStyle getPSPFStyle();

    public String getTemplDocUrl();
}

