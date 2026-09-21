/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.SF;

import SA.SRFDA.PS.Core.SF.IPSSF;
import SA.SRFDA.PS.Core.SF.IPSSFCodeFolder;
import SA.SRFDA.PS.Core.SF.IPSSFObject;
import SA.SRFDA.PS.Data.PSSFPubCode;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Iterator;

public interface IPSSFPubCode
extends IPSSFObject {
    public static final String TARGETTYPE_NONE = "NONE";

    public void init(ISRFDAGlobalHelper var1, IPSSF var2, IPSSFPubCode var3, PSSFPubCode var4) throws Exception;

    public String getTargetType();

    public String getPKGCodeName();

    public String getClassNameExt();

    public String getFileNameExt();

    public String getCodeFolder();

    public IPSSFCodeFolder getPSSFCodeFolder();

    public String getPreviewCode();

    public String getPluginTemplCode();

    public IPSSFPubCode getParentPSSFPubCode();

    public Iterator<IPSSFPubCode> getChildPSSFPubCodes();
}

