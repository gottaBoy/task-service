/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.PF;

import SA.SRFDA.PS.Core.PF.IPSPF;
import SA.SRFDA.PS.Core.PF.IPSPFPubCode;
import SA.SRFDA.PS.Core.PF.IPSPFStyle;
import SA.SRFDA.PS.Core.PF.IPSPFStyleObject;
import SA.SRFDA.PS.Core.Pub.IPSPFAppCodePublisher;
import SA.SRFDA.PS.Data.PSPFAppTempl;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

public interface IPSPFAppTempl
extends IPSPFStyleObject {
    public void init(ISRFDAGlobalHelper var1, IPSPF var2, IPSPFStyle var3, PSPFAppTempl var4) throws Exception;

    public PSPFAppTempl getPSPFAppTemplData();

    public IPSPFPubCode getPSPFPubCode() throws Exception;

    public IPSPFAppCodePublisher getPSPFAppCodePublisher() throws Exception;

    public void releasePSPFAppCodePublisher(IPSPFAppCodePublisher var1);

    public void resetPSPFAppCodePublishers();

    public String getTemplDocUrl();
}

