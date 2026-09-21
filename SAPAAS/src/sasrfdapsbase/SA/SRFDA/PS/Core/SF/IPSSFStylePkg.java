/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.SF;

import SA.SRFDA.PS.Core.SF.IPSSFObject;
import SA.SRFDA.PS.Core.SF.IPSSFPkgVer;
import SA.SRFDA.PS.Core.SF.IPSSFStyle;
import SA.SRFDA.PS.Data.PSSFStylePkg;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

public interface IPSSFStylePkg
extends IPSSFObject {
    public void init(ISRFDAGlobalHelper var1, IPSSFStyle var2, PSSFStylePkg var3) throws Exception;

    public IPSSFPkgVer getPSSFPkgVer();

    public int getOrderValue();
}

