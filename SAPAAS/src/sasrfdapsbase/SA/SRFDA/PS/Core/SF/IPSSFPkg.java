/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.SF;

import SA.SRFDA.PS.Core.SF.IPSSF;
import SA.SRFDA.PS.Core.SF.IPSSFObject;
import SA.SRFDA.PS.Data.PSSFPkg;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

public interface IPSSFPkg
extends IPSSFObject {
    public void init(ISRFDAGlobalHelper var1, IPSSF var2, PSSFPkg var3) throws Exception;

    public String getTag();

    public String getTag2();
}

