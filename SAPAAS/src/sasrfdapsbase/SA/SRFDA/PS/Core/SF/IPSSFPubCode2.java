/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.SF;

import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.SF.IPSSFCodeFolder2;
import SA.SRFDA.PS.Core.SF.IPSSFPubCode;
import SA.SRFDA.PS.Core.SF.IPSSFStyle2;
import SA.SRFDA.PS.Data.PSSFPubCode;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

@PSModelIgnoreMeta
public interface IPSSFPubCode2
extends IPSSFPubCode {
    public void init(ISRFDAGlobalHelper var1, IPSSFStyle2 var2, IPSSFCodeFolder2 var3, PSSFPubCode var4) throws Exception;

    public IPSSFStyle2 getPSSFStyle2();
}

