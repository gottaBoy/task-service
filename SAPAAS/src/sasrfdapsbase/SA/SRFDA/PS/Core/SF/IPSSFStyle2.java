/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.SF;

import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.SF.IPSSFHelpCodeObject;
import SA.SRFDA.PS.Core.SF.IPSSFHelpTempl;
import SA.SRFDA.PS.Core.SF.IPSSFLogicCodeObject;
import SA.SRFDA.PS.Core.SF.IPSSFLogicTempl;
import SA.SRFDA.PS.Core.SF.IPSSFPubCode;
import SA.SRFDA.PS.Core.SF.IPSSFStyle;
import java.util.Iterator;

@PSModelIgnoreMeta
public interface IPSSFStyle2
extends IPSSFStyle {
    public static final String PATH_APPPRJ = "%APP_PRJ%";

    public String getRealLocalPath();

    public IPSSFPubCode getPSSFPubCode(String var1, String var2, boolean var3) throws Exception;

    public IPSSFLogicTempl getPSSFLogicTempl(IPSSFLogicCodeObject var1, IPSSFPubCode var2) throws Exception;

    public IPSSFHelpTempl getPSSFHelpTempl(IPSSFHelpCodeObject var1, IPSSFPubCode var2) throws Exception;

    public Iterator<? extends IPSSFLogicTempl> getPSSFLogicTempls();
}

