/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 */
package SA.SRFDA.PS.Core.PF;

import SA.SRFDA.PS.Core.PF.IPSPF;
import SA.SRFDA.PS.Core.PSGlobalModelBase;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;

public abstract class PSPFGlobalModelBase<KT, VT, HT>
extends PSGlobalModelBase<KT, VT, HT> {
    protected IPSPF iPSPF = null;

    public CallResult Init(ISRFDAGlobalHelper iDAGlobalHelper, IPSPF iPSPF) {
        this.iPSPF = iPSPF;
        return super.Init(iDAGlobalHelper);
    }

    protected IPSPF getPSPF() {
        return this.iPSPF;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.getPSPF().getPSSysModelInstId();
    }
}

