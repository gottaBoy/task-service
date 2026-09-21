/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 */
package SA.SRFDA.PS.Core.Service;

import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PSGlobalModelBase;
import SA.SRFDA.PS.Core.Service.IPSSubSysServiceAPI;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;

public abstract class PSSubSysServiceAPIGlobalModelBase<KT, VT, HT>
extends PSGlobalModelBase<KT, VT, HT> {
    protected IPSSubSysServiceAPI iPSSubSysServiceAPI = null;

    public CallResult Init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSubSysServiceAPI iPSSubSysServiceAPI) {
        this.iPSSubSysServiceAPI = iPSSubSysServiceAPI;
        return super.Init(iDAGlobalHelper);
    }

    protected IPSSubSysServiceAPI getPSSubSysServiceAPI() {
        return this.iPSSubSysServiceAPI;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.getPSSubSysServiceAPI().getPSSysModelInstId();
    }

    protected IPSSystemUtil getPSSystemUtil() {
        return (IPSSystemUtil)((Object)this.getPSSubSysServiceAPI().getPSSystem());
    }
}

