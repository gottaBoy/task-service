/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.PF;

import SA.SRFDA.PS.Core.Control.IPSControlType;
import SA.SRFDA.PS.Core.PF.IPSPF;
import SA.SRFDA.PS.Core.PF.IPSPFCtrlTemplDetail;
import SA.SRFDA.PS.Core.PF.IPSPFPubCode;
import SA.SRFDA.PS.Core.PF.IPSPFStyle;
import SA.SRFDA.PS.Core.PF.IPSPFStyleObject;
import SA.SRFDA.PS.Core.Pub.IPSPFCtrlCodePublisher;
import SA.SRFDA.PS.Data.PSPFCtrlTempl;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

public interface IPSPFCtrlTempl
extends IPSPFStyleObject {
    public void init(ISRFDAGlobalHelper var1, IPSPF var2, IPSPFStyle var3, PSPFCtrlTempl var4) throws Exception;

    public IPSPFPubCode getPSPFPubCode() throws Exception;

    public IPSPFCtrlCodePublisher getPSPFCtrlCodePublisher() throws Exception;

    public void releasePSPFCtrlCodePublisher(IPSPFCtrlCodePublisher var1);

    public void resetPSPFCtrlCodePublishers();

    public PSPFCtrlTempl getPSPFCtrlTemplData();

    public IPSPFCtrlTemplDetail getPSPFCtrlTemplDetail(String var1) throws Exception;

    public IPSPFCtrlTemplDetail getPSPFCtrlTemplDetail(String var1, boolean var2) throws Exception;

    public IPSPFCtrlTemplDetail getPSPFCtrlTemplDetail2(String var1) throws Exception;

    public IPSPFCtrlTemplDetail getPSPFCtrlTemplDetail2(String var1, boolean var2) throws Exception;

    public IPSControlType getPSControlType();

    public String getTemplDocUrl();
}

