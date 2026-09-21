/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.PF;

import SA.SRFDA.PS.Core.PF.IPSPFPubCode2;
import SA.SRFDA.PS.Core.PF.IPSPFViewLogicTempl;
import SA.SRFDA.PS.Core.PF.IPSPFViewLogicTemplDetail;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Data.PSPFViewLogicTempl;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

@PSModelIgnoreMeta
public interface IPSPFViewLogicTempl2
extends IPSPFViewLogicTempl {
    public void init(ISRFDAGlobalHelper var1, IPSPFPubCode2 var2, PSPFViewLogicTempl var3) throws Exception;

    public String getTemplFilePath();

    public IPSPFViewLogicTemplDetail getPSPFViewLogicTemplDetail(String var1) throws Exception;

    public IPSPFViewLogicTemplDetail getPSPFViewLogicTemplDetail(String var1, boolean var2) throws Exception;

    public IPSPFViewLogicTemplDetail getPSPFViewLogicTemplDetail2(String var1) throws Exception;

    public IPSPFViewLogicTemplDetail getPSPFViewLogicTemplDetail2(String var1, boolean var2) throws Exception;
}

