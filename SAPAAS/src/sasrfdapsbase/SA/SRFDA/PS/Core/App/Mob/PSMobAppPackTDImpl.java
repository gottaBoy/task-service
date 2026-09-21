/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.App.Mob;

import SA.SRFDA.PS.Core.App.Mob.IPSMobAppPack;
import SA.SRFDA.PS.Core.App.Mob.IPSMobAppPackTD;
import SA.SRFDA.PS.Core.Mob.IPSDCMobAppTestDevice;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Data.PSMobAppPackTD;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

@PSModelIgnoreMeta
public class PSMobAppPackTDImpl
extends PSObjectImpl
implements IPSMobAppPackTD {
    private IPSMobAppPack iPSMobAppPack = null;
    protected PSMobAppPackTD psMobAppPackTD = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSMobAppPack iPSMobAppPack, PSMobAppPackTD psMobAppPackTD) throws Exception {
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.iPSMobAppPack = iPSMobAppPack;
        this.psMobAppPackTD = psMobAppPackTD;
        this.setId(this.psMobAppPackTD.getPSMOBAPPPACKTDID());
        this.setName(this.psMobAppPackTD.getPSMOBAPPPACKTDNAME());
        this.setPSObjectData(psMobAppPackTD);
        this.onInit();
    }

    @Override
    public IPSDCMobAppTestDevice getPSDCMobAppTestDevice() {
        return null;
    }

    @Override
    public IPSMobAppPack getPSMobAppPack() {
        return this.iPSMobAppPack;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.iPSMobAppPack.getPSSysModelInstId();
    }
}

