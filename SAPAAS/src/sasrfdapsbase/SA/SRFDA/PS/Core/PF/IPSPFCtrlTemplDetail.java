/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.PF;

import SA.SRFDA.PS.Core.PF.IPSPFCtrlTempl;
import SA.SRFDA.PS.Core.PF.IPSPFObject;
import SA.SRFDA.PS.Core.PF.IPSPFPubCode;
import SA.SRFDA.PS.Core.Pub.IPSPFCtrlPartCodePublisher;
import SA.SRFDA.PS.Data.PSPFCtrlTemplDetail;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

public interface IPSPFCtrlTemplDetail
extends IPSPFObject {
    public void init(ISRFDAGlobalHelper var1, IPSPFCtrlTempl var2, PSPFCtrlTemplDetail var3) throws Exception;

    public IPSPFCtrlTempl getPSPFCtrlTempl();

    public IPSPFPubCode getPSPFPubCode() throws Exception;

    public IPSPFCtrlPartCodePublisher getPSPFCtrlPartCodePublisher() throws Exception;

    public void releasePSPFCtrlPartCodePublisher(IPSPFCtrlPartCodePublisher var1);

    public void resetPSPFCtrlPartCodePublishers();

    public PSPFCtrlTemplDetail getPSPFCtrlTemplDetailData();

    public IPSPFCtrlPartCodePublisher createPSPFCtrlPartCodePublisher() throws Exception;

    public String getTemplDesc();

    public String getLogicName();

    public String getTemplDocUrl();
}

