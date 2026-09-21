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
import SA.SRFDA.PS.Data.PSLanguageItem;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

public interface IPSLanguageItem
extends IPSSystemObject {
    public void init(ISRFDAGlobalHelper var1, IPSSystem var2, PSLanguageItem var3) throws Exception;

    public IPSLanguageRes getPSLanguageRes();

    public String getContent();

    public String getLanguage();

    public String getLanResTag();

    public IPSSystemModule getPSSystemModule();
}

