/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.SF;

import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.SF.IPSSF;
import SA.SRFDA.PS.Core.SF.IPSSFObject;
import SA.SRFDA.PS.Core.SF.IPSSFPkg;
import SA.SRFDA.PS.Data.PSSFPkgVer;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

@PSModelIgnoreMeta
public interface IPSSFPkgVer
extends IPSSFObject {
    public void init(ISRFDAGlobalHelper var1, IPSSF var2, PSSFPkgVer var3) throws Exception;

    public IPSSFPkg getPSSFPkg();

    public String getVerTag();

    public String getVerTag2();

    public String getVerParam();
}

