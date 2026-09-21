/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.Res;

import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.IPSSystemObject;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import SA.SRFDA.PS.Core.System.IPSSystemModule;
import SA.SRFDA.PS.Data.PSSysUnit;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

public interface IPSSysUnit
extends IPSSystemObject {
    public void init(ISRFDAGlobalHelper var1, IPSSystem var2, PSSysUnit var3) throws Exception;

    public IPSLanguageRes getNamePSLanguageRes();

    public IPSSystemModule getPSSystemModule();

    @Override
    public String getCodeName();

    public String getUnitTag();

    public String getUnitTag2();
}

