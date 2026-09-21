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
import SA.SRFDA.PS.Data.PSSFStyleParam;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

@PSModelIgnoreMeta
public interface IPSSFStyleParam
extends IPSSFObject {
    public void init(ISRFDAGlobalHelper var1, IPSSF var2, PSSFStyleParam var3) throws Exception;

    public String getStyleParam(String var1, String var2);

    public int getStyleParam(String var1, int var2);

    public boolean containsStyleParam(String var1);
}

