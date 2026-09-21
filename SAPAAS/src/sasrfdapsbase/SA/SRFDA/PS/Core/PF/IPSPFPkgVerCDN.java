/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.PF;

import SA.SRFDA.PS.Core.PF.IPSPF;
import SA.SRFDA.PS.Core.PF.IPSPFCDN;
import SA.SRFDA.PS.Core.PF.IPSPFPkgVer;
import SA.SRFDA.PS.Data.PSPFPkgVerCDN;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

public interface IPSPFPkgVerCDN
extends IPSPFPkgVer {
    public void init(ISRFDAGlobalHelper var1, IPSPF var2, PSPFPkgVerCDN var3) throws Exception;

    public IPSPFCDN getPSPFCDN();

    public IPSPFPkgVer getPSPFPkgVer();
}

