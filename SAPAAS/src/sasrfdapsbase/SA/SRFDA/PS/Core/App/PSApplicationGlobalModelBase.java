/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 */
package SA.SRFDA.PS.Core.App;

import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.App.IPSApplicationRuntime;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PSGlobalModelBase;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;

public abstract class PSApplicationGlobalModelBase<KT, VT, HT>
extends PSGlobalModelBase<KT, VT, HT> {
    protected IPSApplication iPSApplication = null;

    public CallResult Init(ISRFDAGlobalHelper iDAGlobalHelper, IPSApplication iPSApplication) {
        this.iPSApplication = iPSApplication;
        return super.Init(iDAGlobalHelper);
    }

    protected IPSApplication getPSApplication() {
        return this.iPSApplication;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.getPSApplication().getPSSysModelInstId();
    }

    protected IPSSystemUtil getPSSystemUtil() {
        return (IPSSystemUtil)((Object)this.getPSApplication().getPSSystem());
    }

    protected IPSApplicationRuntime getPSApplicationRuntime() {
        return (IPSApplicationRuntime)((Object)this.getPSApplication());
    }
}

