/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.Mob;

import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Data.PSDCMobAppTestDevice;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

@PSModelIgnoreMeta
public interface IPSDCMobAppTestDevice
extends IPSObject {
    public void init(ISRFDAGlobalHelper var1, PSDCMobAppTestDevice var2) throws Exception;

    public String getDeviceId();

    public String getOSType();

    public String getOSVersion();
}

