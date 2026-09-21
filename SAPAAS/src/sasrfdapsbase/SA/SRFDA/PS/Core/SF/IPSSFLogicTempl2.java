/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.SF;

import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.SF.IPSSFLogicTempl;
import SA.SRFDA.PS.Core.SF.IPSSFLogicTemplDetail;
import SA.SRFDA.PS.Core.SF.IPSSFPubCode2;
import SA.SRFDA.PS.Data.PSSFLogicTempl;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

@PSModelIgnoreMeta
public interface IPSSFLogicTempl2
extends IPSSFLogicTempl {
    public void init(ISRFDAGlobalHelper var1, IPSSFPubCode2 var2, PSSFLogicTempl var3) throws Exception;

    public String getTemplFilePath();

    public IPSSFLogicTemplDetail getPSSFLogicTemplDetail(String var1) throws Exception;

    public IPSSFLogicTemplDetail getPSSFLogicTemplDetail(String var1, boolean var2) throws Exception;

    public IPSSFLogicTemplDetail getPSSFLogicTemplDetail2(String var1) throws Exception;

    public IPSSFLogicTemplDetail getPSSFLogicTemplDetail2(String var1, boolean var2) throws Exception;

    public boolean isCheckModelOnly();
}

