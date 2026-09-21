/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.SF;

import SA.SRFDA.PS.Core.SF.IPSSFCodeTempl;
import SA.SRFDA.PS.Core.SF.IPSSFObject;
import SA.SRFDA.PS.Core.SF.IPSSFVerCode;
import SA.SRFDA.PS.Data.PSSFVerCodeItem;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

public interface IPSSFVerCodeItem
extends IPSSFObject,
IPSSFCodeTempl {
    public void init(ISRFDAGlobalHelper var1, IPSSFVerCode var2, PSSFVerCodeItem var3) throws Exception;

    public IPSSFVerCode getPSSFVerCode();
}

