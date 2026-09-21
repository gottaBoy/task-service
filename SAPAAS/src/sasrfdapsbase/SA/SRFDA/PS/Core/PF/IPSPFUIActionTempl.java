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
import SA.SRFDA.PS.Core.Pub.IPSPFUIActionCodePublisher;
import SA.SRFDA.PS.Data.PSPFUIActionTempl;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

public interface IPSPFUIActionTempl
extends IPSPFStyleObject {
    public void init(ISRFDAGlobalHelper var1, IPSPF var2, IPSPFStyle var3, PSPFUIActionTempl var4) throws Exception;

    public IPSPFPubCode getPSPFPubCode() throws Exception;

    public IPSPFUIActionCodePublisher getPSPFUIActionCodePublisher() throws Exception;

    public void releasePSPFUIActionCodePublisher(IPSPFUIActionCodePublisher var1);

    public void resetPSPFUIActionCodePublishers();

    public PSPFUIActionTempl getPSPFUIActionTemplData();

    public String getTemplDocUrl();
}

