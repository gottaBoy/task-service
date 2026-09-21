/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.SF;

import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.SF.IPSSFHelpTempl;
import SA.SRFDA.PS.Core.SF.IPSSFHelpTemplDetail;
import SA.SRFDA.PS.Core.SF.IPSSFPubCode2;
import SA.SRFDA.PS.Data.PSSFHelpTempl;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

@PSModelIgnoreMeta
public interface IPSSFHelpTempl2
extends IPSSFHelpTempl {
    public void init(ISRFDAGlobalHelper var1, IPSSFPubCode2 var2, PSSFHelpTempl var3) throws Exception;

    public String getTemplFilePath();

    public IPSSFHelpTemplDetail getPSSFHelpTemplDetail(String var1) throws Exception;

    public IPSSFHelpTemplDetail getPSSFHelpTemplDetail(String var1, boolean var2) throws Exception;

    public IPSSFHelpTemplDetail getPSSFHelpTemplDetail2(String var1) throws Exception;

    public IPSSFHelpTemplDetail getPSSFHelpTemplDetail2(String var1, boolean var2) throws Exception;
}

