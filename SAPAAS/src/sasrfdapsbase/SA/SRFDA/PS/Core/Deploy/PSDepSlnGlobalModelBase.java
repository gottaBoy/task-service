/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 */
package SA.SRFDA.PS.Core.Deploy;

import SA.SRFDA.PS.Core.Deploy.IPSDepSln;
import SA.SRFDA.PS.Core.PSGlobalModelBase;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;

public abstract class PSDepSlnGlobalModelBase<KT, VT, HT>
extends PSGlobalModelBase<KT, VT, HT> {
    protected IPSDepSln iPSDepSln = null;

    public CallResult Init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDepSln iPSDepSln) {
        this.iPSDepSln = iPSDepSln;
        return this.Init(iDAGlobalHelper);
    }

    protected IPSDepSln getPSDepSln() {
        return this.iPSDepSln;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.getPSDepSln().getPSSysModelInstId();
    }
}

