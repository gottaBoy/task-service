/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.PF;

import SA.SRFDA.PS.Core.PF.IPSPFCodeFolder2;
import SA.SRFDA.PS.Core.PF.IPSPFPubCode;
import SA.SRFDA.PS.Core.PF.IPSPFStyle2;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Data.PSPFPubCode;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

@PSModelIgnoreMeta
public interface IPSPFPubCode2
extends IPSPFPubCode {
    public void init(ISRFDAGlobalHelper var1, IPSPFStyle2 var2, IPSPFCodeFolder2 var3, PSPFPubCode var4) throws Exception;

    public IPSPFStyle2 getPSPFStyle2();

    public IPSPFPubCode getOriginPSPFPubCode();
}

