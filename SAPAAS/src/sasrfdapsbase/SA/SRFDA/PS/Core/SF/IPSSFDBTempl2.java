/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.SF;

import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.SF.IPSSFDBTempl;
import SA.SRFDA.PS.Core.SF.IPSSFDBTemplDetail;
import SA.SRFDA.PS.Core.SF.IPSSFPubCode2;
import SA.SRFDA.PS.Data.PSSFDBTempl;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

@PSModelIgnoreMeta
public interface IPSSFDBTempl2
extends IPSSFDBTempl {
    public void init(ISRFDAGlobalHelper var1, IPSSFPubCode2 var2, PSSFDBTempl var3) throws Exception;

    public String getTemplFilePath();

    public IPSSFDBTemplDetail getPSSFDBTemplDetail(String var1) throws Exception;

    public IPSSFDBTemplDetail getPSSFDBTemplDetail(String var1, boolean var2) throws Exception;

    public IPSSFDBTemplDetail getPSSFDBTemplDetail2(String var1) throws Exception;

    public IPSSFDBTemplDetail getPSSFDBTemplDetail2(String var1, boolean var2) throws Exception;

    public boolean isCheckModelOnly();
}

