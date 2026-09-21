/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.Res;

import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.IPSSystemObject;
import SA.SRFDA.PS.Core.System.IPSSystemModule;
import SA.SRFDA.PS.Data.PSSysDictCat;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

public interface IPSSysDictCat
extends IPSSystemObject {
    public void init(ISRFDAGlobalHelper var1, IPSSystem var2, PSSysDictCat var3) throws Exception;

    public boolean isUserCat();

    @Override
    public String getCodeName();

    public String getDictCatTag();

    public String getDictCatTag2();

    public IPSSystemModule getPSSystemModule();

    public boolean isUserDictCat();
}

