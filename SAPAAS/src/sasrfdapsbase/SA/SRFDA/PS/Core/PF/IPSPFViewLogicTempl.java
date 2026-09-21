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
import SA.SRFDA.PS.Core.Pub.IPSPFViewLogicCodePublisher;
import SA.SRFDA.PS.Core.View.IPSViewLogicType;
import SA.SRFDA.PS.Data.PSPFViewLogicTempl;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

public interface IPSPFViewLogicTempl
extends IPSPFStyleObject {
    public void init(ISRFDAGlobalHelper var1, IPSPF var2, IPSPFStyle var3, PSPFViewLogicTempl var4) throws Exception;

    public IPSPFPubCode getPSPFPubCode() throws Exception;

    public IPSPFViewLogicCodePublisher getPSPFViewLogicCodePublisher() throws Exception;

    public void releasePSPFViewLogicCodePublisher(IPSPFViewLogicCodePublisher var1);

    public void resetPSPFViewLogicCodePublishers();

    public PSPFViewLogicTempl getPSPFViewLogicTemplData();

    public IPSViewLogicType getPSViewLogicType();

    public String getTemplDocUrl();
}

