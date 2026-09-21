/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.SF;

import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.SF.IPSSFCodeType;
import SA.SRFDA.PS.Data.PSSFCodeTempl;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

public interface IPSSFCodeTempl
extends IPSObject {
    public void init(ISRFDAGlobalHelper var1, IPSSFCodeType var2, PSSFCodeTempl var3) throws Exception;

    public PSSFCodeTempl getPSSFCodeTemplData();

    public String getTemplDocUrl();

    public String getTemplDesc();

    public String getLogicName();
}

