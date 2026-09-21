/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.SF;

import SA.SRFDA.PS.Core.SF.IPSSFObject;
import SA.SRFDA.PS.Core.SF.IPSSFStyle;
import SA.SRFDA.PS.Core.SF.IPSSFVerCode;
import SA.SRFDA.PS.Data.PSSFStyleVer;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Iterator;

public interface IPSSFStyleVer
extends IPSSFObject {
    public void init(ISRFDAGlobalHelper var1, IPSSFStyle var2, PSSFStyleVer var3) throws Exception;

    public IPSSFStyle getPSSFStyle();

    public Iterator<IPSSFVerCode> getPSSFVerCodes() throws Exception;

    public IPSSFVerCode getPSSFVerCode(String var1) throws Exception;

    public void resetPSSFVerCode(String var1) throws Exception;
}

