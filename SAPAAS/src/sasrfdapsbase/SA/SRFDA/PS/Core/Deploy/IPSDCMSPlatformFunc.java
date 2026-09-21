/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.Deploy;

import SA.SRFDA.PS.Core.Deploy.IPSDCMSPlatform;
import SA.SRFDA.PS.Core.Deploy.IPSMSPlatformFunc;
import SA.SRFDA.PS.Data.PSDCMSPlatformFunc;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

public interface IPSDCMSPlatformFunc
extends IPSMSPlatformFunc {
    public void init(ISRFDAGlobalHelper var1, IPSDCMSPlatform var2, PSDCMSPlatformFunc var3) throws Exception;

    public IPSDCMSPlatform getPSDCMSPlatform();
}

