/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.SF;

import SA.SRFDA.PS.Core.SF.IPSSFCodeType;
import SA.SRFDA.PS.Core.SF.IPSSFObject;
import SA.SRFDA.PS.Core.SF.IPSSFStyleVer;
import SA.SRFDA.PS.Core.SF.IPSSFVerCodeItem;
import SA.SRFDA.PS.Data.PSSFVerCode;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Iterator;

public interface IPSSFVerCode
extends IPSSFObject,
IPSSFCodeType {
    public void init(ISRFDAGlobalHelper var1, IPSSFStyleVer var2, PSSFVerCode var3) throws Exception;

    public IPSSFStyleVer getPSSFStyleVer();

    public IPSSFCodeType getPSSFCodeType();

    public IPSSFVerCodeItem getPSSFVerCodeItem(String var1) throws Exception;

    public void resetPSSFVerCodeItem(String var1) throws Exception;

    public Iterator<IPSSFVerCodeItem> getPSSFVerCodeItems() throws Exception;
}

