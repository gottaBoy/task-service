/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.PF;

import SA.SRFDA.PS.Core.PF.IPSPFObject;
import SA.SRFDA.PS.Core.PF.IPSPFPubCode;
import SA.SRFDA.PS.Core.PF.IPSPFViewLogicTempl2;
import SA.SRFDA.PS.Core.Pub.IPSPFViewLogicPartCodePublisher;
import SA.SRFDA.PS.Data.PSPFViewLogicTemplDetail;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

public interface IPSPFViewLogicTemplDetail
extends IPSPFObject {
    public void init(ISRFDAGlobalHelper var1, IPSPFViewLogicTempl2 var2, PSPFViewLogicTemplDetail var3) throws Exception;

    public IPSPFViewLogicTempl2 getPSPFViewLogicTempl();

    public IPSPFPubCode getPSPFPubCode() throws Exception;

    public IPSPFViewLogicPartCodePublisher getPSPFViewLogicPartCodePublisher() throws Exception;

    public void releasePSPFViewLogicPartCodePublisher(IPSPFViewLogicPartCodePublisher var1);

    public void resetPSPFViewLogicPartCodePublishers();

    public PSPFViewLogicTemplDetail getPSPFViewLogicTemplDetailData();

    public IPSPFViewLogicPartCodePublisher createPSPFViewLogicPartCodePublisher() throws Exception;

    public String getTemplDesc();

    public String getLogicName();

    public String getTemplDocUrl();
}

