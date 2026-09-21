/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.SF;

import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.SF.IPSSFCodeType;
import SA.SRFDA.PS.Core.SF.IPSSFStyle;
import SA.SRFDA.PS.Core.SF.IPSSFStylePrj;
import SA.SRFDA.PS.Data.PSSFCodeFolder;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Iterator;

public interface IPSSFCodeFolder
extends IPSObject {
    public void init(ISRFDAGlobalHelper var1, IPSSFStyle var2, PSSFCodeFolder var3) throws Exception;

    public IPSSFStyle getPSSFStyle();

    public String getFolderCode();

    public Iterator<IPSSFCodeType> getPSSFCodeTypes() throws Exception;

    public String getHeaderCode();

    public String getBottomCode();

    public IPSSFCodeType getPSSFCodeType(String var1) throws Exception;

    public IPSSFCodeType getPSSFCodeType(String var1, boolean var2) throws Exception;

    public void resetPSSFCodeType(String var1) throws Exception;

    public int getModelLevel();

    public IPSSFStylePrj getPSSFStylePrj();

    public String getPrjFolder();
}

