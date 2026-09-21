/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 */
package SA.SRFDA.PS.Core;

import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PSGlobalModelBase;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;

public abstract class PSSystemGlobalModelBase<KT, VT, HT>
extends PSGlobalModelBase<KT, VT, HT> {
    protected IPSSystem iPSSystem = null;

    public CallResult Init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSystem iPSSystem) {
        this.iPSSystem = iPSSystem;
        return this.Init(iDAGlobalHelper);
    }

    protected IPSSystem getPSSystem() {
        return this.iPSSystem;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.getPSSystem().getPSSysModelInstId();
    }

    protected IPSSystemUtil getPSSystemUtil() {
        return (IPSSystemUtil)((Object)this.getPSSystem());
    }
}

