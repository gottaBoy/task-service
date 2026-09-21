/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.SF;

import SA.SRFDA.PS.Core.SF.IPSSF;
import SA.SRFDA.PS.Core.SF.IPSSFObject;
import SA.SRFDA.PS.Data.PSSFACHandler;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

public interface IPSSFACHandler
extends IPSSFObject {
    public void init(ISRFDAGlobalHelper var1, IPSSF var2, PSSFACHandler var3) throws Exception;

    public String getHandlerObj();

    public String getHandlerObj2();

    public String getHandlerObj3();

    public String getHandlerObj4();
}

