/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.Deploy;

import SA.SRFDA.PS.Core.Deploy.IPSDCMSPlatform;
import SA.SRFDA.PS.Core.Deploy.IPSMSPlatformNode;
import SA.SRFDA.PS.Data.PSDCMSPlatformNode;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

public interface IPSDCMSPlatformNode
extends IPSMSPlatformNode {
    public void init(ISRFDAGlobalHelper var1, IPSDCMSPlatform var2, PSDCMSPlatformNode var3) throws Exception;

    public IPSDCMSPlatform getPSDCMSPlatform();

    public String getPSDCRegistryItemId();
}

