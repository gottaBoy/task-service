/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.PF;

import SA.SRFDA.PS.Core.PF.IPSPF;
import SA.SRFDA.PS.Core.PF.IPSPFObject;
import SA.SRFDA.PS.Core.PF.IPSPFPkg;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Data.PSPFPkgVer;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

@PSModelPFIgnoreMeta
@PSModelIgnoreMeta
public interface IPSPFPkgVer
extends IPSPFObject {
    public void init(ISRFDAGlobalHelper var1, IPSPF var2, PSPFPkgVer var3) throws Exception;

    public IPSPFPkg getPSPFPkg();

    public String getVerTag();

    public String getVerTag2();

    public String getVerParam();

    public String getVerParam2();

    public String getVerParam3();

    public String getVerParam4();

    public int getOrderValue();
}

