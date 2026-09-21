/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 */
package SA.SRFDA.PS.Core.SubSys;

import SA.SRFDA.PS.Core.PSGlobalModelBase;
import SA.SRFDA.PS.Core.SubSys.IPSSubApp;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;

public abstract class PSSubAppGlobalModelBase<KT, VT, HT>
extends PSGlobalModelBase<KT, VT, HT> {
    protected IPSSubApp iPSSubApp = null;

    public CallResult Init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSubApp iPSSubApp) {
        this.iPSSubApp = iPSSubApp;
        return this.Init(iDAGlobalHelper);
    }

    protected IPSSubApp getPSSubApp() {
        return this.iPSSubApp;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.getPSSubApp().getPSSysModelInstId();
    }
}

