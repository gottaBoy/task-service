/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.PF;

import SA.SRFDA.PS.Core.PF.IPSPFObject;
import SA.SRFDA.PS.Core.PF.IPSPFPkgVer;
import SA.SRFDA.PS.Core.PF.IPSPFStyle;
import SA.SRFDA.PS.Data.PSPFStylePkg;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

public interface IPSPFStylePkg
extends IPSPFObject {
    public void init(ISRFDAGlobalHelper var1, IPSPFStyle var2, PSPFStylePkg var3) throws Exception;

    public IPSPFPkgVer getPSPFPkgVer();
}

