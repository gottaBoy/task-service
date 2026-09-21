/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.App.Mob;

import SA.SRFDA.PS.Core.App.Mob.IPSMobAppPack;
import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.Mob.IPSDCMobAppTestDevice;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Data.PSMobAppPackTD;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

@PSModelIgnoreMeta
public interface IPSMobAppPackTD
extends IPSObject {
    public void init(ISRFDAGlobalHelper var1, IPSMobAppPack var2, PSMobAppPackTD var3) throws Exception;

    public IPSDCMobAppTestDevice getPSDCMobAppTestDevice();

    public IPSMobAppPack getPSMobAppPack();
}

